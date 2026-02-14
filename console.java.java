// ----------------- MAIN CLASS -----------------
class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadData("bankdata.ser"); // Load saved users/accounts

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n---- WELCOME TO THE BANK ----");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    bank.registerUser(newUsername, newPassword);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User user = bank.login(username, password);
                    if (user != null) {
                        boolean userMenu = true;
                        while (userMenu) {
                            System.out.println("\n---- USER MENU ----");
                            System.out.println("1. Add Account");
                            System.out.println("2. List Accounts");
                            System.out.println("3. Deposit/Withdraw");
                            System.out.println("4. Logout");
                            System.out.print("Enter your choice: ");
                            int userChoice = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            switch (userChoice) {
                                case 1:
                                    System.out.print("Enter new account number: ");
                                    String accNum = scanner.nextLine();
                                    user.addAccount(accNum);
                                    break;
                                case 2:
                                    user.listAccounts();
                                    break;
                                case 3:
                                    user.interactWithAccount();
                                    break;
                                case 4:
                                    System.out.println("Logging out...");
                                    userMenu = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice! Try again.");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    bank.saveData("bankdata.ser"); // Save users/accounts before exit
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}

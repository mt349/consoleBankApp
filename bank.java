import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

//----------BANK CLASS-----------
class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private HashMap<String, User> users = new HashMap<>();

    // Register User
    public void registerUser(String username,String password) {
        if(users.containsKey(username)) {
            System.out.println("Username already exists! Try a different one");
            return;
        }
        User newUser = new User(username, password);
        users.put(username, newUser);
        System.out.println("User registered Successfully!");
        
    }
         public User login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("Username not found!");
            return null;
        }

        User user = users.get(username);
        if (!user.checkPassword(password)) {
            System.out.println("Incorrect password!");
            return null;
        }

        System.out.println("Login successful! Welcome, " + username);
        return user;
    }

    // Save all users to a file
    public void saveData(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(users);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all users from a file
    @SuppressWarnings("unchecked")
    public void loadData(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            users = (HashMap<String, User>) in.readObject();
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
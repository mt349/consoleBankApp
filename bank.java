import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

class Bank implements Serializable {
    private static final long serialVersionUID = 1L;

    private HashMap<String, User> users = new HashMap<>();

    public void registerUser(String username,String password) {
        if(users.containsKey(username)) {
            System.out.println("User Already Exists!Try a different one");
            return;
        }

        User newUser = new User(username,password);
        users.put(username, newUser);
        System.out.println("User Registered Sucessfully!");

    }

    public User login(String username,String password) {
        if(!users.containsKey(username)) {
            System.out.println("Username not Found!");
            return null;
        }

        User user = users.get(username);
    if(!user.checkPassword(password)) {
        System.out.println("Incorrect Password!");
        return null;
    }

    System.out.println("Login Successful! Welcome " + username );
    return user;
} 

 public void saveData(String filename) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
        out.writeObject(users);
        System.out.println("Data Saved Successfully!");
    } catch (IOException e) {
        e.printStackTrace();
    }
 }

 @SuppressWarnings("unchecked")
 public void loadData(String filename) {
    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
        users = (HashMap<String, User >) in.readObject();
        System.out.println("Data loaded Sucessfully!");
    } catch(FileNotFoundException e) {
        System.out.println("No previous data dound.Starting fresh.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    }
    }
 

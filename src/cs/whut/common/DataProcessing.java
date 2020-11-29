package cs.whut.common;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

public class DataProcessing {

    private static boolean connectToDB = false;
    static Hashtable<String, User> users;

    static {
        users = new Hashtable<>();
        users.put("jack", new Operator("jack", "123", "operator"));
        users.put("rose", new Browser("rose", "123", "browser"));
        users.put("kate", new Administrator("kate", "123", "administrator"));
        Init();
    }

    public static void Init() {
        // connect to database
        // update database connection status
        connectToDB = Math.random() > 0.2;
    }

    public static User search(String name, String password) throws SQLException {
        if (!connectToDB) {
            throw new SQLException("Not Connected to Database");
        }
        double ranValue = Math.random();
        if (ranValue > 0.7) {
            throw new SQLException("Error in executing Query");
        }

        if (users.containsKey(name)) {
            User temp = users.get(name);
            if ((temp.getPassword()).equals(password))
                return temp;
        }
        return null;
    }

    public static Enumeration<User> getAllUser() throws SQLException {
        if (!connectToDB)
            throw new SQLException("Not Connected to Database");

        double ranValue = Math.random();
        if (ranValue > 0.7)
            throw new SQLException("Error in executing Query");

        return users.elements();
    }

    public static boolean update(String name, String password, String role) throws SQLException {
        User user;
        if (!connectToDB)
            throw new SQLException("Not Connected to Database");

        double ranValue = Math.random();
        if (ranValue > 0.7)
            throw new SQLException("Error in executing Update");

        if (users.containsKey(name)) {
            if (role.equalsIgnoreCase("administrator"))
                user = new Administrator(name, password, role);
            else if (role.equalsIgnoreCase("operator"))
                user = new Operator(name, password, role);
            else
                user = new Browser(name, password, role);
            users.put(name, user);
            return true;
        } else
            return false;
    }

    public static boolean insert(String name, String password, String role) throws SQLException {
        User user;

        if (!connectToDB)
            throw new SQLException("Not Connected to Database");

        double ranValue = Math.random();
        if (ranValue > 0.7)
            throw new SQLException("Error in executing Insert");

        if (users.containsKey(name))
            return false;
        else {
            if (role.equalsIgnoreCase("administrator"))
                user = new Administrator(name, password, role);
            else if (role.equalsIgnoreCase("operator"))
                user = new Operator(name, password, role);
            else
                user = new Browser(name, password, role);
            users.put(name, user);
            return true;
        }
    }

    public static boolean delete(String name) throws SQLException {
        if (!connectToDB)
            throw new SQLException("Not Connected to Database");

        double ranValue = Math.random();
        if (ranValue > 0.7)
            throw new SQLException("Error in executing Delete");

        if (users.containsKey(name)) {
            users.remove(name);
            return true;
        } else
            return false;

    }

    public static void disconnectFromDB() {
        if (connectToDB) {
            // close Statement and Connection
            try {
                if (Math.random() > 0.7)
                    throw new SQLException("Error in disconnecting DB");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } finally {
                connectToDB = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}
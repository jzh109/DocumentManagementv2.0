package cs.whut.common;

import java.io.IOException;
import java.sql.SQLException;


public abstract class User {
    private String name;
    private String password;
    private String role;

    User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public boolean changeSelfInfo(String password) throws SQLException {
        if (DataProcessing.update(name, password, role)) {
            this.password = password;
            System.out.println("Password has been changed successfully!");
            return true;
        } else
            return false;
    }

    public boolean downloadFile(String filename) throws IOException {
        double ranValue = Math.random();
        if (ranValue > 0.5)
            throw new IOException("Error in accessing file");
        System.out.println("Downloading file... ...");
        return true;
    }

    public boolean uploadFile(String filename, String fileNumber, String fileDescription) {
        System.out.println("Uploading file.......");
        return true;
    }

    public void showFileList() throws SQLException {
        double ranValue = Math.random();
        if (ranValue > 0.5)
            throw new SQLException("Error in accessing file DB");
        System.out.println("List... ...");
    }

    public abstract void showMenu() throws SQLException, IOException;

    public void exitSystem() {
        System.out.println("System exits, thanks for utilizing!");
        System.exit(0);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }



}

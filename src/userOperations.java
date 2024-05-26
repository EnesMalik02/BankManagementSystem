//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

import java.sql.*;


public class userOperations {
    public static int ID;
    static Connection connection = DatabaseConnection.getConnection();

    public static void createUser(String username, String password) {
        try {
            // Create a statement object
            Statement statement = connection.createStatement();

            // Get the last ID from the table
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) AS last_id FROM proje.veriler");
            int lastID = 0;
            if (resultSet.next()) {
                lastID = resultSet.getInt("last_id");
            }
            lastID++; // Increment lastID by 1 to get the next ID

            ID = lastID;
//            System.out.println(lastID);

            // Define SQL query to insert data (Corrected)
            String sql = "INSERT INTO proje.veriler (id, name, password, balance) VALUES (" + lastID + ", '" + username + "', '" + password + "', 0)";

            // Execute the query
            statement.executeUpdate(sql);
//            System.out.println("Kullanıcı eklendi!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean login(int ID, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // Get a connection
            connection = DatabaseConnection.getConnection();
            // Create a statement object
            statement = connection.createStatement();

            // SQL query to get the password of the user with the given ID
            String sql = "select password FROM proje.veriler WHERE id =" + ID + ";";
            resultSet = statement.executeQuery(sql);
            //
            if (resultSet.next()) {
                String passwordFromDB = resultSet.getString("password");
                if (password.equals(passwordFromDB)) {
//                    System.out.println("Giriş başarılı!");
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kullanıcı adı alınamadı!");
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Giriş başarısız!");
        return false;
    }
}
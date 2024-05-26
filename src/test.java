import java.sql.*;

public class test {
    public static void main(String[] args) {
// Get a connection to the database
        Connection connection = DatabaseConnection.getConnection();
        // Check if the connection is not null

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();

//                transactions.Balance(1);
//                userOperations.createUser("Ahmet", "1234");
//                double balance = transactions.getUserBalance(1);
//                System.out.println(balance);























            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Veri ekleme başarısız!");
            } finally {
                // Close the connection
                try {
                    connection.close();
                    System.out.println("Bağlantı kapatıldı!");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Bağlantı kapatma başarısız!");
                }
            }
        }
    }
}

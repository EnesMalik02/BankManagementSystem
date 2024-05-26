import java.sql.*;

public class transactions {
    static Connection connection = DatabaseConnection.getConnection();

//    public static String Balance(int id) {
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        String balance = null;
//        try {
//            // Bağlantıyı al
//            connection = DatabaseConnection.getConnection();
//            // Statement nesnesini oluştur
//            statement = connection.createStatement();
//
//            // ID'si 2 olan kullanıcının adını almak için SQL sorgusu
//            String sql = "select balance FROM proje.veriler WHERE id =" + id + ";";
//            resultSet = statement.executeQuery(sql);
////
//            if (resultSet.next()) {
//                balance = resultSet.getString("balance");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Kullanıcı adı alınamadı!");
//        } finally {
//            // Kaynakları kapat
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Bakiye: " + balance);
//        return balance;
//    }

    public static void deposit(int id, int amount) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Get a connection to the database
            connection = DatabaseConnection.getConnection();
            // Create a statement object
            statement = connection.createStatement();
            // Define SQL query to update data
            String sql = "update proje.veriler set balance = balance + " + amount + " where id = " + id + ";";
            // Execute the query
            statement.executeUpdate(sql);
            System.out.println("Bakiye güncellendi!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Bakiye güncelleme başarısız!");
        } finally {
            // Close the connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void withdraw(int id, int amount) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Get a connection to the database
            connection = DatabaseConnection.getConnection();
            // Create a statement object
            statement = connection.createStatement();
            // Define SQL query to delete data
            String sql = "update proje.veriler set balance = balance - " + amount + " where id = " + id + ";";
            // Execute the query
            statement.executeUpdate(sql);
            System.out.println("Bakiye silindi!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Bakiye silme başarısız!");
        } finally {
            // Close the connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static double getUserBalance(int userId) {
        double balance = 0.0;
        String query = "SELECT balance FROM veriler WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    balance = resultSet.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }
}
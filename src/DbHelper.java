import java.sql.*;

public class DbHelper {
    private String userName = "root";//--------------------------------------
    private String password = "XXXX";//NOTE: CHANGE PASSWORD, LOCALHOST
    private String dbUrl = "jdbc:mysql://localhost:XXXX/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection connection;


    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(dbUrl,userName,password);
        System.out.println("-------Bağlantı oluştu.-------");
        return connection;
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Error : "+ exception.getMessage());
        System.out.println("Error code : "+ exception.getErrorCode());
    }

}

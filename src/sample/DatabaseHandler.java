package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"+dbHost+":"
                        +dbPort+"/"+dbName;
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection(connectionString,
                        dbUser,dbPass);
                return dbConnection;
    }
    //Write||Read
    public void signUpUser(String firstname, String lastname, String username, String password, String gender){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME+ "," + Const.USER_NAME+","+Const.USER_PASSWORD + ","+Const.USER_GENDER+")"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert );
            prSt.setString(1,firstname);
            prSt.setString(2,lastname);
            prSt.setString(3,username);
            prSt.setString(4,password);
            prSt.setString(5,gender);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

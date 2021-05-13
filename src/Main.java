import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) {

        try{
            Connection connection = dataSource();
            Statement stmt = connection.createStatement();
            System.out.println("conected  ");


        String sql = "INSERT INTO registration   "  +
              "VALUES  (12, 14, 1, 15);  " ;

            stmt.executeUpdate(sql);
        }

        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection dataSource() throws SQLException {

        String ConnectionString = "jdbc:postgresql://ec2-63-34-97-163.eu-west-1.compute.amazonaws.com:5432/dd0of0uufj69pe";
        String username = "kygmxpoanyhdim";
        String password = "89079527e60afab5bd7969a366c9771f4778289627b619e00f04b9de81649aeb";
        return DriverManager.getConnection(ConnectionString, username, password);
    }

}
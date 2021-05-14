import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static Connection GetConnection() throws SQLException {
        String ConnectionString = "jdbc:postgresql://ec2-63-32-7-190.eu-west-1.compute.amazonaws.com:5432/d8dsa8l6mtacb3";
        String username = "vgisptadjxxnpl";
        String password = "c79c309b2211b97bae7748d2c9b0f586c9c7d4dbe5db94acb8c850e0b86c7d64";
        return DriverManager.getConnection(ConnectionString, username, password);
    }

    public static void ExecuteQuery(String query) {
        try {
            Connection connection = GetConnection();
            Statement stmt = connection.createStatement();
            System.out.println("Connected");
            stmt.execute(query);
            System.out.println("Query completed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {

        String sql = "CREATE TABLE UMLS (" +
                "UMLSID INT PRIMARY KEY NOT NULL, " +
                "ConceptPreferredName Varchar, " +
                "ConceptUniqueIdentifier Varchar, " +
                "SemanticType Varchar); ";

        ExecuteQuery(sql);

    }

}
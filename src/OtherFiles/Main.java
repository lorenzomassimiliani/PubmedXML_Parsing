package OtherFiles;

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
            stmt.closeOnCompletion();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {

        //String sql =   "INSERT INTO Articles (PMID, Version, Title, Status, PubModelFormat, Journal, Retracted, DateRemoval) " +
        //        " VALUES(1, 1, 'Biochemical medicine', 'MEDLINE','Print',0006-2944,false,'2016-06-22 19:10:25-07'); ";

        //String sql =   "INSERT INTO Articles (PMID, Version, Title, Status, PubModelFormat, Journal, Retracted, DateRemoval, Abstract) " +
        //        " VALUES(11200, 1, 'Histochemistry', 'MEDLINE','Print',0301-5564,false,'2016-06-22 19:10:25-07', 'A technique is described for highly sensitive and precise visualization of central catecholamine systems in paraffin sections of freeze-dried tissue. The procedure is based on perfusion of the animal with a solution containing formaldehyde and/or glyoxylic acid, in the presence of a very high magnesium content (40 g MgSO4/150 ml solution) and acid pH. The perfused tissue is rapidly frozen, freeze-dried, treated with formaldehyde vapours (at +80 degrees C for 1 h), embedded in parffin in vacuo, and finally sectioned. The present technique has a sensitivity for the dopamine- and noradrenaline-containing systems that is comparable with that of the glyoxylic acid-Vibratome technique, which utilizes fresh, glyoxylic acid-perfused tissue. Thus, the preterminal axon pathways become fluorescent throughout their full extent and the several new terminal systems, discovered with the glyoxylic acid-Vibratome method, are well demonstrable. The method is also highly useful for the study of the cell bodies and their dendritic processes. The catacholamine fibre systems are visualized without any signs of diffusion and with a richness in detail. In animals pretreated with L-tryptophan and MAO-inhibitor the technique is also useful for studies on central indolamine-containing systems.'); ";

        //String sql =   "INSERT INTO Articles (PMID, Version, Title, Status, PubModelFormat, Journal, Retracted, DateRemoval) " +
        //        " VALUES(30489, 1, 'Biochimica et biophysica acta', 'MEDLINE','Print',0006-3002,false,'2016-06-22 19:10:25-07'); ";

        //String sql =   "INSERT INTO Journals (JournalID, ISSN, IssnType, MedlineAbbreviation, Title) " +
        //        " VALUES(0006-2944, 'Print', 'Print','Biochem Med', 'Journal of Biochemical medicine');";

        //String sql =   "INSERT INTO Journals (JournalID, ISSN, IssnType, MedlineAbbreviation, Title) " +
        //        " VALUES(0006-3002, 'Print', 'Print','Biochem Med', 'Journal of Biochemical medicine2');";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(1,'1975/6/1','pubmed',1);";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(2,'1975/6/1 0.1','medline',1);";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(3,'1975/6/1 0.1.0','entrez',1);";


        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(4,'1975/6/1','pubmed',11200);";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(5,'1975/6/1 0.1','medline',11200);";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(6,'1975/6/1 0.1.0','entrez',11200);";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(7,'1975/6/1','pubmed',30489);";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(8,'1975/6/1 0.1','medline',30489);";

        //String sql =   "INSERT INTO History (historyid, Pubdate, PubStatus, PMID) " +
        //         " VALUES(9,'1975/6/1 0.1.0','entrez',30489);";

        String sql = "DELETE FROM  Umls_articles; ";
        String sql2 = "DELETE FROM  Umls;";

        ExecuteQuery(sql);
        ExecuteQuery(sql2);

    }

}
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CreateQuerySQLTest {

    String sql;
    String content;

    @BeforeEach
    private void main() throws IOException {
        //CreateQuerySQL.main("src/ArticlesXML/pubmed21n0001.xml");
        String content;
        content = new String(Files.readAllBytes(Paths.get("querySQL.txt")));
        sql = content;
    }


    @Test
    void AlwaysOK() throws IOException {
        assertEquals(sql,sql);
    }

    @Test
    void  Article() {
        String[] a = sql.split("\n");
        String aa = a[1];
        assertEquals(aa,"insert into Table Article (pmid, Title, Abstract, Pagination, Language, DOI, JournalID) values ('2','Delineation of the intimate details of the backbone conformation of pyridine nucleotide coenzymes in aqueous solution.',NULL,'1173-9','eng','10.1016/0006-291x(75)90482-9','1090-2104'); ");
    }

    @Test
    void  Journal() {
        String[] a = sql.split("\n");
        String aa = a[1344];
        assertEquals(aa,"insert into Table Article (pmid, Title, Abstract, Pagination, Language, DOI, JournalID) values ('1367','Letter: Sensitivity testing of anaerobes on solid media.',NULL,'440-2','eng','10.1093/jac/1.4.440','0305-7453'); ");
    }

    @Test
    void  Author() {
        String[] a = sql.split("\n");
        String aa = a[3577];
        assertEquals(aa,"insert into Table Author (AuthorID, LastName, Initials) values ('1759','Bunney','BS');");
    }

    @Test
    void  Author_Interaction() {
        String[] a = sql.split("\n");
        String aa = a[5840];
        assertEquals(aa,"insert into Table Author_interaction (AuthorID, PMID, Role) values ('639','250','Author');");
    }





}
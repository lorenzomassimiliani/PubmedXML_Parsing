import Tables.Article;
import Tables.Author;
import Tables.Author_Interaction;
import Tables.Journal;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class CreateQuerySQL {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/ArticlesXML/article_test.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);

            List<Article> articles = userhandler.getArticles();
            for (Article article : articles) {
                String sql ="insert into Table Article (pmid, Title, Abstract, Pagination, Language, DOI, JournalID) values " +
                        "('"+article.getPMID()+"','"+article.getTitle() +"','"+article.getAbstract()+"','"+article.getPagination()+"','"+article.getLanguage()+"','"+
                        article.getDOI()+"','"+article.getJournalID() +"'); ";
                sql = sql.replaceAll("'null'", "NULL");
                System.out.println(sql);
            }


            List<Journal> journals = userhandler.getJournals();
            for (Journal journal: journals) {
                String sql ="insert into Table Article (JournalID, Title, Volume, Issue) values " +
                        "('"+journal.getJournalID()+"','"+journal.getTitle() +"','"+journal.getVolume()+"','"+journal.getIssue()+"');";
                sql = sql.replaceAll("'null'", "NULL");
                System.out.println(sql);
            }

            List<Author> authors = userhandler.getAuthors();
            for (Author author: authors) {
                String sql ="insert into Table Author (AuthorID, LastName, Initials) values " +
                        "('"+author.getAuthorID()+"','"+author.getLastName() +"','"+author.getInitials()+"');";
                sql = sql.replaceAll("'null'", "NULL");
                System.out.println(sql);
            }

            List<Author_Interaction> author_interactions = userhandler.getAuthor_interactions();
            for (Author_Interaction author_interaction: author_interactions) {
                String sql ="insert into Table Author_interaction (AuthorID, PMID, Role) values " +
                        "('"+author_interaction.getAuthorID()+"','"+author_interaction.getPMID() +"','"+author_interaction.getRole() +"');";
                sql = sql.replaceAll("'null'", "NULL");
                System.out.println(sql);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

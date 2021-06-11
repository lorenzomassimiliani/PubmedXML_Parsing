import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Tables.Article;
import Tables.Author;
import Tables.Author_Interaction;
import Tables.Journal;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



class UserHandler extends DefaultHandler {
    private final List<Article> articles = new ArrayList<>();
    private Map<String, Journal> journals = new HashMap <String, Journal>();
    private final List<Author> authors = new ArrayList<>();
    private final List<Author_Interaction> author_interactions = new ArrayList<>();
    private Article article = null;
    private Journal journal = null;
    private Author author = null;
    private Author_Interaction author_interaction = null;
    private int IDauthor = 1;
    private String CurrentPMID = null;
    private String elementTag = "";
    private Boolean Skip = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  throws SAXException {

        if (qName.equals("PubmedArticle")) {
            article = new Article();
            journal = new Journal();
            return;
        }

        if(qName.equals("CommentsCorrections")) {
            Skip = true;
        }

        // Articles parsing
        switch (qName) {
            case "PMID":
                elementTag = "PMID";
                return;
            case "ArticleTitle":
                elementTag = "ArticleTitle";
                return;
            case "AbstractText":
                elementTag = "AbstractText";
                return;
            case "MedlinePgn":
                elementTag = "MedlinePgn";
                return;
            case "Language":
                elementTag = "Language";
                return;
            case "ISSN":
                elementTag = "ISSN";
                return;
        }

        if (qName.equals("ArticleId") && attributes.getLength() > 0 && attributes.getValue("IdType").equals("doi")) {
            elementTag = "doi";

        }


        //Journals parsing
        switch (qName) {
            case "Title":
                elementTag = "Title";
                return;
            case "Volume":
                elementTag = "Volume";
                return;
            case "Issue":
                elementTag = "Issue";
                return;
        }

        //authors parsing
        if (qName.equals("Author")) {
            author = new Author();
            author_interaction = new Author_Interaction();

        }
        switch (qName) {
            case "LastName":
                if (author!=null)
                    elementTag = "LastName";
                return;
            case "Initials":
                if (author!=null)
                    elementTag = "Initials";
                return;
            default:
                if(elementTag!="doi") {
                    elementTag = "";
                }
                return;
        }

    }





    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String content = new String(ch, start, length);

        if(Skip) {
            return;
        }

        //articles parsing
        switch (elementTag){
            case "PMID":
                article.setPMID(content);
                CurrentPMID = content;
                return;
            case "ArticleTitle":
                article.setTitle(content);
                return;
            case "AbstractText":
                article.setAbstract(content);
                return;
            case "MedlinePgn":
                article.setPagination(content);
                return;
            case "Language":
                article.setLanguage(content);
                return;
            case "doi":
                article.setDOI(content);
                return;
            case "ISSN":
                article.setJournalID(content);
                journal.setJournalID(content);
                return;

            //journals parsing
            case "Title":
                journal.setTitle(content);
                return;
            case "Issue":
                journal.setIssue(content);
                return;
            case "Volume":
                journal.setVolume(content);
                return;

            //authors parsing
            case "LastName":
                author = new Author();
                author.setLastName(content);
                return;
            case "Initials":
                author.setInitials(content);
                return;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(qName.equals("CommentsCorrections")) {
            Skip = false;
        }

        if(qName.equals("PubmedArticle")) {
            if(journal.getJournalID()  == null) {
                journal.setJournalID("FAKE-" + journal.getTitle() + journal.getVolume() + journal.getIssue());
                article.setJournalID(journal.getJournalID());
            }
            if(!journals.containsKey(journal.getJournalID())) {
                journals.put(journal.getJournalID(), journal);
            }

            journal = null;
            articles.add(article);
            article = null;
        }

        if(qName.equals("Author")) {
            author.setAuthorID(IDauthor);

            //author_inìteractions parsing
            author_interaction.setRole("Author");
            author_interaction.setPMID(CurrentPMID);
            author_interaction.setAuthorID(IDauthor);
            author_interactions.add(author_interaction);
            author_interaction = null;
            IDauthor ++;
            authors.add(author);
            author = null;
        }
    }


    List<Article> getArticles() {
        return articles;
    }
    List <Journal> getJournals() {
        return  journals.values().stream().toList();
    }
    List <Author> getAuthors() {
        return  authors;
    }
    List <Author_Interaction> getAuthor_interactions() {
        return  author_interactions;
    }

}
package Tables;


public class Article {
    private String PMID;
    private String Title;
    private String Abstract;
    private String Pagination;
    private String Language;
    private String DOI;
    private String JournalID;

    public String getPMID() {
        return PMID;
    }

    public void setPMID(String PMID) {
        this.PMID = PMID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getPagination() {
        return Pagination;
    }

    public void setPagination(String pagination) {
        Pagination = pagination;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getJournalID() {
        return JournalID;
    }

    public void setJournalID(String journalID) {
        JournalID = journalID;
    }

}

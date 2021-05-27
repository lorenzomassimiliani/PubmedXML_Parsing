package Tables;

public class Journal {
    private String JournalID;
    private String Title;
    private String Volume;
    private String Issue;

    public String getJournalID() {
        return JournalID;
    }

    public void setJournalID(String journalID) {
        JournalID = journalID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }
}

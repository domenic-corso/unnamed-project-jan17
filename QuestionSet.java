import java.util.Date;

public class QuestionSet {
    // Useful constants
    static final public int MAX_TITLE_LEN = 30;
    static final public int MAX_CREATOR_NAME_LEN = 20;

    // Instance variables
    private String title;
    private String creatorName;
    private Date dateCreated;
    private Question[] questions = new Question[Application.MAX_QUESTIONS_PER_SET];
    private int numQuestions;

    public QuestionSet () {
        this.numQuestions = 0;
    }

    public String getTitle () { return this.title; }

    public String getCreatorName () { return this.creatorName; }

    public int getNumQuestions () { return this.numQuestions; }

    // Add a Question to array of Questions
    public void addQuestion (Question question) {
        // Cancel if the maximum number of questions has been reached
        // Note that this should never really be greater than, could leave it as '=='
        if (this.numQuestions >= Application.MAX_QUESTIONS_PER_SET) return;
        this.questions[this.numQuestions++] = question;
    }

    public void setTitle (String title) { this.title = title; }

    public void setCreatorName (String creatorName) { this.creatorName = creatorName; }

    public void debugDetails () {
        System.out.println("---- Question Set Details (Debugging) ----\n");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Creator: " + this.getCreatorName());
        System.out.println("Questions:");

        for (int i = 0; i < this.numQuestions; i++) {
            this.questions[i].debugDetails();
        }

        System.out.println("\n---- End Question Set Details ----");
    }
}

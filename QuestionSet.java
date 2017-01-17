import java.util.Date;
import java.util.Random;

public class QuestionSet {
    // Useful constants
    static final public int MAX_TITLE_LEN = 30;
    static final public int MAX_CREATOR_NAME_LEN = 20;

    // Instance variables
    private String title;
    private String creatorName;
    private Date dateCreated;
    private Question[] questions = new Question[App.MAX_QUESTIONS_PER_SET];
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
        if (this.numQuestions >= App.MAX_QUESTIONS_PER_SET) return;
        this.questions[this.numQuestions++] = question;
    }

    public void setTitle (String title) { this.title = title; }

    public void setCreatorName (String creatorName) { this.creatorName = creatorName; }

    // Returns a shuffled version of the Questions' array.
    public Question[] shuffleQuestions () {
        // Create new empty array of Questions' which will be filled with random Questions of the original array.
        Question[] shuffled = new Question[this.numQuestions];

        // Get an integer array containing random distinct values from 0 to this.numQuestions (non-exclusive)
        // For example, if this.numQuestions was 4, this COULD equal {3,0,1,2}
        // For example, if this.numQuestions was 9, this COULD equal {5,2,3,8,7,1,0,4,6}
        int[] randomIndexes = new Random().ints(0, this.numQuestions).distinct().limit(this.numQuestions).toArray();

        // Loop through the randomly generated indexes, and progressively add Questions to the shuffled array based
        // on the randomness of the generated indexes.
        for (int i = 0; i < randomIndexes.length; i++) {
            shuffled[i] = this.questions[randomIndexes[i]];
        }

        // Finally, return the shuffled array.
        return shuffled;
    }

    public void debugDetails () {
        System.out.println("---- Question Set Details (Debugging) ----\n");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Creator: " + this.getCreatorName());
        System.out.println("Questions:");

        Question[] shuffledVersion = this.shuffleQuestions();
        for (int i = 0; i < this.numQuestions; i++) {
            shuffledVersion[i].debugDetails();
        }

        System.out.println("\n---- End Question Set Details ----");
    }

    public void listQuestions () {
        if  (numQuestions == 0) {
            System.out.println("No questions!");
            return;
        }

        for (int i = 0; i < numQuestions; i++) {
            System.out.println("Question #" + (i + 1) + ": " + questions[i].getQuestion());
        }
    }
}

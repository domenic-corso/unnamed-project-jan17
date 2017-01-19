
public class Question {
	//Instance Variables
    private String question;
    private String answer;

    static final public int MAX_QUESTION_ANSWER_LEN = 50;
    
    public Question () {}
    
    //Setter Methods
    public void setQuestion (String question) { this.question = question; }
    public void setAnswer (String answer) { this.answer = answer; }

    //Getter Methods
    public String getQuestion () { return this.question; }
    public String getAnswer () { return this.answer; }

    public void debugDetails () {
        System.out.println("---- Question Details (Debug) ----\n");
        System.out.println("Q: " + this.getQuestion());
        System.out.println("A: " + this.getAnswer());
        System.out.println("---- End Question Details ----\n");
    }

}

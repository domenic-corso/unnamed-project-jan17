
public class Question {
    private String question;
    private String answer;

    public Question () {}

    public void setQuestion (String question) { this.question = question; }
    public void setAnswer (String answer) { this.answer = answer; }

    public String getQuestion () { return this.question; }
    public String getAnswer () { return this.answer; }

    public void debugDetails () {
        System.out.println("---- Question Details (Debug) ----\n");
        System.out.println("Q: " + this.getQuestion());
        System.out.println("A: " + this.getAnswer());
        System.out.println("---- End Question Details ----");
    }

}

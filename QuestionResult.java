
public class QuestionResult {
	
	// Instance Variables
	private Question question; 
	private String userAnswer;
	
	// Constructor
	public QuestionResult () {}
	
	public Question getQuestion () { return this.question; }
	public String getUserAnswer () { return this.userAnswer; }
	
	public void setUserAnswer (String userAnswer) { this.userAnswer = userAnswer; }
	public void setQuestion (Question question) { this.question = question; }

	
	// Gets the accuracy of the users answer
	public float getAccuracy() { return 100; }

}

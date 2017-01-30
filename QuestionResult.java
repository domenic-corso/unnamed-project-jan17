
public class QuestionResult {
	
	// Instance Variables
	private Question question; 
	private String userAnswer;
	private int numQuestionsCorrect = 0;
	
	// Constructor
	public QuestionResult () {}
	
	public Question getQuestion () { return this.question; }
	public String getUserAnswer () { return this.userAnswer; }
	public int getNumQuestionsCorrect () {return this.numQuestionsCorrect; }
	
	public void setUserAnswer (String userAnswer) { this.userAnswer = userAnswer; }
	public void setQuestion (Question question) { this.question = question; }
	public void setQuestionsCorrect(int numQuestionsCorrect) {this.numQuestionsCorrect = numQuestionsCorrect++; }
	
	// Gets the accuracy of the users answer
	public float getAccuracy() { return 100 ; }

	public boolean isCorrect(){
		if(getAccuracy() >= 50){
			numQuestionsCorrect++;
			return true;
		}else{
			return false;
		}
	}
}


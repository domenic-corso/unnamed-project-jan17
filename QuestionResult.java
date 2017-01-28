
public class QuestionResult {
	
	// Instance Variables
	private Question question; 
	private String userAnswer;
	private float accuracy = 100;
	private int numQuestionsCorrect = 0;
	
	// Constructor
	public QuestionResult () { 
	}
	
	public Question getQuestion () { return this.question; }
	public String getUserAnswer () { return this.userAnswer; }
	public int getNumQuestionsCorrect () {return this.numQuestionsCorrect; }
	
	public void setUserAnswer (String userAnswer) { this.userAnswer = userAnswer; }
	public void setQuestion (Question question) { this.question = question; }
	public void setQuestionsCorrect(int numQuestionsCorrect) {this.numQuestionsCorrect = numQuestionsCorrect++; }
	
	// Gets the accuracy of the users answer
	public float getAccuracy() { return accuracy; } 

	public boolean isCorrect(){
		if(accuracy > 50){
			//System.out.println("Accuracy is more than 50%, Great!\n");
			numQuestionsCorrect++;
			return true;
		}else{
			//System.out.println("Accuracy is less than 50%, Try Again!\n");
			return false;
		}
	}
}



public class App {

	// Constants defining the application name and max questions per QuestionSet
    final public static String APPLICATION_NAME = "Unnamed Project JAN 17";
    final public static int MAX_QUESTIONS_PER_SET = 5;

    public static UI userIfce;

    public static QuestionSet testQS = new QuestionSet();

    public static void main (String[] args) {
        testQS.setTitle("My mint test QuestionSet");
        testQS.setCreatorName("Lu and Dom");

        Question tempQuestion;

        tempQuestion = new Question();
        tempQuestion.setQuestion("What is the name of my dog?");
        tempQuestion.setAnswer("Raffe");
        testQS.addQuestion(tempQuestion);

        tempQuestion = new Question();
        tempQuestion.setQuestion("What colour is my keyboard?");
        tempQuestion.setAnswer("Black");
        testQS.addQuestion(tempQuestion);

        tempQuestion = new Question();
        tempQuestion.setQuestion("Is it hot outside?");
        tempQuestion.setAnswer("Yes");
        testQS.addQuestion(tempQuestion);

        testQS.setDate();

        userIfce = new CLI();
        testQS.getAsXML();
        //Core.beginTest(testQS);
        //userIfce.showMainMenu();
    }

}

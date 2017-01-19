
public class App {

	// Constants defining the application name and max questions per QuestionSet
    final public static String APPLICATION_NAME = "Unnamed Project JAN 17";
    final public static int MAX_QUESTIONS_PER_SET = 5;

    public static UI userIfce;

    public static void main (String[] args) {
        userIfce = new CLI();
        userIfce.showMainMenu();
    }

}

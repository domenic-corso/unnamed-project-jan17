
public class App {

    final public static String APPLICATION_NAME = "Unnamed Project JAN 17";
    final public static int MAX_QUESTIONS_PER_SET = 2;

    public static UI userIfce;

    public static void main (String[] args) {
        userIfce = new CLI();
        userIfce.showMainMenu();
    }

}

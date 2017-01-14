public class Application {

    final public static int MAX_QUESTIONS_PER_SET = 40;

    public static void main (String[] args) {
        UI userInterface = new CLI();
        userInterface.showAddNewSetMenu().debugDetails();
    }

}

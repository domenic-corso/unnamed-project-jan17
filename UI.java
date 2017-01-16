
abstract public class UI {
    // Welcome messaged to be used in both user interfaces.
    final public String WELCOME_MESSAGE = "Welcome to " + Application.APPLICATION_NAME + "!";

    // Shows Main Menu options and allows user to select an option.
    abstract public void showMainMenu ();

    // Shows options for creating a new question set.
    abstract public QuestionSet showAddNewSetMenu ();
}

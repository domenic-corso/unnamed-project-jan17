
abstract public class UI {
    // Welcome messaged to be used in both user interfaces.
    final public String WELCOME_MESSAGE = "Welcome to " + App.APPLICATION_NAME + "!";

    // Shows Main Menu options and allows user to select an option.
    abstract public void showMainMenu ();

    // Shows options for creating a new question set.
    abstract public QuestionSet showAddNewSetMenu ();

    // Asks user a yes/no question and returns true/false respectively based on answer
    abstract public boolean promptYesOrNo (String promptMessage);

    // Displays an error to the user.
    abstract public void showError (String message);

    // Alerts the user of information.
    abstract public void alertUser (String message);
}

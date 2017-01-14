/*

Using an abstract class here in order to have a GUI version as well as a CLI

 */

abstract public class UI {

    // Constants for Main Menu return values/options
    final public int OPT_NEW_SET = 0;
    final public int OPT_IMPORT = 1;
    final public int OPT_EXIT = 2;

    final public String WELCOME_MESSAGE = "Welcome to Unnamed Project Jan 17\n";

    // Shows Main Menu options for user and returns their selection as int
    abstract public int showMainMenu ();
}

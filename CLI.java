import java.util.Scanner;

public class CLI extends UI {
    Scanner sc;

    // Constantly changing user-input variable to collect input from the scanner
    String userInp;

    public CLI () {
        // Create a new input Scanner
        this.sc = new Scanner(System.in);
    }

    public int showMainMenu () {
    	while (true) {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("\n0. New Question Set");
        System.out.println("1. Import Existing File");
        System.out.println("2. Exit\n");
        
        switch (userInp.trim()) {
            case "0":
            	this.showAddNewSetMenu();
            case "1":
            	return OPT_IMPORT;
            case "2":
            	return OPT_EXIT;
            default: 
            	System.out.println("[ERROR] Not a valid option");
        }
    	}
    }

    public QuestionSet showAddNewSetMenu () {
        // QuestionSet to add data to and eventually return
        QuestionSet questionSet = new QuestionSet();

        // Ask user for their desired name of the new QuestionSet
        while (true) {
            System.out.print("Enter a name for the Question Set " + this.getMaxCharMSG(QuestionSet.MAX_NAME_LEN) + ": ");
            userInp = sc.nextLine().trim();

            // Ask again if they didn't enter anything useful
            if (userInp.isEmpty()) continue;

            // Ask again if they entered a name that is too long
            if (userInp.length() > QuestionSet.MAX_NAME_LEN) {
                this.showUserInpErr("Sorry, that name is too long. Try again.");
                continue;
            }

            // Successful, set the name and continue on to next step
            questionSet.setName(userInp);
            break;
        }

        // Ask user for their name to associate with this QuestionSet
        while (true) {
            System.out.print("Enter your name " + this.getMaxCharMSG(QuestionSet.MAX_CREATOR_NAME_LEN) +": ");
            userInp = sc.nextLine().trim();

            // Ask again if they didn't enter anything useful
            if (userInp.isEmpty()) continue;

            // Ask again if they entered a name that is too long
            if (userInp.length() > QuestionSet.MAX_CREATOR_NAME_LEN) {
                this.showUserInpErr("Sorry, that name is too long. Try again.");
                continue;
            }

            // Successful, set the creator name and continue on to next step
            questionSet.setCreatorName(userInp);
            break;
        }

        return questionSet;
    }

    private void showUserInpErr (String message) { System.out.println("ERR: " + message); }
    private String getMaxCharMSG (int maxChars) { return "(max characters: " + maxChars + ")"; }
}

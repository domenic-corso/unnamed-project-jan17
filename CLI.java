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
        
        switch (Integer.parseInt(userInp.trim())) {
            case OPT_NEW_SET:
            	System.out.println("Selected New Question Set");
            	break;
            case OPT_IMPORT:
            	System.out.println("Importing File");
            	break;
            case OPT_EXIT:
            	System.out.println("Exiting Application");
            	sc.close();
        }
        return userInp;
    	}
    }

    public QuestionSet showAddNewSetMenu () {
        QuestionSet questionSet = new QuestionSet();

        // Ask user for their desired name of the new QuestionSet
        System.out.print("Enter a name for the Question Set: ");
        userInp = sc.nextLine();
        questionSet.setName(userInp);

        // Ask user for their name to associate with this QuestionSet
        System.out.print("Add your name to the set (optional): ");
        userInp = sc.nextLine();

        if (userInp.isEmpty()) {
            questionSet.setCreatorName(null);
        }
        else {
            questionSet.setCreatorName(userInp);
        }

        return questionSet;
    }
}

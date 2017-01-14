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
            	return OPT_NEW_SET;
            case "1":
            	return OPT_IMPORT;
            case "2":
            	return OPT_EXIT;
        }
    	}
    }

    public QuestionSet showAddNewSetMenu () {
        QuestionSet questionSet = new QuestionSet();

        // Ask user for their desired name of the new QuestionSet
        while (true) {
            System.out.print("Enter a name for the Question Set (max " + QuestionSet.MAX_NAME_LEN + " chars): ");
            userInp = sc.nextLine().trim();
            questionSet.setName(userInp);
        }

        // Ask user for their name to associate with this QuestionSet
        System.out.print("Add your name to the set (optional): ");
        userInp = sc.nextLine().trim();

        // Add a Creator Name to the Question Set if the user decides to do so
        if (!userInp.isEmpty()) {
            questionSet.setCreatorName(userInp);
        } else {
            questionSet.setCreatorName(null);
        }

        return questionSet;
    }
}

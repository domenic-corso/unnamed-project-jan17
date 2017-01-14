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
            	sc.close();
        }
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

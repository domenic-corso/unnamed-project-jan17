import java.util.Scanner;

public class CLI extends UI {
    Scanner sc;

    public CLI () {
        // Create a new input Scanner
        this.sc = new Scanner(System.in);
    }

    public int showMainMenu () {
        System.out.println(WELCOME_MESSAGE);
        return 0;
    }

    public QuestionSet showAddNewSetMenu () {
        QuestionSet questionSet = new QuestionSet();

        // Constantly changing user-input variable to collect input from the scanner
        String userInp;

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

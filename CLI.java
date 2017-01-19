import java.util.Scanner;

public class CLI extends UI {
    Scanner sc;
    String userInp;

    public CLI () {
        // Instantiate a new input scanner on creation.
        this.sc = new Scanner(System.in);
    }

    // Display a list of options for the user to pick from. Take their input and run the appropriate method. If the
    // user chooses to exit the application, return from this method.
    public void showMainMenu () {
    	while (true) {
            System.out.println(WELCOME_MESSAGE);
            System.out.println();
            System.out.println("1. Create a new Question Set.");
            System.out.println("2. Import an existing Question Set.");
            System.out.println("3. Exit application.");
            System.out.println();
            System.out.print("Select an option: ");

            // Grab text user entered and trim it immediately.
            userInp = sc.nextLine().trim();

            // Add an extra line break to give room for next prompt
            System.out.println();

            // Switch out the user input and run a method based on the chosen option.
            switch (userInp) {
                case "1":
                    Core.createQuestionSet();
                    continue;
                case "2":
                    this.showError("Not yet implemented.");
                    continue;
                case "3":
                    return;
                default:
                    this.showError("Invalid option. Try again.");
            }
    	}
    }

    // This method displays the 'menu' or command-line process which asks the user to enter in data related to their
    // eventually created Question Set. It does this by creating a new instance of QuestionSet and then progressively
    // add data to it until it is returned.
    public QuestionSet showAddNewSetMenu () {
        Question newQues;
        QuestionSet questionSet;

        // QS to progressively add data to.
        questionSet = new QuestionSet();

        this.displayMenuOptionTitle("Add new Question Set");

        // Ask user for title of QS.
        questionSet.setTitle(this.promptForDataValue("Title of Question Set: ", QuestionSet.MAX_TITLE_LEN));

        // Ask user for the creator name (their name) of QS.
        questionSet.setCreatorName(this.promptForDataValue("Enter your name: ", QuestionSet.MAX_CREATOR_NAME_LEN));

        // Add an extra line break to give room for next prompt
        System.out.println();

        this.displayMenuOptionTitle("Add your Questions");
        
        while (true) {
            // Instantiate a new Question.
            newQues = new Question();

            // Set the question.
            newQues.setQuestion(promptForDataValue("Enter Question: ", Question.MAX_QUESTION_ANSWER_LEN));

            // Set the answer.
            newQues.setAnswer(promptForDataValue("Enter Answer: ", Question.MAX_QUESTION_ANSWER_LEN));

            // Add this Question to the QuestionSet.
            questionSet.addQuestion(newQues);

            // Tell user how many questions they have left.
            this.showMessage("Current number of Questions: " + questionSet.getNumQuestions() + "/" + App.MAX_QUESTIONS_PER_SET);

            // Add line break to add room for next potential question prompt.
            System.out.println();

            // If maximum number of questions has been reached, then stop asking for questions.
            if (questionSet.getNumQuestions() == App.MAX_QUESTIONS_PER_SET) {
                this.alertUser("You have reached the maximum number of questions allowed (" + App.MAX_QUESTIONS_PER_SET + ").");
                break;
            }

            // If user does not wish to add another Question, then stop asking for questions.
            if (!promptYesOrNo("Would you like to add another?")) break;
        }

        // Add a date created to the QS.
        questionSet.setDate();

    	// Finally once all data has been gathered, return it.
        return questionSet;
    }

    // Check parent class for description.
    public void showError (String message) {
        this.showMessage("ERR: " + message);
    }

    // Check parent class for description.
    public void alertUser (String message) { this.showMessage("ALERT: " + message); }

    // Check parent class for description.
    public boolean promptYesOrNo (String promptMessage) {
        String textAnswer;

        // Keep asking user for their answer if they don't say 'y' or 'n'.
        do {
            textAnswer = this.promptForDataValue(promptMessage + " (y/n) : ", 0);
        } while (!textAnswer.toLowerCase().equals("y") && !textAnswer.toLowerCase().equals("n"));

        // Return true if they answered yes.
        if (textAnswer.equals("y")) return true;

        // Otherwise in all other cases return false.
        return false;
    }
   
    // Asks user for a string of text and return it. Needs a prompt message as well as a maximum amount of characters
    // allowed.
    private String promptForDataValue (String promptMessage, int maxChars) {
        while (true) {
            // Show prompt.
            System.out.print(promptMessage);

            // Gather user input, trim it immediately.
            userInp = sc.nextLine().trim();

            // Prompt again if user entered nothing or white space.
            if (userInp.isEmpty()) continue;

            // Prompt again if user entered text that is too long.
            if (maxChars > 0 && userInp.length() > maxChars) {
                this.showError("Sorry, you must enter a maximum of " + maxChars + " characters. Try again.");
                continue;
            }

            // If the data is good, return it.
            return userInp;
        }
    }

    // Displays a title for a menu option, such as 'Add new QS' or 'Import'.
    private void displayMenuOptionTitle (String title) {
        System.out.println("--- " + title + " ---");
        System.out.println();
    }

    // Prints out a basic message.
    private void showMessage (String message) {
        System.out.println(message);
    }
}

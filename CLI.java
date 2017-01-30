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
            this.showMessage(WELCOME_MESSAGE);
            this.lineBreak();
            this.showMessage("1. Create a new Question Set.");
            this.showMessage("2. Import an existing Question Set.");
            this.showMessage("3. Exit application.");
            this.lineBreak();
            this.showMessage("Select an option: ");

            // Grab text user entered and trim it immediately.
            userInp = sc.nextLine().trim();

            // Add an extra line break to give room for next prompt
            this.lineBreak();

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
        questionSet.setTitle(this.promptForDataValue("Title of Question Set: ", QuestionSet.MAX_TITLE_LEN, false));

        // Ask user for the creator name (their name) of QS.
        questionSet.setCreatorName(this.promptForDataValue("Enter your name: ", QuestionSet.MAX_CREATOR_NAME_LEN, false));

        // Add an extra line break to give room for next prompt
        this.lineBreak();

        this.displayMenuOptionTitle("Add your Questions");
        
        while (true) {
            // Instantiate a new Question.
            newQues = new Question();

            // Set the question.
            newQues.setQuestion(promptForDataValue("Enter Question: ", Question.MAX_QUESTION_ANSWER_LEN, false));

            // Set the answer.
            newQues.setAnswer(promptForDataValue("Enter Answer: ", Question.MAX_QUESTION_ANSWER_LEN, false));

            // Add this Question to the QuestionSet.
            questionSet.addQuestion(newQues);

            // Tell user how many questions they have left.
            this.showMessage("Current number of Questions: " + questionSet.getNumQuestions() + "/" + App.MAX_QUESTIONS_PER_SET);

            // Add line break to add room for next potential question prompt.
            this.lineBreak();

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
            textAnswer = this.promptForDataValue(promptMessage + " (y/n) : ", 0, false);
        } while (!textAnswer.toLowerCase().equals("y") && !textAnswer.toLowerCase().equals("n"));

        // Return true if they answered yes.
        if (textAnswer.equals("y")) return true;

        // Otherwise in all other cases return false.
        return false;
    }

    // Check parent class for description.
    public QuestionResult[] beginTest (Question[] questions, String testTitle) {
        // Create an array of QuestionResult, one for each Question.
        QuestionResult[] results = new QuestionResult[questions.length];

        this.alertUser("Beginning test '" + testTitle + "'");
        this.lineBreak();

        for (int i = 0; i < results.length; i++) {
            results[i] = askQuestion(questions[i]);
        } 
        
        //Show user the results such as 3/3 
        displayTestResults(results);
        
        return results;  
    }
       
    public void displayTestResults(QuestionResult[] results){
        QuestionResult qr = new QuestionResult();
        
        //Go through the array and check if a question is correct based on the accuracy being greater than a certain number
        for(int i = 0; i < results.length ; i++){
        	if(qr.isCorrect() == true){
        	}
        }
        this.alertUser("You got: " + qr.getNumQuestionsCorrect() + "/" + results.length + " Correct!" );
        
    }
    
    // Asks a single question and returns a QuestionResult variable based on the users' answer
    private QuestionResult askQuestion (Question q) {
        QuestionResult qr = new QuestionResult();

        // Add the Question to the QuestionResult.
        qr.setQuestion(q);

        this.showMessage("Question");
        this.showDivisor();

        // Ask user for their answer to the question and store it in the QuestionResult object.
        qr.setUserAnswer(this.promptForDataValue(q.getQuestion(), 0, true));

        // Display as a percentage how accurate the user was to the actual answer.

        this.lineBreak();
        this.showMessage("Your Answer:");
        this.showMessage(qr.getUserAnswer());
        this.lineBreak();
        this.showMessage("Actual Answer:");
        this.showMessage(q.getAnswer());
        this.lineBreak();
        this.showMessage("Accuracy: " + qr.getAccuracy());
        this.lineBreak();

        return qr;
    }
   
    // Asks user for a string of text and return it. Needs a prompt message as well as a maximum amount of characters
    // allowed.
    private String promptForDataValue (String promptMessage, int maxChars, boolean newLine) {
        while (true) {
            // Show prompt.
            System.out.print(promptMessage);

            if (newLine) this.lineBreak();

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

    // Displays a divider (using dashes)
    private void showDivisor () {
        this.showMessage("-------------------------------------------------");
    }

    // Displays a line break
    private void lineBreak() {
        this.showMessage("");
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

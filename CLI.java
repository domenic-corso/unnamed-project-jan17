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
                    this.showAddNewSetMenu();
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
        // QS to progressively add data to.
        QuestionSet questionSet = new QuestionSet();

        this.displayMenuOptionTitle("Add new Question Set");

        // Ask user for title of QS.
        questionSet.setTitle(this.promptForDataValue("Title of Question Set: ", QuestionSet.MAX_TITLE_LEN));

        // Ask user for the creator name (their name) of QS.
        questionSet.setCreatorName(this.promptForDataValue("Enter your name: ", QuestionSet.MAX_CREATOR_NAME_LEN));

        // Add an extra line break to give room for next prompt
        System.out.println();
        
        Question question = new Question();
        
        String questionInp, questionAnswer;
        
        while(true){
        //Prompt Question
        System.out.println("\n[Enter 'exit' to finish]");
        questionInp = promptForDataValue("Enter Question: ", Question.MAX_QUESTION_ANSWER_LEN);
    
        //If question is equal to exit break while loop
        if(questionInp.equals("exit")){ break; }
        
        //Set the Question
        question.setQuestion(questionInp);
        
        //Store the question in the Array 
    	questionSet.addQuestion(question);
    	
    	//Ask user for answer
    	question.setAnswer(promptForDataValue("Enter Answer for Question: ", Question.MAX_QUESTION_ANSWER_LEN));
    	
    	//Store answer for question here // 
    
    	//Tracker of questions
    	System.out.println("\nCurrent number of questions: " + questionSet.getNumQuestions() + "/" + Application.MAX_QUESTIONS_PER_SET);
    	System.out.println("\nCurrent Questions: ");
    	questionSet.listQuestions();
        
        }
    	
    	// Finally once all data has been gathered, return it.
        return questionSet;
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
            if (userInp.length() > maxChars) {
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

    // Takes in a message and prints it out in the form of an error
    private void showError (String message) {
        System.out.println("ERR: " + message);
    }
}

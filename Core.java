
// The 'Core' class contains methods that perform the main functions of the application.
final public class Core {
    public static void createQuestionSet () {
        // Get the data for the new QuestionSet using the UI.
        QuestionSet newQS = App.userIfce.showAddNewSetMenu();

        // Alert the user that their QuestionSet has been successfully created.
        App.userIfce.alertUser("Your Question Set '" + newQS.getTitle() + "' has been successfully created.");
        
        // Alerts the user the date and time on which their QuestionSet was created.
        App.userIfce.alertUser("'" + newQS.getTitle() + "' created on: " + newQS.getDate());

        // Find out if user would like to begin testing themselves right away
        if (App.userIfce.promptYesOrNo("Would you like to test yourself now?")) {
            beginTest(newQS);
        }
    }

    // Accepts a QS and goes through each question, prompting the user for the answer.
    public static void beginTest (QuestionSet qs) {
        Question[] shuffledQuestions = qs.getShuffledQuestions();
        App.userIfce.beginTest(shuffledQuestions, qs.getTitle());
        
        QuestionResult qr = new QuestionResult();
   
        //Go through the array and check if a question is correct based on the accuracy being greater than a certain number
        for(int i = 0; i < shuffledQuestions.length; i++){
        	if(qr.isCorrect() == true){
        	}
        }
    }
}

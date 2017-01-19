
// The 'Core' class contains methods that perform the main functions of the application.
final public class Core {
    public static void createQuestionSet () {
        // Get the data for the new QuestionSet using the UI.
        QuestionSet newQS = App.userIfce.showAddNewSetMenu();

        // Alert the user that their QuestionSet has been successfully created.
        App.userIfce.alertUser("Your Question Set '" + newQS.getTitle() + "' has been successfully created.");
        
        // Alerts the user the date and time on which their QuestionSet was created.
        App.userIfce.alertUser(newQS.getTitle() + " Created On: " + newQS.setDate());

        newQS.debugDetails();

        // Find out if user would like to begin testing themselves right away
        if (App.userIfce.promptYesOrNo("Would you like to test yourself now?")) {
            beginTest(newQS);
        }
    }

    // Accepts a QS and goes through each question, prompting the user for the answer.
    private static void beginTest (QuestionSet qs) {
        Question[] shuffledQuestions = qs.getShuffledQuestions();
        App.userIfce.alertUser("Beginning Test '" + qs.getTitle() + "'.");


    }
}

import java.util.Scanner;

public class CLI extends UI {
	Scanner sc = new Scanner(System.in);
    public int showMainMenu () {
    	while(true){
        System.out.println(WELCOME_MESSAGE);
        System.out.println("0. New Question Set");
        System.out.println("1. Import Existing File");
        System.out.println("2. Exit\n");
        
        // User input 
        int userInput = sc.nextInt();
        
        switch(userInput){
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
        return userInput;
    	}
    }
}

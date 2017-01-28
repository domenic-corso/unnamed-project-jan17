import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Date;
import java.util.Random;

public class QuestionSet {
    // Useful constants
    static final public int MAX_TITLE_LEN = 30;
    static final public int MAX_CREATOR_NAME_LEN = 20;

    // XML and file type related constants
    static final private String FILE_EXTENSION = "quizx";
    static final private String ROOT_ELEM_NAME = "QuestionSet";
    static final private String TITLE_ELEM_NAME = "title";
    static final private String CREATOR_NAME_ELEM_NAME = "creator_name";
    static final private String DATE_CREATED_ELEM_NAME = "date_created";
    static final private String QUESTIONS_ELEM_NAME = "questions";
    static final private String QUESTION_ELEM_NAME = "question";
    static final private String QUES_TEXT_NAME = "question_text";
    static final private String ANS_TEXT_NAME = "question_answer";

    // Instance variables
    private String title;
    private String creatorName;
    private Date dateCreated;
    private Question[] questions = new Question[App.MAX_QUESTIONS_PER_SET];
    private int numQuestions;

    public QuestionSet () {
        this.numQuestions = 0;
    }

    // --- GETTER METHODS ---
    public String getTitle () { return this.title; }

    public String getCreatorName () { return this.creatorName; }

    public Question[] getQuestions () { return this.questions; }

    public int getNumQuestions () { return this.numQuestions; }
    
    public Date getDate () { return this.dateCreated; }

    // Returns a shuffled version of the Questions' array.
    public Question[] getShuffledQuestions () {
        // Create new empty array of Questions' which will be filled with random Questions of the original array.
        Question[] shuffled = new Question[this.numQuestions];

        // Get an integer array containing random distinct values from 0 to this.numQuestions (non-exclusive)
        // For example, if this.numQuestions was 4, this COULD equal {3,0,1,2}
        // For example, if this.numQuestions was 9, this COULD equal {5,2,3,8,7,1,0,4,6}
        int[] randomIndexes = new Random().ints(0, this.numQuestions).distinct().limit(this.numQuestions).toArray();

        // Loop through the randomly generated indexes, and progressively add Questions to the shuffled array based
        // on the randomness of the generated indexes.
        for (int i = 0; i < randomIndexes.length; i++) {
            shuffled[i] = this.questions[randomIndexes[i]];
        }

        // Finally, return the shuffled array.
        return shuffled;
    }

    // Add a Question to array of Questions
    public void addQuestion (Question question) {
        // Cancel if the maximum number of questions has been reached.
        // Note that this should never really be greater than, could leave it as '=='.
        if (this.numQuestions >= App.MAX_QUESTIONS_PER_SET) return;
        this.questions[this.numQuestions++] = question;
    }

    // --- SETTER METHODS ---
    public void setTitle (String title) {
        this.title = title;
    }

    public void setCreatorName (String creatorName) {
        this.creatorName = creatorName;
    }

    public void setDate () {
    	this.dateCreated = new Date();
    }

    // Represents this QuestionSet as an XML Document and returns the Document.
    // Code guide: https://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
    public Document getAsXML () {
        Document document;
        Element rootElem, titleElem, creatorNameElem, dateCreatedElem, questionsElem;
        Element questionElem, quesTextElem, ansTextElem;
        Text tempText;

        // Try to create a XML Document.
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (Exception e) {
            App.userIfce.showError(e.getMessage());
            return null;
        }

        // Root element.
        rootElem = document.createElement(ROOT_ELEM_NAME);
        document.appendChild(rootElem);

        // Title
        titleElem = document.createElement(TITLE_ELEM_NAME);
        tempText = document.createTextNode(this.title);

        titleElem.appendChild(tempText);
        rootElem.appendChild(titleElem);

        // Creator Name
        creatorNameElem = document.createElement(CREATOR_NAME_ELEM_NAME);
        tempText = document.createTextNode(this.creatorName);

        creatorNameElem.appendChild(tempText);
        rootElem.appendChild(creatorNameElem);

        // Date Created
        dateCreatedElem = document.createElement(DATE_CREATED_ELEM_NAME);
        tempText = document.createTextNode(this.dateCreated.toString());

        dateCreatedElem.appendChild(tempText);
        rootElem.appendChild(dateCreatedElem);

        // All the Questions
        questionsElem = document.createElement(QUESTIONS_ELEM_NAME);

        Question q;
        for (int i = 0; i < this.numQuestions; i++) {
            q = this.questions[i];

            // A single <question> element
            questionElem = document.createElement(QUESTION_ELEM_NAME);

            // A single <question_text>, child of <question>
            quesTextElem = document.createElement(QUES_TEXT_NAME);
            tempText = document.createTextNode(q.getQuestion());
            quesTextElem.appendChild(tempText);

            // A single <question_answer>, child of <question>
            ansTextElem = document.createElement(ANS_TEXT_NAME);
            tempText = document.createTextNode(q.getAnswer());
            ansTextElem.appendChild(tempText);

            // Append all where needed
            questionElem.appendChild(quesTextElem);
            questionElem.appendChild(ansTextElem);
            questionsElem.appendChild(questionElem);
        }

        rootElem.appendChild(questionsElem);

        // This should NOT be here, gotta seperate it into a seperate method later on
        // Write XML to file (or console if debugging).
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            // The output XML should be indented and readable.
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("C:/Users/Domenic/Desktop/test." + FILE_EXTENSION));

            // Write data to file/console.
            transformer.transform(source, result);
        } catch (Exception e) {
            App.userIfce.showError(e.getMessage());
            return null;
        }

        return document;
    }

    public void debugDetails () {
        System.out.println("---- Question Set Details (Debugging) ----\n");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Creator: " + this.getCreatorName());
        System.out.println("Date: " + this.dateCreated.toString());
        System.out.println("Questions:");

        for (Question q : this.getQuestions()) {
            if (q == null) continue;
            q.debugDetails();
        }

        System.out.println("\n---- End Question Set Details ----");
    }
    
    // Method to show a list of all the questions
    public void listQuestions () {
        if  (numQuestions == 0) {
            System.out.println("No questions!");
            return;
        }

        for (int i = 0; i < numQuestions; i++) {
            System.out.println("Question #" + (i + 1) + ": " + questions[i].getQuestion());
        }
    }
}

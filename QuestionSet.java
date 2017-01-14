public class QuestionSet {
    private String name;
    private String creatorName;

    public QuestionSet () {}

    public String getName () { return this.name; }

    public String getCreatorName () { return this.creatorName; }

    public void setName (String name) { this.name = name; }

    public void setCreatorName (String creatorName) { this.creatorName = creatorName; }

    public void debugDetails () {
        System.out.println("---- Question Set Details (Debugging) ----\n");
        System.out.println("Name: " + this.getName());
        System.out.println("\n---- End Question Set Details ----");
    }
}

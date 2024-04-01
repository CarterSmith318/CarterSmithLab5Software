package Lab5;

public class Part1 {
    // The static variable that stores the singleton instance
    private static Part1 instance;

    // Private constructor 
    private Part1() {
    }

    // Public method to access the singleton instance
    public static Part1 getInstance() {
        // If the instance is not created yet, create a new one
        if (instance == null) {
            instance = new Part1();
        }
        return instance;
    }

    // A sample method to demonstrate the singleton
    public void showMessage(){
        System.out.println("Hello, I am a Singleton!");
    }

    // Main method to test the Singleton pattern
    public static void main(String[] args) {
        // Get the only object available
        Part1 singleton = Part1.getInstance();

        // Show the message
        singleton.showMessage();
    }
}

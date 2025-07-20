package Prac.twoDimenstional;
class GreetingService {
    public String getGreetingPhrase() {
        // Imagine this does some work to decide the phrase
        System.out.println("GreetingService: Providing phrase...");
        // Hardcoded for simplicity
        return "Hello";
    }
}
// 2. The Untestable Class (Greeter_Untestable)
// Java
public class Greeter_Untestable {

    GreetingService service = new GreetingService();
    String phrase = service.getGreetingPhrase();
    public String greetUser(String userName) {
        
        

        // Input validation
        if (userName == null || userName.trim().isEmpty()) {
            System.err.println("Error: User name cannot be empty.");
            return "Error: Invalid user name.";
        }
        // Problem: Dependency is created directly inside the method.
        // Every time greetUser runs, a new GreetingService is made.
       
       
        // Combine phrase and username
        String finalGreeting = phrase + ", " + userName.trim() + "!";
        System.out.println("Greeter: Generated greeting: " + finalGreeting);
        return finalGreeting;
    }
    // Example Usage (not a test)
    public static void main(String[] args) {
        Greeter_Untestable greeter = new Greeter_Untestable();
        String greeting1 = greeter.greetUser("Alice");
        System.out.println("Main: " + greeting1); // Will always use "Hello" from the real GreetingService
        System.out.println("---");
        String greeting2 = greeter.greetUser("  Bob  "); // Test trimming
        System.out.println("Main: " + greeting2);
        System.out.println("---");
        String greeting3 = greeter.greetUser(""); // Test invalid input
        System.out.println("Main: " + greeting3);
    }
}

//howkeye quiver 
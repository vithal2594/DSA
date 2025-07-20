package exceptions;

// Custom Checked Exception (not public)
class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super();
    }
    public InvalidAgeException(String message) {
        super(message);
    }
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidAgeException(Throwable cause) {
        super(cause);
    }
}

// Demo class (not public)
class CheckedExceptionDemo {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is not valid. Age must be between 0 and 120.");
        }
        System.out.println("Age " + age + " is valid.");
    }

    public static void main(String[] args) {
        try {
            validateAge(25);
            validateAge(-5);
            validateAge(150);
        } catch (InvalidAgeException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            validateAge(70);
            validateAge(10);
        } catch (InvalidAgeException e) {
            System.err.println("Another Error: " + e.getMessage());
        }
    }
}
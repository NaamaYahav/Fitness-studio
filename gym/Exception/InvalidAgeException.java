package gym.Exception;
/**
 * Custom exception class that represents an error when a client is not old enough to register.
 *
 * This exception is thrown when a client attempts to register for the gym but does not meet the
 * minimum age requirement (18 years or older).
 */
public class InvalidAgeException extends RuntimeException{
    /**
     * Constructor that creates a new instance of the exception with an error message.
     * The message indicates that the client must be at least 18 years old to register.
     */
    public InvalidAgeException(){
        super("Error: Client must be at least 18 years old to register");
    }

    /**
     * @return The detail message string of the exception, which explains why this exception was thrown.
     */
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}

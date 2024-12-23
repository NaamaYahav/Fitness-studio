package gym.Exception;
/**
 * Custom exception class that represents an error when an instructor is not qualified
 * to conduct a particular type of session.
 *
 * This exception is thrown when an instructor attempts to lead a session or lesson
 * that they are not certified or qualified to conduct.
 */
public class InstructorNotQualifiedException extends RuntimeException {
    /**
     * Constructor that creates a new instance of the exception with an error message.
     * The message indicates that the instructor is not qualified to conduct the session.
     */
    public InstructorNotQualifiedException(){
        super("Error: Instructor is not qualified to conduct this session type.");
    }
    /**
     * @return The detail message string of the exception, which explains why this exception was thrown.
     */
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}

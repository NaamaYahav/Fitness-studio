package gym.Exception;

import gym.customers.Client;
/**
 * Custom exception class that represents the error when a client is already registered.
 * This exception is thrown when a client attempts to register for a gym service
 * while already being registered, either for the gym or for a specific lesson.
 *
 */
public class DuplicateClientException extends RuntimeException {
    /**
     *Constructor that creates a new instance of the exception with an error message.
     * The message indicates that the client is already registered.
     */
    public DuplicateClientException(){
        super("Error: The client is already registered");
    }
    /**
     * Constructor that creates a new instance of the exception with a custom error message.
     * This constructor is used when the client attempts to register for a lesson they are already enrolled in.
     *
     * @param client The client object who is attempting to register for a lesson.
     */
    public DuplicateClientException(Client client){
        super("Error: The client is already registered for this lesson");
    }

    /**
     * @return The detail message string of the exception, which provides information about why this exception was thrown.
     */
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}

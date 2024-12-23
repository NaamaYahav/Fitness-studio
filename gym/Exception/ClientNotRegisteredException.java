package gym.Exception;

import gym.customers.Client;
/**
 * Custom exception class that represents the error when a client is not registered with the gym
 * and attempts to enroll in lessons or unregister.
 *
 * This exception is thrown when a client who is not registered attempts to perform actions that require
 * a valid gym registration, such as enrolling in lessons or unregistering from the gym.
 */

public class ClientNotRegisteredException extends RuntimeException {
    /**
     * Constructor that creates a new instance of the exception with an error message.
     * The message indicates that the client is not registered and cannot enroll in lessons.
     */
    public ClientNotRegisteredException(){
        super("Error: The client is not registered with the gym and cannot enroll in lessons");
    }
    /**
     * Constructor that creates a new instance of the exception with a custom error message.
     * This constructor is used when the client attempts to unregister without being registered first.
     *
     * @param client The client object who is attempting to unregister or enroll.
     */
    public ClientNotRegisteredException(Client client) {
        super("Error: Registration is required before attempting to unregister");
    }
    /**
     * Gets the detail message of the exception.
     * In this case, it returns the message set by the constructor.
     *
     * @return the detail message string of the exception
     */
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}

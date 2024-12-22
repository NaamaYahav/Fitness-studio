package gym.Exception;

import gym.customers.Client;

public class DuplicateClientException extends RuntimeException {
    public DuplicateClientException(){
        super("Error: The client is already registered");
    }
    public DuplicateClientException(Client client){
        super("Error: The client is already registered for this lesson");
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}

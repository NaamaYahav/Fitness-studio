package gym.Exception;

import gym.customers.Client;

public class ClientNotRegisteredException extends RuntimeException {
    public ClientNotRegisteredException(){
        super("Error: The client is not registered with the gym and cannot enroll in lessons");
    }
    public ClientNotRegisteredException(Client client) {
        super("Error: Registration is required before attempting to unregister");
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}

package gym.customers;

import gym.management.Member;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a client of the gym who extends the Person class and implements the Member interface.
 * The Client class includes functionality for creating clients, managing notifications, and handling updates.
 */
public class Client extends Person implements Member {
    private  List<String> messages; // List to store notifications or messages for the client
    /**
     * Private constructor to create a Client object based on an existing Person object.
     *
     * @param person the Person object to base the Client on
     */
    private Client(Person person){
        super(person);
        messages=new ArrayList<>();  // Initialize the messages list
    }
    /**
     * Factory method to create a new Client instance.
     *
     * @param p the Person object to be converted into a Client
     * @return a new Client instance
     */
    public static Client creatClient(Person p){
        return new Client(p);
    }
    /**
     * Retrieves all notifications for the client as a formatted string.
     *
     * @return a string representation of the client's notifications
     */
    public String getNotifications(){
        String string="[";
        for (int i =0; i<messages.size();i++){
            if (i<messages.size()-1){
           string+=messages.get(i)+", ";}
            else string+=messages.get(i)+"]";
        }
        return string;
    }
    /**
     * Updates the client's message list with a new notification.
     *
     * @param message the notification message to add
     */
    @Override
    public void update(String message) {
            this.messages.add(message);
    }
}

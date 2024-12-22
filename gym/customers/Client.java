package gym.customers;

import gym.management.Message;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Message {
    private  List<String> messages;
    private Client(Person person){
        super(person);
        messages=new ArrayList<>();
    }
    public static Client creatClient(Person p){
        return new Client(p);
    }
    public String getNotifications(){
        String string="[";
        for (int i =0; i<messages.size();i++){
            if (i<messages.size()-1){
           string+=messages.get(i)+", ";}
            else string+=messages.get(i)+"]";
        }
        return string;
    }
    @Override
    public void update(String message) {
            this.messages.add(message);
    }
}

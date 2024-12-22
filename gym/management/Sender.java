package gym.management;

import gym.customers.Client;

import java.util.ArrayList;
import java.util.List;

public abstract class Sender {
    private final List<Client> members = new ArrayList<>();

    public void notifyMembers(String newsletter){
        for (Client client: members){
            client.update(newsletter);
        }
    }
}

package gym.management.Sessions;

import gym.customers.Person;
import gym.management.ForumType;
import gym.management.Instructor;

import java.util.List;

public class NinjaSession extends Session {
    private final int price=150;
    private final int numOfParticipants=5;
    public NinjaSession(String date, ForumType forumType, Instructor instructor){
        super(SessionType.Ninja,date,forumType,instructor);
    }

    @Override
    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public SessionType getSessionType() {
        return SessionType.Ninja;
    }
}

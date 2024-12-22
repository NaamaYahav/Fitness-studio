package gym.management.Sessions;

import gym.customers.Person;
import gym.management.ForumType;
import gym.management.Instructor;

import java.util.List;

public class MachinePilatesSession extends Session {
    private final int price=80;
    private final int numOfParticipants=10;
    public MachinePilatesSession(String date, ForumType forumType, Instructor instructor){
        super(SessionType.MachinePilates,date,forumType,instructor);
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
        return SessionType.MachinePilates;
    }
}

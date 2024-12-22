package gym.management.Sessions;

import gym.customers.Person;
import gym.management.ForumType;
import gym.management.Instructor;

import java.util.List;

public class PilatesSession extends Session{
    private final int price=60 ;
    private final int numOfParticipants= 30;

    public PilatesSession(String date, ForumType forumType, Instructor instructor){
        super(SessionType.Pilates,date,forumType,instructor);
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
        return SessionType.Pilates;
    }

}

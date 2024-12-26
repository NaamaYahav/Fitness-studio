package gym.management.Sessions;

import gym.management.ForumType;
import gym.management.Instructor;
import gym.management.Session;

public class ThaiBoxingSession extends Session {
    private final int price=100;
    private final int numOfParticipants=20;
    public ThaiBoxingSession(String date, ForumType forumType, Instructor instructor){
        super(SessionType.ThaiBoxing,date,forumType,instructor);
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
        return SessionType.ThaiBoxing;
    }

}

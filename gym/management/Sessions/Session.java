package gym.management.Sessions;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.ForumType;
import gym.management.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public abstract class Session {
    private SessionType sessionType;
    private String date;
    private ForumType f;
    private Instructor instructor;
    private List<Client> participants;

    protected Session(SessionType sessionType, String date, ForumType f, Instructor instructor){
        this.sessionType=sessionType;
        this.date=date;
        this.f=f;
        this.instructor=instructor;
        participants=new ArrayList<>();
    }
    public static Session creatSession(SessionType sessionType, String date, ForumType f, Instructor instructor)  {
        switch (sessionType){
            case Pilates:
                return new PilatesSession(date,f,instructor);
            case MachinePilates:
                return new MachinePilatesSession(date,f,instructor);
            case Ninja:
                return new NinjaSession(date,f,instructor);
            case ThaiBoxing:
                return new ThaiBoxingSession(date,f,instructor);
            default:
                throw new IllegalArgumentException("Invalid session type");
        }
    }
    public boolean isRegisted(Client client) {
      if (participants.contains(client)) {
          return true;
      }
      return false;
    }
    public String getDate(){
        return this.date;
    }

    public List<Client> getParticipants(){
        return this.participants;
    }
    public abstract int getNumOfParticipants();
    public abstract int getPrice();
    public abstract SessionType getSessionType();
    public ForumType getF(){
        return this.f;
    }
    public Instructor getInstructor(){
        return this.instructor;
    }

}

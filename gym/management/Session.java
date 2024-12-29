package gym.management;
import gym.customers.Client;
import gym.management.Sessions.*;

import java.util.ArrayList;
import java.util.List;
/**
 * The class represents an abstract base class for different types of gym sessions.
 * It encapsulates common properties and behaviors shared among all session types,
 * such as session type, date, forum type, instructor, and participants.
 */

public abstract class Session {
    private SessionType sessionType;
    private String date;
    private ForumType f;
    private Instructor instructor;
    private List<Client> participants;
    /**
     * Constructs a new {@code Session} with the specified details.
     *
     * @param sessionType the type of the session
     * @param date        the date of the session
     * @param f           the forum type for the session
     * @param instructor  the instructor conducting the session
     */

    protected Session(SessionType sessionType, String date, ForumType f, Instructor instructor){
        this.sessionType=sessionType;
        this.date=date;
        this.f=f;
        this.instructor=instructor;
        participants=new ArrayList<>();
    }
    /**
     * Factory method to create a session based on its type.
     *
     * @param sessionType the type of the session
     * @param date        the date of the session
     * @param f           the forum type for the session
     * @param instructor  the instructor conducting the session
     * @return a new instance of a subclass of {@code Session}
     * @throws IllegalArgumentException if the session type is invalid
     */
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
    /**
     * Checks if the specified client is registered for the session.
     *
     * @param client the client to check
     * @return true if the client is registered, false otherwise
     */
    public boolean isRegisted(Client client) {
      if (participants.contains(client)) {
          return true;
      }
      return false;
    }
    /**
     * Gets the date of the session.
     *
     * @return the session date
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Gets the list of participants registered for the session.
     *
     * @return the list of participants
     */
    protected List<Client> getParticipants() {
        return this.participants;
    }

    /**
     * Gets the number of participants registered for the session.
     *
     * @return the number of participants
     */
    public abstract int getNumOfParticipants();

    /**
     * Gets the price of the session.
     *
     * @return the session price
     */
    public abstract int getPrice();

    /**
     * Gets the type of the session.
     *
     * @return the session type
     */
    public abstract SessionType getSessionType();

    /**
     * Gets the forum type of the session.
     *
     * @return the forum type
     */
    public ForumType getF() {
        return this.f;
    }

    /**
     * Gets the instructor of the session.
     *
     * @return the session instructor
     */
    public Instructor getInstructor() {
        return this.instructor;
    }
}


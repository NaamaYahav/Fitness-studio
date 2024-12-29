package gym.management.Sessions;

import gym.management.ForumType;
import gym.management.Instructor;
import gym.management.Session;
/**
 * Represents a Pilates session at the gym.
 * This session type has a fixed price and maximum number of participants.
 */
public class PilatesSession extends Session {
    private final int price=60 ;
    private final int numOfParticipants= 30;
    /**
     * Constructs a new {@code PilatesSession} with the specified details.
     *
     * @param date        the date of the session
     * @param forumType   the forum type for the session
     * @param instructor  the instructor conducting the session
     */
    public PilatesSession(String date, ForumType forumType, Instructor instructor){
        super(SessionType.Pilates,date,forumType,instructor);
    }
    /**
     * Gets the maximum number of participants allowed in this session.
     *
     * @return the number of participants
     */
    @Override
    public int getNumOfParticipants() {
        return numOfParticipants;
    }
    /**
     * @return the session price
     */
    @Override
    public int getPrice() {
        return price;
    }
    /**
     * Gets the session type.
     *
     */
    @Override
    public SessionType getSessionType() {
        return SessionType.Pilates;
    }

}

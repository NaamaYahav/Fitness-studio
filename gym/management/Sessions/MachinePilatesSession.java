package gym.management.Sessions;

import gym.management.ForumType;
import gym.management.Instructor;
import gym.management.Session;
/**
 * Represents a Machine Pilates session at the gym.
 * This session type has a fixed price and maximum number of participants.
 */

public class MachinePilatesSession extends Session {
    private final int price=80;
    private final int numOfParticipants=10;
    /**
     * Constructs a new {@code MachinePilatesSession} with the specified details.
     *
     * @param date        the date of the session
     * @param forumType   the forum type for the session
     * @param instructor  the instructor conducting the session
     */
    public MachinePilatesSession(String date, ForumType forumType, Instructor instructor){
        super(SessionType.MachinePilates,date,forumType,instructor);
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
        return SessionType.MachinePilates;
    }
}

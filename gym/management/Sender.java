package gym.management;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an abstract class for a newsletter sender in a gym system.
 * The sender manages a list of members (subscribers) who receive updates.
 * It follows the Observer design pattern.
 */
public abstract class Sender {
    // List of members (subscribers) registered to receive updates
    private final List<Member> members = new ArrayList<>();
    /**
     * Registers a member to the sender's list of subscribers.
     *
     * @param member the member to register for updates.
     */
    public void register(Member member) {
        members.add(member);
    }
    /**
     * Unregisters a member from the sender's list of subscribers.
     *
     * @param member the member to remove from the update list.
     */
    public void unregister(Member member) {
        members.remove(member);
    }
    /**
     * Sends a newsletter to all registered members by invoking their update method.
     *
     * @param newsletter the content of the newsletter to be sent.
     */
    public void notifyMembers(String newsletter){
        for (Member member: members){
            member.update(newsletter); // Notify each member with the provided newsletter
        }
    }
}

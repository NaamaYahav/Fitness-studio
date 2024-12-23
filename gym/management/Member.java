package gym.management;
/**
 * Represents a subscriber (member) in the notification system.
 * Classes implementing this interface will receive updates (newsletter)
 * Ths class is a part of the Observer design pattern.
 */
public interface Member {
    /**
     * Method to update the member with a newsletter or message.
     *
     * @param newsletter the message or newsletter content to send.
     */
    void update(String newsletter);
}

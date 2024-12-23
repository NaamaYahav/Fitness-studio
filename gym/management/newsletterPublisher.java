package gym.management;
/**
 * A publisher responsible for managing and sending newsletters to registered members.
 * Inherits the basic notification functionality from the Sender class.
 * This class follows the Observer design pattern.
 */
public class newsletterPublisher extends Sender{
    /**
     * Sends a newsletter to all registered members.
     *
     * @param content the content of the newsletter to send.
     */
    public void sendNewsletter(String content) {
        notifyMembers(content);
    }
}

package gym.management;

public class newsletterPublisher extends Sender{
    public void sendNewsletter(String content) {
        String timestamp = java.time.LocalDateTime.now().toString();
        String newsletter = timestamp + " - Newsletter: " + content;
        System.out.println("Sending newsletter: " + newsletter);
        notifyMembers(newsletter);
    }
}

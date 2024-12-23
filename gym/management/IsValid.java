package gym.management;

import gym.customers.Age;
import gym.customers.Client;
import gym.customers.Gender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Utility class for validating client registration and session requirements.
 * Contains static methods to validate various constraints such as age, gender,
 * balance, session capacity, and session timing.
 */
public class IsValid {
    /**
     * Checks if the session is full.
     *
     * @return 0 if there is space, -1 if the session is full.
     */
    public static int isNotFull(int a, int b){
        if ((a+1)>b){
            String s="Failed registration: No available spots for session";
            HistoryActions.addAction(s);
            return -1;
        }
        return 0;
    }
    /**
     * Validates the client's eligibility for a forum based on its type.
     *
     * @return 0 if the client meets the forum's requirements, -1 otherwise.
     */
    public static int validForum(Client client, ForumType f ){
        if (!(f == ForumType.All)) { // Specific forum type checks
            if (f == ForumType.Seniors) {
                if (Age.getAge(client.getBirthDate()) < 65) {
                    String s = "Failed registration: Client doesn't meet the age requirements for this session (Seniors)";
                    HistoryActions.addAction(s);
                    return -1;
                }
            }
            if (f == ForumType.Male) {
                if (client.getGender() != Gender.Male) {
                    String s = "Failed registration: Client's gender doesn't match the session's gender requirements";
                    HistoryActions.addAction(s);
                    return -1;
                }
            }
            if (f == ForumType.Female) {
                if (client.getGender() != Gender.Female) {
                    String s = "Failed registration: Client's gender doesn't match the session's gender requirements";
                    HistoryActions.addAction(s);
                    return -1;
                }
            }
        }
        return 0;
    }
    /**
     * Checks if the client has enough balance for registration.
     *
     * @return 0 if the client has enough balance, -1 otherwise.
     */
    public static int enoughtBalanc(int a, int b){
        if (a-b>=0) return 0;
        else {
            String s="Failed registration: Client doesn't have enough balance";
            HistoryActions.addAction(s);
        }
        return -1;
    }
    /**
     * Checks if the session's date and time are in the future.
     *
     * @param date the session date and time in "dd-MM-yyyy HH:mm" format.
     * @return 0 if the session is in the future, -1 otherwise.
     */
    public static int inTheFuture(String date){
        LocalDateTime localDateTime= LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        if (localDateTime.isAfter(dateTime)){
            String s="Failed registration: Session is not in the future";
            HistoryActions.addAction(s);
            return -1;
        }
        return 0;
    }
}

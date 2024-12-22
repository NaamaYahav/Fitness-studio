package gym.management;

import gym.customers.Age;
import gym.customers.Client;
import gym.customers.Gender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IsValid {
    public static int isNotFull(int a, int b){
        if ((a+1)>b){
            String s="Failed registration: No available spots for session";
            HistoryActions.addAction(s);
            return -1;
        }
        return 0;
    }
    public static int validForum(Client client, ForumType f ){
        if (!(f == ForumType.All)) {
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
    public static int enoughtBalanc(int a, int b){
        if (a-b>=0) return 0;
        else {
            String s="Failed registration: Client doesn't have enough balance";
            HistoryActions.addAction(s);
        }
        return -1;
    }
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

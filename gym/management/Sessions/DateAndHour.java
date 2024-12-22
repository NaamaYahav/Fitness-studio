package gym.management.Sessions;
public class DateAndHour {
    public static String returnDate(String time){
        return time.substring(0,10);
    }
    public static String returnHour(String time){
        return time.substring(11,16);
    }
}

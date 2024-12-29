package gym.management.Sessions;
/**
 * Utility class for extracting date and hour from a timestamp string in "YYYY-MM-DDTHH:MM" format.
 */
public class DateAndHour {
    /**
     * Returns the date portion ("YYYY-MM-DD") of a timestamp.
     *
     * @param time the timestamp string
     * @return the date portion
     */

    public static String returnDate(String time){
        return time.substring(0,10);
    }
    /**
     * Returns the hour portion ("HH:MM") of a timestamp.
     *
     * @param time the timestamp string
     * @return the hour portion
     */
    public static String returnHour(String time){
        return time.substring(11,16);
    }
}

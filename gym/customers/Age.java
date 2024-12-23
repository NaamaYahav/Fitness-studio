package gym.customers;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
/**
 * The Age class provides utility methods for calculating the age of a person
 * based on their birth date.
 */
public class Age {
    /**
     * Calculates the age of a person based on their birth-date.
     *
     * @param birthDateString the birth-date as a string in the format "dd-MM-yyyy".
     * @return the calculated age in years.
     */
    public static int getAge(String birthDateString){
        // Define the date format used for parsing the birth date.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Parse the input string to a LocalDate object.
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        // Get the current date.
        LocalDate today = LocalDate.now();
        // Calculate the period between the birth date and the current date and return the years.
        return Period.between(birthDate, today).getYears();
    }
}

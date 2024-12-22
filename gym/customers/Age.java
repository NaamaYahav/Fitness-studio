package gym.customers;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
public class Age {
    public static int getAge(String birthDateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }
}

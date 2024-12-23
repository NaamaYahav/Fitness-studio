package gym.customers;

import java.util.ArrayList;
import java.util.List;
/**
 * The IsRegisted class provides utility methods to check if a person is already registered as a client.
 */
public class IsRegisted {
    /**
     * Checks if a given person is already registered in the list of members.
     *
     * @param person  the person to check.
     * @param members the list of registered clients.
     * @return true if the person is registered, false otherwise.
     */
    public static boolean checkRegisted(Person person, List<Client> members){
        // Checks if the members list contains the given person.
        return members.contains(person);

    }
}

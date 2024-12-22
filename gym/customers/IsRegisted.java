package gym.customers;

import java.util.ArrayList;
import java.util.List;

public class IsRegisted {
    public static boolean checkRegisted(Person person, List<Client> members){
        return members.contains(person);

    }
}

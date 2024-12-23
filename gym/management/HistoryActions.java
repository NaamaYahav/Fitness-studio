package gym.management;

import java.util.ArrayList;
/**
 * The HistoryActions class manages a history of actions performed within the gym management system.
 * It allows adding actions to the history and retrieving the complete history of actions.
 */
public class HistoryActions {
    // A static list to store the history of actions as strings.
    private static ArrayList<String> history = new ArrayList<>();

    /**
     * Adds a new action to the history.
     *
     * @param s the action description to be added to the history.
     */
    public static void addAction(String s) {
        history.add(s);
    }

    /**
     * Retrieves the history of all recorded actions.
     *
     * @return an ArrayList containing the descriptions of all actions.
     */
    public static ArrayList<String> getHistory() {
        return history;
    }
}

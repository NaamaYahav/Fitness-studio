package gym.management;

import java.util.ArrayList;

public class HistoryActions {
    private static ArrayList<String> history = new ArrayList<>();
    public static void addAction(String s){
        history.add(s);
    }
    public static ArrayList<String> getHistory(){
        return history;
    }
}

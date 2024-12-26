package gym.management;

import gym.customers.Age;
import gym.customers.Client;
import gym.customers.Person;

import java.util.ArrayList;

/**
 * This class represents a Gym management system. It is implemented as a singleton.
 */
public class Gym {
    private String name; // Name of the gym
    private static Gym instance; // Singleton instance of the Gym
    private Secretary currentSecretary; // Current secretary working at the gym

    /**
     * Private constructor to prevent direct instantiation.
     */
    private Gym() {
    }
    /**
     * Returns the singleton instance of the Gym. If it doesn't exist, it creates a new one.
     *
     * @return the singleton instance of Gym
     */
    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }
    /**
     * Sets the name of the gym.
     *
     * @param name the name of the gym
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Assigns a new secretary to the gym. If a secretary already exists, their access is revoked.
     *
     * @param p      the person to be assigned as secretary
     * @param salary the monthly salary of the secretary
     */
    public void setSecretary(Person p, int salary) {
        if (getSecretary() != null) {
            getSecretary().setAccess(false); // Revoke access for the previous secretary
        }
        this.currentSecretary = new Secretary(p, salary);
        String s = "A new secretary has started working at the gym: " + p.getName();
        HistoryActions.addAction(s); // Log the action
    }
    /**
     * Retrieves the current secretary of the gym.
     *
     * @return the current Secretary object
     */
    public Secretary getSecretary() {
        return this.currentSecretary;
    }
    /**
     * Generates a string representation of the gym, including details of the gym, secretary, clients, employees, and sessions.
     *
     * @return a string containing all gym details
     */
    @Override
    public String toString() {
        String gymData = "Gym Name: " + name + "\n" +
                "Gym Secretary: ID: " + getSecretary().getID() + " | Name: " + getSecretary().getName() + " | Gender: " + getSecretary().getGender() + " | Birthday: " + getSecretary().getBirthDate() +
                " | Age: " + Age.getAge(getSecretary().getBirthDate()) + " | Balance: " + getSecretary().getBalance() + " | Role: Secretary | Salary per Month: " + getSecretary().getSalary() + "\n" +
                "Gym Balance: " + getSecretary().getGymBalance() + "\n";
        String clientsData = "\nClients Data:\n";
        for (Client client : getSecretary().getMembers()) {
            String info = "ID: " + client.getID() + " | Name: " + client.getName() + " | Gender: " + client.getGender() +
                    " | Birthday: " + client.getBirthDate() + " | Age: " + Age.getAge(client.getBirthDate()) + " | Balance: " + client.getBalance() + "\n";
            clientsData += info;
        }
        String employeesData = "\nEmployees Data:\n";
        for (Instructor instructor : getSecretary().getInstructors()) {
            String info = "ID: " + instructor.getID() + " | Name: " + instructor.getName() + " | Gender: " + instructor.getGender() +
                    " | Birthday: " + instructor.getBirthDate() + " | Age: " + Age.getAge(instructor.getBirthDate()) + " | Balance: " + instructor.getBalance() +
                    " | Role: Instructor | Salary per Hour: " + instructor.getSalary() + " | Certified Classes: " + instructor.getSessions() + "\n";
            employeesData += info;
        }
        String s1 = "ID: " + getSecretary().getID() + " | Name: " + getSecretary().getName() + " | Gender: " + getSecretary().getGender() + " | Birthday: " + getSecretary().getBirthDate() +
                " | Age: " + Age.getAge(getSecretary().getBirthDate()) + " | Balance: " + getSecretary().getBalance() + " | Role: Secretary | Salary per Month: " + getSecretary().getSalary() + "\n";
        employeesData += s1;
        String sessionsData = "\nSessions Data:\n";
        ArrayList<Session> s = getSecretary().getAllSessions();
        for (int i = 0; i < s.size(); i++) {
            if (i == s.size() - 1) {
                String info = "Session Type: " + s.get(i).getSessionType() + " | Date: " + s.get(i).getDate() + " | Forum: " + s.get(i).getF() + " | Instructor: " +
                        s.get(i).getInstructor().getName() + " | Participants: " + s.get(i).getParticipants().size() + "/" + s.get(i).getNumOfParticipants();
                sessionsData += info;
            } else {
                String info = "Session Type: " + s.get(i).getSessionType() + " | Date: " + s.get(i).getDate() + " | Forum: " + s.get(i).getF() + " | Instructor: " +
                        s.get(i).getInstructor().getName() + " | Participants: " + s.get(i).getParticipants().size() + "/" + s.get(i).getNumOfParticipants() + "\n";
                sessionsData += info;
            }
        }
        String all = gymData + clientsData + employeesData + sessionsData;
        return all;
    }
}

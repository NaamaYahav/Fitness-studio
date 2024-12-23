package gym.management;

import gym.customers.Person;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;
/**
 * Represents an instructor in the gym system.
 * Instructors are derived from the Person class and have additional attributes such as salary, session types,
 * and the number of sessions they have conducted.
 */
public class Instructor extends Person{
//    private Person p;
    private int salary; // Instructor's salary per session
    private ArrayList<SessionType> arr; // List of session types the instructor can teach
    private int countSession; // Number of sessions conducted by the instructor
    /**
     * Constructs a new Instructor with the specified details.
     * extends
     * @param p      the person details for the instructor.
     * @param salary the salary of the instructor per session.
     * @param arr    the list of session types the instructor can teach.
     */
    protected Instructor(Person p, int salary, ArrayList<SessionType> arr){
        super(p);
        this.salary=salary;
        this.arr=arr;
    }
    public ArrayList<SessionType> getArr(){
        return this.arr;
    }
    public int getCountSession(){
        return this.countSession;
    }
    public void setCountSession(int count){
        this.countSession=count;
    }
    public int getSalary(){
        return this.salary;
    }
    public String getSessions(){
        String session="";
       for (int i=0;i<arr.size();i++){
           if (i==arr.size()-1){
               session+=arr.get(i);
           }
           else {
               session += arr.get(i) + ", ";
           }
       }
       return session;
    }
}

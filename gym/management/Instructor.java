package gym.management;

import gym.customers.Person;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

public class Instructor extends Person{
//    private Person p;
    private int salary;
    private ArrayList<SessionType> arr;
    private int countSession;

    protected Instructor(Person p, int salary, ArrayList<SessionType> arr){
        super(p);
//        this.p=p;
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

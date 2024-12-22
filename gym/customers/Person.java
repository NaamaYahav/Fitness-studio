package gym.customers;

import java.util.ArrayList;

public class Person {
    private String name;
    private int balance;
    private Gender gender;
    private String birthDate;
    final private int ID;
    private static int adder;
    private static ArrayList<Person> allPerson=new ArrayList<>();

    public Person(String name, int balance, Gender gender, String date) {
        this.name= name;
        this.balance=balance;
        this.gender=gender;
        this.birthDate=date;
        this.ID= 1110+ ++adder;
        allPerson.add(this);
    }
    public static ArrayList<Person> getAllPerson(){
        return allPerson;
    }
    public Person(Person person){
        this.name=person.name;
        this.balance=person.balance;
        this.gender=person.gender;
        this.birthDate=person.birthDate;
        this.ID= person.ID;
        allPerson.add(this);
    }
    public String getName(){
        return this.name;
    }
    public String getBirthDate(){
        return this.birthDate;
    }
    public int getID(){
        return this.ID;
    }
    public int getBalance(){
        return this.balance;
    }
    public void setBalance(int balance){
        this.balance=balance;
    }
    @Override
    public boolean equals(Object object){
        return ((Person)object).getID()==this.getID();
    }
    public Gender getGender(){
        return this.gender;
    }
}

package gym.customers;

import java.util.ArrayList;
/**
 * Represents a person in the gym system.
 * Each person has a unique ID, name, balance, gender, and birth date.
 * A list of all created persons is maintained for tracking.
 */
public class Person {
    private String name;
    private int[] balance= new int[1];
    private Gender gender;
    private String birthDate;
    final private int ID;
    private static int adder; // Counter to generate unique IDs
    /**
     * Constructs a new Person with the specified details.
     *
     * @param name      the name of the person.
     * @param balance   the initial balance of the person.
     * @param gender    the gender of the person.
     * @param date      the birth date of the person in "dd-MM-yyyy" format.
     */
    public Person(String name, int balance, Gender gender, String date) {
        this.name= name;
        this.balance[0]=balance;
        this.gender=gender;
        this.birthDate=date;
        this.ID= 1110+ ++adder; // Generate a unique ID
    }
    /**
     * Constructs a new Person by copying details from another Person object.
     *
     * @param person the person to copy details from.
     */
    public Person(Person person){
        this.name=person.name;
        this.balance=person.balance;
        this.gender=person.gender;
        this.birthDate=person.birthDate;
        this.ID= person.ID; // Keep the same I
    }

    /**
     * @return the name of the person.
     */
    public String getName(){
        return this.name;
    }
    /**
     * @return the birth date in "dd-MM-yyyy" format.
     */
    public String getBirthDate(){
        return this.birthDate;
    }
    /**
     * @return the ID of the person.
     */
    public int getID(){
        return this.ID;
    }
    /**
     * @return the balance of the person.
     */
    public int getBalance(){
        return this.balance[0];
    }
    /**
     * Sets the balance of the person.
     *
     * @param balance the new balance to set.
     */
    public void setBalance(int balance){
        this.balance[0]=balance;
    }
    /**
     * Checks if this person is equal to another object based on the ID.
     *
     * @param object the object to compare with.
     * @return true if the IDs are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object){
        return ((Person)object).getID()==this.getID();
    }
    /**
     * @return the gender of the person.
     */
    public Gender getGender(){
        return this.gender;
    }
}

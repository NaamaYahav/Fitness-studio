package gym.management;

import gym.Exception.*;
import gym.customers.*;
import gym.management.Sessions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 * The Secretary class represents a secretary of the gym who manages clients, instructors, sessions, and gym operations.
 * This class provides methods to register/unregister clients, hire instructors, create sessions, notify members,
 * and manage gym finances such as paying salaries.
 * Only the current secretary can use the methods.
 */
public class Secretary extends Person {
    private Person person; // The person object representing the secretary
    private int salary; // The salary of the secretary
    private boolean hasAccess; // Access control for the secretary's actions
    private static List<Client> members = new ArrayList<>(); // List of all gym members
    private static ArrayList<Session> allSession = new ArrayList<>(); // List of all sessions
    private static List<Instructor> instructors = new ArrayList<>(); // List of all gym instructors
    private static int gymBalance; // The total balance of the gym
    /**
     * Constructor to create a Secretary object.
     *
     * @param person The person object representing the secretary.
     * @param salary The salary of the secretary.
     */
    protected Secretary(Person person, int salary) {
        super(person);
        this.person = person;
        this.salary = salary;
        this.hasAccess = true;
    }
    /**
     * Checks if the secretary has access to perform an action.
     *
     * @param access The access flag to check.
     * @throws NullPointerException if access is denied.
     */
    private void checkAccess(boolean access) {
        if (!access) {
            throw new NullPointerException();
        }
    }
    /**
     * Registers a new client to the gym.
     *
     * @param p The person object representing the client.
     * @return The newly created Client object.
     * @throws InvalidAgeException if the client's age is below 18.
     * @throws DuplicateClientException if the client is already registered.
     */
    public Client registerClient(Person p) {
        checkAccess(hasAccess);
        if (Age.getAge(p.getBirthDate()) < 18) {
            throw new InvalidAgeException();
        }
        if ((IsRegisted.checkRegisted(p, members))) {
            throw new DuplicateClientException();
        }
        Client client = Client.creatClient(p);
        members.add(client);
        String s = "Registered new client: " + client.getName();
        HistoryActions.addAction(s);
        return client;
    }
    /**
     * Unregisters a client from the gym.
     *
     * @param client The client to be unregistered.
     * @throws ClientNotRegisteredException if the client is not registered.
     */
    public void unregisterClient(Client client) {
        checkAccess(hasAccess);
        if (!(IsRegisted.checkRegisted(client, members))) {
            throw new ClientNotRegisteredException(client);
        }
        members.remove(client);
        String s = "Unregistered client: " + client.getName();
        HistoryActions.addAction(s);
    }
    /**
     * Hires a new instructor for the gym.
     *
     * @param person The person object representing the instructor.
     * @param salary The salary of the instructor per hour.
     * @param arr The list of session types the instructor is qualified to teach.
     * @return The newly hired Instructor object.
     */
    public Instructor hireInstructor(Person person, int salary, ArrayList<SessionType> arr) {
        checkAccess(hasAccess);
        Instructor i = new Instructor(person, salary, arr);
        instructors.add(i);
        String s = "Hired new instructor: " + person.getName() + " with salary per hour: " + salary;
        HistoryActions.addAction(s);
        return i;
    }
    /**
     * Creates a new session in the gym.
     *
     * @param type The type of the session.
     * @param date The date and time of the session.
     * @param f The forum type for the session.
     * @param instructor The instructor assigned to the session.
     * @return The newly created Session object.
     * @throws InstructorNotQualifiedException if the instructor is not qualified to teach the session type.
     */
    public Session addSession(SessionType type, String date, ForumType f, Instructor instructor) {
        checkAccess(hasAccess);
        if (!instructor.getArr().contains(type)) {
            throw new InstructorNotQualifiedException();
        }
        Session session = Session.creatSession(type, date, f, instructor);
        allSession.add(session);
        instructor.setCountSession(instructor.getCountSession() + 1);
        String s = "Created new session: " + type + " on " + toLocalTime(date) + " with instructor: " + instructor.getName();
        HistoryActions.addAction(s);
        return session;
    }
    /**
     * Registers a client to a specific session.
     *
     * @param client The client to register.
     * @param session The session to register the client to.
     * @throws DuplicateClientException if the client is already registered for the session.
     * @throws ClientNotRegisteredException if the client is not a member of the gym.
     * If the session is in the past/ if the client is not matching to the session forum/
     * if the session is full/ if the client doesn't have enough money then it will print an error with registering the client.
     */
    public void registerClientToLesson(Client client, Session session) {
        int flag = 0;
        checkAccess(hasAccess);
        if (session.isRegisted(client)) {
            throw new DuplicateClientException(client);
        }
        if (!members.contains(client)) {
            throw new ClientNotRegisteredException();
        }

        flag = IsValid.inTheFuture(session.getDate()) + IsValid.validForum(client, session.getF()) +
                IsValid.isNotFull(session.getParticipants().size(), session.getNumOfParticipants())
                + IsValid.enoughtBalanc(client.getBalance(), session.getPrice());
        if (flag == 0) {
            session.getParticipants().add(client);
            client.setBalance(client.getBalance() - session.getPrice());
            gymBalance += session.getPrice();
            String s = "Registered client: " + client.getName() + " to session: " + session.getSessionType() + " on " + toLocalTime(session.getDate()) + " for price: " + session.getPrice();
            HistoryActions.addAction(s);
        }
    }
    /**
     * Sends a notification to all participants of a specific session.
     *
     * @param session The session whose participants will be notified.
     * @param message The message to send.
     */
    public void notify(Session session, String message) {
        checkAccess(hasAccess);
        newsletterPublisher newsletterPublisher=new newsletterPublisher();
        for (Client client : session.getParticipants()) {
            newsletterPublisher.register(client);
        }
        newsletterPublisher.sendNewsletter(message);
        String s = "A message was sent to everyone registered for session " +
                session.getSessionType() + " on " + toLocalTime(session.getDate()) + " : " + message;
        HistoryActions.addAction(s);
    }
    /**
     * Sends a notification to all participants of sessions on a specific date.
     *
     * @param date The date of the sessions.
     * @param message The message to send.
     */
    public void notify(String date, String message) {
        checkAccess(hasAccess);
        newsletterPublisher newsletterPublisher=  new newsletterPublisher();
        for (Session session : allSession) {
            if (date.equals(DateAndHour.returnDate(session.getDate()))) {
                for (Client client : session.getParticipants()) {
                    newsletterPublisher.register(client);
                }
            }
        }
        newsletterPublisher.sendNewsletter(message);
        String s = "A message was sent to everyone registered for a session on " + toLocalDateTime(date) + " : " + message;
        HistoryActions.addAction(s);
    }
    /**
     * Sends a notification to all gym clients.
     *
     * @param message The message to send.
     */
    public void notify(String message) {
        newsletterPublisher newsletterPublisher= new newsletterPublisher();
        checkAccess(hasAccess);
        for (Client member : members) {
            newsletterPublisher.register(member);
        }
        newsletterPublisher.sendNewsletter(message);
        String s = "A message was sent to all gym clients: " + message;
        HistoryActions.addAction(s);
    }
    /**
     * Sets the access control for the secretary.
     *
     * @param access The new access control value.
     */
    public void setAccess(boolean access) {
        this.hasAccess = access;
    }
    /**
     * Pays salaries to all instructors and current secretary,  and updates the gym balance accordingly.
     */
    public void paySalaries() {
        checkAccess(hasAccess);
        for (Instructor instructor : instructors) {
            instructor.setBalance(instructor.getBalance()+((instructor.getSalary()) * (instructor.getCountSession())));
            gymBalance -= ((instructor.getSalary()) * (instructor.getCountSession()));
        }
        this.setBalance(this.getBalance()+salary);
        gymBalance -= salary;
        String s = "Salaries have been paid to all employees";
        HistoryActions.addAction(s);
    }
    /**
     * @return The gym balance.
     */
    public int getGymBalance() {
        return gymBalance;
    }
    /**
     * Prints the history of actions performed in the gym.
     */
    public void printActions() {
        checkAccess(hasAccess);
        for (String s : HistoryActions.getHistory()) {
            System.out.println(s);
        }
    }
    /**
     * @return The salary of the secretary.
     */
    public int getSalary() {
        return this.salary;
    }
    /**
     * @return A list of clients registered to the gym.
     */
    protected List<Client> getMembers() {
        return members;
    }
    /**
     * @return A list of instructors working at the gym.
     */
    protected List<Instructor> getInstructors() {
        return instructors;
    }
    /**
     * @return A list of sessions of the gym.
     */
    protected ArrayList<Session> getAllSessions() {
        return allSession;
    }

    private LocalDateTime toLocalTime(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }
    private String toLocalDateTime(String str){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(str, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(outputFormatter);
        return formattedDate;
    }
}

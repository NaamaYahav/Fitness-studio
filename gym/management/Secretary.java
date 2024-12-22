package gym.management;

import gym.Exception.*;
import gym.customers.*;
import gym.management.Sessions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Secretary extends Person {
    private Person person;
    private int salary;
    private boolean hasAccess;
    private static List<Client> members = new ArrayList<>();
    private static ArrayList<Session> allSession = new ArrayList<>();
    private static List<Instructor> instructors = new ArrayList<>();
    private static int gymBalance;

    public Secretary(Person person, int salary) {
        super(person);
        this.person = person;
        this.salary = salary;
        this.hasAccess = true;
    }

    private void checkAccess(boolean access) {
        if (!access) {
            throw new NullPointerException();
        }
    }

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

    public void unregisterClient(Client client) {
        checkAccess(hasAccess);
        if (!(IsRegisted.checkRegisted(client, members))) {
            throw new ClientNotRegisteredException(client);
        }
        members.remove(client);
        String s = "Unregistered client: " + client.getName();
        HistoryActions.addAction(s);
    }

    public Instructor hireInstructor(Person person, int salary, ArrayList<SessionType> arr) {
        checkAccess(hasAccess);
        Instructor i = new Instructor(person, salary, arr);
        instructors.add(i);
        String s = "Hired new instructor: " + person.getName() + " with salary per hour: " + salary;
        HistoryActions.addAction(s);
        return i;
    }

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
            for(Person person1: Person.getAllPerson()){
                if(person1.getID()==client.getID()){
                    person1.setBalance(client.getBalance());
                }
            }
            gymBalance += session.getPrice();
            String s = "Registered client: " + client.getName() + " to session: " + session.getSessionType() + " on " + toLocalTime(session.getDate()) + " for price: " + session.getPrice();
            HistoryActions.addAction(s);
        }
    }

    public void notify(Session session, String message) {
        checkAccess(hasAccess);
        for (Client client : session.getParticipants()) {
            client.update(message);
        }
        String s = "A message was sent to everyone registered for session " +
                session.getSessionType() + " on " + toLocalTime(session.getDate()) + " : " + message;
        HistoryActions.addAction(s);
    }

    public void notify(String date, String message) {
        checkAccess(hasAccess);
        for (Session session : allSession) {
            if (date.equals(DateAndHour.returnDate(session.getDate()))) {
                for (Client client : session.getParticipants()) {
                    client.update(message);
                }
            }
        }
        String s = "A message was sent to everyone registered for a session on " + toLocalDateTime(date) + " : " + message;
        HistoryActions.addAction(s);
    }

    public void notify(String message) {
        checkAccess(hasAccess);
        for (Client member : members) {
            member.update(message);
        }
        String s = "A message was sent to all gym clients: " + message;
        HistoryActions.addAction(s);
    }

    public void setAccess(boolean access) {
        this.hasAccess = access;
    }

    public void paySalaries() {
        checkAccess(hasAccess);
        for (Instructor instructor : instructors) {
            instructor.setBalance(instructor.getBalance()+((instructor.getSalary()) * (instructor.getCountSession())));
            for(Person person1: Person.getAllPerson()){
                if(person1.getID()==instructor.getID()){
                    person1.setBalance(instructor.getBalance());
                }
            }
            gymBalance -= ((instructor.getSalary()) * (instructor.getCountSession()));
        }
        this.setBalance(this.getBalance()+salary);
        gymBalance -= salary;
        String s = "Salaries have been paid to all employees";
        HistoryActions.addAction(s);
    }

    public int getGymBalance() {
        return gymBalance;
    }

    public void printActions() {
        for (String s : HistoryActions.getHistory()) {
            System.out.println(s);
        }
    }

    public int getSalary() {
        return this.salary;
    }

    public List<Client> getMembers() {
        return members;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public ArrayList<Session> getAllSessions() {
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

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Hogwarts {

    //region [ - Fields - ]
    private static ArrayList<Account> accounts;

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    private static ArrayList<Assistant> assistants;

    public static ArrayList<Assistant> getAssistants() {
        return assistants;
    }

    private static ArrayList<Professor> professors;

    public static ArrayList<Professor> getProfessors() {
        return professors;
    }

    private static ArrayList<Student> students;

    public static ArrayList<Student> getStudents() {
        return students;
    }

    private static ArrayList<Course> rawCourses;

    public static ArrayList<Course> getRawCourses() {
        return rawCourses;
    }

    private static ArrayList<Course> courses;

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    private static ArrayList<Professor> requestedProfessors;
    public static ArrayList<Professor> getRequestedProfessors() {
        return requestedProfessors;
    }

    private static ArrayList<Course> requestedCourses;
    public static ArrayList<Course> getRequestedCourses() {
        return requestedCourses;
    }
    //endregion

    //region [ - Constructor - ]
    public Hogwarts() {
        accounts = new ArrayList<>();
        assistants = new ArrayList<>();
        professors = new ArrayList<>();
        requestedProfessors = new ArrayList<>();
        students = new ArrayList<>();
        rawCourses = new ArrayList<>();
        courses = new ArrayList<>();
        requestedCourses = new ArrayList<>();
    }
    //endregion

    //region [ - Methods - ]

    //region [ - addAccount(Account account) - ]
    public static void addAccount(Account account) {
        accounts.add(account);
    }
    //endregion

    //region [ - addAssistant(Assistant assistant) - ]
    public static void addAssistant(Assistant assistant) {
        assistants.add(assistant);
    }
    //endregion

    //region [ - addProfessor(Professor professor) - ]
    public static void addProfessor(Professor professor) {
        professors.add(professor);
    }
    //endregion

    //region [ - addRequestedProfessor(Professor professor) - ]
    public static void addRequestedProfessor(Professor professor) {
        requestedProfessors.add(professor);
    }
    //endregion

    //region [ - addStudent(Student student) - ]
    public static void addStudent(Student student) {
        students.add(student);
    }
    //endregion

    //region [ - addRawCourse(Course rawCourse) - ]
    public static void addRawCourse(Course rawCourse) {
        rawCourses.add(rawCourse);
    }
    //endregion

    //region [ - addCourse(Course course) - ]
    public static void addCourse(Course course) {
        rawCourses.forEach(rc -> {
            if (Objects.equals(rc.getTitle(), course.getTitle())) {
                courses.add(course);
                return;
            }
        });
        rawCourses.add(new Course(course.getTitle()));
    }
    //endregion

    //region [ - removeAccount(Account account) - ]
    public static void removeAccount(Account account) {
        accounts.remove(account);
    }
    //endregion

    //region [ - removeAssistant(Assistant assistant) - ]
    public static void removeAssistant(Assistant assistant) {
        assistants.remove(assistant);
    }
    //endregion

    //region [ - removeProfessor(Professor professor) - ]
    public static void removeProfessor(Professor professor) {
        professors.remove(professor);
    }
    //endregion

    //region [ - removeRequestedProfessor(Professor professor) - ]
    public static void removeRequestedProfessor(Professor professor) {
        requestedProfessors.remove(professor);
    }
    //endregion

    //region [ - removeStudent(Student student) - ]
    public static void removeStudent(Student student) {
        students.remove(student);
    }
    //endregion

    //region [ - removeCourse(Course course) - ]
    public static void removeCourse(Course course) {
        courses.remove(course);
    }
    //endregion

    //region [ - viewAllProfessors() - ]
    public static void viewAllProfessors() {
        professors.forEach(p -> System.out.printf("\nId : %d \nFirst Name :  %s, Last Name :  %s, Age :  %d, Username :  %s, Score :  %d\n", professors.indexOf(p) + 1, p.firstName, p.lastName, p.age, p.account.getUsername(), p.getScore()));
    }
    //endregion

    //region [ - viewAllStudents() - ]
    public static void viewAllStudents() {
        students.forEach(s -> System.out.printf("\nId :  %s\nFirst Name :  %s\nLast Name :  %s\nAge :  %d\nUsername :  %s\n", students.indexOf(s) + 1, s.firstName, s.lastName, s.age, s.account.getUsername()));
    }
    //endregion

    //region [ - viewStudent(UUID id) - ]
    public void viewStudent(UUID id) {
        students.forEach(s -> {
            if (s.getHogwartsId() == id) {
                System.out.printf("Id :  %s\nFirst Name :  %s\nLast Name :  %s\nAge :  %d\nUsername :  %s", s.getHogwartsId().toString(), s.firstName, s.lastName, s.age, s.account.getUsername());
            }
        });
    }
    //endregion

    //region [ - viewAllCourses() - ]
    public static void viewAllCourses() {
        courses.forEach(c -> System.out.printf("Title :  %s\nProfessor :  %s %s (%d)\n", c.getTitle(), c.getProfessor().firstName, c.getProfessor().lastName, c.getProfessor().getScore()));
    }
    //endregion

    //region [ - viewCourse(UUID id) - ]
    public void viewCourse(UUID id) {
        courses.forEach(c -> {
            if (c.getId() == id) {
                System.out.printf("Title :  %s\nProfessor :  %s %s (%d)\n---------------", c.getTitle(), c.getProfessor().firstName, c.getProfessor().lastName, c.getProfessor().getScore());
            }
        });
    }
    //endregion

    //region [ - rateProfessor(Professor professor, int change) - ]
    public static void rateProfessor(Professor professor, int change) {
        professors.forEach(p -> {
            if (p.getHogwartsId() == professor.getHogwartsId()) {
                p.setScore(p.getScore() + change);
            }
        });
    }
    //endregion

    //region [ - scoreStudent(UUID course, UUID studentId, double score) - ]
    public static void scoreStudent(UUID courseId, UUID studentId, double score) {
        students.stream().filter(s -> s.getHogwartsId() == studentId).forEach(s -> s.getCourses().forEach(c -> {
            if (c.getId() == courseId) c.setScore(score);
        }));
    }
    //endregion

    //region [ - message(Student student, Professor professor, String messageText) - ]
    public static void message(Student student, Professor professor, String messageText) {
        professors.forEach(p -> {
            if (p.getHogwartsId() == professor.getHogwartsId()) {
                p.messages.add(new Message(messageText, student, professor));
            }
        });
    }
    //endregion

    //region [ - createCourse(Course course) - ]
    public void createCourse(Course course) {
        Hogwarts.courses.add(course);
    }
    //endregion

    //endregion

}
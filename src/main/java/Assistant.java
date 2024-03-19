import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Assistant extends Person {

    //region [ - Constructor - ]

    //region [ - Assistant(Account account, String firstName, String lastName, int age) - ]
    public Assistant(Account account, String firstName, String lastName, int age) {
        super(account, firstName, lastName, age);
        hasLoggedIn = false;
    }
    //endregion

    //region [ - Assistant(Account account) - ]
    public Assistant(Account account) {
        super(account);
    }
    //endregion

    //endregion

    //region [ - Methods - ]

    //region [ - signUp(Assistant assistant) - ]
    public void signUp(Assistant assistant) {
        if (hasLoggedIn) {
            Hogwarts.addAccount(assistant.account);
            Hogwarts.addAssistant(assistant);
        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //region [ - login(Account account) - ]
    public Assistant login() {
        for (Assistant a : Hogwarts.getAssistants()) {
            if (Objects.equals(a.account.getUsername(), account.getUsername()) && Objects.equals(a.account.getPassword(), account.getPassword())) {
                a.hasLoggedIn = true;
                System.out.printf("Welcome %s %s\nYou are logged in as an assistant", firstName, lastName);
                return a;
            }
        }
        return null;
    }
    //endregion

    //region [ - viewCoursesAndItsStudents() - ]
    public void viewCoursesAndItsStudents() {
        if (hasLoggedIn) {
            for (var course : Hogwarts.getCourses()) {
                System.out.printf("\nCourse Title :  %s\nProfessor :  %s %s\nStudents :\n", course.getTitle(), course.getProfessor().firstName, course.getProfessor().lastName);
                course.getStudents().forEach(s -> System.out.printf("  %s %s\n", s.firstName, s.lastName));
            }
        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //region [ - viewProfile - ]

    //region [ - viewProfile(Student student) - ]
    public void viewProfile(Student student) {
        if (hasLoggedIn) {
            System.out.printf("\nFirst Name :  %s\nLast Name :  %s\nAge :  %d\nUsername :  %s\n", student.firstName, student.lastName, student.age, student.account.getUsername());
        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //region [ - viewProfile(Professor professor) - ]
    public void viewProfile(Professor professor) {
        if (hasLoggedIn) {
            System.out.printf("First Name :  %s\nLast Name :  %s\nAge :  %d\nUsername :  %s\nScore :  %d", professor.firstName, professor.lastName, professor.age, professor.account.getUsername(), professor.getScore());
        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //endregion

    //region [ - createCourse(Course course) - ]
    public void createCourse(Course course) {
        if (hasLoggedIn) {
            Hogwarts.addCourse(course);
        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //region [ - createRawCourse(Course rawCourse) - ]
    public void createRawCourse(Course rawCourse) {
        if (hasLoggedIn) {
            Hogwarts.addRawCourse(rawCourse);
        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //region [ - remove - ]

    //region [ - remove(Professor professor) - ]
    public void remove(Professor professor) {
        if (hasLoggedIn) {
            if (!Objects.equals(professor.account.getRole(), "Assistant")) {
                System.out.printf("Are sure you want to remove %s %s (%s)?(y/n)  ", professor.firstName, professor.lastName, professor.account.getRole());
                Scanner in = new Scanner(System.in);
                String command = in.nextLine();
                if (Objects.equals(command, "y")) {

                    if (Objects.equals(professor.account.getRole(), "Professor")) Hogwarts.removeProfessor(professor);
                    System.out.printf("\n%s %s (%s) removed successfully\n", professor.firstName, professor.lastName, professor.account.getRole());

                } else if (!Objects.equals(command, "n")) {

                    System.out.println("Invalid Choice");
                    remove(professor);

                }
            } else System.out.println("!! You can't remove an assistant !!");
        } else System.out.println("!! No assistant has logged in !!");
    }
    //endregion

    //region [ - remove(Student student) - ]
    public void remove(Student student) {
        if (hasLoggedIn) {
            if (!Objects.equals(student.account.getRole(), "Assistant")) {
                System.out.printf("Are sure you want to remove %s %s (%s)?(y/n)  ", student.firstName, student.lastName, student.account.getRole());
                Scanner in = new Scanner(System.in);
                String command = in.nextLine();
                if (Objects.equals(command, "y")) {

                    if (Objects.equals(student.account.getRole(), "Student")) Hogwarts.removeStudent(student);
                    System.out.printf("\n%s %s (%s) removed successfully\n", student.firstName, student.lastName, student.account.getRole());

                } else if (!Objects.equals(command, "n")) {

                    System.out.println("Invalid Choice");
                    remove(student);

                }
            } else System.out.println("!! You can't remove an assistant !!");
        } else System.out.println("!! No assistant has logged in !!");
    }
    //endregion

    //endregion

    //region [ - manageRequestedCourse() - ]
    public void manageRequestedCourse() {
        if (hasLoggedIn) {
            Hogwarts.getRequestedCourses().forEach(rc -> System.out.printf("Title :  %s\nProfessor :  %s %s (%d)\n---------------", rc.getTitle(), rc.getProfessor().firstName, rc.getProfessor().lastName, rc.getProfessor().getScore()));
            System.out.print("Enter a number of the course request you want to accept :  ");
            Scanner in = new Scanner(System.in);
            int index = in.nextInt();
            Course course = Hogwarts.getRequestedCourses().get(index - 1);
            Hogwarts.addRawCourse(course);
            Hogwarts.removeRequestedCourse(course);
            System.out.println("Course successfully accepted.");
        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //region [ - manageRequestedProfessor() - ]
    public void manageRequestedProfessor() {
        if (hasLoggedIn) {
            for (Professor p : Hogwarts.getProfessors()) {
                if (!p.getHasAccess()) {
                    Hogwarts.addRequestedProfessor(p);
                }
            }
            Hogwarts.getRequestedProfessors().forEach(rq -> System.out.printf("\n%d, %s %s %d (%s)\n", Hogwarts.getRequestedProfessors().indexOf(rq) + 1, rq.firstName, rq.lastName, rq.age, rq.account.getUsername()));
            System.out.print("\nEnter a number of the professor request you want to accept :  ");
            Scanner in = new Scanner(System.in);
            int index = in.nextInt();
            Professor professor = Hogwarts.getRequestedProfessors().get(index - 1);
            Hogwarts.getProfessors().stream().filter(p -> p.getHogwartsId() == professor.getHogwartsId()).forEach(p -> p.setHasAccess(true));
            Hogwarts.removeRequestedProfessor(professor);
            System.out.println("Professor account successfully accepted.");

        } else {
            System.out.println("!! No assistant has logged in !!");
        }
    }
    //endregion

    //endregion

}

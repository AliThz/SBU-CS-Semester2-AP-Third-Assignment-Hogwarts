import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Student extends Person {

    //region [ - Fields - ]

    //region [ - String house - ]
    private String house;

    //region [ - getHouse() - ]
    public String getHouse() {
        return house;
    }
    //endregion

    //endregion

    //region [ - ArrayList<Course> courses - ]
    private ArrayList<Course> courses;

    //region [ - getCourses() - ]
    public ArrayList<Course> getCourses() {
        return courses;
    }
    //endregion

    //endregion

    //endregion

    //region [ - Constructor - ]

    //region [ - Student(Account account, String firstName, String lastName, int age) - ]
    public Student(Account account, String firstName, String lastName, int age) {
        super(account, firstName, lastName, age);
        courses = new ArrayList<>();
        hasLoggedIn = false;
        sort();
    }
    //endregion

    //region [ - Student(Account account) - ]
    public Student(Account account) {
        super(account);
        hasLoggedIn = false;
        sort();
    }
    //endregion

    //endregion

    //region [ - Methods - ]

    //region [ - signUp(Student student) - ]
    public void signUp(Student student) {
        Hogwarts.addStudent(student);
        Hogwarts.addAccount(student.account);
    }
    //endregion

    //region [ - login(Student student) - ]
    public Student login() {
        for (Student s : Hogwarts.getStudents()) {
            if (Objects.equals(s.account.getUsername(), account.getUsername()) && Objects.equals(s.account.getPassword(), account.getPassword())) {
                hasLoggedIn = true;
                System.out.printf("Welcome %s %s\nYou are logged in as an student", firstName, lastName);
                return s;
            }
        }
        return null;
    }
    //endregion

    //region [ - takeCourse(Course course) - ]
    public void takeCourse(Course course) {
        courses.add(course);
    }
    //endregion

    //region [ - viewAllCoursesTaken() - ]
    public void viewAllCoursesTaken() {
        courses.forEach(c -> System.out.printf("\nTitle :  %s, Score :  %f\nProfessor :  %s %s (%d)\n", c.getTitle(), c.getScore(), c.getProfessor().firstName, c.getProfessor().lastName, c.getProfessor().getScore()));
    }
    //endregion

    //region [ - viewAllProfessors() - ]
    public void viewAllProfessors() {
        courses.forEach(c -> System.out.printf("Professor %s %s (%d)\n---------------", c.getProfessor().firstName, c.getProfessor().lastName, c.getProfessor().getScore()));
    }
    //endregion

    //region [ - sort() - ]
    public void sort() {
        System.out.print("Which house do you like to be part of ?\n  1,Gryffindor\n  2,Hufflepuff\n  3,Ravenclaw\n  4,Slytherin\nPrint your desired house number :  ");
        Scanner in = new Scanner(System.in);
        int houseNumber = in.nextInt();
        switch (houseNumber) {
            case 1:
                house = "Gryffindor";
                break;
            case 2:
                house = "Hufflepuff";
                break;
            case 3:
                house = "Ravenclaw";
                break;
            case 4:
                house = "Slytherin";
                break;
            default:
                System.out.println("!! Invalid Choice !!");
                sort();
        }
    }
    //endregion

    //endregion

}

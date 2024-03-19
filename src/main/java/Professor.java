import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Professor extends Person {

    //region [ - Field - ]

    //region [ - int score - ]
    private int score;

    //region [ - getScore() - ]
    public int getScore() {
        return score;
    }
    //endregion

    //region [ - setScore(int score) - ]
    public void setScore(int score) {
        this.score = score;
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

    //region [ - setCourses(ArrayList<Course> courses) - ]

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    //endregion

    //endregion

    //region [ - Boolean hasAccess - ]
    private Boolean hasAccess;

    //region [ - getHasAccess() - ]
    public Boolean getHasAccess() {
        return hasAccess;
    }
    //endregion

    //region [ - setHasAccess(Boolean hasAccess) - ]
    public void setHasAccess(Boolean hasAccess) {
        this.hasAccess = hasAccess;
    }
    //endregion

    //endregion

    //endregion

    //region [ - Constructor - ]

    //region [ - Professor(Account account, String firstName, String lastName, int age) - ]
    public Professor(Account account, String firstName, String lastName, int age) {
        super(account, firstName, lastName, age);
        score = 0;
        hasAccess = false;
        courses = new ArrayList<>();
    }
    //endregion

    //region [ - Professor(Account account) - ]
    public Professor(Account account) {
        super(account);
        courses = new ArrayList<>();
        hasAccess = false;
    }
    //endregion

    //endregion

    //region [ - Methods - ]

    //region [ - signUp(Professor professor) - ]
    public void signUp(Professor professor) {
        Hogwarts.addRequestedProfessor(professor);
        Hogwarts.addProfessor(professor);
        Hogwarts.addAccount(professor.account);
        System.out.println("Your account as a professor is requested to assistants");
    }
    //endregion

    //region [ - login() - ]
    public Professor login() {
        for (Professor p : Hogwarts.getProfessors()) {
            if (Objects.equals(p.account.getUsername(), account.getUsername()) && Objects.equals(p.account.getPassword(), account.getPassword())) {
                hasLoggedIn = true;
                System.out.printf("Welcome %s %s\nYou are logged in as a professor\n", p.firstName, p.lastName);
                return p;
            }
        }
        return null;
    }
    //endregion

    //region [ - takeCourse() - ]
    public void takeCourse() {
        if (!hasAccess) {
            System.out.println("!! You don't have access to do this !!");
            return;
        }
        Hogwarts.getRawCourses().forEach(rc -> System.out.printf("%d, %s \n", Hogwarts.getRawCourses().indexOf(rc) + 1, rc.getTitle()));
        System.out.print("Enter a number of the course you want to take :  ");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        Course course = Hogwarts.getRawCourses().get(index - 1);
        course.setProfessor(this);
        Hogwarts.addCourse(course);
        courses.add(course);
        System.out.println("The course was successfully added");
    }
    //endregion

    //region [ - scoreStudent(Course course, Student student, double score) - ]
    public void scoreStudent(Course course, Student student, double score) {
        if (!hasAccess) {
            System.out.println("!! You don't have access to do this !!");
            return;
        }
        Hogwarts.getStudents().stream().filter(s -> s.getHogwartsId() == student.getHogwartsId()).forEach(s -> s.getCourses().stream().filter(c -> c.getId() == course.getId()).forEach(c -> c.setScore(score)));
    }
    //endregion

    //region [ - viewCourses() - ]
    public void viewCourses() {
        if (!hasAccess) {
            System.out.println("!! You don't have access to do this !!");
            return;
        }
        courses.forEach(c -> System.out.printf("\nId :  %d\nTitle :  %s\n", courses.indexOf(c) + 1, c.getTitle()));
    }
    //endregion

    //region [ - viewCourseStudents(Course course) - ]
    public void viewCourseStudents(Course course) {
        if (!hasAccess) {
            System.out.println("!! You don't have access to do this !!");
            return;
        }
        System.out.printf("Course Title :  %s\nStudents :\n", course.getTitle());
        course.getStudents().forEach(s -> System.out.printf("  %s %s\n", s.firstName, s.lastName));
    }
    //endregion

    //region [ - requestCourse(Course course) - ]
    public void requestCourse(Course course) {
        if (!hasAccess) {
            System.out.println("!! You don't have access to do this !!");
            return;
        }

        Hogwarts.addRequestedCourse(course);
    }
    //endregion

    //endregion
}

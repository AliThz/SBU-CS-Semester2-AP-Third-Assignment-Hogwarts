import java.util.ArrayList;
import java.util.UUID;

public class Course {

    //region [ - Fields - ]

    //region [ - UUID id - ]
    private final UUID id;

    //region [ - getId() - ]
    public UUID getId() {
        return id;
    }
    //endregion

    //endregion

    //region [ - String title; - ]
    private String title;

    //region [ - getTitle() - ]
    public String getTitle() {
        return title;
    }
    //endregion

    //region [ - setTitle(String title) - ]
    public void setTitle(String title) {
        this.title = title;
    }
    //endregion

    //endregion

    //region [ - Professor professor - ]
    private Professor professor;

    //region [ - getProfessor() - ]
    public Professor getProfessor() {
        return professor;
    }
    //endregion

    //region [ - setProfessor(Professor professor) - ]
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    //endregion

    //endregion

    //region [ - double score - ]
    private double score;

    //region [ - getScore() - ]
    public double getScore() {
        return score;
    }
    //endregion

    //region [ - setScore(double score) - ]
    public void setScore(double score) {
        this.score = score;
    }
    //endregion

    //endregion

    //region [ - ArrayList<Student> students - ]
    private ArrayList<Student> students;

    //region [ - getStudents() - ]
    public ArrayList<Student> getStudents() {
        return students;
    }
    //endregion

    //region [ - setStudents(ArrayList<Student> students) - ]
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    //endregion

    //endregion

    //endregion

    //region [ - Constructor - ]

    //region [ - Course(String title) - ]
    public Course(String title) {
        id = UUID.randomUUID();
        this.title = title;
        students = new ArrayList<>();
    }
    //endregion

    //region [ - Course(String title, Professor professor) - ]
    public Course(String title, Professor professor) {
        id = UUID.randomUUID();
        this.title = title;
        this.professor = professor;
        students = new ArrayList<>();
    }
    //endregion

    //endregion

    //region [ - Method - ]

    //region [ - addStudent(Student student - ]
    public void addStudent(Student student) {
        students.add(student);
    }
    //endregion

    //endregion

}

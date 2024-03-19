import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Function;

public class Main {

    //region [ - main(String[] args) - ]
    public static void main(String[] args) {
        //These are some initial objects

        Hogwarts hogwarts = new Hogwarts();

        Hogwarts.addAssistant(new Assistant(new Account("ali", "ali", "Assistant"), "Ali", "Taherzadeh", 19));

        Hogwarts.addProfessor(new Professor(new Account("p1", "p1", "Professor"), "p1", "p1", 40));
        Hogwarts.addProfessor(new Professor(new Account("p2", "p2", "Professor"), "p2", "p2", 50));
        Hogwarts.addProfessor(new Professor(new Account("p3", "p3", "Professor"), "p3", "p3", 60));

        Hogwarts.addStudent(new Student(new Account("s1", "s1", "Student"), "s1", "s1", 10));
        Hogwarts.addStudent(new Student(new Account("s2", "s2", "Student"), "s2", "s2", 20));
        Hogwarts.addStudent(new Student(new Account("s3", "s3", "Student"), "s3", "s3", 30));

        Hogwarts.addCourse(new Course("BP", Hogwarts.getProfessors().get(0)));
        Hogwarts.addCourse(new Course("AP", Hogwarts.getProfessors().get(1)));
        Hogwarts.addCourse(new Course("DS", Hogwarts.getProfessors().get(2)));

        Hogwarts.addRawCourse(new Course("BoM"));
        Hogwarts.addRawCourse(new Course("BOC"));

        runMenu();
    }
    //endregion

    //region [ - runMenu() - ]
    public static void runMenu() {
        System.out.flush();
        System.out.print("-- Welcome to Hogwarts School of Witchcraft And Wizardry  !\n  1,Login\n  2,SignUp\n  3,Exit\nChoose one of the options above :  ");

        Scanner commandScanner = new Scanner(System.in);
        int command = commandScanner.nextInt();

        switch (command) {
            case 1:
                login();
                break;
            case 2:
                signUp();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.print("\n!! Invalid Choice !!\n");
                runMenu();
        }
        System.out.println("0,Back");
        int backCommand = commandScanner.nextInt();
        if (backCommand == 0) {
            runMenu();
        }
    }
    //endregion

    //region [ - login() - ]
    public static void login() {
        System.out.flush();
        System.out.print("-- Login\n  1,Assistant\n  2,Professor\n  3,Student\n  4,Back\nChoose one of the options above :  ");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        String username, password;

        switch (command) {
            case "1":
                System.out.print("Username :  ");
                username = scanner.next();
                scanner.nextLine();
                System.out.print("Password :  ");
                scanner = new Scanner(System.in);
                password = scanner.nextLine();

                Assistant assistant = new Assistant(new Account(username, password, "Assistant"));
                assistant = assistant.login();
                runAssistantMenu(assistant);
                break;
            case "2":
                System.out.print("Username :  ");
                username = scanner.next();
                scanner.nextLine();
                System.out.print("Password :  ");
                password = scanner.nextLine();

                Professor professor = new Professor(new Account(username, password, "Professor"));
                professor = professor.login();
                runProfessorMenu(professor);
                break;
            case "3":
                System.out.print("Username :  ");
                username = scanner.next();
                scanner.nextLine();
                System.out.print("Password :  ");
                password = scanner.nextLine();

                Student student = new Student(new Account(username, password, "Student"));
                student = student.login();
                runStudentMenu(student);
                break;
            case "4":
                runMenu();
                break;
            default:
                System.out.print("\n!! Invalid Choice !!\n");
                login();
        }
    }
    //endregion

    //region [ - signUp() - ]
    public static void signUp() {
        System.out.flush();
        System.out.print("-- Sign Up\n  1,Professor\n  2,Student\n  3,Back\nChoose one of the options above :  ");

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        switch (command) {
            case 1:
                String firstName, lastName, userName, password;
                int age;
                System.out.print("First Name :  ");
                firstName = scanner.next();
                scanner.nextLine();
                System.out.print("Last Name :  ");
                lastName = scanner.next();
                scanner.nextLine();
                System.out.print("Age :  ");
                age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Username :  ");
                userName = scanner.next();
                scanner.nextLine();
                System.out.print("Password :  ");
                password = scanner.next();

                Professor professor = new Professor(new Account(userName, password, "Professor"), firstName, lastName, age);
                professor.signUp(professor);
                break;
            case 2:
                System.out.print("First Name :  ");
                firstName = scanner.next();
                scanner.nextLine();
                System.out.print("Last Name :  ");
                lastName = scanner.next();
                scanner.nextLine();
                System.out.print("Age :  ");
                age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Username :  ");
                userName = scanner.next();
                scanner.nextLine();
                System.out.print("Password :  ");
                password = scanner.next();
                Student student = new Student(new Account(userName, password, "Student"), firstName, lastName, age);
                student.signUp(student);
                break;
            case 3:
                runMenu();
                break;
            default:
                System.out.print("\n!! Invalid Choice !!");
                login();
        }
        System.out.println("0,Back");
        int backCommand = scanner.nextInt();
        if (backCommand == 0) {
            runMenu();
        }
    }
    //endregion

    //region [ - runAssistantMenu(Assistant assistant) - ]
    public static void runAssistantMenu(Assistant assistant) {
        System.out.flush();
        System.out.printf("-- Welcome %s %s (%s) !\n  1,Response requested accounts\n  2,Response requested courses\n  3,Remove a professor\n  4,Remove a student\n  5,View course and their list of students\n  6,View a professor profile\n  7,View a student profile\n  8,Create a course\n  9,Score Student\n  10,Sign up a Assistant\n  11,Change Username & Password\n  12,Log out\nChoose one of the options above :  ", assistant.firstName, assistant.lastName, assistant.account.getRole());

        Scanner parameterScanner = new Scanner(System.in);
        Scanner commandScanner = new Scanner(System.in);
        int command = commandScanner.nextInt();

        switch (command) {
            case 1:
                assistant.manageRequestedProfessor();
                break;
            case 2:
                assistant.manageRequestedCourse();
                break;
            case 3:
                System.out.println("Professors");
                Hogwarts.viewAllProfessors();
                int professorIndex = parameterScanner.nextInt();
                assistant.remove(Hogwarts.getProfessors().get(professorIndex - 1));
                break;
            case 4:
                System.out.println("Students");
                Hogwarts.viewAllStudents();
                int studentIndex = parameterScanner.nextInt();
                assistant.remove(Hogwarts.getStudents().get(studentIndex - 1));
                break;
            case 5:
                assistant.viewCoursesAndItsStudents();
                break;
            case 6:
                System.out.println("Professors");
                Hogwarts.viewAllProfessors();
                professorIndex = parameterScanner.nextInt();
                assistant.viewProfile(Hogwarts.getProfessors().get(professorIndex - 1));
                break;
            case 7:
                System.out.println("Students");
                Hogwarts.viewAllStudents();
                studentIndex = parameterScanner.nextInt();
                assistant.viewProfile(Hogwarts.getStudents().get(studentIndex - 1));
                break;
            case 8:
                String title;
                System.out.print("Title :  ");
                title = parameterScanner.nextLine();
                System.out.print("Do you want to add a course without a professor?(y/n)  ");
                String yn = commandScanner.next();
                if (Objects.equals(yn, "n")) {
                    System.out.println("Professors");
                    Hogwarts.viewAllProfessors();
                    professorIndex = parameterScanner.nextInt();
                    Professor professor = Hogwarts.getProfessors().get(professorIndex - 1);
                    assistant.createCourse(new Course(title, professor));
                } else if (Objects.equals(yn, "y")) {
                    assistant.createRawCourse(new Course(title));
                }
                break;
            case 9:
                System.out.println("Students");
                Hogwarts.viewAllStudents();
                studentIndex = parameterScanner.nextInt();
                Student student = Hogwarts.getStudents().get(studentIndex - 1);

                System.out.println("Courses");
                student.viewAllCoursesTaken();
                int courseIndex = parameterScanner.nextInt();
                Course course = student.getCourses().get(courseIndex - 1);

                System.out.println("Score :  ");
                double score = parameterScanner.nextDouble();

                Hogwarts.scoreStudent(course.getId(), student.getHogwartsId(), score);
                break;
            case 10:
                String firstName, lastName, userName, password;
                int age;
                System.out.print("First Name :  ");
                firstName = parameterScanner.next();
                parameterScanner.nextLine();
                System.out.print("Last Name :  ");
                lastName = parameterScanner.next();
                parameterScanner.nextLine();
                System.out.print("Age :  ");
                age = parameterScanner.nextInt();
                parameterScanner.nextLine();
                System.out.print("Username :  ");
                userName = parameterScanner.next();
                parameterScanner.nextLine();
                System.out.print("Password :  ");
                password = parameterScanner.next();
                assistant.signUp(new Assistant(new Account(userName, password, "Assistant"), firstName, lastName, age));
                break;
            case 11:
                System.out.print("New Username :  ");
                userName = parameterScanner.next();
                parameterScanner.nextLine();
                System.out.print("New Password :  ");
                password = parameterScanner.next();

                assistant.account.changeUsername(userName);
                assistant.account.changePassword(password);
            case 12:
                assistant.logOut();
                runMenu();
                break;
            default:
                System.out.print("\n!! Invalid Choice !!\n");
                runAssistantMenu(assistant);
        }

        System.out.println("0,Back");
        int backCommand = commandScanner.nextInt();
        if (backCommand == 0) {
            runAssistantMenu(assistant);
        }
    }
    //endregion

    //region [ - runProfessorMenu(Professor professor) - ]
    public static void runProfessorMenu(Professor professor) {
        System.out.flush();
        System.out.printf("\n-- Welcome %s %s (%s) Score: %d \n  1,Take Courses\n  2,Score Students\n  3,View Courses List\n  4,View Course's List of Students\n  5,Request a course\n  6,Change Username & Password\n  7,Log Out\nChoose one of the options above :  ", professor.firstName, professor.lastName, professor.account.getRole(), professor.getScore());

        Scanner parameterScanner = new Scanner(System.in);
        Scanner commandScanner = new Scanner(System.in);
        int command = commandScanner.nextInt();

        switch (command) {
            case 1:
                professor.takeCourse();
                break;
            case 2:
                System.out.println("Courses");
                professor.viewCourses();
                int courseIndex = parameterScanner.nextInt();
                Course course = professor.getCourses().get(courseIndex - 1);

                parameterScanner.nextLine();

                System.out.println("Students");
                professor.viewCourseStudents(course);
                int studentIndex = parameterScanner.nextInt();
                Student student = course.getStudents().get(studentIndex - 1);

                parameterScanner.nextLine();

                System.out.println("Score :  ");
                double score = parameterScanner.nextDouble();

                professor.scoreStudent(course, student, score);
                break;
            case 3:
                System.out.println("Courses");
                professor.viewCourses();
                break;
            case 4:
                System.out.println("Courses");
                professor.viewCourses();
                courseIndex = parameterScanner.nextInt();
                course = professor.getCourses().get(courseIndex - 1);

                System.out.println("Students");
                professor.viewCourseStudents(course);
                break;
            case 5:
                String title;
                System.out.print("Title :  ");
                title = parameterScanner.next();

                professor.requestCourse(new Course(title));
                break;
            case 6:
                String userName, password;
                System.out.print("New Username :  ");
                userName = parameterScanner.next();
                parameterScanner.nextLine();
                System.out.print("New Password :  ");
                password = parameterScanner.next();

                professor.account.changeUsername(userName);
                professor.account.changePassword(password);
                break;
            case 7:
                professor.logOut();
                runMenu();
                break;
            default:
                System.out.print("\n!! Invalid Choice !!");
                runProfessorMenu(professor);
        }

        System.out.println("0,Back");
        int backCommand = commandScanner.nextInt();
        if (backCommand == 0) {
            runProfessorMenu(professor);
        }
    }
    //endregion

    //region [ - runStudentMenu(Student student) - ]
    public static void runStudentMenu(Student student) {
        System.out.flush();
        System.out.printf("-- Welcome %s %s (%s)\n  1,Take Courses\n  2,View ALl Courses\n  3,View All Professors\n  4,Rating and Message Professors\n  5,Change Username & Password\n  6,Log Out\nChoose one of the options above :  ", student.firstName, student.lastName, student.account.getRole());

        Scanner parameterScanner = new Scanner(System.in);
        Scanner commandScanner = new Scanner(System.in);
        int command = commandScanner.nextInt();

        switch (command) {
            case 1:
                Hogwarts.viewAllCourses();
                int courseIndex = parameterScanner.nextInt();
                student.takeCourse(Hogwarts.getCourses().get(courseIndex - 1));
                break;
            case 2:
                student.viewAllCoursesTaken();
                break;
            case 3:
                student.viewAllProfessors();
                break;
            case 4:
                System.out.println("Professors");
                Hogwarts.viewAllProfessors();
                int professorIndex = parameterScanner.nextInt();
                Professor professor = Hogwarts.getProfessors().get(professorIndex - 1);
                System.out.print("Type your message or comment :  ");
                String text = parameterScanner.next();
                Hogwarts.message(student, professor, text);
                System.out.println("Your message sent successfully to the professor");
                System.out.print("Hoe do you rate professor from 0 to 10? ");
                int score = parameterScanner.nextInt();
                Hogwarts.rateProfessor(professor, score);
                break;
            case 5:
                String userName, password;
                System.out.print("New Username :  ");
                userName = parameterScanner.next();
                parameterScanner.nextLine();
                System.out.print("New Password :  ");
                password = parameterScanner.next();

                student.account.changeUsername(userName);
                student.account.changePassword(password);
            case 6:
                student.logOut();
                runMenu();
                break;
            default:
                System.out.print("\n!! Invalid Choice !!");
                runStudentMenu(student);
        }

        System.out.println("0,Back");
        int backCommand = commandScanner.nextInt();
        if (backCommand == 0) {
            runStudentMenu(student);
        }
    }
    //endregion

}

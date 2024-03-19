import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Person {

    //region [ - Fields - ]

    //region [ - UUID hogwartsId - ]
    private final UUID hogwartsId;

    //region [ - getHogwartsId() - ]
    public UUID getHogwartsId() {
        return hogwartsId;
    }
    //endregion

    //endregion

    protected String firstName;
    protected String lastName;
    protected int age;
    protected Account account;
    protected ArrayList<Message> messages;
    protected Boolean hasLoggedIn;

    //endregion

    //region [ - Constructors - ]

    //region [ - Person(Account account, String firstName, String lastName, int age) - ]
    public Person(Account account, String firstName, String lastName, int age) {
        hogwartsId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.account = account;
        messages = new ArrayList<>();
    }
    //endregion

    //region [ - Person(Account account) - ]
    public Person(Account account) {
        hogwartsId = UUID.randomUUID();
        this.account = account;
    }
    //endregion

    //endregion

    //region [ - Method - ]

    //region [ - logOut() - ]
    public void logOut() {
        hasLoggedIn = false;
    }
    //endregion

    //endregion

}

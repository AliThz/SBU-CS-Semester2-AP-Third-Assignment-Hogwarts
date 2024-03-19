import java.util.UUID;

public class Account implements AccountManagement {

    //region [ - Fields - ]

    //region [ - UUID accountId - ]
    private UUID accountId;

    //region [ - getAccountId() - ]

    public UUID getAccountID() {
        return accountId;
    }

    //endregion

    //endregion

    //region [ - String username - ]
    private String username;

    //region [ - String getUsername() - ]

    public String getUsername() {
        return username;
    }

    //endregion

    //endregion

    // TODO: Passwords should hashed
    private String password;

    public String getPassword() {
        return password;
    }

    //region [ - String role - ]
    private String role;

    //region [ - String getRole() - ]
    public String getRole() {
        return role;
    }
    //endregion

    //region [ - setRole(String role) - ]
    public void setRole(String role) {
        this.role = role;
    }
    //endregion

    //endregion

    //endregion

    //region [ - Constructor - ]

    //region [ - Account(String username, String password, String role) - ]
    public Account(String username, String password, String role) {
        this.accountId = UUID.randomUUID();
        this.username = username;
        if (validatePassword(password)) this.password = password;
        else System.out.println("!! Not a valid password !!");
        this.role = role;
    }
    //endregion

    //region [ - Account(String username, String password) - ]
    public Account(String username, String password) {
        this.username = username;
        if (validatePassword(password)) this.password = password;
        else System.out.println("!! Not a valid password !!");
    }
    //endregion

    //endregion

    //region [ - Methods - ]

    //region [ - validatePassword(String enteredPassword) - ]
    @Override
    public boolean validatePassword(String enteredPassword) {
//        return password.length() >= 6;
        return true;
    }
    //endregion

    //region [ - changeUsername(String newUsername) - ]
    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }
    //endregion

    //region [ - changePassword(String newPassword) - ]
    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    //endregion

    //endregion
}

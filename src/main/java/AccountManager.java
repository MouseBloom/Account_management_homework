//Account management interface
public interface AccountManager {

    //New account registration, adds record to CSV
    void register(Account account) throws AccountAlreadyExistsException;

    //Returns account by email and password
    Account login(String email, String password) throws WrongCredentialsException, AccountBlockedException;

    //Deletes account by email and password
    void removeAccount(String email, String password) throws WrongCredentialsException;
}

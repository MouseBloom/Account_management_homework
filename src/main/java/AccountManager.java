public interface AccountManager {

    void register(Account account);

    void login(String email, String password);

    void removeAccount(String email, String password);
}

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileAccountManager implements AccountManager{

    private static String filePath;
    private List<String[]> accounts;

    public FileAccountManager(String path) {
        try {
            filePath = path;
            accounts = FileService.readAllLines(Paths.get(filePath));
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public void register(Account account) throws AccountAlreadyExistsException {
        String mail = account.getEmail();
        for(String[] strings : accounts){
            System.out.println(strings[2].toString());
            System.out.println(mail);
            if (strings[2].toString().equals(mail)){
                throw new AccountAlreadyExistsException("Account this same email already exists");
            }
        }
        FileService.writeCSV(filePath, account.getAccount());
    }

    @Override
    public Account login(String email, String password) throws WrongCredentialsException, AccountBlockedException {
        for (String[] strings : accounts) {
            if (strings[2].toString().equals(email)) {
                if (strings[3].toString().equals(password)) {
                    if (strings[4].toString().equals("false")) {
                        Account account = new Account(strings[0].toString(), strings[1].toString(), strings[2].toString(), strings[3].toString());
                        return account;
                    } else {
                        throw new AccountBlockedException("Account is blocked");
                    }
                } else {
                    throw new WrongCredentialsException("Password or email is incorrect");
                }

            }
        }
        throw new WrongCredentialsException("Password or email is incorrect");
    }

    @Override
    public void removeAccount(String email, String password) {


    }
}

import java.util.Collections;
import java.util.List;

public class Account implements AccountManager {
    private String fullName;
    private String birthDate;
    private String email;
    private String password;
    private boolean blocked;


    @Override
    public void register(Account account) {

    }

    @Override
    public void removeAccount(String email, String password) {

    }

    @Override
    public void login(String email, String password){

    }

    public Account(String fio, String birthDate, String email, String password ){
        fullName = fio;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

    //Getter
    public String[] getAccount(){
        String[] account = {fullName, birthDate, email, password, String.valueOf(blocked)};
        return account;
    }

}


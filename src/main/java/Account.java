public class Account {
    private String fullName;
    private String birthDate;
    private String email;
    private String password;
    private boolean blocked;



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

    //Getter
    public String getEmail(){
        return email;
    }
}


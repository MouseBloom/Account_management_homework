import java.util.TreeMap;

//Class with the demonstration of all functions and exceptions
public class Test {

    public static void main(String[] args) {
        String path = System.getProperty("user.home") + "\\Desktop\\\\JAVA COURSE\\\\Home_Works\\\\lab_5\\\\Accounts.csv";
        try {
            Account A = new Account("Marinkin O I", "02.03.2004", "spam@gmail.com", "Passw0rd");
            Account B = new Account("Golovach E A", "29.12.1984", "lgol@mail.ru", "1234");
            FileAccountManager accManager = new FileAccountManager(path);
            accManager.register(A);
            accManager.register(B);
            accManager.register(A);
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < 5; i++) {
            try {
                FileAccountManager accManager = new FileAccountManager(path);
                accManager.login("spam@gmail.com", "q");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            accManager.login("lgol@mail.ru", "123");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            accManager.login("spam@gmail.com", "Passw0rd");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            accManager.login("lgol@mail.ru", "123");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            System.out.println(accManager.login("lgol@mail.ru", "1234").getAccountStr());
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < 4; i++) {
            try {
                FileAccountManager accManager = new FileAccountManager(path);
                System.out.println(accManager.login("lgol@mail.ru", "123"));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            System.out.println(accManager.login("lgol@mail.ru", "1234").getAccountStr());
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            accManager.removeAccount("spam@gmail.com", "Passw0rd");
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            accManager.removeAccount("lgol@mail.ru", "123");
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            FileAccountManager accManager = new FileAccountManager(path);
            accManager.removeAccount("lgol@mail.ru", "1234");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

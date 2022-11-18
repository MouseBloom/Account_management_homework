import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

//Singleton to count attempts to login
public class FailedLoginCounter {
    private static FailedLoginCounter instance;

    private static HashMap<String, Integer> attemptsCounter = new HashMap<>();

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    //Blockes account after 5 unsuccessful attempts
    public static void countAttempts(Account account, String path) {
        String email = account.getEmail();

        if (!attemptsCounter.containsKey(email)) {
            attemptsCounter.put(email, 0);
        }

        attemptsCounter.put(email, attemptsCounter.get(email) + 1);
        //System.out.println(attemptsCounter);
        if (attemptsCounter.get(email) == 5) {
            try {
                FileService.deleteRowByEmail(email, path);
                account.setBlocked();
                FileService.writeCSV(path, account.getAccount());
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    //Deletes attempts record after successful login
    public static void nullifyCounter(Account account) {
        String email = account.getEmail();
        attemptsCounter.remove(email);
    }

}



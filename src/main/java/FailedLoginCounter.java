import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;

    private static HashMap<Account, Integer> attemptsCounter = new HashMap<>();

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public static void countAttempts(Account account, String path) {

        if (!attemptsCounter.containsKey(account)) {
            attemptsCounter.put(account, 0);
        }

        attemptsCounter.put(account, attemptsCounter.get(account) + 1);
        if (attemptsCounter.get(account) == 5) {
            try{
                FileService.deleteRow(account, path);
                account.setBlocked();
                FileService.writeCSV(path, account.getAccount());
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

        public static void nullifyCounter(Account account) {
            attemptsCounter.remove(account);
        }

    }



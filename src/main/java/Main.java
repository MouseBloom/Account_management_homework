import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<String[]> r = FileService.readAllLines(Paths.get("C:\\Users\\olega\\Desktop\\JAVA COURSE\\Home_Works\\lab_5\\Accounts.csv"));
            for(String[] strings : r){
                System.out.println(Arrays.toString(strings));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            Account acc = new Account("Ivanov I.  I.", "01.01.2001","vanya@gmail.com", "1234");
            FileService.writeCSV("C:\\Users\\olega\\Desktop\\JAVA COURSE\\Home_Works\\lab_5\\Accounts.csv", acc.getAccount());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}



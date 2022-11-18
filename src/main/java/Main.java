import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = System.getProperty("user.home") + "\\Desktop\\\\JAVA COURSE\\\\Home_Works\\\\lab_5\\\\Accounts.csv";
        try {
            List<String[]> r = FileService.readAllLines(Paths.get(path));
            for (String[] strings : r) {
                System.out.println(strings.length);
                System.out.println(strings[0].toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}



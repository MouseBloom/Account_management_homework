import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<String[]> r = FileService.readAllLines(Paths.get("C:\\Users\\olega\\Desktop\\JAVA COURSE\\Home_Works\\lab_5\\Accounts.csv"));
            for(String[] strings : r){
                //System.out.println(strings[2].toString());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            FileAccountManager f = new FileAccountManager("C:\\Users\\olega\\Desktop\\JAVA COURSE\\Home_Works\\lab_5\\Accounts.csv");
            FileService.deleteRowByEmail("o@mail.ru","C:\\Users\\olega\\Desktop\\JAVA COURSE\\Home_Works\\lab_5\\Accounts.csv");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}



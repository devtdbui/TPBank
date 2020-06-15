
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author trinh
 */
public class TpBank {

    //ham check account
    //ham check password
    //random capcha
    //check capcha
    public void checkAccount(ResourceBundle bundle) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(bundle.getString("account"));
            String account = sc.nextLine();
            Pattern p = Pattern.compile("[0-9]{10}");
            if (p.matcher(account).find()) {
                break;
            } else {
                System.out.println(bundle.getString("check.account"));
            }
        }
    }

    public void checkPassword(ResourceBundle bundle) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(bundle.getString("password"));
            String password = sc.nextLine();
            Pattern p1 = Pattern.compile("^[0-9A-Za-z]{8,31}$"); //check 8-31
            Pattern p2 = Pattern.compile("^[A-Za-z0-9]*[0-9]+[A-Za-z0-9]*$");//CHECK CO IT NHAT LA 1 SO
            Pattern p3 = Pattern.compile("^[A-Za-z0-9]*[A-Za-z]+[A-Za-z0-9]*$");
            if (p1.matcher(password).find() && p2.matcher(password).find() && p3.matcher(password).find()) {
                break;
            } else {
                System.out.println(bundle.getString("wrong.password"));
            }
        }
    }

    public String radomCapchar() {
        //capchar: length = 5
        //cau tao: chua hoa, chu thuong, so
        //[a-zA-Z0-9]
        String root = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        //eplDB = capcha
        String capcha = "";
        int length = root.length();
        Random r = new Random();
        //r.nextInt(10); 0-9
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(length);//0 - length - 1
            capcha = capcha + root.charAt(index);
        }
        System.out.println("Capchar: " + capcha);
        return capcha;
    }

    public boolean checkCapchar(String capcha,ResourceBundle bundle) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.print(bundle.getString("capcha"));
        input = sc.nextLine();
        if (input.equals(capcha)) {
            System.out.println(bundle.getString("right.capcha"));
            return true;
        } else {
            System.out.println(bundle.getString("wrong.capcha"));
            return false;
        }
    }
}

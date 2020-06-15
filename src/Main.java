
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class Main {

    public static void menu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.println("Please choice one option:");
    }
    public static int getChoice(){
        Scanner sc = new Scanner(System.in);
        while(true){
            String txt = sc.nextLine();
            Pattern p = Pattern.compile("^[123]$");
            if(p.matcher(txt).find()){
                int choice = Integer.parseInt(txt);
                return choice;
            }else{
                System.out.println("invalid choice, please input again: ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TpBank tp = new TpBank();
        while (true) {
            menu();
            int choice = getChoice();
            String capcha = "";
            ResourceBundle bundle;
            switch (choice) {
                case 1:
                    bundle = ResourceBundle.getBundle("Vi");
                    tp.checkAccount(bundle);
                    tp.checkPassword(bundle);
                    capcha = tp.radomCapchar();
                    tp.checkCapchar(capcha,bundle);
                    break;
                case 2:
                    bundle = ResourceBundle.getBundle("En");
                    tp.checkAccount(bundle);
                    tp.checkPassword(bundle);
                    capcha = tp.radomCapchar();
                    tp.checkCapchar(capcha,bundle);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}

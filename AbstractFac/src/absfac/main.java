package absfac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException {
        int pick;
        System.out.println("what smart divce do you like ? 1. phone 2.tablet");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pick = Integer.parseInt(br.readLine());
        switch (pick) {
            case 1:
                System.out.println("what smart phone would u like to see ringing ? 1.iphone 2.haweie 3.Samsung");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                int choice = Integer.parseInt(br2.readLine());
                if (choice == 1) {
                    Phone p = new phoneFactory().getType("iphone");
                    p.Ring();
                } else if (choice == 2) {
                    Phone p = new phoneFactory().getType("huaweie");
                    p.Ring();
                } else if (choice == 3) {
                    Phone p = new phoneFactory().getType("Samsung");
                    p.Ring();
                }
                break;
            case 2:
                System.out.println("what tablet would u like to watch from ? 1.ipad 2.s7tablet ");
                BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
                int choice2 = Integer.parseInt(br3.readLine());
                if (choice2 == 1) {
                    tablet t = new tabletFactory().getType("ipad");
                    t.watch();
                } else if (choice2 == 2) {
                    tablet t = new tabletFactory().getType("s7tablet");
                    t.watch();
                }
                break;
            default:
                System.out.println("error entering");
        }
    }
}

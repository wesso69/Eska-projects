package abstractfac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFac {

    static int choice;

    public static void main(String[] args) throws IOException {
        System.out.println("--------------");
        System.out.println("do you want ur shape to be rounded or normal ? 1.rounded 2.normal  ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1:
                System.out.println("do you want it 1. square / 2.rect");
                int s = Integer.parseInt(br.readLine());

                if (s == 1) {
                    AbstractFactory af3 = FactoryProcdure.getFactory(true);
                    shape s3 = af3.getshape("square");
                    s3.drow();
                } else if (s == 2) {
                    AbstractFactory af4 = FactoryProcdure.getFactory(true);
                    shape s4 = af4.getshape("rectangle");
                    s4.drow();
                }
                 break;
            case 2:
                System.out.println("do you want it 1. square / 2.react");
                int s2 = Integer.parseInt(br.readLine());
                if (s2 == 1) {
                    AbstractFactory af1 = FactoryProcdure.getFactory(false);
                    shape s1 = af1.getshape("square");
                    s1.drow();
                } else if (s2 == 2) {
                    AbstractFactory af2 = FactoryProcdure.getFactory(false);
                    shape s3 = af2.getshape("rectangle");
                    s3.drow();
                }
                 break;
                  default: br.close();
        }
//        AbstractFactory af1 = FactoryProcdure.getFactory(true);
//        shape s1 = af1.getshape("rectangle");
//        s1.drow();
//        AbstractFactory af2 = FactoryProcdure.getFactory(true);
//        shape s2 = af2.getshape("square");
//        s2.drow();
//        AbstractFactory af3 = FactoryProcdure.getFactory(false);
//        shape s3 = af3.getshape("rectangle");
//        s3.drow();
//        AbstractFactory af4 = FactoryProcdure.getFactory(false);
//        shape s4 = af4.getshape("square");
//        s4.drow();
    }
}

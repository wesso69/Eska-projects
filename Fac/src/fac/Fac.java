package fac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fac {

    public static void main(String[] args) throws IOException {
        getPlan getplan = new getPlan();
        System.out.println("Enter the name of the plan which you want the bill to be generated");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String planName = br.readLine();
        System.out.println("Enter number of units u want to be calculated");
        int units = Integer.parseInt(br.readLine());
        Plan p = getplan.getPlanFactory(planName);
        System.out.print("Bill amount of :" + units + " for plan : " + planName + " = ");
        p.getRate();
        p.calcBil(units);
    }

}

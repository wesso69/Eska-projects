package dp.sing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 *
 * @author W.Shraideh
 */
public class DpSing {

    static int count = 1;
    static int choice;

    public static void main(String[] args) throws IOException, SQLException {

        jdbcSing jdbc = jdbcSing.getInstatnce();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
        do {
            System.out.println("DATABASE OPERATIONS");
            System.out.println(" --------------------- ");
            System.out.println(" 1. Insertion ");
            System.out.println(" 2. View  one person    ");
            System.out.println(" 3. view all persons    ");
            System.out.println(" 5. Exit      ");
            System.out.print("\n");
            System.out.print("Please enter the choice what you want to perform in the database: ");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1: {
                    System.out.print("Enter the id you want to insert data into the database: ");
                    String id = br.readLine();
                    int pid = Integer.parseInt(id);
                    System.out.print("Enter the name you want to insert data into the database: ");
                    String name = br.readLine();

                    try {
                        int i = jdbc.insert(pid, name);
                        if (i > 0) {
                            System.out.println((count++) + " Data has been inserted successfully");
                        } else {
                            System.out.println("Data has not been inserted ");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.println("Press Enter key to continue...");
                    System.in.read();

                }//End of case 1  
                break;
                case 2: {
                    System.out.print("Enter the id : ");
                    String id = br.readLine();
                    int pid = Integer.parseInt(id);
                    try {
                        jdbc.view(pid);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();

                }//End of case 2  
                break;
                case 3: {
                    System.out.println("all the persons  :");
                    try {
                        jdbc.viewAll();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;
                default:
                    return;

            }
        } while (choice != 3);
        {

        }

    }
}

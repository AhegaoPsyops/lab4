import javax.swing.*;
import java.util.Scanner;
/*
The dataVisualizer object exists as a facade, allowing users to custom input specific data
values, or just runs with the default data file and values.
included testing.txt for an alternate option without creation
 */

public class guiMain {
    public static void main(String[] args) {
        // take user input for data values for the string
        Scanner sc = new Scanner(System.in);
        String dataFile;
        System.out.println("Choose an Option: \n1: Default Data file\n2: Input Custom Data file");
        int choice = sc.nextInt();
        if (choice == 1) {
            dataFile = "Ratio-Index.txt";
            // System.out.println("Default Data file selected: " + dataFile);
        }else if (choice == 2) {
            System.out.println("Input Custom .txt file: ");
            dataFile = sc.next();
        } else {
            System.out.println("Invalid Choice. Running default file. ");
            dataFile = "Ratio-Index.txt";
        }
        System.out.println("\nReading " + dataFile);


        SwingUtilities.invokeLater(() -> new dataVisualizer(dataFile).setVisible(true));
    }
}

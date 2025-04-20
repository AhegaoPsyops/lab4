// Ethan Dykes
// class with main that will show the data visualization
// implements separate GUI objects like charts and panels from their own classes. Limitations on its capability and you will see
// several degraded objects. Time crunch (once again)

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/*
Design Pattern implementation.
Facade
Improving by removing the basic main from this class, and instead making it into a driver that takes basic inputs for display.
This is just grep in Linux lol

 */

public class dataVisualizer extends JFrame {
    // dataVisualizer now takes the file as an input, and turns it into the data that is displayed
    Scanner sc = new Scanner(System.in);
    public dataVisualizer(String filename) {
        dataReader reader = new dataReader(filename);
        List<String[]> fileData = new ArrayList<>();
        List<String> lines = reader.getLines();
        String headers = lines.get(0);
        lines.remove(0); // remove header data
        for (String line : lines) {
            String[] columns = line.split("\t"); // .txt file, delimited via tab
            if (columns.length > 15) { // If data is missing a column (some have incomplete data) skips that row, prevents bad by having a date thrown into an average calculation
                fileData.add(new String[]{columns[0], columns[1], columns[6], columns[15]});
            }
        }
        System.out.println("File Headers:");
        System.out.println(headers);
        if (filename != "Ratio-Index.txt") {
            System.out.println("Would you like to customize the headers? (Y/N)");
            String answer = sc.nextLine();
            if(answer.equals("Y") || answer.equals("y")) {
                // fill in with methods rewriting the basic file headers
                // not done due to the complexity of work, right now I am demonstratrating that it can be filled in if needed
            } else if (answer.equals("N") || answer.equals("n")) {
                System.out.println("Keeping Default Solar Flare Headers");
            }

        }


        setTitle("Data Visualizer");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tablePanel tablePanel = new tablePanel(fileData);
        statistics statsPanel = new statistics(fileData);
        chartPanel chartPanel = new chartPanel(fileData);
        detailsPanel detailsPanel = new detailsPanel();

        add(tablePanel, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.EAST);
        add(detailsPanel, BorderLayout.SOUTH);

    }
// Invokes dataReader, which parses the data, and then throws it into the GUI
    /*public static void main(String[] args) {
        String data = "Ratio-Index.txt";
        dataReader reader = new dataReader(data);
        List<String[]> fileData = new ArrayList<>();
        List<String> lines = reader.getLines();
        lines.remove(0); // remove header data
        for (String line : lines) {
            String[] columns = line.split("\t"); // .txt file, delimited via tab
            if (columns.length > 15) { // If data is missing a column (some have incomplete data) skips that row, prevents bad by having a date thrown into an average calculation
                fileData.add(new String[]{columns[0], columns[1], columns[6], columns[15]});
            }
        }
        SwingUtilities.invokeLater(() -> new dataVisualizer(fileData).setVisible(true));
    }
*/
}
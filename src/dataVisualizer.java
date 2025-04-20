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
    public dataVisualizer(List<String[]> data) {
        setTitle("Data Visualizer");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tablePanel tablePanel = new tablePanel(data);
        statistics statsPanel = new statistics(data);
        chartPanel chartPanel = new chartPanel(data);
        detailsPanel detailsPanel = new detailsPanel();

        add(tablePanel, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.EAST);
        add(detailsPanel, BorderLayout.SOUTH);
    }
// Invokes dataReader, which parses the data, and then throws it into the GUI
    public static void main(String[] args) {
        dataReader reader = new dataReader();
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
}


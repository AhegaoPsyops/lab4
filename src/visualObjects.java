import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.util.*;

/*
Implement a Builder Design Pattern.
This allows for any form of abstraction so we separate the data reading from the data
when we push to our visual objects. This theoretically allows more involved and flexible
visual object completion.
 */

public class visualObjects extends JPanel {
    public visualObjects(List<String[]> fileData) {
        tablePanel tablePanel = new tablePanel(fileData);
        statistics statsPanel = new statistics(fileData);
        chartPanel chartPanel = new chartPanel(fileData);
        detailsPanel detailsPanel = new detailsPanel();

        add(tablePanel, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.EAST);
        add(detailsPanel, BorderLayout.SOUTH);
    }

}

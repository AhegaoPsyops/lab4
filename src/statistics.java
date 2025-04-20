import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// creates the statsPanel
// also calculates everything we see. had issues passing and accessing data between objects, so it is now all one class

class statistics extends JPanel {
    public statistics(List<String[]> data) {
        setLayout(new GridLayout(2, 1));
        statistics(data);
    }

    private void statistics(List<String[]> data) {
        int count = data.size();
        double maxIntensity = Double.MIN_VALUE;
        String maxIntensityYear = "";
        Map<String, Integer> eventCountByYear = new HashMap<>();

        for (String[] row : data) {
            String year = row[1].split("\\.")[0];
            eventCountByYear.put(year, eventCountByYear.getOrDefault(year, 0) + 1);

            double intensity = safeParseDouble(row[3]); // because somehow I just couldn't pass the row value, see function comments.
            if (intensity > maxIntensity) {
                maxIntensity = intensity;
                maxIntensityYear = year;
            }
        }
// creates the header of chart that we see above
        // yeah yeah, the title should be bigger but theres other things missing. focus on those
        add(new JLabel("Solar Events from 2007 to 2017."));
        add(new JLabel("Total Entries: " + count));
        add(new JLabel("Year with highest intensity: " + maxIntensityYear));
    }

    private double safeParseDouble(String value) { /* Dude I dont know what this is either
    ended up having issues passing the data from the txt to the data table.
    Found it somewhere deep in stackExchange */
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

}
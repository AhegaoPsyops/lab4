import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Creates panel and applies a chart to it

// JFree chart did not want to work with me, so I got drunk and wrote it using basic graphics functions in javax.swing
// Trust me, I dont understand it either

class chartPanel extends JPanel {
    private List<String[]> data;
    private String chartLabel = "Events per Year";
    public chartPanel(List<String[]> data) {
        this.data = data;
        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBarGraph(g);
    }

    // I was 6 drinks deep here, I apologize
    private void drawBarGraph(Graphics g) {
        // because i wasnt able to implement J Graphics, this was handmade, and cant really be turned into another class
        if (data.isEmpty()) return;
        Map<String, Integer> eventCountByYear = new HashMap<>(); // does this count as Streams?
        for (String[] row : data) {
            String year = row[1].split("\\.")[0];
            eventCountByYear.put(year, eventCountByYear.getOrDefault(year, 0) + 1);
        }

        int width = getWidth();
        int height = getHeight();
        int margin = 40;
        int barWidth = (width - 2 * margin) / eventCountByYear.size();

        g.setColor(Color.BLACK);
        g.drawLine(margin, height - margin, width - margin, height - margin);
        g.drawLine(margin, height - margin, margin, margin);
        g.drawString(chartLabel, width / 2 - 40, height - 10);

        int maxEvents = Collections.max(eventCountByYear.values());
        int index = 0;

        g.setColor(Color.BLUE);
        for (Map.Entry<String, Integer> entry : eventCountByYear.entrySet()) {
            int barHeight = (int) ((double) entry.getValue() / maxEvents * (height - 2 * margin));
            g.fillRect(margin + index * barWidth, height - margin - barHeight, barWidth - 2, barHeight);
            g.drawString(entry.getKey(), margin + index * barWidth, height - margin + 15);
            index++;
        }
    }
    public void setChartLabel(String input){
        chartLabel = input;
    }
}
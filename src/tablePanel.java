import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// Creates basic tabelPanel in UI, and loads data into GUI Panel

class tablePanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public tablePanel(List<String[]> data) {
        setLayout(new BorderLayout());
        tableModel = new DefaultTableModel(new String[]{"Date", "Year", "Duration", "Intensity"}, 0); // I wanted to add class_flare, but has a tendency to cram
        // the rest of the data
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table), BorderLayout.CENTER);
        loadData(data);
    }

    // Data loaded into table in GUI
    private void loadData(List<String[]> data) {
        for (String[] row : data) {
            tableModel.addRow(new Object[]{row[0], row[1].split("\\.")[0], row[2], row[3]});
        }
    }
    public void setTableHeaders(String[] headers) {

    }
// returns the whole table as an object
    // degraded, I ended up not doing so as it was easier to implement in main.
    // kept as an artifact in bug testing
    public JTable getTable() {
        return table;
    }
}
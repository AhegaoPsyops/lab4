import javax.swing.*;
import java.awt.*;

class detailsPanel extends JPanel {
    private JLabel detailsLabel;
    // it was supposed to do something but doenst because I ran out of time.

    public detailsPanel() {
        setLayout(new BorderLayout());
        detailsLabel = new JLabel("Select an item for details.");
        add(detailsLabel, BorderLayout.CENTER);
    }

}

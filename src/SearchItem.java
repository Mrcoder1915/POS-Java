import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SearchItem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int frameWidth = 700;
            int frameHeight = 600;

            JFrame frame = new JFrame();
            frame.setUndecorated(true);
            frame.setSize(frameWidth, frameHeight);
            frame.setLocationRelativeTo(null);

            JPanel background = new JPanel();
            background.setLayout(null);
            background.setBackground(Color.DARK_GRAY);

            JPanel searchPanel = new JPanel();
            searchPanel.setLayout(new BorderLayout());
            searchPanel.setBounds(30, 20, 580, 30);
            searchPanel.setBackground(Color.DARK_GRAY);

            RoundedTextField searchField = new RoundedTextField(30);
            searchField.setText("Search item...");
            searchPanel.add(searchField, BorderLayout.CENTER);

            JPanel itemList = new JPanel();
            itemList.setLayout(new GridLayout(10, 1, 0, 5));
            itemList.setBounds(30, 70, 580, 350);
            itemList.setBackground(Color.DARK_GRAY);

            for (int i = 0; i < 10; i++) {
                JPanel itemRow = new JPanel(new BorderLayout());
                itemRow.setBackground(Color.DARK_GRAY);
                itemRow.setPreferredSize(new Dimension(560, 30));
                itemRow.setOpaque(true);
                itemRow.setBorder(new EmptyBorder(5, 10, 5, 10));

                JLabel itemName = new JLabel("Dairy milk chocolate 10g");
                JLabel itemPrice = new JLabel("125", SwingConstants.RIGHT);
                itemName.setForeground(Color.WHITE);
                itemPrice.setForeground(Color.WHITE);

                itemRow.add(itemName, BorderLayout.WEST);
                itemRow.add(itemPrice, BorderLayout.EAST);

                itemList.add(itemRow);
            }

            background.add(searchPanel);
            background.add(itemList);

            frame.setContentPane(background);
            frame.setVisible(true);
        });
    }

    static class RoundedTextField extends JTextField {
        private int arc;

        public RoundedTextField(int arc) {
            this.arc = arc;
            setOpaque(false);
            setForeground(Color.WHITE);
            setBackground(new Color(37, 57, 60));
            setFont(new Font("Arial", Font.PLAIN, 14));
            setCaretColor(Color.WHITE);
            setBorder(new EmptyBorder(8, 15, 8, 15));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            // No border painting to keep it clean
        }
    }
}

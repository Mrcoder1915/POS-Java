import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DailySalesPage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int frameWidth = 700;
            int frameHeight = 600;
            int cornerRadius = 40;

            JFrame frame = new JFrame();
            frame.setUndecorated(true);
            frame.setSize(frameWidth, frameHeight);
            frame.setLocationRelativeTo(null);
            frame.setShape(new RoundRectangle2D.Double(0, 0, frameWidth, frameHeight, cornerRadius, cornerRadius));

            JPanel background = new JPanel();
            background.setLayout(null);
            background.setBackground(Color.WHITE);

            
            JPanel itemList = new JPanel();
            itemList.setLayout(new GridLayout(10, 1, 0, 5));
            itemList.setBackground(Color.WHITE);
            itemList.setBounds(30, 30, 580, 350);

            for (int i = 0; i < 10; i++) {
                JPanel itemRow = new JPanel();
                itemRow.setLayout(new BorderLayout());
                itemRow.setBackground(Color.WHITE);
                itemRow.setPreferredSize(new Dimension(560, 30));
                itemRow.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                itemRow.setOpaque(true);

                JLabel itemName = new JLabel("Dairy milk chocolate 10g");
                JLabel itemPrice = new JLabel("125", SwingConstants.RIGHT);

                itemRow.add(itemName, BorderLayout.WEST);
                itemRow.add(itemPrice, BorderLayout.EAST);

                itemRow.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 0, true),
                        new EmptyBorder(0, 10, 0, 10)
                ));

                itemList.add(itemRow);
            }

            background.add(itemList);

            JPanel footer = new JPanel();
            footer.setLayout(null);
            footer.setBounds(0, frameHeight - 100, frameWidth, 100);
            footer.setBackground(new Color(33, 51, 51));

            JLabel total = new JLabel("TOTAL SALES :  php: 2350");
            total.setForeground(Color.WHITE);
            total.setFont(new Font("SansSerif", Font.BOLD, 20));
            total.setBounds(60, 20, 400, 30);
            footer.add(total);

            JButton closeButton = new JButton("CLOSE") {
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(new Color(90, 85, 85));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                    super.paintComponent(g2);
                    g2.dispose();
                }

                protected void paintBorder(Graphics g) {}
            };
            closeButton.setBounds(560, 20, 100, 40);
            closeButton.setForeground(Color.WHITE);
            closeButton.setFont(new Font("SansSerif", Font.BOLD, 16));
            closeButton.setContentAreaFilled(false);
            closeButton.setFocusPainted(false);
            closeButton.addActionListener(e -> System.exit(0));
            footer.add(closeButton);

            background.add(footer);

            frame.setContentPane(background);
            frame.setVisible(true);
        });
    }
}

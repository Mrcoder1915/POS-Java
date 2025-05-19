import java.awt.*;
import javax.swing.*;

public class CashInputUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog dialog = new JDialog((Frame) null, "Enter Cash", true);
            dialog.setUndecorated(true);
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setBackground(new Color(0, 0, 0, 0));

            JPanel contentPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(new Color(60, 60, 60));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                    g2.dispose();
                    super.paintComponent(g);
                }
            };

            contentPanel.setLayout(null);
            contentPanel.setOpaque(false);

            JLabel titleLabel = new JLabel("Enter Cash", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            titleLabel.setForeground(Color.LIGHT_GRAY);
            titleLabel.setBounds(0, 2, 300, 20);
            contentPanel.add(titleLabel);

            JLabel phpLabel = new JLabel("PHP");
            phpLabel.setFont(new Font("Arial", Font.BOLD, 14));
            phpLabel.setForeground(Color.WHITE);
            phpLabel.setBounds(40, 35, 40, 25);
            contentPanel.add(phpLabel);

            JTextField cashField = new JTextField("2000");
            cashField.setFont(new Font("Courier New", Font.PLAIN, 16));
            cashField.setBackground(new Color(25, 40, 45));
            cashField.setForeground(Color.WHITE);
            cashField.setCaretColor(Color.WHITE);
            cashField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            cashField.setBounds(80, 35, 150, 25);
            contentPanel.add(cashField);

            dialog.setContentPane(contentPanel);
            dialog.setVisible(true);
        });
    }
}

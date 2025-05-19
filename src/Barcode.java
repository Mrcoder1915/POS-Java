import java.awt.*;
import javax.swing.*;

public class Barcode {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog dialog = new JDialog((Frame) null, "Enter Barcode", true);
            dialog.setUndecorated(true);
            dialog.setSize(420, 220);
            dialog.setLocationRelativeTo(null);
            dialog.setBackground(new Color(0, 0, 0, 0));

            JPanel contentPanel = new JPanel(new GridBagLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(new Color(50, 50, 50, 220));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                    g2.dispose();
                    super.paintComponent(g);
                }
            };
            contentPanel.setOpaque(false);
            contentPanel.setLayout(null);
            dialog.setContentPane(contentPanel);

            JButton closeBtn = new JButton("x");
            closeBtn.setBounds(385, 5, 30, 30);
            closeBtn.setForeground(Color.WHITE);
            closeBtn.setBackground(new Color(90, 90, 90));
            closeBtn.setBorderPainted(false);
            closeBtn.setFocusPainted(false);
            closeBtn.setFont(new Font("Arial", Font.BOLD, 14));
            closeBtn.addActionListener(e -> dialog.dispose());
            contentPanel.add(closeBtn);

            JLabel titleLabel = new JLabel("Enter Barcode", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setBounds(0, 15, 420, 30);
            contentPanel.add(titleLabel);

            JLabel barcodeLabel = new JLabel("Barcode:");
            barcodeLabel.setForeground(Color.LIGHT_GRAY);
            barcodeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
            barcodeLabel.setBounds(30, 70, 100, 25);
            contentPanel.add(barcodeLabel);

            JTextField barcodeField = new JTextField();
            barcodeField.setFont(new Font("Courier New", Font.PLAIN, 16));
            barcodeField.setBounds(130, 65, 250, 40);
            contentPanel.add(barcodeField);

            JLabel itemLabel = new JLabel("Item:");
            itemLabel.setForeground(Color.LIGHT_GRAY);
            itemLabel.setFont(new Font("Arial", Font.PLAIN, 25));
            itemLabel.setBounds(30, 135, 100, 25);
            contentPanel.add(itemLabel);

            JTextField itemField = new JTextField();
            itemField.setFont(new Font("Courier New", Font.PLAIN, 16));
            itemField.setBounds(130, 130, 250, 35);
            contentPanel.add(itemField);

            dialog.setVisible(true);
        });
    }
}

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SalesDashboardUI extends JFrame {

    public SalesDashboardUI() {
        setTitle("Sales Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(70, 70, 75));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(70, 70, 75));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(50, 30, 50, 30);

        RoundedButton dailySalesBtn = new RoundedButton("DAILY SALES");
        RoundedButton topSellingBtn = new RoundedButton("TOP SELLING<br>PRODUCTS");
        RoundedButton manageProductsBtn = new RoundedButton("MANAGE PRODUCTS");
        RoundedButton viewSalesBtn = new RoundedButton("VIEW ALL SALES");
        RoundedButton addCashierBtn = new RoundedButton("ADD CASHIER");

        // ➕ Button click actions
        // dailySalesBtn.addActionListener(e -> new DailySalesPage().setVisible(true));
        // topSellingBtn.addActionListener(e -> new TopSellingPage().setVisible(true));
        // manageProductsBtn.addActionListener(e -> new ManageProductsPage().setVisible(true));
        // viewSalesBtn.addActionListener(e -> new ViewAllSalesPage().setVisible(true));
        // addCashierBtn.addActionListener(e -> new AddCashierPage().setVisible(true));

        // First row
        gbc.gridy = 0;
        gbc.gridx = 0;
        panel.add(dailySalesBtn, gbc);
        gbc.gridx = 1;
        panel.add(topSellingBtn, gbc);
        gbc.gridx = 2;
        panel.add(manageProductsBtn, gbc);

        // Second row
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel bottomRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        bottomRow.setBackground(new Color(70, 70, 75));
        bottomRow.add(viewSalesBtn);
        bottomRow.add(addCashierBtn);
        panel.add(bottomRow, gbc);

        add(panel);
    }

    static class RoundedButton extends JButton {
        public RoundedButton(String htmlText) {
            super("<html><center>" + htmlText + "</center></html>");
            setPreferredSize(new Dimension(280, 130));
            setBackground(new Color(30, 50, 55));
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, 16));
            setFocusPainted(false);
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(10, 20, 10, 20));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            // No border painting
        }

        @Override
        public boolean contains(int x, int y) {
            return new Rectangle(0, 0, getWidth(), getHeight()).contains(x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SalesDashboardUI().setVisible(true);
        });
    }
}

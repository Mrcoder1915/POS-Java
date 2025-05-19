import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class uiFrame extends JFrame {

    public uiFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 620);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(51, 51, 51));

        initUI();
        initBarcodeDialog();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTextArea itemListArea;
    private JLabel cashLabel, changeLabel;
    private JDialog barcodeDialog;

    private void initUI() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(51, 51, 51));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        itemListArea = new JTextArea();
        itemListArea.setEditable(false);
        itemListArea.setBackground(new Color(41, 59, 61));
        itemListArea.setForeground(Color.WHITE);
        itemListArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        itemListArea.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 10, true));

        JScrollPane scrollPane = new JScrollPane(itemListArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(new Color(41, 59, 61));
        detailsPanel.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 10, true));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, detailsPanel);
        splitPane.setResizeWeight(0.65); // 65% left, 35% right
        splitPane.setDividerSize(10);
        splitPane.setBorder(null);
        splitPane.setContinuousLayout(true);

        splitPane.setUI(new BasicSplitPaneUI() {
            @Override
            public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this) {
                    @Override
                    public void paint(Graphics g) {
                        g.setColor(new Color(51, 51, 51));
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
            }
        });

        centerPanel.add(splitPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(51, 51, 51));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JPanel cashChangePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        cashChangePanel.setBackground(new Color(51, 51, 51));
        cashLabel = new JLabel("CASH: 0");
        cashLabel.setForeground(Color.WHITE);
        cashLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        changeLabel = new JLabel("CHANGE: 0");
        changeLabel.setForeground(Color.WHITE);
        changeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        cashChangePanel.add(cashLabel);
        cashChangePanel.add(changeLabel);
        bottomPanel.add(cashChangePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 7, 10, 5));
        buttonPanel.setBackground(new Color(51, 51, 51));
        String[] buttons = {"F1\nEnter Cash", "F2\nSearch Item", "F3\nRemove Item", "F4\nNew", "F5\nCancel", "F6\nLog Out", "123456789"};

        for (String text : buttons) {
            String label = text.split("\n")[0];
            JButton button = new JButton("<html><center>" + text.replace("\n", "<br>") + "</center></html>");
            button.setPreferredSize(new Dimension(120, 80));
            button.setBackground(new Color(41, 59, 61));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 8, true));

            button.addActionListener(e -> {
                switch (label) {
                    case "F1":
                        openEnterCashPage();
                        break;
                    case "F2":
                        openSearchItemPage();
                        break;
                    case "F3":
                        openRemoveItemPage();
                        break;
                    case "F4":
                        openNewTransactionPage();
                        break;
                    case "F5":
                        cancelTransaction();
                        break;
                    case "F6":
                        logout();
                        break;
                    case "123456789":
                        showSpecialPage();
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "No action assigned for: " + label);
                }
            });

            buttonPanel.add(button);
        }

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initBarcodeDialog() {
        barcodeDialog = new JDialog(this, "Enter Barcode", true);
        barcodeDialog.setSize(350, 300);
        barcodeDialog.setLayout(new GridBagLayout());
        barcodeDialog.getContentPane().setBackground(new Color(73, 86, 88));
        barcodeDialog.setLocationRelativeTo(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Enter Barcode", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        barcodeDialog.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        barcodeDialog.add(new JLabel("Barcode:"), gbc);
        gbc.gridx = 1;
        barcodeDialog.add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        barcodeDialog.add(new JLabel("Item:"), gbc);
        gbc.gridx = 1;
        barcodeDialog.add(new JLabel("---"), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        barcodeDialog.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        barcodeDialog.add(new JTextField(), gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy++;
        JButton closeBtn = new JButton("Close");
        barcodeDialog.add(closeBtn, gbc);

        closeBtn.addActionListener(e -> barcodeDialog.setVisible(false));
    }



    private void openEnterCashPage() {
        JOptionPane.showMessageDialog(this, "Opening Enter Cash Page...");
        // new EnterCashFrame().setVisible(true);
    }

    private void openSearchItemPage() {
        JOptionPane.showMessageDialog(this, "Opening Search Item Page...");
        // new SearchItemFrame().setVisible(true);
    }

    private void openRemoveItemPage() {
        JOptionPane.showMessageDialog(this, "Opening Remove Item Page...");
        // new RemoveItemFrame().setVisible(true);
    }

    private void openNewTransactionPage() {
        JOptionPane.showMessageDialog(this, "Opening New Transaction Page...");
        // new NewTransactionFrame().setVisible(true);
    }

    private void cancelTransaction() {
        JOptionPane.showMessageDialog(this, "Transaction Cancelled.");
        // Additional logic to clear fields or reset form
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose(); // or redirect to login page
        }
    }

    private void showSpecialPage() {
        JOptionPane.showMessageDialog(this, "Opening Special Page...");
        // new SpecialFrame().setVisible(true);
    }

    public static void main(String[] args) {
        new uiFrame();
    }
}

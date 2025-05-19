import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusinessLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}

class LoginFrame extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public LoginFrame() {
        setTitle("Login");
        setSize(360, 400); // Slightly larger frame
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300)); // Larger panel
        panel.setBackground(new Color(224, 224, 224));
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true));

        JLabel title = new JLabel("BUSSINESS LOGO", SwingConstants.CENTER);
        title.setBounds(10, 20, 280, 25); // More padding top
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(title);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        userLabel.setBounds(30, 60, 100, 15);
        panel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(30, 75, 240, 30); // Wider input
        panel.add(userField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        passLabel.setBounds(30, 115, 100, 15);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(30, 130, 240, 30); // Wider input
        panel.add(passField);

        JButton signInButton = new JButton("Sign In");
        signInButton.setBounds(30, 180, 240, 35); // Larger button
        signInButton.setBackground(new Color(28, 43, 45));
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);
        signInButton.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(signInButton);

        add(panel);

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    dispose();
                    new LogoFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login!");
                }
            }
        });

        setVisible(true);
    }
}

class LogoFrame extends JFrame {
    public LogoFrame() {
        setTitle("Business Logo");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new BusinessLogo());
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class BusinessLogo extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        g.setColor(new Color(0, 102, 204));
        g.fillOval(50, 50, 100, 100);

        g.setFont(new Font("SansSerif", Font.BOLD, 24));
        g.setColor(Color.BLACK);
        g.drawString("MyBiz Tech", 170, 110);

        g.setFont(new Font("SansSerif", Font.ITALIC, 16));
        g.drawString("Innovate Your Future", 170, 140);
    }
}

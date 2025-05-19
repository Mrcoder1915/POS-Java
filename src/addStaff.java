import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

// import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class addStaff extends JFrame{
    public addStaff(){
        setTitle("AddStaff");
        setSize(350, 400);
        setVisible(false);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2,1,5,0));
        JPanel panel1 = new JPanel(new GridLayout(2,1,5,0));
        JPanel panel2 = new JPanel(new GridLayout(2,1,5,0));

        JLabel Header = new JLabel("ADD STAFF");
        JLabel userName = new JLabel("Username");
        JLabel Pass = new JLabel("Password");
        JLabel Pin = new JLabel("Pin");
        JTextField userNameField = new JTextField(25);
        JPasswordField passwordField = new JPasswordField(25);
        JTextField pinField = new JTextField(25);
        JButton SignIn = new JButton("Sign In");
    

        SignIn.setPreferredSize(new Dimension(280,30));

        Header.setFont(new Font("Arial", Font.BOLD, 30 ));

        userNameField.setPreferredSize(new Dimension(300, 30));
        passwordField.setPreferredSize(new Dimension(300, 30));
        pinField.setPreferredSize(new Dimension(300, 30));

        panel.add(userName,BorderLayout.CENTER);
        panel.add(userNameField, BorderLayout.CENTER);
        panel1.add(Pass);
        panel1.add(passwordField);
        panel2.add(Pin);
        panel2.add(pinField);


        add(Header);
        add(panel);
        add(panel1);
        add(panel2);
        add(SignIn);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

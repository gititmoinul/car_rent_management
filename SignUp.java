package rentyourcar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener {
        
    private JTextField idTf;
    private JLabel titleLabel1,titleLabel2;
    private JPasswordField pF;
    private JButton loginBtn, signupBtn;

    SignUp() {

        getContentPane().setBackground(Color.getHSBColor(0.33f, 0.3f, 0.6f));
        setLayout(null);

        //Font
        Font f1 = new Font("ARIAL", Font.BOLD, 22);
        Font f2 = new Font("Raleway", Font.BOLD, 14);

        //setTitle
        titleLabel1 = new JLabel("Register to");
        titleLabel1.setBounds(120, 25, 380, 100);
        titleLabel1.setFont(f1);
        add(titleLabel1);

        titleLabel2 = new JLabel("InviCarTar");
        titleLabel2.setBounds(150, 45, 380, 120);
        titleLabel2.setForeground(Color.red);
        titleLabel2.setFont(new Font("Raleway", Font.BOLD, 40));
        add(titleLabel2);

        //userLabel & TextField
        JLabel idLabel = new JLabel("Set Username");
        idLabel.setBounds(75, 150, 250, 25);
        idLabel.setFont(f2);
        add(idLabel);

        idTf = new JTextField();
        idTf.setBounds(75, 175, 350, 40);
        add(idTf);

        //PasswordLabel & PasswordField
        JLabel passLabel = new JLabel("Set Password");
        passLabel.setBounds(75, 220, 250, 25);
        passLabel.setFont(f2);
        add(passLabel);

        pF = new JPasswordField();
        pF.setBounds(75, 245, 350, 40);
        add(pF);

        //Adding Buttons
        signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(75, 315, 350, 50);
        signupBtn.addActionListener(this);
        add(signupBtn);

        JLabel textLabel = new JLabel("Already have an account?");
        textLabel.setBounds(75, 400, 200, 25);
        textLabel.setFont(f2);
        add(textLabel);

        loginBtn = new JButton("Log In");
        loginBtn.setBounds(300, 390, 125, 50);
        loginBtn.setBackground(Color.black);
        loginBtn.setForeground(Color.white);
        add(loginBtn);

        setSize(500, 600);
        setLocationRelativeTo(null);
        setTitle("Sign Up Frame");
        setVisible(true);

    }

    public static void main(String[] args) {
        new SignUp();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == signupBtn) {

            String userName = idTf.getText();
            String password = pF.getText();

            try {
                DatabaseConnection c = new DatabaseConnection();
                String query = "insert into loginuser values('" + userName + "', '" + password + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Successfully Registered");
                setVisible(false);
                new LogIn();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == loginBtn) {

            setVisible(false);
            new LogIn();
        }
    }

}

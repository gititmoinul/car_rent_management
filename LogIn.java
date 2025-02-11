package rentyourcar;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogIn extends JFrame implements ActionListener{
    
    private final Font f1;
    private final Font f2;
    private JLabel titleLabel1,titleLabel2,textLabel1,Label2,idLabel,passLabel;
    private final JTextField idTf;
    private final JPasswordField pF;
    private final JButton signupBtn;
    private JButton loginBtn,adminBtn;
    
        LogIn(){
            
            getContentPane().setBackground(Color.getHSBColor(0.33f,0.3f,0.6f));
            setLayout(null);
            

           
            //Font
            f1= new Font("ARIAL",Font.BOLD,18);
            f2= new Font("Raleway",Font.BOLD,14);
            
            //setTitle
            titleLabel1 = new JLabel("Welcome To");
            titleLabel1.setBounds(120,45,380,100);
            titleLabel1.setFont(f1);
            add(titleLabel1);
            
            titleLabel2 = new JLabel("InviCarTar");
            titleLabel2.setBounds(150,65,380,120);
            titleLabel2.setForeground(Color.red);
            titleLabel2.setFont(new Font("Raleway",Font.BOLD,40));
            add(titleLabel2);
            
            //userLabel & TextField
            idLabel=new JLabel("Enter Username or Mail");
            idLabel.setBounds(60,175,200,25);
            idLabel.setFont(f2);
            add(idLabel);
            
            idTf = new JTextField();
            idTf.setBounds(60,200,370,40);
            add(idTf);
            
            //PasswordLabel & TextField
            passLabel=new JLabel("Enter Password");
            passLabel.setBounds(60,260,200,25);
            passLabel.setFont(f2);
            add(passLabel);
            
            pF = new JPasswordField();
            pF.setBounds(60,285,370,40);
            add(pF );
            
            textLabel1 = new JLabel("Don't have an account? Sign Up");
            textLabel1.setBounds(60,350,400,25);
            add(textLabel1);
            
            
            // LogIn-SignUp-Admin Button
            
            signupBtn = new JButton("Sign Up");
            signupBtn.setBounds(150,380,200,50);
            signupBtn.addActionListener(this);
            add(signupBtn);
            
            loginBtn = new JButton("Log In");
            loginBtn.setBounds(150,455,200,50);
            loginBtn.addActionListener(this);
            add(loginBtn);
            
            adminBtn = new JButton("Admin");
            adminBtn.setBounds(150,530,200,50);
            adminBtn.addActionListener(this);
            add(adminBtn);
            
            
                        
            setSize(500,650);
            setLocationRelativeTo(null);
            setTitle("Login Frame");
            setVisible(true);
            
           
        }

    
    public static void main(String[] args) {
            new LogIn();
 
 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signupBtn) {
            setVisible(false);
            new SignUp();
            
        } else if (ae.getSource() == loginBtn) {
            try {
                String userName = idTf.getText();
                String password = pF.getText();
                String query = "select * from loginuser where username = '"+userName+"' and password = '"+password+"' ";
                
                DatabaseConnection c = new DatabaseConnection();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Successfully logged in");
                    new RentalSystem2();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == adminBtn){
                        try {
                String userName = idTf.getText();
                String password = pF.getText();
                String query = "select * from login where username = '"+userName+"' and password = '"+password+"' ";
                
                DatabaseConnection c = new DatabaseConnection();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Successfully logged in");
                    new HomeRentCar();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Administrator");
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    
    
}

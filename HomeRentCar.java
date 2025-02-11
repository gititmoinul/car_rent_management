package rentyourcar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class HomeRentCar extends JFrame implements ActionListener{
    
    private  Font f1,f2;
    private  JLabel image, heading;
    private  JButton addBtn,viewBtn,updateBtn,removeBtn;
    private  ImageIcon icon,icon3;
    private  Image icon2;
    
        HomeRentCar(){
            
            getContentPane().setBackground(Color.white);
            setLayout(null);
            

           
            //Font
            f1= new Font("ARIAL",Font.BOLD,22);
            f2= new Font("Raleway",Font.BOLD,14);
           
            /*
            icon = new ImageIcon(getClass().getResource("/source/car.jpg"));
            icon2 = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            image = new JLabel(new ImageIcon(icon2));
            image.setBounds(200,200,100,100);
            add(image);
            */
            
            //Heading
            
            heading = new JLabel("InvoCarTar");
            heading.setBounds(450,20,400,50);
            //heading.setForeground(Color.magenta);
            heading.setFont(new Font("Raleway",Font.BOLD,30));
            add(heading);
            
            //Button
            
            addBtn = new JButton("Add Trip");
            addBtn.setBounds(320,75,200,50);
            addBtn.setFont(f2);
            addBtn.setBackground(Color.black);
            addBtn.setForeground(Color.white);
            addBtn.addActionListener(this);
            add(addBtn);
            
            viewBtn = new JButton("View Trip");
            viewBtn.setBounds(550,75,200,50);
            viewBtn.setFont(f2);
            viewBtn.setBackground(Color.black);
            viewBtn.setForeground(Color.white);
            viewBtn.addActionListener(this);
            add(viewBtn);
            
            updateBtn = new JButton("Update Trip");
            updateBtn.setBounds(320,150,200,50);
            updateBtn.setFont(f2);
            updateBtn.setBackground(Color.black);
            updateBtn.setForeground(Color.white);
            updateBtn.addActionListener(this);
            add(updateBtn);
            
            removeBtn = new JButton("Remove Trip");
            removeBtn.setBounds(550,150,200,50);
            removeBtn.setFont(f2);
            removeBtn.setBackground(Color.black);
            removeBtn.setForeground(Color.white);
            removeBtn.addActionListener(this);
            add(removeBtn);
            
            
                        
            setSize(800,600);
            setLocationRelativeTo(null);
            setTitle("Administrator");
            setVisible(true);
            
           
        }

    
    public static void main(String[] args) {
            new HomeRentCar();
 
 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn){
            setVisible(false);
            new RentalSystem();
        }
        else if(ae.getSource() == viewBtn){
            setVisible(false);
            new ViewBooking();
            
        }
        else if(ae.getSource() == updateBtn){
            setVisible(false);
            new ViewBooking();
        }
        else if(ae.getSource() == removeBtn){
            setVisible(false);
            new RemoRentalInfo();
        }
    }


    
    
}

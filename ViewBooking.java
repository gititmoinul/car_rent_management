package rentyourcar;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class ViewBooking extends JFrame implements ActionListener {

    private Font f1, f2;
    private JLabel searchLabel;
    private JButton searchBtn, printBtn, updateBtn, backBtn;
    private JTable viewTable;
    private JScrollPane scrollPane;
    private Choice bookingId;
    private ImageIcon icon, icon3;
    private Image icon2;

    ViewBooking() {

        getContentPane().setBackground(Color.getHSBColor(0.33f, 0.3f, 0.6f));
        setLayout(
                null);

        //Font
        f1 = new Font("Raleway", Font.BOLD, 12);
        f2 = new Font("Raleway", Font.BOLD, 14);

        //addImage
        /*
            icon = new ImageIcon(ClassLoader.getSystemResource("image/car.jpg"));
            icon2 = icon.getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
            icon3 = new ImageIcon(icon2);
            image = new JLabel(icon3);
            image.setBounds(0,0,800,600);
            add(image);
         */
        //Table
        viewTable = new JTable();

        try {

            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery("select * from rentalsystemdb");
            viewTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Label
        searchLabel = new JLabel("Search by Booking Id");
        searchLabel.setBounds(30, 50, 180, 25);
        searchLabel.setFont(f2);
        add(searchLabel);

        //Choice
        bookingId = new Choice();
        bookingId.setBounds(220, 50, 150, 80);
        add(bookingId);

        try {

            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery("select * from rentalsystemdb");
            
            while (rs.next()) {
                bookingId.add(rs.getString("bookingId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //ScrollPane
        scrollPane = new JScrollPane(viewTable);
        scrollPane.setBounds(30, 125, 1130, 475);
        add(scrollPane);

        //Button
        searchBtn = new JButton("Search");
        searchBtn.setBounds(450, 45, 100, 30);
        searchBtn.setFont(f1);
        searchBtn .addActionListener(this);
        add(searchBtn);

        printBtn = new JButton("Print");
        printBtn.setBounds(780, 610, 100, 50);
        printBtn.setFont(f1);
        printBtn.addActionListener(this);
        add(printBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(920, 610, 100, 50);
        updateBtn.setFont(f1);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(1060, 610, 100, 50);
        backBtn.setFont(f1);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(1200, 730);
        setLocationRelativeTo(null);
        setTitle("View Booking");
        setVisible(true);

    }

    public static void main(String[] args) {
        new ViewBooking();

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchBtn) {
            String query = "select * from rentalsystemdb where bookingId = '"+bookingId.getSelectedItem()+"'";
            
        try {

            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery(query);
            viewTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        } 
        else if (ae.getSource() == printBtn)  {
            try{
                viewTable.print();
                
            }catch(Exception e){
                
               e.printStackTrace(); 
            }
        }
        else if (ae.getSource() == updateBtn) {
            setVisible(false);
            new UpdateRentalInfo(bookingId.getSelectedItem());
        }
        else if (ae.getSource() == backBtn) {
            setVisible(false);
            new RentalSystem();
        }
        else
        {
            
        }
    }
}



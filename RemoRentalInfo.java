package rentyourcar;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;

public class RemoRentalInfo extends JFrame implements ActionListener {

    private Font f1, f2, f3;
    private JLabel bookingIdLabel, bookingIdLabel2, fromLabel, fromLabel2, toLabel, toLabel2, nameLabel, nameLabel2;
    private JLabel dateLabel, dateLabel2, carTypeLabel, carTypeLabel2, tripTypeLabel, tripTypeLabel2, phoneLabel, phoneLabel2, durationLabel, durationLabel2;
    private Choice bookingId;
    private JButton removeBtn, returnBtn;

    RemoRentalInfo() {

        getContentPane().setBackground(Color.orange);
        setLayout(null);

        //Font
        f1 = new Font("ARIAL", Font.BOLD, 22);
        f2 = new Font("Raleway", Font.BOLD, 14);
        f3 = new Font("sherif", Font.PLAIN, 14);

        //Label & TextField
        bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(30, 50, 200, 25);
        bookingIdLabel.setFont(f2);
        add(bookingIdLabel);

        bookingId = new Choice();
        bookingId.setBounds(240, 50, 105, 30);
        bookingId.setFont(f2);
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
        nameLabel = new JLabel("Customer Name: ");
        nameLabel.setBounds(30, 100, 200, 25);
        nameLabel.setFont(f2);
        add(nameLabel);

        nameLabel2 = new JLabel("");
        nameLabel2.setBounds(205, 100, 200, 30);
        nameLabel2.setFont(f3);
        add(nameLabel2);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(30, 135, 200, 25);
        phoneLabel.setFont(f2);
        add(phoneLabel);

        phoneLabel2 = new JLabel("");
        phoneLabel2.setBounds(205, 135, 200, 30);
        phoneLabel2.setFont(f3);
        add(phoneLabel2);

        dateLabel = new JLabel("Journey Date:");
        dateLabel.setBounds(30, 170, 200, 25);
        dateLabel.setFont(f2);
        add(dateLabel);

        dateLabel2 = new JLabel("");
        dateLabel2.setBounds(205, 170, 200, 30);
        dateLabel2.setFont(f3);
        add(dateLabel2);

        durationLabel = new JLabel("Total Duration:");
        durationLabel.setBounds(30, 205, 205, 25);
        durationLabel.setFont(f2);
        add(durationLabel);

        durationLabel2 = new JLabel("");
        durationLabel2.setBounds(205, 205, 205, 30);
        durationLabel2.setFont(f3);
        add(durationLabel2);

        carTypeLabel = new JLabel("Car Details:");
        carTypeLabel.setBounds(30, 240, 205, 25);
        carTypeLabel.setFont(f2);
        add(carTypeLabel);

        carTypeLabel2 = new JLabel("");
        carTypeLabel2.setBounds(205, 240, 205, 30);
        carTypeLabel2.setFont(f3);
        add(carTypeLabel2);

        tripTypeLabel = new JLabel("Trip Type:");
        tripTypeLabel.setBounds(30, 275, 205, 25);
        tripTypeLabel.setFont(f2);
        add(tripTypeLabel);

        tripTypeLabel2 = new JLabel("");
        tripTypeLabel2.setBounds(205, 275, 205, 25);
        tripTypeLabel2.setFont(f3);
        add(tripTypeLabel2);

        fromLabel = new JLabel("PickUp Point");
        fromLabel.setBounds(30, 310, 100, 25);
        fromLabel.setFont(f2);
        add(fromLabel);

        fromLabel2 = new JLabel("");
        fromLabel2.setBounds(205, 310, 100, 25);
        fromLabel2.setFont(f3);
        add(fromLabel2);

        toLabel = new JLabel("DropOff Point:");
        toLabel.setBounds(30, 345, 100, 25);
        toLabel.setFont(f2);
        add(toLabel);

        toLabel2 = new JLabel("");
        toLabel2.setBounds(205, 345, 100, 25);
        toLabel2.setFont(f3);
        add(toLabel2);

        try {

            DatabaseConnection c = new DatabaseConnection();
            String query = "select * from rentalsystemdb where bookingId = '" + bookingId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {

                nameLabel2.setText(rs.getString("userName"));
                phoneLabel2.setText(rs.getString("phone"));
                dateLabel2.setText(rs.getString("pickUpDate"));
                carTypeLabel2.setText(rs.getString("carType"));
                durationLabel2.setText(rs.getString("duration"));
                tripTypeLabel2.setText(rs.getString("tripType"));
                fromLabel2.setText(rs.getString("pickUp"));
                toLabel2.setText(rs.getString("dropoff"));

            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        bookingId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {

                    DatabaseConnection c = new DatabaseConnection();
                    String query = "select * from rentalsystemdb where bookingId = '" + bookingId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {

                        nameLabel2.setText(rs.getString("userName"));
                        phoneLabel2.setText(rs.getString("phone"));
                        dateLabel2.setText(rs.getString("pickUpDate"));
                        carTypeLabel2.setText(rs.getString("carType"));
                        durationLabel2.setText(rs.getString("duration"));
                        tripTypeLabel2.setText(rs.getString("tripType"));
                        fromLabel2.setText(rs.getString("pickUp"));
                        toLabel2.setText(rs.getString("dropoff"));

                    }

                } catch (Exception ee) {
                    ee.printStackTrace();
                }

            }
        });

        // LogIn-SignUp-Admin Button
        removeBtn = new JButton("Remove Info");
        removeBtn.setBounds(100, 400, 120, 50);
        removeBtn.setBackground(Color.BLACK);
        removeBtn.setForeground(Color.WHITE);
        removeBtn.addActionListener(this);
        add(removeBtn);

        returnBtn = new JButton("Return");
        returnBtn.setBounds(230, 400, 120, 50);
        returnBtn.setBackground(Color.BLACK);
        returnBtn.setForeground(Color.WHITE);

        returnBtn.addActionListener(this);
        add(returnBtn);

        setSize(500, 550);
        setLocationRelativeTo(null);
        setTitle("Remove Rental Info");
        setVisible(true);
    }

    public static void main(String[] args) {
        new RemoRentalInfo();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == removeBtn) {

            try {
                DatabaseConnection c = new DatabaseConnection();
                String query = "delete from rentalsystemdb where bookingId = '" + bookingId.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Successfully Removed");
                setVisible(false);
                new ViewBooking();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == returnBtn) {
                setVisible(false);
                new HomeRentCar(); 
        } else {
            JOptionPane.showMessageDialog(null, "There is some issue");
            setVisible(false);
        }
    }
}

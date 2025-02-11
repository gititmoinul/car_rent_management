package rentyourcar;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class UpdateRentalInfo extends JFrame implements ActionListener {

    private Font f1, f2, f3;
    private JLabel bookingIdLabel, bookingIdLabel2, fromLabel, toLabel, dateLabel, carTypeLabel, tripTypeLabel, phoneLabel, nameLabel, durationLabel;
    private JDateChooser chooseDate;
    private JTextField fromTf, toTf, phoneTf, nameTf;
    private JComboBox durationCombo, carTypeCombo, tripTypeCombo;

    private JButton updateBtn,returnBtn;
    String bookingId;

    UpdateRentalInfo(String bookingId) {
        this.bookingId = bookingId;

        getContentPane().setBackground(Color.getHSBColor(0.33f, 0.3f, 0.6f));
        setLayout(null);

        //Font
        f1 = new Font("ARIAL", Font.BOLD, 22);
        f2 = new Font("Raleway", Font.BOLD, 14);
        f3 = new Font("sherif", Font.PLAIN, 14);

        //Label & TextField
        bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(30, 75, 200, 25);
        bookingIdLabel.setFont(f2);
        add(bookingIdLabel);

        bookingIdLabel2 = new JLabel();
        bookingIdLabel2.setBounds(130, 75, 105, 25);
        bookingIdLabel2.setFont(f2);
        add(bookingIdLabel2);

        fromLabel = new JLabel("From");
        fromLabel.setBounds(30, 100, 200, 25);
        fromLabel.setFont(f2);
        add(fromLabel);

        fromTf = new JTextField();
        fromTf.setBounds(30, 125, 205, 40);
        fromTf.setFont(f3);
        add(fromTf);

        toLabel = new JLabel("To");
        toLabel.setBounds(265, 100, 200, 25);
        toLabel.setFont(f2);
        add(toLabel);

        toTf = new JTextField();
        toTf.setBounds(265, 125, 205, 40);
        toTf.setFont(f3);
        add(toTf);

        dateLabel = new JLabel("Select Date:");
        dateLabel.setBounds(30, 180, 200, 25);
        dateLabel.setFont(f2);
        add(dateLabel);

        chooseDate = new JDateChooser();
        chooseDate.setBounds(30, 205, 205, 40);
        chooseDate.setFont(f3);
        add(chooseDate);

        durationLabel = new JLabel("Confirm Duration:");
        durationLabel.setBounds(265, 180, 205, 25);
        durationLabel.setFont(f2);
        add(durationLabel);

        String duration[] = {"1 day", "2 days", "3 days", "4 days", "5 days", "6 days", "7 days", "8 days"};

        durationCombo = new JComboBox(duration);
        durationCombo.setBounds(265, 205, 205, 40);
        durationCombo.setFont(f3);
        add(durationCombo);

        carTypeLabel = new JLabel("Select Car:");
        carTypeLabel.setBounds(30, 260, 205, 25);
        carTypeLabel.setFont(f2);
        add(carTypeLabel);

        String carType[] = {"Car(4 Seat)", "Noah(6 Seat)", "Micro(7 Seat)", "Hiace(11 Seat)"};

        carTypeCombo = new JComboBox(carType);
        carTypeCombo.setBounds(30, 285, 205, 40);
        carTypeCombo.setFont(f3);
        add(carTypeCombo);

        tripTypeLabel = new JLabel("Select Trip Type:");
        tripTypeLabel.setBounds(265, 260, 205, 25);
        tripTypeLabel.setFont(f2);
        add(tripTypeLabel);

        String tripType[] = {"One Way", "Return"};

        tripTypeCombo = new JComboBox(tripType);
        tripTypeCombo.setBounds(265, 285, 205, 40);
        tripTypeCombo.setFont(f3);
        add(tripTypeCombo);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 340, 100, 25);
        nameLabel.setFont(f2);
        add(nameLabel);

        nameTf = new JTextField();
        nameTf.setBounds(30, 365, 205, 40);
        nameTf.setFont(f3);
        add(nameTf);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(265, 340, 100, 25);
        phoneLabel.setFont(f2);
        add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(265, 365, 205, 40);
        phoneTf.setFont(f3);
        add(phoneTf);

        try {

            DatabaseConnection c = new DatabaseConnection();
            String query = "select * from rentalsystemdb where bookingId = '" + bookingId + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                bookingIdLabel2.setText(rs.getString("bookingId"));
                fromTf.setText(rs.getString("pickUp"));
                toTf.setText(rs.getString("dropoff"));
                nameTf.setText(rs.getString("userName"));
                phoneTf.setText(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // LogIn-SignUp-Admin Button
        updateBtn = new JButton("Update Information");
        updateBtn.setBounds(100, 445, 300, 50);
        updateBtn.addActionListener(this);
        add(updateBtn);

        returnBtn = new JButton("Return");
        returnBtn.setBounds(320, 75, 150, 30);
        returnBtn.addActionListener(this);
        add(returnBtn);

        setSize(500, 600);
        setLocationRelativeTo(null);
        setTitle("Update Rental Info");
        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateRentalInfo("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateBtn) {

            String username = nameTf.getText();
            String phone = phoneTf.getText();
            String pickUp = fromTf.getText();
            String dropoff = toTf.getText();
            String carType = (String) carTypeCombo.getSelectedItem();
            String duration = (String) durationCombo.getSelectedItem();
            String tripType = (String) tripTypeCombo.getSelectedItem();
            String pickUpDate = ((JTextField) chooseDate.getDateEditor().getUiComponent()).getText();
            try {
                DatabaseConnection c = new DatabaseConnection();
                String query = "update rentalsystemdb set userName = '" + username + "',phone = '" + phone + "',carType = '" + carType + "',pickUpDate = '" + pickUpDate + "',pickUp = '" + pickUp + "',dropoff = '" + dropoff + "',tripType = '" + tripType + "',duration = '" + duration + "' where bookingId = '" + bookingId + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Successfully Updated");
                setVisible(false);
                new ViewBooking();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == returnBtn){
                setVisible(false);
                new HomeRentCar();
        }
        
        else {
            JOptionPane.showMessageDialog(null, "There is some issue");
            setVisible(false);
        }
    }

}

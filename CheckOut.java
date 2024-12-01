package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {

    private JTextField txtNIC, txtCustomerName, txtRoomNo, txtCheckInDate, txtType, txtBedType, txtNoOfDays, txtTotalCash;
    private  JButton btnCheck, btnCheckOut, btnBack, btnExit;
    private  JLabel lblCheckOutDate, nm, nic, roomNo, cName, lblBedType, lblCheckIn, lblTotCash, lblCh_Out;

  public   CheckOut() {
        setTitle("Customer Check-Out");
        setLayout(new BorderLayout());


        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 205, 170));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        nm = new JLabel("Customer Check-Out");
        nm.setFont(new Font("Tahoma", Font.BOLD, 30));
        headerPanel.add(nm);

        add(headerPanel, BorderLayout.NORTH);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;


        nic = new JLabel("NIC:");
        nic.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nic, gbc);

        txtNIC = new JTextField(15);
        txtNIC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc.gridx = 1;
        formPanel.add(txtNIC, gbc);

        btnCheck = new JButton("Check");
        btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc.gridx = 2;
        formPanel.add(btnCheck, gbc);
        btnCheck.addActionListener(this);


        cName = new JLabel("Customer Name:");
        cName.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(cName, gbc);

        txtCustomerName = new JTextField(15);
        txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtCustomerName.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtCustomerName, gbc);


        roomNo = new JLabel("Allocated Room No:");
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        formPanel.add(roomNo, gbc);

        txtRoomNo = new JTextField(15);
        txtRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtRoomNo.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtRoomNo, gbc);


        lblCheckIn = new JLabel("Check-in Date:");
        lblCheckIn.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        formPanel.add(lblCheckIn, gbc);

        txtCheckInDate = new JTextField(15);
        txtCheckInDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtCheckInDate.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtCheckInDate, gbc);


        JLabel lblType = new JLabel("Type:");
        lblType.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        formPanel.add(lblType, gbc);

        txtType = new JTextField(15);
        txtType.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtType.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtType, gbc);


        lblBedType = new JLabel("Bed Type:");
        lblBedType.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(lblBedType, gbc);

        txtBedType = new JTextField(15);
        txtBedType.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtBedType.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtBedType, gbc);


        JLabel lblNoOfDays = new JLabel("No of Days:");
        lblNoOfDays.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        formPanel.add(lblNoOfDays, gbc);

        txtNoOfDays = new JTextField(15);
        txtNoOfDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtNoOfDays.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtNoOfDays, gbc);


        lblCh_Out = new JLabel("Check Out Date:");
        lblCh_Out.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        formPanel.add(lblCh_Out, gbc);

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        lblCheckOutDate = new JLabel(sdf.format(currentDate));
        lblCheckOutDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(lblCheckOutDate, gbc);


        lblTotCash = new JLabel("Total Cash:");
        lblTotCash.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        formPanel.add(lblTotCash, gbc);

        txtTotalCash = new JTextField(15);
        txtTotalCash.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTotalCash.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtTotalCash, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Button Panel.......................................
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        btnPanel.setBackground(new Color(102, 205, 170));

        btnCheckOut = new JButton("Check Out");
        btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnPanel.add(btnCheckOut);
        btnCheckOut.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnPanel.add(btnBack);
        btnBack.addActionListener(this);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnPanel.add(btnExit);
        btnExit.addActionListener(this);

        add(btnPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.WHITE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCheck) {
            String id = txtNIC.getText();
            String query = "select * from cus_register where id = ?";

            try {
                Conn c = new Conn();
                PreparedStatement ps = c.statement.getConnection().prepareStatement(query);
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    txtCustomerName.setText(rs.getString("customer_name"));
                    txtRoomNo.setText(String.valueOf(rs.getInt("allocated_room")));
                    txtCheckInDate.setText(rs.getString("check_in"));
                    txtType.setText(rs.getString("type"));
                    txtBedType.setText(rs.getString("bed_type"));
                    txtNoOfDays.setText(String.valueOf(rs.getInt("no_of_days")));

                    // Calculate total cash
                    calculateTotalCash(rs.getString("allocated_room"), rs.getInt("no_of_days"), rs.getString("food_beverage"));
                } else {
                    JOptionPane.showMessageDialog(null, "Customer not found.");
                }

                ps.close();
                rs.close();
                c.statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnCheckOut) {
            String id = txtNIC.getText();
            String roomNo = txtRoomNo.getText();
            String customerName = txtCustomerName.getText();
            String checkInDate = txtCheckInDate.getText();
            String checkOutDate = lblCheckOutDate.getText();
            String totalCash = txtTotalCash.getText();

            String query1= "delete from cus_register where id = ?";
            String query2 = "update rooms set availability = 'Not Allocate' where room_no = ?";
            String query3 = "insert into checkout (id, customer_name, allocated_room, check_in, check_out, total_cash) values (?, ?, ?, ?, ?, ?)";

            try {
                Conn c = new Conn();
                PreparedStatement ps1 = c.statement.getConnection().prepareStatement(query1);
                PreparedStatement ps2 = c.statement.getConnection().prepareStatement(query2);
                PreparedStatement ps3 = c.statement.getConnection().prepareStatement(query3);

                ps1.setString(1, id);
                ps2.setString(1, roomNo);

                ps3.setString(1, id);
                ps3.setString(2, customerName);
                ps3.setString(3, roomNo);
                ps3.setString(4, checkInDate);
                ps3.setString(5, checkOutDate);
                ps3.setString(6, totalCash);

                int affectedRows = ps1.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Check Out successful.");
                    setVisible(false);
                    new Reception().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Check Out failed.");
                }

                ps1.close();
                ps2.close();
                ps3.close();
                c.statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnBack) {
            new Reception();
            dispose();
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    private void calculateTotalCash(String roomNo, int noOfDays, String foodBeverage) {
        int pricePerDay = 0;
        int totalCash = 0;
        try {
            Conn c = new Conn();
            String query = "SELECT price FROM rooms where room_no = ?";
            PreparedStatement ps = c.statement.getConnection().prepareStatement(query);
            ps.setString(1, roomNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pricePerDay = rs.getInt("price");
            }

            totalCash = pricePerDay * noOfDays;

            if (foodBeverage.equalsIgnoreCase("yes")) {
                totalCash += 1500; // Adding a fixed amount for foods.....
            }

            txtTotalCash.setText(String.valueOf(totalCash));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

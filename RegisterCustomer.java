package HotelManagementSystem;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterCustomer extends JFrame implements ActionListener {

   private JTextField txtID, txtCustomerName, txtNoOfDays;
    private JRadioButton maleBtn, femaleBtn;
    private JButton AddButton, btnBack, btnExit;
    private JLabel lblDate;
    private JComboBox<String> cboxType, cboxBedType, cbFood, cbRoomNo;


  public   RegisterCustomer() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);
        mainPanel.setBackground(new Color(102, 205, 170));


        JPanel formPanel = new JPanel(new GridBagLayout());
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder title = BorderFactory.createTitledBorder(blackline, "Customer Registration");
        title.setTitleFont(new Font("Thoma", Font.BOLD, 30));
        ((TitledBorder) title).setTitleJustification(TitledBorder.CENTER);
        formPanel.setBorder(title);
        formPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("NIC"), gbc);

        gbc.gridx = 1;
        txtID = new JTextField(20);
        formPanel.add(txtID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Customer Name"), gbc);

        gbc.gridx = 1;
        txtCustomerName = new JTextField(20);
        formPanel.add(txtCustomerName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Gender"), gbc);

        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);
        formPanel.add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Type"), gbc);

        gbc.gridx = 1;
        cboxType = new JComboBox<>(new String[]{"AC", "Non-AC"});
        cboxType.addActionListener(this);
        formPanel.add(cboxType, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Bed Type"), gbc);

        gbc.gridx = 1;
        cboxBedType = new JComboBox<>(new String[]{"Single", "Double", "Triple"});
        cboxBedType.addActionListener(this);
        formPanel.add(cboxBedType, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Allocated Room No"), gbc);

        gbc.gridx = 1;
        cbRoomNo = new JComboBox<>();
        formPanel.add(cbRoomNo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(new JLabel("Check-in Date"), gbc);

        gbc.gridx = 1;
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        lblDate = new JLabel(sdf.format(currentDate));
        formPanel.add(lblDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(new JLabel("No of Days"), gbc);

        gbc.gridx = 1;
        txtNoOfDays = new JTextField(20);
        formPanel.add(txtNoOfDays, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        formPanel.add(new JLabel("Food & Beverage"), gbc);

        gbc.gridx = 1;
        cbFood = new JComboBox<>(new String[]{"Yes", "No"});
        formPanel.add(cbFood, gbc);

        // Btns..
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        btnPanel.setBackground(new Color(102, 205, 170));
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        AddButton = new JButton("Add");
        btnPanel.add(AddButton);
        AddButton.addActionListener(this);

        btnBack = new JButton("Back");
        btnPanel.add(btnBack);
        btnBack.addActionListener(this);

        btnExit = new JButton("Exit");
        btnPanel.add(btnExit);
        btnExit.addActionListener(this);


        getContentPane().setBackground(Color.LIGHT_GRAY);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);



        UpdateAvailableRooms();
    }

    private void UpdateAvailableRooms() {
        cbRoomNo.removeAllItems();
        String type = cboxType.getSelectedItem().toString();
        String bedType = cboxBedType.getSelectedItem().toString();
        String query = "SELECT room_no FROM rooms where availability = 'Not Allocate' AND type = ? and bed_type = ?";

        try {
            Conn c = new Conn();
            PreparedStatement ps = c.statement.getConnection().prepareStatement(query);
            ps.setString(1, type);
            ps.setString(2, bedType);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cbRoomNo.addItem(rs.getString("room_no"));
            }

            ps.close();
            rs.close();
            c.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddButton) {
            String id = txtID.getText();
            String customerName = txtCustomerName.getText();
            String gender = maleBtn.isSelected() ? "Male" : "Female";
            String allocatedRoomNo = cbRoomNo.getSelectedItem().toString();
            String checkInDate = lblDate.getText();
            String type = cboxType.getSelectedItem().toString();
            String bedType = cboxBedType.getSelectedItem().toString();
            String noOfDays = txtNoOfDays.getText();
            String foodBeverage = cbFood.getSelectedItem().toString();

            String query = "INSERT INTO cus_register (id, customer_name, gender, allocated_room, check_in, type, bed_type, no_of_days, food_beverage) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String query2 = "UPDATE rooms set availability = 'Allocate' where room_no = ?";

            try {
                Conn c = new Conn();
                PreparedStatement statement = c.statement.getConnection().prepareStatement(query);
                PreparedStatement statement2 = c.statement.getConnection().prepareStatement(query2);
                statement.setString(1, id);
                statement.setString(2, customerName);
                statement.setString(3, gender);
                statement.setString(4, allocatedRoomNo);
                statement.setString(5, checkInDate);
                statement.setString(6, type);
                statement.setString(7, bedType);
                statement.setString(8, noOfDays);
                statement.setString(9, foodBeverage);

                int rowsAffected = statement.executeUpdate();
                statement2.setString(1, allocatedRoomNo);
                statement2.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Customer is Registered Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer Registration is Failed");
                }

                statement.close();
                statement2.close();
                c.statement.close();
                new Reception().setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnBack) {
            new Reception().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == cboxType || e.getSource() == cboxBedType) {

            UpdateAvailableRooms();
        }
    }


}

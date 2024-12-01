package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRoom extends JFrame implements ActionListener {

  private   JTextField RoomNo, Price;
    private JComboBox<String> cmbAvailability, cmboxBedType, cmboxType;
    private JButton BtnAdd, BtnBack, BtnExit;
    private JLabel PriceLbl, BedType, lblAvailability, TitlePanel, Type, lblRoom_No;

   public AddRoom() {


        JPanel mainPanel = new JPanel(new BorderLayout(19, 19));
       // mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setBackground(new Color(102, 205, 170));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(19, 19, 19, 19));
        add(mainPanel);


        JPanel title = new JPanel();
        title.setBackground(new Color(102, 205, 170));
        TitlePanel = new JLabel("Add Room");
        TitlePanel.setFont(new Font("Thoma", Font.BOLD, 31));
        title.add(TitlePanel);
        mainPanel.add(title, BorderLayout.NORTH);


        JPanel FormPanel = new JPanel(new GridBagLayout());
        FormPanel.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        lblRoom_No = new JLabel("Room No");
        gbc.gridx = 0;
        gbc.gridy = 0;
        lblRoom_No.setFont(new Font("Thoma", Font.BOLD, 21));
        FormPanel.add(lblRoom_No, gbc);

        gbc.gridx = 1;
        RoomNo = new JTextField(20);
        RoomNo.setFont(new Font("Thoma", Font.PLAIN, 21));
        FormPanel.add(RoomNo, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        lblAvailability = new JLabel("Availability");
        lblAvailability.setFont(new Font("Thoma", Font.BOLD, 21));
        FormPanel.add(lblAvailability, gbc);

        gbc.gridx = 1;
        cmbAvailability = new JComboBox<>(new String[]{"Allocate", "Not Allocate"});
        cmbAvailability.setFont(new Font("Thoma", Font.PLAIN, 21));
        FormPanel.add(cmbAvailability, gbc);

        Type = new JLabel("Type");
        gbc.gridx = 0;
        gbc.gridy = 2;
        Type.setFont(new Font("Thoma", Font.BOLD, 21));
        FormPanel.add(Type, gbc);

        gbc.gridx = 1;
        cmboxType = new JComboBox<>(new String[]{"AC", "Non-AC"});
        cmboxType.setFont(new Font("Thoma", Font.PLAIN, 21));
        FormPanel.add(cmboxType, gbc);

        BedType = new JLabel("Bed Type");
        gbc.gridx = 0;
        gbc.gridy = 3;
        BedType.setFont(new Font("Thoma", Font.BOLD, 21));
        FormPanel.add(BedType, gbc);

        gbc.gridx = 1;
        cmboxBedType = new JComboBox<>(new String[]{"Single", "Double", "Triple","family"});
        cmboxBedType.setFont(new Font("Thoma", Font.PLAIN, 21));
        FormPanel.add(cmboxBedType, gbc);


       PriceLbl = new JLabel("Price");
        gbc.gridx = 0;
        gbc.gridy = 4;
       PriceLbl.setFont(new Font("Thoma", Font.BOLD, 21));
        FormPanel.add(PriceLbl, gbc);

        gbc.gridx = 1;
        Price = new JTextField(20);
        Price.setFont(new Font("Thoma", Font.PLAIN, 21));
        Price.setEditable(false);
        FormPanel.add(Price, gbc);

        mainPanel.add(FormPanel, BorderLayout.CENTER)
        ;

// Button Panel.......................................
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        btnPanel.setBackground(new Color(102, 205, 170));

        cmboxType.addActionListener(this);
        cmboxBedType.addActionListener(this);

        BtnAdd = new JButton("Add");
        BtnAdd.addActionListener(this);
        btnPanel.add(BtnAdd);

        BtnBack = new JButton("Back");
        BtnBack.addActionListener(this);
        btnPanel.add(BtnBack);

        BtnExit = new JButton("Exit");
        BtnExit.addActionListener(this);
        btnPanel.add(BtnExit);

        mainPanel.add(btnPanel, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Room");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(mainPanel);
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
       // pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cmboxType || e.getSource() == cmboxBedType) {
            CalculatePrice();
        } else if (e.getSource() == BtnAdd) {
            String roomNo = RoomNo.getText();
            String availability = cmbAvailability.getSelectedItem().toString();
            String type = cmboxType.getSelectedItem().toString();
            String price = Price.getText();
            String bedType = cmboxBedType.getSelectedItem().toString();


            String query = "INSERT INTO rooms (room_no, availability, type, price, bed_type) VALUES (?, ?, ?, ?, ?)";

            try {
                Conn c = new Conn();
                PreparedStatement statement = c.statement.getConnection().prepareStatement(query);
                statement.setString(1, roomNo);
                statement.setString(2, availability);
                statement.setString(3, type);
                statement.setString(4, price);
                statement.setString(5, bedType);

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Room is added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Unable to add a room.Try again");
                }

                statement.close();
                c.close();
                clear();
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        } else if (e.getSource() == BtnBack)
        {
            new Admin();
            dispose();
        } else if (e.getSource() == BtnExit)
        {
            System.exit(0);
        }
    }

    private void CalculatePrice() {
        String Type = (String) cmboxType.getSelectedItem();
        String bedType = (String) cmboxBedType.getSelectedItem();


        if (Type == null || bedType == null) {
            Price.setText("");
            return;
        }

        int price = 0;
        if (Type.equals("AC")) {
            switch (bedType) {
                case "Single":
                    price = 4000;
                    break;
                case "Double":
                    price = 8000;
                    break;
                case "Triple":
                    price = 12000;
                    break;
            }
        } else if (Type.equals("Non-AC")) {
            switch (bedType) {
                case "Single":
                    price = 2000;
                    break;
                case "Double":
                    price = 4000;
                    break;
                case "Triple":
                    price = 8000;
                    break;
            }
        }
        Price.setText(String.valueOf(price));
    }

    private void clear()
    {
        RoomNo.setText("");
        Price.setText("");
        cmbAvailability.setSelectedIndex(-1);
        cmboxType.setSelectedIndex(-1);
        cmboxBedType.setSelectedIndex(-1);
    }
    public static void main(String[] args) {
        new AddRoom();
    }

}

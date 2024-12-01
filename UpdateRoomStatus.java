package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    private   JTextField txt1, txt4;
    private JComboBox<String> txt2, txt5;
    private JButton BtnCheck, BtnUpdate, BtnBack, BtnExit;
    private JLabel name, no, available, price, type;

  public   UpdateRoomStatus() {

        setLayout(new BorderLayout());


        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 205, 170));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

      JLabel  nm = new JLabel("Update the Room Status");
        nm.setFont(new Font("Tahoma", Font.BOLD, 30));
        headerPanel.add(nm);

        add(headerPanel, BorderLayout.NORTH);


        JPanel FormPanel = new JPanel(new GridBagLayout());
        FormPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

       // Title
//        name = new JLabel("Update Room Status");
//        name.setFont(new Font("Tahoma", Font.BOLD, 30));
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 3;
//        gbc.anchor = GridBagConstraints.CENTER;
//        formPanel.add(name, gbc);


        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        no = new JLabel("Room No");
        no.setFont(new Font("Tahoma", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 1;
        FormPanel.add(no, gbc);


        txt1 = new JTextField(10);
        txt1.setFont(new Font("Tahoma", Font.PLAIN, 23));
        gbc.gridx = 1;
        FormPanel.add(txt1, gbc);


        BtnCheck = new JButton("Check");
        BtnCheck.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 2;
        FormPanel.add(BtnCheck, gbc);
        BtnCheck.addActionListener(this);


        available = new JLabel("Availability");
        available.setFont(new Font("Tahoma", Font.BOLD, 23));
        gbc.gridx = 0;
        gbc.gridy = 2;
        FormPanel.add(available, gbc);


        txt2 = new JComboBox<>(new String[]{"Allocate", "Not Allocate"});
        txt2.setFont(new Font("Tahoma", Font.PLAIN, 24));
        gbc.gridx = 1;
        FormPanel.add(txt2, gbc);


        price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.BOLD, 23));
        gbc.gridx = 0;
        gbc.gridy = 3;
        FormPanel.add(price, gbc);


        txt4 = new JTextField(10);
        txt4.setFont(new Font("Tahoma", Font.PLAIN, 23));
        gbc.gridx = 1;
        FormPanel.add(txt4, gbc);


        type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma", Font.BOLD, 23));
        gbc.gridx = 0;
        gbc.gridy = 4;
        FormPanel.add(type, gbc);


        txt5 = new JComboBox<>(new String[]{"Single", "Double", "Triple"});
        txt5.setFont(new Font("Tahoma", Font.PLAIN, 24));
        gbc.gridx = 1;
        FormPanel.add(txt5, gbc);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(102, 205, 170));


        BtnUpdate = new JButton("Update");
        BtnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
        BtnUpdate.addActionListener(this);
        buttonPanel.add(BtnUpdate);


        BtnBack = new JButton("Back");
        BtnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
        buttonPanel.add(BtnBack);

        BtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
                dispose();
            }
        });


        BtnExit = new JButton("Exit");
        BtnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
        BtnExit.addActionListener(this);
        buttonPanel.add(BtnExit);

        add(FormPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        setTitle("Update Room Status");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BtnCheck) {
            Integer roomNo = Integer.valueOf(txt1.getText());
            try {
                Conn c = new Conn();
                String query = "select * from rooms where room_no = ?";
                PreparedStatement st = c.statement.getConnection().prepareStatement(query);
                st.setInt(1, roomNo);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    txt2.setSelectedItem(rs.getString("availability"));
                    txt4.setText(rs.getString("price"));
                    txt5.setSelectedItem(rs.getString("bed_type"));
                } else {
                    JOptionPane.showMessageDialog(null, "Room not found");
                }
                st.close();
                c.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        } else if (e.getSource() == BtnUpdate) {
            Integer roomNo = Integer.valueOf(txt1.getText());
            String availability = txt2.getSelectedItem().toString();
            String price = txt4.getText();
            String bedType = txt5.getSelectedItem().toString();

            String query = "update rooms set availability = ?, price = ?, bed_type = ? where room_no = ?";

            try {
                Conn c = new Conn();
                PreparedStatement st = c.statement.getConnection().prepareStatement(query);
                st.setString(1, availability);
                st.setString(2, price);
                st.setString(3, bedType);
                st.setInt(4, roomNo);

                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Room status is updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update the room status");
                }

                st.close();
                c.close();
                new Reception().setVisible(true);
                setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went Wrong" + ex.getMessage());
            }
        }
         else if (e.getSource() == BtnExit) {
            System.exit(0);
        }
    }


}

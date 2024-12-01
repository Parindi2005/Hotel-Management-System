package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    private JCheckBox checkBox;
    private Choice choice;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnBack, btnExit;
    JLabel name;

   public SearchRoom() {

        setTitle("Search For Room");
        setLayout(new BorderLayout());

        JPanel Panel = new JPanel(new GridBagLayout());
        Panel.setBackground(new Color(102, 205, 170));
        add(Panel, BorderLayout.NORTH);

        name = new JLabel("Search For Room");
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 20, 10);
        Panel.add(name, gbc);

        checkBox = new JCheckBox("See Only Available Rooms");
        checkBox.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(checkBox, gbc);

        choice = new Choice();
        choice.add("Single");
        choice.add("Double");
        choice.add("Triple");
        choice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(choice, gbc);

        // Table
        model = new DefaultTableModel(new String[]{"Room No", "Availability", "Price", "Bed Type"}, 0);
        table = new JTable(model);
        table.setFont(new Font("Tahoma", Font.PLAIN, 20));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(102, 205, 170));
        add(buttonPanel, BorderLayout.SOUTH);

        btnBack = new JButton("Back");
        btnBack.setPreferredSize(new Dimension(150, 40));
        btnBack.addActionListener(this);
        buttonPanel.add(btnBack);

        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(150, 40));
        btnExit.addActionListener(this);
        buttonPanel.add(btnExit);


        checkBox.addActionListener(this);
        choice.addItemListener(e -> performSearch());


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        performSearch();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            setVisible(false);
            new Reception().setVisible(true);
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        } else {
            performSearch();
        }
    }

    private void performSearch() {
        String selectedBedType = choice.getSelectedItem();
        boolean onlyAvailableRooms = checkBox.isSelected();

        String query = "select room_no, availability, price, bed_type FROM rooms WHERE bed_type = ?";
        if (onlyAvailableRooms) {
            query += " and availability = 'Not Allocate'";
        }

        Conn con = null;
        try {
            con = new Conn();
            PreparedStatement preparedStatement = con.statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1, selectedBedType);
            ResultSet rs = preparedStatement.executeQuery();

            model.setRowCount(0);

            while (rs.next())
            {
                int roomNo = rs.getInt(1);
                String availability = rs.getString(2);
                double price = rs.getDouble(3);
                String bedType = rs.getString(4);

                model.addRow(new Object[]{roomNo, availability, price, bedType});
            }

            rs.close();
            preparedStatement.close()
            ;

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred when fetching the room details: " + ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


}

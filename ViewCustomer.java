package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {
    private Conn con;
    private JTable roomtable;
    private DefaultTableModel model;
    private JButton btnBack, btnExit;

    public ViewCustomer() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBounds(0, 500, 1000, 600);

        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        buttonPanel.add(btnBack);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        buttonPanel.add(btnExit);

        add(buttonPanel, BorderLayout.SOUTH);

        //  tbl....
        model = new DefaultTableModel(new Object[]{" NIC", "Name", "Gender", "Room No", " Check In", "AC/Non-AC", "Bed", "No of Days", "Foods"}, 0);
        roomtable = new JTable(model);
        roomtable.setRowHeight(30);


        JScrollPane scrollPane = new JScrollPane(roomtable);
        scrollPane.setPreferredSize(new Dimension(900, 400));
        add(scrollPane);


        try {
            con = new Conn();
            fetchCustomerData();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred when connecting to the database: " + e.getMessage());
        }

        setTitle("View Customer Details");
        setSize(1000, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void fetchCustomerData() {
        try {
            Statement statement = con.statement;
            ResultSet rs = statement.executeQuery("SELECT * FROM cus_register");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("id"),
                        rs.getString("customer_name"),
                        rs.getString("gender"),
                        rs.getString("allocated_room"),
                        rs.getString("check_in"),
                        rs.getString("type"),
                        rs.getString("bed_type"),
                        rs.getString("no_of_days"),
                        rs.getString("food_beverage"),
                });
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            setVisible(false);
            new Reception();
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}

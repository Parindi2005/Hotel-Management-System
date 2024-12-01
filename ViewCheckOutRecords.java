package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewCheckOutRecords extends JFrame {

    private JTable table;
    private  DefaultTableModel model;
    private  JButton btnBack, btnExit;

   public ViewCheckOutRecords() {

        setTitle("View Check-Out Records");
        setLayout(null);
        setBounds(300, 90, 1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel heading = new JLabel("Check-Out Records");
        heading.setFont(new Font("Thoma", Font.BOLD, 30));
        heading.setBounds(350, 20, 300, 30);
        add(heading);


        table = new JTable();
        model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn("NIC");
        model.addColumn("Customer Name");
        model.addColumn("Room No");
        model.addColumn("Check-In Date");
        model.addColumn("Check-Out Date");
        model.addColumn("Total Cash");

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 80, 950, 400);
        add(sp);


        fetchCheckOutRecords();


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBounds(0, 500, 999, 78);
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        add(buttonPanel);

        btnBack = new JButton("Back");
        buttonPanel.add(btnBack);
        btnBack.addActionListener(e -> {
            setVisible(false);
            new Reception().setVisible(true);
        });

        btnExit = new JButton("Exit");
        buttonPanel.add(btnExit);
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void fetchCheckOutRecords() {
        String query = "SELECT id, customer_name, allocated_room, check_in, check_out, total_cash FROM checkout";

        try {
            Conn c = new Conn();
            PreparedStatement ps = c.statement.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String customerName = rs.getString("customer_name");
                String roomNo = rs.getString("allocated_room");
                String checkInDate = rs.getString("check_in");
                String checkOutDate = rs.getString("check_out");
                String totalCash = rs.getString("total_cash");

                model.addRow(new Object[]{id, customerName, roomNo, checkInDate, checkOutDate, totalCash});
            }

            ps.close();
            rs.close();
            c.statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

package HotelManagementSystem;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends JFrame {

    private JTable table;
    private  DefaultTableModel model;

  public   Customer() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 600);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        add(panel);


        table = new JTable();
        table.setBounds(20, 40, 750, 500);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        table.setBorder(border);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 40, 750, 500);
        panel.add(scrollPane);


        model = new DefaultTableModel(new Object[]{" NIC", "Name", "Gender", "Room No", " Check In", "AC/Non-AC", "Bed", "No of Days", "Foods"}, 0);
        table.setModel(model);


        try {
            Conn c = new Conn();
            String query = "SELECT * FROM cus_register";
            ResultSet resultSet = c.statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String customer_name = resultSet.getString("customer_name");
                String gender = resultSet.getString("gender");
                String allocated_room = resultSet.getString("allocated_room");
                String check_in = resultSet.getString("check_in");
                String type = resultSet.getString("type");
                String bed_type = resultSet.getString("bed_type");
                String no_of_days = resultSet.getString("no_of_days");
                String food_beverage = resultSet.getString("food_beverage");

                model.addRow(new Object[]{id, customer_name, gender, allocated_room, check_in, type, bed_type, no_of_days, food_beverage});
            }

            resultSet.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        setVisible(true);
    }

}

package HotelManagementSystem;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room extends JFrame {

   private JTable table;
  private   DefaultTableModel model;

    public Room() {

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



        model = new DefaultTableModel(new Object[]{"Room No", "Availability", "Type", "Price", "Bed Type"}, 0);
        table.setModel(model);


        try {
            Conn c = new Conn();
            String query = "SELECT * FROM rooms";
            ResultSet resultSet = c.statement.executeQuery(query);

            while (resultSet.next()) {
                String roomNo = resultSet.getString("room_no");
                String availability = resultSet.getString("availability");
                String type = resultSet.getString("type");
                String price = resultSet.getString("price");
                String bedType = resultSet.getString("bed_type");

                model.addRow(new Object[]{roomNo, availability, type, price, bedType});
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

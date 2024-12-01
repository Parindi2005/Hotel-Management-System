package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class viewrooms extends JFrame implements ActionListener {
    private Conn con;
    private JTable Roomtable;
    private DefaultTableModel tblmodel;
    private JButton BackButton, ExitButton;

    public viewrooms() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBounds(0, 500, 1000, 600);

        BackButton = new JButton("Back");
        BackButton.addActionListener(this);
        buttonPanel.add(BackButton);

        ExitButton = new JButton("Exit");
        ExitButton.addActionListener(this);
        buttonPanel.add(ExitButton);

        add(buttonPanel, BorderLayout.SOUTH);


        tblmodel = new DefaultTableModel(new Object[]{"Room No", "Availability", "Type", "Price", "Bed Type"}, 0);
        Roomtable = new JTable(tblmodel);
        Roomtable.setRowHeight(30);


        JScrollPane scrollPane = new JScrollPane(Roomtable);
        scrollPane.setPreferredSize(new Dimension(899, 400));
        add(scrollPane);


        try {
            con = new Conn();
            fetchRoomData();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred when connecting to the database: " + e.getMessage());
        }

        setTitle("View Rooms");
        setSize(1000, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void fetchRoomData() {
        try {
            Statement st = con.statement;
            ResultSet rs = st.executeQuery("SELECT * FROM rooms");

            while (rs.next()) {
                tblmodel.addRow(new Object[]{
                        rs.getString("room_no"),
                        rs.getString("availability"),
                        rs.getString("type"),
                        rs.getString("price"),
                        rs.getString("bed_type"),
                });
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == BackButton)
        {
            setVisible(false);
            new Reception();

        } else if (e.getSource() == ExitButton)
        {
            System.exit(0);
        }
    }
}

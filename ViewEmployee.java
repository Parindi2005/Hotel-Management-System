package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewEmployee extends JFrame implements ActionListener {
    private Conn con;
    private JTable emptable;
    private DefaultTableModel model;
    private JButton btnBack, btnExit;

    public ViewEmployee() {
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 19, 19));
        ButtonPanel.setBounds(0, 499, 999, 600);

        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        ButtonPanel.add(btnBack);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        ButtonPanel.add(btnExit);

        add(ButtonPanel, BorderLayout.SOUTH);

        emptable = new JTable();
        try {
            con = new Conn();
            InitializeUI();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred when connecting to the database: " + e.getMessage());
        }
    }

    public DefaultTableModel addDataToTable(DefaultTableModel model) {
        try {
            Statement statement = con.statement;
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("name"),
                        rs.getString("emp_id"),
                        rs.getString("gender"),
                        rs.getString("age"),
                        rs.getString("job"),
                        rs.getString("salary"),
                        rs.getString("contact"),
                        rs.getString("email"),
                });
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    private void InitializeUI() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        Object[] columnIdentifier = new Object[]{" Name", "Employee ID", "Gender", "Age", "Job", "Salary", "Contact No", "Email"};
        defaultTableModel.setColumnIdentifiers(columnIdentifier);

        // Add data to model..............
        defaultTableModel = addDataToTable(defaultTableModel);
        emptable.setModel(defaultTableModel);

        emptable.setRowHeight(30);

        JScrollPane jScrollPane = new JScrollPane(emptable);
        jScrollPane.setPreferredSize(new Dimension(900, 400));
        add(jScrollPane);

        setTitle("View Employee");
        setSize(1000, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
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

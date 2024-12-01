package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

   private JButton addEmp, btnExit, btnLogout, btnAddRoom;

  public   Admin() {

      super("Admin Dashboard");


        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 205, 170));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel headerLabel = new JLabel("Admin Dashboard");
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        headerPanel.add(headerLabel);

        add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER; // Centered for both buttons


        btnAddRoom = new JButton("Add Room");
        btnAddRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAddRoom.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        formPanel.add(btnAddRoom, gbc);


        ImageIcon roomIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/room.jpeg"));
        Image roomImage = roomIcon.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        ImageIcon roomScaledIcon = new ImageIcon(roomImage);
        JLabel roomLabel = new JLabel(roomScaledIcon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(roomLabel, gbc);


        addEmp = new JButton("Add Employee");
        addEmp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addEmp.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(addEmp, gbc);


        ImageIcon empIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/employee.jpeg"));
        Image empImage = empIcon.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        ImageIcon empScaledIcon = new ImageIcon(empImage);
        JLabel empLabel = new JLabel(empScaledIcon);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(empLabel, gbc);

        // Buttons..
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        btnPanel.setBackground(new Color(102, 205, 170));

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnExit.addActionListener(this);
        btnPanel.add(btnExit);

        btnLogout = new JButton("Log Out");
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLogout.addActionListener(this);
        btnPanel.add(btnLogout);


        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.WHITE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

  }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addEmp) {
            new AddEmployee();
            dispose();
        } else if (e.getSource() == btnAddRoom) {
            new AddRoom();
            dispose();
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnLogout) {
            new Login();
            dispose();
        }
    }


}

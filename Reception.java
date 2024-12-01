package HotelManagementSystem;

import com.mysql.cj.log.Log;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Reception extends JFrame implements ActionListener{

    private  JPanel Btn;
    private  JButton btnCus,btnRoom,btnEmp,btnCI,btnURoom,btnC_Out,btnSroom;
    public   Reception() {

        super("Reception");

        //  panel on the left
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 200, 700);
        panel.setBackground(new Color(102, 205, 170));
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setLayout(null);
        add(panel);


        //  panel on the up....
        JPanel panel2 = new JPanel();
        panel2.setBounds(202, 20, 1000, 90);
        panel2.setBackground(new Color(102, 205, 170));
        panel2.setBorder(new LineBorder(Color.BLACK, 1));
        panel2.setLayout(null);
        add(panel2);


        JLabel receptionLabel = new JLabel("Reception");
        receptionLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        receptionLabel.setBounds(400, 10, 200, 40);
        panel2.add(receptionLabel);

        btnCus = new JButton("New Customer Form");
        btnCus.setBounds(20, 20, 160, 30);
        panel.add(btnCus);
        btnCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterCustomer();
                dispose();
            }
        });


        btnRoom = new JButton("Room");
        btnRoom.setBounds(20, 70, 160, 30);
        panel.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewrooms();
                dispose();
            }
        });


        btnEmp = new JButton("Employee Info");
        btnEmp.setBounds(20, 120, 160, 30);
        panel.add(btnEmp);
        btnEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                dispose();
            }
        });


        btnCI = new JButton("Customer Info");
        btnCI.setBounds(20, 170, 160, 30);
        panel.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCustomer();
                dispose();
            }
        });


        btnC_Out = new JButton("Check Out");
        btnC_Out.setBounds(20, 220, 160, 30);
        panel.add(btnC_Out);
        btnC_Out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckOut();
                dispose();
            }
        });


        btnURoom = new JButton("Update Room Status");
        btnURoom.setBounds(20, 270, 160, 30);
        panel.add(btnURoom);
        btnURoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateRoomStatus();
                dispose();
            }
        });


        btnSroom = new JButton("Search Room");
        btnSroom.setBounds(20, 330, 160, 30);
        panel.add(btnSroom);
        btnSroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
                dispose();
            }
        });


        JButton btnCheckDetail = new JButton("Check Out Details");
        btnCheckDetail.setBounds(20, 390, 160, 30); // Corrected bounds
        panel.add(btnCheckDetail);
        btnCheckDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCheckOutRecords();
                dispose();
            }
        });


        Btn = new JPanel();
        Btn.setLayout(new FlowLayout(FlowLayout.CENTER, 21, 11));
        Btn.setBounds(200, 600, 801, 51); // Adjusted bounds for the bottom panel
        Btn.setBackground(Color.LIGHT_GRAY);
        add(Btn);


        JButton btnlogout= new JButton("LogOut");
        Btn.add(btnlogout);
        btnlogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
                dispose();
            }
        });


        JButton btnExit = new JButton("Exit");
        Btn.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(990, 700);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

//    public static void main(String[] args) {
//        new Reception();
//    }

}

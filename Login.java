package HotelManagementSystem ;

import javax.swing.* ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt. event.ActionListener;
import java.sql.ResultSet
        ;

public class Login extends JFrame implements ActionListener {

    private  JLabel lblname, lblpass;
    private JTextField txtnm;
    private JPasswordField passwordField2 ;
    private JButton btnlog, btncan;

  public   Login()
    {
        setTitle("User Login");
        setLayout(new BorderLayout());


        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 205, 170));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel nm = new JLabel("Login");
        nm.setFont(new Font("Tahoma", Font.BOLD, 30));
        headerPanel.add(nm);
        add(headerPanel, BorderLayout.NORTH);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;


        lblname = new JLabel("Username") ;
        lblname.setFont(new Font("Tahoma", Font.BOLD,  19));
        gbc.gridx =  0;
        gbc.gridy = 0 ;
        gbc.gridwidth = 1;
       // gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(lblname, gbc);


        txtnm = new JTextField (21) ;
      //  txtnm.setForeground(Color.BLACK);
        txtnm.setFont(new Font ("Tahoma", Font.PLAIN, 14));
        gbc.gridx  = 1 ;
        //gbc.gridy = 0  ;
        gbc.gridwidth = 1;
       // gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(txtnm, gbc);
        ;


        lblpass = new JLabel("Password");
        lblpass.setFont(new Font("Tahoma", Font.BOLD, 19));
        gbc.gridx = 0;
        gbc.gridy = 1;
       gbc.gridwidth = 1;
       // gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(lblpass, gbc);


        passwordField2 = new JPasswordField(19);
       // passwordField2.setForeground(Color.BLACK);
        passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gbc.gridx =  1;
       // gbc.gridy =  2;
       gbc.gridwidth = 1;
      //  gbc.anchor = GridBagConstraints.WEST ;
        formPanel.add(passwordField2, gbc);


        // Button Panel.......................................
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        btnPanel.setBackground(new Color(102, 205, 170));


        btnlog = new JButton("Login");
        btnlog.setFont(new Font("Serif", Font.PLAIN, 15));
      //  btnlog.setBackground(Color.ORANGE);
       // btnlog.setForeground(Color.BLACK);
        btnlog.addActionListener(this);
       // gbc.gridx = 0;
       // gbc.gridy = 3;
      //  gbc.gridwidth = 1;
     //   gbc.anchor = GridBagConstraints.CENTER;
        btnPanel.add(btnlog, gbc);
        ;


        btncan = new JButton("Cancel");
        btncan.setFont(new Font("Serif", Font.PLAIN, 15));
     ///  btncan.setBackground(Color.ORANGE);
     //   btncan.setForeground(Color.BLACK);
        btncan.addActionListener(this);
      //  gbc.gridx = 1;
     //   gbc.gridy = 3;
     //   gbc.gridwidth = 1
        ;
      //  gbc.anchor = GridBagConstraints.CENTER;
        btnPanel.add(btncan, gbc);


        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);


//        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login2.jpg")) ;
//        Image originalImage = originalIcon.getImage();
//        Image scaledImage = originalImage.getScaledInstance(199, 150, Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon (scaledImage);
//        JLabel Newlabel = new JLabel(scaledIcon);
//        gbc.gridx = 5;
//        gbc.gridy = 0;
//       //gbc.gridheight = 2;
//        gbc.gridheight = 2;
//        gbc.anchor = GridBagConstraints.WEST;
//        formPanel.add(Newlabel, gbc);
        ;


        getContentPane(). setBackground ( Color.LIGHT_GRAY);
        setLocation( 401, 270) ;
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible (true)
        ;


    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String role = null;
        try
        {
            if (e.getSource() == btnlog) {
                Conn c = new Conn(); // Ensure Conn is correctly implemented and imported
                String username = txtnm.getText();
                String password = new String(passwordField2.getPassword());

                String query = "select * from login where username = '" + username + "' AND password = '" + password + "'";
                ResultSet resultSet = c.statement.executeQuery(query);

                while (resultSet.next()) {
                    role = resultSet.getString("role");
                }

                if ("admin".equals(role))
                {
                    new Admin();
                    dispose();
                } else if ("receptionist".equals(role))
                {
                    new Reception ()
                    ;
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Username or Password" );

                }

            } else if (e.getSource() == btncan) {
                txtnm.setText("");
                passwordField2.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An Error Occurred : " + ex.getMessage())
            ;

        }
    }


}
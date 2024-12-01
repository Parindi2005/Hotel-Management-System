package HotelManagementSystem;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement ;
import java.sql.SQLException ;

public class AddEmployee extends JFrame implements ActionListener {

   private JTextField  Name, EmpID, Age, Salary, Contact, Email;
    private JComboBox<String> Job;
    private JButton btnAdd, btnBack, btnExit;
    private JRadioButton maleBtn, femaleBtn;
    private JLabel Title, lblName, labelEmpID, lblAge;
    private JLabel lblGender, labelJob, lblSalary, labelContact, labelEmail;

  public   AddEmployee ()
    {

        setTitle("Add Employee");


        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 205, 170));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));


       JLabel nm = new JLabel("Add Employee");
        nm.setFont(new Font("Tahoma", Font.BOLD, 30));
        headerPanel.add(nm);

        add(headerPanel, BorderLayout.NORTH);


        JPanel Newpanel = new JPanel();
        Newpanel.setLayout(new GridBagLayout());
        Newpanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        Newpanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;


        lblName = new  JLabel("Name");
        lblName.setFont(new Font("Tahoma" , Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        Newpanel.add(lblName, gbc);

        Name = new JTextField(20);
        Name.setFont(new Font("Tahoma", Font.PLAIN, 21));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        Newpanel.add(Name, gbc);


        labelEmpID = new JLabel("Employee ID");
        labelEmpID.setFont(new Font("Tahoma", Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        Newpanel.add(labelEmpID, gbc);

        EmpID = new JTextField(20);
        EmpID.setFont(new Font("Tahoma", Font.PLAIN, 21));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        Newpanel.add(EmpID, gbc);


        lblAge = new JLabel ("Age");
        lblAge.setFont(new Font(" Tahoma", Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END ;
        Newpanel.add(lblAge, gbc);


        Age = new JTextField(20);
        Age.setFont(new Font("Tahoma", Font.PLAIN, 21));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        Newpanel.add(Age, gbc);



        lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        Newpanel.add(lblGender, gbc);

        maleBtn = new JRadioButton("Male");
        maleBtn.setFont(new Font("Tahoma", Font.PLAIN, 21));
        femaleBtn = new JRadioButton("Female");
        femaleBtn.setFont(new Font("Tahoma", Font.PLAIN, 21));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);

        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(Color.LIGHT_GRAY);
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        Newpanel.add(genderPanel, gbc);


        labelJob = new JLabel("Job");
        labelJob.setFont(new Font("Tahoma", Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        Newpanel.add(labelJob, gbc);


        Job = new JComboBox<> (new  String[]{"Front Office",  "Housekeeping", "Kitchen", "Room Service",  "Manager", "Accountant" });
        Job.setFont(new Font("Tahoma", Font.PLAIN, 21));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START ;
        Newpanel.add(Job, gbc) ;


        lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("Tahoma", Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        Newpanel.add(lblSalary, gbc) ;

        Salary = new JTextField(20);
        Salary.setFont(new Font("Tahoma", Font.PLAIN, 21));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        Newpanel.add(Salary, gbc);


        labelContact = new JLabel("Contact No");
        labelContact.setFont(new Font("Tahoma", Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        Newpanel.add(labelContact, gbc);

        Contact = new JTextField(20);
        Contact.setFont(new Font("Tahoma", Font.PLAIN, 21));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        Newpanel.add(Contact, gbc);


        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 21));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_END;
        Newpanel.add(labelEmail, gbc);

        Email = new JTextField(20);
        Email.setFont(new Font("Tahoma", Font.PLAIN, 21));
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        Newpanel.add(Email, gbc);


        // Buttons.....
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        ButtonPanel.setBackground(new Color(102, 205, 170));

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 21) );
        btnAdd.addActionListener(this);
        ButtonPanel.add(btnAdd);

        btnBack = new JButton("Back");
        btnBack. setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnBack.addActionListener(this);
        ButtonPanel.add(btnBack) ;

        btnExit  = new JButton("Exit");

        btnExit.setFont(new Font("Tahoma",  Font.PLAIN, 21));
        btnExit.addActionListener(this );
        ButtonPanel.add(btnExit) ;

        gbc.gridx  = 0;
        gbc.gridy  = 9;
        gbc.gridwidth = 2 ;
        gbc.anchor = GridBagConstraints.CENTER;
        Newpanel.add (ButtonPanel, gbc);

        add(Newpanel) ;
        setSize(900, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setVisible(true)  ;

    }


    @Override

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnAdd)
        {
            String name = Name. getText();
            String empID = EmpID.getText();
            String gender = maleBtn. isSelected()  ?  "Male" : "Female" ;
            String job = Job.getSelectedItem(). toString() ;
            String age =  Age.getText();
            String salary  = Salary. getText();
            String contact  = Contact.getText();
            String email  = Email.getText();

            String query = "INSERT into employees (name, emp_id, gender, job, age, salary, contact, email) values   (?, ?, ?, ?, ?, ?, ?, ?) " ;


            try
            {

                Conn c = new Conn();

                PreparedStatement statement = c.statement.getConnection().prepareStatement(query);
                statement.setString(1, name);
                statement.setString(2, empID) ;
                statement.setString(3, gender) ;
                statement.setString(4, job) ;
                statement.setString(5, age);
                statement.setString(6, salary);
                statement.setString(7, contact);
                statement.setString(8, email);
                statement.executeUpdate() ;
                JOptionPane.showMessageDialog(null, "Employee is Added Successfully");
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An Error Occurred : " + ex.getMessage() );
            }
        }
        else if (e.getSource() == btnBack)
        {
            new Admin();
            dispose();
        }
        else if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }
//    public static void main(String[] args) {
//        new AddEmployee();
//    }
}

package HotelManagementSystem;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.ResultSet;

public class Employee extends JFrame {

    private JTable table;

  public   Employee(){


        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 600);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        add(panel);

        table= new JTable();
        table.setBounds(20,40,500,400);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        table.setBorder(border);
        panel.add(table);

        try {

            Conn c = new Conn();
            String info= "select all from employees";
            ResultSet resultSet =c.statement.executeQuery(info);

        }catch (Exception e){
            e.printStackTrace();
        }


        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        setVisible(true);
    }


}

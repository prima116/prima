import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 

public class Registration extends JFrame implements ActionListener
  { 

    JLabel lbHeader, lbUserName, lbEmail, lbPassword, lbConfirmPassword, lbFullName, lbGendar, lbPhoneNo;

    JTextField tf1, tf2, tf5, tf6, tf7;

    JButton btn1, btn2;

    JPasswordField p1, p2;

 

    Registration()
     {

        setVisible(true);

        setSize(550, 550);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Registration Form in Java");

 

        lbHeader = new JLabel("Please Sign Up Here!!!!");

        lbHeader.setForeground(Color.gray);

        lbHeader.setFont(new Font("Serif", Font.BOLD, 20));

 

        lbUserName = new JLabel("User Name");

        lbEmail = new JLabel("Email-ID");

        lbPassword = new JLabel("Passowrd");

        lbConfirmPassword = new JLabel("Confirm Password");

        lbFullName = new JLabel("Full Name");

        lbGendar = new JLabel("Gendar");

        lbPhoneNo = new JLabel("Phone No"); 

        tf1 = new JTextField();

        tf2 = new JTextField();

        p1 = new JPasswordField();

        p2 = new JPasswordField();

        tf5 = new JTextField();

        tf6 = new JTextField();

        tf7 = new JTextField();

 

        btn1 = new JButton("Submit");

        btn2 = new JButton("Clear");

 

        btn1.addActionListener(this);

        btn2.addActionListener(this);

 

        lbHeader.setBounds(150, 20, 400, 30);

        lbUserName.setBounds(80, 70, 200, 30);
        
        lbFullName.setBounds(80, 110, 200, 30);
        
        lbGendar.setBounds(80, 150, 200, 30);

        lbPassword.setBounds(80, 190, 200, 30);

        lbConfirmPassword.setBounds(80, 230, 200, 30);

        lbEmail.setBounds(80, 270, 200, 30);

        lbPhoneNo.setBounds(80, 310, 200, 30);

        tf1.setBounds(300, 70, 200, 30);

        tf2.setBounds(300, 110, 200, 30);

        p1.setBounds(300, 150, 200, 30);

        p2.setBounds(300, 190, 200, 30);

        tf5.setBounds(300, 230, 200, 30);

        tf6.setBounds(300, 270, 200, 30);

        tf7.setBounds(300, 310, 200, 30);

        btn1.setBounds(50, 350, 100, 30);

        btn2.setBounds(170, 350, 100, 30);

 

        add(lbHeader);

        add(lbUserName);

        add(tf1);

        add(lbEmail);

        add(tf2);

        add(lbPassword);

        add(p1);

        add(lbConfirmPassword);

        add(p2);

        add(lbFullName);

        add(tf5);

        add(lbGendar);

        add(tf6);

        add(lbPhoneNo);

        add(tf7);

        add(btn1);

        add(btn2);

    }

 

    public void actionPerformed(ActionEvent e)
     {

        if (e.getSource() == btn1)
         {

            int x = 0;

            String s1 = tf1.getText();

            String s2 = tf2.getText();

 

            char[] s3 = p1.getPassword();

            char[] s4 = p2.getPassword(); 

            String s8 = new String(s3);

            String s9 = new String(s4);

 

            String s5 = tf5.getText();

            String s6 = tf6.getText();

            String s7 = tf7.getText();

            if (s8.equals(s9))
           {

                try
               {

                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");

                    PreparedStatement ps = con.prepareStatement("insert into reg values(?,?,?,?,?,?)");

                    ps.setString(1, s1);

                    ps.setString(2, s2);

                    ps.setString(3, s8);

                    ps.setString(4, s5);

                    ps.setString(5, s6);

                    ps.setString(6, s7);

                    ResultSet rs = ps.executeQuery();

                    x++;

                    if (x > 0)
                    {

                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");

                    }

                }
          catch (Exception ex)
                {

                    System.out.println(ex);

                }

            }
          else
           {

                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");

            } 

        }
          else
       {

            tf1.setText("");

            tf2.setText("");

            tf5.setText("");

            tf6.setText("");
            
            p1.setText("");

            p2.setText("");

            tf7.setText("");

        }

    } 

    public static void main(String args[])
   {

        new Registration();

    }
}


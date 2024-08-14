package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class FP1 extends JFrame {
    public static String s;
    public FP1()
    {
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setFocusable(true);//cursor focus on frame

        getContentPane().setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(14,235,195));
        headerPanel.setBounds(0,0,900,90);
        add(headerPanel);
        headerPanel.setLayout(null);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(14,235,195));
        inputPanel.setBounds(150,180,600,350);
        add(inputPanel);
        inputPanel.setLayout(null);

        Font f1 = new Font("Arial", Font.BOLD, 30);
        Font f2 = new Font("Arial", Font.PLAIN, 25);
        Font f3 = new Font("Arial", Font.PLAIN, 16);
        Font f4 = new Font("Arial", Font.BOLD, 20);
        Font f5 = new Font("Arial", Font.PLAIN, 25);



        JLabel l1=new JLabel();
        l1.setText("Recover Password");
        l1.setFont(f1);
        l1.setBounds(300, 30, 350, 30);
        headerPanel.add(l1);

        JLabel l2=new JLabel();
        l2.setText("Provide Account Details");
        l2.setFont(f2);
        l2.setBounds(150, 130, 350, 30);
        add(l2);

        JLabel l3=new JLabel();
        l3.setText("To verify your identity, please enter the mobile number associated with your account.");
        l3.setFont(f3);
        l3.setBounds(5, 25, 600, 25);
        inputPanel.add(l3);

        JLabel l4=new JLabel();
        l4.setText("Mobile Number");
        l4.setFont(f4);
        l4.setBounds(120, 110, 200, 25);
        inputPanel.add(l4);

        JTextField t1= new JTextField();
        t1.setBounds(120,150,350,45);
        t1.setBorder(null);//to remove the border of the JTextfield
        t1.setFont(f5);
        inputPanel.add(t1);

        JButton b1 = new JButton("PROCEED");
        b1.setBounds(225,230,150,40);
        b1.setFont(f4);
        b1.setBackground(new Color(6, 70, 93));// Set custom background color for the button
        b1.setForeground(Color.white);// Set custom text color for the button
        b1.setFocusable(false);// Remove the border around the text
        b1.setBorder(null);//Remove the border around the Button
        inputPanel.add(b1);

        JButton b2 = new JButton("Back");
        b2.setBounds(15, 520, 100, 25);
        b2.setFont(f4);
        b2.setBackground(new Color(6, 70, 93));
        b2.setForeground(new Color(255, 255, 255));
        b2.setFocusable(false);
        b2.setBorder(null);
        add(b2);

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here

                String Mobile=t1.getText();
                s=Mobile;
                String queryFP = "SELECT * FROM `register`";

                DBconnect db = new DBconnect();
                try {
                    int val= db.FP(queryFP,Mobile);
                    if(val==1)
                    {
                        dispose();
                        new FP2();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Wrong Mobile Number.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new SignIn(); // Open a new instance of the SignIn class
            }
        });

        setVisible(true);
    }
}

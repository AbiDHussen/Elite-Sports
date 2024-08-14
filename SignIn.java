package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Objects;

public class SignIn extends JFrame {
    public SignIn()
    {
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setFocusable(true);//cursor focus on frame

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("EliteSp3.jpg")));
        JLabel imglabel = new JLabel(img);
        imglabel.setBounds(40,100,300,300);
        add(imglabel);

        getContentPane().setBackground(new Color(14,235,195));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.white);
        headerPanel.setBounds(0,0,400,600);
        add(headerPanel);

        Font f1 = new Font("Arial", Font.BOLD, 30);
        Font f2 = new Font("Arial", Font.BOLD, 20);
        Font f3 = new Font("Arial", Font.ITALIC, 15);
        Font f4 = new Font("Arial", Font.BOLD, 15);



        JLabel lvl1 = new JLabel();
        lvl1.setText("Login");
        lvl1.setFont(f1);
        lvl1.setBounds(490,60,250,40);
        add(lvl1);

        JLabel lvl2 = new JLabel();
        lvl2.setText("Email");
        lvl2.setFont(f2);
        lvl2.setBounds(500,150,100,20);
        add(lvl2);

        JLabel lvl3 = new JLabel();
        lvl3.setText("Password");
        lvl3.setFont(f2);
        lvl3.setBounds(500,250,150,20);
        add(lvl3);

        JLabel lvl4 = new JLabel();
        lvl4.setText("Welcome Back!Please login to your Account.");
        lvl4.setForeground(new Color(4, 55, 75));
        lvl4.setFont(f3);
        lvl4.setBounds(500,110,400,20);
        add(lvl4);

        JLabel lvl5 = new JLabel("<html><u>Forgot Password?</u></html>");//for underline the Jlabel
//        lvl5.setText("Forgot Password?");
//        lvl5.setForeground(Color.blue);
        lvl5.setFont(f4);
        lvl5.setBounds(645,335,400,20);
        add(lvl5);

//        JLabel lvl6 = new JLabel("<html><u>Reset!</u></html>");//for underline the Jlabel
////        lvl6.setText("Reset!");
//        lvl6.setForeground(Color.BLACK);
//        lvl6.setFont(f4);
//        lvl6.setBounds(730,335,400,20);
//        add(lvl6);

        JLabel lvl6 = new JLabel();
        lvl6.setText("Dont't Have An Account?");
        lvl6.setFont(f4);
        lvl6.setBounds(585,10,300,20);
        add(lvl6);

        JLabel lvl7 = new JLabel("<html><u>Register Here!</u></html>");
        lvl7.setFont(f4);
        lvl7.setBounds(775,10,300,20);
        lvl7.setForeground(new Color(3, 24, 96, 179));
        add(lvl7);

        JTextField t1= new JTextField();
        t1.setBounds(500,190,280,40);
        t1.setBorder(null);//to remove the border of the JTextfield
        t1.setFont(f4);
        add(t1);

        JTextField t2= new JTextField();
        t2.setBounds(500,290,280,40);
        t2.setBorder(null);//to remove the border of the JTextfield
        t2.setFont(f4);
        add(t2);


        JButton b1 = new JButton("Login");
        b1.setBounds(565,370,150,40);
        b1.setFont(f2);
        b1.setBackground(new Color(6, 70, 93));// Set custom background color for the button
        b1.setForeground(Color.white);// Set custom text color for the button
        b1.setFocusable(false);// Remove the border around the text
        b1.setBorder(null);//Remove the border around the Button
        add(b1);

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here

                String Email=t1.getText();
                String pass=t2.getText();

                String queryLogin = "SELECT * FROM `register`";

                DBconnect db = new DBconnect();
                try {
                    int val= db.Login(queryLogin,Email,pass);
                    if(val==1)
                    {
                        dispose();
                        new Menu();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You are not registered.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                String query = "SELECT `Username`, `Mobile` FROM `register` WHERE Email='"+Email+"'";
                try {
                    db.setProfile(query,Email);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        lvl6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new RegisterFrom(); // Open a new instance of the SignIn class
            }
        });

        lvl5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new FP1(); // Open a new instance of the SignIn class
            }
        });

        setVisible(true);
    }

}

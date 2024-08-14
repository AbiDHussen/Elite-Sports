package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterFrom extends JFrame {
    public RegisterFrom()
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

        Font f1 = new Font("Arial", Font.BOLD, 25);
        Font f3 = new Font("Times New Roman",Font.BOLD, 15);


        JLabel lvl1 = new JLabel();
        lvl1.setText("Create An Account ");
        lvl1.setFont(f1);
        lvl1.setBounds(440,60,250,30);
        add(lvl1);

        JTextField t1= new JTextField();
        t1.setBounds(450,135,180,30);
        t1.setBorder(null);//to remove the border of the JTextfield
        t1.setFont(f3);
        add(t1);

        JTextField t2= new JTextField();
        t2.setBounds(660,135,180,30);
        t2.setBorder(null);//to remove the border of the JTextfield
        t2.setFont(f3);
        add(t2);

        JTextField t3= new JTextField();
        t3.setBounds(450,220,180,30);
        t3.setBorder(null);//to remove the border of the JTextfield
        t3.setFont(f3);

        add(t3);

        JTextField t4= new JTextField();
        t4.setBounds(660,220,180,30);
        t4.setBorder(null);//to remove the border of the JTextfield
        t4.setFont(f3);
        add(t4);

        JTextField t5= new JTextField();
        t5.setBounds(450,305,180,30);
        t5.setBorder(null);//to remove the border of the JTextfield
        t5.setFont(f3);

        add(t5);

        JTextField t6= new JTextField();
        t6.setBounds(660,305,180,30);
        t6.setBorder(null);//to remove the border of the JTextfield
        t6.setFont(f3);

        add(t6);

        Font f2 = new Font("Arial", Font.BOLD, 15);
        JLabel lvl2 = new JLabel();
        lvl2.setText("Username");
        lvl2.setFont(f2);
        lvl2.setBounds(450,105,100,20);
        add(lvl2);

        JLabel lvl3 = new JLabel();
        lvl3.setText("Mobile");
        lvl3.setFont(f2);
        lvl3.setBounds(660,105,100,20);
        add(lvl3);

        JLabel lvl4 = new JLabel();
        lvl4.setText("Email");
        lvl4.setFont(f2);
        lvl4.setBounds(450,190,100,20);
        add(lvl4);

        JLabel lvl5 = new JLabel();
        lvl5.setText("Address");
        lvl5.setFont(f2);
        lvl5.setBounds(660,190,100,20);
        add(lvl5);

        JLabel lvl6 = new JLabel();
        lvl6.setText("Create Password");
        lvl6.setFont(f2);
        lvl6.setBounds(450,275,150,20);
        add(lvl6);

        JLabel lvl7 = new JLabel();
        lvl7.setText("Confirm Password");
        lvl7.setFont(f2);
        lvl7.setBounds(660,275,150,20);
        add(lvl7);

        JLabel lvl8 = new JLabel();
        lvl8.setText("Already Have An Account?");
        lvl8.setFont(f2);
        lvl8.setBounds(585,10,300,20);
        add(lvl8);

        JLabel lvl9 = new JLabel("<html><u>Sign in Here!</u></html>");//for underline the Jlabel
        lvl9.setFont(f2);
//        lvl9.setFont(lvl9.getFont().deriveFont(Font.ITALIC));
        lvl9.setBounds(785,10,300,20);
        lvl9.setForeground(new Color(3, 24, 96, 179));
        add(lvl9);

        lvl9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new SignIn(); // Open a new instance of the SignIn class
            }
        });

        JButton b1 = new JButton("Create Account");
        b1.setBounds(545,370,200,40);
        b1.setFont(f2);
        b1.setBackground(new Color(6, 70, 93));// Set custom background color for the button
        b1.setForeground(Color.white);// Set custom text color for the button
        b1.setFocusable(false);// Remove the border around the text
        b1.setBorder(null);//Remove the border around the Button
        add(b1);

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click action here
//                dispose(); // Close the current RegisterFrom frame
                int duplicate=0,duplicate1=0;
                String Name=t1.getText();
                String Mobile=t2.getText();
                String Email=t3.getText();
                String Address=t4.getText();
                String pass=t5.getText();
                String Conpass=t6.getText();

                String DuplicateEmailCheckQuery = "SELECT * FROM `register`";
                DBconnect db = new DBconnect();
                try {
                    duplicate=db.DuplicateEmailCheck(DuplicateEmailCheckQuery,Email);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                String DuplicateMoibleCheckQuery = "SELECT * FROM `register`";
                DBconnect db2 = new DBconnect();
                try {
                    duplicate1=db2.DuplicateMobileCheck(DuplicateMoibleCheckQuery,Mobile);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                //validation
                String NameRegex = "^[a-zA-Z]{3,20}$";
                String MobileRegex = "^(\\+88)?01[2-9]\\d{8}$";
                String EmailRegex = "^[a-zA-Z]+[0-9#$*!]*@[a-zA-Z]+\\.[a-zA-Z]{2,}$";
                String PassRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,30}$";
                String AddressRegex = "^[a-zA-Z0-9-,.\\s]{4,50}$";

                if(!Pattern.matches(NameRegex,Name))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Name. Please enter a valid name with 3 to 20 alphabetical characters.","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else if(!Pattern.matches(MobileRegex,Mobile))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Please enter a valid Bangladeshi mobile number starting with 01, with a total of 11 digits.","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else if(duplicate1==1)
                {
                    JOptionPane.showMessageDialog(null,"This Mobile Number is Already Taken","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else if(!Pattern.matches(EmailRegex,Email))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Email Address. Please enter a valid email address.","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else if(duplicate==1)
                {
                    JOptionPane.showMessageDialog(null,"This Email is Already Taken","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else if(!Pattern.matches(AddressRegex,Address))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Address. Please enter a valid Address.","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else if(!Pattern.matches(PassRegex,pass))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Password. Please ensure your password contains at least one digit, one lowercase letter,\n one uppercase letter, and one special character and is 8 to 20 characters long.","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else if(!Conpass.equals(pass))
                {
                    JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match. Please ensure both fields have the same value.","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    String insertQuery = "INSERT INTO `register`(`Username`, `Mobile`, `Email`, `Address`, `Password`) VALUES ('"+Name+"','"+Mobile+"','"+Email+"','"+Address+"','"+pass+"')";
                    DBconnect db1 = new DBconnect();
                    try {
                        db1.RegisterInsert(insertQuery);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    dispose();
                }

            }
        });


        setVisible(true);
    }
}

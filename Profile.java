package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Profile extends JFrame {
    private static String userName;
    private static String email;
    private static String mobile;

    public static void setVal(String userName, String email, String mobile) {
        Profile.userName = userName;
        Profile.email = email;
        Profile.mobile = mobile;
    }
    public Profile() {

        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setFocusable(true);
        getContentPane().setBackground(new Color(255, 255, 255));

        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font f1 = new Font("Arial", Font.BOLD, 15);
        Font f2 = new Font("Arial", Font.BOLD, 20);
        Font f3 = new Font("Arial", Font.BOLD, 18);
//        Font f4 = new Font("Arial", Font.BOLD, 20);




        ImageIcon i = new ImageIcon(getClass().getResource("EliteSp_small.jpg"));
        JLabel iLabel = new JLabel(i);
        iLabel.setBounds(350, 0, 200, 200);
        add(iLabel);

//        ImageIcon i1 = new ImageIcon(getClass().getResource("Pic1.jpg"));
//        JLabel i1Label = new JLabel(i1);
//        i1Label.setBounds(50, 20, 200, 216);
//        add(i1Label);


        JButton b1 = new JButton("Edit Profile");
        b1.setBounds(750, 20, 100, 25);
        b1.setFont(f1);
        b1.setBackground(new Color(6, 70, 93));
        b1.setForeground(new Color(255, 255, 255));
        b1.setFocusable(false);
        b1.setBorder(null);
        add(b1);

        JButton b2 = new JButton("User Profile");
        b2.setBounds(350, 200, 300, 25);
        b2.setFont(f1);
        b2.setBackground(new Color(6, 70, 93));
        b2.setForeground(new Color(255, 255, 255));
        b2.setFocusable(false);
        b2.setBorder(null);
        add(b2);

        JButton b3 = new JButton("Back");
        b3.setBounds(15, 520, 100, 25);
        b3.setFont(f1);
        b3.setBackground(new Color(6, 70, 93));
        b3.setForeground(new Color(255, 255, 255));
        b3.setFocusable(false);
        b3.setBorder(null);
        add(b3);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(161, 161, 161));
        headerPanel.setBounds(50, 20, 130, 110);
        headerPanel.setLayout(null);
        add(headerPanel);

        JLabel l1= new JLabel();
        l1.setText("Add Image");
        l1.setBounds(15,30,100,50);
        l1.setForeground(Color.white);
        l1.setFont(f2);
        headerPanel.add(l1);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(255, 255, 255));
        inputPanel.setBounds(5, 5, 800, 550);
        inputPanel.setLayout(null);
        add(inputPanel);

        JLabel profilelabel = new JLabel();
        profilelabel.setBounds(60, 0, 80, 20);
        profilelabel.setFont(f1);
        inputPanel.add(profilelabel);

        JLabel proflabel = new JLabel("Profile Picture");
        proflabel.setBounds(45, 130, 150, 30);
        proflabel.setFont(f2);
        inputPanel.add(proflabel);

        JLabel namelabel = new JLabel("UserName:");
        namelabel.setBounds(180, 250, 100, 40);
        namelabel.setFont(f3);
        inputPanel.add(namelabel);

        JTextField nameText = new JTextField(userName);
        nameText.setBounds(300, 250, 400, 40);
        nameText.setBackground(new Color(14, 235, 195));
        nameText.setFont(labelFont);
        nameText.setBorder(null);
        nameText.setEditable(false);
        inputPanel.add(nameText);

        JLabel emaillabel = new JLabel("Email:");
        emaillabel.setBounds(220, 315, 100, 40);
        emaillabel.setFont(f3);
        inputPanel.add(emaillabel);


        JTextField emailText = new JTextField(email);
        emailText.setBounds(300, 315, 400, 40);
        emailText.setBackground(new Color(14, 235, 195));
        emailText.setFont(labelFont);
        emailText.setBorder(null);
        emailText.setEditable(false);
        inputPanel.add(emailText);

        JLabel mobilelabel = new JLabel("Mobile No:");
        mobilelabel.setBounds(180, 380, 100, 40);
        mobilelabel.setFont(f3);
        inputPanel.add(mobilelabel);

        JTextField mobileText = new JTextField(mobile);
        mobileText.setBounds(300, 380, 400, 40);
        mobileText.setBackground(new Color(14, 235, 195));
        mobileText.setFont(labelFont);
        mobileText.setBorder(null);
        mobileText.setEditable(false);
        inputPanel.add(mobileText);

//        JLabel biolabel = new JLabel("Bio:");
//        biolabel.setBounds(250, 400, 100, 40);
//        biolabel.setFont(f3);
//        inputPanel.add(biolabel);


//        JTextField bioText = new JTextField();
//        bioText.setBounds(300, 405, 400, 30);
//        bioText.setBackground(new Color(14, 235, 195));
//        bioText.setFont(labelFont);
//        bioText.setBorder(null);
//        inputPanel.add(bioText);

        JLabel acclabel = new JLabel("Delete Account:");
        acclabel.setBounds(135, 445, 200, 40);
        acclabel.setFont(f3);
        inputPanel.add(acclabel);

        JButton b4 = new JButton("Confirm");
        b4.setBounds(300, 445, 400, 40);
        b4.setBackground(new Color(14, 235, 195));
        b4.setForeground(new Color(0, 0, 0));
        b4.setFont(f2);
        b4.setFocusable(false);
        b4.setBorder(null);
        inputPanel.add(b4);
        setVisible(true);

        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                dispose();
                new Menu();
            }
        });

        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                int a=JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete your Account?");
                if(a==JOptionPane.YES_OPTION){
                    DBconnect db = new DBconnect();

                    String query="DELETE FROM `register` WHERE Email = '"+email+"'";
                    try {
                        db.DeleteAcc(query);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
}
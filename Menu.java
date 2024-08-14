package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Menu extends JFrame {
    public Menu()
    {
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setFocusable(true);//cursor focus on frame
        getContentPane().setBackground(new Color(255,255,255));

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("EliteSp_small.jpg")));
        JLabel imglabel = new JLabel(img);
        imglabel.setBounds(350,0,200,200);
        add(imglabel);

        Font f1 = new Font("Arial", Font.BOLD, 30);
        Font f2 = new Font("Arial", Font.BOLD, 20);
        Font f3 = new Font("Arial", Font.ITALIC, 15);
        Font f4 = new Font("Arial", Font.BOLD, 15);

        JButton b1 = new JButton("Cricket");
        b1.setBounds(150,200,600,50);
        b1.setFont(f2);
        b1.setBackground(new Color(14,235,195));// Set custom background color for the button
        b1.setForeground(Color.BLACK);// Set custom text color for the button
        b1.setFocusable(false);// Remove the border around the text
        b1.setBorder(null);//Remove the border around the Button
        add(b1);

        JButton b2 = new JButton("Football");
        b2.setBounds(150,300,600,50);
        b2.setFont(f2);
        b2.setBackground(new Color(14,235,195));// Set custom background color for the button
        b2.setForeground(Color.BLACK);// Set custom text color for the button
        b2.setFocusable(false);// Remove the border around the text
        b2.setBorder(null);//Remove the border around the Button
        add(b2);

        JButton b3 = new JButton("BasketBall");
        b3.setBounds(150,400,600,50);
        b3.setFont(f2);
        b3.setBackground(new Color(14,235,195));// Set custom background color for the button
        b3.setForeground(Color.BLACK);// Set custom text color for the button
        b3.setFocusable(false);// Remove the border around the text
        b3.setBorder(null);//Remove the border around the Button
        add(b3);

        JButton b4 = new JButton("Log Out");
        b4.setBounds(10,10,150,40);
        b4.setFont(f2);
        b4.setBackground(new Color(6, 70, 93));// Set custom background color for the button
        b4.setForeground(Color.white);// Set custom text color for the button
        b4.setFocusable(false);// Remove the border around the text
        b4.setBorder(null);//Remove the border around the Button
        add(b4);

        JButton b5 = new JButton("Profile");
        b5.setBounds(720,10,150,40);
        b5.setFont(f2);
        b5.setBackground(new Color(6, 70, 93));// Set custom background color for the button
        b5.setForeground(Color.white);// Set custom text color for the button
        b5.setFocusable(false);// Remove the border around the text
        b5.setBorder(null);//Remove the border around the Button
        add(b5);

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new Cricket(); // Open a new instance of the SignIn class
            }
        });

        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new Football(); // Open a new instance of the SignIn class
            }
        });

        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new Basketball(); // Open a new instance of the SignIn class
            }
        });

        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                int a=JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?");
                if(a==JOptionPane.YES_OPTION){
                    dispose();
                    new SignIn();
                }
            }
        });

        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Handle the click action here
                dispose();
                new Profile();
            }
        });


        setVisible(true);
    }

}

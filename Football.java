package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class Football extends JFrame {
    public Football()
    {
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setFocusable(true);//cursor focus on framet
        getContentPane().setBackground(new Color(255, 255, 255));

        Font f1 = new Font("Arial", Font.BOLD, 30);
        Font f2 = new Font("Arial", Font.BOLD, 20);
        Font f3 = new Font("Arial", Font.ITALIC, 15);
        Font f4 = new Font("Arial", Font.BOLD, 15);

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("EliteSp_small.jpg")));
        JLabel imglabel = new JLabel(img);
        imglabel.setBounds(350,0,200,200);
        add(imglabel);

        JButton b1 = new JButton("Live Score");
        b1.setBounds(150,200,600,50);
        b1.setFont(f2);
        b1.setBackground(new Color(14,235,195));// Set custom background color for the button
        b1.setForeground(Color.BLACK);// Set custom text color for the button
        b1.setFocusable(false);// Remove the border around the text
        b1.setBorder(null);//Remove the border around the Button
        add(b1);

        JButton b2 = new JButton("Live Stream");
        b2.setBounds(150,280,600,50);
        b2.setFont(f2);
        b2.setBackground(new Color(14,235,195));// Set custom background color for the button
        b2.setForeground(Color.BLACK);// Set custom text color for the button
        b2.setFocusable(false);// Remove the border around the text
        b2.setBorder(null);//Remove the border around the Button
        add(b2);

        JButton b3 = new JButton("Highlights");
        b3.setBounds(150,360,600,50);
        b3.setFont(f2);
        b3.setBackground(new Color(14,235,195));// Set custom background color for the button
        b3.setForeground(Color.BLACK);// Set custom text color for the button
        b3.setFocusable(false);// Remove the border around the text
        b3.setBorder(null);//Remove the border around the Button
        add(b3);

        JButton b4 = new JButton("Upcoming Matches");
        b4.setBounds(150,440,600,50);
        b4.setFont(f2);
        b4.setBackground(new Color(14,235,195));// Set custom background color for the button
        b4.setForeground(Color.BLACK);// Set custom text color for the button
        b4.setFocusable(false);// Remove the border around the text
        b4.setBorder(null);//Remove the border around the Button
        add(b4);

        JButton b5 = new JButton("Back");
        b5.setBounds(10,520,150,40);
        b5.setFont(f2);
        b5.setBackground(new Color(6, 70, 93));// Set custom background color for the button
        b5.setForeground(Color.white);// Set custom text color for the button
        b5.setFocusable(false);// Remove the border around the text
        b5.setBorder(null);//Remove the border around the Button
        add(b5);

        b1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Desktop d = Desktop.getDesktop();
                try {
                    d.browse(new URI("https://www.goal.com/en-in/live-scores"));
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        b2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Desktop d = Desktop.getDesktop();
                try {
                    d.browse(new URI("https://shootz.yalla-shoot-tv.live/"));
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        b3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Desktop d = Desktop.getDesktop();
                try {
                    d.browse(new URI("https://hoofoot.com/"));
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        b4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Desktop d = Desktop.getDesktop();
                try {
                    d.browse(new URI("https://hoofoot.com/"));
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click action here
                dispose(); // Close the current RegisterFrom frame
                new Menu(); // Open a new instance of the SignIn class
            }
        });


        setVisible(true);
    }

}

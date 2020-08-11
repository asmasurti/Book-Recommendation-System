/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookRecommendationSystem;

import javax.swing.JFrame;
import java.awt.FlowLayout; 
import java.awt.Graphics;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon;
import javax.swing.ImageIcon; 
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author 342174893
 */
public class MainPage extends JFrame implements ActionListener {
    
    //Declare variables
    JLabel lblTitle, lblBackground, lblLogIn, lblSignUp;
    JButton btnLogIn;
    JButton btnSignUp;
    Font fHeader = new Font("Copperplate Gothic Light", Font.PLAIN, 25);
    Font fBody = new Font("High Tower Text", Font.PLAIN, 19);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);
    ImageIcon pic = new ImageIcon("background.jpg");
    Color c1 = new Color(208, 204, 197);
    
    public MainPage() {
        super( "Testing JLabel" );
        setLayout(null);
        
        //background label with picture
        lblBackground = new JLabel();
        lblBackground.setSize(500, 500);
        lblBackground.setIcon(pic);
        add(lblBackground);
        
        //label for title 
        lblTitle = new JLabel();
        lblTitle.setText("Welcome to Book Recommender");
        lblTitle.setFont(fHeader);
        lblTitle.setSize(500, 100);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setLocation(20, 20);
        lblBackground.add(lblTitle);
        
        //label for log in
        lblLogIn = new JLabel();
        lblLogIn.setText("Would you like to");
        lblLogIn.setFont(fBody);
        lblLogIn.setSize(200, 100);
        lblLogIn.setForeground(Color.WHITE);
        lblLogIn.setLocation(50, 130);
        lblBackground.add(lblLogIn);
        
        //log in button
        btnLogIn = new JButton();
        btnLogIn.setText("Log In");
        btnLogIn.setFont(fButton);
        btnLogIn.setSize(110, 30);
        btnLogIn.setLocation(70, 210);
        btnLogIn.setBackground(c1);
        lblBackground.add(btnLogIn);
        btnLogIn.setActionCommand("Log In");
        btnLogIn.addActionListener(this);
        
        lblLogIn = new JLabel();
        lblLogIn.setText("or");
        lblLogIn.setFont(fBody);
        lblLogIn.setSize(100, 100);
        lblLogIn.setForeground(Color.WHITE);
        lblLogIn.setLocation(115, 210);
        lblBackground.add(lblLogIn);
        
        //sign up button
        btnSignUp = new JButton();
        btnSignUp.setText("Sign Up");
        btnSignUp.setFont(fButton);
        btnSignUp.setSize(110, 30);
        btnSignUp.setLocation(70, 280);
        btnSignUp.setBackground(c1);
        lblBackground.add(btnSignUp); 
        btnSignUp.setActionCommand("Sign Up");
        btnSignUp.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e) {
        //open log in page
        if(e.getActionCommand().equals("Log In")) {
           Login f1 = new Login();
           f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
           f1.setSize(500, 500 ); 
           f1.setVisible(true); 
           this.dispose();    
        }
        //open sign up page
        if(e.getActionCommand().equals("Sign Up")) {
            SignUp f1 = new SignUp();
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
    }
}

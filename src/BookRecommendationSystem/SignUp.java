/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookRecommendationSystem;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.FlowLayout; 
import java.awt.Font;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon;
import javax.swing.ImageIcon; 
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Surti
 */
public class SignUp extends JFrame implements ActionListener{
    
    //Declare variables 
    JLabel lblUsername, lblPassword, lblOutput, lblBackground, lblTitle; 
    JTextField txtUsername, txtPassword;
    JButton btnSignUp, btnBack;
    Font fHeader = new Font("Copperplate Gothic Light", Font.PLAIN, 25);
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);
    ImageIcon pic = new ImageIcon("background.jpg");
    Color c1 = new Color(208, 204, 197);
    
    public SignUp() {
        super("Testing JLabel");
        setLayout(null);
        
        //label for background with picture
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
        
        //text field for username
        txtUsername = new JTextField();
        txtUsername.setFont(fBody);
        txtUsername.setSize(100, 30);
        txtUsername.setLocation(130, 180);
        lblBackground.add(txtUsername);      
        
        //text field for password
        txtPassword = new JTextField();
        txtPassword.setFont(fBody);
        txtPassword.setSize(100, 30);
        txtPassword.setLocation(130, 230);
        lblBackground.add(txtPassword); 
        
        //label for username
        lblUsername = new JLabel();
        lblUsername.setText("Username");
        lblUsername.setFont(fBody);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setSize(200, 30);
        lblUsername.setLocation(20, 180);
        lblBackground.add(lblUsername);       
        
        //label for password
        lblPassword = new JLabel();
        lblPassword.setText("Password");
        lblPassword.setFont(fBody);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setSize(200, 30);
        lblPassword.setLocation(20, 230);
        lblBackground.add(lblPassword); 
        
        //sign up button
        btnSignUp = new JButton();
        btnSignUp.setText("Sign Up");
        btnSignUp.setSize(100, 30);
        btnSignUp.setLocation(130, 310);
        btnSignUp.setFont(fButton);
        btnSignUp.setBackground(c1);
        lblBackground.add(btnSignUp); 
        btnSignUp.setActionCommand("Sign Up");
        btnSignUp.addActionListener(this);
        
        //label for any possible outputs
        lblOutput = new JLabel();
        lblOutput.setText("");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setSize(220, 30);
        lblOutput.setLocation(30, 270);
        lblOutput.setFont(fBody);
        lblOutput.setForeground(new Color(130, 16, 13));
        lblBackground.add(lblOutput);
        
        //button to go back
        btnBack = new JButton();
        btnBack.setText("Back");
        btnBack.setSize(100, 30);
        btnBack.setFont(fButton);
        btnBack.setBackground(c1);
        btnBack.setLocation(130, 350);
        lblBackground.add(btnBack); 
        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);     
    } 
    
    public void actionPerformed (ActionEvent e) {
        if(e.getActionCommand().equals("Sign Up")) {
           String strName = txtUsername.getText();
           
           Member m1 = new Member();
           
           //if no username entered 
           if(strName.equals("")) {
               lblOutput.setText("Enter a Username");
               btnSignUp.setText("Try Again"); 
               txtUsername.setText("");
           }
           //if no password entered 
           else if(txtPassword.getText().equals("")) {
               lblOutput.setText("Enter a Password");
               btnSignUp.setText("Try Again"); 
           }
           //add the new member and open the options page
           else if(m1.newMember(strName)) {
                m1.addPassword(txtPassword.getText());
                OptionsPage f1 = new OptionsPage(strName);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
                f1.setSize(500, 500 ); 
                f1.setVisible(true); 
                this.dispose();
           }
           //username already exists
           else {
               lblOutput.setText("Username already exists");
               txtPassword.setText("");
               btnSignUp.setText("Try Again"); 
               txtUsername.setText("");
           }
        }
        
        //open the main page
        if(e.getActionCommand().equals("Back")) {
            MainPage f1 = new MainPage();
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose();
        }
    }
}


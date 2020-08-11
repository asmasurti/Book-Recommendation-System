/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookRecommendationSystem;

import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.util.ArrayList;
/**
 *
 * @author 342174893
 */
public class Login extends JFrame implements ActionListener {
    
    //declare variables
    JLabel lblUsername, lblPassword, lblOutput, lblBackground, lblTitle; 
    JTextField txtUsername, txtPassword;
    JButton btnLogIn, btnSignUp, btnBack;
    Font fHeader = new Font("Copperplate Gothic Light", Font.PLAIN, 25);
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);
    ImageIcon pic = new ImageIcon("background.jpg");
    Color c1 = new Color(208, 204, 197);
    
    public Login() {
        super( "Testing JLabel" );
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
        
        //log in button
        btnLogIn = new JButton();
        btnLogIn.setText("Log In");
        btnLogIn.setSize(100, 30);
        btnLogIn.setLocation(130, 310);
        btnLogIn.setFont(fButton);
        btnLogIn.setBackground(c1);
        lblBackground.add(btnLogIn);
        btnLogIn.setActionCommand("Log In");
        btnLogIn.addActionListener(this);
        
        //label for any possible outputs
        lblOutput = new JLabel();
        lblOutput.setText("");
        lblOutput.setFont(fBody);
        lblOutput.setForeground(new Color(130, 16, 13));
        lblOutput.setSize(200, 30);
        lblOutput.setLocation(40, 270);
        lblBackground.add(lblOutput);
        
        //sign up button
        btnSignUp = new JButton();
        btnSignUp.setText("Sign Up");
        btnSignUp.setSize(100, 30);
        btnSignUp.setLocation(20, 310);
        btnSignUp.setFont(fButton);
        btnSignUp.setBackground(c1);
        lblBackground.add(btnSignUp); 
        btnSignUp.setActionCommand("Sign Up");
        btnSignUp.addActionListener(this);
        btnSignUp.setVisible(false);
        
        //button to go back to main page
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
        if(e.getActionCommand().equals("Log In")) {
           String strName = txtUsername.getText();
           
           Member m1 = new Member();
           //for admin login
           if (txtUsername.getText().equals("Admin") && txtPassword.getText().equals("adminPassword")) {
                AdminPage f1 = new AdminPage(strName);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
                f1.setSize(500, 500 ); 
                f1.setVisible(true); 
                this.dispose();
           }
           //if no username
           else if(strName.equals("")) {
                lblOutput.setText("" + m1.numberMembers());
                btnLogIn.setText("Try Again"); 
                txtUsername.setText("");
                btnSignUp.setVisible(true);
           }  
           //if no password
           else if(txtPassword.getText().equals("")) {
                lblOutput.setText("Enter a Password");
                btnLogIn.setText("Try Again"); 
                txtUsername.setText("");
                txtPassword.setText("");
                btnSignUp.setVisible(true);
           }
           //if username doesn't exist
           else if (m1.findMember(strName) == -1) {
                lblOutput.setText("Username Not found");
                btnLogIn.setText("Try Again"); 
                txtUsername.setText("");
                txtPassword.setText("");
                btnSignUp.setVisible(true);        
           }
           //if the password entered is incorrect for a correct username
           else if (!m1.getPassword(m1.findMember(txtUsername.getText())).equals(txtPassword.getText())) {
                lblOutput.setText("Incorrect Password");
                btnLogIn.setText("Try Again"); 
                txtPassword.setText("");
                btnSignUp.setVisible(true);
           }
           //if password and username match
           else if(m1.findMember(strName) > -1 && m1.getPassword(m1.findMember(txtUsername.getText())).equals(txtPassword.getText())) {
                OptionsPage f1 = new OptionsPage(strName);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
                f1.setSize(500, 500 ); 
                f1.setVisible(true); 
                this.dispose();                
           } 
        }  
        
        //open sign up page
        if(e.getActionCommand().equals("Sign Up")) {
               SignUp f1 = new SignUp();
               f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
               f1.setSize(500, 500 ); 
               f1.setVisible(true); 
               this.dispose();
        }
        
        //open main page
        if(e.getActionCommand().equals("Back")) {
            MainPage f1 = new MainPage();
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose();
        }
    }
}

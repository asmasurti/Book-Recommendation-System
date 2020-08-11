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
import java.awt.Image;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon;
import javax.swing.ImageIcon; 
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author zsur
 */
public class User extends JFrame implements ActionListener {
    
    //Declare variables
    JLabel lblBackground, lblUsername, lblBooksRead, lblBooksUnread, lblOutput, lblInfo;
    JButton btnBack, btnLogOut, btnUsername, btnPassword, btnEnter;
    JTextField txtPassword, txtUsername;
    Member m1;
    Ratings r1;
    Books b1;   
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);
    ImageIcon pic = new ImageIcon("PlainBackground.jpg");  
    Color c1 = new Color(208, 204, 197);
    String strUser;
    
    public User(String str1) {
        super( "Testing JLabel" );
        setLayout(null);
        
        //label for the background with picture
        lblBackground = new JLabel();
        lblBackground.setSize(500, 500);
        lblBackground.setIcon(pic);
        add(lblBackground);
        
        //label for the username
        strUser = str1;
        lblUsername = new JLabel();
        lblUsername.setText(strUser);
        lblUsername.setFont(fBody);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setSize(200, 30);
        lblUsername.setLocation(20, 10);
        lblBackground.add(lblUsername);
        
        //buttn to change username
        btnUsername = new JButton();
        btnUsername.setText("Chnage Username");
        btnUsername.setSize(200, 30);
        btnUsername.setLocation(20, 80);
	btnUsername.setFont(fButton);
	btnUsername.setBackground(c1);
        lblBackground.add(btnUsername); 
        btnUsername.setActionCommand("Username");
        btnUsername.addActionListener(this);
        
        //text field for username
        txtUsername = new JTextField();
        txtUsername.setFont(fBody);
        txtUsername.setSize(200, 30);
        txtUsername.setLocation(20, 80);
        lblBackground.add(txtUsername);
        txtUsername.setVisible(false);
             
        //text field for password
        txtPassword = new JTextField();
        txtPassword.setFont(fBody);
        txtPassword.setSize(200, 30);
        txtPassword.setLocation(20, 80);
        lblBackground.add(txtPassword); 
        txtPassword.setVisible(false);
        
        //button to change password
        btnPassword = new JButton();
        btnPassword.setText("Change Password");
        btnPassword.setSize(200, 30);
        btnPassword.setLocation(20, 160);
	btnPassword.setFont(fButton);
	btnPassword.setBackground(c1);
        lblBackground.add(btnPassword); 
        btnPassword.setActionCommand("Password");
        btnPassword.addActionListener(this);     
        
        //button to enter
        btnEnter = new JButton();
        btnEnter.setText("Enter");
        btnEnter.setSize(200, 30);
        btnEnter.setLocation(20, 180);
	btnEnter.setFont(fButton);
	btnEnter.setBackground(c1);
        lblBackground.add(btnEnter); 
        btnEnter.addActionListener(this); 
        btnEnter.setVisible(false);
        
        //label for any ouput 
        lblOutput = new JLabel();
        lblOutput.setText("");
        lblOutput.setFont(fBody);
        lblOutput.setForeground(new Color(130, 16, 13));
        lblOutput.setSize(300, 30);
        lblOutput.setLocation(20, 130);
        lblBackground.add(lblOutput);
        
        b1 = new Books();
        r1 = new Ratings();
        m1 = new Member();
        int intReadBooks = r1.numberRead(m1.findMember(strUser));
        
        //label to display how many books the user has read
        lblInfo = new JLabel();
        lblInfo.setText("<html>You have read<br/>" + intReadBooks + " out of " + b1.numberBooks() + 
                        " books...<br/>" + (b1.numberBooks() - intReadBooks)  + " more to go<html>");
        lblInfo.setFont(fBody);
        lblInfo.setForeground(Color.WHITE);
        lblInfo.setSize(400, 200);
        lblInfo.setLocation(20, 200);
        lblBackground.add(lblInfo);
        
        //button to go back
        btnBack = new JButton();
        btnBack.setText("Back");
        btnBack.setSize(100, 30);
        btnBack.setLocation(210, 10);
	btnBack.setFont(fButton);
	btnBack.setBackground(c1);
        lblBackground.add(btnBack); 
        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);    

        //button to log out
	btnLogOut = new JButton();
        btnLogOut.setText("Log Out");
        btnLogOut.setSize(100, 30);
        btnLogOut.setLocation(330, 10);
        btnLogOut.setFont(fButton);
        btnLogOut.setBackground(c1);
        lblBackground.add(btnLogOut);
        btnLogOut.setActionCommand("Log Out");
        btnLogOut.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e) {
        //open options page
        if(e.getActionCommand().equals("Back")) {
            OptionsPage f1 = new OptionsPage(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open main page
	if(e.getActionCommand().equals("Log Out")) {
            MainPage f1 = new MainPage();
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose();   
        } 
        //display information for changing username
        if(e.getActionCommand().equals("Username")) {
            btnPassword.setVisible(false);
            btnUsername.setVisible(false);
            txtUsername.setVisible(true);
            lblInfo.setVisible(false);
            btnEnter.setVisible(true);
            btnEnter.setActionCommand("Enter Username");
        }
        //display information for changing password
        if(e.getActionCommand().equals("Password")) {
            btnPassword.setVisible(false);
            btnUsername.setVisible(false);
            txtPassword.setVisible(true);
            lblInfo.setVisible(false);
            btnEnter.setVisible(true);
            btnEnter.setActionCommand("Enter Password");
        }
        if(e.getActionCommand().equals("Enter Username")) {
            m1 = new Member();        
            
            //if no input entered
            if(txtUsername.getText().equals("")){
                lblOutput.setText("Enter a username");
                txtUsername.setText("");
            }
            //if input is the same the current name
            else if(txtUsername.getText().equals(strUser)){
               lblOutput.setText("Input is same as current username");
               txtUsername.setText("");
            }          
            //if entered username is already taken
            else if(m1.findMember(txtUsername.getText()) > -1) {    
                lblOutput.setText("Username already exisits");
                txtUsername.setText("");
            }
            else {
                //change username
                lblOutput.setText("Username successfully changed");
                lblOutput.setForeground(Color.WHITE);
                m1.changeUsername(strUser, txtUsername.getText());
                btnEnter.setText("Back to Profile");
                btnEnter.setActionCommand("Profile");
                strUser = txtUsername.getText();
                txtUsername.setText("");
            }
        }     
        if(e.getActionCommand().equals("Enter Password")) {
            m1 = new Member();
            
            //if no input entered
            if(txtPassword.getText().equals("")){
                lblOutput.setText("Enter a password");
                txtPassword.setText("");
            }
            //if the input entered is the same as current password
            else if (m1.getPassword(m1.findMember(strUser)).equals(txtPassword.getText())) {
                lblOutput.setText("Input is same as current password");
                txtPassword.setText("");
            }
            else {
                //change password
                m1.changePassword(m1.findMember(strUser), txtPassword.getText());
                lblOutput.setText("Password successfully changed");
                lblOutput.setForeground(Color.WHITE);
                btnEnter.setText("Back to Profile");
                btnEnter.setActionCommand("Profile");
                txtPassword.setText("");
            }
        } 
        //open profile page
        if(e.getActionCommand().equals("Profile")) {
            User f1 = new User(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        } 
    }    
}

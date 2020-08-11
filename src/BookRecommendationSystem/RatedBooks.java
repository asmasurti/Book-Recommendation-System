/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookRecommendationSystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
public class RatedBooks extends JFrame implements ActionListener{
    
    //Declare variables
    JLabel lblRating, lblBackground, lblUsername, lblTitle;
    JButton btnBack, btnSelect, btnLogOut;
    String strUser;   
    Font fBody = new Font("High Tower Text", Font.PLAIN, 16);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15); 
    ImageIcon pic = new ImageIcon("PlainLargeBackground.jpg");
    Color c1 = new Color(208, 204, 197);
    Choice ratings;
    Member m1;
    Ratings r1;
    Books b1;
    
    public RatedBooks(String str1) {
        super( "Testing JLabel" );
        setLayout(null);
        
        //label for background with picture 
        lblBackground = new JLabel();
        lblBackground.setSize(500, 650);
        lblBackground.setIcon(pic);
        add(lblBackground);
        
        //label for username 
        strUser = str1;
        lblUsername = new JLabel();
        lblUsername.setText(strUser);
        lblUsername.setFont(fBody);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setSize(200, 30);
        lblUsername.setLocation(20, 10);
        lblBackground.add(lblUsername);
        
        r1 = new Ratings();
        m1 = new Member();
        
        //if the user has not read any books
        if(r1.emptyRatings(m1.findMember(strUser))) {
            //display output 
            lblTitle = new JLabel();
            lblTitle.setSize(400, 30);
            lblTitle.setText("You have not rated any books");
            lblTitle.setLocation(20, 80);;
            lblTitle.setFont(fBody);
            lblTitle.setForeground(Color.WHITE);
            lblBackground.add(lblTitle);
            
            //button to rate books
            btnSelect = new JButton();
            btnSelect.setText("Rate Books");
            btnSelect.setSize(150, 30);
            btnSelect.setLocation(250, 80);
            btnSelect.setFont(fButton);
            btnSelect.setBackground(c1);
            lblBackground.add(btnSelect); 
            btnSelect.setActionCommand("Rate");
            btnSelect.addActionListener(this);
        }
        else {
            //create new drop down with all of the rating options
            ratings = new Choice();
            ratings.add("-5");
            ratings.add("-3");
            ratings.add("1");
            ratings.add("3");
            ratings.add("5");
            ratings.setFont(fBody);
            ratings.setSize(100, 50);
            ratings.setLocation(20, 80);
            lblBackground.add(ratings); 

            //button to select
            btnSelect = new JButton();
            btnSelect.setText("Select");
            btnSelect.setSize(100, 30);
            btnSelect.setLocation(330, 80);
            btnSelect.setFont(fButton);
            btnSelect.setBackground(c1);
            lblBackground.add(btnSelect); 
            btnSelect.setActionCommand("Select");
            btnSelect.addActionListener(this);
            
            //label for the rating selected 
            lblRating = new JLabel();
            lblRating.setLocation(20, 100);
            lblRating.setSize(400, 50);
            lblRating.setFont(fBody);
            lblRating.setForeground(Color.WHITE);
            lblBackground.add(lblRating);
            
            //label to display the list of titles 
            lblTitle = new JLabel();
            lblTitle.setSize(500, 500);
            lblTitle.setLocation(20, 140);
            lblTitle.setVerticalAlignment(SwingConstants.TOP);
            lblTitle.setFont(fBody);
            lblTitle.setForeground(Color.WHITE);
            lblBackground.add(lblTitle);
            lblTitle.setVisible(false);
        }
        
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
            f1.setSize(500, 500); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open rate page
        if(e.getActionCommand().equals("Rate")) {
            RateBooks f1 = new RateBooks(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        if(e.getActionCommand().equals("Select")) {
            m1 = new Member(); 
            b1 = new Books();
            int intX = m1.findMember(strUser);
            int intY = 130;     
            Ratings r1 = new Ratings();
            int[] arrRatings = r1.returnRatings(intX);
            
            //display the rating selected 
	    lblRating.setText("List of books that you rated " + ratings.getSelectedItem());
            String str = "<html>";
            
            //concatenate a string with all of the titles given the rating selected 
            for(int intI = 0; intI < arrRatings.length; intI++) {
                if (arrRatings[intI] == Integer.parseInt(ratings.getSelectedItem())) {
                    str = str + (b1.getTitle(intI)) + "<br/>";                  
                }
            }          
            str = str + "<html>";
            //display the titles 
            lblTitle.setText(str);
            lblTitle.setVisible(true);
        }
        //open main page
	if(e.getActionCommand().equals("Log Out")) {
            MainPage f1 = new MainPage();
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose();   
        }  
    }
}
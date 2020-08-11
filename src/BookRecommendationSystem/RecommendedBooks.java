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
import java.util.ArrayList;
/**
 *
 * @author Surti
 */
public class RecommendedBooks extends JFrame implements ActionListener {
    
    //Declare variables 
    String strUser;
    JLabel lblOutput, lblBackground, lblUsername, lblTop;
    JButton btnBack, btnLogOut;
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);
    ImageIcon pic = new ImageIcon("PlainBackground.jpg");
    Color c1 = new Color(208, 204, 197);
    
    public RecommendedBooks(String str1) {
        super( "Testing JLabel" );
        setLayout(null);
       
        //label for background with picture 
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
	
        Ratings r1 = new Ratings();
        Member m1 = new Member();
        
        //if the user has read all of the books
        if(r1.completeRatings(m1.findMember(strUser))) {
            lblOutput = new JLabel();
            lblOutput.setText("You have read all of the books!");
            lblOutput.setSize(400, 30);
            lblOutput.setLocation(20, 100);
            lblOutput.setFont(fBody);
            lblOutput.setForeground(Color.WHITE);
            lblBackground.add(lblOutput);
        }
        else {
            lblTop = new JLabel();
            lblTop.setText("Here is a list of five recommended books:");
            lblTop.setFont(fBody);
            lblTop.setForeground(Color.WHITE);
            lblTop.setSize(400, 30);
            lblTop.setLocation(20, 50);
            lblBackground.add(lblTop);

            ArrayList<Integer> arrDotProducts = r1.dotProducts(str1);
            int[] arrTopThree = r1.getTopThree(arrDotProducts);
            ArrayList<String> arrRecommendedBooks = r1.recommendedBooks(arrTopThree);
            int intY = 100;
            
            //if the length of array is bigger than 5, display top five books
            if(arrRecommendedBooks.size() >= 5) {
                for(int intI = 0; intI < 5; intI++) {
                    lblOutput = new JLabel();
                    lblOutput.setText(Integer.toString(intI + 1) + ") " +  arrRecommendedBooks.get(intI));
                    lblOutput.setSize(500, 30);
                    lblOutput.setLocation(20, intY);
                    lblOutput.setFont(fBody);
                    lblOutput.setForeground(Color.WHITE);
                    lblBackground.add(lblOutput);
                    intY += 50;
                } 
            }
            else {
                ArrayList<String> generalRecommended = r1.generalRecommended();
                //display all the books in the recommended array
                for(int intI = 0; intI < arrRecommendedBooks.size(); intI++) {
                    lblOutput = new JLabel();
                    lblOutput.setText(Integer.toString(intI + 1) + ") " + arrRecommendedBooks.get(intI));
                    lblOutput.setSize(500, 30);
                    lblOutput.setLocation(20, intY);
                    lblOutput.setFont(fBody);
                    lblOutput.setForeground(Color.WHITE);
                    lblBackground.add(lblOutput);
                    intY += 50;
                }     
                //display general recommended books for the rest
                for(int intI = 0; intI < (5 - arrRecommendedBooks.size()); intI++) {
                    lblOutput = new JLabel();
                    lblOutput.setText(Integer.toString(intI + 1) + ") " + generalRecommended.get(intI));
                    lblOutput.setSize(500, 30);
                    lblOutput.setLocation(20, intY);
                    lblOutput.setFont(fBody);
                    lblOutput.setForeground(Color.WHITE);
                    lblBackground.add(lblOutput);
                    intY += 50;
                }
            }
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
        //open the options page
        if(e.getActionCommand().equals("Back")) {
            OptionsPage f1 = new OptionsPage(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open the main page
	if(e.getActionCommand().equals("Log Out")) {
            MainPage f1 = new MainPage();
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose();   
        }
    }   
}

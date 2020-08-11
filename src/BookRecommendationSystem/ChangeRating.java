/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookRecommendationSystem;

import javax.swing.JFrame;
import java.awt.FlowLayout; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon;
import javax.swing.ImageIcon; 
import javax.swing.*;
import java.awt.event.*;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Surti
 */
public class ChangeRating extends JFrame implements ActionListener{
    
    //Declare variables 
    String strUser, strTitle;
    JLabel lblOutput, lblUsername, lblBackground, lblChoice, lblFace;
    JButton btnSelect, btnEnter, btnBack, btnLogOut, btnChange;
    ButtonGroup btnRateChoice;
    JRadioButton s1, s2, s3, s4, s5;
    int intRating, intOriginalRating, intMemberIndex;    
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);
    ImageIcon pic = new ImageIcon("PlainBackground.jpg");
    ImageIcon face;	
    Color c1 = new Color(208, 204, 197);
    Choice Options;  
    Member m1;
    Books b1;
    Ratings r1;
    int[] arrRatings;
  
    public ChangeRating(String str1) {
        super( "Testing JLabel" );
        setLayout(null);
        
        //label for background with picture 
        lblBackground = new JLabel();
        lblBackground.setSize(500, 500);
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

        m1 = new Member();
        b1 = new Books();
        r1 = new Ratings();  
        intMemberIndex = m1.findMember(strUser);
        arrRatings = r1.returnRatings(intMemberIndex);
        
        //create a mew drop down with all of the books that the user has already rated 
        Options = new Choice();
        for(int intI = 0; intI < arrRatings.length; intI++) {
            if(arrRatings[intI] != 0) {
                Options.add(b1.getTitle(intI));
            }
        } 
	Options.setFont(fBody);
        Options.setSize(400, 50);
        Options.setLocation(20, 80);
        lblBackground.add(Options); 
        
        //button to select
        btnSelect = new JButton();
        btnSelect.setText("Select");
        btnSelect.setSize(100, 30);
        btnSelect.setLocation(20, 120);
	btnSelect.setFont(fButton);
	btnSelect.setBackground(c1);
        lblBackground.add(btnSelect); 
        btnSelect.setActionCommand("Select");
        btnSelect.addActionListener(this);
	
        //button to change selection
	btnChange = new JButton();
        btnChange.setText("Change the Selection");
        btnChange.setSize(200, 30);
        btnChange.setLocation(150, 150);
	btnChange.setFont(fButton);
	btnChange.setBackground(c1);
        lblBackground.add(btnChange); 
        btnChange.setVisible(false);
        btnChange.setActionCommand("Change");
        btnChange.addActionListener(this);
        
        //button to enter
        btnEnter = new JButton();
        btnEnter.setText("Enter");
        btnEnter.setSize(100, 30);
        btnEnter.setLocation(260, 340);
	btnEnter.setFont(fButton);
	btnEnter.setBackground(c1);
        lblBackground.add(btnEnter); 
        btnEnter.setVisible(false);
        btnEnter.setActionCommand("Enter");
        btnEnter.addActionListener(this);
        
        //series of five radio buttons
        s1 = new JRadioButton("-5", false);
        s1.setSize(50, 50);
        s1.setLocation(120, 220);
	s1.setFont(fButton);
	s1.setBackground(c1);
        lblBackground.add(s1); 
        s1.setVisible(false);
	s1.setActionCommand("Very Unhappy");
        s1.addActionListener(this);    
        
        s2 = new JRadioButton("-3", false);
        s2.setSize(50, 50);
        s2.setLocation(170, 220);
	s2.setFont(fButton);
	s2.setBackground(c1);
        lblBackground.add(s2); 
        s2.setVisible(false);
	s2.setActionCommand("Unhappy");
        s2.addActionListener(this);    
        
        s3 = new JRadioButton("1", false);
        s3.setSize(50, 50);
        s3.setLocation(220, 220);
	s3.setFont(fButton);
	s3.setBackground(c1);
        lblBackground.add(s3); 
        s3.setVisible(false);
	s3.setActionCommand("Moderate");
        s3.addActionListener(this);    
        
        s4 = new JRadioButton("3", false);
        s4.setSize(50, 50);
        s4.setLocation(270, 220);
	s4.setFont(fButton);
	s4.setBackground(c1);
        lblBackground.add(s4); 
        s4.setVisible(false);
	s4.setActionCommand("Happy");
        s4.addActionListener(this);    
        
        s5 = new JRadioButton("5", false);
        s5.setSize(50, 50);
        s5.setLocation(320, 220);
	s5.setFont(fButton);
	s5.setBackground(c1);
        lblBackground.add(s5); 
        s5.setVisible(false);
	s5.setActionCommand("Very Happy");
        s5.addActionListener(this);    
        
        //adding the radio buttons to a button group
        btnRateChoice = new ButtonGroup();
        btnRateChoice.add(s1);
        btnRateChoice.add(s2);
        btnRateChoice.add(s3);
        btnRateChoice.add(s4);
        btnRateChoice.add(s5);
        
        //label to display any output 
        lblOutput = new JLabel();
        lblOutput.setSize(400, 30);
	lblOutput.setFont(fBody);
        lblBackground.add(lblOutput);
        lblOutput.setVisible(false);
        
        //label to display selected book
	lblChoice = new JLabel();
	lblChoice.setSize(500, 100);
	lblChoice.setLocation(0, 50);
        lblChoice.setHorizontalAlignment(SwingConstants.CENTER);
	lblChoice.setFont(fBody);
	lblChoice.setForeground(Color.WHITE);
	lblBackground.add(lblChoice);
	lblChoice.setVisible(false);
        
        //label to display face associated with rating 
	lblFace = new JLabel();
	lblFace.setSize(100, 100);
	lblFace.setLocation(130, 300);
	lblBackground.add(lblFace);
        
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
        //set up display
        if(e.getActionCommand().equals("Select")) {
            m1 = new Member();
            r1 = new Ratings();
            b1 = new Books();
            strTitle = Options.getSelectedItem();
            arrRatings = r1.returnRatings(m1.findMember(strUser));
            intOriginalRating = arrRatings[b1.findTitle(strTitle)];
            lblChoice.setText("<html><div style='text-align: center;'>The selected book is<br/>" + strTitle + "<br/>"
                              + "You gave it a rating of " + intOriginalRating + "<html>");
 	    lblChoice.setVisible(true);
	    btnChange.setVisible(true);
	    
            Options.setVisible(false);
	    btnSelect.setVisible(false);
	    s1.setVisible(true);
            s2.setVisible(true);
            s3.setVisible(true);
            s4.setVisible(true);
            s5.setVisible(true);
            btnEnter.setVisible(true);
        }
        if(e.getActionCommand().equals("Enter")) {
            //determine the rating selected 
            if(s1.isSelected() || s2.isSelected() || s3.isSelected() || s4.isSelected() || s5.isSelected()) {
                lblOutput.setVisible(false);
                if(s1.isSelected())
                    intRating = -5;
                else if(s2.isSelected())
                    intRating = -3;
                else if(s3.isSelected())
                    intRating = 1;
                else if(s4.isSelected())
                    intRating = 3;
                else if(s5.isSelected())
                    intRating = 5;           
                
                //update the ratings 
                int intBookIndex = b1.findTitle(strTitle);
                for(int intI = 0; intI < arrRatings.length; intI++) {
                    if(intI == intBookIndex) {
                        arrRatings[intI] = intRating;
                    }
                }
                r1.updateRatings(arrRatings, strUser);
		
                //if the current and new rating are the same, invalid input 
                if(intRating == intOriginalRating) {
                    lblOutput.setText("Selected rating same as current rating");
                    lblOutput.setLocation(90, 430);
                    lblOutput.setForeground(new Color(130, 16, 13));
                    lblOutput.setVisible(true);
                    btnRateChoice.clearSelection();
                }
                else {
                //update the screen
		btnEnter.setVisible(false);
		lblChoice.setVisible(false);
		s1.setVisible(false);
            	s2.setVisible(false);
            	s3.setVisible(false);
            	s4.setVisible(false);
            	s5.setVisible(false);
                lblFace.setVisible(false);
		
                //rate another book
                btnChange.setSize(200, 30);
		btnChange.setLocation(150, 250);
		btnChange.setText("Change Another Rating");
                
                //display output for successfully rating a book
                lblOutput.setForeground(Color.WHITE);
                lblOutput.setSize(500, 150);
                lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setText("<html><div style='text-align: center;'>You gave<br/> " + strTitle + "<br/>a rating of " + intRating);
		lblOutput.setLocation(0, 100);
                lblOutput.setFont(fBody);
		lblOutput.setVisible(true);
                }
            }
            //otherwise no rating is selected 
            else {
                lblOutput.setText("Please select a rating");
                lblOutput.setForeground(new Color(130, 16, 13));
                lblOutput.setLocation(150, 430);
                lblOutput.setVisible(true);
            }   
        }
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
        //open change ratings again
	if(e.getActionCommand().equals("Change")) {
            ChangeRating f1 = new ChangeRating(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose();   
        } 
        //set the face picture based on the radio button clicked 
	if(e.getActionCommand().equals("Very Unhappy")) {
            face = new ImageIcon("VeryUnhappy.jpg");
	    lblFace.setIcon(face);   
        } 
	if(e.getActionCommand().equals("Unhappy")) {
            face = new ImageIcon("Unhappy.jpg");
	    lblFace.setIcon(face);   
        } 
	if(e.getActionCommand().equals("Moderate")) {
   	    face = new ImageIcon("Moderate.jpg");
	    lblFace.setIcon(face); 
        } 
	if(e.getActionCommand().equals("Happy")) {
 	    face = new ImageIcon("Happy.jpg");
	    lblFace.setIcon(face); 
        }  
	if(e.getActionCommand().equals("Very Happy")) {
            face = new ImageIcon("VeryHappy.jpg");
	    lblFace.setIcon(face);   
        }  
    } 
}

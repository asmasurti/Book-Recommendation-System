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
public class NewBook extends JFrame implements ActionListener{
    
    //Declare variables
    String strUser;
    JLabel lblTitle, lblAuthor, lblISBN, lblYear, lblOutput, lblBackground, lblUsername;
    JTextField txtTitle, txtAuthor, txtISBN, txtYear;
    JButton btnBack, btnEnter, btnLogOut;   
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);  
    ImageIcon pic = new ImageIcon("PlainBackground.jpg");
    Color c1 = new Color(208, 204, 197);
    Books b1;
    
    public NewBook(String str1) {
        super( "Testing JLabel" );
        setLayout(null);
       
        //label for background with picture
	lblBackground = new JLabel();
        lblBackground.setSize(500, 500);
        lblBackground.setIcon(pic);
        add(lblBackground);
        
        //label with username
	strUser = str1;
        lblUsername = new JLabel();
        lblUsername.setText(strUser);
        lblUsername.setFont(fBody);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setSize(200, 30);
        lblUsername.setLocation(20, 10);
        lblBackground.add(lblUsername);
        
        //text field for book title 
        txtTitle = new JTextField();
	txtTitle.setFont(fBody);
        txtTitle.setSize(200, 30);
        txtTitle.setLocation(210, 80);
        lblBackground.add(txtTitle);
        
        //text field for ISBN number 
        txtISBN = new JTextField();
	txtISBN.setFont(fBody);
        txtISBN.setSize(200, 30);
        txtISBN.setLocation(210, 240);
        lblBackground.add(txtISBN);
        
        //text field for author
        txtAuthor = new JTextField();
	txtAuthor.setFont(fBody);
        txtAuthor.setSize(200, 30);
        txtAuthor.setLocation(210, 160);
        lblBackground.add(txtAuthor);
        
        //text field for year
        txtYear = new JTextField();
        txtYear.setFont(fBody);
	txtYear.setSize(200, 30);
        txtYear.setLocation(210, 320);
        lblBackground.add(txtYear);
        
        //label for title 
        lblTitle = new JLabel();
        lblTitle.setText("Title");
        lblTitle.setSize(200, 30);
        lblTitle.setLocation(20, 80);
	lblTitle.setFont(fBody);
	lblTitle.setForeground(Color.WHITE);
        lblBackground.add(lblTitle);
        
        //label for author
        lblAuthor = new JLabel();
        lblAuthor.setText("Author");
        lblAuthor.setSize(200, 30);
        lblAuthor.setLocation(20, 160);
        lblAuthor.setFont(fBody);
	lblAuthor.setForeground(Color.WHITE);
	lblBackground.add(lblAuthor);
        
        //label for ISBN
        lblISBN = new JLabel();
        lblISBN.setText("<html>ISBN Number<br/>(13 digits)<html>");
        lblISBN.setSize(200, 50);
        lblISBN.setLocation(20, 235);
	lblISBN.setFont(fBody);
	lblISBN.setForeground(Color.WHITE);
        lblBackground.add(lblISBN);
        
        //label for year
        lblYear = new JLabel();
        lblYear.setText("Year of Publication");
        lblYear.setSize(200, 30);
        lblYear.setLocation(20, 320);
	lblYear.setFont(fBody);
	lblYear.setForeground(Color.WHITE);
        lblBackground.add(lblYear);
        
        //label for any possible outputs 
        lblOutput = new JLabel();
        lblOutput.setText("");
        lblOutput.setSize(350, 30);
        lblOutput.setLocation(20, 400);
	lblOutput.setFont(fBody);
        lblBackground.add(lblOutput);
        
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
        
        //button to enter information
        btnEnter = new JButton();
        btnEnter.setText("Enter");
        btnEnter.setSize(100, 30);
        btnEnter.setLocation(330, 400);
	btnEnter.setFont(fButton);
	btnEnter.setBackground(c1);
        lblBackground.add(btnEnter); 
        btnEnter.setActionCommand("Enter");
        btnEnter.addActionListener(this);

        //log out button
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
        if(e.getActionCommand().equals("Enter")) {
            Books b1 = new Books();
            String strDigits = "1234567890";
            Boolean isInvalid = false;
            
            //determine whether the ISBN or Year contains letters
            for(int intI = 0; intI < txtISBN.getText().length(); intI++) {
                if(strDigits.indexOf(txtISBN.getText().charAt(intI)) == -1)
                    isInvalid = true;
            }           
            for(int intI = 0; intI < txtYear.getText().length(); intI++) {
                if(strDigits.indexOf(txtYear.getText().charAt(intI)) == -1)
                    isInvalid = true;
            }
           
            //if any of the text fields are blank, the input is invalid
            if(txtTitle.getText().equals("") || txtAuthor.getText().equals("") ||
               txtISBN.getText().equals("") || txtYear.getText().equals("")) {
                lblOutput.setText("Please fill all of the required fields");
                lblOutput.setForeground(new Color(130, 16, 13));
            }
            //if the length of ISBN and year isn't correct, the input is invalid 
            else if(txtISBN.getText().length() != 13 || txtYear.getText().length() != 4 || isInvalid) {
                lblOutput.setText("Invalid input");
                lblOutput.setForeground(new Color(130, 16, 13));
            }
            else {
                lblOutput.setVisible(false);
                //format the string inputs
                String strTitle = capitalizeString(txtTitle.getText().toLowerCase().trim());
                String strAuthor = capitalizeString(txtAuthor.getText().toLowerCase().trim());
                
                //invalid if ISBN number already exists 
                if(b1.findISBN(txtISBN.getText()) > -1) {
                    lblOutput.setText("The ISBN number aleady exists");
                    lblOutput.setForeground(new Color(130, 16, 13));
                    lblOutput.setVisible(true);
                }   
                //invalid if the title from the same author already exists 
                else if(b1.findTitle(strTitle) > -1) {
                    if(b1.findAuthor(strAuthor) > -1) {
                        lblOutput.setText("The title aleady exists");
                        lblOutput.setForeground(new Color(130, 16, 13));
                        lblOutput.setVisible(true);
                    }
                }
                //add book 
                else {
                    String strNewBook = strAuthor + "," + strTitle;
                    String strNewInfo = txtISBN.getText() + "," + txtYear.getText();
                    b1 = new Books();
                    b1.addBooks(strNewBook);
                    b1.addInfo(strNewInfo);
                    lblOutput.setForeground(Color.WHITE);
                    lblOutput.setLocation(10, 400);
                    lblOutput.setText("The book has been successfully added");
                    lblOutput.setVisible(true);
                }
            }
            //reset textfields 
            txtTitle.setText("");
            txtAuthor.setText("");
            txtISBN.setText("");
            txtYear.setText("");
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
    
    
    /**
     * 
     * @param str1 is a string 
     * @return a string with the first letter of every word capitalized 
     */
    public String capitalizeString(String str1) {
        String strReturn = ""; 
        str1 = Character.toUpperCase(str1.charAt(0)) + str1.substring(1);
        
        //capitalize the first letter of every word in the string 
        for (int intI = 0; intI < str1.length(); intI++) {
            if (str1.charAt(intI) == ' ') {
                if (intI + 1 < str1.length()) {
                    strReturn = strReturn + " " + Character.toUpperCase(str1.charAt(intI + 1));
                }
                intI++;
            } else {
                strReturn = strReturn + str1.charAt(intI);
            }
        }
        return strReturn;
    }
}

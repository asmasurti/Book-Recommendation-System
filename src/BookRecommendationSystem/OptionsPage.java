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
 * @author Surti
 */
public class OptionsPage extends JFrame implements ActionListener{
    
    //Declare variables
    JButton btnAddBook, btnRecommended, btnRate, btnRated, btnLogOut, btnUser, btnChangeRating;
    JLabel lblBackground, lblThumbs, lblBook, lblRated, lblRecommended;
    String strUser;    
    Font fHeader = new Font("Copperplate Gothic Light", Font.PLAIN, 25);
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);   
    ImageIcon pic = new ImageIcon("PlainBackground.jpg");
    ImageIcon thumbs = new ImageIcon("thumbs.jpg");
    ImageIcon addBook = new ImageIcon("addBook.png");
    ImageIcon rated = new ImageIcon("rate.png");
    ImageIcon recommended = new ImageIcon("recommended.png");
    Color c1 = new Color(208, 204, 197);
    
    public OptionsPage(String str1) {
        super( "Testing JLabel" );
        setLayout(null);
        
        //label for background with picture 
        lblBackground = new JLabel();
        lblBackground.setSize(500, 500);
        lblBackground.setIcon(pic);
        add(lblBackground);
        
        //button for user profile 
        strUser = str1;
        btnUser = new JButton();
        btnUser.setText(strUser);
        btnUser.setFont(fButton);
        btnUser.setBackground(c1);
        btnUser.setSize(200, 30);
        btnUser.setLocation(20, 10);
        lblBackground.add(btnUser);
        btnUser.setActionCommand("User");
        btnUser.addActionListener(this);
        
        //button for adding a book
        btnAddBook = new JButton();
        btnAddBook.setText("Add a Book");
        btnAddBook.setSize(200, 30);
        btnAddBook.setLocation(20, 80);
        btnAddBook.setFont(fButton);
        btnAddBook.setBackground(c1);
        lblBackground.add(btnAddBook); 
        btnAddBook.setActionCommand("Add Book");
        btnAddBook.addActionListener(this);
        
        //Label for addding a book with picture
        lblBook = new JLabel();
        lblBook.setSize(200, 100);
        lblBook.setLocation(20, 130);
        lblBook.setIcon(addBook);
        lblBackground.add(lblBook);
        
        //button for viewing recommended books
        btnRecommended = new JButton();
        btnRecommended.setText("Recommended Books");
        btnRecommended.setSize(200, 30);
        btnRecommended.setLocation(250, 80);
        btnRecommended.setFont(fButton);
        btnRecommended.setBackground(c1);
        lblBackground.add(btnRecommended);
        btnRecommended.setActionCommand("Recommended");
        btnRecommended.addActionListener(this);
        
        //label for recommended books with picture 
        lblRecommended = new JLabel();
        lblRecommended.setSize(200, 100);
        lblRecommended.setLocation(250, 130);
        lblRecommended.setIcon(recommended);
        lblBackground.add(lblRecommended);
        
        //button for rating the books
        btnRate = new JButton();
        btnRate.setText("Rate a Book");
        btnRate.setSize(200, 30);
        btnRate.setLocation(20, 250);
        btnRate.setFont(fButton);
        btnRate.setBackground(c1);
        lblBackground.add(btnRate);
        btnRate.setActionCommand("Rate");
        btnRate.addActionListener(this);
        
        //label for rating the books with picture 
        lblThumbs = new JLabel();
        lblThumbs.setSize(200, 100);
        lblThumbs.setLocation(20, 300);
        lblThumbs.setIcon(thumbs);
        lblBackground.add(lblThumbs);
        
        //button for viewing rated books 
        btnRated = new JButton();
        btnRated.setText("See Rated Books");
        btnRated.setSize(200, 30);
        btnRated.setLocation(250, 250);
        btnRated.setFont(fButton);
        btnRated.setBackground(c1);
        lblBackground.add(btnRated);
        btnRated.setActionCommand("Rated");
        btnRated.addActionListener(this);
        
        //label for rated books with picture 
        lblRated = new JLabel();
        lblRated.setSize(200, 100);
        lblRated.setLocation(250, 300);
        lblRated.setIcon(rated);
        lblBackground.add(lblRated);
        
        //button for changing ratings 
        btnChangeRating = new JButton();
        btnChangeRating.setText("Change a rating");
        btnChangeRating.setSize(200, 30);
        btnChangeRating.setLocation(130, 420);
        btnChangeRating.setFont(fButton);
        btnChangeRating.setBackground(c1);
        lblBackground.add(btnChangeRating);
        btnChangeRating.setActionCommand("Change rating");
        btnChangeRating.addActionListener(this);
        
        //Log out button
        btnLogOut = new JButton();
        btnLogOut.setText("Log Out");
        btnLogOut.setSize(200, 30);
        btnLogOut.setLocation(250, 10);
        btnLogOut.setFont(fButton);
        btnLogOut.setBackground(c1);
        lblBackground.add(btnLogOut);
        btnLogOut.setActionCommand("Log Out");
        btnLogOut.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e) {
        //open main page (logout)
        if(e.getActionCommand().equals("Log Out")) {
            MainPage f1 = new MainPage();
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose();   
        }
        //open page for viewing rated books
        if(e.getActionCommand().equals("Rated")) {
            RatedBooks f1 = new RatedBooks(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 650); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open page for rating books
        if(e.getActionCommand().equals("Rate")) {
            RateBooks f1 = new RateBooks(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open page for adding books
        if(e.getActionCommand().equals("Add Book")) {
            NewBook f1 = new NewBook(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open page for viewing recommended books
        if(e.getActionCommand().equals("Recommended")) {
            RecommendedBooks f1 = new RecommendedBooks(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open page with user profile
        if(e.getActionCommand().equals("User")) {
            User f1 = new User(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
        //open change rating page
        if(e.getActionCommand().equals("Change rating")) {
            ChangeRating f1 = new ChangeRating(strUser);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(500, 500 ); 
            f1.setVisible(true); 
            this.dispose(); 
        }
    }
}

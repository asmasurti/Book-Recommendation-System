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
 * @author Surti
 */
public class AdminPage extends JFrame implements ActionListener {
    
    //Declare variables
    JLabel lblBackground, lblUser, lblOutput, lblPassword;
    JButton btnDeleteUser, btnChangePassword, btnDeleteBook, btnEnter, btnLogOut, btnBack;
    JTextField txtPassword;
    String strUser;
    Member m1;
    Ratings r1;
    Books b1;
    Choice users, books;
    Font fBody = new Font("High Tower Text", Font.PLAIN, 20);
    Font fButton = new Font("High Tower Text", Font.PLAIN, 15);
    Color c1 = new Color(208, 204, 197);
    ImageIcon pic = new ImageIcon("PlainBackground.jpg");
    
    public AdminPage(String str1) {
        super( "Testing JLabel" );
        setLayout(null);
        
        //label for background with picture 
        lblBackground = new JLabel();
        lblBackground.setSize(500, 500);
        lblBackground.setIcon(pic);
        add(lblBackground);
        
        //label for username 
        strUser = str1;
        lblUser = new JLabel();
        lblUser.setText(strUser);
        lblUser.setFont(fBody);
        lblUser.setForeground(Color.WHITE);
        lblUser.setSize(100, 30);
        lblUser.setLocation(20, 10);
        lblBackground.add(lblUser);
        
        //create new drop down with complete list of memebers 
        m1 = new Member();
        ArrayList<String> arrMembers = m1.returnListMembers();
        users = new Choice();
        for(int intI = 0; intI < arrMembers.size(); intI++) {
            users.add(arrMembers.get(intI));
        } 
	users.setFont(fBody);
        users.setSize(400, 50);
        users.setLocation(20, 80);
        lblBackground.add(users);
        users.setVisible(false);
        
        //create new drop down with complete list of books
        b1 = new Books();
        ArrayList<String> arrBooks = b1.returnListBooks();        
        books = new Choice();
        for(int intI = 0; intI < arrBooks.size(); intI++) {
            books.add(arrBooks.get(intI));
        } 
	books.setFont(fBody);
        books.setSize(400, 50);
        books.setLocation(20, 80);
        lblBackground.add(books);
        books.setVisible(false);
        
        //label to display any output 
        lblOutput = new JLabel();
        lblOutput.setText("");
        lblOutput.setFont(fBody);
        lblOutput.setForeground(new Color(130, 16, 13));
        lblOutput.setSize(300, 30);
        lblOutput.setLocation(20, 130);
        lblBackground.add(lblOutput);
        
        //label for password 
        lblPassword = new JLabel();
        lblPassword.setText("Enter new password");
        lblPassword.setFont(fBody);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setSize(300, 30);
        lblPassword.setLocation(20, 130);
        lblBackground.add(lblPassword); 
        lblPassword.setVisible(false);
        
        //text field for password 
        txtPassword = new JTextField();
        txtPassword.setFont(fBody);
        txtPassword.setSize(200, 30);
        txtPassword.setLocation(200, 130);
        lblBackground.add(txtPassword); 
        txtPassword.setVisible(false);
        
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
        
        //button to delete a user 
        btnDeleteUser = new JButton();
        btnDeleteUser.setText("Delete User");
        btnDeleteUser.setSize(200, 30);
        btnDeleteUser.setLocation(20, 80);
        btnDeleteUser.setFont(fButton);
        btnDeleteUser.setBackground(c1);
        lblBackground.add(btnDeleteUser); 
        btnDeleteUser.setActionCommand("Delete User");
        btnDeleteUser.addActionListener(this);
        
        //button to delete a book
        btnDeleteBook = new JButton();
        btnDeleteBook.setText("Delete Book");
        btnDeleteBook.setSize(200, 30);
        btnDeleteBook.setLocation(20, 220);
        btnDeleteBook.setFont(fButton);
        btnDeleteBook.setBackground(c1);
        lblBackground.add(btnDeleteBook); 
        btnDeleteBook.setActionCommand("Delete Book");
        btnDeleteBook.addActionListener(this);
        
        //button to change passwords 
        btnChangePassword = new JButton();
        btnChangePassword.setText("Change Passwords");
        btnChangePassword.setSize(200, 30);
        btnChangePassword.setLocation(20, 150);
        btnChangePassword.setFont(fButton);
        btnChangePassword.setBackground(c1);
        lblBackground.add(btnChangePassword); 
        btnChangePassword.setActionCommand("Change Password");
        btnChangePassword.addActionListener(this);        
        
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
        btnBack.setVisible(false);
    }
    
    public void actionPerformed (ActionEvent e) {
        //display info for deleting a user 
        if(e.getActionCommand().equals("Delete User")) {
            btnDeleteUser.setVisible(false);
            btnChangePassword.setVisible(false);
            btnDeleteBook.setVisible(false);
            users.setVisible(true);
            btnEnter.setVisible(true);
            btnBack.setVisible(true);
            btnEnter.setActionCommand("Delete");
        }
        //delete user 
        if(e.getActionCommand().equals("Delete")) {
            m1 = new Member();     
            lblOutput.setText("User successfully deleted");
            lblOutput.setForeground(Color.WHITE);
            m1.deleteMember(users.getSelectedItem());
            users.setVisible(false);
            btnEnter.setText("Back to Options");
            btnEnter.setActionCommand("Options");
        }
        //display info for changing a password
        if(e.getActionCommand().equals("Change Password")) {
            btnDeleteUser.setVisible(false);
            btnChangePassword.setVisible(false);
            btnDeleteBook.setVisible(false);
            txtPassword.setVisible(true);
            lblPassword.setVisible(true);
            btnBack.setVisible(true);
            users.setVisible(true);
            btnEnter.setVisible(true);
            btnEnter.setActionCommand("Password");
        }
        if(e.getActionCommand().equals("Password")) {
            m1 = new Member(); 
            
            //if no input entered
            if(txtPassword.getText().equals("")) {
                 lblOutput.setText("Enter a password");
                 lblOutput.setLocation(250, 180);
                 txtPassword.setText("");
            }
            //update password
            else {
                lblOutput.setText("Password successfully changed");
                lblOutput.setLocation(20, 130);
                lblOutput.setForeground(Color.WHITE);
                m1.changePassword(m1.findMember(users.getSelectedItem()), txtPassword.getText());
                users.setVisible(false);
                txtPassword.setVisible(false);
                lblPassword.setVisible(false);
                btnEnter.setText("Back to Options");
                btnEnter.setActionCommand("Options");
            }
        }
        //display infor for deleting a book
        if(e.getActionCommand().equals("Delete Book")) {
                btnDeleteUser.setVisible(false);
                btnChangePassword.setVisible(false);
                btnDeleteBook.setVisible(false);
                btnDeleteBook.setVisible(false);
                books.setVisible(true);
                btnEnter.setVisible(true);
                btnBack.setVisible(true);
                btnEnter.setActionCommand("Book");
        }
        //delete a book
        if(e.getActionCommand().equals("Book")) {
                b1 = new Books();     
                lblOutput.setText("Book successfully deleted");
                lblOutput.setForeground(Color.WHITE);
                b1.deleteBook(books.getSelectedItem());
                books.setVisible(false);
                btnEnter.setText("Back to Options");
                btnEnter.setActionCommand("Options");
        }
        //go back to admin page
        if(e.getActionCommand().equals("Options") || e.getActionCommand().equals("Back")) {
            AdminPage f1 = new AdminPage(strUser);
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
    }
}

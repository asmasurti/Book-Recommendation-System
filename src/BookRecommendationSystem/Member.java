/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookRecommendationSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author 342174893
 */
public class Member {
    
    ArrayList<String> arrMembers = new ArrayList();
    ArrayList<String> arrPasswords = new ArrayList();
    Member m1;
    Ratings r1;
    
    public Member() {
        //read the ratings text file
        try{
            FileReader fw = new FileReader("ratings.txt");
            BufferedReader br = new BufferedReader(fw);
            String strLine = br.readLine();
            
            while(strLine != null) {       
                arrMembers.add(strLine); //add each name to array list
                strLine = br.readLine();
                strLine = br.readLine();
            }
            
            br.close();
        }
        catch(IOException e){}
        //read the passwords text file
        try{
            FileReader fw = new FileReader("passwords.txt");
            BufferedReader br = new BufferedReader(fw);
            String strLine = br.readLine();
            
            while(strLine != null) {       
                arrPasswords.add(strLine); //add each password to array list
                strLine = br.readLine();
            }
            
            br.close();
        }
        catch(IOException e){} 
    }
    
    /**
     * 
     * @param strName is the name of the member
     * @return the index of that member
     */
    public int findMember(String strName) {
        return arrMembers.indexOf(strName);
    }
    
    /**
     * 
     * @param str1 is string, name of member to be added
     * @return false, if member already exists, otherwise return true
     */
    public boolean newMember(String str1) {
        //if member already exists
        if(arrMembers.indexOf(str1) > -1) {
            return false;
        }
        else {          
            arrMembers.add(str1);
            Books b1 = new Books();
            //add member to ratings file
            try{         
                BufferedWriter out = new BufferedWriter( new FileWriter("ratings.txt", true)); 
                //Writing things into the file
                out.write(str1 + "\n");
                for(int intI = 0; intI < b1.numberBooks(); intI++) {
                    out.write("0 ");
                }
                out.write("\n");
                out.close();               
            }
            catch(IOException e){}
            return true;
        }
    }
    
    /**
     * 
     * @return the total number of members
     */
    public int numberMembers() {
        return arrMembers.size();
    }
    
    /**
     * 
     * @param intIndex is an integer
     * @return the member name at the given index
     */
    public String getName(int intIndex) {
        return arrMembers.get(intIndex);
    } 
    
    /**
     * 
     * @param intIndex is an integer
     * @return the password at the given index
     */
    public String getPassword(int intIndex) {
        return arrPasswords.get(intIndex);
    }
    
    /**
     * 
     * @param strPassword is a string password to be added
     */
    public void addPassword(String strPassword) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("passwords.txt", true));
            out.write("\n" + strPassword);
            out.close();
        } 
        catch (IOException e) {}
    }
    
    /**
     * 
     * @param strUser is a string, current username
     * @param strNewName is a string, new username
     */
    public void changeUsername(String strUser, String strNewName) {
        //update ratings file
        try{  
            m1 = new Member();
            r1 = new Ratings();
            int intMembers = m1.numberMembers();
            
            BufferedWriter fw = new BufferedWriter( new FileWriter("ratings.txt", false));             
            
            for(int intI = 0; intI < intMembers; intI++) {
                int[] arrRating = r1.returnRatings(intI);
                //update the name
                if(m1.getName(intI).equals(strUser))                  
                    fw.write(strNewName + "\n");
                else
                    fw.write(m1.getName(intI) + "\n");              
                for(int intJ = 0; intJ < arrRating.length; intJ++) {
                        fw.write(Integer.toString(arrRating[intJ]) + " ");
                }
                fw.write("\n");
            }
            fw.close();
        }          
        catch(IOException e){}
    }
    
    /**
     * 
     * @param intMemberIndex is an integer, the index of the member in the array list
     * @param strNewPassword is a string, new password
     */
    public void changePassword(int intMemberIndex, String strNewPassword) {
        m1 = new Member();
        r1 = new Ratings();
        
        try{           
            BufferedWriter fw = new BufferedWriter( new FileWriter("passwords.txt", false));                     
            //change current password to new password
            for(int intI = 0; intI < m1.numberMembers(); intI++) {
                if(intI == intMemberIndex) 
                    fw.write(strNewPassword + "\n");              
                else 
                    fw.write(arrPasswords.get(intI) + "\n");         
            }
            fw.close();
        }          
        catch(IOException e){}
    }
    
    /**
     * 
     * @return complete list of members
     */
    public ArrayList<String> returnListMembers() {
        return arrMembers;
    }
    
    /**
     * 
     * @param strUser is a string, name of member to delete
     */
    public void deleteMember(String strUser) {
        m1 = new Member();
        r1 = new Ratings();
        int intMembers = m1.numberMembers();
        
        //update the ratings text file
        try{      
            BufferedWriter fw = new BufferedWriter( new FileWriter("ratings.txt", false));             
            
            for(int intI = 0; intI < intMembers; intI++) {
                int[] arrRating = r1.returnRatings(intI);
                if(!m1.getName(intI).equals(strUser)) {                
                    fw.write(m1.getName(intI) + "\n");          
                    for(int intJ = 0; intJ < arrRating.length; intJ++) {
                            fw.write(Integer.toString(arrRating[intJ]) + " ");
                    }
                    fw.write("\n");
                }
            }
            fw.close();
        }          
        catch(IOException e){}
        //update the passwords text file
        try{  
            BufferedWriter fw = new BufferedWriter( new FileWriter("passwords.txt", false));             
            
            for(int intI = 0; intI < intMembers; intI++) {
                if(!m1.getName(intI).equals(strUser)) {                
                    fw.write(m1.getPassword(intI) + "\n");          
                }
            }
            fw.close();
        }          
        catch(IOException e){}
    }
}

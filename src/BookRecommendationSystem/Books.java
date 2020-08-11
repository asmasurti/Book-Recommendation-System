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
public class Books {
    
    //Arraylist for titles authors, ISBNs and years
    ArrayList<String> arrTitle = new ArrayList();
    ArrayList<String> arrAuthor = new ArrayList();
    ArrayList<String> arrISBN = new ArrayList();
    ArrayList<String> arrYear = new ArrayList();
    Books b1;
   
    public Books() {
        //read the books file
        try{
            FileReader fw = new FileReader("books.txt");
            BufferedReader br = new BufferedReader(fw);
            String strLine = br.readLine();
            
            while(strLine != null) {
                arrAuthor.add(strLine.substring(0, strLine.indexOf(",")));
                arrTitle.add(strLine.substring(strLine.indexOf(",") + 1));
                strLine = br.readLine();
            }
            
            br.close(); 
        }
        catch(IOException e){}         
        //read the ISBN and year file
        try{
            FileReader fw = new FileReader("ISBNAndYears.txt");
            BufferedReader br = new BufferedReader(fw);
            String strLine = br.readLine();
            
            while(strLine != null) {
                arrISBN.add(strLine.substring(0, strLine.indexOf(",")));
                arrYear.add(strLine.substring(strLine.indexOf(",") + 1));
                strLine = br.readLine();
            }
            
            br.close(); 
        }
        catch(IOException e){}  
    }
    
    /**
     * 
     * @param intIndex is an integer
     * @return book title at that index
     */
    public String getTitle(int intIndex) {
        return arrTitle.get(intIndex);
    }
    
    /**
     * 
     * @param intIndex is an integer
     * @return author at that index
     */
    public String getAuthor(int intIndex) {
        return arrAuthor.get(intIndex);
    }
    
    /**
     * 
     * @param intIndex is an integer
     * @return ISBN number at that index
     */
    public String getISBN(int intIndex) {
        return arrISBN.get(intIndex);
    }
    
    /**
     * 
     * @param intIndex is an integer
     * @return year at that index
     */
    public String getYear(int intIndex) {
        return arrYear.get(intIndex);
    }
    
    /**
     * 
     * @param strTitle is a string 
     * @return index of that string in the array list
     */
    public int findTitle(String strTitle) {
        return arrTitle.indexOf(strTitle);
    }
    
    /**
     * 
     * @param strAuthor s a string 
     * @return index of that string in the array list
     */
    public int findAuthor(String strAuthor) {
        return arrAuthor.indexOf(strAuthor);
    }
    
    /**
     * 
     * @param strISBN s a string 
     * @return index of that string in the array list
     */
    public int findISBN(String strISBN) {
        return arrISBN.indexOf(strISBN);
    }
    
    /**
     * 
     * @return the size of the array list (number of books)
     */
    public int numberBooks() {
        return arrTitle.size();
    }
    
    /**
     * 
     * @param str1 is a string (Author,Title) is added
     */
    public void addBooks(String str1) {
        //write to the books file 
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("books.txt", true));
            //add the new title
            out.write(str1 + "\n");
            out.close();
        } 
        catch (IOException e) {}
        
        //rewrite the ratings
        try{  
            Member m1 = new Member();
            Ratings r1 = new Ratings();
            Books b1 = new Books();
            int intMembers = m1.numberMembers();
            
            BufferedWriter fw = new BufferedWriter(new FileWriter("ratings.txt", false));  
            
            for(int intI = 0; intI < intMembers; intI++) {
                int[] arrRating;                 
                arrRating = r1.returnRatings(intI);                          
                fw.write(m1.getName(intI) + "\n");
                for(int intJ = 0; intJ < arrRating.length; intJ++) {
                    fw.write(Integer.toString(arrRating[intJ]) + " ");
                }
                //add a zero for the new book added
                for(int intK = 0; intK < (b1.numberBooks() - arrRating.length); intK++) {
                    fw.write("0 ");
                }
                fw.write("\n");
            }
            fw.close();
        }          
        catch(IOException e){}
    }
    
    /**
     * 
     * @param str1 is a string (ISBN, Year) which is added
     */
    public void addInfo(String str1) {
        //write to the ISBN And Years file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("ISBNAndYears.txt", true));
            //add the new ISBN and years
            out.write(str1 + "\n");
            out.close();
        } 
        catch (IOException e) {}
    }
    
    /**
     * 
     * @return the complete list of book titles
     */
    public ArrayList<String> returnListBooks() {
        return arrTitle;
    }
    
    /**
     * 
     * @param strTitle is the title of the book that is deleted
     */
    public void deleteBook (String strTitle) {
        //update ISBN and Years file (remove info for given title)
        try{  
            b1 = new Books();
            String strISBN = b1.getISBN(b1.findTitle(strTitle));
            BufferedWriter fw = new BufferedWriter( new FileWriter("ISBNAndYears.txt", false));             
            
            //write to the file only if the book title is not equal to the string parameter
            for(int intI = 0; intI < b1.numberBooks(); intI++) {
                if(!b1.getISBN(intI).equals(strISBN)) {                
                    fw.write(b1.getYear(intI) + "," + b1.getISBN(intI) + "\n");          
                }
            }
            fw.close();
        }          
        catch(IOException e){}
        //update ratings file (remove rating for given title for each member)
        try{  
            Member m1 = new Member();
            Ratings r1 = new Ratings();
            int intMembers = m1.numberMembers();
            
            BufferedWriter fw = new BufferedWriter(new FileWriter("ratings.txt", false));  
            
            for(int intI = 0; intI < intMembers; intI++) {
                int[] arrRating;                 
                arrRating = r1.returnRatings(intI);                          
                fw.write(m1.getName(intI) + "\n");
                //only write the rating value if it is not for the given title parameter
                for(int intJ = 0; intJ < arrRating.length; intJ++) {
                    if(intJ != b1.findTitle(strTitle))
                        fw.write(Integer.toString(arrRating[intJ]) + " ");
                }
                fw.write("\n");
            }
            fw.close();
        }          
        catch(IOException e){}
        //update books file
        try{   
            b1 = new Books();
            BufferedWriter fw = new BufferedWriter( new FileWriter("books.txt", false));             
            
            //only write to file if the book title is not equal to the parameter title
            for(int intI = 0; intI < b1.numberBooks(); intI++) {
                if(!b1.getTitle(intI).equals(strTitle)) {                
                    fw.write(b1.getAuthor(intI) + "," + b1.getTitle(intI) + "\n");          
                }
            }
            fw.close();
        }          
        catch(IOException e){}        
    }
}

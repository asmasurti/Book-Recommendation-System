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
public class Ratings {
    
    ArrayList<int[]> arrRatings = new ArrayList(); //array list of integer arrays for the ratings
    String strName;
    int intMemberIndex;
    Member m1;
    Ratings r1;
    Books b1;
    
    public Ratings() {
        //read the ratings file
        try{
            FileReader fw = new FileReader("ratings.txt");
            BufferedReader br = new BufferedReader(fw);
            String strLine = br.readLine();
            strLine = br.readLine(); 
            
            while(strLine != null) {       
                String[] strList = strLine.split(" ");
                int[] intList = new int[strList.length];
                
                for(int intI = 0; intI < strList.length; intI++) {
                    intList[intI] =  Integer.parseInt(strList[intI]);
                }
                
                strLine = br.readLine(); 
                strLine = br.readLine(); 
                arrRatings.add(intList);
            }
            
            br.close(); 
        }
        catch(IOException e){}
    }
    
    /**
     * 
     * @param intIndex is an integer 
     * @return the array of ratings at a given index
     */
    public int[] returnRatings(int intIndex) {
        return arrRatings.get(intIndex);
    }
    
    /**
     * 
     * @param intIndex is an integer index for the chosen array  
     * @return true, if array is empty (only zero) and false if it's not
     */
    public boolean emptyRatings(int intIndex) {
        r1 = new Ratings();
        int[] selectedRatings = r1.returnRatings(intIndex);
        for(int intI = 0; intI < selectedRatings.length; intI++) {
            if(selectedRatings[intI] == -5 || selectedRatings[intI] == -3 || selectedRatings[intI] == 1 ||
            selectedRatings[intI] == 3 || selectedRatings[intI] == 5)
                return false;
        }      
        return true;
    }
    
    /**
     * 
     * @param intIndex is an integer index for the chosen array  
     * @return true, is the array is full (no zero), and false if the array has zeros
     */
    public boolean completeRatings(int intIndex){
        r1 = new Ratings();
        int[] selectedRatings = r1.returnRatings(intIndex);
        for(int intI = 0; intI < selectedRatings.length; intI++) {
            if(selectedRatings[intI] == 0)
                return false;
        }      
        return true;
    }
    
    /**
     * 
     * @param arrNew is an array containing the new rating
     * @param strName is a string, name of the member whose ratings need to be updated 
     */
    public void updateRatings(int[] arrNew, String strName) {
        //rewrite the ratings document
        try{  
            m1 = new Member();
            r1 = new Ratings();
            int intMembers = m1.numberMembers();
            
            BufferedWriter fw = new BufferedWriter( new FileWriter("ratings.txt", false));             
            
            for(int intI = 0; intI < intMembers; intI++) {
                int[] arrRating;
                //determine array based on the username
                if(!m1.getName(intI).equals(strName))                  
                    arrRating = r1.returnRatings(intI);        
                else
                    arrRating = arrNew;                  
                fw.write(m1.getName(intI) + "\n");
                //add array
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
     * @param str1 is a string, name of the user 
     * @return array list of integers containing the dot products
     */
    public ArrayList<Integer> dotProducts(String str1) {       
        m1 = new Member();
        r1 = new Ratings();
        intMemberIndex = m1.findMember(str1);
        int intDotProduct = 0;
        int[] arrSelected = r1.returnRatings(intMemberIndex);
        int[] arrOther;
        ArrayList<Integer> arrDotProducts = new ArrayList(); 
             
        for(int intI = 0; intI < m1.numberMembers(); intI++) {
            if(intI != intMemberIndex) {
                arrOther = r1.returnRatings(intI);
                for(int intJ = 0; intJ < arrSelected.length; intJ++) {
                    intDotProduct = intDotProduct + (arrSelected[intJ] * arrOther[intJ]);
                }
                arrDotProducts.add(intDotProduct);
                intDotProduct = 0;
            }
        }      
        return arrDotProducts;
    }
    
    /**
     * 
     * @param arrDotProducts is an array list of dot products
     * @return an integer array of the index of top three dot products
     */
    public int[] getTopThree (ArrayList<Integer> arrDotProducts) {
        int[] arrTopThree = new int[3];
        int intCount = 0;
        
        while(intCount < 3) {
            int intMax = arrDotProducts.get(0);
            int intIndex = 0;
            //determine max value in the dot product array three times
            for(int intI = 0; intI < arrDotProducts.size(); intI++) {
                if(arrDotProducts.get(intI) > intMax) {
                       intMax = arrDotProducts.get(intI);
                       intIndex = intI;
                }
            }
            
            arrDotProducts.set(intIndex, 0);
            arrTopThree[intCount] = intIndex;
            intCount++;
        }       
        return arrTopThree;
    }
    
    /**
     * 
     * @param arrTopThree is an integer array of the index of top three dot products
     * @return a string array list of recommended books 
     */
    public ArrayList<String> recommendedBooks(int[] arrTopThree) {
        r1 = new Ratings();
        ArrayList<String> recommendedBooks = new ArrayList();
        int[] arrSelected = r1.returnRatings(intMemberIndex);
        Books b1 = new Books();
        
        //if the ratings list is not empty
        if(!r1.emptyRatings(intMemberIndex)) {
            //generate list of recommended books
            for(int intI = 0; intI < arrTopThree.length; intI++) {
                int[] arrRating;
                if(arrTopThree[intI] < intMemberIndex) {
                    arrRating = r1.returnRatings(arrTopThree[intI]);
                }
                else {
                    arrRating = r1.returnRatings(arrTopThree[intI] + 1);
                }
                for(int intJ = 0; intJ < arrRating.length; intJ++) {
                    if(arrRating[intJ] > 0 && arrSelected[intJ] == 0) {
                        if(recommendedBooks.indexOf(b1.getTitle(intJ)) == -1)
                            recommendedBooks.add(b1.getTitle(intJ));
                    }
                }   
            } 
        }
        //if empty, return a list of general recommende books
        else {
            recommendedBooks = r1.generalRecommended();
        }
        return recommendedBooks;
    }
    
    /**
     * 
     * @return a string array list of general recommended books based on sum of ratings
     */
    public ArrayList<String> generalRecommended () {   
        b1 = new Books();
        m1 = new Member();
        r1 = new Ratings();
        int intSum = 0;
        ArrayList<Integer> sumRatings = new ArrayList();
        
        //determine sum of the ratings for each book
        for(int intI = 0; intI < b1.numberBooks(); intI++) {
            for(int intJ = 0; intJ < m1.numberMembers(); intJ++) {
                int[] arrRating = r1.returnRatings(intJ);
                intSum = intSum + arrRating[intI];
            }
            sumRatings.add(intSum);
            intSum = 0;
        }
        
        int intCount = 0;
        ArrayList<String> generalRecommendation = new ArrayList();
        
        //determine the five books with the highest sum of ratings
        while(intCount < 5) {
            int intMax = sumRatings.get(0);
            int intIndex = 0;
            //determine max value in array list
            for(int intI = 0; intI < sumRatings.size(); intI++) {
                if(sumRatings.get(intI) > intMax) {
                       intMax = sumRatings.get(intI);
                       intIndex = intI;
                }
            }
            //add book to recommended books
            sumRatings.set(intIndex, -200);
            if(generalRecommendation.indexOf(b1.getTitle(intIndex)) == -1)
                generalRecommendation.add(b1.getTitle(intIndex));
            intCount++;
        }      
        return generalRecommendation;
    }
    
    /**
     * 
     * @param intMemberIndex is an integer, the index of the current user
     * @return the number of books that are read 
     */
    public int numberRead(int intMemberIndex) {
        r1 = new Ratings();
        int[] arrRating = r1.returnRatings(intMemberIndex);
        int intCount = 0;
        
        //increase if count if an element in the array is not 0
        for(int intI = 0; intI < arrRating.length; intI++) {
            if(arrRating[intI] != 0) 
                intCount++;
        }       
        return intCount;
    }
}

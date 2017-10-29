/** Program: ReadArray Program
* File: ReadArray.java
* Summary: builds a 20x45 array that stores the characters in row major order and then extracts in column major order.
* Displays the solution.
* Author: Robert J. Nichols
* Date: October 28, 2017 
**/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadArray {
    public static void main(String[] args) {
        //Create variables
        String mySampleText = "";
        char[][]textArray;
        //try-catch for reading from a file
        try {
            BufferedReader br = new BufferedReader(new FileReader("array.txt"));
            
            String readLine = "";
            
            while((readLine = br.readLine()) != null){
                mySampleText += readLine;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        //call the fillArray method and pass in my text that i read from the array.text file to create an array
        textArray = fillArray(mySampleText);
        
        //print the array in column order
        arrayElements(textArray);       
    }
    
    // The arrayElements method will read the array in column order and display it to the console window
    private static void arrayElements(char[][] textArray){
        StringBuilder outputText = new StringBuilder();

        
        for (int i=0; i < 45; i++){
            for (int j = 0; j < 20; j++){
                char temp = textArray[j][i];
                outputText.append(temp);
            }
        }
        System.out.println(outputText);
    }
    
    //Create an array by filling in the row order
    public static char[][] fillArray(String entireText){
        char[][] textArray = new char[20][45];
        int count = 0; 
        
        for (int i = 0; i < 20; i++){
            for(int j = 0; j < 45; j++){
                if(count < entireText.length()){
                    textArray[i][j] = entireText.charAt(count);
                    count++;
                    //Attempted to replace spaces with @ symbol but could not get it to work.
                    if(textArray[i][j] == ' '){
                        textArray[i][j] = '@';
                    }
                }
            }
        }   
        return textArray;
    }    
}

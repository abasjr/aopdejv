/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faculty
 */
public class NamaAnakTB {

    public boolean isPal(String kata){ 
        int left  = 0;                 
        int right = kata.length()-1;  

        while (left < right) {
            if (kata.charAt(left) != kata.charAt(right)) {
                return false;         
            }
            left++;                  
            right--;              
        }

        return true; 
    } 
    
}

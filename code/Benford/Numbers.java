package Benford;

public class Numbers {
    
    // If 971
    // Code figures has 3 digits.
    // Then add (3-1) zeros to 1 (100)
    // Divide by that number (9)
        
    // see how many times each digit appears in the given number, which will tell you how many digits long the number is
    //add one less number of 0's after 1 than how many digits long the number is and divide it by that number (lines 41 and 42)
    //ex. if career games played is 678, code will read it is 3 digits long, and then divide the number by 100 before outputing the integer of 6
    
     public static int get_leading_digit(double number ) {
         int inum = (int) Math.floor(number);
         String sn = String.valueOf(inum);
         int length = sn.length();
         
         int divider = (int) Math.pow(10, length-1);
         return inum / divider;
     }
    
     public static void main(String [] args) {
        System.out.println(5123 + " -> " + get_leading_digit(5123));  
        
        System.out.println(123 + " -> " + get_leading_digit(123));   
        
        System.out.println(4 + " -> " + get_leading_digit(4));   
        
        // Expect 9
        System.out.println(94 + " -> " + get_leading_digit(94));   
        
        // Expect 4
        System.out.println(40203 + " -> " + get_leading_digit(40203));   
        
        
        System.out.println(390.40203 + " -> " + get_leading_digit(390.40203));   
     }
}
import java.lang.StringBuilder;
import java.util.*;

public class StringMod{

    //Replace each A by dd, remove each b
    private static String modAA(String input){
        StringBuilder toReturn = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char savedChar = input.charAt(i); 
            if(savedChar != 'b' && savedChar != 'a'){
                toReturn.append(savedChar);
            } else if(savedChar == 'a'){
                toReturn.append("dd"); 
            }
        }
        return toReturn.toString();
    }


    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        String n = "";
        while(n != "end"){
            System.out.println("Enter a String: ");
            n = reader.nextLine(); // Scans the next token of the input as an int.
            System.out.println(modAA(n));
        }
    }
}
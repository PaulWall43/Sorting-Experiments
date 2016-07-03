import java.util.*;
public class ModSubSequence{   

    public static void main(String[] args){
        int[] arr = {3, 3, 3, 3, 3, 3, 3,3 ,3 , 3, 3,3 ,3 ,3 ,3 ,3, 3, 3, 3,3};
        System.out.println(kSub(3, arr));
        int[] testArr = {1,2,3,4,5,6,7};
        //System.out.println(Arrays.copyOfRange(testArr, 2, 3)[Arrays.copyOfRange(testArr, 2, 3).length - 1]);
    }
    static long kSub(int k, int[] nums) {
        //Dynamic programming
        //Loop through the array once 
        long toReturn = 0;
        long currSum = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % k == 0){toReturn++;} //consider case of just single
            for(int j = 0; j < i; j++){ //here consider case of all previous subsequences
                long temp = sumArray(Arrays.copyOfRange(nums, j, i + 1));
                //System.err.println(temp);
                //System.out.println("From range: (" + j + "," + i + ") we got: " + temp);
                if(temp % k == 0){
                    toReturn++;
                    
                }
            }
        }
        
        return toReturn;
    }


    private static long sumArray(int[] nums){
        long toReturn = 0;
        for(int i : nums){
            toReturn += i;
        }
        return toReturn;
    }

    static String compress(String str) {
        /*I realize this could be shorter, but given time constraints I'm going to move on to the next one because I'm not sure how             hard the last question will be, thanks*/
        /*Just a note, will this code may be longer it is O(n)*/
        
        if(str.length() == 1){ //check for the trivial case
            return str;
        }
        char currChar = str.charAt(0); //get the first char
        int counter = 0; //set a counter to check streak of letters
        ArrayList<String> listForNewString = new ArrayList<String>();
        String toReturn = "";  //make a toReturn string to format later
        int strLength = str.length(); //convenience variable (should be a constant but you get the point)
        for(int i = 1; i < strLength; i++){ //loop through the string
            if(str.charAt(i) == currChar){ //Check if the loop character is equal to the last one
                counter++;
                if (i + 1 >= strLength){ //Check if end of the string, special case
                    listForNewString.add(Character.toString(currChar));
                    listForNewString.add(String.valueOf(counter + 1));
                }
            } else { //end of streak, add to the list the char and num if it had a streak > 1
                listForNewString.add(Character.toString(currChar)); 
                if (counter + 1 > 1){
                    listForNewString.add(String.valueOf(counter + 1));
                }
                counter = 0; //reset counter
                currChar = str.charAt(i); //set the currChar to this one for next one to compare
                if (i + 1 >= strLength){ //Check if end of the string, special case
                    listForNewString.add(Character.toString(str.charAt(i)));
                } 
            }
            
        }
        
        for(String string : listForNewString){ //format the returnString
                   toReturn += string; //compile formats to StringBuilder
        } 
        return toReturn;
    }
}
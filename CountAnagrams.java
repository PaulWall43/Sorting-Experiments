import java.util.*;

public class CountAnagrams{

    private static HashMap<String, ArrayList<String>> groupAnagrams(String[] strings){
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strings.length; i++){
            String curr = strings[i];
            char[] chars = curr.toCharArray(); //should probably remove whitespace
            Arrays.sort(chars); //changes in place
            String sortedWord = new String(chars);
            if(anagramMap.containsKey(sortedWord)){
                anagramMap.get(sortedWord).add(curr);
                continue; 
            }
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(curr);
            anagramMap.put(sortedWord, temp);
        }
        return anagramMap;
    }

    public static void main(String[] args){
        String[] arrA = {"test", "estt", "sett", "tset", "jeb", "bej"};
        HashMap<String, ArrayList<String>> anagramMap = null;
        anagramMap = groupAnagrams(arrA);
        for(String key : anagramMap.keySet()){
            System.out.println(key);
        }


    }
    

}

-------

//This write only section is limited I want to add another class
//
    static String[] getSuspiciousList(String[] transactions) {
        //create a boolean array to keep track of the first sus trans
        boolean[] susBoolList = new boolean[transactions.length];
        HashMap<String, ArrayList<Integer>> nameHistory = new HashMap<String, ArrayList<Integer>>(); 
        //find the number of different names
        for(int i = 0; i < transactions.length; i++){
            String[] sArr = transactions[i].split("\\|");
            if(nameHistory.containsKey(sArr[0])){
                //append the index 
                Integer temp2 = new Integer(i);
                nameHistory.get(sArr[0]).add(temp2);
                continue;
            }
            ArrayList<Integer> temp = new ArrayList<Integer>();
            Integer temp2 = new Integer(i);
            temp.add(temp2);
            nameHistory.put(sArr[0], temp); 
        }
        
        //Loop through every name
        String[] prevTrans = {}; 
        int numSusTrans = 0;
        for(String name : nameHistory.keySet()){
            //loop through all their transactions
            for(int i = 0; i < nameHistory.get(name).size(); i++){
                //Get the index of the transaction
                int index = nameHistory.get(name).get(i).intValue();
                //check if the transaction was > 3000
                String[] sArr = transactions[index].split("\\|");
                
                if(Integer.parseInt(sArr[1]) > 3000){
                    susBoolList[index] = true; 
                    numSusTrans++;
                    continue; 
                } else if(i > 0){ //else check for the last transaction
                    if(Integer.parseInt(sArr[3]) - Integer.parseInt(prevTrans[3]) < 60){
                        if(!sArr[2].equals(prevTrans[2])){
                            susBoolList[nameHistory.get(name).get(i - 1).intValue()] = true;
                            numSusTrans++;
                        }
                    }
                }
                //save reference to the last transaction
                prevTrans = sArr;   
            }
        }
        
        ArrayList<String> toReturnNames = new ArrayList<String>(); //At most this many 
        //Now to print out the names at the susBoolListSpots
        for(int i = 0; i < susBoolList.length; i++){
            //String[] sArr = transactions[index].split("\\|");
            if(susBoolList[i]){
                //check the name
                String[] sArr = transactions[i].split("\\|");
                if(!toReturnNames.contains(sArr[0])){
                    toReturnNames.add(sArr[0]);
                }
            }
        }
        
        String[] toReturn = new String[toReturnNames.size()];
        toReturn = toReturnNames.toArray(toReturn);
        
        return toReturn;

    }


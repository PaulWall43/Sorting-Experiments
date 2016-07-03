import java.util.*;


public class pascaNumbers {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> toReturn = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            if(i == 0){
                temp.add(new Integer(1));
                toReturn.add(temp);
            } else if(i == 1){
                temp.add(new Integer(1));
                temp.add(new Integer(1));
                toReturn.add(temp);
            } else {
                temp.add(new Integer(1));
                for(int j = 0; j < toReturn.get(i - 1).size() - 1; j++){
                    temp.add(new Integer(toReturn.get(i - 1).get(j).intValue() + toReturn.get(i - 1).get(j + 1).intValue()));
                }
                temp.add(new Integer(1));
                toReturn.add(temp);
            }
        }
        return toReturn;
    }


        public static void main(String[] args){
            pascaNumbers n = new pascaNumbers();

            System.out.println(n.generate(1));
            System.out.println(n.generate(2));
            System.out.println(n.generate(3));
            System.out.println(n.generate(4));
            System.out.println(n.generate(5));
        }
        
        
    }
    static int getMinTimeDifference(String[] times) {

        int[] intArr = new int[times.length];
        //First will convert to an array only containing minutes
        for(int i = 0; i < times.length; i++){
            //get first two numbers
            String s = times[i];
            String hours = s.substring(0,2);
            String minutes = s.substring(3,5);
            //Convert hours to minutes
            int convertedTime = (Integer.parseInt(hours) * 60) + Integer.parseInt(minutes);
            intArr[i] = convertedTime <= 1439 ? convertedTime : 0;
        }
        
        //sort the intArr
        Arrays.sort(intArr);
        
        //No negative time differences lol, so 0 and not infinity should be okay
        int minDiff = 1439; 
        //loop through the array and find the smallest difference
        for(int i = 0; i < intArr.length - 1; i++){
            int tempDiff = intArr[i + 1] - intArr[i];
            if(tempDiff < minDiff){
                minDiff = tempDiff;
            }
        }
        //Do last compare around the edge with first and last index
        int tempFirst = intArr[0] + 1440;
        if(tempFirst - intArr[intArr.length - 1] < minDiff){
            minDiff = tempFirst - intArr[intArr.length - 1]; 
        }

       return minDiff;
    }
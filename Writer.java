public class Writer(){
    

    public void writeAddress(){

        File file = new File("Address.txt");
        BufferedReader bReader = null; 

        PrintWriter writer = new PrintWriter("Address.txt", "UTF-8");

        try{

        bReader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundExeception e){
            System.err.println("File not found... exiting");
            return 
        } //other exceptions


        int counter_one = 0;
        int counter_two = 1;
        for(int i = 0; i < 255; i++){
            for(int j = 0; j < 255; j++){

            }
        }



        // while(bReader.readLine() != null){

        // }


//pamkrish@cisco.com

    }
}
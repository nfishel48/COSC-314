package Relation;

  /* This program will take an 8x8 boolean matrix and output
    wheater or not relations are on the set
    This program was written for COSC-314 from instruction from 
    Dr.Michael Zeiger, and written by Nathaniel Fishel*/

    //imoorts
    import java.util.*;
    import java.io.*;

class Relations
{
    //Global Flag varibles
    boolean reflexive = false;
    boolean symmetric =false;
    boolean antisymmetric = false;
    boolean transitive = false;
    boolean equiv_relation = false;

    //scanner
    static Scanner stdIn = new Scanner(System.in);

    //File Reader
    static String fileName;
    static String line;
    static FileReader fileReader;
    static BufferedReader br;



/***********************************************************************************************************************/
   
    public static void getFile()
    {
        //Prompt the user to enter a file name 
        System.out.println("Please enter the name of the file containing the matrix");
        fileName = stdIn.nextLine();
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory +"/Relation/"+ fileName;
        System.out.println(path);
        //"/Volumes/Macintosh HD/Volumes/Macintosh HD/Users/nfishel/LocalDocuments/m1.txt"

        //Open the file or throw an exception
        try
        {
        fileReader = new FileReader(path);
         br = new BufferedReader(fileReader);
            //next try block is for testing purpose only
            try
            {
                System.out.println("The matrix: ");
                for(int i = 0; i<=7; i++){
                    line = br.readLine();
                    System.out.println(line);
             }
            }
            catch(IOException e)
            {
                System.out.println("ERROR");
            }
         }
        catch(FileNotFoundException e)
        {
            System.out.println("\nThat file was not found program is now closing please relaunch and try again");

        }
    }

/***********************************************************************************************************************/


    public static void main(String[] args)
    {
        getFile();
    }

}
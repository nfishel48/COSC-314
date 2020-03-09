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

    //Matrix 
    static int[][] matrix = new int[8][8];



/***********************************************************************************************************************/
   
    public static void getFile()
    {
        //Prompt the user to enter a file name 
        System.out.println("Please enter the name of the file containing the matrix");
        fileName = stdIn.nextLine();
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory +"/"+ fileName;
        System.out.println("The path entered was "+path);
        //"/Volumes/Macintosh HD/Volumes/Macintosh HD/Users/nfishel/LocalDocuments/m1.txt"

        //Open the file or throw an exception
        try
        {
         br = new BufferedReader(fileReader = new FileReader(path));
            //Read in maxtrix to a 2D array
            try
            {
                for(int i = 0; i<=7; i++){
                    for(int j = 0; j<=7; j++)
                    {
                        int a = br.read()-48;   //Read the character and subract 48 to get int value
                        if(a == -16)            //If it is a space skip it
                             a = br.read()-48; 
                        if(a == -38)            //IF it is a new line skip it
                            a = br.read()-48;
                        matrix[i][j] = a;
                        System.out.print(matrix[i][j]+" ");
                    }
                    System.out.println();
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
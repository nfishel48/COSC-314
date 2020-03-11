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
    static boolean reflexive = false;
    static boolean symmetric =false;
    static boolean antisymmetric = false;
    static boolean transitive = false;
    static boolean equiv_relation = false;

    //scanner
    static Scanner stdIn = new Scanner(System.in);

    //File Reader
    static String fileName;
    static String line;
    static FileReader fileReader;
    static BufferedReader br;

    //Matrix 
    static int[][] matrix = new int[8][8];



/**********************************************************************************************************************
 This Method will get a file name and load that file into the Reader
 Then it will save the matrix in the file to a 2D array as well as print it to the screen
*/
   
    public static void getFile()
    {
        //Prompt the user to enter a file name 
        System.out.println("Please enter the name of the file containing the matrix");
        fileName = stdIn.nextLine();
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory +"/"+ fileName;
        System.out.println("The path entered was "+path);

        //Open the file or throw an exception
        try
        {
         br = new BufferedReader(fileReader = new FileReader(path));
            //Read in maxtrix to a 2D array
            try
            {
                System.out.println("The matrix is:");
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

/***********************************************************************************************************************
This method will check if the matrix is reflexive 
*/

    public static void isReflexive()
    {
        int check = 0;  //Increment this too check the main diagonial
        for(int i = 0; i<=7; i++)
        {
            if(matrix[i][check++] == 1)   //Check the values along the main diagonial and sets it equal too true if all 1
                reflexive = true;
            else
                reflexive = false;
        }
    }

/**********************************************************************************************************************
 This method will check if a matrix is symetric
*/

    public static void isSymetric()
    {
        for(int i = 0; i<=7; i++) //loop through rows
        {
            for(int j = i+1; j<=7; j++) //loop through colums
            {
                if(matrix[i][j] == 1) //if a one is found
                {
                    if(matrix[j][i] == 1)
                    {                    //if corresponding 1 = 1 
                      
                        symmetric = true;
                    }
                    else                  //if corresponding 1 = 0
                        symmetric = false;
                }
            }
        }
    }

/***********************************************************************************************************************
This method will check if a matrix is Antisymetric 
*/

public static void isAntisymetric()
{
    for(int i = 0; i<=7; i++) //loop through rows
    {
        for(int j = i+1; j<=7; j++) //loop through colums
        {
            if(matrix[i][j] == 1) //if a one is found
            {
                if(matrix[j][i] == 1)
                {                    //if corresponding 1 = 1 
                    antisymmetric = false;
                }
                else                  //if corresponding 1 = 0
                    antisymmetric = true;
            }
        }
    }
}

/**********************************************************************************************************************
This method will check if a matrix is Transitive 
*/

public static void isTransitive()
{
    for(int i = 0; i<=7; i++)// loop through rows
    {
        for(int j = 0; j<=7; j++)// loop through colums
        {
            if(matrix[i][j] == 1) //if aRb find and relations of bRc and verify that aRc 
            {
                for(int k = 0; k<=7; k++)//loop through row to find any realtions
                {
                    if(matrix[j][k] == 1 && j!=k) //found a realation bRc
                    {
                        if(matrix[i][k] == 1) //check for aRc
                        {
                            transitive = true;
                        }
                        else
                        {
                            transitive=false;
                        }   
                        
                    }
                }
            }
        }
    }
}

/***********************************************************************************************************************/

    public static void main(String[] args)
        {
            getFile();
            isReflexive();
            isSymetric();
            isAntisymetric();
            isTransitive();
            if(transitive == true )
                System.out.println("TRUEEEEE");
        }

}
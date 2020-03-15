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
                    if(matrix[j][k] == 1) //found a realation bRc
                    {
                        if(matrix[i][k] == 1 ) //check for aRc
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

    //if(symetric == true && reflexive == true)
}

/***********************************************************************************************************************/

public static void isEquivalnce()
{
    if(transitive == true && symmetric == true && reflexive == true)
    {
        equiv_relation = true;
    }
    else
    {
        equiv_relation = false;
    }
}

/***********************************************************************************************************************/

public static void transitiveClosure()
{
    boolean done = false;
    int i = 0;
    int size = 0;
    ArrayList<Integer> column = new ArrayList<Integer>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    int matrixC[][] = matrix;
 if(transitive == false)
 {
     while(done == false)
     {
        for(int j = 0; j<=7; j++)
        {
            if(matrixC[i][j] == 1 && matrixC[j][i] == 1)
            {
                matrixC[j][j] = 1;
            }
        }
        i++;
        if(i == 8)
        {
         done = true;
        }

     }
     System.out.println("The matrix  closure is:");
     for(int a = 0; a<=7; a++){
         for(int b = 0; b<=7; b++)
         {
            System.out.print(matrixC[a][b]+" ");
         }
         System.out.println();
        }
 }
}
/***********************************************************************************************************************/

public static void equiv_classes()
{
    int j = 0; //increment row outside of loop
    boolean done = false;
    int row[] = new int[8];
    ArrayList<Integer> matchs = new ArrayList<Integer>();
    while(done == false)
    {
        for(int i = 0; i<=7; i++)// move through row and make an array list
        {
             row[i] = matrix[j][i]; //save a row to single array
        }
       
        for(int x = 0; x<=7; x++) // compare row with other rows to form equvilance classes
        {
            if(matrix[x][0] == row[0] && matrix[x][1] == row[1] && matrix[x][2] == row[2] && matrix[x][3] == row[3] &&
            matrix[x][4] == row[4] && matrix[x][5] == row[5] && matrix[x][6] == row[6] && matrix[x][7] == row[7])
            {
                matchs.add(x);
            }
        }
        matchs.add(500);
        j++;
        if(j == 7){
        done = true;
        }
        
    }
    for(int i = 0; i<matchs.size(); i++){
        if(matchs.get(i) == 500){
            System.out.println();
        }
        else
        {
            System.out.print(matchs.get(i)+1);
        }
    }
    
}



/***********************************************************************************************************************/

public static void outputer()
{
    if(reflexive == true)
    {
        System.out.println("The relation is reflexive");
    }
    else
    {
        System.out.println("The relation is not reflexive");
    }
    if(symmetric == true)
    {
        System.out.println("The relation is symmetric");
    }
    else
    {
        System.out.println("The relation is not symmetric");
    }
    if(antisymmetric == true)
    {
        System.out.println("The relation is antisymmetric");
    }
    else
    {
        System.out.println("The relation is not antisymmetric");
    }
    if(transitive == true)
    {
        System.out.println("The relation is transitive");
    }
    else
    {
        System.out.println("The relation is not transitive");
        transitiveClosure();
    }
    if(equiv_relation == true)
    {
        System.out.println("The relation is a equivalence relation");
        System.out.println("The equvilant classes are:");
        equiv_classes();
    }
    else
    {
        System.out.println("The relation is  not a equivalence relation");
    }
}


    public static void main(String[] args)
        {
            getFile();
            isReflexive();
            isSymetric();
            isAntisymetric();
            isTransitive();
            isEquivalnce();
            outputer();
        }

}
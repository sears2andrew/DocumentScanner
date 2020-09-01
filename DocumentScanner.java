//Chris Logan and Andrew Sears
//CSC 210
//10/25/18
//This class accepts user input and holds the classes together

package documentscanner;

/**
 *
 * @author alsears and cjlogan
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.util.*;
//mport static jdk.nashorn.tools.ShellFunctions.input;


public class DocumentScanner {
    public static void main(String[] args) throws FileNotFoundException {
        ScanDocument();
        Scanner input = new Scanner(System.in);
        boolean done = false;
        while(done == false){
            System.out.println();
            System.out.println("Would you like to\n"
                    + "\t-Search for a word\n"
                    + "\t-PrintMaxWord\n"
                    + "\t-PrintPreorder\n"
                    + "\t-PrintInorder\n"
                    + "\t-PrintPostorder\n"
                    + "\t-Delete a word\n"
                    + "\t-Exit\n");
            String response = input.next();
            if("Search".equalsIgnoreCase(String.valueOf(response))){
                System.out.println("what would you like to seach for?");
                String key = input.next();
                search(key);
            }
            else if("PrintMaxWord".equalsIgnoreCase(String.valueOf(response))){
                //need to find max word and count
                //System.out.println(key + "is has the highest occurance count at " + count);
                Node parent = BinarySearchTree.head;
            }
            else if("PrintPreorder".equalsIgnoreCase(String.valueOf(response))){
                PrintPreorder();
            }
            else if("PrintInorder".equalsIgnoreCase(String.valueOf(response))){
                PrintInorder();
            }
            else if("PrintPostorder".equalsIgnoreCase(String.valueOf(response))){ 
                PrintPostorder();
            }
            else if("Delete".equalsIgnoreCase(String.valueOf(response))){ //deletes a word and shuffles tree
                System.out.println("What word would you like to delete?");
                BinarySearchTree.Delete(input.next());
                System.out.println("Word has been removed.");
            }
            else if("Exit".equalsIgnoreCase(String.valueOf(response))){ //shuts program down
                System.out.println("Shutting down.......");
                done = true;
            }
            else{
                System.out.println("input invalid. try again\n");
            }
        }
    }
    public static void ScanDocument() throws FileNotFoundException{
        Scanner inputFile = new Scanner(new FileInputStream("Alice.txt")); //reads file. 
        while(inputFile.hasNext()){
            String word = inputFile.next().toLowerCase().replaceAll("[^\\p{L}\\p{Nd}]", ""); //removes uppercase letters and assorted non-sense. 
            BinarySearchTree.insert(word); //inserts word into binary tree
        }
    }
//prints using data generated from other class
    public static void search(String key){ //searchs for the word the user types in
        if(BinarySearchTree.Search(key)!=null){
        System.out.println(key + " occured " + BinarySearchTree.Search(key).GetValue() + " times.");
        }
        else
            System.out.println("word not found"); //prints if the word is not found. 
    }
    public static void PrintPreorder(){
       //System.out.println();
       BinarySearchTree.Print_Preorder(BinarySearchTree.head); //Prints in pre-order
    }
        
    public static void PrintInorder(){
       //System.out.println();
       BinarySearchTree.Print_Inorder(BinarySearchTree.head); //Prints with in-onder
    }
    
    public static void PrintPostorder(){
       //System.out.println();
       BinarySearchTree.Print_Postorder(BinarySearchTree.head); //Prints in post-order
    }
    
    public static int HashGenerator(String key) { //hash function provided by Professor Nwamze
        double hash = 0.0;
        int base;
        int power;
        for (int i=0; i<key.length(); i++) {
        base = (int)key.charAt(i)-96;
        power = (i==0)?3:2;
        hash += Math.pow(base, power)*Math.PI/(i+1);
        }
    return (int)(hash*Math.E*5/key.length());
    }
}//end of class

//Chris Logan and Andrew Sears
//CSC 210
//10/25/18
//This class hold the node and it's functions

package documentscanner;
/**
 *
 * @author alsears and cjlogan
 */
public class Node {
  int value;
    Node leftChild;
    Node rightChild;
        Node parent;
    int key;
        String word;
    Node() {
    }
    public void SetValue(int value){
        this.value = value; //sets the value
    }
    public void SetLeftChild(Node child){
        this.leftChild = child; //sets the left child
    }
    public void SetRightChild(Node child){
        this.rightChild = child; //sets the right child
    }
    public int GetValue(){
        return value; //returns value
    }
    public Node GetLeftChild(){
        return leftChild; //returns left child
    }
    public Node GetRightChild(){
        return rightChild; //returns right child
    }
    public void SetKey(int key){
        this.key = key; //assigns key to word
    }
    public int GetKey(){
        return key; //returns key for word
    }
    public Node GetParent(){
        return parent; //returns parent
    }
    public void SetParent(Node parent){
        this.parent = parent; //sets parent
    }
    public void SetWord(String word){
        this.word = word; //sets word for printing functions
    }
    public String GetWord(){
        return word; //returns word for printing functions
    }
    public String HighestWordCount(){
        return HighestWordCount;
    }
}

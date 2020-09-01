//Chris Logan and Andrew Sears
//CSC 210
//10/25/18
//This class contains the binary search tree and it's functions

package documentscanner;

/**
 *
 * @author alsears and cjlogan
 */
public class BinarySearchTree {
    public static Node head;
    public static void insert(String key){ //Inserts word into the binary tree
        int keyHash = DocumentScanner.HashGenerator(key);
        if (head == null){
                Node addnode = new Node();
            head = addnode;
                addnode.SetValue(1);
                addnode.SetKey(keyHash);
                addnode.SetWord(key);
        }
        else{
            Node parent = head;
            boolean done = false;
            while(parent.GetLeftChild() != null && parent.GetRightChild() != null && done == false){
                if(keyHash < parent.GetKey()){
                    parent = parent.GetLeftChild();
                }
                else if(keyHash > parent.GetKey()){
                    parent = parent.GetRightChild();
                }
                if(keyHash == parent.GetKey()){
                    parent.SetValue(parent.GetValue()+1);
                        done = true;
                }
            }
            if(keyHash < parent.GetKey()){
                    Node addnode = new Node();
                    addnode.SetValue(1);
                    addnode.SetKey(keyHash);
                    parent.SetLeftChild(addnode);
                    addnode.SetWord(key);
                }
            else if(keyHash > parent.GetKey()){
                    Node addnode = new Node();
                    addnode.SetValue(1);
                    addnode.SetKey(keyHash);
                    parent.SetRightChild(addnode);
                    addnode.SetWord(key);
                }
            
        }
       
    }
    public static Node Search(String key){ //traverses through the tree to search for a word
        int ValueSearch = DocumentScanner.HashGenerator(key);
        Node parent = head;
        if(parent.GetKey()== ValueSearch){
            return parent;
        }
        while(parent.GetLeftChild() != null && parent.GetRightChild() != null){
            if(parent.GetKey()== ValueSearch)
                return parent;
            else if(ValueSearch < parent.GetKey())
                parent = parent.GetLeftChild();
            else if(ValueSearch > parent.GetKey())
                parent = parent.GetRightChild();
        }
        if(parent.GetKey()== ValueSearch){
            return parent;
        }
        else
            return null;
    }
    
       
    public static void Delete(String key){ //deletes selected word
       Node parent = Search(key);
       parent.SetLeftChild(null);
       parent.SetRightChild(null);
       
       if(head.GetKey() > head.key){
          head.GetLeftChild() = Delete(head.key);
       }
       else if(head.GetKey() < head.key){
           head.GetRightChild() = Delete(head.key);
       }
       else{
           if(head.GetLeftChild() == null){
               return head.GetRightChild();
           }
           else if(head.GetRightChild() == null){
               return head.GetLeftChild();
           }
       }
       
    }

    public static void Print_Preorder(Node head){ //head, left, right.
        System.out.println(head.GetWord() + "" + (head.GetValue())); 
        if (head.GetLeftChild() != null)
            Print_Preorder(head.GetLeftChild());
        if (head.GetRightChild() != null)
            Print_Preorder(head.GetRightChild());
    }
        
    public static void Print_Inorder(Node head){ //left, head, right
       if (head.GetLeftChild()!= null)
            Print_Inorder(head.GetLeftChild());
            System.out.println(head.GetWord() + "" + (head.GetValue()));
       if (head.GetRightChild() != null)
            Print_Inorder(head.GetRightChild());
    }
    public static void Print_Postorder(Node head){ //left, right, head
       if (head.GetLeftChild() != null)
            Print_Postorder(head.GetLeftChild());
        if (head.GetRightChild() != null)
            Print_Postorder(head.GetRightChild());
            System.out.println(head.GetWord() + "" + (head.GetValue()));
    }
    
    public static void maxCount(Node head){
        if(HighestWordCount == null){
            Node addnode = new Node();
            addnode.SetValue(head.GetValue());
            addnode.SetWord(head.GetWord());
            HighestWordCount = addnode;
        }
        else if (head.GetValue() > HighestWordCount.GetValue()){
            HighestWordCount.SetValue(head.GetValue());
            HighestWordCount.SetWord(head.GetWord());
        }
        if (head.GetLeftChild() != null)
            maxCount(head.GetLeftChild());
        if (head.GetRightChild() != null)
            maxCount(head.GetRightChild());
        }
}

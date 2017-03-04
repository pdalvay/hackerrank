import java.util.*;

/* Class node is defined as :
class Node 
   int val;   //Value
   int ht;      //Height
   Node left;   //Left child
   Node right;   //Right child

*/

class Node{
	int val;
	int ht;
	Node left;
	Node right;
	Node(int d){
		val = d;
		ht = 0;
		left = null;
		right = null;
	}
	Node(){
		val = 0;
		ht = 0;
		left = null;
		right = null;
	}
}


public class Solution {

	public static Node insert(Node root, int val){
		Node ins = new Node();
		ins.val = val;
		if(root == null){
			ins.ht = 1;
			root = ins;
		} else if(val < root.val){
				root.left = insert(root.left,val);
		} else if(val > root.val){
				root.right = insert(root.right,val);
		}
	    root.ht=1+Math.max( height(root.left), height(root.right));
	    int bf= height(root.left)-height(root.right);
	    if(bf>1 && val<root.left.val)
	        return rightRotate(root);
	    else if(bf>1 && val>root.left.val)
	    {
	       root.left= leftRotate(root.left);
	        return rightRotate(root);
	    }
	    else if(bf<-1 && val>root.right.val)
	        {
	        
	            
	            return leftRotate(root);
	            
	            
	    }
	    else if(bf<-1 && val<root.right.val)
	     {
	        root.right=rightRotate(root.right);
	        return leftRotate(root);
	    }
		return root;
	}


public static int height(Node root)
{
    if(root==null)
        return -1;
    else
        return root.ht;
    
}

public static Node rightRotate(Node z)
{
    Node y= z.left;
    z.left= y.right;
    y.right=z;
    z.ht= 1+ Math.max(height(z.left), height(z.right));
    y.ht= 1+ Math.max(height(y.left), height(y.right));
    return y;
    
}
public static Node leftRotate(Node z)
{
    Node y= z.right;
    z.right= y.left;
    y.left=z;
    z.ht=  1+Math.max(height(z.left), height(z.right));
    y.ht= 1+ Math.max(height(y.left), height(y.right));
    
    return y;
    
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node root = null;
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int iN = in.nextInt();
			root = insert(root,iN);
			System.out.println("Inside Iserting : "+(iN)+" : ");
			preOrder(root);
			System.out.println("");
		}
		System.out.print("Final::");
		preOrder(root);
    }

	public static void preOrder(Node root){
		if(root==null){
			return;
		}
		System.out.print(root.val+ ":"+root.ht+" , ");
		preOrder(root.left);
		preOrder(root.right);
	}
}   

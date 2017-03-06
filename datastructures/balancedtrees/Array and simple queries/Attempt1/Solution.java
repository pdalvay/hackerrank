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
		int n = in.nextInt();
		int m = in.nextInt();
		boolean who = true;
		int[] arr = new int[n];
		int[] arrtmp = new int[n];
		for(int i=0;i<n;i++){
			int iN = in.nextInt();
			arr[i] = iN;
		}
		for(int i=0;i<m;i++){
			int iop = in.nextInt();
			int ifr = in.nextInt()-1;
			int ito = in.nextInt()-1;
			if(iop == 1){
				int itrvOrig = ifr;
				int itrvNew = 0;
				while(itrvOrig <= ito){
					if(who){
						arrtmp[itrvNew++]=arr[itrvOrig++];	
					} else {
						arr[itrvNew++]=arrtmp[itrvOrig++];
					}
					
				}
				int itrvOldtoifr = 0;
				while(itrvOldtoifr < ifr){
					if(who){
						arrtmp[itrvNew++]=arr[itrvOldtoifr++];	
					} else {
						arr[itrvNew++]=arrtmp[itrvOldtoifr++];	
					}
				}
				int itrvOldtoend = ito+1;
				while(itrvOldtoend < n){
					if(who){
						arrtmp[itrvNew++]=arr[itrvOldtoend++];	
					} else {
						arr[itrvNew++]=arrtmp[itrvOldtoend++];	
					}
				}
				who = !who;
			} else {
				int itrvOrig = 0;
				int itrvNew = 0;
				while(itrvOrig < ifr){
					if(who){
						arrtmp[itrvNew++]=arr[itrvOrig++];	
					} else {
						arr[itrvNew++]=arrtmp[itrvOrig++];	
					}
				}				
				int itrvOldtoend = ito+1;
				while(itrvOldtoend < n){
					if(who){
						arrtmp[itrvNew++]=arr[itrvOldtoend++];	
					} else {
						arr[itrvNew++]=arrtmp[itrvOldtoend++];	
					}
				}
				itrvOrig = ifr;
				while(itrvOrig <= ito){
					if(who){
						arrtmp[itrvNew++]=arr[itrvOrig++];	
					} else {
						arr[itrvNew++]=arrtmp[itrvOrig++];
					}
				}
				who = !who;				
			}
		}
		if(who){
			System.out.println(Math.abs(arr[0]-arr[n-1]));
//			printArr(arr);	
		} else{
			System.out.println(Math.abs(arrtmp[0]-arrtmp[n-1]));
//			printArr(arrtmp);
		}
		
    }
    

	private static void printArr(int[] arrtmp) {
		for(int i:arrtmp){
			System.out.print(i+" ");
		}
		
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

import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	Node(int d){
		data = d;
		left = null; right = null;
	}
	Node(int d,Node l, Node r){
		data=d; left=l;right = r;
	}
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node root = new Node(1);
		ArrayList<Node> al =  new ArrayList<Node>(100);
		al.add(root);
		for(int i=0;i<n;i++){
			int l = in.nextInt();
			int r = in.nextInt();
			Node par = null;
			while(!al.isEmpty()){
				par = al.remove(0);
				if(par.data != -1) break;
			}
			
			Node left = null;
			Node right = null;
			if(l!=-1){
				left = new Node(l);
				par.left = left;
				al.add(left);
			} else {
				al.add(new Node(-1));
			}
			if(r!=-1){
				right = new Node(r);
				par.right = right;
				al.add(right);
			} else {
				al.add(new Node(-1));
			}
			
		}
		int maxHt = getHt(root);
		int t = in.nextInt();
		for(int j=0;j<t;j++){
			int k = in.nextInt();
			rotate(root,k,maxHt,1);
			inorder(root);
			System.out.println("");
		}
//		System.out.println("Printing Inorder After: ");
//		inorder(root);
		
    }

	private static void rotate(Node root, int k, int maxHt,int lev) {
		if(root == null) return;
		if(lev>maxHt-1){
			return;
		}
		if(lev%k == 0){
			Node tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}
		rotate(root.left,k,maxHt,lev+1);
		rotate(root.right,k,maxHt,lev+1);
	}

	private static int getHt(Node root) {
		if(root == null) return 0;
		return (1+ Math.max(getHt(root.left), getHt(root.right)));
	}

	private static void inorder(Node root) {
		if(root == null ){
			return;
		}
		inorder(root.left);
		System.out.print(root.data+",");
		inorder(root.right);
	}

}
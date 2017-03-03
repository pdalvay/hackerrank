import java.util.*;

class Node{
	char data;
	HashMap<Character,Node> hm;
	int cnt;
	Node(char d){
		data = d;
		hm=new HashMap<Character,Node>();
		cnt=0;
	}
	Node(){
		data = ' ';
		hm=new HashMap<Character,Node>();
		cnt=0;
	}
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node root = new Node();
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String strR = in.next();
			if(!addToTree(root,strR)){
				System.out.println("BAD SET");
				System.out.println(strR);
				return;
			}
		}
		System.out.println("GOOD SET");
    }

	private static boolean addToTree(Node root, String str) {
		boolean flag=true;
		for(char c:str.toCharArray()){
			if(root.hm.get('A')!=null) return false;
			if(root.hm.get(c)!=null){
				root = root.hm.get(c);
			}else{
				Node nIns = new Node(c);
				root.hm.put(c,nIns);
				root = nIns;
			}
			root.cnt++;
		}
		if(root.hm.get('A')!=null || root.cnt > 1) return false;
		root.hm.put('A', new Node());
		return flag;
	}
	
}   

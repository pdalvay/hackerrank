import java.util.*;

class Node{
	String data;
	HashMap<String,Node> hm;
	int cnt;
	Node(String d){
		data = d;
		hm=new HashMap<String,Node>();
		cnt=0;
	}
	Node(){
		data = "";
		hm=new HashMap<String,Node>();
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
			if(strR.startsWith("add")){
				String strWhat = in.next();
				addToTree(root,strWhat);
			} else {
				String strWhat = in.next();
				findInTree(root,strWhat);
			}
		}
    }

	private static void addToTree(Node root, String str) {
		for(char c:str.toCharArray()){
			if(root.hm.get(String.valueOf(c))!=null){
//				root.cnt.put(String.valueOf(c),root.cnt.get(String.valueOf(c))+1);
				root = root.hm.get(String.valueOf(c));
			}else{
				Node nIns = new Node(String.valueOf(c));
				root.hm.put(String.valueOf(c),nIns);
//				root.cnt++;	
//				root.cnt.put(String.valueOf(c),1);
				root = nIns;
			}
			root.cnt++;
		}
	}
	
	private static void findInTree(Node root, String str) {
		for(char c:str.toCharArray()){
			if(root.hm.get(String.valueOf(c))!=null){
				root = root.hm.get(String.valueOf(c));
			}else{
				System.out.println("0");
				return;
			}
		}
//		int sum=0;
//		for(String run:root.cnt.keySet()){
//			sum+=root.cnt.get(run);
//		}
		if(root.data == null ){
			System.out.println(0);
		} else {
			System.out.println(root.cnt);	
		}		
	}
}   

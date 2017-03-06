
public class Solution {

	/*  
	   class Node
	      public  int frequency; // the frequency of this tree
	       public  char data;
	       public  Node left, right;
	    
	*/ 

	void decode(String S ,Node root)
	    {
			StringBuffer sbuf = new StringBuffer();
			Node trv = root;
	        for(char c:S.toCharArray()){
                if(c == '1'){
	        		trv = trv.right;
	        	} else {
	        		trv = trv.left;
	        	}
                if(trv.data != '\0'){
	        		sbuf.append(trv.data);
	        		trv = root;
	        	} 
	        }
	        System.out.println(sbuf);
	       
	    }
}   

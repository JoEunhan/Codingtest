package baekjoon_bf;
import java.util.*;
public class stateful_string_samsung {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt=0;
		ArrayList<String> str = new ArrayList<>();
		
		while(true) {
		 String string = s.next();
		 if(string.contains("-")) break;
		 str.add(string);
		
		}
		//1. 2
		//2. 0
		//3. 1
		//System.out.println(str);
		int[] result = new int[str.size()];
		for(int i=0;i<str.size();i++) {
			String string = str.get(i);
			//System.out.println(string+", "+find(string));
			Stack<String> st = new Stack<>();
			if(find(string,st)) {
				System.out.print(i+1+". "+0+"\n");
			}else {
				//if(i==str.size()-1) System.out.print(i+1+". "+couting(string));
				//else
					System.out.print(i+1+". "+couting(st)+"\n");
			}
		}
		
	}
	public static boolean find(String string,Stack<String> st) {
		//Stack<String> st = new Stack<>();
		if(string.equals(""))return true;
		else if(string.length()%2==1) return false;
		else {
			
		for(int i=0;i<string.length();i++) {
			String str = string.substring(i,i+1);
			//System.out.println(str);
			if(st.isEmpty()||st.peek().equals("}")) st.push(str);
			else {
				if(str.equals("}")&&st.peek().equals("{")) {
					st.pop();
					//st.pop();
				}else st.push(str);
			}
		}
		if(st.size()==0)return true; 
		
		else return false;
		}
	}
	public static int couting(Stack<String> st) {
		String string="";
		for(int i=0;i<st.size();i++) {
			string+=st.get(i);
		}
		int cnt=0;
		String newstr="";
		while(newstr.length()<string.length()) {
			if(newstr.length()%2==0) {
				newstr+="{";
			}else newstr+="}";
		}
		//System.out.println(newstr);
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)!=newstr.charAt(i)) cnt++;
		}
		return cnt;
		
	}

}

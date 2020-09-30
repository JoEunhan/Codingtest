package baekjoon_bf;
import java.util.*;
public class chicken_delivery_samsung {

	static ArrayList<ArrayList<Integer>> comb = new ArrayList<>();
	static int min = 99999;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
		ArrayList<Integer> qx = new ArrayList<>();
		ArrayList<Integer> qy = new ArrayList<>();
		int a = s.nextInt();
		int b = s.nextInt();
		int[][] arr = new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				arr[i][j]=s.nextInt();
				if(arr[i][j]==2) {
					ArrayList<Integer> lst = new ArrayList<>();
					lst.add(i);
					lst.add(j);
					ar.add(lst);
				}else if(arr[i][j]==1) {
					qx.add(i);
					qy.add(j);
				}
			}
		}
		
		//System.out.println(ar.size()+"ll");
		boolean[] v = new boolean[ar.size()];
	//for(int i=0;i<5;i++)
		select(ar.size(),0,b,v);
		
		
	//	System.out.println(comb);
	//	System.out.println(ar);
		
		int mm=99999;
			for(int i=0;i<comb.size();i++) {
				if(mm>calmin(comb.get(i),ar,qx,qy))
					mm=calmin(comb.get(i),ar,qx,qy);
			}
		
	
		System.out.println(mm);
		
	}
	
	public static void select(int max,int start,int num,boolean[] v) {
		if(num==0) {
			ArrayList<Integer> ar = new ArrayList<>();
			for(int i=0;i<v.length;i++) {
				if(v[i]==true) {
				//	System.out.print(i+" ");
					ar.add(i);
				}
				
			}
			comb.add(ar);
			
			
			//System.out.println();
			//return;
		}else {
			for(int i=start;i<max;i++) {
				v[i]=true;
				select(max,i+1,num-1,v);
				v[i]=false;
			}
			
			//select(max,start+1,num-1,v);
			
		}
	}
	
	public static int calmin(ArrayList<Integer> a,ArrayList<ArrayList<Integer>> b,
			ArrayList<Integer> qx, ArrayList<Integer> qy) {
		ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
		for(int i=0;i<a.size();i++) {
			ls.add(b.get(a.get(i)));
		}
	//	System.out.println(ls);
		int distance=0;
		
			for(int j=0;j<qx.size();j++) {
				int x = qx.get(j);
				int y = qy.get(j);
				int min =9999;
				for(int i=0;i<ls.size();i++) {
				
				int dst = Math.abs(ls.get(i).get(0)-x)+Math.abs(ls.get(i).get(1)-y);
				if(dst<min)min=dst;
			//	System.out.println(min);
				//distance+=min;
				
			}
			distance+=min;
		}
		//System.out.println("dist"+distance);
		return distance;
		
		
		
	}
}

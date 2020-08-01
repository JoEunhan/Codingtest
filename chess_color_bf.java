package baekjoon_bf;
import java.util.*;
public class chess_color_bf {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a =s.nextInt();
		int b = s.nextInt();
		String[][] narr = new String[51][51];
		for(int i=0;i<a;i++) {
			String str = s.next();
			String[] arr = str.split("");
			for(int j=0;j<arr.length;j++) {
				narr[i][j]=arr[j];
			}
		}
		/*
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++)
				System.out.print(narr[i][j]);
			System.out.println();
		}*/
		//System.out.println();
		int min=64;
		//int d=0;int e=0;
		for(int d=0;d+8<=a;d++) {
			for(int e=0;e+8<=b;e++) {
				int result1=0;
				for(int i=d;i<d+8;i++) {
					for(int j=e;j<e+8;j++) {
						//System.out.print(narr[i][j]);
						if((i+j)%2==1) {
							//È¦ ¼ö ÀÏ¶©, wÀÌ¾î¾ß ÇÔ.
							if(narr[i][j].equals("B")) {
								result1++;
							}
						}else if((i+j)%2==0) {
								if(narr[i][j].equals("W")) {
									
									result1++;
								}
					}
						
					//System.out.println();
				}
				//System.out.println();
			}
				if(min>result1)min=result1;
				//System.out.println(result1);
		}
			
			//d++; e++;
		}
		
		
			//d++; e++;
		
	
		for(int d=0;d+8<=a;d++) {
			for(int e=0;e+8<=b;e++) {
				int result2=0;
				for(int i=d;i<d+8;i++) {
					for(int j=e;j<e+8;j++) {
						//System.out.print(narr[i][j]);
						if((i+j)%2==1) {
							//È¦ ¼ö ÀÏ¶©, wÀÌ¾î¾ß ÇÔ.
							if(narr[i][j].equals("W")) {
								
								result2++;
							}
							}else if((i+j)%2==0) {
								if(narr[i][j].equals("B")) {
									
									result2++;
								}
					}
						
					//System.out.println();
				}
				//System.out.println();
			}
			if(min>result2) min=result2;
			//	System.out.println(result2);
		}
			
			//d++; e++;
		}
		System.out.println(min);
		
		
	
	
		
	}	
		
	
	
	
}

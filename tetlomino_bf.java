package baekjoon_bf;

import java.util.*;

public class tetlomino_bf {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a=s.nextInt();
		int b= s.nextInt();
		int[][] arr = new int[a][b];
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				arr[i][j]=s.nextInt();
			}
		}
		int max=0;
		for(int i=0;i<a;i++) {
			for(int j=0;j+4<=b;j++) {
				int result1=0;
				for(int k=j;k<j+4;k++) {
					result1+=arr[i][k];
				}
				if(max<result1) max = result1;
				//System.out.println(result1);
			}
		}
		for(int i=0;i<b;i++) {
			for(int j=0;j+4<=a;j++) {
				int result1=0;
				for(int k=j;k<j+4;k++) {
					result1+=arr[k][i];
				}
				if(max<result1) max = result1;
				//System.out.println(result1);
			}
		}
		
		for(int i=0;i+1<a;i++) {
			
			for(int j=0;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i][j+1];
			result1+=arr[i+1][j+1];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+2<a;i++) {
			for(int j=0;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i+2][j];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j+1];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+2<a;i++) {
			for(int j=1;j<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i+2][j];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j-1];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+1<a;i++) {
			for(int j=0;j+2<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i+1][j+1];
			//result1+=arr[i][j+1];
			result1+=arr[i+1][j+2];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		for(int i=1;i<a;i++) {
			for(int j=0;j+2<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i][j+1];
			result1+=arr[i][j+2];
			//result1+=arr[i][j+1];
			result1+=arr[i-1][j+2];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+2<a;i++) {
			for(int j=0;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i][j+1];
			result1+=arr[i+1][j];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		for(int i=0;i+2<a;i++) {
			for(int j=0;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i][j+1];
			result1+=arr[i+1][j+1];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j+1];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+1<a;i++) {
			for(int j=0;j+2<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i][j+1];
			//result1+=arr[i][j+1];
			result1+=arr[i][j+2];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+1<a;i++) {
			for(int j=0;j+2<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i][j+1];
			result1+=arr[i][j+2];
			//result1+=arr[i][j+1];
			result1+=arr[i+1][j+2];
			if(max<result1) max=result1;
		//	System.out.println(result1);
			}
		}
		for(int i=0;i+2<a;i++) {
			for(int j=0;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i+1][j+1];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j+1];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		for(int i=0;i+2<a;i++) {
			for(int j=1;j<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i+1][j-1];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j-1];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+1<a;i++) {
			for(int j=0;j+2<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i][j+1];
			result1+=arr[i+1][j+1];
			//result1+=arr[i][j+1];
			result1+=arr[i+1][j+2];
			if(max<result1) max=result1;
		//	System.out.println(result1);
			}
		}
		for(int i=0;i+1<a;i++) {
			for(int j=1;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j-1];
			result1+=arr[i+1][j];
			//result1+=arr[i][j+1];
			result1+=arr[i][j+1];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+2<a;i++) {
			for(int j=0;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i+1][j+1];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		for(int i=0;i+2<a;i++) {
			for(int j=1;j<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j];
			result1+=arr[i+1][j-1];
			//result1+=arr[i][j+1];
			result1+=arr[i+2][j];
			if(max<result1) max=result1;
			//System.out.println(result1);
			}
		}
		
		
		for(int i=0;i+1<a;i++) {
			for(int j=0;j+2<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i][j+1];
			result1+=arr[i+1][j+1];
			//result1+=arr[i][j+1];
			result1+=arr[i][j+2];
			if(max<result1) max=result1;
		//	System.out.println(result1);
			}
		}
		for(int i=0;i+1<a;i++) {
			for(int j=1;j+1<b;j++) {
			int result1=0;
			result1+=arr[i][j];
			result1+=arr[i+1][j-1];
			result1+=arr[i+1][j];
			//result1+=arr[i][j+1];
			result1+=arr[i+1][j+1];
			if(max<result1) max=result1;
		//	System.out.println(result1);
			}
		}
		System.out.println(max);
	}
}

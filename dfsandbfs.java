package baekjoon_bf;
import java.util.*;
public class dfsandbfs {
	//static ;
	//static 
	static int dx[]= {1,-1,-1,1};
	static int dy[] = {0,-1,+1,1};
	
	public static void dfs(int k,int l,int[][] arr,boolean[][] v) {
		if(k>=arr.length||l>=arr[0].length||k<0||l<0) return;

		else if(v[k][l]==false&&arr[k][l]==1) {
			v[k][l]=true;
			for(int i=0;i<4;i++) {
				k+=dx[i];
				l+=dy[i];
				if(k<arr.length&&l<arr[0].length) 
					dfs(k,l,arr,v);
			}
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		int a = 0;
		int b=0;
		int[] result = new int[t];
		for(int i=0;i<t;i++) {
			int M = s.nextInt();
			int N = s.nextInt();
			int K = s.nextInt();
			int cnt=0;
			int arr[][]=new int[N][M];
			//System.out.println("N"+N+"M"+arr[0].length);

			boolean v[][] = new boolean[N][M];
			for(int j=0;j<K;j++) {
				b = s.nextInt();
				a = s.nextInt();
				arr[a][b]=1;
			}
		/*	for(int k=0;k<N;k++) {
				for(int l=0;l<M;l++) {
					System.out.print(arr[k][l]);
				}
				System.out.println();
			}*/
			for(int k=0;k<N;k++) {
				for(int l=0;l<M;l++) {
					if(arr[k][l]==1&&v[k][l]==false) {
						cnt++;
						int newk=k;
						int newl=l;
						//System.out.println(k+" "+l);
						
						dfs(newk,newl,arr,v);	
					}
				}
				//System.out.println();
			}
			result[i]=cnt;
			//System.out.println(cnt);
					
		}
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
}

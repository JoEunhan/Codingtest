package baekjoon_bf;
import java.util.*;
public class food_garbage_avide {
	public static boolean visited[][];
	static int dx[]= {1,-1,-1,1};
	static int dy[] = {0,-1,+1,1};
	public static int max=0;
	public static int m;
	public static int n;
	public static int result=0;
	public static void dfs(int[][] arr,int i,int j) {
		result++;
		int newi=i;
		int newj=j;
		if(newi<0||newj<0||newi>=n||newj>=m) return;
		for(int k=0;k<dx.length;k++) {
			newi+=dx[k];
			newj+=dy[k];
			if(newi<0||newj<0||newi>=n||newj>=m)  continue;
			//	dfs(result,arr,newi,newj);

			else if(arr[newi][newj]==1&&visited[newi][newj]==false) {
				//System.out.println("newi: "+newi+" newj: "+newj);	
				
				visited[newi][newj]=true;
				dfs(arr,newi,newj);
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		int k = s.nextInt();
		int arr[][]= new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<k;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			arr[a-1][b-1]=1;
		}
		/*for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]);
				
			}
			System.out.println();
		}*/
		//int result=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1&&visited[i][j]==false) {
					result=0;
					//result++;

					//System.out.println("newi: "+i+" newj: "+j);
					visited[i][j]=true;
					dfs(arr,i,j);	
					//System.out.println("result: "+result);
					if(result>max) max=result;
				}
				
			}
		}
		
		System.out.println(max);
		//int result=0;
		
		
	}
}

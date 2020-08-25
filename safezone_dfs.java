package baekjoon_bf;
import java.util.*;
public class safezone_dfs{
	//public static int result=0;

	public static boolean [][] visited;
	static int dx[]= {1,-1,-1,1};
	static int dy[] = {0,-1,+1,1};
	
	public static void dfs(int i, int j,int[][] newarr) {
		int newi=i;
		int newj=j;
		for(int a=0;a<4;a++) {
			newi+=dx[a];
			newj+=dy[a];
			if(newi<0||newj<0||newi>=newarr.length||newj>=newarr.length) continue;

			if(newarr[newi][newj]==1&&visited[newi][newj]==false) {
				visited[newi][newj]=true;
				dfs(newi,newj,newarr);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int min=100;
		int max=0;
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=s.nextInt();
				if(arr[i][j]>max) max=arr[i][j];
				if(arr[i][j]<min) min=arr[i][j];
				}
		}
		int[][] newarr;
		int maxr=0;
		for(int w=0;w<=max;w++) {
			newarr=new int[n][n];
			visited=new boolean[n][n];
			int result=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]<=w) { //침수된 지역은 0으로
						newarr[i][j]=0;
					}else newarr[i][j]=1; //아닌 지역은 1로 setting
				}
			}	
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(newarr[i][j]+" ");
				}
				System.out.println();
			}
		
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(newarr[i][j]==1&&visited[i][j]==false) {
						visited[i][j]=true;
						result++;
						System.out.println("i"+i+"j"+j);
						dfs(i,j,newarr);
						
					}
				}
			}
			System.out.println(w+" result "+ result);
			if(maxr<result) maxr=result;
			
		}
		System.out.println(maxr);
		System.out.println("--------------");
		
	}
}

package baekjoon_bf;
import java.util.*;
public class robot_cleaner {
	static int now =0;
	static int[][] arr;
	static boolean[][] v;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int r = s.nextInt();
		int c = s.nextInt();
		int d = s.nextInt();
		 arr = new int[n][m];
		 v= new boolean[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				arr[i][j]=s.nextInt();
		
		now=d;
		v[r][c]=true;
		dfs(r,c);
		int ans=0;
		///counting/////
		/*for(int i=0;i<v.length;i++) {
			for(int j=0;j<v[0].length;j++) {
				System.out.print(v[i][j]+"  ");
			}
			System.out.println();
		}*/
		for(int i=0;i<v.length;i++) {
			for(int j=0;j<v[0].length;j++) {
				if(v[i][j]==true) ans++;
			}
		}
		System.out.println(ans);
				
	}
	public static boolean cango(int i, int j) {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int cnt=0;
		for(int k=0;k<dx.length;k++) {
			int newi = i+dx[k];
			int newj = j+dy[k];
			if(newi>=0&&newj>=0&&newi<arr.length&&newj<arr[0].length) {
				if(arr[newi][newj]==0&&v[newi][newj]==false)
					cnt++;
			}
			
			
		}
		///갈 곳이 없음... 네 방향 모두
		if(cnt==0) return false;
		return true;
				
		
	}
	public static void dfs(int i, int j) {
		//v[i][j]=true;
		//System.out.println("i: "+i+" ,j: "+j+" ,now: "+now);
		
		//System.out.println(cnt);
		///갈 곳이 없음... 네 방향 모두
		if(!cango(i,j)) {
			if(now==0) {
			int newi = i+1;
			if(newi>=0&&newi<arr.length) 
			if(arr[newi][j]==0){
				v[newi][j]=true;
				dfs(newi,j);
					
			}else return;
			
			}else if(now==1) {
			int newj = j-1;
			if(newj>=0&&newj<arr[0].length) 
				if(arr[i][newj]==0){
				 
				v[i][newj]=true;
				dfs(i,newj);	
				
			}else return;
			
			
			}else if (now==2) {
			int newi = i-1;
			if(newi>=0&&newi<arr.length) 
				if(arr[newi][j]==0){
				 
				v[newi][j]=true;
				dfs(newi,j);	

			}else return;
			
			
			}else if (now==3) {
		    int newj = j+1;
		    if(newj>=0&&newj<arr[0].length) 
				if(arr[i][newj]==0){
				
				v[i][newj]=true;
				dfs(i,newj);
				
			}else return;
			}
		}else	
		switch(now) {
		case 0:{
			int newj = j-1;
			if(newj>=0&&newj<arr[0].length) {
			if(arr[i][newj]==0&&v[i][newj]==false) {
				now=3;
				v[i][newj]=true;
				dfs(i,newj);
			}else {
				now=3;
				dfs(i,j);
			}
			}/*else {
				now=3;
				dfs(i,j);
			}*/
		} break;
		 
		case 1:{
			int newi = i-1;
			if(newi>=0&&newi<arr.length) {
				if(arr[newi][j]==0&&v[newi][j]==false) {
					now=0;
					v[newi][j]=true;
					dfs(newi,j);
				}else {
					now=0;
					dfs(i,j);
				}
			}/*else {
				now=0;
				dfs(i,j);
			}*/
		} break;
		
		case 2:{
			int newj = j+1;
			if(newj>=0&&newj<arr[0].length) {
				if(arr[i][newj]==0&&v[i][newj]==false) {
					v[i][newj]=true;
					now=1;
					dfs(i,newj);
				}else {
					now=1;
					dfs(i,j);
				}
			}
			/*else {
				now=1;
				dfs(i,j);
			}*/
			
		} break;
		
		case 3:{
			int newi = i+1;
			if(newi>=0&&newi<arr.length) {
				if(arr[newi][j]==0&&v[newi][j]==false) {
					now=2;
					v[newi][j]=true;
					dfs(newi,j);
				}else {
					now=2;
					dfs(i,j);
				}
			}/*else {
				now=2;
				dfs(i,j);
			}*/
		} break;
		
			
			
			
			
			
		
		}
			
	}
}

package baekjoon_bf;

import java.util.*;
public class RGB_bfs {

	static int n;
	static String[][] arr;
	static String[][] newarr;
	static boolean[][] v;
	static int[] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	static int result=0;
	public static void bfs1(int a, int b) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(a);
		qy.add(b);
		
		while(!qx.isEmpty()&&!qy.isEmpty()) {
			int x=qx.poll();
			int y=qy.poll();
			v[x][y]=true;
			String str3 = arr[x][y];
			//result++;
			for(int i=0;i<4;i++) {
				int newx = x+dx[i];
				int newy = y+dy[i];
				if(newx>=0&&newx<n&&newy>=0&&newy<n) {
					if(v[newx][newy]==false&&arr[newx][newy].equals(str3)) {
						v[newx][newy]=true;
						qx.add(newx);
						qy.add(newy);
					}else continue;
				}
			}
		}
			
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		newarr =new String[n][n];	
		arr =new String[n][n];
		v = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String str1 = s.next();
			String[] str2 = str1.split("");
			for(int j=0;j<n;j++) {
				arr[i][j]=str2[j];
				newarr[i][j]=str2[j];
				if(newarr[i][j].equals("R")||newarr[i][j].equals("G")) {
					newarr[i][j]="A";
				}
				
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(v[i][j]==false) {
					result++;
					bfs1(i,j);
				}
				
			}
		}
		System.out.println(result);
			
	}
}

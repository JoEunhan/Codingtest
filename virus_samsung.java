package baekjoon_bf;
import java.util.*;
public class virus_samsung {
	
	static ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int a;
	static int b;
	static boolean[][] v ;
	static int cnt=0;
	static int max=0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		a = s.nextInt();
		b = s.nextInt();
		int[][] arr= new int[a][b];
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				ArrayList<Integer> sm = new ArrayList<>();
				arr[i][j]=s.nextInt();
				if(arr[i][j]==0) {
					sm.add(i);
					sm.add(j);
					arr2.add(sm);
				}
			}
		}
		//System.out.println(arr2);
		//System.out.println(arr[4][2]);
		for(int i=0;i<arr2.size()-2;i++) {
			for(int j=i+1;j<arr2.size()-1;j++) {
				for(int k=j+1;k<arr2.size();k++) {
					int[][] arr3=new int[a][b];
					for(int h=0;h<arr.length;h++) {
						for(int l=0;l<arr[0].length;l++) {
							arr3[h][l]=arr[h][l];
						}
					}
							v= new boolean[a][b];

					cnt=0;
					int x_1=arr2.get(i).get(0);
					int x_2=arr2.get(i).get(1);
					int y_1=arr2.get(j).get(0);
					int y_2 =arr2.get(j).get(1);
					int z_1=arr2.get(k).get(0);
					int z_2 = arr2.get(k).get(1);
				//	System.out.print("x:"+x_1+","+x_2);
				//	System.out.print(" y:"+y_1+","+y_2);
				//	System.out.print(" z:"+z_1+","+z_2);
				//	System.out.println();
					arr3[x_1][x_2]=1;
					
					arr3[y_1][y_2]=1;
					arr3[z_1][z_2]=1;
					
					spread(arr3);
					find_pure(arr3);
					if(max<cnt) max=cnt;
					//System.out.println("cnt: "+cnt);
				}
				
			}
		}
		
		System.out.println(max);
		
		
	}
	public static void spread(int[][] arr3) {
		for(int i=0;i<arr3.length;i++) {
			for(int j=0;j<arr3[0].length;j++) {
				if(arr3[i][j]==2&&v[i][j]==false) {
					v[i][j]=true;
					dfs(arr3,i,j);
				}
			}
		}
		
	}
	public static void dfs(int[][] arr3,int x,int y) {
		for(int i=0;i<4;i++) {
			int newx=x+dx[i];
			int newy=y+dy[i];
			if(newx>=0&&newy>=0&&newx<a&&newy<b) {
				if(arr3[newx][newy]==0&&v[newx][newy]==false) {
					arr3[newx][newy]=2;
					v[newx][newy]=true;
					dfs(arr3,newx,newy);
					
				}
			}
		}
	}
	public static void find_pure(int[][] arr3) {
		for(int i=0;i<arr3.length;i++) {
			for(int j=0;j<arr3[0].length;j++) {
				//System.out.print(new_arr[i][j]);
				if(arr3[i][j]==0) {
				//	System.out.println("empty");
					cnt++;
				}
			}
		//System.out.println();
		}
		
	}
}

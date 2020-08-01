package baekjoon_bf;
import java.util.*;
public class devide_sum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i =s.nextInt();
		int ans=0;
		for(int j=i;j>=0;j--) {
			String str = String.valueOf(j);
			String[] arr = str.split("");
			int sum=0;
			for(int k=0;k<arr.length;k++) {
				sum+=Integer.valueOf(arr[k]);
			}
			if(sum+j==i) ans=j;
			
		}
		System.out.println(ans);
		
	}
}

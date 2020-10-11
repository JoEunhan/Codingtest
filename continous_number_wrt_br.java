package baekjoon_bf;
import java.util.*;
public class continous_number_wrt_br {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int result=0;
		for(int i=1;i<=n;i++) {
			//int numb = i/10;
			
				//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
				
			if(i<10) result+=1;
			else if(i>=10 && i<100) result+=2;
			else if(i>=100 && i<1000) result+=3;
			else if(i>=1000 && i<10000) result+=4;
			else if(i>=10000 && i<100000) result+=5;
			else if(i>=100000 && i<1000000) result+=6;
			else if(i>=1000000 && i<10000000) result+=7;
			else if(i>=10000000 && i<100000000) result+=8;
			else if(i==100000000) result+=9;
		}
		System.out.println(result);
	}
}

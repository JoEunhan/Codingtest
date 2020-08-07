#include <iostream>
#include <algorithm>
#include <vector>;
#include <stack>;
#include <tuple>;
#include <queue>;
using namespace std;

int a;
int b;
int s;
int s2;
int zero_cnt = 0;
int two_cnt = 0;
int arr[9][9];
int copy_arr[9][9];
int zero[81][2];
int two[81][2];
queue < pair<int, int>> v;
queue <pair<int, int>> v2;
int maxn = 0;

void dfs(int x, int y) {
	//if (copy_arr[x][y] == 1||x<0||y<0) return;
	while (x >= 0 && y >= 0 && x < a && y < b && (copy_arr[x + 1][y] == 0
		|| copy_arr[x - 1][y] == 0 || copy_arr[x][y - 1] == 0 || copy_arr[x][y + 1] == 0)) {
		
		if (copy_arr[x + 1][y] == 0) {

			copy_arr[x + 1][y] = 2;
			dfs(x + 1, y);
		}else if (copy_arr[x - 1][y] == 0) {

			copy_arr[x - 1][y] = 2;
			dfs(x - 1, y);
		}else if (copy_arr[x][y + 1] == 0) {
			//x++;
			copy_arr[x][y + 1] = 2;
			dfs(x, y + 1);
		}
		else if (copy_arr[x][y - 1] == 0) {
			//x++;
			copy_arr[x][y - 1] = 2;
			dfs(x, y - 1);
		}
		else break;
	}
	
}

void spread() {
	for (int i = 0; i < s2; i++) {
		int x = two[i][0];
		int y = two[i][1];
		
	//	cout << two[i][0] << " " << two[i][1] << '\n';
		dfs(x, y);
		//cout << "----" << '\n';

	}
}
void wall(int i, int j, int k) {
	int x1 = zero[i][0];
	int y1 = zero[i][1];
	int x2 = zero[j][0];
	int y2 = zero[j][1];
	int x3 = zero[k][0];
	int y3 = zero[k][1];
	copy_arr[x1][y1] = 1;
	copy_arr[x2][y2] = 1;
	copy_arr[x3][y3] = 1;
	/*
	cout << "\n";
	for (int c = 0; c < a; c++) {
		for (int d = 0; d < b; d++) cout << copy_arr[c][d] << " ";
		cout << "\n";
	}*/
	spread();
}



int main()
{
	cin >> a;
	cin >> b;
	for (int i = 0; i < a; i++)
		for (int j = 0; j < b; j++) {
			cin >> arr[i][j];
			copy_arr[i][j] = arr[i][j];
			if (arr[i][j] == 0) {
				zero_cnt++;
				v.push(make_pair(i, j));
			}
			else if (arr[i][j] == 2) {
				two_cnt++;
				v2.push(make_pair(i, j));
			}
		}
	//int zero[sizeof(v)][2];
	s = zero_cnt;
	for (int i = 0; i < sizeof(v); i++) {
		if (v.empty()) break;
		zero[i][0] = v.front().first;
		zero[i][1] = v.front().second;
		v.pop();
	}
	s2 = two_cnt;
	cout <<s<<" "<< s2 << "\n";
	for (int i = 0; i < sizeof(v2); i++) {
		if (v2.empty()) break;
		two[i][0] = v2.front().first;
		two[i][1] = v2.front().second;
		v2.pop();
	}
/*	for (int i = 0; i < s2; i++) {
		cout << two[i][0]<< " " << two[i][1] << "\n";
	}*/
	for (int i = 0; i < s-2; i++) {
		for (int j = i + 1; j < s - 1; j++) {
			for (int k = j + 1; k < s ; k++) {
				for (int c = 0; c < a; c++)
					for (int d = 0; d < b; d++) copy_arr[c][d] = arr[c][d];
				

				int cnt = 0;
				wall(i, j, k);
				cout << "\n";
				for (int c = 0; c < a; c++) {
					for (int d = 0; d < b; d++) cout << copy_arr[c][d] << " ";
					cout << "\n";
				}
				for (int c = 0; c < a; c++) {
					for (int d = 0; d < b; d++) {
						if (copy_arr[c][d] == 0) {
							cnt++;
						}
					}
				}
				if (maxn < cnt) {
					maxn = cnt;
					cout << "\n";
				for (int c = 0; c < a; c++) {
					for (int d = 0; d < b; d++)
						cout << copy_arr[c][d] << " ";
					cout << "\n";
				}
				}
			}
				
		}
	
}
	cout << maxn;
			
	
}

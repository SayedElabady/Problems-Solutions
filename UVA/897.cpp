#include <bits/stdc++.h>
using namespace std;
#define MOD           1000000007
#define forn(i,s,n)   for(int i = s ; i < n ; i++)
#define mp            make_pair
#define pb            push_back  
#define st            first
#define nd            second
#define sz(v)         ((int)((v).size()))
const int SIZE=10000009;
const int OO = (int)1e9;
const double PI = acos(-1);
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<int , int > Point;
typedef pair<pair<int, double> , int > iii;
// complexity (O(10 ^ 6 * !7))
bool isprime[SIZE];
int it = 0;
int ana[SIZE];
void sieve(){
	for(int i = 2 ;i < SIZE ; ++i){
		if(!isprime[i]){
			for(int j = i + i ; j < SIZE ; j+=i)
				isprime[j]=1;
		}
	}
}
void build(int X){
	int i = 0 , arr[9]; 
	int temp = X;
	while(X){
		arr[i++]= X%10;
		X/=10;
		if((arr[i-1]&1)==0)return;
	}
	
	sort(arr , arr + i);
	do{
		int q = 0 ; 
		forn(x , 0 , i)q = q * 10 + arr[x];
	//	cout << q << endl;
		if(isprime[q])return;
	}while(next_permutation(arr,arr + i));
	ana[it++]=temp;
}
 int main(){   
 	
 	sieve();
 //	build(113);
 	ana[0]=2;
 	it++;
 	for(int i = 3 ; i < SIZE ; i+=2)build(i);
	int n;
	while(scanf("%d" , &n)==1 && n){
		int qq = n;
		int cnt = 0  ;
		while(qq){
			cnt++;

			qq/=10;
			
		}
		int ans = ana[upper_bound(ana , ana + it , n) - ana];
		cnt = pow(10 , cnt);
	//	cout << cnt << " " << last << " ";
		if(cnt > ans)
 		printf("%d\n",  ans);
 		else printf("%d\n" ,0);
 		}
      
}

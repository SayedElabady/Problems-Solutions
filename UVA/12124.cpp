#include <bits/stdc++.h>
using namespace std;
#define MOD           1000000007
#define forn(i,s,n)   for(int i=s ; i<n ; i++)
#define mp            make_pair
#define pb            push_back  
#define st            first
#define nd            second
#define sz(v)         ((int)((v).size()))
const int SIZE=500005;
const int OO = (int)1e9;
const double PI = acos(-1);
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<double , double > Point;
typedef pair<pair<int, double> , int > iii;
int arr1[SIZE] , arr2[SIZE];
map < string , vector<ii> >mpp;
int C ;
bool solve(int mid , int W){

	for(auto X : mpp){
		int cost = INT_MAX;
		//cout << X.first;
		for(auto Q : X.second){
			if(Q.nd >= mid){
				cost = min(cost , Q.st);
			}


		}
		if(cost > W || cost == INT_MAX)return 0;
		W -= cost;
	}
	return 1;

}
int main(){
	int T ;
	scanf("%d" , &T);
	while(T--){
	int N ;
	mpp.clear();
	scanf("%d %d" , &N , &C );
	string S , q ;
	int a , b;
	
	forn(i , 0 , N){
		cin >> S >> q >> a >> b;
	
		mpp[S].pb({a , b});
	}
//	forn(i , 0 , 10)cout << solve(i, C) << endl;
	 int l = 0 , r = 1000000000; 
	 int ans = -1;
	 while(r > l){
	 	int mid = (l+r+1)/2;
	 	if(solve(mid , C)){
	 		ans = max(ans , mid);
	 		l = mid ;
	 	}else 
	 	r = mid -1;
	 }
	 printf("%d\n" , l);
	}



}

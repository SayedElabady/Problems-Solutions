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
int C , X[SIZE] , Y[SIZE];
 
int main(){
	int T ;
	scanf("%d" , &T);
	while(T--){
		int N;
		scanf("%d" , &N);
		memset(X , 0 , sizeof(X));
		memset(Y , 0 , sizeof(Y));
		ll Xav = 0, Yav = 0;
		forn(i , 0 , N){
			scanf("%d %d" , &X[i] , &Y[i]);
			Xav += X[i];
			Yav += Y[i];
		}
		int f = 0;
		if(Xav%N || Yav%N)
		{
			f=1;
 
		}
		Xav/=N;
		Yav/=N;
		map<ll , int > XM , YM;
     XM.clear();
     YM.clear();
		forn(i , 0 , N){
			if((Xav <X[i] && Xav > X[i]) || (Yav < Y[i] && Yav > Y[i])){
			f=1;
				break;
			}
			XM[Xav - X[i]]++;
			YM[Yav - Y[i]]++;
		}
	//	cout << f << endl;
	//	forn(i , 0 , N){
	//		if((XM[X[i] - 2 * (Xav - X[i])]==0 || (XM[X[i] + 2 * (Xav - X[i])]==0 ))
	//		|| (YM[Y[i] - 2 * (Yav - Y[i])]==0 || (YM[Y[i] - 2 * (Yav - Y[i])]==0 ))){
	//		     cout << X[i] << " " << Y[i] << endl;
	//			f=1;
	//		break;
	//		}
	//	}
     if(f)puts("no");
	else 	puts("yes");
	}
 
}

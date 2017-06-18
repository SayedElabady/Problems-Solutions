#include <bits/stdc++.h>
using namespace std;
#define MOD           1000000007
#define forn(i,s,n)   for(int i = s ; i < n ; i++)
#define mp            make_pair
#define pb            push_back  
#define st            first
#define nd            second
#define sz(v)         ((int)((v).size()))
const int SIZE=60006;
const int OO = (int)1e9;
const double PI = acos(-1);
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<int , int > Point;
typedef pair<pair<int, double> , int > iii;
int  arr[SIZE] , n;
ll S[SIZE];
ll get(ll sum){
	ll ret = 0;
	int it = 1;
	forn(i , 1 , n+1){

		while(S[it]-S[i-1]<sum && it+1<(n+1))it++;
		if(S[it]-S[i-1]>sum)it--;
	    if(it>=i) ret+=(it-i+1);
		//cout << i << " " << it << " " << ret << endl;
	}
	return ret;
}
void de(){
	vi ss ;
	

	forn(i , 0 , n){
		int s = 0;
		forn(j , i , n){
			s+=arr[j];
		ss.pb(s);	
		}
	}
	sort(ss.begin() , ss.end());
	forn(i , 0 , sz(ss))cout << ss[i] << " ";
}
int main(){
    int  k ;
    scanf("%d %d" , &n , &k);
    cin >> ws ;
    forn(i , 0 , n)scanf("%d" , &arr[i]);
	forn(i , 1 , n+1)S[i]=S[i-1]+arr[i-1];
	ll l = 0 , r = 50000000000000;
	if(k==n*(n+1)/2){
		printf("%lld\n",S[n]);
		return 0;
	}
	for(int i = 0 ; i < 600 ; ++i){
	     ll mid = (l+r+1)/2;
	     if(get(mid)<k){
	          l=mid;
	     }else {
	          r=mid-1;
	     }
	}
//	forn(i , 0 , 16)cout << get(i) << " ";
//	cout << endl;
//	de();
	l--;
	while(get(l)<k)l++;
	printf("%lld\n" , l);

}

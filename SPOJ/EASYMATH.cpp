#include <bits/stdc++.h>
using namespace std;
#define MOD           1000000007
#define forn(i,s,n)   for(int i = s ; i < n ; i++)
#define mp            make_pair
#define pb            push_back  
#define st            first
#define nd            second
#define sz(v)         ((int)((v).size()))
const int SIZE=100009;
const int OO = (int)1e9;
const double PI = acos(-1);
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<int , int > Point;
typedef pair<pair<int, double> , int > iii;

// this video explains it well.
// https://www.youtube.com/watch?v=sr6WgCLcgVM


bool isprime[SIZE];
int arr[6];
ll gcd(ll a,ll b)
{
    if(a%b) return gcd(b,a%b);
    return b;
}
ll lcm(ll a , ll b){
	return (a*b) / gcd(a,b);
}
ll get(int id, int cnt  , ll X , ll div  ){

		if(id == 5){
			if(cnt & 1)
					return - X / div;
			else 
					return   X / div;
		}
		ll ret = 0;
		ret += get(id + 1 , cnt + 1 , X , lcm(div , arr[id]));
		ret += get(id + 1 , cnt , X , div);
		return ret;

}
 int main(){   
 	
 	int T;
 	scanf("%d" , &T);
 	while(T--){
 		int n , m , a , d;
 		scanf("%d %d %d %d" , &n , &m , &a , &d);
 			arr[0]= a ;
 			forn(i , 1 , 5)arr[i]=arr[i-1]+d;
 		printf("%lld \n" , get(0,0,m,1) - get(0,0,n-1,1));


 	}

      
}

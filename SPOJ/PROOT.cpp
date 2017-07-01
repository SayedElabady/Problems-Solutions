#include <bits/stdc++.h>
#define _CRT_SECURE_NO_WARNINGS 1
using namespace std;
#define MOD           1000000007
#define forn(i,s,n)   for(int i = s ; i < n ; i++)
#define mp            make_pair
#define pb            push_back  
#define st            first
#define nd            second
#define sz(v)         ((int)((v).size()))
const int SIZE=500000;
const int OO = (int)1e9;
const double PI = acos(-1);
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<int , int > Point;
typedef pair<pair<int, double> , int > iii;
int primes[SIZE];
vi A;
int X[50000] , it = 0;

void sieve(){
	for(int i = 2 ; i < SIZE ; ++i){
		if(!primes[i]){
			for(int j = i + i ; j < SIZE ; j+=i)primes[j]=1;
		}
	}
	
	forn(i , 2 , SIZE){
		if(!primes[i])X[it++]=i;
	}
	
	
}
int power(ll a, int p, int mod)
{
	ll r = 1;
	while(p>0)
	{
		if(p&1) r = (r*a)%mod;
		p >>= 1;
		a = (a*a)%mod;
	}
	return r;
}
/*
ll power(ll x, ll y , ll mod)
{
    if (y == 0)
        return 1;
    else if (y%2 == 0)
        return (power(x, y/2 , mod)*1LL * power(x, y/2, mod)) % mod ;
    else
        return (x*1LL*power(x, y/2 , mod)*1LL*power(x, y/2 ,mod)) % mod;
}
*/
void fac(ll n){
     int lmt = (int)sqrt(n);
    for(int i = 0 ; i <it , primes[i]<lmt; i++){
    	if(n%X[i]==0){
    		A.pb(X[i]);
    		while(n%X[i]==0)n/=X[i];
    		lmt = (int)sqrt(n);
    	}
    }
 
     if(n>1)A.pb(n);
     
}
 
 int main(){   
sieve();
//forn(i , 0 , 30)cout << X[i]<< " ";
      ll P , n;
      
      while(scanf("%lld %lld" , &P , &n)==2 && P && n){
           A.clear();
           fac(P-1);
          // forn(i , 0 , sz(A))cout << A[i] << " " ;
           while(n--){
                ll x ;
                bool f = 0;
                scanf("%lld" , &x);
                forn(i , 0 , sz(A)){
                     ll q = power(x, ((P-1) / A[i]) , P);
                    if(q ==1){
                         f=1;
                         break;
                         
                    }
                }
                if(f)puts("NO");
                else puts("YES");
           }
      }
      
      
}

#include <bits/stdc++.h>
using namespace std;
#define MOD           1000000007
#define forn(i,s,n)   for(int i = s ; i < n ; i++)
#define mp            make_pair
#define pb            push_back  
#define st            first
#define nd            second
#define sz(v)         ((int)((v).size()))
const int SIZE=100009+6;
const int OO = (int)1e9;
const double PI = acos(-1);
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<int , int > Point;
typedef pair<pair<int, double> , int > iii;
bool isprime[SIZE+30];
int primes[SIZE+30] , it=0;
void sv(){
	for(int i = 2 ; i < SIZE ; i++){
		if(!isprime[i]){
			primes[it++]=i;
			for(int j = i + i ; j < SIZE ; j+=i){
				isprime[j]=1;
			}
		}
	}

}

 int main(){   
     sv();
 	int m , a , b;
 	while(scanf("%d %d %d" , &m , &a , &b) && m){
 	   //  cout << m <<endl;
 		int x =1, y=1;
 		for(int i= 0 ; primes[i] * primes[i] <= m ; ++i){
 				for(int j = i ; primes[i] * primes[j] <=m;++j){
 						if(b*primes[i]>=a*primes[j]&& 
 							primes[i] * primes[j]>x * y){
 							x = primes[i];
 							y = primes[j];
 						}

 				}

 		}
 		printf("%d %d\n" , x , y);

 	}

      
}

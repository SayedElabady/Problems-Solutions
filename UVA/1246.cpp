#include <bits/stdc++.h>
using namespace std;
#define MOD 1000000007
#define PI 3.14159265358979323846
#define forn(i,s,n) for(int i=s ; i<n ; i++)
#define fornr(i,s,n) for(int i=n ; i>s ; i--)
#define mp make_pair
#define pb push_back  
#define fr first
#define sc second
const int SIZE=100009 ;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef unsigned long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
int p[SIZE] , prim[10000009] , ok[100009];
void siev(){
  forn(i , 2 , 100000){
    if(!prim[i]){
      for(int j = i + i ; j < 100000 ; j+=i)prim[j]=1;

    }
  }
}
void facto(int n){
  int s=0;
  for(int i = 1 ; i * i <= n ; ++i){
    if(n % i == 0){s++;
    if(n/i!=i)s++;
    }

  }

ok[n]=s;

}
int  main(){
  siev();
  
 forn(i , 0 , 100009)facto(i);
prim[0]=prim[1]=1;
 int t;
 scanf("%d" , &t);
 while(t--){
  int l , h ;
  scanf("%d %d" , &l , &h);
 
  bool f =0;
  forn(i , l , h+1)
  if(prim[ok[i]]==0){
  if(f)printf(" ");
  printf("%d" , i);
  f = 1;
  }
  if(!f)printf("-1");
   printf("\n");


 }

}

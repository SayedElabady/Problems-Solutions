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
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
int A[SIZE] , B[SIZE] , n , m  , tmp[SIZE * 2 ] , tmp1[SIZE * 2 ] , H[0][SIZE * 2 ];
vi seq , seq1 , X;
vi ans[2];
int last[2];
// elfekra kolha en el diff yeb2a minimum 3la ad ma2dar f ba7wel ene a generate every possible diff
// w homa 2 cases ema abd2a b 0 aw b 1 fagrab kolo w a5tar ela7san 
// GET betgeb law habda2 b 0 EX :- 011010010 while ene ma7afz 3 eltarteb
// GET1 betgeb law habda2 b 1 
int GET(){
 
  int it1 = 1, it2 = 1 , i = 1;
  int st = 0 ; 
  while(it1 <= n && it2 <=m){
    while(A[it1]==st && it1<=n){
      seq.pb(it1);
      H[0][i++]=A[it1++];
    }
    while(B[it2]==st && it2<=m){
      seq.pb(it2+n);
      H[0][i++]=B[it2++];
    }
    st = 1 - st ;
 
  }
  while(it1<=n){ seq.pb(it1) ; H[0][i++]=A[it1++]; } 
  while(it2<=m){ seq.pb(it2+n) ; H[0][i++]=B[it2++]; }
  int dif = 0;
 
  forn(i , 2 , n+m+1)
  if(H[0][i]!=H[0][i-1]){
       dif++;
       // saved me from many TLE 
       ans[0].pb(i-1);
  }
  last[0]=(H[0][n+m]==0 ); 
  if(H[0][n+m] ){ dif++;ans[0].pb(n+m);}
return dif;
 
}
int GET2(){
 
  int it1 = 1, it2 = 1 , i = 1;
  int st = 1 ; 
  while(it1 <= n && it2 <=m){
    while(A[it1]==st && it1<=n){
      seq1.pb(it1);
      H[1][i++]=A[it1++];
    }
    while(B[it2]==st && it2<=m){
      seq1.pb(it2+n);
      H[1][i++]=B[it2++];
    }
    st = 1 - st ;
 
  }
  while(it1<=n){ seq1.pb(it1) ; H[1][i++]=A[it1++]; } 
  while(it2<=m){ seq1.pb(it2+n) ; H[1][i++]=B[it2++]; }
  int dif = 0;
 
  forn(i , 2 , n+m+1)
  if(H[1][i]!=H[1][i-1]){
       dif++;
       ans[1].pb(i-1);
  }
  if(H[1][n+m] ){dif++;ans[1].pb(n+m);}
  last[1]=(H[1][n+m]==0); 
return dif;
 
}
int  main(){
    freopen("input.txt","r",stdin);
  freopen("output.txt","w",stdout);
scanf("%d" , &n);
forn(i , 1 , n+1)scanf("%d" , A + i);
scanf("%d" , &m);
forn(i , 1 , m+1)scanf("%d" , B + i);
 
int HERE=0  , res=0 ;
int a = GET();
int b = GET2();
if(a < b || (a==b && last[0])){
  HERE = 0;
  res = a;
 forn(i , 0 , seq.size())printf("%d " , seq[i]);
 printf("\n");
}else {
     res = b;
 HERE = 1;
  forn(i , 0 , seq1.size())printf("%d " , seq1[i]);
  printf("\n");
}
 
  printf("%d\n" , res) ;
  forn(i , 0 , ans[HERE].size())printf("%d " , ans[HERE][i]);
 
 
}

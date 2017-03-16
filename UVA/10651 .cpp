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
const int SIZE=100001 ;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
int dp[100000];
int solve(int X){
  int &ret = dp[X];
  if(~ret)
      return ret;
  ret = __builtin_popcount(X);
  
  forn(i , 0 , 12){
  	// cout <<(X ^ (6 << i))<< " " <<(3<<i) << endl;
    if((X & (7<<i)) == (3<<i) && i < 10){
    
      int T = X ;
      T |= (4<<i);
      T &= ~(3<<i);
       
      ret = min(ret , solve(T));
    }
    if((X & (7<<i)) == (6<<i) && i < 10){
    //	cout << i <<" " <<  ((6 << i))<< endl;
      int T = X ;
     
      T |= (1 << i);
      T &= ~(6<<i);
     
      ret= min(ret , solve(T));

    }


  }

  return ret;

}
int  main(){
   //  freopen("input.txt","r",stdin);
  //freopen("output.txt","w",stdout);
int t ;
scanf("%d" , &t);
while(t--){
  string s ;
  cin >> s;
  memset(dp , -1 , sizeof dp);
  int A = 0;
  int base = 1;
  for(int i = 11 ; i >=0 ; --i)
  {
  
    if(s[i]=='o')
      A += base;
    base *= 2;
  }

printf("%d\n" , solve(A));
}


}

#include <bits/stdc++.h>
using namespace std;
#define MOD 1000000007
#define PI 3.14159265358979323846
#define forn(i,s,n) for(int i=s ; i<n ; i++)
#define fornr(i,s,n) for(int i=n ; i>s ; i--)
#define mp make_pair
#define pb push_back  
#define st first
#define nd second
const int SIZE=1003;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<double , double > Point;
typedef pair<pair<int, double> , int > iii;
double dp[2][SIZE][SIZE];
int dx[]={-1 , -1 , -1 , 0 , 0 , 1 , 1 , 1};
int dy[]={-1 , 0 , 1 , -1 , 1 , -1 , 0 , 1};
char B[15][15] , Played[15][15] , Ans[15][15];

int main(){
 int T ;
 scanf("%d" , &T);
 while(T--){
  int N ;
  scanf("%d" , &N);
  int A , B , C , Res = INT_MAX;
  for(A = 1 ; A <= N ; A++){
    for(B = 1 ;  B <= N ; B++){
         if(A*B >N)break;
      for(C = 1 ; ( C) <=N; C++){
           if(A*B*C>N)break;
        if(A * B * C == N)
          Res = min(Res , 2 * (A*B + B*C + A*C));
      }

    }


  }

printf("%d\n", Res);
 }


}

  

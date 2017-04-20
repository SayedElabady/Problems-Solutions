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
void fill(int n , int m){
  forn(i , 0 , n)
    forn(j , 0 , m)
      Ans[i][j]='.';
}
int get(int a , int b , int x){
  int ret = 0;
  forn(i , 0 , 8)
    if(B[a+dx[i]][b+dy[i]]=='*' && (a+dx[i])<x && (b+dy[i])<x)ret++;
    return ret;
}
void Touch(int x){
  forn(i , 0 , x)
    forn(j , 0 , x)
      if(B[i][j]=='*')
        Ans[i][j]='*';


}
int main(){
  int n  , f=0;
  scanf("%d" , &n);
  while(n--){
  	if(f)puts("");
  	cin>>ws;
  	f=1;
    int X;
    scanf("%d" , &X);
    fill(X, X);
    forn(i , 0 , X)
      forn(j , 0 , X)cin>>B[i][j];
     
      forn(i , 0 , X)
        forn(j ,0 , X)
          cin >> Played[i][j];
          forn(i , 0 , X)
            forn(j , 0 , X)
              {
               if(Played[i][j]!='x')continue;
                int P = get(i , j, X);
                if(B[i][j]=='*')
                  Touch(X);
                else if(Ans[i][j]=='.')
                Ans[i][j]=P+'0';
              }
              forn(i , 0 , X){
               forn(j , 0 , X)
                cout << Ans[i][j];
                puts("");
              }
  }


}

  

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
int done[2][SIZE][SIZE];
// the probability for the princess equals to the probability when she chooses to win and the dragon chooses to lose 
// for example the first test case.
//                          1  3                                      - princess choose level
//        1  2 (not win yet)       0 3 (win this ends here)           - dragon choose level
//    1  1 (black runs)  0 2 (white runs)                             - princess choose level
// and so on 
double solve(int idx , int w , int b){
  if(!w)return 0;
     if(!b){
          return idx;
     }
  double &ret = dp[idx][w][b];
  if(done[idx][w][b])return ret;
  done[idx][w][b]=1;
  if(idx) ret = (w*1.0/(w+b)) + (b*1.0/(b+w)) * solve(0 , w , b-1) * 1.0;
  if(idx == 0){
    ret = (b*1.0/(b+w)) * (w*1.0/(w+b-1)) * solve(1 , w-1 , b-1) * 1.0;
    if(b>=2)
    ret +=(b*1.0/(b+w)) *((b-1)*1.0 / (w+b-1)) * solve(1, w , b-2) * 1.0;

  }

return ret;

}

int main(){
 
 
 int W ,B;
 scanf("%d %d" , &W , &B);
 memset(done, 0 , sizeof done);
 memset(dp , -1 , sizeof dp);
 //cout << dp[0][0][0];
 printf("%0.9lf\n", solve(1 , W , B)); 
 }

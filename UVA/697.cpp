#include <bits/stdc++.h>
using namespace std;
#define MOD 1000000007
#define forn(i,s,n) for(int i=s ; i<n ; i++)
#define fornr(i,s,n) for(int i=n ; i>s ; i--)
#define mp make_pair
#define pb push_back  
#define st first
#define nd second
const int SIZE=1003;
const int OO = (int)1e9;
const double PI = acos(-1);
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
 double UP , D , L , B , P , DOWN , V ;
 double G = 32.2;
 int f = 0;
 int cnt = 1;
 while(cin >> UP >> D){
  if(f)puts("");
  f=1;
  if(UP==0)break;
    cin >> L >> B >>P >> DOWN >> V;
    double ans = 0;
    printf("Scenario %d:\n" , cnt++);
          printf("     up hill         %10.2lf sec\n", UP);
        printf("     well diameter   %10.2lf in\n", D);
        printf("     water level     %10.2lf in\n", L);
        printf("     bucket volume   %10.2lf cu ft\n", B);
        printf("     bucket ascent rate%8.2lf in/sec\n", P);
        printf("     down hill       %10.2lf sec\n", DOWN);
        printf("     required volume %10.2lf cu ft\n", V);
    forn(i , 0 ,(int)ceil((V/B) - 0.000000000001 )){
    	
    ans+= (UP + DOWN + (L / P) + sqrt((2*L) / (12*G) ) );
    L+=(12*12*12*B/(PI * (D/2)*(D/2)));
 //   cout << L << endl;
    }
     
    
          printf("     TIME REQUIRED   %10.2lf sec\n", ans);

 }


}

  

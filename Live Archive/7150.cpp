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
const int SIZE=1000003;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<double , double > Point;
typedef pair<pair<int, double> , int > iii;

int dx[]={-1 , -1 , -1 , 0 , 0 , 1 , 1 , 1};
int dy[]={-1 , 0 , 1 , -1 , 1 , -1 , 0 , 1};
// the idea is to create array to save the max from the begining and another array to save min from the end of the array 
// and compare at every index.. " Max Price till now with the min from the last "
double P , A , B , C , D ,  Values[SIZE] , MnArr[SIZE] , MxArr[SIZE];
int N;
double Get (int i){
  return P * (sin(A * (double) i + B) + cos(C * (double) i + D) + 2.0) ;
 }
int main(){
 
 while(scanf("%lf %lf %lf %lf %lf %d " , &P , &A , &B , &C , &D , &N)==6){
  MxArr[0]=-1e12;
  memset(Values , 0 , sizeof Values);
  forn(i , 1 , N + 1){
     Values[i] = Get(i);
    //Mn = min(Mn , G);
    MxArr[i] = max(MxArr[i-1] , Values[i]);


  }
  MnArr[N+1] =1e12;
  for(int i = N ; i >=1 ; --i){
  	MnArr[i]=min(MnArr[i+1] , Values[i]);
  }
  double ans = 0.0;
  forn(i , 1 , N){
  	ans = max(ans , MxArr[i] - MnArr[i]);
  }
  printf("%lf\n", ans );


 }

}

  

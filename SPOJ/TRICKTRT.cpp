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
const int SIZE=10003;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<double , double > Point;
typedef pair<pair<int, double> , int > iii;
int n ;
Point P[50009];
double dist(Point &A , Point &B){
  return (A.st - B.st) * (A.st - B.st) + (A.nd - B.nd) * (A.nd - B.nd) ;
}
double getCost(double X){
  Point Tmp;
  Tmp.st = X ;
  Tmp.nd = 0 ;
  double ans = 0.0;
  forn(i , 0 , n){
    ans = max(ans , dist(P[i] , Tmp));
  }
  return ans;
}
double ternery(double l , double r){
  int Counter = 64;
  while(Counter--){
    double left = ((2*l) + r ) / 3.0;
    double right = (l + (2*r)) / 3.0;
    if(getCost(left) < getCost(right))
      r = right ;
    else 
       l = left;


  }
  return (l+r) / 2.0;
}
int main(){
  while(scanf("%d" , &n) == 1 && n){
    double Min , Max;
    forn(i , 0 , n){
      scanf("%lf %lf" , &P[i].st , &P[i].nd);
      if(!i)Max = P[i].st , Min = P[i].st;
      if(P[i].st < Min) Min = P[i].st;
      if(P[i].st > Max) Max = P[i].st;
    }
    
    double Result = ternery(Min , Max);
    printf("%0.7lf %0.7lf\n", Result  , sqrt(getCost(Result)));


  }


  }








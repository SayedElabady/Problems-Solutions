#include <bits/stdc++.h>
#define forn(i,s,n) for(int i=s;i<n;i++)
#define fornr(i,s,n) for(int i=n ; i>=s;i--)
#define N 100001

#define EPS 1e-7
 
using namespace std;
bool visited[101]={false};
int n , counter=0 , l  , i , x , st;
int p , q , r , s , t , u;
double f(double x){
	
	return p*exp(-x)+q*sin(x) + r*cos(x) + s*tan(x) + t*x*x + u;
}

double fd(double x){
	
	return -p * exp(-x) + q * cos(x) - r * sin(x) + s/(cos(x) * sin(x)) + 2 * t * x ;
}

double newton(double x) {
	if(fd(0)==0 ) return 0;
	for(double x=0.5 ; ; ){
		double x1 = x -f(x)/fd(x);
		if(fabs(x1-x) < EPS) return x;
		x1=x;
		
	}
	
}

int main(){
  while (scanf("%d %d %d %d %d %d",&p,&q,&r,&s,&t,&u)!=EOF){
    if (f(0) * f(1) > 0){
      puts("No solution");
    } else {
      printf("%.4lf\n", bisection());
    }
  }
}

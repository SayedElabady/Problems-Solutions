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
// G(n) = f(2n) * f(2n + 1);
ll Base[2] , A[2][2] , Temp[2][2]={0};
void inti(){
  Base[0]=2;
  Base[1]=1;
  A[0][0]=2;
  A[0][1]=1;
  A[1][0]=1;
  A[1][1]=1;
}
void Mul(){
	memset(Temp , 0 , sizeof Temp);
forn(i , 0 , 2)
  forn(j , 0 , 2)
    forn(k , 0 , 2){
      (Temp[i][j]= Temp[i][j] + A[i][k]*A[k][j]);
      Temp[i][j]%=MOD;
    }
      memcpy(A , Temp , sizeof Temp);


}
void expo1(ll n){
  while(n>0){
    if(n&1){
    	ll X=0 , Y=0;
    	
      (X=Base[0]*A[0][0] + Base[1]*A[1][0]);
      (Y=Base[0]*A[0][1] + Base[1]*A[1][1]);
      Base[0]=X%MOD;
      Base[1]=Y%MOD;
    }
  
		Mul();
   n = n>>1;

  }

}
int main(){
 
 ll t , n;
 scanf("%lld" ,&t);

 while(t--){
  scanf("%lld" , &n);
  n= n - 1LL;
  
  inti();
  expo1(n);
  //cout << Base[0] << " " << Base[1] << endl;
  printf("%lld\n" , (Base[0]*Base[1])%MOD);

 }

  }








#include <bits/stdc++.h>
using namespace std;
#define MOD           1000000007
#define forn(i,s,n)   for(int i = s ; i < n ; i++)
#define mp            make_pair
#define pb            push_back  
#define st            first
#define nd            second
#define sz(v)         ((int)((v).size()))
const int SIZE=1000005;
const int OO = (int)1e9;
const double PI = acos(-1);
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<int , int > Point;
typedef pair<pair<int, double> , int > iii;

  char a[20][20] , b[20][20] , c[20][20] , d[20][20] , e[20][20] ,f[20][20];
  bool check(char a[][20] ,  char b[][20] , int n){
       bool f = 0;
       forn(i , 0 , n)
           forn(j , 0 , n)if(a[i][j]!=b[i][j])f=1;
           return (!f);
  }
 int main(){   
      int n , cnt = 1;
      while(cin >> n){
          memset(a , 0 , sizeof a);
          memset(b , 0 , sizeof b);
          memset(c , 0 , sizeof c);
          memset(d , 0 , sizeof d);
          memset(e , 0 , sizeof e);
          memset(f , 0 , sizeof f);
           forn(i , 0 , n)
                    cin >> a[i] >> b[i];
          // first check if they at first equal each other.
                    if(check(a , b , n)){
                         printf("Pattern %d was preserved.\n" , cnt++);
                         continue;
                    }
                    // rotate 90 
                    forn(i , 0 , n)
                         forn(j , 0 , n)
                              c[j][n-i-1]=a[i][j];
                    //check rotate 90 
                         if(check(c , b , n)){
                       printf("Pattern %d was rotated 90 degrees.\n" , cnt++);
                         continue;
                         }
                    // roatate 180 
                          forn(i , 0 , n)
                              forn(j , 0 , n)
                                 d[j][n-i-1]=c[i][j];
                    if(check(d , b , n)){
                         printf("Pattern %d was rotated 180 degrees.\n" , cnt++);
                         continue;
                    }
                    // rotate 270 
                    forn(i , 0 , n)
                              forn(j , 0 , n)
                                 e[j][n-i-1]=d[i][j];
                    if(check(e , b , n)){
                         printf("Pattern %d was rotated 270 degrees.\n" , cnt++);
                         continue;
                    }            
                     // reflection 
                     forn(i , 0 , n)
                         forn(j , 0 , n)
                              f[n-i-1][j]=a[i][j];
                    if(check(f , b , n)){
                          printf("Pattern %d was reflected vertically.\n" , cnt++);
                         continue;
                    }
                    // reflection with 90
                     forn(i , 0 , n)
                         forn(j , 0 , n)
                              c[j][n-i-1]=f[i][j];
                    //check rotate 90 with reflection 
                         if(check(c , b , n)){
                       printf("Pattern %d was reflected vertically and rotated 90 degrees.\n" , cnt++);
                         continue;
                         }
                    // reflection with 180
                     forn(i , 0 , n)
                         forn(j , 0 , n)
                              d[j][n-i-1]=c[i][j];
                    //check rotate 180 with reflection 
                         if(check(d , b , n)){
                       printf("Pattern %d was reflected vertically and rotated 180 degrees.\n" , cnt++);
                         continue;
                         }     
                         // reflection with 270
                     forn(i , 0 , n)
                         forn(j , 0 , n)
                              e[j][n-i-1]=d[i][j];
                    //check rotate 270 with reflection 
                         if(check(e , b , n)){
                       printf("Pattern %d was reflected vertically and rotated 270 degrees.\n" , cnt++);
                         continue;
                         }
               
               
               
               
               
                 printf("Pattern %d was improperly transformed.\n" , cnt++);

      }
}

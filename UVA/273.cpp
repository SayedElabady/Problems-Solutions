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
const int SIZE=100004 ;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
map < ii , int > mpp;
vi v[SIZE];
int n , u , q , t , A[SIZE];
// solution is simple.. just build the adjmatrix by checking if 2 lines intersects or not
// after matrix is built we run floyd to determine the connectivity of every pair of points
// RE-Calling the way to build the matrix from geeks4geeks library
struct Point
{
    int x;
    int y;
};

bool onSegment(Point p, Point q, Point r)
{
    if (q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) &&
        q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y))
       return true;
 
    return false;
}

int orientation(Point p, Point q, Point r)
{
  
    int val = (q.y - p.y) * (r.x - q.x) -
              (q.x - p.x) * (r.y - q.y);
 
    if (val == 0) return 0;  
 
    return (val > 0)? 1: 2; 
}
 

bool doIntersect(Point p1, Point q1, Point p2, Point q2)
{
    int o1 = orientation(p1, q1, p2);
    int o2 = orientation(p1, q1, q2);
    int o3 = orientation(p2, q2, p1);
    int o4 = orientation(p2, q2, q1);
 
    if (o1 != o2 && o3 != o4)
        return true;
 

    if (o1 == 0 && onSegment(p1, p2, q1)) return true;

    if (o2 == 0 && onSegment(p1, q2, q1)) return true;
    if (o3 == 0 && onSegment(p2, p1, q2)) return true;

    if (o4 == 0 && onSegment(p2, q1, q2)) return true;
 
    return false; 
}

int  main(){
   //  freopen("input.txt","r",stdin);
  //freopen("output.txt","w",stdout);
  int CON[]={0 , 0 , 2 , 4 , 6 , 8 , 10 , 12 , 14 , 16 , 18 , 20 , 22 , 24 , 26 , 28 , 30 , 32 , 34};
  int t;
  scanf("%d" , &t);
  bool f = 0;
  while(t--){
  	if(f)printf("\n");
  	f=1;
  	cin >> ws;
    int n;
    scanf("%d" , &n);
    Point P[4 * n + 5];
    for(int i = 0 ; i < 2*n ; i += 2)
    scanf("%d %d %d %d" , &P[i].x , &P[i].y , &P[i+1].x , &P[i+1].y);
    
    
    int adj[30][30]={0};
    memset(adj , 0 , sizeof adj);
    for(int i = 0 ; i < 2*n ; i+=2){
      for(int j = 0 ; j < 2 *n ;  j+=2)
      // this conditon was giving me WA
     // if(i!=j){
        if(doIntersect(P[i] , P[i+1] , P[j] , P[j+1])){
          adj[i][j]=1;
          adj[j][i]=1;
          
          }
      //}

    }
    for(int k =0 ; k<2*n;k+=2){
      for(int i = 0 ; i<2*n ; i+=2)
          for(int j = 0;j<2*n;j+=2)
            adj[i][j] |= (adj[i][k] & adj[k][j]); 
    }
    int X , Y;
    while(scanf("%d %d" , &X , &Y)==2 && X &&Y){
    	X = CON[X];
    	Y=CON[Y];
      if(adj[X][Y]||adj[Y][X])puts("CONNECTED");
      else puts("NOT CONNECTED");
    }



  }

}

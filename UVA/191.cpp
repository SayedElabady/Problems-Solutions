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
const int SIZE=150009 ;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
// the solution is that .. check the intersection with the four lines of the rect and another case if the line inside the rect.
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
int main(){

  int n;
  scanf("%d" , &n);
  forn(w , 0 , n){
    Point X , Y ;
    Point A[4];
    scanf("%d %d %d %d" , &X.x , &X.y , &Y.x , &Y.y);

  scanf("%d %d %d %d" , &A[0].x , &A[0].y , &A[2].x , &A[2].y);
 // if(w==30){
  //     cout << X.x << " " << X.y << " " << Y.x << " "<< Y.y;
   //    cout << A[0].x << " " << A[0].y << " " << A[2].x << " "<< A[2].y;
       
  //}
  
  A[1].x = A[2].x;
  A[1].y = A[0].y;
  A[3].x = A[0].x;
  A[3].y = A[2].y;
  
  bool ok = 0;
  // this line which gave me 3 WA mny and mnx was -1
  int mnx = OO , mxx = -1 , mny=OO , mxy=-1; 
  forn(j , 0 , 4){
       mnx = min(mnx , A[j].x);
    mxx = max(mxx , A[j].x);
    mny = min(mny , A[j].y);
    mxy = max(mxy , A[j].y);
   //    cout << A[j].x <<" " << A[j].y << endl;
  forn(i , 0 , 4 ){
    if(abs(i-j) % 2 !=0 && i!=j){

    ok |= doIntersect(X , Y , A[i] ,A[j] );
  }
  }
  }
 if(X.x <=mxx && X.x >=mnx && X.y <=mxy && X.y >=mny &&Y.x <=mxx && Y.x >=mnx && Y.y <=mxy && Y.y >=mny )ok=1;
 // if()ok=1;
  if(ok)puts("T");
  else puts("F");
  //if(w==n-1)puts("");
    

  }
  }






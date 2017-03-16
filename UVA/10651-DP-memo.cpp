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
const int SIZE=100009 ;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef unsigned long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
int p[SIZE] , prim[100009] , ok[100009];
map<string , int > mpp;
// parse the input and try every possible solution with memoization the calculated solution to prevent 
// overlapping , as the input is strings i used map to memoization
bool valid(int x){
  return (x <12 && x >=0);
}
int cnt(string s){
  int si = 0;
  forn(i , 0 , 12)if(s[i]=='o')si++;
  return si;
}
int solve(string s){
  if(mpp.count(s)!=0)
    return mpp[s];
  int &ret = mpp[s];
  ret = cnt(s);
  forn(i , 0 , 12){
 
 
    if(s[i]=='-'){
      if(valid(i+1) && valid(i+2))
        if(s[i+1]=='o' && s[i+2] =='o'){
          string t = s;
          t[i]='o';
          t[i+1]='-';
          t[i+2]='-';
          ret = min(ret , solve(t));
        }
        if(valid(i-1) && valid(i-2))
               if(s[i-1]=='o' && s[i-2] =='o'){
          string t = s;
          t[i]='o';
          t[i-1]='-';
          t[i-2]='-';
          ret = min(ret , solve(t));
        }
 
    }
 
 
  }
return ret;
 
 
}
int  main(){
 int n ;
 scanf("%d" , &n);
 while(n--){
 
  string s ;
  cin >> s;
  mpp.clear();
  int ans = solve(s);
  printf("%d\n" , ans );
 
 }
 
 
}

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
const int SIZE=10003;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
vi v[SIZE] , v1[SIZE];
string Path , Path1;
int Parent[SIZE] , Parent1[SIZE] , sz[SIZE] , sz1[SIZE];
// first of all we generate the 2 trees then get the canonical form of both of them.
// like the way of the video.

int n  , MAX_CNT , MAX_CNT1;
void solve(int idx = 0, int cnt =1 , int node=1){
  if(idx == n){
     MAX_CNT = cnt;
       return ;
       
  }
  if(Path[idx] == '1'){
   //   v[node].pb(Parent[node]);
    solve(idx+1 , cnt , Parent[node]);
  }else {
    Parent[cnt+1]=node;
    v[node].pb(cnt+1);
    solve(idx+1 , cnt+1 , cnt+1);
  }

}

void solve1(int idx = 0, int cnt =1 , int node=1){
  if(idx == n){
       MAX_CNT1 = cnt;
       return ;
       
  }
  if(Path1[idx] == '1'){
   //   v1[node].pb(Parent1[node]);
    solve1(idx+1 , cnt , Parent1[node]);
  }else {
    Parent1[cnt+1]=node;
    v1[node].pb(cnt+1);
    solve1(idx+1 , cnt+1 , cnt+1);
  }

}

string treeCanoincalForm(int i, int p)
{
    vector<string> childern;
 
    forn(j , 0 , v[i].size())
    if(v[i][j] != p)
        childern.push_back( treeCanoincalForm(v[i][j], i) );
 
    string nodeRep = "(";
    sort( childern.begin(), childern.end() );
    forn(k , 0 , childern.size())
        nodeRep += childern[k];
    nodeRep += ")";
 
    return nodeRep;
}
int main(){
     int T ;
     scanf("%d" , &T);
     while(T--){
     
 cin >> Path ;
 cin >> Path1;
 n = Path.size();
 memset(v , 0 , sizeof v);
 memset(v1 , 0 , sizeof v1);
 memset(Parent , 0 , sizeof Parent);
 memset(Parent1 , 0 , sizeof Parent1);


 if(MAX_CNT != MAX_CNT1){
      puts("different");
 }else {
     solve();
    solve1();
    string A , B ;
    A =  treeCanoincalForm(1 , -1);
    forn(Q , 0 , MAX_CNT +5) v[Q]=v1[Q];
    B=  treeCanoincalForm(1 , -1);
     
     if(A == B)puts("same");
     else puts("different");
      
 }
}
  }








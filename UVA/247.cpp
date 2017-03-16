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
const int SIZE=101 ;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
 
vi v[SIZE];
map<string , int > mpp;
vector<vi> comps;
ll idx = 0 , val[SIZE];
stack<ll> st;
ll ind[SIZE] , lowLink[SIZE] , inst[SIZE];
void init(){
  memset(lowLink , 0  , sizeof lowLink);
  memset(ind , -1 , sizeof ind);
  comps.clear();
  mpp.clear();
  memset(v , 0 ,sizeof v);
  idx = 0;
}
void tarjanSCC(int i) {
  lowLink[i] = ind[i] = idx++;
  st.push(i);
  inst[i] = 1;
for (int j = 0; j < v[i].size(); j++) {
  int k = v[i][j];
  if (ind[k] == -1) {
    tarjanSCC(k);
    lowLink[i] = min(lowLink[i], lowLink[k]);
  } else if (inst[k]) {
    lowLink[i] = min(lowLink[i], lowLink[k]);
  }
}
if (lowLink[i] == ind[i]) {
  vector<int> comp;
  int n = -1;
  while (n != i) {
    n = st.top();
    st.pop();
    comp.push_back(n);
    inst[n] = 0;
 
  }
  comps.push_back(comp);
 
 
}
 
}
int  main(){
	int cas = 0;
int n , m;
int ff = 0;
while(scanf("%d %d" , &n , &m)==2 && (n || m)){
	if(ff)printf("\n");
	ff=1;
  init();
  int ix = 0 ; 
  string tmp[n+1];
  forn(i , 0 , m){
    string x  ,y;
    cin >> x >> y ;
    int a , b;
    if(mpp.count(x)==0){
      mpp[x]=ix;
      tmp[ix]=x;
      a = ix++;
    }else {
      a = mpp[x];
    }
    if(mpp.count(y)==0){
      mpp[y]=ix;
      tmp[ix] = y;
      b = ix++;
    }else {
      b = mpp[y];
    }
    v[a].pb(b);
  }
printf("Calling circles for data set %d:\n" , ++cas);
 
for(int i = 0 ;  i<n ; ++i)
if(ind[i]==-1)tarjanSCC(i);
sort(comps.begin() , comps.end());
forn(i , 0 , comps.size()){
  bool f = 0;
  forn(j , 0 , comps[i].size()){
    if(f)printf(", ");
    cout << tmp[comps[i][j]];
    f=1;
  }
printf("\n");
}
 
}
}

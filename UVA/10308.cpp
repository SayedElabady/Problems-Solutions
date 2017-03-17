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
const int SIZE=10004 ;
const int OO = (int)1e9;
typedef vector<int> vi;
typedef long long int ll;  
typedef pair<int , int > ii;
typedef pair<pair<int, double> , int > iii;
// just the straightforward idea of the tree diameter

int mpp[SIZE][SIZE];
vi v[SIZE];
// i forgot that array and it gets me 2 TLE
int vis[SIZE];
void init(){
  memset(mpp , 0 , sizeof mpp);
  memset(v , 0 ,sizeof v);
	memset(vis , 0 , sizeof vis);
}
pair<ll , ll >  dia(int idx , int p = -1){
	vis[idx]=1;
  ll mxH[3]={-1 , -1 , -1 };
  ll diam = 0;
  forn(i , 0 , v[idx].size()){
    int ch = v[idx][i];
    if(ch!=p && !vis[ch]){
    	
      pair <ll , ll > chP = dia(ch , idx);
      diam = max(diam , chP.first);
	//	cout << ch << " " << idx << " " << chP.second << endl;
      mxH[0] = chP.second + mpp[idx][ch];
      sort( mxH , mxH + 3);


    }

  }
  forn(i , 0 , 3)mxH[i] = max(mxH[i] , 0LL );
  
  
  diam = max(diam , mxH[1] + mxH[2]);
  return mp(diam , mxH[2]);


}
int  main(){
   //  freopen("input.txt","r",stdin);
  //freopen("output.txt","w",stdout);
  int n =0, m =0, val=0 ;
  bool f = 1;
  string line;
	while(1){
    init();
    
    f = 0 ;
    
  while(!cin.eof()){
  	getline(cin , line);
  	istringstream parse(line);
    parse >> n;
    if(n==0){
    	break;}
    parse >> m;
    parse >> val;
  
    v[n].pb(m);
    v[m].pb(n);
    mpp[n][m] = val;
    mpp[m][n] = val;
    f=1;
	n= 0 , m = 0 , val = 0;
  }
	if(!f)return 0;
  printf("%d\n", dia(1).first);

}
}

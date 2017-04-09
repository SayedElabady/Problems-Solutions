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
int f , se;
vector <string> A[3];
bool get2(string s){
     forn(i , 0 , s.size()){
          if(s[i]=='/'){
               if(f==-1)f=i;
               else se = i;
          }
     }
     if(f!=-1 && se!=-1)return 1;
     return 0;
}
int contain(string s){
     forn(i , 0 , s.size())
     if(s[i]=='/')
          return i;

return -1;     
}
bool isVowel(char c){
     return (c == 'a' || c == 'e' || c == 'i' ||  c == 'o' || c == 'u' || c== 'y') ;  
}
int get(string s){
     int cnt = 0;
     forn(i , 0 , s.size())
          if(isVowel(s[i])){
               cnt++;
               while(isVowel(s[i]) && i<s.size())i++;
          }
          return cnt ;
     
}
int count(int N){
     int counter = 0;
     forn(i , 0 , A[N].size()){
          counter += get(A[N][i]);
     }
     return counter;
     
     
}
int main(){
  string line;
  while(getline(cin , line)){
       f= -1 , se= -1;
       memset(A , 0 , sizeof A);
    if(line =="e/o/i")break;
    stringstream ss;
    ss << line;
    string tmp ;
    int cnt = 0;
    while(ss>>tmp){
         int C = contain(tmp);
         if(get2(tmp)){
              A[0].pb(tmp.substr(0 , f));
              A[1].pb(tmp.substr(f+1 , se - f-1));
              A[2].pb(tmp.substr(se+1 , tmp.size() - se));
             // cout << A[0][0] << " " << A[1][0] << " " << A[2][0] << endl;
              cnt = 2;
             f=-1 , se=-1;
             
         }
    else if(C!=-1){
           
          A[cnt].pb(tmp.substr(0 ,C ));
          A[++cnt].pb(tmp.substr(C+1 , tmp.size()-C));
           
      }
      else A[cnt].pb(tmp);
    }
   
// cout << count(1)<< endl;
     if(count(0)!=5){
          puts("1");
     }else if(count(1)!=7){
          puts("2");
     }else if(count(2)!=5){
          puts("3");
     }else puts("Y");
  }

  }








#include <bits/stdc++.h>
using namespace std;
#define MOD 1e9+5
#define MAX 1e7+5
#define PI 3.141592653589793238462643383279502884197169399
#define forn(i,s,n) for(int i=s;i<n;i++)
#define fornr(i,s,n) for(int i=n ; i>s;i--)
#define N 10000009
#define INF 1e17
#define mp make_pair
#define pb push_back
typedef  long long int ll;
typedef vector<int> vi;
string s;
int pi[3000009];
void ans()
{


    for(int i =1, j = 0  ; i < s.size() ; ++i)
    {
        while(j > 0 && s[i]!=s[j] )
            j=pi[j-1];
        if(s[i]==s[j])
            ++j;
        pi[i]=j;


    }


}
string x;
int main()
{
    int t;
    scanf("%d ", &t);
    while(t--)
    {
        cin >> x;
        s="";
        for(int i = x.size()-1 ; i >=0 ; --i)s+=x[i];
        s+='&';
        s+=x;
        memset(pi, 0, sizeof pi);
        ans();
        bool flag=0;
        vector<int>v;
        v.pb(pi[s.size()-1]);
        if(v[0]==x.size())
        {
            puts("palindrome");
            flag=1;
        }
        if(flag)continue;
        for(int i = s.size()-1 ; i >= s.size()/2; --i)
        {
            if(pi[i]==0&&i-1 >=s.size()/2)
            {
                v.pb(pi[i-1]);
                if(pi[i-1]==x.size())
                {
                    puts("palindrome");
                    flag=1;
                }
            }
            if(flag)break;

        }
        if(flag)continue;

        s=x;
        s+='&';
        for(int i = x.size()-1 ; i >=0 ; --i)s+=x[i];
        memset(pi, 0, sizeof pi);
        ans();

        v.pb(pi[s.size()-1]);
        if(v[0]==x.size())
        {
            puts("palindrome");
            flag=1;

        }
        if(flag)continue;
        for(int i = s.size()-1 ; i >= s.size()/2; --i)
        {
            if(pi[i]==0&&i-1 >=s.size()/2)
            {
                v.pb(pi[i-1]);
                if(pi[i-1]==x.size())
                {
                    puts("palindrome");
                    flag=1;

                }
            }
            if(flag)break;
        }
        if(flag)continue;

        forn(i, 0, v.size())
        {
            forn(j, i+1,v.size())
            if(v[i]+v[j]==x.size())
            {
                puts("alindrome");
                flag=1;
            }
            if(flag)break;
        }
        if(flag)continue;
        puts("simple");
    }

}


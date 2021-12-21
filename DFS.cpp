#include <iostream>
#include <stack>
#include <list>
#include <iterator>
#include <vector>
#include <cstring>

using namespace std;

const int N = 100005;
int vis[N];
vector <int>nodes[N];

void dfs(int n){
    vis[n] = 1;
    cout << n;
    vector <int>::iterator itr;
    for(itr= nodes[n].begin(); itr!=nodes[n].end(); itr++){
        if(vis[*itr]){
            continue;
        }
        dfs(*itr);
    }
}



int main(){
    int n, m;
    cin >> n >> m;
    int x, y;
    memset(vis, 0, sizeof(vis));
    for (int i = 0; i < m; i++){
        cin >> x >> y;
        nodes[x].push_back(y);
        nodes[y].push_back(x);
    }
    //Starting Node = 1
    dfs(1);
    return 0;
}
#include <iostream>
#include <vector>
#include <iterator>
#include <queue>

using namespace std;

const int N = 100005;
vector <int> nodes[N];
int vis[N]; 


int main(){
    int n, m;
    // n = number of nodes
    // m = number of edges
    cin >> n >> m;
    for (int i = 0; i<n; i++){
        vis[i] = 0;
    }

    int x, y;
    for (int i=0; i<m; i++){
        cin >> x >> y;
        nodes[x].push_back(y);
        nodes[y].push_back(x);
    }
    queue <int> q;
    q.push(1);
    vis[1] = true;
    while(!q.empty()){
        int present = q.front();
        q.pop();
        cout << present << " ";
        vector <int>:: iterator itr;
        for(itr = nodes[present].begin(); itr != nodes[present].end(); itr++){
            if(vis[*itr]){
                continue;
            }
            vis[*itr] = 1;
            q.push(*itr);
        }
    }

}
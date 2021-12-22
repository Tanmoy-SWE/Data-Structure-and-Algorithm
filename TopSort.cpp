#include <iostream>
#include <list>
#include <vector>
#include <queue>
#include <iterator>

using namespace std;

const int N = 10005;
vector <int> adj[N];
vector <int> inDeg(N,0);
queue <int> q;

int main(){
    int n, m;
    cin >> n >> m;
    int x, y;
    for(int i = 0; i<m; i++){
        cin >> x >> y;
        adj[x].push_back(y);
        inDeg[N]++;
    }
    for(int i=0; i<n; i++){
        if(inDeg[i]==0){
            q.push(i);
        }
    }
    while(!q.empty()){
        int node = q.front();
        q.pop();
        cout << node << " ";
        vector <int>::iterator itr;
        for(itr=adj[n].begin(); itr!=adj[n].end(); itr++){
                inDeg[*itr]--; 
                if(inDeg[*itr]){
                    q.push(*itr);
                }

        } 
    }



    return 0;
}
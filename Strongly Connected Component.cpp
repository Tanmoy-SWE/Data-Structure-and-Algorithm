#include <bits/stdc++.h>
#define N 100005

using namespace std;
int n, m;

struct Node {
  vector <int> adj;
  vector <int> rev_adj;
};

Node g[N];

stack <int> S;

//array to identify visited nodes.
bool visited[N];
int component[N];
vector<int>components[N];
int numComponents;

void dfs_1(int x) {
  visited[x] = true;
  for (int i = 0; i < g[x].adj.size(); i++) {
    if (!visited[g[x].adj[i]]) dfs_1(g[x].adj[i]);
  }
  S.push(x);
}

void dfs_2(int x) {
  printf("%d ", x);
  component[x] = numComponents;
  components[numComponents].push_back(x);
  visited[x] = true;
  for (int i = 0; i < g[x].rev_adj.size(); i++) {
    if (!visited[g[x].rev_adj[i]]) dfs_2(g[x].rev_adj[i]);
  }
}

void SCC() {

  //Running the first dfs to push the objects
  for (int i = 0; i < n; i++)
    if (!visited[i]) dfs_1(i);
  //Making visited array false to run new dfs
  for (int i = 0; i < n; i++)
    visited[i] = false;

  while (!S.empty()) {
    int v = S.top();
    S.pop();
    if (!visited[v]) {
      printf("SCC %d: ", numComponents);
      dfs_2(v);
      numComponents++;
      printf("\n");
    }
  }
}

int main() {

  cin >> n >> m;
  int a, b;
  while (m--) {
    cin >> a >> b;
    g[a].adj.push_back(b);
    g[b].rev_adj.push_back(a);
  }
  SCC();
  printf("Total number of SCCs: %d\n", numComponents);

  return 0;
}

/*
8 10
0 1
1 2
2 0
2 3
3 4
4 5
5 6
6 7
4 7
6 4
*/

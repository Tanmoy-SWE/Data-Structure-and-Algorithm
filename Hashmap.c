#include <stdio.h>
#include <stdbool.h>
#include <conio.h>


_Bool solveMazeUtil(
    int n, char maze[n][n], int x,
    int y, char sol[n][n]);


void printSolution(int n, char sol[n][n])
{
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            printf("%c", sol[i][j]);
        printf("\n");
    }
}

_Bool isSafe(int n, char maze[n][n], int x, int y)
{
    if (
        x >= 0 && x < n && y >= 0
        && y < n)
        return true;

    return false;
}

_Bool solveMaze(int n, char maze[n][n])
{
    char sol[n][n];
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            sol[i][j]=maze[i][j];
        }

    int x=0, y=0;

      for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(maze[i][j]=='S'){
                x = i;
                y = j;
                goto TheEnd;
            }
        }
    }
    TheEnd :


    if (solveMazeUtil(
            n, maze, x, y, sol)
        == false) {
        printf("Solution doesn't exist");
        return false;
    }

    printSolution(n, sol);
    return true;
}
}

_Bool solveMazeUtil(int n,
    char maze[n][n], int x,
    int y, char sol[n][n])
{
    if (maze[x][y] == 'E') {
        sol[x][y] = 'E';
        return true;
    }
    if (isSafe(n, maze, x, y) == true) {
          if (sol[x][y] == '.')
              return false;

        sol[x][y] = '.';
        if (solveMazeUtil(n,
                maze, x + 1, y, sol)
            == true)
            return true;
        if (solveMazeUtil(n,
                maze, x, y + 1, sol)
            == true)
            return true;
        if (solveMazeUtil(n,
                maze, x - 1, y, sol)
            == true)
            return true;
        if (solveMazeUtil(n,
                maze, x, y - 1, sol)
            == true)
            return true;

        sol[x][y] = '.';
        return false;
    }

    return false;
}


int main()
{
    FILE * fp;
    fp = fopen("big_maze.txt","r");
    FILE * fp1;
    char maze[1000][1000];
    int i,j,size;

    for(i=0; i<1000; i++) {
        for(j=0; j<1000; j++) {
            fscanf(fp,"%c",&maze[i][j]);
            if(maze[i][j]=='\n'){
                size = j;
                goto breakBoth;
            }
        }
    }
    breakBoth:
         for(i=0; i<size; i++) {
        for(j=0; j<size; j++) {
            fscanf(fp,"%c",&maze[i][j]);
        }
    }
     for(i=0; i<size; i++) {
        for(j=0; j<size; j++) {
            printf("%c",maze[i][j]);
        }
        printf("\n");
    }

    solveMaze(size, maze);

    return 0;
}

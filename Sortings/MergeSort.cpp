#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void merge(int a[], int first, int mid, int last){
    int b[50];
    int i,j,k;
    i = first;
    j = mid + 1;
    k = first;
    while(i<=mid && j<=last){
        if(a[i]<=a[j]){
            b[k++]=a[i++];
        }
        else{
            b[k++]=a[j++];
        }
    }
    if(i>mid){
        while(j<=last){
            b[k++]= a[j++];
        }
    }
    else{
        while(i<=mid){
            b[k++]=a[i++];
        }
    }
    for(i=first; i<=last; i++){
        a[i]=b[i];
    }

}


void mergesort(int a[], int first, int last){
    int mid;
    if(first < last){
        mid = (first+last)/2;
        mergesort(a,first,mid);
        mergesort(a,mid+1,last);
        merge(a,first,mid,last);
    }
}


void ShowArray(int arr[], int n){
    for(int i=0; i<n; i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(){
    int a[40], n, i;
    printf("Enter size of array : ");
    scanf("%d",&n);
    printf("Enter elements : ");
    for(i=0; i<n; i++){
        scanf("%d",&a[i]);
    }
    mergesort(a,0,n-1);
    ShowArray(a,n);
    return 0;
}


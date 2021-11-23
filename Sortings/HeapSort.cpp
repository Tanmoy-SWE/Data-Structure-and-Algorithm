#include <iostream>

using namespace std;

void heapify(int arr[], int n, int i){
    int largest_node = i;
    int left_child = 2*i;
    int right_child = 2*i+1;
    //If left child is larger than root
    if (left_child < n && arr[left_child]>arr[largest_node]){
        largest_node = left_child;
    }
    //If right child is larger than root
    if (right_child < n && arr[right_child]>arr[largest_node]){
        largest_node  = right_child;
    }

    //Recursively Heapify the Dangered sub-tree
    if(largest_node != i){
        swap(arr[i], arr[largest_node]);
        heapify(arr,n, largest_node);
    }
}

void HeapSort(int arr[], int n){
    //Building max heap
    for(int i =n/2; i>=1; i--){
        heapify(arr,n,i);
    }

    // Heap sort
    for (int i = n-1; i >= 1; i--) {
      swap(arr[1], arr[i]);
      //Heapify root element to get highest element at root again
      heapify(arr, i, 1);
    }
}

void ShowArray(int arr[], int n){
    for(int i=1; i<n; i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}


int main(){
    int arr[]= {-1,5,8,8,6,9,12,11,10};
    int n = sizeof(arr)/sizeof(arr[1]);
    ShowArray(arr,n);
    HeapSort(arr,n);
    ShowArray(arr,n);
    return 0;
}

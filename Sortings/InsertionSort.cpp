#include <iostream>

using namespace std;

void insertionSort(int arr[], int n){
    int i = 0;
    for(i = 1; i < n; i++){
        int current = arr[i];
        int j = i - 1;
        while (j>=0 && current<arr[j]){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
    }
}

void printArray(int arr[], int n){
    int i = 0;
    cout << "Sorted array : ";
    for (i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}



int main(){

    int arr[] = {5, 4, 6, 1, 6, 9, 8};
    int n = sizeof(arr)/sizeof(arr[0]);
    insertionSort(arr, n);
    printArray(arr, n);

    return 0;
}

#include <iostream>
#include <vector>
using namespace std;


//nlog(n) complexity te korlam
//Eta recursion diyeo kora jay
void getSum(int arr[], int size, int n){
    for(int i=0; i<size; i++){
        int start = i;
        int end = size;
        int rem = n - arr[i];
        while(start<end){
            int mid = (start + end)/2;
            if(arr[mid]<rem){
                start = mid + 1;
            }
            else if(arr[mid]>rem){
                end = mid - 1;
            }
            else{
                cout << arr[i] << " " << arr[mid];
                return;
            }
        }
    }
    cout << "No valid sum" << endl;
}



int main() {
    int arr[100005];
    int size;
    cout << "Enter size of the array : " << endl;
    cin >> size;
    cout << "Enter the array elements : " << endl;
    for(int i=0; i<size; i++){
        cin >> arr[i];
    }
    int seek;
    cout << "Enter the sum you are seeking : " << endl;
    cin >> seek;
    getSum(arr,size,seek);
    return 0;
}

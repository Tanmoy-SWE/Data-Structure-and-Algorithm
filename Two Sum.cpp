#include <iostream>
#include <vector>
using namespace std;

vector <int, int> getSum(int arr[], int size, int n){
    for(int i=0; i<size; i++){
        int start = i;
        int end = size - 1;
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
                return {i, mid};
            }
        }
    }
    return {-1, -1};
}



int main() {
    int arr[100005];
    int size;
    cout << "Enter size of the array : " << endl;
    cin >> size;
    cout << "Enter the array elements : " << endl;
    for(int i=0; i<15; i++){
        cin >> arr[i];
    }
    int seek;
    cout << "Enter the sum you are seeking : " << endl;
    cin >> seek;
    vector <int, int> ans;
    ans = getSum(arr,size,seek);
    return 0;
}


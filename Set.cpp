#include <iostream>
#include <string>
#include <sstream>
#include <array>


using namespace std;

int size(const int set[]);
string stos(const int set[]);
int* setOr (const int set1[], const int set2[]);
int* setAnd(const int set1[], const int set2[]);
int* setDiff(const int set1[], const int set2[]);
bool contains(const int set[], int elt);
void trimSet(int*& set);
int setCard(const int set1[]);
int setCardUsed(const int set1[]);

int main(){
	int size1, size2, size3;
	cout << "Enter size and elements of set A -> ";
	cin >> size1;
	int* arrayA = new int[size1+1];
	arrayA[0] = size1;
	for (int counter = 1; counter < size1+1; counter++){
		cin >> arrayA[counter];
	}
	cout << "Enter size and elements of set B -> ";
	cin >> size2;
	int* arrayB = new int[size2+1];
	arrayB[0] = size2;
	for (int counter = 1; counter < size2+1; counter++){
		cin >> arrayB[counter];
	}
	cout << "Enter size and elements of set C -> ";
	cin >> size3;
	int* arrayC = new int[size3+1];
	arrayC[0] = size3;
	for (int counter = 1; counter < size3+1; counter++){
		cin >> arrayC[counter];
	}



	// cardinality = size(arrayA);


	string a = stos(arrayA);
	cout << "A = " << a << endl;
	string b = stos(arrayB);
	cout << "B = " << b << endl;
	string c = stos(arrayC);
	cout << "C = " << c << endl;


	int* unionset = setOr(arrayA, arrayB);
	cout << "A u B = " << stos(unionset) << endl;

	int* intersectionset = setAnd(arrayA, arrayB);
	cout << "A n B = " << stos(intersectionset) << endl;

	int* diffset = setDiff(arrayA, arrayB);
	cout << "A - B = " << stos(diffset) << endl;

	int* diffset1 = setDiff(arrayA, arrayB);
	int* diffset2 = setDiff(arrayB, arrayA);
	int* unionset2 = setOr(diffset1, diffset2);
	cout << "(A - B) u (B - A) = " << stos(unionset2) << endl;
	cout << "|A u B| = " << setCard(unionset) << endl;
	int result = setCard(arrayA) + setCard(arrayB) - setCardUsed(intersectionset);
	cout << "|A| + |B| - |A n B| = " << result << endl;
	int* temp = setOr(arrayB, arrayC);
	int* resultset = setAnd(arrayA, temp);
	cout << "A n (B u C) = " << stos(resultset) << endl;
    temp = setAnd(arrayA, arrayC);
	resultset = setOr(intersectionset, temp);
	cout << "(A n B) u (A n C) = " << stos(resultset) << endl;
	resultset = setAnd(temp, arrayB);
	cout << "A n B n C = " << stos(resultset) << endl << endl;
	int n;
	cout << "Enter an integer : ";
	cin >> n;
	bool present = contains(resultset, n);
	cout << "Is " << n << " in A n B n C ? ";
	if (present == 1){
        cout << "true";
	}
	else{
        cout << "false";
	}

	return 0;
}


int size(const int set[]){
	int card = set[0];
	return card;
}

string stos(const int set[]){
	int i = 2;
	stringstream sout;
	sout << "{" << set[1];
	while (i <= set[0]){
		sout << ", " << set[i];
		i++;}
	sout << "}";
	return sout.str();
}

bool contains(const int set[], int elt){
	for (int i = 1; i < set[0]+1; i++){
		if (elt == set[i]){
			return true;
		}
	}
	return false;
}

void trimSet(int*& set){
	int* temp = new int[set[0]+1];
	delete[] set;
	set = temp;
}

int* setOr (const int set1[], const int set2[]){
	int *arrayU = new int [set1[0]+set2[0]+1];
	arrayU[0] = 0;
	int i = 1;
	for (i; i < set1[0]+1; i++){
		arrayU[i] = set1[i];
		arrayU[0]++;}
	int f = i;
	for (int i = 1; i < set2[0]+1; i++){
		if (contains(set1, set2[i]) == false){
		arrayU[f] = set2[i];
		f++;
		arrayU[0]++;}}
	// trimSet(arrayU); //FIX THIS
	return arrayU;
}

int* setAnd(const int set1[], const int set2[]){
	int width;
	if (set1[0] > set2[0]){
		width = set2[0];}
	else{
		width = set1[0];}

	int *ans = new int [width + 1];
	ans[0] = 0;
	int j = 1;
	for (int i = 1; i < set1[0]+1; i++){
		if (contains(set2, set1[i]) ){
			ans[j] = set1[i];
			j++;
		}
	}
	ans[0] = j - 1;
	// trimSet(ans); //FIX

	return ans;
}

int* setDiff(const int set1[], const int set2[]){
	int width = set1[0];
	int *diff = new int [width]; //+1? // need to trim
	diff[0]= 0;
	int j = 1;
	for (int i = 1; i <set1[0]+1; i++){
		if (contains(set2, set1[i]) == false){
			diff[j] = set1[i];
			diff[0]++;
			j++;}
	}

	return diff;
}

//Function to identify Cardinality
int setCard(const int set1[]){

    int i , j, cardinality=1, temp[100005];
    if(set1[0]==1){
        return 0;
    }
    for(i= 1; i<set1[0]+1; i++){
        for(j=i+1; j<set1[0]+1; j++){
            if(set1[i]==set1[j]){
                continue;
            }
            if(j==set1[0]){
                cardinality++;
            }
        }
    }
    return cardinality;

}

int setCardUsed(const int set1[]){

    int i , j, cardinality=1, temp[100005];
    int size1 = sizeof(set1)/sizeof(set1[0]);
        size1--;
        if(size1==1 && set1[0]==0){
        return 0;
    }
    for(i= 0; i<size1; i++){
        for(j=i+1; j<size1; j++){
            if(set1[i]==set1[j]){
                continue;
            }
            if(j==size1){
                cardinality++;
            }
        }
    }
    return cardinality;

}

#include<iostream>
using namespace std;

void sumByReference(int *n){
     *n = (*n*(*n+1))/2;
}

int sumByValue(int n){
    return ((n*(n+1))/2);
}

int main(){
    int number;
    cout << "Please enter the value of num:";
    cin >> number;
    
    int val = sumByValue(number);
   
    
    cout << "num = ";
    cout << number; 
    cout << " before sumByValue\n"; 
    cout << "Value returned by sumByValue: ";
    cout << val;
    cout << "\n";
    cout << "num = ";
    cout << number; 
    cout << " before sumByReference\n";
    sumByReference(&number); 
    cout << "num = ";
    cout << number; 
    cout << " after sumByReference\n";
    

    
   
}

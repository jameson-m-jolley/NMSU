#include <iostream>
using namespace std;

void msort(int arr[],int low,int high){
    int dif = high - low;
    int mid = low + (high - low) / 2;
    if(dif > 1){

       cout << "low: " <<low<< " high:"<< high << " mid:" << mid<< "\n"; 
       msort(arr,low,mid);
       msort(arr,mid,high);
    

    int k=low;
    int index1 =0;
    int index2 =0;
    int temp[high];

    //merging the 
    while(index1 < (mid - low) && index2 < (high -mid)){

        if(arr[index1]> arr[index2]){
            temp[k++]= arr[index1];
            index1++;
        }else{
            temp[k++]=arr[index2];
            index2++;
        }
    }

    //overide the arr with the new vals
    for(int i=low; i<k; i++ ){
       xdß∑å´´´´´
    }
   }

}

void swap(int a[], int index1, int index2){
    int wap = a[index1]; 
    a[index1]= a[index2];
    a[index2]= wap;
}

int main(){
    int a[10] = {1,4,3,2,5,6,2,4,6,7};
    
    cout << "list befor merge sort\n";
    for(int i=0; i<10; i++ ){
        cout << a[i];
    }
    cout<< "\nsorting...\n";

    msort(a,0,9);

    for(int i=0; i<10; i++ ){
        cout << a[i];
    }

    cout << "\nlist after merge sort\n";

    

}
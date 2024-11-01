#include<stdio.h>


int* copyarr(int* arr){
    int size = sizeof(*arr)/sizeof(int);
    int narr[size];
    for(int i = 0; i < size; ++i ){
        narr[i] = *(arr +i);
    }
    return &narr;
}

int* reversearr(int* arr){
    int size = sizeof(*arr)/sizeof(int);
    int narr[size];
    for(int i = 0; i < size; ++i ){
        narr[i] = *(arr +(size));
    }
    return &narr;
}



int main(){

    int arr[]= {1,2,3,4,5,6,7,8,9};

    printf("the size of this array is %lu\n",sizeof(arr)/sizeof(int));

    //printing the array 
    for(int i = 0; i < sizeof(arr)/sizeof(int); ++i ){
        printf("index %d is %d\n", i, arr[i] );
    }

    //computing the sumation
    int sum =0;
    for(int i = 0; i < sizeof(arr)/sizeof(int); ++i ){
        sum += arr[i];
    }
    printf("the sum is %d\n",sum );

    int* nnarr = copyarr(&arr);
    int narr[sizeof(nnarr)+1];
    narr[0] = *nnarr;


    for(int i = 0; i < sizeof(narr)/sizeof(int); ++i ){
        printf("index %d is %d\n", i, arr[i] );
    };
    

    nnarr = reversearr(&arr);
    narr[0] = *nnarr;
    printf("------------reversed--------\n");

    for(int i = 0; i < sizeof(narr)/sizeof(int); ++i ){
        printf("index %d is %d\n", i, arr[i] );
    };
    


    //reverse an array



}


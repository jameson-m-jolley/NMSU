#include"distinct.h"
#include<iostream>
using namespace std;


int main()
{
    /* 
    Input three integer values: 2 4 5
    The number of distinct values is 3
    Input three character values: a b a
    The number of distinct values is 2
    Input three floating-point values: 1.0 1.0 1.0
    The number of distinct values is 1
    
    
     */
    cout<< "Input three integer values: 2 4 5 \n The number of distinct values is"<< distinct(2,4,5)<<"\n";
    cout<< "Input three character values: a b a \n The number of distinct values is "<< distinct('a','b','a')<<"\n";
    cout<< "Input three floating-point values: 1.0 1.0 1.0 \n The number of distinct values is "<< distinct(1.0,1.0,1.0)<<"\n";

    return 0;
}//end of main

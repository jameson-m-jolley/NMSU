
#include <stdio.h>



int GCD(int a , int b){
//     function gcdIter(a,b)
//     while(b != 0)  
//         t = b
//         b = a%b
//         a = t
//     end   
//       return a 
//     end
    while(b != 0){
        int t=b;
        b = a%b;
        a=t;
    }
    return a;    
}

int LCM(int a, int b){
    return (a*b / GCD(a,b));
}

int main(){

    int option;
    printf("Enter a number:[1 for GCD] or [2 for LCM]\n");
    scanf("%d",&option);


    int num1;
    int num2;

    printf("Enter a 2 numbers\n");
    scanf("%d",&num1);
    scanf("%d",&num2);

    if(option == 1){
        printf("GCD = %d \n",GCD(num1,num2));
    }else if(option == 2){
        printf("LCM = %d \n",LCM(num1,num2));
    }else{
        printf("%d is not a valid option",option);
    }

}
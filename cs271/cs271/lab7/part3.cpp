
#include <iostream>
using namespace std;
/*
Write a function called totalCost that takes three integer parameters (shipping cost, cost of one box,
and number of boxes purchased) and returns the total cost which is computed using the following formula:
shipping cost + (number of boxes purchased) * (cost of one box).
    Default values for the parameters are the following:
    shipping cost is 0 dollars,
    cost of one box is 4 dollars,
    number of boxes is 1.
*/
int totalCost(int shipingCost = 0 , int costOfOne = 4, int numofboxes = 1){
 return shipingCost + (numofboxes * costOfOne);
}
int main(){

    /*
        The total cost of $8 shipping, default cost of one box (4),
        and default number of boxes purchased (1) is: $12
        The total cost of $8 shipping, $5 cost of one box,
        and default number of boxes purchased (1) is: $13
        The total cost of $8 shipping, $5 cost of one box,
        and 10 boxes purchased is: $58
    */
    cout << "The default total cost is: " << totalCost()<<"\n";
    cout << "The total cost of $8 shipping, default cost of one box (4),\nand default number of boxes purchased (1) is:"<< totalCost(8)<<"\n";
    cout << "The total cost of $8 shipping, $5 cost of one box,\nand default number of boxes purchased (1) is;" << totalCost(8,5)<<"\n";
    cout << "The total cost of $8 shipping, $5 cost of one box,\nand 10 boxes purchased is: " << totalCost(8,5,10)<< "\n";

}
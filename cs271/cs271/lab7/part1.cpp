
#include <iostream>
using namespace std;

float areaOfCircle(int r){
    return 3.14159*(r*r);
}

inline void loop(){
 //get the input from the user
 //
    int r;
    cout << "Enter the radius of your circle (-1 to end):";
    cin >> r;

    switch(r){
        case -1:
            break;
        default:
            cout << "Area of circle with radius ";
            cout << r;
            cout << " is ";
            cout << areaOfCircle(r);
            cout << "\n";
            loop();
    }
}

int main(){
  // enters into the recusive function loop
  loop();  
}



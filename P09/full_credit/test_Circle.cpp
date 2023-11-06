#include "Circle.h"
#include <iostream>

using namespace std;

int main(){
    Circle c {4.0};
    cout << c.name() << " has area of " << c.area() << endl;
    return 0;
}
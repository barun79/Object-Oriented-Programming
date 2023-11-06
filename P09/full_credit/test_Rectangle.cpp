#include "Rectangle.h"
#include <iostream>


int main(){
    Rectangle r{5.0, 2.0};
    std::cout << r.name() << " has area of " << r.area()<< std::endl;
    return 0;
}
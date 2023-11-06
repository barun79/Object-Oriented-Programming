#include <iostream>
#include "Shape.h"

int main(){
    Shape s{};
    std::cout << s.name() << " with it's area " << s.area() << std::endl;
    return 0;
}
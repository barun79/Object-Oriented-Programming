#include "Circle.h"

Circle::Circle(double radius): _radius{radius}{
    if (radius < 0){
        throw std::runtime_error{"Invalid radius"};
    }
}

std::string Circle::name(){
    return "Circle";
}

double Circle::area(){
    return M_PI * pow(_radius, 2);
}
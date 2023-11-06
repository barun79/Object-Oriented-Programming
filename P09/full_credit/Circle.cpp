#include "Circle.h"
#include <cmath>

using namespace std;

Circle::Circle(double radius): _radius{radius}{
    if (radius < 0){
        throw runtime_error{"Invalid radius"};
    }
};

string Circle::name(){
    return "Circle";
}

double Circle::area(){
    return M_PI * pow(_radius, 2);
}
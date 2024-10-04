#ifndef CIRCLE_H
#define CIRCLE_H

#include <iostream>
#include <stdexcept>
#include <cmath>

class Circle{
    public:
        Circle(double radius);
        std ::string name();
        double area();
    private:
        double _radius;  
};

#endif
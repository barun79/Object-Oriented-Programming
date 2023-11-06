#ifndef CIRCLE_H
#define CIRCLE_H

#include <iostream>
#include <stdexcept>
#include <cmath>
#include "Shape.h"

class Circle: public Shape{
    public:
        Circle(double radius);
        std ::string name() override;
        double area() override;
    private:
        double _radius;  
};

#endif
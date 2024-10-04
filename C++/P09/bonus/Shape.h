#ifndef SHAPE_H
#define SHAPE_H

#include <iostream>

class Shape{
    public:
        virtual std::string name() = 0;
        virtual double area() = 0;
        virtual std::string to_string();
};

#endif
#ifndef SHAPE_H
#define SHAPE_H

#include <iostream>

class Shape{
    public:
        std::string name();
        double area();
        std::string to_string();
};

#endif
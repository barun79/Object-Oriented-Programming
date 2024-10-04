#ifndef RECTANGLE_H
#define RECTANGLE_H

#include <iostream>
#include <stdexcept>

class Rectangle{
    public:
        Rectangle(double height, double width);
        std::string name();
        double area();
    private:
        double _height;
        double _width;
};

#endif
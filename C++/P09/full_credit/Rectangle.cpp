#include "Rectangle.h"

Rectangle::Rectangle(double height, double width) : _height{height}, _width{width}{
    if (height < 0 || width < 0){
        throw std::runtime_error("Invalid input");
    }
}

std::string Rectangle::name(){
    return "Rectangle";
}

double Rectangle::area(){
    return _height * _width;
}

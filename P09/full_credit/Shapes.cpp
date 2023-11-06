#include <iostream>
#include <vector>

#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"

int main(){
    std::vector<Shape*>shapes;
    shapes.push_back( new Circle{3.0});
    shapes.push_back(new Rectangle{2.0,5.0});

    for(auto s : shapes){
        std::cout << s->to_string() << std::endl;
    }
    
    return 0;
}
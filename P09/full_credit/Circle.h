#include <iostream>
#include <stdexcept>

class Circle{
    public:
        Circle(double radius);
        std ::string name();
        double area();
    private:
        double _radius;  
};
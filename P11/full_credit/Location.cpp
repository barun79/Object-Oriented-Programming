#include "Location.h"
#include <iostream>

Location::Location(std::string filename, int line){

}

bool Location:: operator== (const Location& location) const{

}

bool Location:: operator!= (const Location& location) const{

}

bool Location:: operator< (const Location& location) const{

}

bool Location:: operator> (const Location& location) const{

}

bool Location:: operator<= (const Location& location) const {

}

bool Location:: operator>= (const Location& location) const {

}

std::ostream& operator<< (std::ostream& ost, const Location& location){
    ost << location._filename <<" line " << location._line;
    return ost;
}
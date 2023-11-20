#ifndef _LOCATION_H
#define _LOCATION_H

#include<iostream>

using namespace std;

class Location{
    private:
        string _filename;
        int _line;

    public:

        Location(string filename, int line);
        bool operator== (const Location& location) const;
        bool operator!=(const Location& location) const;
        bool operator< (const Location& location) const;
        bool operator> ( const Location& location) const;
        bool operator<= (const Location& location) const;
        bool operator>= (const Location& location) const;
        friend ostream& operator<< (ostream& ost, const Location& location);

};

#endif
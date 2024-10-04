#ifndef _INDEX_H
#define _INDEX_H

#include<iostream>
#include<map>
#include<set>
#include "Location.h"
       
typedef std::string Word;
typedef std::set<Location>Locations;

class Index{
    std::map<Word, Locations>_index;

    public:
        void add_word(Word word, std::string filename, int line);
        friend std::ostream& operator<< (std::ostream& ost, const Index& index);
};

#endif
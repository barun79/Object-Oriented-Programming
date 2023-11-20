#include<iostream>
#include "Index.h"

void Index::add_word(Word word, string filename, int line){
    _index[word].insert(Location(filename, line));
};

std::ostream& operator<<(std::ostream& ost, const Index& index){
    for(const auto& entry : index._index ){
        ost << entry.first <<": ";
        for(const auto& location : entry.second){
            ost << location << ", ";
        }
        ost << std::endl;
    }
    return ost;
};
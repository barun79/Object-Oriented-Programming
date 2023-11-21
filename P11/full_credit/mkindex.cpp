#include <iostream>
#include <fstream>
#include <sstream>
#include "Index.h"
#include <algorithm>

std::string clean_word(const std::string& word) {
    std::string cleaned_word = word;

    cleaned_word.erase(std::remove_if(cleaned_word.begin(), cleaned_word.end(),
                        [](char c) { return ispunct(c) || c == ',' || c == '"'; }),
                        cleaned_word.end());

    std::transform(cleaned_word.begin(), cleaned_word.end(), cleaned_word.begin(), [](unsigned char c) { return std::tolower(c); });

    return cleaned_word;
}



int main(int argc, char* argv[]){

    Index index;
    if (argc < 2){
        std::cerr <<"Usage " << argv[0] << " <file1> <file2> ...";
    }
    for(int i = 1 ; i < argc; i++){
        std::ifstream file(argv[i]);
        
        if (!file){
            std::cerr << "File "  << argv[i] <<" could not be open" << std::endl;
        }

        std::string line;
        int linenum = 1;
        
        while(std::getline(file, line)){
            std::istringstream iss(line);
            std::string word;
            while(iss >> word){
                index.add_word(word,argv[i],linenum);
            }
            linenum++;
        }
        file.close();
    }

    

    std::cout << index ;

    return 0;
}

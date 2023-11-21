#include <iostream>
#include <fstream>
#include <sstream>
#include "Index.h"

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



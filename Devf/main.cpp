//
//  main.cpp
//  Devf
//
//  Created by Gerardo Teruel on 5/6/15.
//  Copyright (c) 2015 Gerardo Teruel. All rights reserved.
//

#include <iostream>
#include <stack>
#include <string>

using namespace std;

void printBackwards(string input, char toCount);

int main(int argc, const char * argv[]) {
    
    printBackwards("El DevF rockea", 'e');
    
    return 0;
}



// REQUIRES: None.
// MODIFIES: None.
//  EFFECTS: Prints the input string in reverse order, and prints the frequency of the
// given letter.
void printBackwards(string input, char toCount){
    stack<char> storeChars;
    char toCountOtherCase = NULL;
    int charCount = 0;
    
    // If toCount is letter, sets toCountOtherCase to the other case of the char.
    if (toCount <= 90 && toCount >= 65) {
        toCountOtherCase = toCount + 32;
    } else if(toCount <= 122 && toCount >= 97){
        toCountOtherCase = toCount - 32;
    }
    
    
    cout << "Input al reves: " << endl;
    
    // Stores the string character by character in a stack and adds 1 to
    // each characterCount if the current character is equal to toCount.
    for (auto c :input) {
        storeChars.push(c);
        
        if (c == toCount || c == toCountOtherCase) {
            charCount++;
        }
    }
    
    // Prints to console the stack.
    while (!storeChars.empty() ) {
        cout << storeChars.top();
        storeChars.pop();
    }
    
    // Nice format.
    cout << endl;
    cout << endl;
    
    // Outputs the frequency count of toCount. 
    cout << "Frecuencia de la letra " << toCount << ": " << charCount << endl;
    
}



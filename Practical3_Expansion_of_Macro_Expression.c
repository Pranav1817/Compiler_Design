#include <stdio.h>
#include <string.h>

#define PI 3.14159

char* replaceMacroExpression(const char* str) {
    char* result = (char*)malloc(strlen(str) * 2); // Allocate a buffer to hold the result string
    result[0] = '\0'; // Initialize the result string

    const char* delimiter = " "; // Define a delimiter for splitting the input string
    char* token = strtok((char*)str, delimiter); // Tokenize the input string by spaces

    while (token != NULL) {
        if (strcmp(token, STR(PI)) == 0) {
            char piValue[16];
            snprintf(piValue, sizeof(piValue), "%g", PI);
            strcat(result, piValue);
        }
        else {
            strcat(result, token); // Copy the token as-is if it's not a macro expression
        }

        strcat(result, " "); // Append a space after each token
        token = strtok(NULL, delimiter); // Get the next token
    }

    return result;
}

int main() {
    const char input[] = "The value of PI is PI and the maximum of 5 and 10 is MAX";
    char* output = replaceMacroExpression(input);

    printf("Original string: %s\n", input);
    printf("Updated string: %s\n", output);

    free(output); // Free the allocated memory

    return 0;
}

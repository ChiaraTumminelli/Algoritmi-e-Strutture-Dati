#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include "skipList.h"

#define DICTIONARY "./resources/dictionary.txt"
#define CORRECTME "./resources/correctme.txt"

#define BUFF_MAX_LEN 1024
#define DICT_LEN 661562

#define GREEN "\x1B[32m"
#define RESET "\x1B[0m"
#define BLINK "\x1B[5m"
#define HIDE_CURSOR "\x1B[?25l"

SkipList *create_dictionary_skip_list();
void print_err_correctme_file(SkipList *dictionary_skip_list);
int compare_char(void *c1, void *c2);

// Reading file and initializing dictionary
SkipList *create_dictionary_skip_list()
{
    char *word;
    char buff[BUFF_MAX_LEN];
    SkipList *dictionary_skip_list;
    int last_letter = 0;

    dictionary_skip_list = create_skip_list(compare_char);
    FILE *fp = fopen(DICTIONARY, "r");
    if (fp == NULL)
    {
        printf("Trouble reading file --> Dictionary.txt! \nProgram terminating . . .\n");
        exit(0);
    }

    while (fgets(buff, BUFF_MAX_LEN, fp) != NULL)
    {
        word = malloc(strlen(buff) * sizeof(char));
        strcpy(word, buff);
        last_letter = (int)strlen(word) - 1;
        if (word[last_letter] == '\n')
        {
            word[last_letter] = '\0';
        }
        insert_skip_list(dictionary_skip_list, word);
    }
    fclose(fp);
    return dictionary_skip_list;
}

// Reading file and searching words in the dictionary
void print_err_correctme_file(SkipList *dictionary_skip_list)
{
    char *line;
    char *word;
    char buff[BUFF_MAX_LEN];

    FILE *fp = fopen(CORRECTME, "r");
    if (fp == NULL)
    {
        printf("Trouble reading file --> CorrectMe.txt! \nProgram terminating . . .\n");
        exit(0);
    }

    system("clear");
    puts(GREEN "\n--------- Words to correct ---------\n" RESET);

    while (fgets(buff, BUFF_MAX_LEN, fp) != NULL)
    {
        line = malloc((strlen(buff) + 1) * sizeof(char));
        strcpy(line, buff);
        word = strtok(line, " \t\r\n\v\f,.;:");

        while (word != NULL)
        {
            if (search_skip_list(dictionary_skip_list, word) == NULL)
                printf("%s\n", word);
            word = strtok(NULL, " \t\r\n\v\f,.;:");
        }
        free(line);
    }
    fclose(fp);
}

// Comparator for char values
int compare_char(void *c1, void *c2)
{
    char *val1 = (char *)c1;
    char *val2 = (char *)c2;
    if (strcasecmp(val1, val2) > 0)
        return 1;
    else if (strcasecmp(val1, val2) < 0)
        return -1;
    else
        return 0;
}

int main(int argc, char *argv[])
{
    clock_t start, end;
    start = clock();
    system("clear");
    printf(HIDE_CURSOR BLINK "\nCreating dictionary skip list . . .\n" RESET);
    SkipList *dictionary_skip_list = create_dictionary_skip_list();
    end = clock();
    print_err_correctme_file(dictionary_skip_list);
    delete_skip_list(dictionary_skip_list);
    double tot = (double)(end - start) / CLOCKS_PER_SEC;
    printf(GREEN "\nCPU: " RESET "%f sec\n\n", tot);
    return 0;
}

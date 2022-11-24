#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "../src/quick_bin_insertion_sort.h"

#define RECORDS_PATH "./resources/records.csv"
#define CHAR_ORD_RECORDS_PATH "./resources/char_ord_records.txt"
#define INT_ORD_RECORDS_PATH "./resources/int_ord_records.txt"
#define FLOAT_ORD_RECORDS_PATH "./resources/float_ord_records.txt"
#define LINE_LENGTH 1000
#define CSV_LENGTH 20000000

#define GREEN "\x1B[32m"
#define BLINK "\x1B[5m"
#define RESET "\x1B[0m"
#define HIDE_CURSOR "\x1B[?25l"

typedef struct
{
    int id;
    char *field1;
    int field2;
    float field3;

} record;

int struct_comparator_char(void *c1, void *c2);
int struct_comparator_int(void *i1, void *i2);
int struct_comparator_float(void *f1, void *f2);

int main(int argc, char const *argv[])
{

    //Cleaning terminal and hiding cursor
    system("clear");
    printf(HIDE_CURSOR BLINK "\nOpening csv file . . .\n" RESET);

    // Creating and opening file pointer
    FILE *fp = fopen(RECORDS_PATH, "r");

    // Generating an error if the opening of the file fails
    if (fp == NULL)
    {
        printf("Trouble reading file! \nProgram terminating ... ");
        exit(0);
    }

    // Creating a giant string to hold one line of data
    char line[LINE_LENGTH];

    // Dynamic allocation of the amount of memory needed
    record **rows = (record **)malloc(CSV_LENGTH * sizeof(void *));
    for (int i = 0; i < CSV_LENGTH; i++)
    {
        rows[i] = (record *)calloc(1, sizeof(record));
    }

    // Reading the strings of the file and splitting fields separated by comma
    for (int i = 0; i < CSV_LENGTH; i++)
    {
        fgets(line, LINE_LENGTH, fp);
        rows[i][0].id = atoi(strtok(line, ","));
        char *token = strtok(NULL, ",");
        rows[i][0].field1 = (char *)malloc(strlen(token) * sizeof(char));
        strcpy(rows[i][0].field1, token);
        rows[i][0].field2 = atoi(strtok(NULL, ","));
        rows[i][0].field3 = (float)atof(strtok(NULL, ","));
    }

    // Closing file containing records
    fclose(fp);
    system("clear");

    // --------------------------------------------- SORTING CHAR ---------------------------------------------------------------------
    clock_t start, end;
    start = clock();
    quick_bin_insertion_sort((void **)rows, 0, CSV_LENGTH - 1, struct_comparator_char, NULL);
    end = clock();
    double tot1 = (double)(end - start) / CLOCKS_PER_SEC;
    system("clear");
    printf(GREEN "CHAR" RESET "\tTotal time taken by CPU is : %f\n", tot1);

    printf(BLINK "\nCreating char sorted file . . .\n" RESET);
    FILE *char_ord_records = fopen(CHAR_ORD_RECORDS_PATH, "w");
    for (int i = 0; i < CSV_LENGTH; i++)
    {
        fprintf(char_ord_records, "%d, %s, %d, %f\n", rows[i][0].id, rows[i][0].field1, rows[i][0].field2, rows[i][0].field3);
    }

    system("clear");
    printf(GREEN "CHAR" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "char_ord_records.txt" RESET " file!\n", tot1);
    fclose(char_ord_records);

    // --------------------------------------------- SORTING INTEGER ---------------------------------------------------------------------
    start = clock();
    quick_bin_insertion_sort((void **)rows, 0, CSV_LENGTH - 1, struct_comparator_int, NULL);
    end = clock();
    double tot2 = (double)(end - start) / CLOCKS_PER_SEC;
    system("clear");
    printf(GREEN "CHAR" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "char_ord_records.txt" RESET " file!\n", tot1);
    printf(GREEN "INT" RESET "\tTotal time taken by CPU is : %f\n", tot2);

    printf(BLINK "\nCreating int sorted file . . .\n" RESET);
    FILE *int_ord_records = fopen(INT_ORD_RECORDS_PATH, "w");
    for (int i = 0; i < CSV_LENGTH; i++)
    {
        fprintf(int_ord_records, "%d, %s, %d, %f\n", rows[i][0].id, rows[i][0].field1, rows[i][0].field2, rows[i][0].field3);
    }

    system("clear");
    printf(GREEN "CHAR" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "char_ord_records.txt" RESET " file!\n", tot1);
    printf(GREEN "INT" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "int_ord_records.txt" RESET " file!\n", tot2);
    fclose(int_ord_records);

    // --------------------------------------------- SORTING FLOAT ---------------------------------------------------------------------
    start = clock();
    quick_bin_insertion_sort((void **)rows, 0, CSV_LENGTH - 1, struct_comparator_float, NULL);
    end = clock();
    double tot3 = (double)(end - start) / CLOCKS_PER_SEC;

    system("clear");
    printf(GREEN "CHAR" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "char_ord_records.txt" RESET " file!\n", tot1);
    printf(GREEN "INT" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "int_ord_records.txt" RESET " file!\n", tot2);
    printf(GREEN "FLOAT" RESET "\tTotal time taken by CPU is : %f\n", tot3);

    printf(BLINK "\nCreating float sorted file . . .\n" RESET);
    FILE *float_ord_records = fopen(FLOAT_ORD_RECORDS_PATH, "w");
    for (int i = 0; i < CSV_LENGTH; i++)
    {
        fprintf(float_ord_records, "%d, %s, %d, %f\n", rows[i][0].id, rows[i][0].field1, rows[i][0].field2, rows[i][0].field3);
    }

    system("clear");
    printf(GREEN "CHAR" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "char_ord_records.txt" RESET " file!\n", tot1);
    printf(GREEN "INT" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "int_ord_records.txt" RESET " file!\n", tot2);
    printf(GREEN "FLOAT" RESET "\tTotal time taken by CPU is : %f\t\t->\tGo check " GREEN "float_ord_records.txt" RESET " file!\n", tot3);
    fclose(float_ord_records);

    for (int i = 0; i < CSV_LENGTH; i++)
    {
        free(rows[i]);
    }

    free(rows);
    return 0;
}

// Comparing lines of CSV file based on type of value
int struct_comparator_char(void *c1, void *c2)
{
    char *val1 = ((record *)c1)->field1;
    char *val2 = ((record *)c2)->field1;
    return strcmp(val1, val2);
}

int struct_comparator_int(void *i1, void *i2)
{
    int val1 = ((record *)i1)->field2;
    int val2 = ((record *)i2)->field2;

    if (val1 > val2)
        return 1;
    else if (val1 < val2)
        return -1;
    else
        return 0;
}

int struct_comparator_float(void *f1, void *f2)
{
    float val1 = ((record *)f1)->field3;
    float val2 = ((record *)f2)->field3;

    if (val1 > val2)
        return 1;
    else if (val1 < val2)
        return -1;
    else
        return 0;
}

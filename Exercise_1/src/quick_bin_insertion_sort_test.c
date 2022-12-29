#include <stdio.h>
#include <stdlib.h>
#include "../src/quick_bin_insertion_sort.h"
#include "../src/comparator.h"
#include "../lib/unity.h"
#include "../lib/unity_internals.h"

#define GREEN "\x1B[32m"
#define RESET "\x1B[0m"

static int i1, i2, i3, i4, i5, i6, i7, i8, n_int1, n_int2, n_int3, n_int4, n_int5, n_int6, n_int7, n_int8;

static float f1, f2, f3, f4, f5, f6, f7, f8, n_float1, n_float2, n_float3, n_float4, n_float5, n_float6, n_float7, n_float8;

void setValue(void)
{
    i1 = 1; f1 = 1.0; n_int1 = -8; n_float1 = -8.0;  
    i2 = 2; f2 = 2.0; n_int2 = -7; n_float2 = -7.0; 
    i3 = 3; f3 = 3.0; n_int3 = -6; n_float3 = -6.0; 
    i4 = 4; f4 = 4.0; n_int4 = -5; n_float4 = -5.0; 
    i5 = 5; f5 = 5.0; n_int5 = -4; n_float5 = -4.0; 
    i6 = 6; f6 = 6.0; n_int6 = -3; n_float6 = -3.0; 
    i7 = 7; f7 = 7.0; n_int7 = -2; n_float7 = -2.0; 
    i8 = 8; f8 = 8.0; n_int8 = -1; n_float8 = -1.0; 
}

/*TESTING SORTING METHOD FOR NULL ARRAY*/

static void nullArray_int_first_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_int, partition_pivot_first);
    TEST_ASSERT_NULL(input);
}

static void nullArray_float_first_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_float, partition_pivot_first);
    TEST_ASSERT_NULL(input);
}

static void nullArray_char_first_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_char, partition_pivot_first);
    TEST_ASSERT_NULL(input);
}

static void nullArray_int_last_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_int, partition_pivot_last);
    TEST_ASSERT_NULL(input);
}

static void nullArray_float_last_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_float, partition_pivot_last);
    TEST_ASSERT_NULL(input);
}

static void nullArray_char_last_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_char, partition_pivot_last);
    TEST_ASSERT_NULL(input);
}

static void nullArray_int_random_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_int, partition_pivot_random);
    TEST_ASSERT_NULL(input);
}

static void nullArray_float_random_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_float, partition_pivot_random);
    TEST_ASSERT_NULL(input);
}

static void nullArray_char_random_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_char, partition_pivot_random);
    TEST_ASSERT_NULL(input);
}

static void nullArray_int_median_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_int, partition_pivot_median);
    TEST_ASSERT_NULL(input);
}

static void nullArray_float_median_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_float, partition_pivot_median);
    TEST_ASSERT_NULL(input);
}

static void nullArray_char_median_pivot(void)
{
    int *input = NULL;
    quickSort((void **)input, 0, 0, comparator_char, partition_pivot_median);
    TEST_ASSERT_NULL(input);
}

static void nullArray_int(void)
{
    int *input = NULL;
    insertionSort((void **)input, 0, 0, comparator_int);
    TEST_ASSERT_NULL(input);
}

static void nullArray_char(void)
{
    int *input = NULL;
    insertionSort((void **)input, 0, 0, comparator_char);
    TEST_ASSERT_NULL(input);
}

static void nullArray_float(void)
{
    int *input = NULL;
    insertionSort((void **)input, 0, 0, comparator_float);
    TEST_ASSERT_NULL(input);
}


/*TESTING SORTING METHOD FOR ARRAY CONTAINING NEGATIVES VALUES*/

static void isNegative_int_first_pivot(void)
{
    int *input[] = {&n_int5, &n_int3, &n_int8, &n_int2, &n_int1, &n_int7, &n_int6, &n_int4};
    int *expected[] = {&n_int1, &n_int2, &n_int3, &n_int4, &n_int5, &n_int6, &n_int7, &n_int8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_float_first_pivot(void)
{
    float *input[] = {&n_float5, &n_float3, &n_float8, &n_float2, &n_float1, &n_float7, &n_float6, &n_float4};
    float *expected[] = {&n_float1, &n_float2, &n_float3, &n_float4, &n_float5, &n_float6, &n_float7, &n_float8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_int_last_pivot(void)
{
    int *input[] = {&n_int5, &n_int3, &n_int8, &n_int2, &n_int1, &n_int7, &n_int6, &n_int4};
    int *expected[] = {&n_int1, &n_int2, &n_int3, &n_int4, &n_int5, &n_int6, &n_int7, &n_int8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_float_last_pivot(void)
{
    float *input[] = {&n_float5, &n_float3, &n_float8, &n_float2, &n_float1, &n_float7, &n_float6, &n_float4};
    float *expected[] = {&n_float1, &n_float2, &n_float3, &n_float4, &n_float5, &n_float6, &n_float7, &n_float8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_int_random_pivot(void)
{
    int *input[] = {&n_int5, &n_int3, &n_int8, &n_int2, &n_int1, &n_int7, &n_int6, &n_int4};
    int *expected[] = {&n_int1, &n_int2, &n_int3, &n_int4, &n_int5, &n_int6, &n_int7, &n_int8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_float_random_pivot(void)
{
    float *input[] = {&n_float5, &n_float3, &n_float8, &n_float2, &n_float1, &n_float7, &n_float6, &n_float4};
    float *expected[] = {&n_float1, &n_float2, &n_float3, &n_float4, &n_float5, &n_float6, &n_float7, &n_float8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_int_median_pivot(void)
{
    int *input[] = {&n_int5, &n_int3, &n_int8, &n_int2, &n_int1, &n_int7, &n_int6, &n_int4};
    int *expected[] = {&n_int1, &n_int2, &n_int3, &n_int4, &n_int5, &n_int6, &n_int7, &n_int8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_float_median_pivot(void)
{
    float *input[] = {&n_float5, &n_float3, &n_float8, &n_float2, &n_float1, &n_float7, &n_float6, &n_float4};
    float *expected[] = {&n_float1, &n_float2, &n_float3, &n_float4, &n_float5, &n_float6, &n_float7, &n_float8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_int(void)
{
    int *input[] = {&n_int5, &n_int3, &n_int8, &n_int2, &n_int1, &n_int7, &n_int6, &n_int4};
    int *expected[] = {&n_int1, &n_int2, &n_int3, &n_int4, &n_int5, &n_int6, &n_int7, &n_int8};
    insertionSort((void **)input, 0, 7, comparator_int);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void isNegative_float(void)
{
    float *input[] = {&n_float5, &n_float3, &n_float8, &n_float2, &n_float1, &n_float7, &n_float6, &n_float4};
    float *expected[] = {&n_float1, &n_float2, &n_float3, &n_float4, &n_float5, &n_float6, &n_float7, &n_float8};
    insertionSort((void **)input, 0, 7, comparator_float);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

/*TESTING SORTING METHOD FOR UNORDERED ARRAY */

static void unorderedArray_int_first_pivot(void)
{
    int *input[] = {&i5, &i3, &i8, &i2, &i1, &i7, &i6, &i4};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_float_first_pivot(void)
{
    float *input[] = {&f5, &f3, &f8, &f2, &f1, &f7, &f6, &f4};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_char_first_pivot(void)
{
    char *input[] = {"b", "a", "d", "h", "e", "g", "f", "c"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_int_last_pivot(void)
{
    int *input[] = {&i5, &i3, &i8, &i2, &i1, &i7, &i6, &i4};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_float_last_pivot(void)
{
    float *input[] = {&f5, &f3, &f8, &f2, &f1, &f7, &f6, &f4};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_char_last_pivot(void)
{
    char *input[] = {"b", "a", "d", "h", "e", "g", "f", "c"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_int_random_pivot(void)
{
    int *input[] = {&i5, &i3, &i8, &i2, &i1, &i7, &i6, &i4};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_float_random_pivot(void)
{
    float *input[] = {&f5, &f3, &f8, &f2, &f1, &f7, &f6, &f4};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_char_random_pivot(void)
{
    char *input[] = {"b", "a", "d", "h", "e", "g", "f", "c"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_int_median_pivot(void)
{
    int *input[] = {&i5, &i3, &i8, &i2, &i1, &i7, &i6, &i4};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_float_median_pivot(void)
{
    float *input[] = {&f5, &f3, &f8, &f2, &f1, &f7, &f6, &f4};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_char_median_pivot(void)
{
    char *input[] = {"b", "a", "d", "h", "e", "g", "f", "c"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_int(void)
{
    int *input[] = {&i5, &i3, &i8, &i2, &i1, &i7, &i6, &i4};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    insertionSort((void **)input, 0, 7, comparator_int);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_float(void)
{
    float *input[] = {&f5, &f3, &f8, &f2, &f1, &f7, &f6, &f4};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    insertionSort((void **)input, 0, 7, comparator_float);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void unorderedArray_char(void)
{
    char *input[] = {"b", "a", "d", "h", "e", "g", "f", "c"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    insertionSort((void **)input, 0, 7, comparator_char);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

/*TESTING SORTING METHOD FOR ORDERED ARRAY*/

static void orderedArray_int_first_pivot(void)
{
    int *input[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_float_first_pivot(void)
{
    float *input[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_char_first_pivot(void)
{
    char *input[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_first);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_int_last_pivot(void)
{
    int *input[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_float_last_pivot(void)
{
    float *input[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_char_last_pivot(void)
{
    char *input[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_last);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_int_random_pivot(void)
{
    int *input[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_float_random_pivot(void)
{
    float *input[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_char_random_pivot(void)
{
    char *input[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_random);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_int_median_pivot(void)
{
    int *input[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    quickSort((void **)input, 0, 7, comparator_int, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_float_median_pivot(void)
{
    float *input[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    quickSort((void **)input, 0, 7, comparator_float, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_char_median_pivot(void)
{
    char *input[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    quickSort((void **)input, 0, 7, comparator_char, partition_pivot_median);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_int(void)
{
    int *input[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    int *expected[] = {&i1, &i2, &i3, &i4, &i5, &i6, &i7, &i8};
    insertionSort((void **)input, 0, 7, comparator_int);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_float(void)
{
    float *input[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    float *expected[] = {&f1, &f2, &f3, &f4, &f5, &f6, &f7, &f8};
    insertionSort((void **)input, 0, 7, comparator_float);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}

static void orderedArray_char(void)
{
    char *input[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    char *expected[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    insertionSort((void **)input, 0, 7, comparator_char);
    TEST_ASSERT_EQUAL_PTR_ARRAY(expected, input, 8);
}


int main(int argc, char const *argv[])
{
    UNITY_BEGIN();

    printf(GREEN"\n%s\n", "QUICK SORT TESTING"RESET);
    
    setValue();

    //Testing null arrays
    RUN_TEST(nullArray_int_first_pivot);
    RUN_TEST(nullArray_float_first_pivot);
    RUN_TEST(nullArray_char_first_pivot);
    RUN_TEST(nullArray_int_last_pivot);
    RUN_TEST(nullArray_float_last_pivot);
    RUN_TEST(nullArray_char_last_pivot);
    RUN_TEST(nullArray_int_random_pivot);
    RUN_TEST(nullArray_float_random_pivot);
    RUN_TEST(nullArray_char_random_pivot);
    RUN_TEST(nullArray_int_median_pivot);
    RUN_TEST(nullArray_float_median_pivot);
    RUN_TEST(nullArray_char_median_pivot);
    RUN_TEST(isNegative_int_first_pivot);

    //Testing negative arrays
    RUN_TEST(isNegative_float_first_pivot);
    RUN_TEST(isNegative_int_last_pivot);
    RUN_TEST(isNegative_float_last_pivot);
    RUN_TEST(isNegative_int_random_pivot);
    RUN_TEST(isNegative_float_random_pivot);
    RUN_TEST(isNegative_int_median_pivot);
    RUN_TEST(isNegative_float_median_pivot);

    //Testing unordered arrays
    RUN_TEST(unorderedArray_int_first_pivot);
    RUN_TEST(unorderedArray_float_first_pivot);
    RUN_TEST(unorderedArray_char_first_pivot);
    RUN_TEST(unorderedArray_int_last_pivot);
    RUN_TEST(unorderedArray_float_last_pivot);
    RUN_TEST(unorderedArray_char_last_pivot);
    RUN_TEST(unorderedArray_int_random_pivot);
    RUN_TEST(unorderedArray_float_random_pivot);
    RUN_TEST(unorderedArray_char_random_pivot);
    RUN_TEST(unorderedArray_int_median_pivot);
    RUN_TEST(unorderedArray_float_median_pivot);
    RUN_TEST(unorderedArray_char_median_pivot);

    //Testing ordered arrays
    RUN_TEST(orderedArray_int_first_pivot);
    RUN_TEST(orderedArray_float_first_pivot);
    RUN_TEST(orderedArray_char_first_pivot);
    RUN_TEST(orderedArray_int_last_pivot);
    RUN_TEST(orderedArray_float_last_pivot);
    RUN_TEST(orderedArray_char_last_pivot);
    RUN_TEST(orderedArray_int_random_pivot);
    RUN_TEST(orderedArray_float_random_pivot);
    RUN_TEST(orderedArray_char_random_pivot);
    RUN_TEST(orderedArray_int_median_pivot);
    RUN_TEST(orderedArray_float_median_pivot);
    RUN_TEST(orderedArray_char_median_pivot);


    printf(GREEN"\n%s\n", "BINARY INSERTION SORT TESTING"RESET);

    //Testing null arrays
    RUN_TEST(nullArray_int);
    RUN_TEST(nullArray_float);
    RUN_TEST(nullArray_char);

    //Testing negative arrays
    RUN_TEST(isNegative_int);
    RUN_TEST(isNegative_float);

    //Testing unordered arrays
    RUN_TEST(unorderedArray_int);
    RUN_TEST(unorderedArray_float);  
    RUN_TEST(unorderedArray_char);

    //Testing ordered arrays
    RUN_TEST(orderedArray_int);
    RUN_TEST(orderedArray_float);
    RUN_TEST(orderedArray_char);
    return UNITY_END();
}
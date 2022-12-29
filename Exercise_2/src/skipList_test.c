#include "../lib/unity.h"
#include "skipList.h"
#include "comparator.h"

#define GREEN "\x1B[32m"
#define RESET "\x1B[0m"

static SkipList *list_to_test_int;
static SkipList *list_to_test_char;
static SkipList *list_to_test_float;

int check_values_int(SkipList *list, int *values, int n_elements);
int check_values_char(SkipList *list, char *values, int n_elements);
int check_values_float(SkipList *list, float *values, int n_elements);

static void test_insert_int()
{
    list_to_test_int = create_skip_list(comparator_int);
    int values_to_insert[4] = {2, 5, 8};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_int, values_to_insert + i);
    }
    TEST_ASSERT_EQUAL_INT(1, check_values_int(list_to_test_int, values_to_insert, 4));
    delete_skip_list(list_to_test_int);
}

static void test_search_existing_int()
{
    list_to_test_int = create_skip_list(comparator_int);
    int values_to_insert[4] = {2, 5, 8, 14};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_int, values_to_insert + i);
    }
    int value_to_search = 5;
    TEST_ASSERT_EQUAL_PTR(values_to_insert + 1, search_skip_list(list_to_test_int, &value_to_search));
    delete_skip_list(list_to_test_int);
}

static void test_search_unexisting_int()
{
    list_to_test_int = create_skip_list(comparator_int);
    int values_to_insert[4] = {2, 5, 8, 14};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_int, values_to_insert + i);
    }

    int value_to_search = 3;
    TEST_ASSERT_EQUAL_PTR(NULL, search_skip_list(list_to_test_int, &value_to_search));
    delete_skip_list(list_to_test_int);
}

static void test_insert_char()
{
    list_to_test_char = create_skip_list(comparator_char);
    char values_to_insert[4] = {'a', 'c', 'f'};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_char, values_to_insert + i);
    }
    TEST_ASSERT_EQUAL_INT(1, check_values_char(list_to_test_char, values_to_insert, 4));
    delete_skip_list(list_to_test_char);
}

static void test_search_existing_char()
{
    list_to_test_char = create_skip_list(comparator_char);
    char values_to_insert[4] = {'a', 'b', 'c', 'd'};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_char, values_to_insert + i);
    }

    char value_to_search = 'b';
    TEST_ASSERT_EQUAL_PTR(values_to_insert + 1, search_skip_list(list_to_test_char, &value_to_search));
    delete_skip_list(list_to_test_char);
}

static void test_search_unexisting_char()
{
    list_to_test_char = create_skip_list(comparator_char);
    char values_to_insert[4] = {'a', 'c', 'f', 'g'};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_char, values_to_insert + i);
    }

    char value_to_search = 'h';
    TEST_ASSERT_EQUAL_PTR(NULL, search_skip_list(list_to_test_char, &value_to_search));
    delete_skip_list(list_to_test_char);
}

static void test_insert_float()
{
    list_to_test_float = create_skip_list(comparator_float);
    float values_to_insert[4] = {2.3f, 5.6f, 8.9f};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_float, values_to_insert + i);
    }

    TEST_ASSERT_EQUAL_INT(1, check_values_float(list_to_test_float, values_to_insert, 4));
    delete_skip_list(list_to_test_float);
}

static void test_search_existing_float()
{
    list_to_test_float = create_skip_list(comparator_float);
    float values_to_insert[4] = {2.3f, 5.4f, 8.7f, 14.2f};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_float, values_to_insert + i);
    }

    float value_to_search = 5.4f;
    TEST_ASSERT_EQUAL_PTR(values_to_insert + 1, search_skip_list(list_to_test_float, &value_to_search));
    delete_skip_list(list_to_test_float);
}

static void test_search_unexisting_float()
{
    list_to_test_float = create_skip_list(comparator_float);
    float values_to_insert[4] = {2.4f, 5.7f, 8.2f, 14.9f};
    for (int i = 0; i < 4; i++)
    {
        insert_skip_list(list_to_test_float, values_to_insert + i);
    }

    float value_to_search = 3.1f;
    TEST_ASSERT_EQUAL_PTR(NULL, search_skip_list(list_to_test_float, &value_to_search));
    delete_skip_list(list_to_test_float);
}

int check_values_int(SkipList *list, int *values, int n_elements)
{
    int res = 0;
    for (int i = 0; i < n_elements; i++)
    {
        if (*((int *)get_value_at_index(list, i)) != values[i])
        {
            res = 0;
        }
    }
    res = 1;
    return res;
}

int check_values_char(SkipList *list, char *values, int n_elements)
{
    int res = 0;
    for (char i = 0; i < n_elements; i++)
    {
        if (*((char *)get_value_at_index(list, i)) != *(values + i))
        {
            res = 0;
        }
    }
    res = 1;
    return res;
}

int check_values_float(SkipList *list, float *values, int n_elements)
{
    int res = 0;
    for (int i = 0; i < n_elements; i++)
    {
        if (*((float *)get_value_at_index(list, i)) != values[i])
        {
            res = 0;
        }
    }
    res = 1;
    return res;
}

int main()
{

    UNITY_BEGIN();

    printf(GREEN "\nTESTING INT:\n" RESET);
    RUN_TEST(test_insert_int);
    RUN_TEST(test_search_existing_int);
    RUN_TEST(test_search_unexisting_int);

    printf(GREEN "\nTESTING CHAR:\n" RESET);
    RUN_TEST(test_insert_char);
    RUN_TEST(test_search_existing_char);
    RUN_TEST(test_search_unexisting_char);

    printf(GREEN "\nTESTING FLOAT:\n" RESET);
    RUN_TEST(test_insert_float);
    RUN_TEST(test_search_existing_float);
    RUN_TEST(test_search_unexisting_float);

    return UNITY_END();
}

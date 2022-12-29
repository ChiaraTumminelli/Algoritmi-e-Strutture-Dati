CFLAGS= -Wpedantic -Wall -Wconversion
EXECUTABLE= bin/es1
UNITY_EXE= bin/unit_test
BUILD_DIR= build/
BIN_DIR= bin/

all: $(EXECUTABLE) unity

app: $(EXECUTABLE)

unity: build/quick_bin_insertion_sort.o build/quick_bin_insertion_sort_test.o build/comparator.o lib/unity.o $(BIN_DIR)
	$(CC) -o $(UNITY_EXE) build/quick_bin_insertion_sort.o build/quick_bin_insertion_sort_test.o build/comparator.o lib/unity.o

unity_run: unity
	$(UNITY_EXE)

build/%.o: src/%.c $(BUILD_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

bin/es1: build/main.o build/quick_bin_insertion_sort.o $(BIN_DIR)
	$(CC) -o bin/es1 build/main.o build/quick_bin_insertion_sort.o 

clean: 
	$(RM) build/*.o
	$(RM) bin/*
	$(RM) lib/*.o
	$(RM) resources/*.txt

run: $(EXECUTABLE)
	$(EXECUTABLE)

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

$(BIN_DIR):
	mkdir -p $(BIN_DIR)

CFLAGS= -Wpedantic -Wall -Wconversion -Wno-sign-conversion
EXECUTABLE= bin/es2
UNITY_EXE= bin/unit_test
BUILD_DIR= build/
BIN_DIR= bin/

all: $(EXECUTABLE) unity

app: $(EXECUTABLE)

unity: build/skipList.o build/skipList_test.o build/comparator.o lib/unity.o $(BIN_DIR)
	$(CC) -o $(UNITY_EXE) build/skipList.o build/skipList_test.o build/comparator.o lib/unity.o

unity_run: unity
	$(UNITY_EXE)

build/%.o: src/%.c $(BUILD_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

bin/es2: build/main.o build/skipList.o $(BIN_DIR)
	$(CC) -o bin/es2 build/main.o build/skipList.o 

clean: 
	$(RM) build/*.o
	$(RM) bin/*
	$(RM) lib/*.o

run: $(EXECUTABLE)
	$(EXECUTABLE)

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

$(BIN_DIR):
	mkdir -p $(BIN_DIR)

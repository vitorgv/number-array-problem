# 🔢 Number Array Problem - Interview Coding Challenge

[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

> **A elegant solution to a classic interview coding problem using Java Streams and functional programming.**

This project demonstrates a clean, concise implementation of array element counting using modern Java features. Perfect for technical interviews and showcasing functional programming skills.

---

## 🎯 Problem Statement

**Interview Question**: Given an array of integers, create a program that:

```java
int[] array = {1, 1, 4, 4, 4, 4, 5, 1, 1, 2, 2, 2, 2, 3, 3, 3};
```

### Requirements:
1. ✅ **Count occurrences** of each number in the array
2. ✅ **Display results** in a formatted, sorted manner  
3. ✅ **Use Java Streams** for data processing
4. ✅ **Use Collections** for grouping and counting
5. ✅ **Implement in a `run(int[])` method** called from `main`
6. ✅ **Keep the solution as simple as possible**

---

## 🚀 Solution Highlights

### **The Core Algorithm** (Just 6 lines!)
```java
public void run(int[] numbers) {
    Arrays.stream(numbers)                    // Convert int[] to IntStream
            .boxed()                          // Convert IntStream to Stream<Integer>
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Group by value, count occurrences
            .entrySet().stream()              // Convert Map to Stream<Entry<Integer, Long>>
            .sorted(Map.Entry.comparingByKey()) // Sort entries by key (number) ascending
            .forEach(e -> System.out.println("Number " + e.getKey() + " appears " + e.getValue() + " time(s)"));
}
```

### **Key Features:**
- 🎯 **Functional Programming**: Pure stream-based solution
- ⚡ **Performance**: Single-pass algorithm with O(n) complexity
- 🧹 **Clean Code**: No loops, no temporary variables
- 📊 **Sorted Output**: Results automatically sorted by number value
- 🔧 **Extensible**: Easy to modify for different requirements

---

## 🛠️ Technical Implementation

### **Stream Pipeline Breakdown:**

| Step | Operation | Input Type | Output Type | Purpose |
|------|-----------|------------|-------------|---------|
| 1 | `Arrays.stream(numbers)` | `int[]` | `IntStream` | Create stream from array |
| 2 | `.boxed()` | `IntStream` | `Stream<Integer>` | Convert primitives to objects |
| 3 | `.collect(Collectors.groupingBy(...))` | `Stream<Integer>` | `Map<Integer, Long>` | Group and count occurrences |
| 4 | `.entrySet().stream()` | `Map<Integer, Long>` | `Stream<Entry<Integer, Long>>` | Convert to entry stream |
| 5 | `.sorted(Map.Entry.comparingByKey())` | `Stream<Entry>` | `Stream<Entry>` | Sort by key (number) |
| 6 | `.forEach(...)` | `Stream<Entry>` | `void` | Print formatted results |

### **Core Technologies Used:**
- **`Function.identity()`**: Method reference for grouping by element value
- **`Collectors.groupingBy()`**: Groups elements and applies downstream collector
- **`Collectors.counting()`**: Counts elements in each group
- **`Map.Entry.comparingByKey()`**: Comparator for sorting map entries by key

---

## 📋 Requirements

- **Java**: 21+ (works with Java 8+)
- **Maven**: 3.6+ 
- **IDE**: Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## 🏗️ Building and Running

### **Quick Start**
```bash
# Clone the repository
git clone <repository-url>
cd number-array-problem

# Build and run
mvn compile exec:java
```

### **Development Commands**
```bash
# Clean build
mvn clean compile

# Run tests
mvn test

# Package JAR
mvn package

# Run directly from classes
java -cp target/classes NumberArrayProcessor
```

### **Manual Compilation**
```bash
# Compile without Maven
javac -d . src/main/java/NumberArrayProcessor.java

# Run
java NumberArrayProcessor
```

---

## 📊 Example Output

### **Input Array:**
```java
{1, 1, 4, 4, 4, 4, 5, 1, 1, 2, 2, 2, 2, 3, 3, 3}
```

### **Program Output:**
```
Processing array: [1, 1, 4, 4, 4, 4, 5, 1, 1, 2, 2, 2, 2, 3, 3, 3]

Number 1 appears 4 time(s)
Number 2 appears 4 time(s)
Number 3 appears 3 time(s)
Number 4 appears 4 time(s)
Number 5 appears 1 time(s)
```

---

## 🧪 Testing

### **Comprehensive Test Suite**
- ✅ **Main scenario test**: Interview array with mixed numbers
- ✅ **Edge case test**: Empty array handling
- ✅ **Single element test**: Array with one element
- ✅ **Output validation**: Verifies correct formatting and content

### **Run Tests**
```bash
mvn test
```

### **Test Results**
```
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```

---

## 🎓 Educational Value

### **Interview Skills Demonstrated:**
1. **Functional Programming**: Mastery of Java 8+ streams
2. **Collections Framework**: Effective use of `Collectors` utility class
3. **Code Elegance**: Achieving complex functionality in minimal code
4. **Problem Solving**: Breaking down requirements into stream operations
5. **Best Practices**: Clean, readable, maintainable code

### **Learning Outcomes:**
- Understanding stream-based data processing
- Mastering grouping and aggregation operations
- Learning functional programming patterns in Java
- Practicing clean code principles

---

## 🔄 Alternative Approaches

<details>
<summary>Click to see other implementation styles</summary>

### **Traditional Loop Approach** (Verbose)
```java
Map<Integer, Integer> counts = new HashMap<>();
for (int num : numbers) {
    counts.put(num, counts.getOrDefault(num, 0) + 1);
}
```

### **Lambda with Identity** (Most Explicit)
```java
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
```

### **Lambda Expression** (More Concise)
```java
.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
```

</details>

---

## 📂 Project Structure

```
number-array-problem/
├── src/
│   ├── main/java/
│   │   └── NumberArrayProcessor.java    # Main solution class
│   └── test/java/
│       └── NumberArrayProcessorTest.java # Unit tests
├── target/                              # Build artifacts (ignored)
├── pom.xml                             # Maven configuration
├── .gitignore                          # Git ignore rules
└── README.md                           # This file
```

---

## 🏆 Why This Solution Stands Out

### **Interview Perspective:**
- ✨ **Impressive brevity**: Complex logic in just a few lines
- 🧠 **Modern Java**: Demonstrates knowledge of current best practices
- 🎯 **Requirement fulfillment**: Meets all specified criteria perfectly
- 🔧 **Maintainable**: Easy to understand and modify

### **Code Quality:**
- 📖 **Readable**: Self-documenting with clear method chains
- ⚡ **Efficient**: Single-pass algorithm with optimal complexity
- 🛡️ **Robust**: Handles edge cases gracefully
- 🧪 **Tested**: Comprehensive test coverage

---

## 🤝 Contributing

Feel free to suggest improvements or alternative implementations:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Interview Coding Challenge Solution**  
*Demonstrating functional programming excellence in Java*

---

<div align="center">

**⭐ If this helped you in an interview, please star the repository! ⭐**

</div>
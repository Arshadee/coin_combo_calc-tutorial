# coin_combo_calc-tutorial

A highly precise, production-ready Java application that solves the classic **Unbounded Knapsack / Coin Change Combination problem** using custom Depth-First Search (DFS) strategies. The project implements both an optimized recursive traversal and an explicit memory-managed iterative stack architecture to cleanly isolate algorithmic variants behind a unified strategy interface.

---

## ⚙️ Core Architecture & Design Patterns

The engine is engineered around the **Strategy Design Pattern**, decoupling client execution from structural search traversal. This enforces a clean separation of concerns and facilitates seamless extensibility for alternative combinatorial calculations.

### Project Composition
* **`IComboCalc`**: The base operational contract defining calculation execution signatures and a default reporting layer.
* **`ComboRecursionDfsCalc`**: A lightweight, highly optimized recursive depth-first execution engine operating on the explicit runtime stack.
* **`ComboIteratorDfsCalc`**: An iterative execution variant utilizing an explicit heap-allocated `ArrayDeque` stack block to prevent system stack overflow conditions during heavy-depth operations.
* **`UserInput` & `StaticInput`**: Decoupled boundary layers managing argument evaluation, data sanitization, and execution lifecycle profiling.

---

## 📊 Algorithmic Mechanics & Search Space Pruning

The engine leverages highly aggressive structural pruning rules within its Depth-First Search tree to maintain deterministic correctness while preventing mathematical duplication:

1. **Duplicate Combination Prevention**:
   Branches restrict future child allocations to indices greater than or equal to the parent node's index ($\ge \text{current\_index}$). This successfully cuts symmetric branch iterations and eliminates duplicate permutation sets.
2. **Value Boundary Constraint**:
   If the remaining target total balance ($rem$) falls strictly below the scalar value of the candidate denomination node ($rem < \text{den}[i]$), the child branch is pruned instantly to prevent deep invalid leaf execution.

```
Example : Denominations =[1,2,3] Total = 4
Uses Debth First Search Algorithm (DFS)     

                                             123
                               _____________[4:0]______________
                              /               |                \
                             1                2                 3
[tot-n:n (append n)]       [3:1]             [2:2]            [1:3]
                        /    |    \             \              -cut-
                       1     2     3             2         
                    [2:11]  [1:12] *[0:13]     *[0:22]
                    /      \  -cut-  
                    1       2
               [1:111]    *[0:112]
                   /
                   1
                *[0:1111]
```

\* = Valid combination matching targeted balance.

---

## 🚀 Performance Optimization Highlights

The codebase has undergone specific micro-optimizations to maximize performance under high iteration loads:
* **Zero Object Allocations in Loops**: Eliminated legacy runtime list conversions (`Arrays.asList(den)`) within recursive routines. Traversal boundaries are resolved natively directly against array allocations to minimize GC pressure.
* **LIFO Sequence Synchronization**: The iterative stack implementation parses search configurations in reverse processing order, cleanly aligning its branch output sequence with natural recursive traversal depths.

---

## 🛠️ Usage & Compilation Guide

### Requirements
* **Java Development Kit (JDK) 8** or higher
* Standard terminal/console console pipeline

### Compilation
Compile all package components cleanly from your root source directory:
```bash
javac -d bin src/org/calculate/coin_combo/*.java
```
## Execution Lifecycle
Run the executable by declaring your target total balance, followed sequentially by your space-delimited denomination values:

Bash
```
java -cp bin org.calculate.coin_combo.Main <total> <den_1> <den_2> ... <den_n> [ENGINE_FLAG]
```
## Tail-End Engine Switching Flags
You can optionally control the strategy pattern implementation at runtime by appending a trailing identifier:

* REC : Forces the Recursive Depth First Search Engine (Default).
* ITR : Forces the Iterative Depth First Search Engine.

## Practical Examples
Bash
```
# Standard Execution using default Recursive Strategy
java -cp bin org.calculate.coin_combo.Main 30 1 2 3 5 29 30 31

# Forced Iterative Stack Execution
java -cp bin org.calculate.coin_combo.Main 30 1 2 3 5 29 30 31 ITR
```
## Licensing & Contribution
Distributed under standard open-source constraints. Codebase optimized for mathematical precision and linear readability.

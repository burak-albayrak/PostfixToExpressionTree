# Postfix Expression to Expression Tree Converter

This project contains a Java program designed to handle postfix expressions. It converts postfix expressions into expression trees and visualizes these trees in a tree-like structure.

## Project Purpose

The purpose of this project is to assist users in processing postfix expressions and visualizing them using an expression tree. Postfix expressions are mathematical notations that represent operations in a sequential manner. This program aims to convert postfix expressions into expression trees and visualize them to help users better understand them.

## Technologies Used

- Java
- Stack data structure
- 2D char array (grid)
  
## Examples

### Example 1: Simple Postfix Expression
```java
String postfixFormula = "12+3+";
Node root = ExpressionTree.buildTree(postfixFormula);
ExpressionTree.printTree(root);
```

### Example 1: Simple Postfix Expression
Postfix formula: `12+3+`

#### Output:
```
   +
  / \
 1   +
    / \
   2   3
```

### Example 2: Complex Postfix Expression
```java
String postfixFormula = "12+3+578/-*";
Node root = ExpressionTree.buildTree(postfixFormula);
ExpressionTree.printTree(root);
```

### Example 2: Complex Postfix Expression
Postfix formula: `12+3+578/-*`

#### Output:
```
     *
    / \
   +   /
  / \  / \
 1   + 5   /
    / \   / \
   2   3  7   8
```

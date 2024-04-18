import java.util.Stack;
import java.util.Arrays;

public class ExpressionTree {

    // Build an expression tree from a postfix expression
    public static Node buildTree(String formulaInPostfix) {
        Stack<Node> stack = new Stack<>();

        for (char c : formulaInPostfix.toCharArray()) {
            // If the character is an operand, create a new node and push it onto the stack
            if (isOperand(c)) {
                stack.push(new Node(c));
            }
            // If the character is an operator, pop two nodes from the stack,
            // create a new node with the operator, and push it back onto the stack
            else if (isOperator(c)) {
                Node operatorNode = new Node(c);
                operatorNode.right = stack.pop();
                operatorNode.left = stack.pop();
                stack.push(operatorNode);
            }
        }

        // The final node on the stack is the root of the expression tree
        return stack.pop();
    }

    // Check if a character is an operand (0-9)
    private static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    // Check if a character is an operator (+, -, *, /)
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Print the expression tree in a tree-like structure
    public static void printTree(Node root) {
        int height = getHeight(root);
        int width = (int) Math.pow(2, height + 1);
        char[][] grid = new char[height + 1][width];

        initializeGrid(grid);

        fillGrid(root, grid, 0, 0, width);

        printGrid(grid);
    }

    // Initialize the grid with empty spaces
    private static void initializeGrid(char[][] grid) {
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
    }

    // Fill the grid based on the level of nodes in the tree
    private static void fillGrid(Node node, char[][] grid, int level, int start, int end) {
        if (node == null) {
            return;
        }

        int mid = (start + end) / 2;
        grid[level][mid] = node.c;

        fillGrid(node.left, grid, level + 1, start, mid - 1);
        fillGrid(node.right, grid, level + 1, mid + 1, end);
    }

    // Print the grid row by row
    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Get the height of the tree
    private static int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
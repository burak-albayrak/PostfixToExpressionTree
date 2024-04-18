public class Main {
    public static void main(String[] args) {
        // Example postfix expression
        String postfixFormula = "12+3+578/-*";
        // Build the expression tree
        Node root = ExpressionTree.buildTree(postfixFormula);
        // Print the expression tree
        ExpressionTree.printTree(root);
    }
}
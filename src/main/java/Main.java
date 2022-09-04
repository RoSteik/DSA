/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: Lab-1-DSA
 * Package: PACKAGE_NAME
 * Class: Main
 */

public class Main {

    public static void main(String[] args) {

        AVLBinaryTree tree = new AVLBinaryTree();
        tree.insert(100);
        tree.insert(150);
        tree.insert(70);
        tree.insert(75);
        tree.insert(60);
        tree.insert(65);
        tree.insert(64);

        tree.printTree();

        tree.delete(70);
        tree.delete(65);
        tree.printTree();

    }
}

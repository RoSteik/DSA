/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: Lab-1-DSA
 * Package: PACKAGE_NAME
 * Class: NodeTests
 */

import org.junit.jupiter.api.Test;

class NodeTests {


    @Test
    void rightRotateTest1() {
        Node root = new Node(100, null);
        root.right = new Node(150, root);
        root.left = new Node(50, root);
        root.left.right = new Node(75, root.left);
        root.left.left = new Node(25, root.left);

        root.printSubTree();
        Node newRoot = root.left;
        root.rightRotate();
        newRoot.printSubTree();
    }

    @Test
    void rightRotateTest2() {
        Node root = new Node(100, null);
        root.right = new Node(150, root);
        root.left = new Node(50, root);
        root.left.left = new Node(25, root.left);

        root.printSubTree();
        Node newRoot = root.left;
        root.rightRotate();
        newRoot.printSubTree();
    }

    @Test
    void rightRotateTest3() {
        Node root = new Node(100, null);
        root.right = new Node(150, root);
        root.right.left = new Node(125, root.right);

        root.printSubTree();

        root.right.rightRotate();
        root.printSubTree();
    }


    @Test
    void leftRotateTest1() {
        Node root = new Node(100, null);
        root.left = new Node(50, root);
        root.right = new Node(150, root);
        root.right.right = new Node(175, root.right);
        root.right.left = new Node(125, root.right);

        root.printSubTree();
        Node newRoot = root.right;
        root.leftRotate();
        newRoot.printSubTree();

    }

    @Test
    void leftRotateTest2() {
        Node root = new Node(100, null);
        root.left = new Node(50, root);
        root.right = new Node(125, root);
        root.right.right = new Node(150, root.right);

        root.printSubTree();
        Node newRoot = root.right;
        root.leftRotate();
        newRoot.printSubTree();
    }

    @Test
    void leftRotateTest3() {
        Node root = new Node(100, null);
        root.left = new Node(50, root);
        root.left.right = new Node(75, root.left);

        root.printSubTree();
        root.left.leftRotate();
        root.printSubTree();
    }


    //right-heavy: left rotate needed
    @Test
    void balanceSubTreeTest1() {
        Node root = new Node(100, null);
        root.right = new Node(125, root);
        root.right.right = new Node(150, root.right);
        root.printSubTree();

        root.balanceSubTree();
        while (root.parent != null) {
            root =  root.parent;
        }
        root.printSubTree();
    }

    //right-heavy: right-left rotate needed
    @Test
    void balanceSubTreeTest2() {
        Node root = new Node(100, null);
        root.right = new Node(150, root);
        root.right.left = new Node(125, root.right);
        root.printSubTree();

        root.balanceSubTree();
        while (root.parent != null) {
            root =  root.parent;
        }
        root.printSubTree();
    }

    //left-heavy right: right rotate needed
    @Test
    void balanceSubTreeTest3() {
        Node root = new Node(100, null);
        root.left = new Node(75, root);
        root.left.left = new Node(50, root.left);
        root.printSubTree();

        root.balanceSubTree();
        while (root.parent != null) {
            root =  root.parent;
        }
        root.printSubTree();
    }

    //left-heavy right: left-right rotate needed
    @Test
    void balanceSubTreeTest4() {
        Node root = new Node(100, null);
        root.left = new Node(50, root);
        root.left.right = new Node(75, root.left);
        root.printSubTree();

        root.balanceSubTree();
        while (root.parent != null) {
            root =  root.parent;
        }
        root.printSubTree();

    }


}
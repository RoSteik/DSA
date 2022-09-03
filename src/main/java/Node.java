/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: Lab-1-DSA
 * Package: PACKAGE_NAME
 * Class: Node
 */

public class Node {

    public Node left;
    public Node right;
    public int data;
    public Node parent;
    public Diapason diapason;

    public Node(int data, Node parent) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }

    public void balanceSubTree() {
        if (this.balance() > 1) {
            if (this.left.balance() > 0) {               //left heavy
                this.rightRotate();                          //right rotate
            } else {                                         //left-right rotate
                this.left.leftRotate();
                this.rightRotate();
            }
        } else {
            if (this.balance() < -1) {
                if (this.right.balance() < 0) {             //right heavy
                    this.leftRotate();                           //left rotate
                } else {                                         //right left rotate
                    this.right.rightRotate();
                    this.leftRotate();
                }
            }
        }

        if (this.parent != null) {
            this.parent.balanceSubTree();
        }

    }

    public void rightRotate() {
        Node thisParent = this.parent;
        this.parent = this.left;
        this.left.parent = thisParent;

        if (thisParent != null) {
            if (thisParent.left == this) {
                thisParent.left = this.left;
            } else {
                thisParent.right = this.left;
            }
        }

        Node leftRightChild = this.left.right;
        this.left.right = this;
        this.left = leftRightChild;

        if (leftRightChild != null) {
            leftRightChild.parent = this;
        }

    }

    public void leftRotate() {
        Node thisParent = this.parent;
        this.parent = this.right;
        this.right.parent = thisParent;

        if (thisParent != null) {
            if (thisParent.left == this) {
                thisParent.left = this.right;
            } else {
                thisParent.right = this.right;
            }
        }

        Node leftChild = this.right.left;
        this.right.left = this;
        this.right = leftChild;
        if (leftChild != null) {
            leftChild.parent = this;
        }

    }

    public int height() {
        int leftSubtreeHeight = 0; // by default
        int rightSubtreeHeight = 0; // by default

        if (this.left != null) {
            leftSubtreeHeight = this.left.height() + 1;
        }
        if (this.right != null) {
            rightSubtreeHeight = this.right.height() + 1;
        }

        return Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

    int balance() { // calculates balance of the node
        int leftHeight = -1; // by default
        int rightHeight = -1; // by default

        if (this.left != null) {
            leftHeight = this.left.height();
        }
        if (this.right != null) {
            rightHeight = this.right.height();
        }

        return leftHeight - rightHeight;
    }

    public void printSubTree() {
        int width = ((int) Math.pow(2, this.height() + 1)) - 1;

        this.diapason = new Diapason(0, width);

        String[][] outputArray = new String[this.height() + 1][width];

        Node parentCopy = this.parent;
        this.parent = null;
        this.setUpTreeToOutput(outputArray);
        this.parent = parentCopy;

        char space = ' ';
        boolean trigger = false;
        Node floatingNode = this;
        while (floatingNode.right != null) {
            floatingNode = floatingNode.right;
        }
        int cellSize = ("" + floatingNode.data).length();

        System.out.println();

        for (String[] strings : outputArray) {
            for (String string : strings) {
                if (string == null) {
                    for (int i = 0; i < cellSize; i++) {
                        System.out.print(space);
                    }
                } else {
                    for (int i = 0; i < cellSize-(string+"").length(); i++) {
                        System.out.print(space);
                    }

                    System.out.print(string);

                    if (trigger) {
                        trigger = false;
                        space = '-';
                    } else {
                        trigger = true;
                        space = ' ';
                    }
                }
            }
            System.out.println();
        }

        System.out.println();

    }

    public void setUpTreeToOutput(String[][] tree) {
        int position = this.diapason.middle();

        Diapason leftDiapason = new Diapason(this.diapason.leftEdge, position - 1);
        Diapason rightDiapason = new Diapason(position + 1, this.diapason.rightEdge);


        if (this.left == null && this.right != null) {
            tree[this.distanceToTheRoot() + 1][leftDiapason.middle()] = "[]";
        }
        if (this.right == null && this.left != null) {
            tree[this.distanceToTheRoot() + 1][rightDiapason.middle()] = "[]";
        }

        tree[this.distanceToTheRoot()][position] = "" + this.data;

        if (this.left != null) {
            this.left.diapason = leftDiapason;
            this.left.setUpTreeToOutput(tree);
        }

        if (this.right != null) {
            this.right.diapason = rightDiapason;
            this.right.setUpTreeToOutput(tree);
        }

    }

    private int distanceToTheRoot() {
        int height = 0;
        Node currentNode = this;

        while (currentNode.parent != null) {
            height++;
            currentNode = currentNode.parent;
        }

        return height;
    }

    public Node searchNode(int data) {
        Node result = this;

        while (data != result.data) {
            if (data < result.data) {
                result = result.left;
            } else {
                result = result.right;
            }
            if (result == null)
                break;
        }

        return result;
    }

}
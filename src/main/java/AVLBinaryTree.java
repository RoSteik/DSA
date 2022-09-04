/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: Lab-1-DSA
 * Package: PACKAGE_NAME
 * Class: AVLBinaryTree
 */

public class AVLBinaryTree {

    public Node root;

    public void insert(int data) {
        boolean isInserted = false;
        Node floatingNode = this.root;

        if (this.root == null) {
            this.root = new Node(data, null);
            isInserted = true;
        }

        while (!isInserted) { // isInserted == false
            if (floatingNode.data > data) {                      //conditions if data has to move left or right
                if (floatingNode.left == null) {
                    floatingNode.left = new Node(data, floatingNode);
                    floatingNode.balanceSubTree();               //balance
                    isInserted = true;
                } else {
                    floatingNode = floatingNode.left;
                }
            } else if (floatingNode.data < data) {
                if (floatingNode.right == null) {
                    floatingNode.right = new Node(data, floatingNode);
                    floatingNode.balanceSubTree();                   //balance
                    isInserted = true;
                } else {
                    floatingNode = floatingNode.right;
                }
            } else {
                System.out.println("Already Inserted " + data);
                break;
            }
        }

        while (this.root.parent != null) {
            this.root = this.root.parent;
        }

    }

    public void printTree() {
        if (this.root != null) {
            this.root.printSubTree();
        }
    }

    public void delete(int data) {
        Node balanceStartPoint;
        Node nodeToDelete = this.root.searchNode(data);
        if (nodeToDelete != null) {

            if (nodeToDelete.left == null) {
                if (nodeToDelete.right == null) {
                    if (nodeToDelete.parent != null) {
                        if (nodeToDelete.parent.left == nodeToDelete) {            // if there is no one on the right or left
                            nodeToDelete.parent.left = null;
                        } else {
                            nodeToDelete.parent.right = null;
                        }
                    } else {
                        this.root = null;
                    }
                } else {
                    if (nodeToDelete.parent != null) {                    //      if something is on the right
                        if (nodeToDelete.parent.left == nodeToDelete) {
                            nodeToDelete.parent.left = nodeToDelete.right;
                        } else {
                            nodeToDelete.parent.right = nodeToDelete.right;
                        }
                        nodeToDelete.right.parent = nodeToDelete.parent;
                        nodeToDelete.parent.balanceSubTree();

                    } else {
                        this.root = this.root.right;
                        this.root.parent = null;
                        this.root.balanceSubTree();
                    }
                }
                balanceStartPoint = nodeToDelete.parent;
            } else {                                                     //   if there is something on the left
                Node theFurthestChildOnTheLeftSide = nodeToDelete.left;
                while (theFurthestChildOnTheLeftSide.right != null) {
                    theFurthestChildOnTheLeftSide = theFurthestChildOnTheLeftSide.right;
                }
                if (theFurthestChildOnTheLeftSide.parent.right == theFurthestChildOnTheLeftSide) {
                    theFurthestChildOnTheLeftSide.parent.right = theFurthestChildOnTheLeftSide.left;
                } else {
                    theFurthestChildOnTheLeftSide.parent.left = theFurthestChildOnTheLeftSide.left;
                }

                nodeToDelete.data = theFurthestChildOnTheLeftSide.data;
                theFurthestChildOnTheLeftSide.parent.balanceSubTree();
                balanceStartPoint = theFurthestChildOnTheLeftSide.parent;
            }

            if (balanceStartPoint != null) {
                while (balanceStartPoint.parent != null) {
                    balanceStartPoint = balanceStartPoint.parent;
                }
                this.root = balanceStartPoint;
            }
        } else {
            System.out.println("There is nothing to delete");
        }
    }

}


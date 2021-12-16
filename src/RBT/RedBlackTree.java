package RBT;

public class RedBlackTree {
    static final boolean RED = false;
    static final boolean BLACK = true;

    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node searchNode(int key) {
        Node node = root;
        while (node != null) {
            if (key == node.data) {
                return node;
            } else if (key < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public void insertNode(int key) {
        Node node = root;
        Node parent = null;

        while (node != null) {
            parent = node;
            if (key < node.data) {
                node = node.left;
            } else if (key > node.data) {
                node = node.right;
            }
        }

        Node newNode = new Node(key);
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else if (key < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        fixRedBlackPropertiesAfterInsert(newNode);
    }

    private Node getUncle(Node parent){
        Node grandparent = parent.parent;
        if(grandparent.left == parent){
            return grandparent.right;
        }
        else if(grandparent.right == parent){
            return grandparent.left;
        }
        else{
            return null;
        }
    }

    private Node getSibling(Node node){
        Node parent = node.parent;
        if(node == parent.left){
            return parent.right;
        }
        else if(node == parent.right){
            return parent.left;
        }
        else{
            return null;
        }
    }

    private void rotateRight(Node node){
        Node parent = node.parent;
        Node leftChild = node.left;
        node.left = leftChild.right;
        if(leftChild.right != null){
            leftChild.right.parent = node;
        }
        leftChild.right = node;
        node.parent = leftChild;
        replaceParentChild(parent,node,leftChild);
    }

    private void rotateLeft(Node node){
        Node parent = node.parent;
        Node rightChild = node.right;
        node.right = rightChild.left;
        if(rightChild.left != null){
            rightChild.left.parent = node;
        }
        rightChild.left = node;
        node.parent = rightChild;
        replaceParentChild(parent,node,rightChild);
    }

    private void replaceParentChild(Node parent, Node oldChild,Node newChild){
        if(parent == null){
            root = newChild;
        }
        else if(parent.left == oldChild){
            parent.left = newChild;
        }
        else if(parent.right == oldChild){
            parent.right = newChild;
        }
    }

    private void fixRedBlackPropertiesAfterInsert(Node node) {
        Node parent = node.parent;
        //case1 : parent is null
        if (parent == null) {
            return;
        }
        if (parent.color == BLACK) {
            return;
        }
        Node grandparent = parent.parent;
        //case2: parent is root
        if (grandparent == null) {
            parent.color = BLACK;
            return;
        }
        Node uncle = getUncle(parent);
        //case3: uncle is red, recolor parent,grandparent,uncle
        if(uncle != null && uncle.color == RED){
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;
            fixRedBlackPropertiesAfterInsert(grandparent);
        }
        //case4a:uncle is black and node is left->right
        else if(parent == grandparent.left){
            if(node == parent.right){
                rotateLeft(parent);
                parent = node;
            }
            //case5a: uncle is black and node is left->left
            rotateRight(grandparent);
            parent.color = BLACK;
            grandparent.color = RED;
        }
        else{
            if(node == parent.left){
                rotateRight(parent);
                parent = node;
            }
            rotateLeft(grandparent);
            parent.color = BLACK;
            grandparent.color = RED;
        }
    }
}
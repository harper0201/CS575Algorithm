package BST;

public class binarySearchTree {

        private Node root;

        public Node getRoot() {
            return root;
        }
        public void setRoot(Node root) {
            this.root = root;
        }
        
        //check if the BST is empty
        public boolean isEmpty(){
            return root == null;
        }

        public Node searchIterative(int value){
            if(isEmpty()) return null;
            Node currentNode = this.root;
            while(currentNode != null){
                if(currentNode.getData() == value){
                    return currentNode;
                }
                else if (currentNode.getData() > value){
                    currentNode = currentNode.getLeftChild();
                }
                else{
                    currentNode = currentNode.getRightChild();
                }
            }
            return null;
        }

        public Node searchRecursive(Node currentNode, int value){
            if(currentNode== null ||currentNode.getData() == value){
                return currentNode;
            }
            else if(currentNode.getData() > value){
                return  searchRecursive(currentNode.getLeftChild(),value);
            }
            else{
                return searchRecursive(currentNode.getRightChild(),value);
            }
        }

        public Node search(int value){
            if(isEmpty())  return null;
            return searchRecursive(root,value);
        }

        public Node addRecursive(Node currentNode,int value){
            //base case
            if(currentNode == null){
                return new Node(value);
            }
            //
            if(value < currentNode.getData()){
                currentNode.setLeftChild(addRecursive(currentNode.getLeftChild(),value));
            }
            else if(value > currentNode.getData()){
                currentNode.setRightChild(addRecursive(currentNode.getRightChild(),value));
            }
            else{
                return currentNode;
            }
            return currentNode;
        }

        public boolean add(int value){
            root = addRecursive(this.root,value);
            return true;
        }
        
        //iterative Function to insert a value in BST
        public boolean addIterative(int value){
            // if BST is empty, the added node is root
            if(isEmpty()){
                root = new Node(value);
                return true;
            }
            
            //starting from root
            Node currentNode = root;
            while(currentNode != null){
                //compare value of added node with current node\
                if(currentNode.getData() > value){
                    if(currentNode.getLeftChild() == null){
                        Node newNode = new Node(value);
                        currentNode.setLeftChild(newNode);
                        return true;
                    }
                    currentNode = currentNode.getLeftChild();
                }
                else{
                    if(currentNode.getRightChild() == null){
                        Node newNode = new Node(value);
                        currentNode.setRightChild(newNode);
                        return true;
                    }
                    currentNode = currentNode.getRightChild();
                }
            }
            return false;
        }

        public boolean delete(int value, Node currentNode){
            if(root == null){
                return false;
            }
            //find the node
            Node parent = null;
            while(currentNode != null && currentNode.getData() != value){
                parent = currentNode;
                if (currentNode.getData() > value){
                    currentNode = currentNode.getLeftChild();
                }
                else{
                    currentNode = currentNode.getRightChild();
                }
            }

            if(currentNode == null){
                return false;
            }
            else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
                //node is a leaf node
                if(root.getData() == currentNode.getData()){
                    setRoot(null);
                    return true;
                }
                else if(currentNode.getData() < parent.getData()){
                    parent.setLeftChild(null);
                    return true;
                }
                else{
                    parent.setRightChild(null);
                    return true;
                }
            }
            else if(currentNode.getLeftChild() == null){
                if(root.getData() == currentNode.getData()){
                    setRoot(currentNode.getRightChild());
                    return true;
                }
                else if(currentNode.getData() < parent.getData()){
                    parent.setLeftChild(currentNode.getRightChild());
                    return true;
                }
                else{
                    parent.setRightChild(currentNode.getRightChild());
                    return true;
                }
            }
            else if(currentNode.getRightChild() == null) {
                if(root.getData() == currentNode.getData()){
                    setRoot(currentNode.getLeftChild());
                    return true;
                }
                else if(currentNode.getData() < parent.getData()){
                    parent.setLeftChild(currentNode.getLeftChild());
                    return true;
                }
                else{
                    parent.setRightChild(currentNode.getLeftChild());
                    return true;
                }
            }
            else{
                //find the least nod in right subtree
                Node leastNode = currentNode.getRightChild();
                while(leastNode.getLeftChild() != null){
                    leastNode = leastNode.getLeftChild();
                }
                int temp = leastNode.getData();
                delete(temp,root);
                currentNode.setData(temp);
                return true;
            }
        }

        public void preOrder(Node root){
            if(root == null) return;
            System.out.print(root.getData() + " ");
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }

        public void inOrder(Node root){
            if(root == null) return;
            inOrder(root.getLeftChild());
            System.out.print(root.getData() + " ");
            inOrder(root.getRightChild());
        }

        public void postOrder(Node root){
            if(root == null) return;
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            System.out.print(root.getData() + " ");
        }

        public int count(Node root){
            if(root == null) return 0;
            return count(root.getLeftChild()) + count(root.getRightChild()) + 1;
        }


        //Just for Testing purpose 
        public void printTree(Node current)
        {
            if (current == null) return;

            System.out.print(current.getData() + ",");
            printTree(current.getLeftChild());
            printTree(current.getRightChild());

        }
}
//O(h) we have traverse from root to deepest leaf node

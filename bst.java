class bst {

    Node root;

    public void insert(Node node) {
        
        root = insertHelper(root, node);
    }
    
    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        if(root == null) {
            root = node;
            return root;
        }

        else if(data > root.data) {

            root.right = insertHelper(root.right, node);

        }

        else {
            root.left = insertHelper(root.left, node);
        }

        return root;
    }

    public void display() {

        displayHelper(root);
    }

    private void displayHelper(Node root) {

        if(root != null) {
            
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public void  search(int data) {
       
       if( searchHelper(data, root)) {
        System.out.println("found");
       }
       else {
         System.out.println("not found");
       }

    }

    private boolean searchHelper(int data, Node root) {

        if(root == null) {
            return false;
        }

        else if(root.data == data) {
            return true;
        }

        else if(data > root.data) {
            return searchHelper(data, root.right);
        }

        else if(data < root.data) {
            return searchHelper(data, root.left);
        }

        return false;
    }

    public void remove(int data) {
        root = removeHelper(data, root);
         
    }

    private Node removeHelper(int data, Node root) {

        if(root == null) {
            System.out.println("root = null");
        }

        else if(root.data == data) {
            if(root.left == null && root.right == null) {
                root = null;
                System.out.println("deleted successfully");
                
            }
            else if(root.right != null) {
                root.data = successor(root);
                root.right = removeHelper(root.data, root.right);
                
            }
            else { 
                root.data = processor(root);
                root.left = removeHelper(root.data, root.left);
            }
        }

        else if(data > root.data) {
             root.right = removeHelper(data, root.right);
        }

        else if(data < root.data) {
            root.left = removeHelper(data, root.left);
        }

        return root;
    }
    private int successor(Node root) {
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int processor(Node root) {

        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
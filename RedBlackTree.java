package redblacktree;

public class RedBlackTree{
    private RedBlackNode root;

    public RedBlackTree(RedBlackNode root){
        this.root = root;
        root.setColor("black");
    }

    // Purpose: mutate the root parameter of the given tree
    public void setRoot(RedBlackNode newRoot){
        this.root = newRoot;
    }

    // Purpose: access the root parameter of the given tree
    public RedBlackNode getRoot(){
        return this.root;
    }

    /* Procedure: leftRotate
    *  Preconditions: the right child of x is not T.nil; the parent of x is T.nil; x is an element of a correct RedBlackTree
    *  Parameters: x, a RedBlackNode
    *  Purpose: rotate to the left (change the pointer structure) the elements of the RedBlackTree around the given parameter
    *  Product: a version of the tree rotated to the left around x
    *  Postconditions: the properties of a red-black tree are all preserved in the rotated version of the tree
    */
    public void leftRotate(RedBlackNode x){
        RedBlackNode y = x.getRight();
        x.setRight(y.getLeft());

        if(y.getLeft() != null){
            y.getLeft().setParent(x); 
        }

        y.setParent(x.getParent());

        if(x.getParent() == null){
            this.setRoot(y);
        } else if (x.equals(x.getParent().getLeft())){
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }

        y.setLeft(x);
        x.setParent(y);
    }

    /* Procedure: rightRotate
    *  Preconditions: the left child of x is not T.nil; the parent of x is T.nil; x is an element of a correct RedBlackTree
    *  Parameters: x, a RedBlackNode
    *  Purpose: rotate to the right (change the pointer structure) the elements of the RedBlackTree around the given parameter
    *  Product: a version of the tree rotated to the right around x
    *  Postconditions: the properties of a red-black tree are all preserved in the rotated version of the tree
    */
    public void rightRotate(RedBlackNode x){
        RedBlackNode y = x.getLeft();
        x.setLeft(y.getRight());

        if(y.getRight() != null){
            y.getRight().setParent(x); 
        }

        y.setParent(x.getParent());

        if (x.getParent() == null){
            this.setRoot(y);
        } else if (x == x.getParent().getRight()){
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }

        y.setRight(x);
        x.setParent(y);
    }

    /* Procedure: insert
    *  Preconditions: the RedBlackTree holds the correct properties of a red-black tree
    *  Parameters: z, a RedBlackNode
    *  Purpose: to add z into a RedBlackTree
    *  Product: the same RedBlackTree but with z added
    *  Postconditions: z is red
    */
    public void insert(RedBlackNode z){
        RedBlackNode y = null;
        RedBlackNode x = this.getRoot();

        while (x != null){
            y = x;

            if (z.getKey() < x.getKey()){
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        z.setParent(y);

        if (y == null) {
            this.setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }

        z.setLeft(null);
        z.setRight(null);
        z.setColor("red");

        this.insertFixup(z);
    }

    /* Procedure: insertFixup
    *  Preconditions: z is part of a RedBlackTree, one that violates the red-black tree properties
    *  Parameters: z, a RedBlackNode
    *  Purpose: to rearrange and/or recolor the nodes of the RedBlackTree z is in to preserve the properties of a red-black tree after an insertion
    *  Product: the tree with the same elements as before
    *  Postconditions: the tree has all the correct properties of a red-black tree
    */
    public void insertFixup(RedBlackNode z) {
        while (!(z.equals(this.getRoot())) && z.getParent().getColor() == "red") {
            if (z.getParent() == z.getParent().getParent().getLeft()) {
                RedBlackNode y = z.getParent().getParent().getRight();

                if (y.getColor() == "red") { // Case 1
                    z.getParent().setColor("black");
                    y.setColor("black");
                    z.getParent().getParent().setColor("red");
                    z = z.getParent().getParent();
                } else{
                    if (z == z.getParent().getRight()) { // Case 2
                    z = z.getParent();
                    this.leftRotate(z);
                    } 

                    z.getParent().setColor("black"); // Case 3
                    z.getParent().getParent().setColor("red");
                    this.rightRotate(z.getParent().getParent());
                }
            } else {
                RedBlackNode y = z.getParent().getParent().getLeft();

                if (y != null && y.getColor() == "red") { // Case 1
                    z.getParent().setColor("black");
                    y.setColor("black");
                    z.getParent().getParent().setColor("red");
                    z = z.getParent().getParent();
                } else { 
                    if (z == z.getParent().getLeft()) { // Case 2
                    z = z.getParent();
                    this.rightRotate(z);
                    }  

                    z.getParent().setColor("black"); // Case 3
                    z.getParent().getParent().setColor("red");
                    this.leftRotate(z.getParent().getParent());
                }
            }

            this.getRoot().setColor("black");
        }
    }

    /* Procedure: transplant
    *  Parameters: u and v, two RedBlackNodes
    *  Purpose: swap u and v’s positions in the tree
    *  Product: the same tree as before with u and v swapped
    */
    public void transplant(RedBlackNode u, RedBlackNode v){
        if (u.getParent() == null) {
            this.root = v;
        } else if (u.equals(u.getParent().getLeft())) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        
        if (v == null){
            return;
        } else {
            v.setParent(u.getParent());
        }
    }

    // Purpose: Find the minimum node of a RedBlackTree given a starting node
    public RedBlackNode treeMinimum (RedBlackNode x){
        while (x.getLeft() != null) {
            x = x.getLeft();
        }

        return x;
    }

    // Purpose: Find the maximum node of a RedBlackTree given a starting node
    public RedBlackNode treeMaximum (RedBlackNode x) {
        while(x.getRight() != null) {
            x = x.getRight();
        }

        return x;
    }

    /* Procedure: deleteFixup
    *  Preconditions: x is part of a RedBlackTree, one that violates the red-black tree properties
    *  Parameters: x, a RedBlackNode
    *  Purpose: to rearrange and/or recolor the nodes of the RedBlackTree z is in to preserve the properties of a red-black tree after a deletion 
    *  Product: the tree with the same elements as before
    *  Postconditions: the tree has all the correct properties of a red-black tree
    */
    public void deleteFixup (RedBlackNode x) {
        while (!(this.getRoot().equals(x)) && (x != null && x.getColor() == "black")) {
            if (x.equals(x.getParent().getLeft())) {
                RedBlackNode w = x.getParent().getRight();

                if (w.getColor() == "red") { // Case 1
                    w.setColor("black");
                    x.getParent().setColor("red");
                    this.leftRotate(x.getParent());
                    w = x.getParent().getRight();
                } 

                if (x.getLeft().getColor() == "black" && w.getRight().getColor() == "black") { // Case 2
                    w.setColor("red");
                    x = x.getParent();
                } else {
                    if (w.getRight().getColor() == "black") { // Case 3
                    w.getLeft().setColor("black");
                    w.setColor("red");
                    this.rightRotate(w);
                    w = x.getParent().getRight();
                    } 
                    
                    w.setColor(x.getParent().getColor()); // Case 4
                    x.getParent().setColor("black");
                    w.getRight().setColor("black");
                    this.leftRotate(x.getParent());
                    x = this.getRoot();
                }
            } else {
                RedBlackNode w = x.getParent().getLeft();

                if (w.getColor() == "red") { // Case 1;
                    w.setColor("black");
                    x.getParent().setColor("red");
                    this.rightRotate(x.getParent());
                    w = x.getParent().getLeft();
                } 

                if (x.getRight().getColor() == "black" && w.getLeft().getColor() == "black") { // Case 2
                    w.setColor("red");
                    x = x.getParent();
                } else {
                    if (w.getLeft().getColor() == "black") { // Case 3
                    w.getRight().setColor("black");
                    w.setColor("red");
                    this.leftRotate(w);
                    w = x.getParent().getLeft();
                    } 

                    w.setColor(x.getParent().getColor()); // Case 4
                    x.getParent().setColor("black");
                    w.getLeft().setColor("black");
                    this.rightRotate(x.getParent());
                    x = this.getRoot();
                }
            }
        }

        if (x == null){
            return;
        } else {
            x.setColor("black");
        }
    }

    /* Procedure: delete
    *  Preconditions: z is part of a RedBlackTree that holds all the correct properties of a red-black tree
    *  Parameters: z, a RedBlackNode
    *  Purpose: to delete z from the RedBlackTree
    *  Product: the original tree but with z removed
    *  Postconditions: z is no longer in the tree; the tree will likely not hold the correct red-black tree properties
    */
    public void delete(RedBlackNode z){
        RedBlackNode y = z;
        RedBlackNode x;
        String y_original_color = y.getColor();

        if (z.getLeft() == null) {
            x = z.getRight();
            this.transplant(z, z.getRight());
        } else if (z.getRight() == null) {
            x = z.getLeft();
            this.transplant(z, z.getLeft());
        } else {
            y = this.treeMinimum(z.getRight());
            y_original_color = y.getColor();
            x = y.getRight();

            if (y.getParent().equals(z)) {
                x.setParent(y);
            } else {
                this.transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }

            this.transplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setColor(z.getColor());
        }

        if (y_original_color == "black") {
            this.deleteFixup(x);
        }
    }
}

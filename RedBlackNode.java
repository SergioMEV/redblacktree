package pset3;

public class RedBlackNode{
    int key;
    RedBlackNode p = null; 
    RedBlackNode left = null;
    RedBlackNode right = null;
    String color = "red";

    public RedBlackNode(int k){
        this.key = k;
    }
    
    // Purpose: access the key parameter of the given RedBlackNode 
    public int getKey(){
        return this.key;
    }

    // Purpose: access the color parameter of the given RedBlackNode
    public String getColor(){
        return this.color;
    }

    // Purpose: access the parent parameter of the given RedBlackNode
    public RedBlackNode getParent(){
        return this.p;
    }

    // Purpose: access the right (right child) parameter of the given RedBlackNode
    public RedBlackNode getRight(){
        return this.right;
    }

    // Purpose: access the left (left child) parameter of the given RedBlackNode
    public RedBlackNode getLeft(){
        return this.left;
    }

    // Purpose: mutate the color parameter of the given RedBlackNode
    public void setColor(String c){
        this.color = c;
    }

    // Purpose: mutate the parent parameter of the given RedBlackNode
    public void setParent(RedBlackNode newParent){
        this.p = newParent;
    }

    // Purpose: mutate the right (right child) parameter of the given RedBlackNode
    public void setRight(RedBlackNode newChild){
        this.right = newChild;
    }

    // Purpose: mutate the left (left child) parameter of the given RedBlackNode
    public void setLeft(RedBlackNode newChild){
        this.left = newChild;
    }
}   
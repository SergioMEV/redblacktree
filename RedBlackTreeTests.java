package redblcaktree;

public class RedBlackTreeTests { 

    /* Procedure: printer
    *  Parameters: node, a RedBlackNode which is the root of a RedBlackTree
    *  Purpose: print on separate lines all of the keys and colors of the nodes of the RedBlackTree that node is the root of
    *  Product: none
    */
    public static void printer(RedBlackNode node){
        if (node == null) {
            return;
        } else {
            System.out.println(node.getKey() + node.getColor());
            printer(node.getLeft());
            printer(node.getRight());
        }
    }

    /* Procedure: checker
    *  Parameters: node, a RedBlackNode which is the root of a RedBlackTree
    *  Purpose: create one long string with all of the keys and colors of the nodes of the RedBlackTree that node is the root of
    *  Product: str, a String
    */
    public static String checker(RedBlackNode node){
        if (node == null) {
            return "";
        } else {
            String left_str = checker(node.getLeft());
            String right_str = checker(node.getRight());
            String str = (node.getKey() + node.getColor()) + left_str + right_str;
            return str;
        }
    }

    // Purpose: test if inserting into a single-node tree works
    public static boolean insertingNodeIntoTreeWith1Node(){
        RedBlackNode rt = new RedBlackNode(1);
        RedBlackTree tree = new RedBlackTree(rt);
        RedBlackNode n = new RedBlackNode(2);
    
        tree.insert(n);
    
        System.out.print("Passed inserting node into tree with 1 node test: ");
        return n.getColor() == "red" && rt.getColor() == "black" && rt.getRight().equals(n);
    }

    // Purpose: test if inserting multiple nodes in order works
    public static boolean InsertingMultipleNodesInOrder() {
        RedBlackNode root = new RedBlackNode(10);
        RedBlackTree tree = new RedBlackTree(root);

        RedBlackNode rnode1 = new RedBlackNode(14);
        tree.insert(rnode1);

        RedBlackNode lnode1 = new RedBlackNode(6);
        tree.insert(lnode1);

        RedBlackNode rnode2 = new RedBlackNode(17);
        tree.insert(rnode2);

        RedBlackNode rnode3 = new RedBlackNode(12);
        tree.insert(rnode3);        

        RedBlackNode lnode2 = new RedBlackNode(8);
        tree.insert(lnode2);

        RedBlackNode lnode3 = new RedBlackNode(4);
        tree.insert(lnode3); 

        RedBlackNode lnode4 = new RedBlackNode(5);
        tree.insert(lnode4);

        System.out.print("Passed Inserting Multiple Nodes in order test: ");
        return checker(root).equals("10black6red4black5red8black14black12red17red");
    }

    // Purpose: test if inserting multiple nodes out of order works
    public static boolean InsertingMultipleNodesOutOfOrder() {
        RedBlackNode root = new RedBlackNode(10);
        RedBlackTree tree = new RedBlackTree(root);

        RedBlackNode rnode1 = new RedBlackNode(14);
        tree.insert(rnode1);

        RedBlackNode lnode1 = new RedBlackNode(13);
        tree.insert(lnode1);

        RedBlackNode rnode2 = new RedBlackNode(12);
        tree.insert(rnode2);

        RedBlackNode rnode3 = new RedBlackNode(17);
        tree.insert(rnode3);        

        RedBlackNode lnode2 = new RedBlackNode(18);
        tree.insert(lnode2);

        RedBlackNode lnode3 = new RedBlackNode(16);
        tree.insert(lnode3); 

        RedBlackNode lnode4 = new RedBlackNode(23);
        tree.insert(lnode4);

        System.out.print("Passed Inserting Multiple Nodes Out of Order test: ");
        return checker(lnode1).equals("13black10black12red17red14black16red18black23red");
    }


    // Purpose: test if leftRotate works on a small tree
    public static boolean LeftRotateTreeWithThreeNodes(){
        RedBlackNode root = new RedBlackNode(2);
        RedBlackNode left = new RedBlackNode(1);
        RedBlackNode right = new RedBlackNode(3);
        RedBlackTree tree = new RedBlackTree(root);
        
        tree.insert(left);
        tree.insert(right);

        tree.leftRotate(root);

        System.out.print("Passed Left Rotate with three nodes test: ");
        return checker(right).equals("3red2black1red");
    }

    // Purpose: test if multiple leftRotates works on a larger tree
    public static boolean LeftRotateTreeWithManyNodes() {
        RedBlackNode root = new RedBlackNode(10);
        RedBlackTree tree = new RedBlackTree(root);

        RedBlackNode rnode1 = new RedBlackNode(14);
        tree.insert(rnode1);

        RedBlackNode lnode1 = new RedBlackNode(13);
        tree.insert(lnode1);

        RedBlackNode rnode2 = new RedBlackNode(12);
        tree.insert(rnode2);

        RedBlackNode rnode3 = new RedBlackNode(17);
        tree.insert(rnode3);        

        RedBlackNode lnode2 = new RedBlackNode(18);
        tree.insert(lnode2);

        RedBlackNode lnode3 = new RedBlackNode(16);
        tree.insert(lnode3); 

        RedBlackNode lnode4 = new RedBlackNode(23);
        tree.insert(lnode4);

        tree.leftRotate(rnode3);

        tree.leftRotate(lnode1);
        
        System.out.print("Passed Multiple Left Rotates test:");
        return checker(lnode2).equals("18black13black10black12red17red14black16red23red");
    }

    // Purpose: test if rightRotate works on a small tree
    public static boolean RightRotateTreeWithThreeNodes(){
        RedBlackNode root = new RedBlackNode(2);
        RedBlackNode left = new RedBlackNode(1);
        RedBlackNode right = new RedBlackNode(3);
        RedBlackTree tree = new RedBlackTree(root);
        
        tree.insert(left);
        tree.insert(right);

        tree.rightRotate(root);
    
        System.out.print("Passed Right Rotate with three nodes test: ");
        return checker(left).equals("1red2black3red");
    }

    // Purpose: test if multiple rightRotates works on a larger tree
    public static boolean RightRotateTreeWithManyNodes() {
        RedBlackNode root = new RedBlackNode(10);
        RedBlackTree tree = new RedBlackTree(root);

        RedBlackNode rnode1 = new RedBlackNode(14);
        tree.insert(rnode1);

        RedBlackNode lnode1 = new RedBlackNode(13);
        tree.insert(lnode1);

        RedBlackNode rnode2 = new RedBlackNode(12);
        tree.insert(rnode2);

        RedBlackNode rnode3 = new RedBlackNode(17);
        tree.insert(rnode3);        

        RedBlackNode lnode2 = new RedBlackNode(18);
        tree.insert(lnode2);

        RedBlackNode lnode3 = new RedBlackNode(16);
        tree.insert(lnode3); 

        RedBlackNode lnode4 = new RedBlackNode(23);
        tree.insert(lnode4);
        
        tree.rightRotate(rnode3);

        tree.rightRotate(lnode1);

        System.out.print("Passed Multiple Right Rotates test:");
        return checker(lnode2).equals("10black13black12red14black17red16red18black23red");
    }

    // Purpose: test if delete works for a red leaf node
    public static boolean DeletingRedLeafNode(){
        RedBlackNode root = new RedBlackNode(10);
        RedBlackTree tree = new RedBlackTree(root);

        RedBlackNode rnode1 = new RedBlackNode(14);
        tree.insert(rnode1);

        RedBlackNode lnode1 = new RedBlackNode(6);
        tree.insert(lnode1);

        RedBlackNode rnode2 = new RedBlackNode(17);
        tree.insert(rnode2);

        RedBlackNode rnode3 = new RedBlackNode(12);
        tree.insert(rnode3);        

        RedBlackNode lnode2 = new RedBlackNode(8);
        tree.insert(lnode2);

        RedBlackNode lnode3 = new RedBlackNode(4);
        tree.insert(lnode3); 

        RedBlackNode lnode4 = new RedBlackNode(5);
        tree.insert(lnode4);

        tree.delete(rnode2);

        System.out.print("Passed Deleting Red Leaf Node test:");
        return checker(root).equals("10black6red4black5red8black14black12red");
    }

    // Purpose: test if delete works for a black leaf node
    public static boolean DeletingBlackLeafNode(){
        RedBlackNode root = new RedBlackNode(10);
        RedBlackTree tree = new RedBlackTree(root);

        RedBlackNode rnode1 = new RedBlackNode(14);
        tree.insert(rnode1);

        RedBlackNode lnode1 = new RedBlackNode(6);
        tree.insert(lnode1);

        RedBlackNode rnode2 = new RedBlackNode(17);
        tree.insert(rnode2);

        RedBlackNode rnode3 = new RedBlackNode(12);
        tree.insert(rnode3);        

        RedBlackNode lnode2 = new RedBlackNode(8);
        tree.insert(lnode2);

        RedBlackNode lnode3 = new RedBlackNode(4);
        tree.insert(lnode3); 

        RedBlackNode lnode4 = new RedBlackNode(5);
        tree.insert(lnode4);

        tree.delete(lnode2);

        System.out.print("Passed Deleting Black Leaf Node test:");
        return checker(root).equals("10black6red4black5red14black12red17red");
    }

    // Purpose: test if deleting multiple nodes works correctly
    public static boolean MultipleDeletesOnLargerTree() {
        RedBlackNode root = new RedBlackNode(10);
        RedBlackTree tree = new RedBlackTree(root);

        RedBlackNode rnode1 = new RedBlackNode(14);
        tree.insert(rnode1);

        RedBlackNode lnode1 = new RedBlackNode(13);
        tree.insert(lnode1);

        RedBlackNode rnode2 = new RedBlackNode(12);
        tree.insert(rnode2);

        RedBlackNode rnode3 = new RedBlackNode(17);
        tree.insert(rnode3);        

        RedBlackNode lnode2 = new RedBlackNode(18);
        tree.insert(lnode2);

        RedBlackNode lnode3 = new RedBlackNode(16);
        tree.insert(lnode3); 

        RedBlackNode lnode4 = new RedBlackNode(23);
        tree.insert(lnode4);

        tree.delete(root); 
        tree.delete(rnode3);
        tree.delete(lnode1);

        System.out.print("Passed Deleting Multiple Nodes test: ");
        return checker(rnode1).equals("14black12black18red16black23black");
    }

    public static void main(String args[]){
        System.out.println(insertingNodeIntoTreeWith1Node());
        System.out.println(InsertingMultipleNodesInOrder());
        System.out.println(InsertingMultipleNodesOutOfOrder());
        System.out.println(LeftRotateTreeWithThreeNodes());
        System.out.println(LeftRotateTreeWithManyNodes());
        System.out.println(RightRotateTreeWithThreeNodes());
        System.out.println(RightRotateTreeWithManyNodes());
        System.out.println(DeletingRedLeafNode());
        System.out.println(DeletingBlackLeafNode());
        System.out.println(MultipleDeletesOnLargerTree());
    }
    
}

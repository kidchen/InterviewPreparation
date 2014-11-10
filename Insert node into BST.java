// recursion

public void insertNode(int key) {
    root = insertNode(root, new Node(key));
}
//private recursive call
private Node insertNode(Node currentParent, Node newNode) {
    if (currentParent == null) 
        return newNode;
    else if (newNode.val > currentParent.val)
        currentParent.right = insertNode(currentParent.right, newNode);
    else if (newNode.val < currentParent.val)
        currentParent.left = insertNode(currentParent.left, newNode);
    return currentParent; 
}


// iterative

public void insertNode(Node root, int key) { 
    Node newNode = new Node(key);
    if (root == null) {
        root = newNode;
        return; 
    }
    Node parent = null; 
    Node cur = root; 
    while (cur != null) {
        parent = cur; 
        if(newNode.val < cur.val) {
            cur = cur.left;
        } else if (newNode.val > cur.val) {
            cur = cur.right; 
        } else {
        // overwrite duplicate 
            cur = newNode; 
            return;
        }
    }
    int res = key.compareTo(parent.key); 
    if (key < parent.val) {
        parent.left = newNode; 
    } else {
        parent.right = newNode; 
    }
    return; 
}

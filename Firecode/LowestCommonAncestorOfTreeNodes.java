public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
    if(root == null) return root;
    
    ArrayList<TreeNode> asancestors = new ArrayList<TreeNode>();
    ancestry(root, a, asancestors);
    ArrayList<TreeNode> bsancestors = new ArrayList<TreeNode>();
    ancestry(root, b, bsancestors);

    TreeNode lca = root, tempA = null, tempB = null;
    Iterator <TreeNode>itA = asancestors.iterator();
    Iterator <TreeNode> itB = bsancestors.iterator();
    Iterator <TreeNode> it = asancestors.size() <= bsancestors.size() ? itA : itB;
    while(it.hasNext()) {
        tempA = itA.next();
        tempB = itB.next() ;
        if(tempA.data == tempB.data) {
            lca = tempA;
        } else break;
    }
    return lca;
}

public boolean ancestry(TreeNode root, TreeNode node, ArrayList<TreeNode> ancestors){
    if(root == null) return false;
    ancestors.add(root);

    if(root.data == node.data) return true;
    
    boolean leftFound = false;
    leftFound = ancestry(root.left, node, ancestors);
    if(leftFound) return leftFound;
    
    boolean rightFound = false;
    rightFound = ancestry(root.right, node, ancestors);
    if(rightFound) return rightFound;
    
    ancestors.remove(root);
    return false;
}


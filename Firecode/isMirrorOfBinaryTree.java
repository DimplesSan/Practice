public boolean isMirror(TreeNode root1, TreeNode root2) {
  if(root1 == null && root2 == null) { return true; }
  if((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
  if(root1.data != root2.data) { return false; }
  
  return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
}

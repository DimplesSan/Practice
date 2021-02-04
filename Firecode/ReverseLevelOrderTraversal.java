public ArrayList<Integer> levelorderRev(TreeNode root) {
  ArrayList<Integer> reversedList = new ArrayList<Integer>();
  if(root == null) return reversedList;

  Stack<Integer> stk = new Stack<Integer>();
  Queue<TreeNode> q = new LinkedList<TreeNode>();
  q.add(root);
  TreeNode c = null;
  while(!q.isEmpty()) {
    c = q.poll();
    stk.push(c.data);

    if(c.right != null) q.add(c.right);
    if(c.left != null) q.add(c.left);
  }

  while(!stk.isEmpty()) {
    reversedList.add(stk.pop());
  }

  return reversedList;
}

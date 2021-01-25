// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode mergeKLists(ArrayList<ListNode> lists) {
  if(lists == null) return null;
  if(lists.size() == 1 ) return list.get(0);

  ListNode newHead;
  for(int i=0; i<lists.size()-1; i++) {
    newHead = merge2Lists(lists.get(i), lists.get(i+1));
  }  

  return newHead;
}

// 4 6   1 3 5
// 
// 
// m(4,1) 
//   - m(4,3)
//     - m(4, 5)  4 -> 5 -> 6
//       - m(6, 5) 5->6
//         - m(6, null)
public ListNode merge2Lists(ListNode l1, ListNode l2) {
  if(l1 == null && l2 == null) return null;
  if(l1 == null) return l2;
  if(l2 == null) return l1;

  ListNode newHead;
  if(l1.data <= l2.data) {
    newHead = l1;
    newHead.next = merge2Lists(l1.next, l2);
  } else {
    newHead = l2;
    newHead.next = merge2Lists(l1, l2.next);
  }

  return newHead;
}  



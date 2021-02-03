// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode mergeKLists(ArrayList<ListNode> lists) {
  PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
      new Comparator<ListNode>() {
        public int compare(ListNode n1, ListNode n2) {
          if(n1.data < n2.data) return -1;
          else if(n1.data == n2.data) return 0;
          else return 1;
        }
      });

  for(ListNode n: lists) { pq.add(n); }

  ListNode newHead = null, current = null, prev = null;
  while(!pq.isEmpty()) {
    current = pq.poll();
    if(current.next != null) pq.add(current.next);

    if(prev == null) {
      newHead = current;
    } else {
      prev.next = current;
    }

    prev = current;
  }

  return newHead;
//  if(lists == null) return null;
//  if(lists.size() == 1 ) return lists.get(0);

//  ListNode newHead = lists.get(0);
//  for(int i=1; i<lists.size(); i++) {
//    newHead = merge2Lists(newHead, lists.get(i));
//  }  
//
//  return newHead;
}

// 4 6   1 3 5
// 
// 
// m(4,1) 
//   - m(4,3)
//     - m(4, 5)  4 -> 5 -> 6
//       - m(6, 5) 5->6
//         - m(6, null)
//public ListNode merge2Lists(ListNode l1, ListNode l2) {
//  if(l1 == null && l2 == null) return null;
//  if(l1 == null) return l2;
//  if(l2 == null) return l1;
//
//  ListNode newHead = null;
//  if(l1.data <= l2.data) {
//    newHead = l1;
//    newHead.next = merge2Lists(l1.next, l2);
//  } else {
//    newHead = l2;
//    newHead.next = merge2Lists(l1, l2.next);
//  }
//
//  return newHead;
//}  
//
//)

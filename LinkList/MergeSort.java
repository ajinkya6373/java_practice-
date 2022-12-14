package LinkList;

import java.util.List;
//
//public class MergeSort {
//
//    public LL.Node ListSort(LL.Node list){
//        if (list!=null &&list.next!=null){
//            return list;
//        }
//
//    }
//
//    public static LL.Node getMid(LL list){
//        LL.Node fast = list.head;
//        LL.Node slow = list.head;
//        while (fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//
//    public static LL merge(LL list1, LL list2){
//        LL.Node first = list1.head;
//        LL.Node second = list2.head;
//        LL ans = new LL();
//        while (first!=null && second!= null){
//            if (first.value<second.value){
//                ans.insertLast(first.value);
//                first = first.next;
//            }else {
//                ans.insertLast(second.value);
//                second=second.next;
//            }
//        }
//        while (first!=null){
//            ans.insertLast(first.value);
//            first = first.next;
//        }
//        while (second!=null){
//            ans.insertLast(second.value);
//            second = second.next;
//        }
//        return ans;
//    }
//}

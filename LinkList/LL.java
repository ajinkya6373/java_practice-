package LinkList;

import java.util.List;

public class LL {
    private Node head;
    private Node tail;
    public int size;

    public LL() {
        this.size = 0;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        if (head == null){
            insertFirst(val);
        }
        else{
            Node node = new Node(val);
            tail.next = node;
//            node.next=null;  no need
            tail = node;
            size += 1;
        }
    }

    public void  insertAtposition(int val, int index ){
        if(index ==0) {
            insertFirst(val);
        }else if(index==size){
            insertLast(val);
        }else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp= temp.next;
            }
            Node node = new Node(val,temp.next);
//            node.next = temp.next;  this also works
            temp.next=node;
            size+=1;
        }
    }

    int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head ==null){
            tail =null;
        }
        size--;
        return  val;
    }

    Node getNode(int index){
        Node temp = head;
        for (int i = 0; i <index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    int deleteLast(){
        if (size<=1){
            return  deleteFirst();
        }
        Node prevNode = getNode(size-2);
        int val = tail.value;
        tail = prevNode;
        prevNode.next =null;
        size--;
        return val;
    }

    int delete(int index){
        if (index<=1){
           return deleteFirst();
        }
        else if (index==size){
            return  deleteLast();
        }
        else {
            Node prevNode = getNode(index-1);
            int val = prevNode.next.value;
            prevNode.next = prevNode.next.next;
            return  val;

        }
    }

    class Node {
        int value;
        Node next;
        public Node(int val) {
            this.value = val;
        }
        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }

    }
    public void cycle(int val,int Linkvalue){
        Node temp = head;
        while (temp.next.value!=Linkvalue){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        tail.next = node;
    }

    void  insertRes(int val, int index){
        head =resInsrt(val,index,head);
    }

    private Node resInsrt(int val , int index, Node node){
        if (index ==0){
            Node newNode = new Node(val,node);
            size++;
            return newNode;
        }
       node.next= resInsrt(val, index-1,node.next);
        return node;
    }


    // question
    //1 remove duplicates elements
    public void duplicates(){
        Node temp = head;
        while (temp.next != null){
            if (temp.value == temp.next.value){
                temp.next = temp.next.next;
                size--;
            }else {
                temp =temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    public static LL merge(LL list1, LL list2){
        Node first = list1.head;
        Node second = list2.head;
        LL ans = new LL();
        while (first!=null && second!= null){
            if (first.value<second.value){
                ans.insertLast(first.value);
                first = first.next;
            }else {
                ans.insertLast(second.value);
                second=second.next;
            }
        }
        while (first!=null){
            ans.insertLast(first.value);
            first = first.next;
        }
        while (second!=null){
            ans.insertLast(second.value);
            second = second.next;
        }
        return ans;
    }

    // cycle detection in linkList
//  https://leetcode.com/problems/linked-list-cycle/submissions/

    public static boolean cycleDetect(LL list){
            Node fast = list.head;
            Node slow = list.head;
            while (fast!=null && fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return  false;
    }
    public static int lenOfcycle(LL list){
        Node fast =list.head;
        Node slow =list.head;
        int size =0;
        while (fast!=null && fast.next!=null){
            fast =fast.next.next;
            slow=slow.next;
            if (fast==slow){
                Node temp = slow;
                do{
                    temp = temp.next;
                    size+=1;
                }while (temp!=fast);
                break;
            }
        }
        return size;
    }

    // detect the cycle
    public static Node detectCycle(LL list){
        Node first = list.head;
        Node second = list.head;
        Node fast = list.head;
        Node slow = list.head;
        int length =0;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lenOfcycle(list);
                break;
            }
        }
        if (length ==0){
            return  null;
        }
        while (length>0){
            second = second.next;
            length--;
        }
        while (first!=second){
            first =first.next;
            second = second.next;
        }

        return first;
    }

//    https://leetcode.com/problems/happy-number/
    public static boolean isHappy(int n) {
        int slow = n;
        int fast =n;
        do {
            slow = squre(slow); // moving 1 index
            fast = squre(squre(fast)); // moving 2 index
        }while (slow!=fast);
        if (slow ==1) {
            return true;
        }
        return false;
    }
    private static int squre(int n){
        int ans =0;
        while (n>0){
            int rem = n%10;
            ans +=rem*rem;
            n=n/10;
        }
        return ans;
    }

    public static Node getMid(LL list){
        Node fast = list.head;
        Node slow = list.head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
public void bubbleSort(){
        bubble(size-1,0);
    }
    private void bubble(int row, int col){
        if (row==0){
            return;
        }
        if (col<row){
            Node first = getNode(col);
            Node second = getNode(col+1);
            if (first.value>second.value){
                if (first==head){
                    head = second;
                    first.next =second.next;
                    second.next =first;
                }else if (second==tail){
                    Node p = getNode(col-1);
                    p.next = second;
                    tail = first;
                    first.next = null;
                    second.next = first;
                }else {
                    Node p = getNode(col-1);
                    p.next = second;
                    first.next =second.next;
                    second.next = first;
                }
            }
            bubble(row,col+1);
        }else {
            bubble(row-1,0);
        }
    }

    private void reverseList(Node node){
        if (node==tail){
            head =tail;
            return;
        }
        reverseList(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    private void res(){
        if (size<2){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while (present!=null){
            present.next =prev;
            prev = present;
            present = next;
            if (next!=null){
                next = next.next;
            }
        }
        head = prev;
    }
    public static void main(String[] args) {

//        LL linkList = new LL();
//        linkList.insertFirst(12);
//        linkList.insertFirst(13);
//        linkList.insertLast(90);
//        linkList.insertAtposition(34,1);
//        linkList.insertAtposition(3,4);
//        linkList.display();
////        System.out.println(linkList.deleteFirst());
////        System.out.println(linkList.deleteLast());
////        System.out.println(linkList.delete(2));
//        linkList.insertRes(2,3);
//        linkList.display();

        // questions

//        LL List = new LL();
//        List.insertFirst(1);
//        List.insertFirst(1);
//        List.insertFirst(12);
//        List.insertFirst(12);
//        List.insertFirst(45);
//        List.insertFirst(89);
//        List.insertFirst(89);
//        List.display();
//        List.duplicates();
//        List.display();

        // merge lists
//        LL list1 = new LL();
//        LL list2 = new LL();
//
//        list1.insertLast(1);
//        list1.insertLast(3);
//        list1.insertLast(5);
//
//        list2.insertLast(1);
//        list2.insertLast(2);
//        list2.insertLast(9);
//        list2.insertLast(14);
//
//        LL ans = LL.merge(list1, list2);
//        list1.display();
//        list2.display();
//        ans.display();

        LL list = new LL();
        list.insertLast(1);
        list.insertLast(15);
        list.insertLast(23);
        list.insertLast(4);
        list.insertLast(53);
        list.insertLast(6);
        list.insertLast(7);
//        list.cycle(8,4);
//        System.out.println(LL.cycleDetect(list));
//        System.out.println(LL.lenOfcycle(list));
//        System.out.println(detectCycle(list).value);

//        System.out.println(LL.isHappy(19));
//        System.out.println(LL.getMid(list).value);
        list.display();
//        list.bubbleSort();
//        list.reverseList(list.head);
        list.res();
        list.display();



    }

}

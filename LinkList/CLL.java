package LinkList;

public class CLL {
    private Node head;
    private Node tail;


    public void insert(int val){
        Node node = new Node(val);
        if (head==null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }
    public Node find(int after){
        Node temp = head;
        while (temp != tail){
            if (temp.val==after){
                return temp;
            }
            temp = temp.next;
        }
        return  null;
    }
    public void insertIndex(int val, int after){
        Node p = find(after);
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
    }
    public void display(){
        Node node = head;
        do{
            System.out.print(node.val+"->");
            node = node.next;
        } while (node!=head);
        System.out.println("HEAD");
    }

    public void delete(int val){
        Node temp = head;
        if (head.val == val){
            head = head.next;
            tail = tail.next;
            return;
        }
        if (temp == null) {
            return;
        }
        if (head == tail){
            head = null;
            tail = null;
            return;
        }
        do{
            if(temp.next.val == val){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        } while (temp !=head);
    }
    class  Node {
       private int val;
       private Node next;

       Node(int val){
           this.val = val;
       }
    }


    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(12);
        list.insert(13);
        list.insert(14);
        list.insert(15);
//        list.insertIndex(90,12);
//        list.insertIndex(91,14);
        list.display();
        list.delete(12);
        list.insertIndex(8,15);
        list.display();
    }
}

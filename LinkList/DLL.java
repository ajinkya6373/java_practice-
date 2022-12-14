package LinkList;

public class DLL {
    private Node head;

    public void insertFrist(int val){
        Node node = new Node(val);
        node.next = head;
        node.prv = null;
        if (head !=null){
            head.prv = node;
        }
        head =node;
    }
    public void  insertLast(int val){
        if (head ==null){
            insertFrist(val);
        }else {
            Node temp = head;
            while (temp.next !=null) {
                temp = temp.next;
            }
            Node node = new Node(val);
            temp.next = node;
            node.next=null;
            node.prv = temp;
        }
    }

    public  Node find(int val){
        Node temp =head;
        while (temp !=null){
            if (temp.val==val){
                return temp;
            }
            temp = temp.next;
        }
        return  null;
    }
    public void  insert(int after,int val){
        Node prv = find(after);
        if (prv ==null){
            System.out.println("dose not exist");
        }
        Node node = new Node(val);
        node.prv = prv;
        node.next = prv.next;
        prv.next = node;
        if (node.next !=null){
            node.next.prv =node;
        }

    }

    public void deleteFirst(){
        if (head ==null){
            System.out.println("empty list");
        }else if(head.next ==null){
            head=null;
        }else {
            head=head.next;
            head.prv=null;
        }
    }
    public void delete(int val){
        Node node = find(val);
        if ( node.prv ==null){
            deleteFirst();
            return;
        }
        node.prv.next =node.next;
        if (node.next ==null){
            node.prv.next=null;
            node.prv = null;
        }else {
            node.next.prv = node.prv;
        }

    }


    private class Node{
        int val;
        Node next;
        Node prv;
        Node(int val){
            this.val =val;
        }
        Node(int val, Node next, Node prv){
            this.val =val;
            this.next = next;
            this.prv=prv;

        }
    }

    public void display(){
        Node temp = head;
        Node last = null;
        while (temp != null){
            System.out.print(temp.val + "->");
            last = temp;
            temp =temp.next;
        }
        System.out.println("END");
        System.out.println("revers print");
        while (last!=null){
            System.out.print(last.val + "->");
            last = last.prv;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        DLL dl = new DLL();
        dl.insertFrist(12);
        dl.insertFrist(14);
//        dl.insertFrist(11);
        dl.insertLast(89);
//        dl.insert(89,5);
        dl.display();
//        dl.deleteFirst();
        dl.delete(89);
        dl.display();

    }
}

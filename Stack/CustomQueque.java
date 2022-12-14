package Stack;

public class CustomQueque {
    private int [] data;
    protected static final  int DEFAULT_SIZE=5;
    int end =0;
    public CustomQueque(int size) {
        this.data = new int[size];

    }
    public CustomQueque(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull(){
        return end==data.length;
    }
    public boolean isEmpty(){
        return end ==0;
    }
    public void add(int val) throws Exception {
        if (isFull()){
            throw new Exception("queue is full");
        }
        else {
            data[end++] =val;
        }

    }

    public void remove() throws Exception{
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        else {
            for (int i = 1; i <end; i++) {
                data[i-1] = data[i];
            }
            end--;
        }
    }

    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        else {
            return data[0];
        }
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+"<-");
        }
        System.out.println("END");
    }


    public static void main(String[] args) throws Exception {
        CustomQueque Q = new CustomQueque(5);
        Q.add(3);
        Q.add(6);
        Q.add(5);
        Q.add(19);
        Q.add(1);
        Q.display();
        Q.remove();


        Q.display();            
    }
}

package Stack;

public class CustomStack {
    protected int [] data;
    private static final int DEFAULT_SIZE =5;
    int  ptr = -1;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];

    }

    public void push(int val) throws CustomException {
        if (isFull()){
                throw new CustomException("Stack is full");
        }else {
            ptr++;
            data[ptr] = val;
        }
    }

    public int pop() throws CustomException {
        if (isEmpty()){
            throw new CustomException("stack is empty");
        }
        int ele = data[ptr--];
        return ele;
    }

    public int peek() throws CustomException {
        if (isEmpty()){
            throw new CustomException("stack is empty");
        }
        else {
            return data[ptr];
        }
    }

    public boolean isFull() {
        return ptr==data.length-1;
    }

    public boolean isEmpty(){
        return ptr ==-1;
    }

    public static void main(String[] args) throws CustomException {
        CustomStack stack = new DynamicStack();
        stack.push(12);
        stack.push(2);
        stack.push(4);
        stack.push(4);
        stack.push(9);
        stack.push(9);
//
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.peek());
    }
}

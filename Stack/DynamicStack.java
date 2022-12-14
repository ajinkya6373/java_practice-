package Stack;

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }

    @Override
    public void push(int val) throws CustomException {
        if (this.isEmpty()){
            int [] temp = new int[data.length *2];
            // copy elements from data to temp
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data =temp;
        }
        // at this point we know array is not full insert it normally

             super.push(val);

    }
}

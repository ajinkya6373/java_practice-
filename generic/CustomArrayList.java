package generic;


import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(90);
//        list.get(0);
//        list.remove(0);
//        list.set(0,9);
        CustomList list = new CustomList();
//        list.add(12);
        for (int i = 0; i < 10; i++) {
            list.add(2*i);
        }
        System.out.println(list);
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list);
    }



}

class CustomList{
    private int[] data;
    private int DEFALUT_SIZE =5;
    private int size =0;

    CustomList(){
        this.data = new int[DEFALUT_SIZE];
    }

    void add(int value){
        if(isFull()){
            resize();
        }else {
            data[size++] = value;
        }
    }

    private boolean isFull(){
        return size == data.length;
    }

    private void resize(){
        int [] temp = new int[data.length *2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

   public int remove (){
        int removed = data[--size];
        return removed;
    }
    public void set(int index, int value) {
        data[index] = value;
    }

    public int get(int index) {
        return data[index];
    }


    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }




}


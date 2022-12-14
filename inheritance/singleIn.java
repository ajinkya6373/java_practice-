package inheritance;
public class singleIn {
    public static void main(String[] args) {
        BoxWeight box1 = new BoxWeight();
        BoxWeight box2 = new BoxWeight(1,2,4,5);
//        System.out.println(box2.w);

        // we can create parent object reference to child class but parent class can not use child class properties;
        Box box3 = new BoxWeight(1,2,2,2);
        Box box4 = new Box(box1);
        BoxWeight box5 = new BoxWeight(1,50,3,45);
        BoxWeight box6 = new BoxWeight(box5);

        System.out.println(box6.l);
    }
}

class  Box{
    int h;
    int l;
    int w;

    Box(){
        this.h=-1;
        this.l=-1;
        this.w=-1;
    }
    Box(int h, int l,int w){
        this.h=h;
        this.l=l;
        this.w=w;
    }

    Box(Box other){
        this.h = other.h;
        this.l = other.l;
        this.w = other.w;
    }
}

class  BoxWeight extends Box{
    int weight;

    BoxWeight (){
        // super keyWord is uses to call constructor of parent class
        super();
        this.weight =-1;
    }
    BoxWeight (int h, int l, int w, int weight){
        super(h,l,w);
        this.weight = weight;
    }

    BoxWeight(BoxWeight other){
        super(other);
        this.weight = other.weight;
    }

}
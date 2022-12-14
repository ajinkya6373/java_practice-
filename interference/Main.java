//package interference;
//
//public class Main {
//    public static void main(String[] args) {
//        Engine normalCar = new Car();
//        normalCar.start();
//        Car car2 = new Car();
//        car2.pause();
//        System.out.println(Engin.PRICE);
//        Car car3 = new Car();
//        car3.a=90; this will not work because it is final

//        Car car4 = new Car();
//        Car car5 = new Car(new PowerEngine());
//        Car car6 = new Car(new ElectricEngine());
//        car4.startEngine();
//        car4.stopEngine();

//        car4.upgradeEngine();  // we upgrade engine from default powerEngine to electric
//        car4.startEngine();
//        car4.stopEngine();
//        Engine.greet();

//    }
//}
//
//interface Brake{
//    void brake();
//}
//interface Engine{
//    final static int PRICE = 78000;
//    void start();
//    void stop();
//    static  void greet(){
//        System.out.println("static interfaces method always should have body");
//        System.out.println("and static method neither get inherit nor overRidden");
//    }
//}
//
//interface Media{
//    void  start();
//    void  pause();
//

//}
//
//class  PowerEngine implements Engine{
//    @Override
//    public void start() {
//        System.out.println("powerEngine start");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("powerEngine stop");
//    }
//}
//class  ElectricEngine implements Engine{
//    @Override
//    public void start() {
//        System.out.println("ElectricEngine start");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("ElectricEngine stop");
//    }
//}
//
//class MediaPlayer implements Media{
//    @Override
//    public void start() {
//        System.out.println("music start");
//    }
//
//    @Override
//    public void pause() {
//        System.out.println("music pause");
//
//}
//
//
//class Car {
//    private Engine engine;
//    private Media music  = new MediaPlayer();
//
//   public Car(){
//        engine = new PowerEngine();
//    }
//    public Car(Engine engine){
//        this.engine = engine;
//    }
//
//    void startEngine (){
//        engine.start();
//    }
//    void stopEngine(){
//        engine.stop();
//    }
//    void startPlayer(){
//        music.start();
//    }
//    void stopMusic(){
//        music.pause();
//    }
//
//    public void upgradeEngine() {
//        this.engine = new ElectricEngine();
//    }
//}
//

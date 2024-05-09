interface myInterface{
    void method1();
    String method2();
}
class ABC implements myInterface{
    public void method1(){

        System.out.println("Hello");
    }
    public String method2(){
        return "9 May";
    }
    void method3(){
        System.out.println("Blah blah blah");
    }
}
public class Main {
    public static void main(String[] args) {
        ABC obj = new ABC();
        obj.method1();
        System.out.println(obj.method2());
        obj.method3();
    }
}

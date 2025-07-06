package AJava;

public class Base {
    static int staticAV = 10;
    int nonstaticBV = 20;

    public Base() {
        System.out.println("Parent constructor called");
    }
    public static void  staticMethod(){
        System.out.println("Inside parent static method");
        // JavaP obj = new JavaP();
        // obj.nonStaticMethod();
    }
    public void  nonStaticMethod(){
        System.out.println("Inside parent non-static method");
        //  JavaP.staticMethod();
    }

    public void MOL(){
        System.out.println("Parent MOL");
    }
    public void MOR(){
        System.out.println("Parent MOR");
    }

    public void engine(){                                   // Object Composition parent
        System.out.println("engine will run");
    }
    public int E1 = 10;

    String name;                                          // Genric
    Base(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}

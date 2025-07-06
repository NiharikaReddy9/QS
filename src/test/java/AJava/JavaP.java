package AJava;

import java.util.Arrays;

public class JavaP extends Base{
    static int staticAV = 10;
    int nonstaticBV = 20;
    int a ;
    public static void  staticMethod(){
        System.out.println("Inside static method");
         // JavaP obj = new JavaP();
         // obj.nonStaticMethod();
    }
    public void  nonStaticMethod(){
        System.out.println("Inside non-static method");
         //  JavaP.staticMethod();
    }

    public void m2(){
        System.out.println("Inside plain method");
    }
    public int m3(){
        return 30;
    }

    public JavaP(int num){
        super();
        this.a = num;
        System.out.println("Child constructor called");
    }

    public void this_super(){
        this.nonStaticMethod();
        super.nonStaticMethod();
        JavaP.staticMethod();
        Base.staticMethod();
        System.out.println(super.nonstaticBV+" "+this.nonstaticBV);
        System.out.println(JavaP.staticAV+" "+this.staticAV);
    }
    public void MOL(int num){
        System.out.println("Child MOL");
    }
    public void MOR(){
        System.out.println("Child MOR");
    }

    Base b;
    public JavaP(Base b){
        this.b = b;
    }
    public void ObjectComposition(){
        b.engine();
        System.out.println(b.E1);
    }


    public static void main(String[] args) {
        JavaP.staticMethod();
        JavaP obj = new JavaP(40);
        obj.nonStaticMethod();
        obj.m2();
        System.out.println(obj.m3());
        System.out.println(obj.a);
        obj.this_super();

        System.out.println("-----------------------");

        Base ob1 = new Base();           // without extends keyword we can create java obj
        ob1.MOL();
        ob1.MOR();
        JavaP ob2 = new JavaP(40);
        ob2.MOL(1);
        ob2.MOR();
        ob2.MOL();

        Base ob3 = new JavaP(40);          // ✅ upcasting  extends Required ( Relation should be there otheer wise we get relation problem )
        ob3.MOL();                              // method resolution is taken care by compiler Left
        ob3.MOR();                              // method resolution is taken care by JVM     Right
        JavaP ob4 = (JavaP)ob2;                 // ✅ downcasting -> Parent ref can hold childclass BUT clild ref cant hold parent class to do it we need to dowcast it
        ob4.MOL(1);                        // Vicecersa same all this aboveslines we can write in parent class also. Even upcast and downcast is also possible
        ob4.MOR();
        ob4.MOL();

        JavaP objC2 = new JavaP(new Base());    // |  Base objC1 = new Base(); -> objC1.engine(); System.out.println(objC1.E1);
        objC2.ObjectComposition();

        Base[] bGen = new Base[3];
        bGen[0] = new Base("java");
        bGen[1] = new Base("selenium");
        //bGen[3] = new Base(12);
        System.out.println(Arrays.toString(bGen));
        System.out.println(bGen[0].name);
    }
}


/*
Rememeber
1) void     → no return         → call it directly
2) non-void → returns something → use System.out.println(...)
3) public JavaP(){ }            → If we put void or return in con even con is consider as method
                                → Constructor should be in 1st line
                                → call constructor only inside constructor
4) this & super                 → this and supe keywords are not used in static method its alooed only in nonstsic methods
                                  Because static methods do not belong to any object, they belong to the class itself.
                                  🧠 inside static method — there is no current object, so this or super would have no meaning.
5) public abstract class abs {
     abstract void m1();
     public void m2(){
       System.out.println("concretae implememnted methods");
     }
   }
  public interface INF {
    int a1 = 1;
    void m1();
    public default void m2(){
       System.out.println("default method so implemented");
    }
    public static void m3() {
        System.out.println("Static method so implemented");
    }
}
6) inside any method inluding main method we cant use Assessmodifires because inside methods we only use local variables
* method calling other method

 */
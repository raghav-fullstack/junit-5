import java.util.Arrays;
import java.util.stream.DoubleStream;

public class MathUtils {

    /*public static int add(int...operands) {
        return DoubleStream.of(operands).sum();
    }*/

    public static int add(int a, int b) {
        return a+b;
    }

    static double add(double...operands){
        return DoubleStream.of(operands).sum();
    }

    static double multiply(double...operands){
        return DoubleStream.of(operands).reduce(1,(a,b)->a*b);
    }

    public int divide(int a, int b){ return a/b;}

    public int multiple(int a, int b){ return a*b;}

    public double computeCircleArea(double radius){
        return 3.14*radius*radius;
    }

}

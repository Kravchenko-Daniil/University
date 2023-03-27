package Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Task2Tests {
    @Test
    @DisplayName("Тестируется скалярное произведение")
    void testSclMlp(){
        Vector vector1 = new Vector(1,2,3);
        Vector vector2 = new Vector(0,0,0);
        Assertions.assertEquals(0, vector1.scalarProduct(vector2));
    }
    @Test
    @DisplayName("Тестируется векторное произведение")
    void testVcrMlp(){
        Vector vector1 = new Vector(1,2,3);
        Vector vector2 = new Vector(0,0,0);
        Assertions.assertEquals(0, vector1.vectorProduct(vector2).getX());
        Assertions.assertEquals(0, vector1.vectorProduct(vector2).getY());
        Assertions.assertEquals(0, vector1.vectorProduct(vector2).getZ());
    }
    @Test
    void testModule(){
        Vector vector = new Vector(1,2,3);
        Assertions.assertEquals(14,vector.vectorModulus());
    }
    @Test
    @DisplayName("Тестируется сложение векторов")
    void testAdd(){
        Vector vector1 = new Vector(1,2,3);
        Vector vector2 = new Vector(1,1,1);
        Assertions.assertEquals(4, vector1.vectorAddition(vector2).getZ());
        Assertions.assertEquals(3, vector1.vectorAddition(vector2).getY());
        Assertions.assertEquals(2, vector1.vectorAddition(vector2).getX());
    }
    @Test
    @DisplayName("Тестируется вычитание векторов")
    void testSubtract(){
        Vector vector1 = new Vector(1,2,3);
        Vector vector2 = new Vector(1,1,1);
        System.out.println(vector1.vectorSubtraction(vector2).getZ());

        Assertions.assertEquals(2, vector1.vectorSubtraction(vector2).getZ());
        Assertions.assertEquals(1, vector1.vectorSubtraction(vector2).getY());
        Assertions.assertEquals(0, vector1.vectorSubtraction(vector2).getX());
    }
    @Test
    @DisplayName("Тестируется функция угла")
    void testAngle(){
        Vector vector1 = new Vector(1,1,0);
        Vector vector2 = new Vector(0,0,1);
        double angle = vector1.vectorsAngle(vector2);
        Assertions.assertEquals(90, angle);
    }
}

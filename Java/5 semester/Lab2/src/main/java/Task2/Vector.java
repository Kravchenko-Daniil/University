package Task2;


import static java.lang.Math.pow;

public class Vector {

    private int x, y, z;

    public Vector(int x, int y, int z){
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public int scalarProduct(Vector vector) {
        return (this.getX() * vector.getX()) + (this.getY() * vector.getY()) + (this.getZ() * vector.getZ());
    }

    public Vector vectorProduct(Vector vector) {
        return new Vector(
                (this.getY() * vector.getZ()) - (this.getZ() * vector.getY()),
                (this.getZ() * vector.getX()) + (this.getX() * vector.getZ()),
                (this.getX() * vector.getY()) - (this.getY() * vector.getX())
        );
    }

    public Vector vectorAddition(Vector vector) {
        return new Vector(
                this.getX() + vector.getX(),
                this.getY() + vector.getY(),
                this.getZ() + vector.getZ()
        );
    }

    public Vector vectorSubtraction(Vector vector) {
        return new Vector(
                this.getX() - vector.getX(),
                this.getY() - vector.getY(),
                this.getZ() - vector.getZ()
        );
    }

    public double vectorModulus() {
        return (pow(this.getX(),2)+pow(this.getY(),2)+pow(this.getZ(),2));
    }

    public int vectorsAngle(Vector vector) {
        return (int) Math.toDegrees(Math.acos(this.scalarProduct(vector) / (this.vectorModulus() * vector.vectorModulus())));
    }



    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}

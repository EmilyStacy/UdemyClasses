package CylinderChallenge;

public class Circle {
    private double radius;

    public Circle(double radius) {
        if(radius > 0){
            this.radius = radius;

        }
        radius = 0;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        double PI = Math.PI;
        return radius * radius * PI;
    }
}

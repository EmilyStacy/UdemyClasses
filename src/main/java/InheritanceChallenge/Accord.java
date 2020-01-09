package InheritanceChallenge;

public class Accord extends Car {
  private int roadServicemonths;

    public Accord(int roadServicemonths) {
        super("Honda Accord", "4WD", 4, 4, 4, false);
        this.roadServicemonths = roadServicemonths;
    }

    public void accelerate(int rate){
        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity == 0){
            stop();
            changeGear(1);
        }else if (newVelocity > 0 && newVelocity <=10){
            changeGear(1);
        }
        else if(newVelocity > 10 && newVelocity <=20){
            changeGear(2);
        }else if (newVelocity > 20  && newVelocity <30){
            changeGear(3);
        }
        else{
            changeGear(4);
        }
        if(newVelocity >  0){
            changeVelocity(newVelocity,getCurrentDirection());
        }
    }
}

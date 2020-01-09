package ComplexOperations;

public class Main  {
    public static void main(String[] args) {

    }


    public class ComplexNumber {
        // write your code here
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public double getReal() {
            return real;
        }


        public double getImaginary() {
            return imaginary;
        }

        public void add (double real, double imaginary){
            this.real += real;
            this.imaginary += imaginary;
        }

        public void add (ComplexNumber cNum){
            double instanceReal = cNum.getReal();
            double instanceImaginary = cNum.getImaginary();
            this.real = instanceReal + this.real;
            this.imaginary = instanceImaginary + this.imaginary;

        }

        public void subtract (double real, double imaginary){
            this.real -= real;
            this.imaginary -= imaginary;
        }
        public void subtract (ComplexNumber cNum){
            double instanceReal = cNum.getReal();
            double instanceImaginary = cNum.getImaginary();
            this.real =  this.real -instanceReal;
            this.imaginary =  this.imaginary - instanceImaginary;
        }
    }

}

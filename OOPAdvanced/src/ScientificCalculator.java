public class ScientificCalculator {
    private double lastResult;
    private double memory;

    public double getLastResult() {
        return lastResult;
    }

    public void setLastResult(double lastResult) {
        this.lastResult = lastResult;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public Double add(double a, double b){
        lastResult = a + b;
        return lastResult;
    }

    public Double subtract(double a, double b){
        lastResult = a - b;
        return lastResult;
    }

    public Double multiply(double a, double b){
        lastResult = a * b;
        return lastResult;
    }

    public Double divide(double a, double b){
        if(a > b){
            lastResult = a / b;
            if(b == 0){
                lastResult = a;
            }
        } else if (b > a) {
            lastResult = b / a;
            if(a == 0){
                lastResult = b;
            }
        }
        else{
            lastResult = 1;
        }
        return lastResult;
    }
    public Double power(double base, double exponent){
        if (exponent == 0) {//if exp =0 so return 1
            lastResult = 1.0;
        }
        else {
            lastResult = 1;
            for (int i = 0; i < exponent; i++) {
                lastResult *= base;
            }
        }
        return lastResult;
    }

    public Double squareRoot(double value){
        if(value < 0){//can't take root for negative numbers
            System.out.println("Invalid, can't take square root of 0");
            return null;
        }
        double result = 0.0;
        double precision = 0.001;//to take the decimals also

        for (double i = 0.0; i * i <= value; i += precision) {
            result = i;
        }

        lastResult = result;
        return lastResult;
    }

    public Double sine(double angleInDegrees){
        lastResult =  Math.sin(angleInDegrees);
        return lastResult;
    }

    public Double cosine(double angleInDegrees){
        lastResult =  Math.cos(angleInDegrees);
        return lastResult;
    }

    public Double tangent(double angleInDegrees){
        lastResult =  Math.tan(angleInDegrees);
        return lastResult;
    }

    public Double logarithm(double value){// (base 10)
        lastResult =  Math.log10(value);
        return lastResult;
    }

    public Double naturalLog(double value){// (ln)
        lastResult =  Math.log(value);
        return lastResult;
    }
}

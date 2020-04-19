package HomeWork;

public class ArithmeticThread implements Runnable {
    float[] arr;
    int os;
    Thread t;

    public ArithmeticThread(float[] arr, int offset) {
        this.arr = arr;
        this.os = offset;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        ArithCalcInArr.arithCalc(arr, os);
    }
}

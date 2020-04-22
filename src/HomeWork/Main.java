package HomeWork;

public class Main {
    public static void main(String[] args) {
        System.out.println("Время выполнения арифметических вычислений в массиве: " + withoutThread() + " миллисекунд");
        System.out.println("то же - в 2- х потоках: " + twoThread() + " миллисекунд");
    }

    static long withoutThread() {
        float[] allArr = ArithCalcInArr.fillArr();
        long a = System.currentTimeMillis();
        allArr = ArithCalcInArr.arithCalc(allArr,0);
        for (int i = 0; i < allArr.length; i += 1_000_000) {
            System.out.print(allArr[i] + "\t");
        }
        System.out.println();
        return System.currentTimeMillis() - a;
    }

    static long twoThread() {
        float[] allArr = ArithCalcInArr.fillArr();
        long a = System.currentTimeMillis();
        float[] firstArr = ArithCalcInArr.firstThread(allArr);
        float[] secondArr = ArithCalcInArr.secondThread(allArr);
        ArithmeticThread a1 = new ArithmeticThread(firstArr,0);
        ArithmeticThread a2 = new ArithmeticThread(secondArr,secondArr.length);
        try {
            a1.t.join();
            a2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArithCalcInArr.mergArr(a1.arr, a2.arr);
        return System.currentTimeMillis() - a;
    }
}

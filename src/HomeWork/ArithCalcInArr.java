package HomeWork;

public class ArithCalcInArr {

    static final int size = 10_000_000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    static float[] fillArr() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }
        return arr;
    }

    synchronized static float[] arithCalc(float[] arr, int offset) {
        int os = offset;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i+os) / 5) * Math.cos(0.2f + (i+os) / 5)
                    * Math.cos(0.4f + (i+os) / 2));
        }
        return arr;
    }

    static float[] firstThread(float[] allArr) {
        float[] a1 = new float[allArr.length/2];
        System.arraycopy(allArr, 0, a1, 0, allArr.length / 2);
        return a1;
    }

    static float[] secondThread(float[] allArr) {
        float[] a2 = new float[allArr.length/2];
        System.arraycopy(allArr, allArr.length / 2, a2, 0, allArr.length / 2);
        return a2;
    }

    static float[] mergArr(float[] a1, float[] a2) {
        float[] arr = new float[a1.length + a2.length];
        System.arraycopy(a1, 0, arr, 0, a1.length);
        System.arraycopy(a2, 0, arr, a2.length, a2.length);
        for (int i = 0; i <arr.length; i+=1_000_000) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        return arr;
    }
}

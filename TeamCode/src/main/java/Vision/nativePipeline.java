package Vision;

public class nativePipeline {

    public int sample(int[] a, int w, int h) {
//        return 5923;
        return Detect(a,w,h);
    }

    static {
        System.loadLibrary("skystone");
    }

    public native int Detect(int[] a, int w, int h);
}
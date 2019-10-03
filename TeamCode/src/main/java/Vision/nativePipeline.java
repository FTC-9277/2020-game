package Vision;

public class nativePipeline {

    public int sample(int[] a, int w, int h) {
        return 5923;
//        return FloodFill(a,w,h);
    }

    static {
        System.loadLibrary("skystone");
    }

    public native int FloodFill(int[] a, int w, int h);
}
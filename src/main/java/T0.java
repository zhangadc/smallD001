public class T0 {

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        int[] arr = new int[30000000];
        for (int i = 0; i < arr.length; i++) {
            i++;
        }
        long time2 = System.currentTimeMillis();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            i++;
        }
        
        long time3 = System.currentTimeMillis();
       // System.out.println(time1);
        //System.out.println(time2);
        System.out.println(time2-time1);
       // System.out.println(time3);
        System.out.println(time3-time2);
    }


}

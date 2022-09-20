package examples;

public class FindNemo {
    public static void findNemo(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == "nemo") {
                System.out.println("Found NEMO!");
            }
        }
    }
    
    public static void main(String[] args) {
        String[] nemo = {"darla", "nemo"};
        FindNemo.findNemo(nemo);
    }
}
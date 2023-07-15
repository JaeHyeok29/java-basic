public class Mathx {
    public static int sigma(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(Mathx.sigma(Integer.valueOf(args[0])));
    }
}

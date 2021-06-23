package Basic;
public class ReverseNumber {
    public static void main(String[] args) {
        int n = 24892098;

        StringBuilder str = new StringBuilder();
        str.append(n);

        str.reverse();

        String s = new String(str);

        int ans = Integer.parseInt(s);
        System.out.println(ans);
    }
}

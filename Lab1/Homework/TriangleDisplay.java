// Ex 6.3
import java.util.Scanner;
public class TriangleDisplay{
    public static void main(String[] args){
        Scanner star = new Scanner(System.in);

        System.out.print("n = ");
        int n = star.nextInt();

        for (int i = 1; i <= n; i++) {

           
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

        System.out.println();
        }
    star.close();
    }
}
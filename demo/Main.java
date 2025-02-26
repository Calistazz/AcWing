import java.util.Scanner;

public class Main {
    private static final int N = 100010;
    private static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 处理 q 次查询
        while (q-- > 0) {
            int tmp = sc.nextInt();
            // 二分查找左边界
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (a[mid] < tmp) l = mid + 1;
                else r = mid;
            }
            if (a[l] != tmp) {
                System.out.println("-1 -1");
                continue;
            }
            // 二分查找右边界
            int l1 = l, r1 = n - 1;
            while (l1 < r1) {
                int mid = (l1 + r1 + 1) >> 1;
                if (a[mid] <= tmp) l1 = mid;
                else r1 = mid - 1;
            }
            // 输出结果
            System.out.println(l + " " + l1);
        }
    }
}
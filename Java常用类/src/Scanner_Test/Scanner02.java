package Scanner_Test;

import java.util.Scanner;

/**
 * 这里所谓的hasNextXxx() 实际上还是读取的第一次输入缓冲区内容,只不过对不了空格
 *
 * 处理接受整理和小数的逻辑时，需要在 else 的分支逻辑里把非整数的输入接收走，
 * 否则会影响后续 hasNextFloat 判断和接受小数的逻辑。
 * @athor:lhl
 * @create:2019-09-01 13:35
 */
public class Scanner02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();
    }
}

package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class InsertArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước mảng:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Kích thước không được lớn hơn 20");
        } while (size > 20);

        array = new int[size];
        int X;
        System.out.print("Nhập số lượng phần tử muốn nhập:");
        X = scanner.nextInt();
        for (int i = 0; i < X; i++) {
            System.out.print("Nhập giá trị " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Mảng ban đầu: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int Y;
        int index;
        System.out.println("\nNhập giá trị cần thêm: ");
        Y = scanner.nextInt();
        System.out.println("\nNhập vị trí cần thêm: ");
        index = scanner.nextInt();
        if (index <= 1 || index >= array.length - 1) {
            System.out.println("Không thể thêm phần tử vào mảng!");
        } else {
            for (int k = X; k >= index; k--) {
                array[k] = array[k - 1];
            }
            array[index] = Y;
            System.out.println("Các phần tử trong mảng là: ");
            for (int l = 0; l < array.length; l++) {
                System.out.print(array[l] + "\t");
            }
        }
    }
}

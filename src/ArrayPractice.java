import java.util.Scanner;

public class ArrayPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            Nhap so phan tu cua mang va khai bao mang so nguyen gom n phan tu
            Nhap cac gia tri và chỉ số phần tử của mảng
        */

        // Nhập so phan tu, khai báo mảng, nhập giá trị
        System.out.println("Nhập số phần tử của mảng:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }

        System.out.println("Nhap vao giá tri phần tử cần chèn");
        int value = sc.nextInt();
        System.out.println("Nhập vào chỉ số:");
        int index = sc.nextInt();

        // Chèn phần tử vào mảng
        if (index < 0 || index > arr.length) {
            System.out.println("Không tồn tại chỉ số trong mảng");
        } else {
            // Tạo mảng mới có kích thước lớn hơn 1 phần tử
            int[] newArr = new int[arr.length + 1];

            // Chèn phần tử vào vị trí index
            for (int i = 0; i < newArr.length; i++) {
                if (i < index) {
                    newArr[i] = arr[i];  // Sao chép phần trước vị trí chèn
                } else if (i == index) {
                    newArr[i] = value;   // Chèn giá trị mới
                } else {
                    newArr[i] = arr[i - 1]; // Sao chép phần còn lại
                }
            }

            // In mảng sau khi chèn
            System.out.println("Mảng sau khi chèn:");
            for (int num : newArr) {
                System.out.printf("%d\t", num);
            }
            System.out.println();

            // Cap nhat phan tu trong mang
            System.out.println("Nhập vào vị trí cần câp nhật");
            int idx = sc.nextInt();

            System.out.println("Nhập giá trị cần cap nhat: ");
            int valueIndex = sc.nextInt();
            if(idx < 0 || idx > newArr.length) {
                System.out.println("Vị trí không hợp le");
            }else{
                for(int i = 0; i < newArr.length; i++) {
                    if(idx == i){
                        newArr[i] = valueIndex;
                    }
                }

                System.out.println("Mảng sau khi cập nhật la: ");
                for (int num : newArr) {
                    System.out.printf("%d\t", num);
                }
                System.out.println();
            }

            // Xóa phần tử trong mảng
            System.out.println("Nhập vào vị trí cần xóa");
            int indexDelete = sc.nextInt();

            int[] remainArr = new int[newArr.length - 1];

            if(indexDelete < 0 || indexDelete > newArr.length) {
                System.out.println("Vị trí xóa không hợp le");
            }else{
                for(int i = 0, j = 0; i < newArr.length; i++) {
                    if(i != indexDelete) {
                        remainArr[j++] = newArr[i];
                    }
                }
            }

            System.out.println("Mảng sau khi xoa phan tu la:");
            for (int num : remainArr) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }
}

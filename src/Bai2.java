import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập số hàng: ");
        int n = sc.nextInt();

        System.out.println("Nhập số cột: ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        do {
            System.out.println("--------------------MENU-------------------");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng ");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và \n" +
                    "đường chéo phụ ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của \n" +
                    "mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính \n" +
                    "của mảng giảm dần");
            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, \n" +
                    "thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.printf("Lựa chọn của bạn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            System.out.printf("num[%d][%d] = ", i, j);
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    break;
                case 2:
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            System.out.printf("%5d\t", arr[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int count = 0;
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            if(arr[i][j] % 2 == 0 && arr[i][j] %3 == 0) {
                                count++;
                            }
                        }
                    }

                    if(count == 0){
                        System.out.println("Không có phần tử chia hết cho 2 và 3!");
                    }else{
                        System.out.printf("So lượng phan tu chia het cho 2 va 3 là: %d\n", count);
                    }
                    break;
                case 4:
                    int lengthMatrix = arr.length;
                    int sumBoundary = 0;
                    int sumMainOriginal = 0;
                    int sumSecondaryOriginal = 0;
                    for(int i = 0; i < arr.length; i++){
                        for(int j = 0; j < arr[i].length; j++){
                            if(i == 0 || j == 0 || i == lengthMatrix - 1 || j == lengthMatrix - 1){
                                sumBoundary += arr[i][j];
                            }

                            if(i == j){
                                sumMainOriginal += arr[i][j];
                            }

                            if(i + j == lengthMatrix - 1){
                                sumSecondaryOriginal += arr[i][j];
                            }
                        }
                    }
                    System.out.printf("Tong cac so tren duong bien la: %d\n", sumBoundary);
                    System.out.printf("Tong cac so trên đường chéo chính là: %d\n", sumMainOriginal);
                    System.out.printf("Tổng các số trên đường chéo phụ là: %d\n", sumSecondaryOriginal);
                    break;
                case 5:
                    for(int col = 0; col < m; col++) {
                        for(int i = 0; i < n - 1; i++) {
                            int minIdx = i;
                            for(int j = i + 1; j < m; j++) {
                                if(arr[j][col] < arr[minIdx][col]){
                                    minIdx = j;
                                }
                            }
                            int temp = arr[i][col];
                            arr[i][col] = arr[minIdx][col];
                            arr[minIdx][col] = temp;
                        }
                    }
                    System.out.println("Ma trận sau khi sắp xếp là: ");
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            System.out.printf("%5d\t", arr[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    int countPrime = 0;

                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            boolean isPrime = true;
                            if(arr[i][j] < 2){
                                isPrime = false;
                            }else{
                                for(int k = 2; k <= Math.sqrt(arr[i][j]); k++){
                                    if(arr[i][j] % k == 0){
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }

                            if(isPrime){
                                countPrime++;
                            }
                        }
                    }

                    int[] newArr = new int[countPrime];
                    int index = 0;
                    if(countPrime == 0){
                        System.out.println("Không có so nguyen to trong ma trận");
                    }else{
                        for(int i = 0; i < n; i++) {
                            for(int j = 0; j < m; j++) {
                                boolean isPrime = true;
                                if(arr[i][j] < 2){
                                    isPrime = false;
                                }else{
                                    for(int k = 2; k <= Math.sqrt(arr[i][j]); k++){
                                        if(arr[i][j] % k == 0){
                                            isPrime = false;
                                            break;
                                        }
                                    }
                                }

                                if(isPrime){
                                    newArr[index++] = arr[i][j];
                                }
                            }
                        }

                        System.out.println("Các số nguyên tố trong ma trận:");
                        for(int i = 0; i < newArr.length; i++) {
                            System.out.printf("%d\t", newArr[i]);
                        }
                        System.out.println();
                    }
                    break;
                case 7:
                    // Lưu đường chéo chính vào mảng 1 chiều
                    int[] mainArr = new int[n];

                    for(int i = 0; i < arr.length; i++) {
                        mainArr[i] = arr[i][i];
                    }

                    for(int i = 0; i < mainArr.length; i++){
                        int key = mainArr[i];
                        int j = i - 1;

                        while(j >= 0 && mainArr[j] < key){
                            mainArr[j + 1] = mainArr[j];
                            j--;
                        }
                        mainArr[j + 1] = key;
                    }

                    for(int i = 0; i < arr.length; i++) {
                        arr[i][i] = mainArr[i];
                    }

                    System.out.println("Ma trận sau khi sắp xếp là: ");
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            System.out.printf("%5d\t", arr[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 8:
                    System.out.println("Nhập chỉ số dòng can chèn:");
                    int idx = sc.nextInt();

                    if(idx < 0 || idx > n){
                        System.out.println("Vị trí chèn không hợp lệ");
                    }else{
                        int[] newRow = new int[m];
                        System.out.printf("Nhap vao %d phần tử của dòng mới:", m);
                        for(int i = 0; i < m; i++) {
                            newRow[i] = sc.nextInt();
                        }

                        int[][] newMatrix = new int[n+1][m];

                        // Sao chép dữ liệu từ ma trận cũ sang ma tran mới
                        for(int i = 0; i < n + 1; i++) {
                            if(i < idx){
                                newMatrix[i] = arr[i];
                            }else if(i == idx){
                                newMatrix[i] = newRow;
                            }else{
                                newMatrix[i] = arr[i - 1];
                            }
                        }

                        System.out.println("Ma trận sau khi chèn thêm dòng là: ");
                        for(int i = 0; i < n + 1; i++) {
                            for(int j = 0; j < m; j++) {
                                System.out.printf("%5d\t", newMatrix[i][j]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại từ 1 đến 9!");
            }
        }while (true);
    }
}

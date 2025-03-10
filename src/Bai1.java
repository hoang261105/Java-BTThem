import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập so phần tu của mảng: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        do {
            System.out.println("---------------------MENU-------------------");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng ");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong  \n" +
                    "mảng (k nhập từ bàn phím) ");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng \n" +
                    "dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, \n" +
                    "các phần tử còn lại ở giữa mảng theo thứ tự tăng dần ");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm  \n" +
                    "dần) đúng vị trí ");
            System.out.println("9. Thoát");
            System.out.printf("Lựa chọn cua bạn: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.printf("num[%d] = ", i);
                        numbers[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.printf("num[%d] = %d\n", i, numbers[i]);
                    }
                    break;
                case 3:
                    int sum = 0;
                    for(int i = 0; i < numbers.length; i++){
                        if(numbers[i] > 0){
                            sum += numbers[i];
                        }
                    }
                    System.out.printf("Tong cac phần tử > 0 trong mảng la: %d\n", sum);
                    break;
                case 4:
                    System.out.println("Nhap vao 1 so cần tìm: ");
                    int k = sc.nextInt();

                    int count = 0;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] == k) {
                            count++;
                        }
                    }

                    if(count == 0){
                        System.out.printf("Không tìm thấy số %d trong mảng\n", k);
                        break;
                    }

                    int[] newArr = new int[count];
                    int index = 0;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] == k) {
                            newArr[index++] = i;
                        }
                    }

                    System.out.printf("Số %d được tìm thấy ở các vị trí: ", k);
                    for(int position : newArr){
                        System.out.printf("%d\t", position);
                    }
                    break;
                case 5:
                    for(int i = 0; i < numbers.length - 1; i++){
                        boolean swapped = false;
                        for(int j = 0; j < numbers.length - i - 1; j++){
                            if(numbers[j] < numbers[j + 1]){
                                int temp = numbers[j];
                                numbers[j] = numbers[j + 1];
                                numbers[j + 1] = temp;
                                swapped = true;
                            }
                        }

                        if(!swapped){
                            break;
                        }
                    }

                    System.out.println("Mảng sau khi sắp xếp giảm dần là:");
                    for(int i = 0; i < numbers.length; i++){
                        System.out.printf("%d\n", numbers[i]);
                    }
                    break;
                case 6:
                    int count1 = 0;
                    for(int i = 0; i < numbers.length; i++){
                        boolean isPrime = true;
                        if(numbers[i] < 2){
                            isPrime = false;
                        }else{
                            for(int j = 2; j <= Math.sqrt(numbers[i]); j++){
                                if(numbers[i] % j == 0){
                                    isPrime = false;
                                    break;
                                }
                            }
                        }
                        if(isPrime){
                            count1++;
                        }
                    }

                    System.out.printf("So luong so nguyen to trong mang là: %d\n", count1);
                    break;
                case 7:
                    // Đếm số lượng phần tử của từng nhóm
                    int countEvenDiv3 = 0, countOddDiv3 = 0, countOthers = 0;
                    for (int i = 0; i < n; i++) {
                        if (numbers[i] % 3 == 0 && numbers[i] % 2 == 0) {
                            countEvenDiv3++;
                        } else if (numbers[i] % 3 == 0 && numbers[i] % 2 != 0) {
                            countOddDiv3++;
                        } else {
                            countOthers++;
                        }
                    }

                    // Tạo các mảng để lưu từng nhóm
                    int[] evenDiv3 = new int[countEvenDiv3];
                    int[] oddDiv3 = new int[countOddDiv3];
                    int[] others = new int[countOthers];

                    // Phân loại số vào các mảng tương ứng
                    int idxEven = 0, idxOdd = 0, idxOthers = 0;
                    for (int i = 0; i < n; i++) {
                        if (numbers[i] % 3 == 0 && numbers[i] % 2 == 0) {
                            evenDiv3[idxEven++] = numbers[i];
                        } else if (numbers[i] % 3 == 0 && numbers[i] % 2 != 0) {
                            oddDiv3[idxOdd++] = numbers[i];
                        } else {
                            others[idxOthers++] = numbers[i];
                        }
                    }

                    // Sắp xếp nổi bọt tăng dần cho chẵn chia hết cho 3
                    for (int i = 0; i < countEvenDiv3 - 1; i++) {
                        for (int j = 0; j < countEvenDiv3 - i - 1; j++) {
                            if (evenDiv3[j] > evenDiv3[j + 1]) {
                                int temp = evenDiv3[j];
                                evenDiv3[j] = evenDiv3[j + 1];
                                evenDiv3[j + 1] = temp;
                            }
                        }
                    }

                    // Sắp xếp nổi bọt tăng dần cho nhóm "các số còn lại"
                    for (int i = 0; i < countOthers - 1; i++) {
                        for (int j = 0; j < countOthers - i - 1; j++) {
                            if (others[j] > others[j + 1]) {
                                int temp = others[j];
                                others[j] = others[j + 1];
                                others[j + 1] = temp;
                            }
                        }
                    }

                    // Sắp xếp nổi bọt giảm dần cho lẻ chia hết cho 3
                    for (int i = 0; i < countOddDiv3 - 1; i++) {
                        for (int j = 0; j < countOddDiv3 - i - 1; j++) {
                            if (oddDiv3[j] < oddDiv3[j + 1]) {
                                int temp = oddDiv3[j];
                                oddDiv3[j] = oddDiv3[j + 1];
                                oddDiv3[j + 1] = temp;
                            }
                        }
                    }

                    // Gộp mảng lại theo đúng thứ tự yêu cầu
                    int index1 = 0;
                    for (int num : evenDiv3) numbers[index1++] = num; // Chẵn chia hết cho 3 (tăng dần)
                    for (int num : others) numbers[index1++] = num;  // Số còn lại (tăng dần)
                    for (int num : oddDiv3) numbers[index1++] = num; // Lẻ chia hết cho 3 (giảm dần)

                    // In kết quả sau khi sắp xếp
                    System.out.println("Mảng sau khi sắp xếp:");
                    for (int num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Nhập 1 giá trị cần thêm: ");
                    int newElement = sc.nextInt();

                    int[] newLists = new int[numbers.length + 1];

                    for(int i = 0; i < numbers.length; i++){
                        newLists[i] = numbers[i];
                    }

                    newLists[numbers.length] = newElement;

                    numbers = newLists;

                    for(int i = 0; i < numbers.length - 1; i++){
                        boolean swapped = false;
                        for(int j = 0; j < numbers.length - i - 1; j++){
                            if(numbers[j] < numbers[j + 1]){
                                int temp = numbers[j];
                                numbers[j] = numbers[j + 1];
                                numbers[j + 1] = temp;
                                swapped = true;
                            }
                        }

                        if(!swapped){
                            break;
                        }
                    }

                    System.out.println("Mảng đc sắp xếp giảm dần sau khi thêm phần tử là:");
                    for(int i = 0; i < numbers.length; i++){
                        System.out.printf("%d\n", numbers[i]);
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại tu 1 den 9");
            }
        }while(true);
    }
}

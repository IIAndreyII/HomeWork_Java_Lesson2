
/*Используем наш код который мы писали на семинаре и дорабатываем, нужно сделать так что бы мы могли написать формулу и заполненить все элементов которые сами же и вели
        Например
        a + b + c
        2
        3
        4
        ответ 9
 */

import java.util.Scanner;

public class HomeWorkLesson2 {
    public static void main(String[] args) {
        Equation();
    }


        public static String GetString() {
            System.out.print("Введите формулу: ");
            String equation = new Scanner(System.in).nextLine();
            return equation;
        }

        public static void Equation() {
            String equation = GetString();
            equation = String.format(equation).replace(" ", "");
            String[] st1 = equation.split("\\+");
            //    System.out.println(Arrays.toString(st1));

            String[] unique = new String[st1.length];
            Integer[] counts = new Integer[st1.length];
            int count = 0;

            for (int i = 0; i < st1.length; i++) {
                String num = st1[i];

                boolean control = false;
                for (int j = 0; j < count; j++) {
                    if (unique[j].equals(num)) {
                        control = true;
                        break;
                    }
                }
                if (!control) {
                    int number = 1;
                    for (int j = i + 1; j < st1.length; j++) {
                        if (num.equals(st1[j])) {
                            number++;
                        }
                    }
                    unique[count] = num;
                    counts[count] = number;
                    count++;
                }
            }

            Integer[] res1 = new Integer[unique.length];
            int sum = 0;

            for (int i = 0; i < unique.length; i++) {
                if (counts[i] != null) {
                    System.out.print("Введите " + unique[i] + ": ");
                    res1[i] = new Scanner(System.in).nextInt();
                    sum += res1[i] * counts[i];
                }
            }


            System.out.println("Результат: " + sum);
    }
}

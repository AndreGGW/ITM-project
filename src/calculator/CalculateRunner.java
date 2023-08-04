package calculator;

import java.util.Arrays;
import java.util.Scanner;
public class CalculateRunner {
    public static void main(String[] args) {
        int result = 0;
        int value1 = 0;
        int value2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста, введите арифметическое выражение строкой ниже (пример '5-3') :");
        String example = sc.nextLine();  // переменная типа стринг = введеный пример.
        System.out.println("Вы ввели:" + example + "\n");
        String mathOperation = getOperation(example); // переменная t1 принимает результат метода getOperation. t1 - мат. опер.
        // массив чисел a = состоит из двух введенных чисел (принимает результат getArray)
        int[] a = getArray(example);
        //System.out.println(a.length);
        value1 = a[0];
        value2 = a[1];
        if (mathOperation=="+"){   // Проверяем на равенство.
            plusing(value1,value2);
        } else if (mathOperation =="-"){
            minusing(value1,value2);
        } else if (mathOperation =="/"){
            divining(value1,value2);
        } else if (mathOperation =="*"){
            multing(value1,value2);
        }
    }
    private static int[] getArray(String example) {
        String[] arr = example.split("[+\\-*/]");
        try{
            int b = Integer.parseInt(arr[1]);
            int a = Integer.parseInt(arr[0]);
            if (arr.length>2 | b>10 | a>10){
                System.out.println("Введен неверный формат примера!!! Программа закрывается! ");
                System. exit(0);
            }
            return new int[] {a, b};
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Введен неверный формат примера!!! Программа закрывается! ");
            return new int[]{0,0};
        } catch (NumberFormatException e){
            System.out.println("Введен неверный формат примера!!! Программа закрывается! ");
            return new int[]{0,0};
        }
    }
    public static void plusing(int a, int b){
        int result;
        result = a+b;
        System.out.println("Ответ " + result);
    }
    public static void minusing(int a, int b){
        int result;
        result = a-b;
        System.out.println("Ответ " + result);
    }
    public static void divining(int a, int b){
        int result;
        try{
            result = a/ b;
            System.out.println("Ответ " + result);
        } catch (ArithmeticException e) {
            System.out.print("Делить на 0 нельзя, программа закрывается.");
        }
    }
    public static void multing(int a, int b){
        int result;
        result = a*b;
        System.out.println("Ответ " + result);
    }
    public static String getOperation(String example){
        String operation = null;
        int plus = example.indexOf('+');
        int minus = example.indexOf('-');
        int mult = example.indexOf('*');
        int div = example.indexOf('/');
        try{
            if (plus != -1)
            {
                operation = "+";
            }
            else if (minus != -1)
            {
                operation = "-";
            }
            else if (mult != -1)
            {
                operation = "*";
            }
            else if (div != -1)
            {
                operation = "/";
            }
            return operation;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Вы ввели неверный формат примера. Программа завершена.");
            return operation;
        }
    }
}
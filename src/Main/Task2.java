package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task2 {

    public void runTask() {

        var array0 = readFile();
        findMinMax(array0);
        findRightAndLeftMin(array0);
        sort(array0);
        var arr3 = choose(array0);
        take(array0, arr3);
        taskeStr(array0);

    }
    private void taskeStr(String[] array){
        System.out.print("\n18.Из исходного массива выделить элементы начинающиеся на букву “Б”");

        Arrays.stream(array).filter(v->v.charAt(0) == 'б').forEach(v->System.out.print(v + "||"));

        System.out.print("\n19.Создать массив из исходного, не содержащих слов на букву “Б”");

        Arrays.stream(array).filter(v->v.charAt(0) != 'б').forEach(v->System.out.print(v + "||"));
    }
    //13
    private void take(String[] array, String[] arr3) {
        System.out.print("13.Взять из массива 5 элементов меньших максимума на k значений:");

        var arr = new String[array.length];

        arr = Arrays.copyOf(array,arr.length);
        Arrays.stream(arr).sorted().skip(1).limit(5).forEach(v->System.out.print(v + ";"));

        //14
        arr = Arrays.copyOf(array,arr.length);
        Arrays.sort(arr);
        String[] arr4 =  Arrays.stream(arr).limit(5).toArray(String[]::new);

        System.out.print("\n14.Выбрать из массива первые 5 наименьших элементов " + Arrays.toString(arr4));
        //15
        var res = Stream.concat(Arrays.stream(arr4),Arrays.stream(arr4)).toArray(String[]::new);

        System.out.print("\n15.Обьединить arr3 и arr4  " + Arrays.toString(res));

        //16
        System.out.print("\n16.Создать массив из исходного, не содержащий элементы  массива array3:");

        arr = Arrays.copyOf(array,arr.length);
        Arrays.stream(arr)
                .filter(v-> Collections.frequency(Arrays.asList(array),arr3) == 1).forEach(el->System.out.print(el + ";"));
        //17
        arr = Arrays.copyOf(array,arr.length);
        System.out.println("\n17. Уникальные елементы:" + Arrays.toString(Arrays.stream(arr).distinct().toArray()));
    }
    //9
    private String[] choose(String[] array) {
        System.out.print("\n9. пропустить 5 элементов и выбрать следующие 5 элементов :");

        Arrays.stream(array).skip(5).limit(5).forEach(v->System.out.print(v + ";"));

        //10
        var arr3 = new String[array.length];
        arr3 = Arrays.copyOf(array,array.length);
        arr3 = (String[]) Arrays.stream(arr3).sorted().limit(5).toArray(String[]::new);
        System.out.print("\n10. Выбрать 5 наибольших элементов :" + Arrays.toString(arr3));
        //11
        var sum = Arrays.stream(array).skip(5).mapToInt(v->v.length()).sum();

        System.out.println("\n11.Пропустить первые 5 и посчитать сумму оставшихся = " + sum);
        //12
        var stop = arr3[arr3.length - 1].length();
        var stop1 = arr3[arr3.length - 2].length();
        var stop2 = arr3[arr3.length - 3].length();
        var stop3 = arr3[arr3.length - 4].length();
        var stop4 = arr3[arr3.length - 5].length();
        sum = Arrays.stream(array).skip(3).mapToInt(v -> v.length()).dropWhile(v -> (v == stop || v == stop1 ||
                v == stop2 || v == stop3 || v == stop4)).sum();

        System.out.println("\n12.Пропустить первые 3 элемента и посчитать сумму элементов, " +
                "пока не достигнем первого максимального= " + sum);
        return arr3;
    }
    //6
    private void sort(String[] array) {

        var array1 = Arrays.copyOf(array, array.length);
        var array2 = Arrays.copyOf(array, array.length);

        Arrays.sort(array1,Comparator.reverseOrder());

        System.out.print("7. Отсортированный массив array1 в обратном порядке:");

        Arrays.stream(array1).forEach(el ->System.out.print(el + ";"));
        //7
        System.out.print("\n8. Отсортированный массив array2:");
        Arrays.stream(array2).sorted((el1,el2)->el1.compareTo(el2)).forEach(el -> System.out.print(el + ";"));
    }
    //3
    private void createArray(String[] array, String minRight, String minLeft) {

        int indexLeft = IntStream.range(0, array.length).
                filter(v ->array[v] == minLeft).findFirst().orElseThrow(NoSuchElementException::new);
        int indexRight = IntStream.range(0,array.length).
                filter(v->array[v] == minRight).findFirst().orElseThrow(NoSuchElementException::new);

        String[] arr3 = new String[indexRight-indexLeft];

        var j = 0;

            for(var i = indexLeft; i < indexRight; j++, i++){
            arr3[j] = array[i];
        }

        System.out.println("3. Массив из элементов расположенных между(" + indexLeft + ";"+ indexRight +")" +
                Arrays.toString(arr3));
        //4
        var sum = Arrays.stream(arr3).mapToInt(v -> v.length()).sum();
        System.out.println("4. Сумма элементов расположенных между(" + indexLeft + ";"+ indexRight +") = " + sum);
        //5
        System.out.println("5. Колличество элементов расположенных между(" + indexLeft + ";"+ indexRight +") = "
                + (indexRight - indexLeft));
        //6
        var average = Arrays.stream(arr3).mapToInt(v -> v.length()).average();
        System.out.println("6. Среднее значение между(" + indexLeft + ";"+ indexRight +") = "
                + average);
    }
    //2
    private void findRightAndLeftMin(String[] array) {

        int half = array.length / 2;
        var array1 = Arrays.copyOf(array,half);
        String[] array2 = new String[half];

        System.arraycopy(array,5,array2,0,half);

        String minLeft = Arrays.stream(array1).
                min(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);
        String minRight = Arrays.stream(array2).
                min(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);

        System.out.println("2.Минимум слева = " + minLeft + " Минимум справа = " + minRight);

       createArray(array, minRight, minLeft);
    }
    //1
    private void findMinMax(String[] arr){

        var max = Arrays.stream(arr).max(Comparator.naturalOrder());
        var min = Arrays.stream(arr).min(Comparator.naturalOrder());

        System.out.println("1. Минимум = " + min + " Максимум = " + max);
    }

    private String[] readFile() {

        String str;
        String[] arr = new String[20];

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jtmotn\\IdeaProjects\\src\\Lab5\\read2.txt"))){

            while ((str = reader.readLine()) != null){
                String[] nums = str.split(" ");
                var i = 0;
                for (var item : nums){
                    str = item;
                    arr[i] = str;
                    i++;
                }
            }
        }
        catch (FileNotFoundException fileEx){

        }
        catch(IOException ioException){

        }
        return arr;
    }
}

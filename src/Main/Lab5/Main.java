package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();

        task1.runTask();
        task2.runTask();

        start();
    }
    public static void start()
    {
        ArrayList<Task3> list = new ArrayList<Task3>();

        list.add(new Task3(4,"ПК",4,700));
        list.add(new Task3(4,"Ноутбук",7,860));
        list.add(new Task3(4,"Принтер",5,450));

        System.out.println("\nФильтрация, ищу 4 кафедру");

        list.stream().filter(v->v.getNumFaculty() == 4).forEach(v->System.out.println
                ( "Факультет:" + v.getNumFaculty() + "|| Оборудование:" + v.getNameEquipment() +
                        "|| Количество:" + v.getQuantity() + "|| Цена:" + v.getPrise()));

        System.out.println("Сортировка по названию оборудования");

        list.stream().sorted((v1,v2)->v1.getNameEquipment().compareTo(v2.getNameEquipment())).forEach(v->System.out.println
            ( "Факультет:" + v.getNumFaculty() + "|| Оборудование:" + v.getNameEquipment() +
                    "|| Количество:" + v.getQuantity() + "|| Цена:" + v.getPrise()));

        System.out.println("Сортировка по кафедре");

        list.stream().sorted((v1,v2)->v1.getNumFaculty().compareTo(v2.getNumFaculty())).forEach(v->System.out.println
                ( "Факультет:" + v.getNumFaculty() + "|| Оборудование:" + v.getNameEquipment() +
                        "|| Количество:" + v.getQuantity() + "|| Цена:" + v.getPrise()));

        Integer min = list.stream().filter(v->v.getNumFaculty() == 4).mapToInt(v->v.getQuantity()).min().getAsInt();
        Integer max = list.stream().filter(v->v.getNumFaculty() == 4).mapToInt(v->v.getQuantity()).max().getAsInt();

        int minIndex = 0 ,maxIndex = 0;

        for (int i =0;i < list.size();i++){
            if (list.get(i).getQuantity()==min) {
                minIndex = i;
            }else if(list.get(i).getQuantity()==max){
                maxIndex = i;
            }

        }

        var newList = new ArrayList<Task3>();

        for (var i = minIndex; i < maxIndex; i++){
            newList.add(list.get(i));
        }

        var sum = newList.stream().mapToInt(v->v.getQuantity()).sum();

        System.out.println("Сумма между минимумом("+ min +") и максимумом("+ max +") = " + sum);
        System.out.println("Количество:" + newList.size());
        System.out.println("Среднее значение:" + newList.stream().mapToInt(v->v.getQuantity()).average());

        ArrayList<int> array = new ArrayList<int>();
        array.add(1);
        array.add(2);
        array.add(3);

        int[] arr = {1,2,3};
        Arrays.stream(arr).+++

    }
}

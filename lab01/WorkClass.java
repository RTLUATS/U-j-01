package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class WorkClass {
    private int[] newArray;

    public WorkClass(){

    }

    public WorkClass(int len){

        Random ran = new Random();

        newArray = new int[len];
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = ran.nextInt(100);
        }
    }

    public void CreateNewArray(){

        int len = EnterSomething("length");

        newArray = new int[len];

        EnterArray(newArray);

    }

    public void  Show(){

        for(int x : newArray){
            System.out.print(x +"; ");
        }
        System.out.println("\n");
    }

    private int EnterSomething(String arg){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter " + arg);

        while (!scan.hasNext()){

            System.out.println("Error!\nEnter again!");
            scan.next();

        }

        return scan.nextInt();
    }

    private void EnterArray(int[] newArray){

        for (int i = 0; i < newArray.length; i++){

            newArray[i] = EnterSomething("["+ i +"]");
        }

    }

    public WorkClass(WorkClass firstArr, WorkClass secondArr){

        newArray = new int[firstArr.Length() + secondArr.Length()];

        for (int i = 0; i < newArray.length; i++){

            if (i < firstArr.Length()){

                newArray[i] = firstArr.Elem(i);

            }else{
                newArray[i] = secondArr.Elem(i - firstArr.Length());
            }
        }

    }

    public int Length(){
        return newArray.length;
    }

    public void SortArray(){
        Arrays.sort(newArray);
    }

    public int Elem(int index){
        return newArray[index];
    }

    public void Task(int num) {

        int len1 = 0, len2 = 0, endIn = -1;
        boolean flag = true;
        for (int i = 1; i < newArray.length; i++) {

            if (newArray[i] <= newArray[i - 1]) {

                len1++;
                flag = true;
            }
            else {
                flag = false;
            }
            if(flag == false){

                if (len2 < len1){
                    endIn = i;
                    len2 = len1;
                }

                len1 = 0;
            }
        }
        if (len2 == 0 || (len2 < len1)) {
            len2 = len1;
            endIn = newArray.length;
        }
        Multiplication(endIn, len2, num);
    }
    private  void Multiplication(int endIn, int len, int num ){

        int res = 1;

        for (int i = (endIn-len); i < endIn ; i++){
            if (i % num == 0){
                res *= newArray[i];
            }
        }
        System.out.println("Результат :" + res);
    }
}


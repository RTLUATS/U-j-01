package com.company;

//import  com.company.WorkClass;
//import java.util.Scanner;

public class someclass {

    public static void main(String[] args) {

        Start();
    }

    public static void Start(){

        WorkClass newArray1 = new WorkClass(10);
        newArray1.Show();
        WorkClass newArray2 = new WorkClass();
        newArray2.CreateNewArray();
        newArray2.Show();
        WorkClass newArray3 = new WorkClass(newArray1, newArray2);
        newArray3.Show();
        newArray3.Task(3);
        /*
        Scanner in = new Scanner(System.in);

        String a = in.next();

        switch (a){

            case "1": ///
                break;
                ////
            default:
                break;
        }
        */
    }

}

package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        start();

    }
    public static void start(){
        ClassCollection collection = new ClassCollection();

        collection.add(1);
        collection.add("name");
        collection.add(1.2);
        collection.add("smth");
        collection.toString();

        Serialize serialize =  new Serialize();

        if(serialize.checkSerializeCollect(collection)){
            System.out.println("Сериализация прошла успешно\nНажмите энтр...");
        }else {
            System.out.println("Произшла ошибка\nНажмите клавишу и энтр...");
        }

        Scanner in =  new Scanner(System.in);

        in.next();

        if(serialize.checkDeserializeCollect(collection)){
            System.out.println("Десериализация прошла успешно\n" );
            collection.toString();
        }else {
            System.out.println("Произшла ошибка...");
        }

        Treatment treatment = new Treatment();

        treatment.filtr(collection);
    }
}

package basepack;

import java.io.*;
import java.time.OffsetDateTime;

public class Writer {

    public  Writer(HumanOffenses offenses){

        String text = "";

        for(HumanOffenses.InnerClass elem : offenses.innerArr){

            text+= elem.getSecondName() + " " + elem.getAmountOfMoney() + " " + elem.getYearOfBirth() +
            " " + elem.getKindOffenses() + " " + elem.getDateOffenses() + " ";
        }

        write(text);
    }

    private void write(String text){

        try(FileWriter writer = new FileWriter("C:\\Users\\jtmotn\\IdeaProjects\\src\\basepack\\Offenses.txt" , false) ) {

            writer.write(text);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}

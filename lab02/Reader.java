package basepack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class Reader {

    public  Reader(HumanOffenses offenses){

        try(FileReader reader = new FileReader("C:\\Users\\jtmotn\\IdeaProjects\\src\\basepack\\Offenses.txt")){

            BufferedReader buf = new BufferedReader(reader);
            String s;

            if((s = buf.readLine())!= null){

                String[] subStr;
                subStr = s.split(" ");

                writeInClass(subStr, offenses);

            }else
            {
                System.out.println("File is empty");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("IO exception");
        }

    }

    public  void  writeInClass(String[] subStr, HumanOffenses offenses){

        int currentWord = 0;
        int currentElem = 0;

        Pattern datePattern = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        Matcher dateMatcher ;

        while(subStr.length > currentWord){

            String str = "";

            offenses.append( new HumanOffenses.InnerClass());
            offenses.innerArr[currentElem].setSecondName(subStr[currentWord]);

            currentWord++;

            offenses.innerArr[currentElem].setAmountOfMoney(subStr[currentWord]);

            currentWord++;

            offenses.innerArr[currentElem].setYearOfBirth(Integer.parseInt(subStr[currentWord].trim()));

            currentWord++;

            while (true){

                dateMatcher = datePattern.matcher(subStr[currentWord]);
                boolean flagExit = dateMatcher.matches();
                if (flagExit == true){
                    break;
                }else{
                    str += subStr[currentWord] + " ";
                    currentWord++;
                }
            }

            offenses.innerArr[currentElem].setKindOffenses(str);
            offenses.innerArr[currentElem].setDateOffenses(subStr[currentWord]);

            currentElem++;
            currentWord++;
        }

    }

}

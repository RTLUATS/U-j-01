package basepack;

import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        start();

    }
    public static void start()
    {

     HumanOffenses offenses = new HumanOffenses();
     Reader read = new Reader(offenses);

     offenses.sort();

     menu(offenses);
    }

    public  static  void menu(HumanOffenses offenses) {

        boolean exitFlag = false;

        while (!exitFlag){

            offenses.showAll();

            switch (mainMenu()){

                case 1: createRecord(1, offenses, 0);
                    break;
                case 2: manipulating(2,offenses ,"record number after which we will add:");
                    break;
                case 3: manipulating(3, offenses, "select the item number you want to change");
                    break;
                case 4:manipulating(4, offenses, "select the item number which you want delete");
                    break;
                case 5: Writer writer = new Writer(offenses);
                    break;
                case 6: offenses.searchBySecondName(writeString(" name", "[A-Z]{1}[a-z]{1,}"));
                    break;
                case 7: exitFlag = true;
                    break;
                default: System.out.print("This item do not exist");
                }
        }
    }

    public static int mainMenu(){

        Scanner in = new Scanner(System.in);

        System.out.print("1.Add new record to end\n2.Add new record after specific number\n" +
                "3.Edit specific record\4.Delete specific record\n5.Save changes\n6.Search by second name" +
                "\n7.Exit\n\tWrite the item number:");

        while (!in.hasNextInt()){

            System.out.println("Error!Enter again");
            in.next();

        }

        return in.nextInt();

    }

    public static void manipulating(int key, HumanOffenses offenses, String name){

        Scanner in  =  new Scanner(System.in);
        boolean exitFlag = false;
        int num = 0;

        do {

            System.out.print("Write" + name);

            if (in.hasNextInt())
            {
                num = in.nextInt();

                if ((num <= offenses.innerArr.length) && (key==2 || key == 3)){

                    createRecord(key, offenses, num);
                    exitFlag = true;
                }
                else  if((num <= offenses.innerArr.length) && (key == 4)){

                    offenses.removeByNum(num);
                }
            }
            else
            {
                System.out.println("Try again");
            }

        }while (!exitFlag);

    }

    public static void createRecord(int key, HumanOffenses offenses, int num){

        HumanOffenses.InnerClass record = new HumanOffenses.InnerClass();

        record.setSecondName(writeString(" second name", "^[A-Z]{1}[a-z]{1,}$")) ;
        record.setKindOffenses(writeString(" kind of offenses", ".+")) ;
        record.setDateOffenses(writeString(" date of offenses","\\d{2}\\.\\d{2}\\.\\d{4}" ));
        record.setAmountOfMoney(writeString(" amount of money", "[0-9]+"));
        record.setYearOfBirth(Integer.parseInt(writeString(" year of birth", "^[12]{1}[0-9]{3}$")));

        if(key == 1)
        {
            offenses.append(record);
        }
        else if(key == 2){
            offenses.appByIndex(record, num);
        }
        else if (key == 3){
            offenses.innerArr[key] = record;
        }


    }

    public static String writeString(String name, String patt){

        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile(patt);
        Matcher matcher ;
        boolean exitFlag = false;
        String something;

        while (true){

            System.out.print("Write" + name + ":");

            something = in.nextLine();
            matcher = pattern.matcher(something);
            exitFlag = matcher.matches();

            if (exitFlag = true){
                return something;
            }
            else{
                System.out.println("Error!Try again");
            }
        }
    }


}

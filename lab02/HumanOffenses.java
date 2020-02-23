package basepack;

import java.util.Arrays;

public class HumanOffenses {

    public HumanOffenses.InnerClass[] innerArr;

    public HumanOffenses(){

        innerArr = new HumanOffenses.InnerClass[0];
    }

    static class InnerClass implements Comparable<InnerClass>
    {
         private String dateOffenses;
         private String secondName;
         private int yearOfBirth;
         private String kindOffenses;
         private String amountOfMoney;

         public String getSecondName () {
            return secondName;
         }

         public void setSecondName (String secondName){
            this.secondName = secondName;
         }

         public int getYearOfBirth () {
             return yearOfBirth;
         }

         public void setYearOfBirth (int yearOfBith){
            this.yearOfBirth = yearOfBith;
         }

         public String getKindOffenses () {
            return kindOffenses;
        }

         public void setKindOffenses (String kindOffenses){
            this.kindOffenses = kindOffenses;
        }

         public String getDateOffenses () {
            return dateOffenses;
        }

         public void setDateOffenses (String dateOffenses){
            this.dateOffenses = dateOffenses;
        }

         public String getAmountOfMoney () {
            return amountOfMoney;
        }

         public void setAmountOfMoney (String amountOfMoney){
            this.amountOfMoney = amountOfMoney;
        }

         @Override
         public int compareTo(InnerClass o) {
           return this.yearOfBirth - yearOfBirth;
         }

         @Override
         public String toString() {
            return "Name:" + getSecondName() + ";Date Offenses:" + getDateOffenses() +
                    ";Year of Birth:" + getYearOfBirth() + ";Amount of money:" + getAmountOfMoney() +
                    ";Kind Offenses:" + getKindOffenses();
         }
    }

    public void sort(){
        Arrays.sort(innerArr);
    }

    public void append(InnerClass elem){

        resizeAdd();

        innerArr[innerArr.length-1] = elem;
    }

    public void appByIndex(InnerClass element, int index){

        resizeAdd();

        for (int i = innerArr.length; i > index; i--){

            innerArr[i] = innerArr[i-1];
        }

        innerArr[index] = element;
    }

    public void removeByNum( int index){

        for (int i = index; i < innerArr.length-1; i++){

            innerArr[i] = innerArr[i+1];

        }

        innerArr = Arrays.copyOf(innerArr, innerArr.length-1);
    }

    private void resizeAdd(){

        innerArr = Arrays.copyOf(innerArr, innerArr.length + 1);

    }

    public void searchBySecondName(String secondName){


        for (InnerClass x : innerArr) {

           if(x.getSecondName().lastIndexOf(secondName) != -1)
           {
               System.out.println(x.toString());
           }

        }

    }

    public void showAll(){

        for(InnerClass x : innerArr){
            System.out.println(x.toString());
        }
    }

}

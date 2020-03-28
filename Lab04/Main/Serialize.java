package Main;

import java.io.*;

public class Serialize {

    public boolean checkSerializeCollect(ClassCollection collection) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\jtmotn\\IdeaProjects\\src\\Lab04\\colllection.dat")) )
        {
            oos.writeObject(collection);
            return true;
        }
        catch (Exception ex){
                return false;
        }
    }

    public boolean checkDeserializeCollect(ClassCollection collection) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\jtmotn\\IdeaProjects\\src\\Lab04\\colllection.dat"))) {

            collection =  (ClassCollection) ois.readObject();
            return true;
        }
       catch (Exception ex){
            return false;
        }
    }

    public boolean checkReadFromFile(ClassCollection collection) {

        try(FileReader reader = new FileReader("C:\\Users\\jtmotn\\IdeaProjects\\src\\Lab04\\src\\smth.txt")) {

            BufferedReader buf = new BufferedReader(reader);
            String str;
            String[] str2;
            while ((str = buf.readLine())!= null){

                str2 =  str.split(" ");

                for (var item: str2){
                    collection.add(item);
                }
            }
            reader.close();
            buf.close();
            return true;
        }
        catch (IOException ex){
            return false;
        }
    }

    public boolean checkWriteFromFile(ClassCollection collection){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\jtmotn\\IdeaProjects\\src\\Lab04\\src\\smth.txt"))){

            Object[] obj = collection.toArray();
            for(var item : obj){
                bw.write((Character) item);
                bw.newLine();
            }
            bw.close();
            return true;
        }
        catch (IOException ex){
            return false;
        }
    }
}

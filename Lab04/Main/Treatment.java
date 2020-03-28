package Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Treatment {
    private  ArrayOb[] arrayOb ;

    class  ArrayOb implements Comparator, Comparable  {
        private Object obj;

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        @Override
        public int compare(Object o1, Object o2) {

            try{
                int result = (int)o1 - (int)o2;
                if (result > 0){
                    return 1;
                }else if (result == 0){
                    return 0;
                }else {
                    return -1;
                }
            }
            catch (Exception ex){
                return 0;
            }
        }

        @Override
        public int compareTo(Object o) {
            try {
                return ((String) this.obj).compareTo((String)o);
            }catch (Exception ex){
                return 0;
            }
        }
    }

    public void show(ClassCollection collection) {
        Object[] obj =  collection.toArray();
        var n = 0;
        for (var item: obj) {
            System.out.println("N:" + n + "| Item:" + item);
        }
    }

    public void sorted(ClassCollection collection) {
        Object[] array =  collection.toArray();
        arrayOb =  new ArrayOb[collection.size()];

        var n = 0;

        collection.clear();

        for (var item: array){
            arrayOb[n].setObj(item);
            n++;
        }

        Arrays.sort(arrayOb);
        collection.addAll(Arrays.asList(arrayOb));
    }

    public void filtr(ClassCollection collection) {

        collection.exportToArrayList().stream().filter(s-> s instanceof String).forEach(s->System.out.print(s));

        System.out.println("\n");
     }

}
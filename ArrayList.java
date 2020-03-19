import java.lang.reflect.Array;

public class ArrayList<T> implements List<T>{

    private Class<T> type;
    private int size;
    private T[] arrayList;

    public ArrayList(){
        size = 0;
        arrayList = (T[])new Object[10];
    }

    public void add(T item){
        if(arrayList.length == size){
            doubled();
        }

        arrayList[size] = item;
        size += 1;

    }

    public void add(int pos, T item){

        if(pos < 0 || pos > size){
            /* Throw an exception*/
            throw new IndexOutOfBoundsException();
        }

        if(arrayList.length == size){
            doubled();
        }

        for(int i = size; i > pos; i--){
            arrayList[i] = arrayList[i-1];
        }
        arrayList[pos] = item;
        size += 1;

    }

    public T get(int pos){

        return arrayList[pos];

    }

    public T remove(int pos){

        /* Check position */
        if(pos < 0 || pos > size){
            /* Throw an exception*/
            throw new IndexOutOfBoundsException();
        }
        T temp = arrayList[pos];
        for(int i = pos; i < size - 1; i++){
            arrayList[i] = arrayList[i + 1];
        }
        size -= 1;
        return temp;

    }

    public int size(){
        return size;
    }

    private void doubled(){

        T[] new_arrayList;
        new_arrayList = (T[])new Object[arrayList.length * 2];

        for(int i = 0; i < size; i++){
            new_arrayList[i] = arrayList[i];
        }
        arrayList = new_arrayList;

    }


}

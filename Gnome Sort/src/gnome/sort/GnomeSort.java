package gnome.sort;

/**
 *
 * @author Juan Salinas & David Ortiz
 */
public class GnomeSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        int index = 0;
        while (index < array.length) {
            if (index == 0 || less(array[index - 1], array[index])) {
                index++;
            } else {
                exch(array, index, index - 1);
                index--;
                show(array);
            }            
        }
    }

    private static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) <= 0;
    }

    private static <T> void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        int index = 0;
        while (index < array.length) {
            if (index == 0 || less(array[index - 1], array[index])) {
                index++;
            } else {
                return false;
            }            
        }
        return true;
    }

    private static <T> void show(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Integer[] array = {34, 2, 10, -9, 3, 8, 5, 9, -3, 7, 7, 12};
        System.out.println("Array antes de ordenar:");
        show(array);
        
        System.out.println("¿Está ordenado? " + isSorted(array));
                        
        System.out.println("Array después de ordenar:");
        sort(array);
        
        System.out.println("¿Está ordenado? " + isSorted(array));
    }
}    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author savb2
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //busqueda secuencial mejora
        // TODO code application logic here
        int[] array = new int[10];
        int[] array2 = new int[10];
        for (int i=0; i < 10; i++) {
            array[i]= (int)(Math.random() * 50 + 1);
        }
        System.out.println("selection sort");
        //imprimirArr(array);
        //sSort(array);
        //imprimirArr(array);
        for (int i=0; i < 10; i++) {
            array[i]= (int)(Math.random() * 50 + 1);
        }
        System.out.println("insertion sort");
        imprimirArr(array);
        iSort(array);
        imprimirArr(array);
        for (int i=0; i < 10; i++) {
            array[i]= (int)(Math.random() * 50 + 1);
        }
        System.out.println("bubble sort");
        imprimirArr(array);
        bubbleSort(array);
        imprimirArr(array);
        for (int i=0; i < 9; i++) {
            array2[i]= (int)(Math.random() * 50 + 1);
        }
        array2[9]= 55;
        bubbleSort(array2);
        imprimirArr(array2);       
        System.out.println(binarySearch(array2, 55));
        System.out.println(sequential(array2,55));
    }
    public static void iSort(int[] array){//falta comprobar
        for (int i = 0; i < array.length; i++) {
            for (int j = i ; j > 0; j--) {
                if(array[j]<array[j-1]){
                    int temp = array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    public static void sSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;//suponemos que es el mas peque;o
            for (int j = i+1; j < array.length; j++) {//buscar el mas peque;o
                if(array[j]<array[min]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i]=temp;
        }
    }
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    public static void imprimirArr(int[] arr){
        for (int i : arr) {
            System.out.print(i+"-");
        }
        System.out.println("");
    }
    public static int binarySearch(int[] arr, int pos){
        return biSearch(arr, pos, 0 ,arr.length-1);
    }
    private static int biSearch(int[] arr, int valB, int lo, int hi){
        int mid = lo + ((hi - lo) / 2);
        int pos = -1;
        if (lo <= hi) {
            if (valB == arr[mid]) {
                pos = mid;
            } else if (valB < arr[mid]) {
                pos = biSearch(arr, valB, lo, mid - 1);
            }
            else if (valB > arr[mid]) {
                pos = biSearch(arr, valB, mid + 1, hi);
            }
        }
        return pos;
    }
    public static void quickSort(int[] arr, int iMin, int iMax) {
        int pivote = arr[iMin];
        int der = iMax;
        int izq = iMin;  
        while (izq < der) {
            while (arr[izq] <= pivote && izq < der) {
                izq++;
            }
            while (arr[der] > pivote) {
                der--;
            }
            if (izq < der) {
                int temp = arr[izq];
                arr[izq] = arr[der];
                arr[der] = temp;
            }
        }
        arr[iMin] = arr[der];
        arr[der] = pivote;
        if (iMin < der - 1) {
            quickSort(arr, iMin, der - 1);
        }
        if (der + 1 < iMax) {
            quickSort(arr, der + 1, iMax);
        }
    }
    
    public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
    }
    public static int sequential(int[] arr, int valB){
        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==valB){
                pos = i;
                break;
            }
            
        }
        return pos;   
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsortingarrays;

import java.util.Arrays;

/**
 *
 * @author DEI-ISEP
 */


public class GenericSortingArrays {

    /**
     * Swaps two vector positions                  O(1)
     */
    public static <E> void swap(E[] v, int i, int j) {

        E temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    //  printArray
    public static <E> void printArray(E[] v) {
        for (E element : v)
            System.out.println(", " + element);
    }

    /**
     * Selection Sort Algorithm
     * Uncompleted!
     */
    public static <E extends Comparable<E>> void selectionSort(E[] v) {

        int min;
        for (int i = 0; i < v.length - 2; i++) {
            min = i;
            for (int j = i + 1; j < v.length -1; j++) {
                if (v[j].compareTo(v[min]) <0)
                    min = j;
                swap(v, i, min);
            }
        }
    }

    /**
     * Bubble Sort Algorithm
     *
     * @param v
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] v) {

        boolean swap = true;

        for (int i = 0; (i < v.length - 1 && swap); i++) {// a primeira vez
            swap = false;
            for (int j = v.length - 1; j > i; j--) {// n vezes
                if (v[j - 1].compareTo(v[j]) > 0) {
                    swap(v, j, j - 1);
                    swap = true;
                }
            }
        }
    }// Não Deterministico: Melhor caso: O(n), Pior caso O(n²)

    /**
     * insertionSort Algorithm
     */
    public static <E extends Comparable<E>> void insertionSort(E[] v) {

        for (int i = 0; i < v.length; i++) { // n + 1 vezes(todas as n vezes + 1 vez que é a verificação de quando é falso)
            int j = i;                      // n vezes
            E x = v[i];                     // n vezes
            while (j > 0 && x.compareTo(v[j - 1]) < 0) { // n x 1º situação: n; 2º situação: 1
                v[j] = v[j - 1];
                j = j - 1;
            }
            v[j] = x;
        }//Não deterministico, Melhor caso: O(n); Pior caso: O(n²)
    }

    /**
     * Mergesort Algorithm
     */
    private static <E extends Comparable<E>> void merge(E[] S1, E[] S2, E[] S) {

        int j=0, k=0,i=0;
        while (j<S1.length && k<S2.length){
            if (S1[j].compareTo(S2[k]) < 0){
                S[i]=S1[j];
                j++;
            }else {
                S[i]=S2[k];
                k++;
            }
            i++;
        }
        while (j<S1.length){
            S[i] = S1[j];
            j++;
            i++;
        }
        while (k<S2.length){
            S[i]=S2[k];
            k++;
            i++;
        }

    }//Algoritmo Deterministico com complexidade -> O(n)

    public static <E extends Comparable<E>> void mergeSort(E[] S) {

        int n = S.length;

        if (n >=2){
            int mid = n/2;                              //Divide o array
            E[] S1 = Arrays.copyOfRange(S,0,mid);
            E[] S2 = Arrays.copyOfRange(S, mid, n);
                                                        // recursividade
            mergeSort(S1);                              //vetor da esquerda(left)
            mergeSort(S2);                              // vetir da direita(rigth)

            merge(S1, S2, S);                           // metodo para executar o merge sorted e juntar o array novamente
        }
    }//Algoritmo Deterministico com complexidade -> O(LogN)

    /**
     * Quicksort Algorithm
     */
    public static <E extends Comparable<E>> void quickSort(E v[]) {

        quickSort(v,0,v.length-1);
    }

    private static <E extends Comparable<E>> void quickSort(E v[], int left, int right) {
        int i = left;
        int j = right;
        E pivot = v[left + ((right-left) / 2)];

        while (i<=j){ // n
            while (v[i].compareTo(pivot) < 0){
                i++;
            }
            while (v[j].compareTo(pivot) > 0){
                j--;
            } // Whiles separados, ou seja, consideramos n. Logo, no melhor caso esses loops não são executados e o while de fora é executado uma vez.
              // Já no pior casso, são todos executados n vezes, O(n²).
              // No melhor caso, o while é executado uma vez, e a recursividade reduz o tamanho do array pela metado, logo, O(logn)
            if (i <= j){
                swap(v,i,j);
                i++;
                j--;
            }
        }


        if (left < j)
            quickSort(v,left,j);
        if (i< right)
            quickSort(v,i,right);
    }//Algoritimo não determinante, melhor caso: O(log(n)) pior caso: O(n²)

}

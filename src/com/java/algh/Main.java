package com.java.algh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Integer[] insertie(Integer list[], int element) {
        int j, key;
        for (int index = 1; index < element; index++) { //pentru toate elementele de la al doilea până la ultimul
            key = list[index]; //pentru elementul list[index]
            j = index - 1; //îi căutăm locul în secvenţa list[0]..list[i-1]
            while ((j >= 0) && (key < list[j])) {  //atât timp cât nu ajungem pe prima poziţie şi elementul de inserat este mai mic decât list[j]
                list[j + 1] = list[j]; //mutăm elementul list[j] pe poziţia j+1
                j--;  //decrementăm indicele j pentru a ajunge la precedentul element
            }
            list[j + 1] = key;  //la ieşirea din ciclul while, elementul trebuie inserat pe poziţia j+1
        }
        return list;
    }

    private static List<Integer> citireLista(Scanner scanner, int length) {
        List<Integer> list = new ArrayList<>();
        System.out.println("Introduceti elementele de la tastatura");
        for (int i = 0; i < length; i++) {
            System.out.println("List[" + i + "]=");
            list.add(scanner.nextInt());
        }
        return list;
    }

    private static Integer[] convert(List<Integer> list) {
        return (Integer[])list.toArray(new Integer[list.size()]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti lungimea sirului de numere dorit: ");
        int length = scanner.nextInt();

        List<Integer> list = citireLista(scanner, length);
        System.out.println("Sirul initial este: " + list);

        System.out.println("Ce element doriti sa adaugati?");
        int elementDeAdaugat = scanner.nextInt();

        Integer[] listaOrdonata = insertie(convert(list), elementDeAdaugat);

        System.out.println("Sirul ordonat este: " + Arrays.toString(listaOrdonata));
    }
}

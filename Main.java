package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> cola = new LinkedList<>();

        System.out.println("¿Cuantos numeros quieres meter en la cola?");
        int n = sc.nextInt();

        System.out.println("Escribe los numeros:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            cola.add(num); //Agregamos a la cola
        }

        System.out.println("Cola original: " + cola);

        invertir(cola); 

        System.out.println("Cola invertida: " + cola);

        sc.close();
    }

    
    public static void invertir(Queue<Integer> cola) {
        
        if (cola.isEmpty()) {
            return;
        }

        // sacamos el primer elemento
        int frente = cola.remove();

        
        invertir(cola);

        // al volver, metemos el elemento al final
        cola.add(frente);
    }
}


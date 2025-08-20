package Stack;

import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pila = new Stack<>(); // aquí guardaremos los símbolos

        System.out.println("Escribe una expresion con (), {}, []:");
        String expresion = sc.nextLine();

        boolean balanceado = true; // asumimos que está bien hasta que se demuestre lo contrario

        // recorremos cada caracter de la expresion
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // si es de apertura lo metemos a la pila
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } 
            // si es de cierre revisamos la pila
            else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) {
                    balanceado = false; // no hay con qué cerrar
                    break;
                } else {
                    char tope = pila.pop(); // quitamos el último abierto

                    // comprobamos que coincidan
                    if (c == ')' && tope != '(') {
                        balanceado = false;
                        break;
                    }
                    if (c == '}' && tope != '{') {
                        balanceado = false;
                        break;
                    }
                    if (c == ']' && tope != '[') {
                        balanceado = false;
                        break;
                    }
                }
            }
        }

        // al final, si la pila no está vacía, significa que quedaron abiertos sin cerrar
        if (!pila.isEmpty()) {
            balanceado = false;
        }

        if (balanceado) {
            System.out.println("La expresion esta balanceada :)");
        } else {
            System.out.println("La expresion NO esta balanceada :(");
        }

        sc.close();
    }
}

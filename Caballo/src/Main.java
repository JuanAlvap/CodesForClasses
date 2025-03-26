
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numCaballos, numVueltas;
        System.out.println("Digite el numero de caballos que correran: ");
        numCaballos = leer.nextInt();
        // Verificamos que el numero de caballos sea valido
        while (numCaballos < 1) {
            System.out.println("Digite un numero de caballos valido: ");
            numCaballos = leer.nextInt();
        }
        int[] c = new int[numCaballos];
        int[] t = new int[numCaballos];
        System.out.println("Digite el numero de vueltas que se correran: ");
        numVueltas = leer.nextInt();
        // Verificamos que el numero de vueltas sea valido
        while (numVueltas < 1) {
            System.out.println("Digite un numero de vueltas valido: ");
            numVueltas = leer.nextInt();
        }
        for (int i = 0; i < numCaballos; i++) {
            System.out.println("Digite el numero de vueltas del caballo " + (i + 1) + ": ");
            c[i] = leer.nextInt();
            // Verificamos que el numero de vueltas sea valido
            while (c[i] < 1 || c[i] > numVueltas) {
                System.out.println("Digite un numero de vueltas valido: ");
                c[i] = leer.nextInt();
            }
            System.out.println("Digite el tiempo en segundos del caballo en esa carrera " + (i + 1) + ": ");
            t[i] = leer.nextInt();
            // Verificamos que el tiempo sea valido
            while (t[i] < 1) {
                System.out.println("Digite un tiempo valido: ");
                t[i] = leer.nextInt();
            }
        }
        
        int [] tiempoAux = t.clone();
        boolean termino = false;
        int tiempoMinimo, caballoGanador = 0, tiempoTotal = 0;
        // Verificamos quien fue el caballo ganador en tiempo y además de que haya terminado la carrera
        while (!termino) {
            tiempoMinimo = tiempoAux[0];
            tiempoTotal = t[0];
            for (int i = 1; i < numCaballos; i++) {
                if (tiempoMinimo > tiempoAux[i]) {
                    tiempoMinimo = t[i];
                    caballoGanador = i;
                }
                tiempoTotal += t[i];
            }
            if(c[caballoGanador] == numVueltas){
                termino = true;
            }else{
                tiempoAux[caballoGanador] = Integer.MAX_VALUE;
            }
        }
        System.out.println("El caballo ganador es el numero: "+ caballoGanador+1 + " con un tiempo promedio de " + (double)(t[caballoGanador]/numVueltas));
        int [] ganadores10 = new int [numCaballos];
        for (int i = 0; i < numCaballos; i++) {
            ganadores10[i] = i+1;
        }
        tiempoAux = t.clone();
        // Verificamos que los caballos hayan terminado la carrera y si no la terminaron le asignamos el tiempo maximo posible
        for (int i = 0; i < numCaballos; i++){
            if(c[i] != numVueltas){
                tiempoAux[i] = Integer.MAX_VALUE;
            }
        }
        // Hacemos un bubble sort para ordenar los tiempos de los caballos
        for (int i = 0; i < numCaballos; i++) {
            for (int j = 0; j < numCaballos; j++) {
                if (j < numCaballos - 1 && tiempoAux[j] > tiempoAux[j+1]){
                    int aux = tiempoAux[j]; 
                    tiempoAux[j] = tiempoAux[j+1];
                    tiempoAux[j+1] = aux;
                    aux = ganadores10[j];
                    ganadores10[j] = ganadores10[j+1];
                    ganadores10[j+1] = aux;
                }
            }
            
        }
        System.out.println("Los 10 primeros caballos en terminar la carrera son: ");
        // Obtenemos el numero minimo para que no nos de un error de IndexOutOfBounds
        int top = Math.min(numCaballos, 10);
        for (int i = 0; i < top; i++) {
            System.out.println(+ (i+1) +"El caballo numero: " + ganadores10[i] + " con un tiempo promedio de: " + tiempoAux[i]/numVueltas + " segundos");
        }
        System.out.println("El tiempo promedio total de la carrera es de: " + tiempoTotal/numVueltas + " segundos");
    }
}

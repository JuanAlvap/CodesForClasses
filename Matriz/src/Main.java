
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n;
        System.out.println("Digite el valor de n: ");
        n = leer.nextInt();

        // Leemos los elementos que va a contener la matriz
        int[][] A = new int[2 * n][2 * n];
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                System.out.println("Digite el valor de A[" + i + "][" + j + "]: ");
                A[i][j] = leer.nextInt();
            }
        }

        // Hacemos el recorrido de la matriz para saber si es simetrica
        boolean simetrica = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != A[j][i]) {
                    simetrica = false;
                }
            }
        }

        // Verificamos si lo fue o no y mostramos el resultado
        if (simetrica) {
            System.out.println("La matriz es simetrica");
        } else {
            System.out.println("La matriz no es simetrica");
        }

        // Hacemos la transpuesta de la matriz y la mostramos
        int aAux[][] = A.clone();
        for (int i = 0; i < n; i++) {
            for (int j = i + n; j < 2 * n; j++) {
                int temp = aAux[i][j];
                aAux[i][j] = aAux[j][i];
                aAux[j][i] = temp;
            }
        }
        System.out.println("Original");
        for (int i = 0; i < n; i++) {
            for (int j = n; j < 2 * n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Transpuesta");
        for (int i = 0; i < n; i++) {
            for (int j = n; j < 2 * n; j++) {
                System.out.print(aAux[i][j] + " ");
            }
            System.out.println();
        }
        
        // Hacemos la traspuesta de la matriz mediante la diagonal secundaria y la mostramos
        aAux = A.clone();
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n - i - 1; j++) {
                int temp = aAux[i][j];
                aAux[i][j] = aAux[n - j - 1][n - i - 1];
                aAux[n - j - 1][n - i - 1] = temp;
            }
        }
        System.out.println("Original");
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n - 1; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Transpuesta");
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n - 1; j++) {
                System.out.print(aAux[i][j] + " ");
            }
            System.out.println();
        }
        
        // Primero verificamos que el numero sea primo y luego lo guardamos en un vector
        int tamaño = 0;
        int[] vector = new int[4 * n * n];
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if (A[i][j] > 1) {
                    boolean primo = true;
                    for (int k = 0; k < A[i][j] / 2; k++) {
                        if (A[i][j] % i == 0) {
                            primo = false;
                        }
                    }
                    if (primo) {
                        vector[tamaño] = A[i][j];
                        tamaño++;
                    }
                }
            }
        }

        // Eliminamos los elementos repetidos del vector
        for (int i = 0; i < tamaño; i++) {
            for (int j = i; j < tamaño; j++) {
                if( vector[i] == vector[j]){
                    vector[j] = 0;
                }
            }
        }

        // Ponemos estos elementos al final del vector
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if(vector[j] == 0 && j < tamaño ){
                    int temp = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = temp;
                }
            }
        }

        // Contamos los ceros que hay en el vector y se lo restamos al tamaño para tener el tamaño real del vector
        int ceros = 0;
        for (int i = 0; i < tamaño; i++) {
            if(vector[i] == 0){
                ceros++;
            }
        }

        // Mostramos el vector
        tamaño -= ceros;
        if(tamaño == 0){
            System.out.println("No hay numeros primos en la matriz");
        }
        for (int i = 0; i < tamaño; i++) {
            System.out.print(vector[i]+ ", ");
        }
    }
}

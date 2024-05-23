import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in); // Cria o Scanner

        System.out.println("Digite seu nome: "); // Pergunta o nome do usuário no terminal

        String nome = teclado.nextLine(); // Recebe do teclado o nome

        System.out.println("O nome eh: " + nome);
    }
}

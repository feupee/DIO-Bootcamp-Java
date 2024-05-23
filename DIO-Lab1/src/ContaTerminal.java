import java.util.Scanner;

public class ContaTerminal {
    private String titular;
    private String numeroConta;
    private double saldo;

    public ContaTerminal(String titular, String numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à criação de uma conta bancária!");
        System.out.println("Por favor, insira as informações abaixo:");

        System.out.print("Nome do titular da conta: ");
        String titular = scanner.nextLine();

        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();

        // Criando uma instância da classe ContaBancaria
        ContaTerminal conta = new ContaTerminal(titular, numeroConta, saldoInicial);

        // Fechando o scanner
        scanner.close();

        System.out.println("Conta criada com sucesso para " + conta.getTitular() + "!");
    }

    // Métodos de acesso para os atributos da conta
    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
}
package util;
import java.util.Scanner;

public class InterfaceUsuario {

    public Scanner scanner;

    //iniciação do scanner
    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }
    //entrada do valor do imovel
    public double pedirValorImovel() {
        double valor;
        while (true) {
            System.out.println("Digitar o valor do imóvel: ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Erro: O valor do imóvel deve ser positivo.");
            } else {
                break;
            }
        }
        return valor;
    }
    //entrada do prazo de financiamento
    public int pedirPrazoFinanciamento() {
        int prazo;
        while (true) {
            System.out.println("Digitar o Prazo do Financiamento (em anos): ");
            prazo = scanner.nextInt();
            if (prazo <= 0) {
                System.out.println("Erro: O prazo do financiamento deve ser positivo.");
            } else {
                break;
            }
        }
        return prazo;
    }
    //entrada da taxa de juros anual
    public double pedirTaxaJurosAnual() {
        double taxa;
        while (true) {
            System.out.println("Digitar a Taxa de Juros Anual: ");
            taxa = scanner.nextDouble();
            if (taxa <= 0 || taxa >= 10000) {
                System.out.println("Erro: A taxa de juros deve ser positiva e razoável.");
            } else {
                break;
            }
        }
        return taxa;
    }

}

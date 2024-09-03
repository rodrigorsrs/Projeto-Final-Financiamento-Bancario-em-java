package main;

import java.util.Scanner;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Perguntar ao usuário quantos financiamentos deseja adicionar
        System.out.print("Quantos financiamentos deseja adicionar? ");
        int numFinanciamentos = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        // Coletar dados dos financiamentos fornecidos pelo usuário
        for (int i = 0; i < numFinanciamentos; i++) {
            System.out.printf("\nDigite os dados para o financiamento %d:\n", i + 1);

            System.out.print("Digite o tipo de financiamento (Casa, Apartamento, Terreno): ");
            String tipo = scanner.nextLine();

            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            switch (tipo.toLowerCase()) {
                case "casa":
                    System.out.print("Digite o tamanho da área construída: ");
                    double tamanhoAreaConstruida = scanner.nextDouble();
                    System.out.print("Digite o tamanho do terreno: ");
                    double tamanhoTerreno = scanner.nextDouble();
                    scanner.nextLine();  // Consumir a nova linha
                    financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno));
                    break;
                case "apartamento":
                    System.out.print("Digite o número de vagas da garagem: ");
                    int vagasGaragem = scanner.nextInt();
                    System.out.print("Digite o número do andar: ");
                    int numeroAndar = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    financiamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, vagasGaragem, numeroAndar));
                    break;
                case "terreno":
                    System.out.print("Digite o tipo de zona (Residencial ou Comercial): ");
                    String tipoZona = scanner.nextLine();
                    financiamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona));
                    break;
                default:
                    System.out.println("Tipo de financiamento desconhecido. Ignorando este financiamento.");
                    break;
            }
        }

        // Calcular e exibir os resultados
        double somaValorImoveis = 0;
        double somaTotalFinanciamentos = 0;

        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            double pagamentoMensal = financiamento.calcularPagamentoMensal();
            double totalPagamento = financiamento.calcularTotalPagamento();
            somaValorImoveis += financiamento.getValorImovel();
            somaTotalFinanciamentos += totalPagamento;

            String tipoFinanciamento;
            if (financiamento instanceof Casa) {
                tipoFinanciamento = "Casa";
                Casa casa = (Casa) financiamento;
                System.out.printf("\nCasa %d:\n", i + 1);
                System.out.printf("Tamanho da Área Construída: %.2f\n", casa.getTamanhoAreaConstruida());
                System.out.printf("Tamanho do Terreno: %.2f\n", casa.getTamanhoTerreno());
            } else if (financiamento instanceof Apartamento) {
                tipoFinanciamento = "Apartamento";
                Apartamento apartamento = (Apartamento) financiamento;
                System.out.printf("\nApartamento %d:\n", i + 1);
                System.out.printf("Número de Vagas na Garagem: %d\n", apartamento.getVagasGaragem());
                System.out.printf("Número do Andar: %d\n", apartamento.getNumeroAndar());
            } else if (financiamento instanceof Terreno) {
                tipoFinanciamento = "Terreno";
                Terreno terreno = (Terreno) financiamento;
                System.out.printf("\nTerreno %d:\n", i + 1);
                System.out.printf("Tipo de Zona: %s\n", terreno.getTipoZona());
            } else {
                tipoFinanciamento = "Desconhecido";
            }

            System.out.printf("Valor do imóvel: %.2f\n", financiamento.getValorImovel());
            System.out.printf("Pagamento mensal: %.2f\n", pagamentoMensal);
            System.out.printf("Total do pagamento: %.2f\n", totalPagamento);
            System.out.printf("Total de parcelas: %d\n", financiamento.getPrazoEmMeses());
        }

        System.out.printf("\nSoma dos valores dos imóveis: %.2f\n", somaValorImoveis);
        System.out.printf("Soma dos valores dos financiamentos: %.2f\n", somaTotalFinanciamentos);
    }
}

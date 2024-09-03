package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double prazoEmMeses = getPrazoEmMeses();
        double taxaMensal = taxaJurosAnual / 12 / 100;
        double fator = Math.pow(1 + taxaMensal, prazoEmMeses);
        double pagamentoMensal = valorImovel * (taxaMensal * fator) / (fator - 1);
        return pagamentoMensal * 1.02; // 2% adicional
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoEmMeses();
    }
}
public class ColaboradorComissionado extends Colaborador {

    private double valorVendas;
    private double percentualComissao;

    public ColaboradorComissionado(
            int matricula,
            String nome,
            double valorVendas,
            double percentualComissao) {

        super(matricula, nome);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public double calcularComissao() {
        return valorVendas * percentualComissao / 100.0;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularComissao();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();

        System.out.println("Tipo: Comissionado");

        System.out.printf(
                "Salário Base: R$ %.2f%n",
                getSalarioBase());

        System.out.printf(
                "Comissão: R$ %.2f%n",
                calcularComissao());

        System.out.printf(
                "Salário Final: R$ %.2f%n",
                calcularSalarioFinal());
    }
}

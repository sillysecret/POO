import java.util.Arrays;

public class app {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "João", "999999999");
        Cliente cliente2 = new Cliente(2, "Maria", "888888888");
        
        Carga carga1 = new Carga(1, 100, 1000, 10, 
        new TipoCargaDuravel(1, "Carga durável", "Setor 1", "Material 1"), 
        cliente1, Situacoes.Pendente,new Destino( 1000,"São Paulo"),new Destino( 1000,"Rio de janeiro"));



        Caminhao caminhao1 = new Caminhao("Caminhão 1", 100, 1000, 10, 1);

        frotaCaminhoes frota = new frotaCaminhoes();
        DestinosCad destinos = new DestinosCad();





        //frete(caminhao1,carga1);
    }

    public static void frete(Caminhao caminhao, Carga carga) {
        //preco do peso da carga || carga.getTipoCarga().getPrecoPorPeso(carga.getPeso())
        //preco destino || caminhao.getCustoPorKm * new API().setRequestMethod(carga);

        System.out.println(caminhao.getCustoPorKm());

        System.out.println(carga.getTipoCarga().getPrecoPorPeso(carga.getPeso()));

        System.out.println((caminhao.getCustoPorKm() * new API().setRequestMethod(carga)) + (carga.getTipoCarga().getPrecoPorPeso(carga.getPeso())));
    }
}

public class app {
    public static void main(String args[]) {
        Carga carga = new Carga(0, 0, 0, 0);
        Cliente cliente = new Cliente(0, null, null);
        Caminhao caminhao = new Caminhao(null, 0, 0, 0, 0);
        System.out.println(carga.toString());
        System.out.println(cliente.toString());
        System.out.println(caminhao.toString());
    }    
}

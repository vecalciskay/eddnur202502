package observer;

public class Banco {
    public static void main(String[] args) {
        CuentaBanco cta = new CuentaBanco("John Smith", 100);

        PromoComercialAgosto25_M42 promo = new PromoComercialAgosto25_M42(cta);

        cta.deposito(150);
        cta.deposito(75);
        cta.retiro(17);
        cta.deposito(95);
        cta.retiro(55);

        System.out.println(cta);
    }


}

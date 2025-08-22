package observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CuentaBanco {
    private static final Logger logger = LogManager.getRootLogger();
    private String cliente;
    private float saldo;
    private PropertyChangeSupport observado;

    public CuentaBanco(String cliente, float saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.observado = new PropertyChangeSupport(this);
        logger.info("Creada la cuenta: " + this.toString());
    }

    public void nuevoObservador(PropertyChangeListener observador) {
        this.observado.addPropertyChangeListener(observador);
        logger.info("Objeto cuenta con un nuevo observador: " +
                observador.toString());
    }

    public String getCliente() {
        return cliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void deposito(float monto) {
        float saldoAnterior = this.saldo;
        this.saldo += monto;
        logger.info("Se DEPOSITO " + monto + "Bs. El saldo cambio de " +
                saldoAnterior + " a " + saldo);
        observado.firePropertyChange("MONTO", saldoAnterior, saldo);
    }

    public void retiro(float monto) {
        float saldoAnterior = this.saldo;
        this.saldo -= monto;
        logger.info("Se RETIRO " + monto + "Bs. El saldo cambio de " +
                saldoAnterior + " a " + saldo);
        observado.firePropertyChange("MONTO", saldoAnterior, saldo);
    }

    @Override
    public String toString() {
        return cliente + " tiene en su cuenta " + saldo  + " Bs";
    }

    public void depositoInterno(float promo) {
        this.saldo += promo;
    }
}

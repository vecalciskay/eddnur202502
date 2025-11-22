package persistencia.dominio;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
@Entity // 1. Marks this class as a persistent entity
@Table(name = "personas") // 2. Specifies the table name in MySQL
public class Persona implements Serializable {
    @Id // 3. Designates the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. MySQL auto-increment
    @Column(name = "id")
    protected int id;
    @Column(name = "nombre", nullable = false)
    protected String nombre;
    @Column(name = "fechanacimiento", nullable = false)
    protected Date fechaNacimiento;
    @Column(name = "salario", nullable = false)
    protected float salario;
    @Column(name = "habilitado", nullable = false)
    protected boolean habilitado;

    protected Persona() {
        nombre = "";
        fechaNacimiento = new Date(2000,1,1);
    }

    public Persona(int id, String nombre, Date fechaNacimiento, Float salario, boolean habilitado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.habilitado = habilitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha Nacimiento=" + fechaNacimiento +
                ", salario=" + salario +
                ", habilitado=" + habilitado +
                '}';
    }
}
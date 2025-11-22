package persistencia.accesodatos.dto;

import java.sql.Date;

public class PersonaDTO {
    protected int id;
    protected String nombre;
    protected Date fechaNacimiento;
    protected float salario;
    protected boolean habilitado;

    public PersonaDTO() {
        id = 0;
        nombre = "";
        fechaNacimiento = new Date(2000,1,1);
        salario = 0;
        habilitado = true;
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
        return "PersonaDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha Nacimiento=" + fechaNacimiento +
                ", salario=" + salario +
                ", habilitado=" + habilitado +
                '}';
    }
}

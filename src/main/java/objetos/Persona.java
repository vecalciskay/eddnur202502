package objetos;


import java.time.LocalDate;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private long ci;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, long ci, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.ci = ci;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCi() {
        return ci;
    }

    public void setCi(long ci) {
        this.ci = ci;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", ci=" + ci +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
        if (fechaNacimiento.compareTo(o.getFechaNacimiento()) == 0) {
            if (ci == o.getCi())
                return nombre.compareTo(o.getNombre());
            else {
                if (ci < o.getCi())
                    return -1;
                return 1;
            }
        } else {
            return fechaNacimiento.compareTo(o.getFechaNacimiento());
        }
    }
}

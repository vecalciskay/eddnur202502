package persistencia.dominio;

import java.sql.Date;
import java.util.Calendar;

public class PersonaBuilder  {

    public Persona construir(int id, String nombre, Date fecha, float salario, boolean habilitado) throws IllegalArgumentException {
        if (id < 0)
            throw new IllegalArgumentException("Must have 0 or positive id");
        if ( nombre == null || nombre.isEmpty() )
            throw new IllegalArgumentException("Nombre tiene que tener algun valor");
        Calendar ayer = Calendar.getInstance();
        ayer.add(Calendar.HOUR, -24);
        if (fecha == null || fecha.after(new Date(ayer.getTimeInMillis())))
            throw new IllegalArgumentException("Fecha no puede ser nulo y debe ser antes de hoy");
        if (salario <= 0)
            throw new IllegalArgumentException("Salario no puede ser menor o igual a 0");

        return new Persona(id, nombre, fecha, salario, habilitado);
    }
}

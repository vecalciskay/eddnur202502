package persistencia.accesodatos.dao;

import persistencia.dominio.Persona;

import java.util.List;

public interface PersonaQueries {
    Persona findById(int id);
    List<Persona> findByNombre(String nombre);
    List<Persona> findTodos();
}

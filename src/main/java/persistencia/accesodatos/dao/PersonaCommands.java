package persistencia.accesodatos.dao;

import persistencia.dominio.Persona;

public interface PersonaCommands {
    void save(Persona persona);
    void update(Persona persona);
    void delete(Persona persona);
}
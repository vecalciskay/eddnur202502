package persistencia.mappers;

import org.mapstruct.Mapper;
import persistencia.accesodatos.dto.PersonaDTO;
import persistencia.dominio.Persona;

@Mapper(componentModel = "default")
public interface PersonaMapper {
    PersonaDTO toDTO(Persona persona);
}

package accesodatos;

import accesodatos.dao.PersonaDao;
import accesodatos.dto.PersonaDto;

public class TestDao {
    public static void main(String[] args) {
        PersonaDao dao = new PersonaDao();
        PersonaDto persona = dao.get(1);
        System.out.println(persona);
    }
}

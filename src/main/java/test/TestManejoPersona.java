package test;
import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersona {
    public static void main(String[] args) {


    PersonaDAO personaDao = new PersonaDAO();

    //INSERTAR UN NUEVO USUARIO

        Persona user1 = new Persona("User1","******");
        Persona user2 = new Persona("User2","******");
        Persona user3 = new Persona("User3","******");
        Persona user4 = new Persona("User4","******");
        personaDao.insertar(user1);
        personaDao.insertar(user2);
        personaDao.insertar(user3);
        personaDao.insertar(user4);

    // ACTUALIZAR UN REGISTRO

    Persona personaModificada = new Persona(3,"new.user3","******");
    personaDao.actualizar(personaModificada);

    // ELIMINAR UN REGISTRO

    Persona personaEliminada = new Persona(2);
    personaDao.eliminar(personaEliminada);


    List<Persona> personas = personaDao.seleccionar();
    for(Persona persona:personas){
        System.out.println(persona);
    }



    }

}

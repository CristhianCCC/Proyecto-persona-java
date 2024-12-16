package Proyecto_01.service;

import Proyecto_01.entities.Persona;
import jakarta.persistence.Id;

import java.util.List;

public interface PersonaService {

    //metodos a los cuales se les dara funcionalidad en PersonaServiceImpl

    List<Persona> obtenerTodas();

    Persona obtenerPorId(Long Id);

    Persona crearPersona(Persona persona);

    Persona actualizarPersona(Long Id, Persona persona);

    void eliminarPersona(Long Id);

}

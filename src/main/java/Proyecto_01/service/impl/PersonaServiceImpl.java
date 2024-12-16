package Proyecto_01.service.impl;
import Proyecto_01.entities.Persona;
import Proyecto_01.repository.PersonaRepository;
import Proyecto_01.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Persona> obtenerTodas() {
    return  personaRepository.findAll();
    }

    @Override
    public Persona obtenerPorId(Long Id) {
        return personaRepository.findById(Id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }


    @Override
    public Persona actualizarPersona(Long Id, Persona persona) {
        Persona personaBd = personaRepository.findById(Id).orElse(null);
        if (personaBd != null){
            personaBd.setNombre(persona.getNombre());
            personaBd.setEdad(persona.getEdad());
            personaRepository.save(personaBd);
        }
        return null;
    }

    @Override
    public void eliminarPersona(Long Id) {
    personaRepository.deleteById(Id);
    }
}

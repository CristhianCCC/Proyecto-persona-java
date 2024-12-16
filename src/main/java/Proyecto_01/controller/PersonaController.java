package Proyecto_01.controller;

import Proyecto_01.entities.Persona;
import Proyecto_01.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    //inyectando personaService
    @Autowired
    private PersonaService personaService;


    //la clase model se utiliza para transferir objetos del controller a la vista------------------------
    //Model sirve como un puente entre el controlador y la vista, permitiendo que los datos que procesas en el backend estén disponibles en la interfaz de usuario.

    //@GetMapping indica que va a ser un listado
    @GetMapping
    public String listarPersonas(Model model){
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("listaPersonas", personas); //-key valor
        //return, se debe colocar el nombre del archivo html que se va a almacenar en templates----------------------------------------
        return "listar";
    }

    //Get porque va a redirigir a otro archivo html el cual permitira crear a la nueva persona, se agrega el endpoint el cual sera el archivo html nueva
    @GetMapping("/nueva")
    public String mostrarFormulariodeNuevaPersona(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")
    //@ModelAttribute permite obtener la informacion de los campos del formulario para guardarlo en la base de datos
    public String guardarNuevaPersona(@ModelAttribute Persona persona){
        personaService.crearPersona(persona);
        return "redirect:/personas"; //luego de clickear en save, direccionara automaticamente a personas
    }

    //para editar una persona
    @GetMapping("/editar/{id}")
    //@PathVariable permite obtener los datos de la entidad por medio del id
    public String mostrarFormularioEditarPersona(@PathVariable Long id, @ModelAttribute Persona persona, Model model){
        model.addAttribute("persona", persona);
        model.addAttribute("accion", "/personas/editar/"+id);
        return "formulario";
    }


    @PostMapping("/editar/{id}")
    //@ModelAttribute para obtener los datos del formulario, en este caso del formulario de persona
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona){
        personaService.actualizarPersona(id,persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable long id){
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}

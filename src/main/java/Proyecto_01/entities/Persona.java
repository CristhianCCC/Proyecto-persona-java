package Proyecto_01.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Entity
@Table(name = "Tabla_Persona")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Persona {

    @Id
    //GeneratedValue se encarga de crear Id's automaticamente de manera autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int edad;

}

package registro.samtel.horas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.RegistroHorasEntity;
import registro.samtel.horas.services.impl.RegistroHorasServiceImpl;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/registro")

public class RegistroHorasController {

    private static Logger log = Logger.getLogger(String.valueOf(RegistroHorasController.class));

    @Autowired
    RegistroHorasServiceImpl registroHorasServiceImpl;

    @PostMapping("/crear")
    public RegistroHorasEntity crearRegistro(@RequestBody RegistroHorasEntity registro){
        log.info("Inicio metodo crearRegistro en RegistroHorasController");
        registroHorasServiceImpl.crearRegistro(registro);
        log.info("Termina metodo crearRegistro en RegistroHorasController");
        return registro;
    }

    @GetMapping
    public List<RegistroHorasEntity> consultarTodosRegistros(){
        log.info("Inicias netodo consultarTodosRegistros en RegistroHorasController");
        List<RegistroHorasEntity> registros = registroHorasServiceImpl.consultarTodosRegistros();
        log.info("Termina metodo consultarTodosRegistros en RegistroHorasController");
        return registros;
    }

    @GetMapping("/{id}")
    public RegistroHorasEntity consultarRegistroPorId(@PathVariable Long id){
        log.info("Inicia metodo consultarRegistroPorId en RegistroHorasController");
        RegistroHorasEntity registroHoras = registroHorasServiceImpl.consultarRegistroPorId(id);
        log.info("Termina metodo consultarRegistroPorId en RegistroHorasController");
        return registroHoras;
    }

        @GetMapping("/consultarPorUsuario/{idUsuario}")
    public List<RegistroHorasEntity> consultarTodosRegistrosUsuario(@PathVariable Long idUsuario){
        log.info("Inicia metodo consultarTodosRegistrosUsuario en RegistroHorasController");
        List<RegistroHorasEntity> registroHoras = registroHorasServiceImpl.consultarTodosRegistrosUsuario(idUsuario);
        log.info("Termina metodo consultarTodosRegistrosUsuario en RegistroHorasController");
        return registroHoras;
    }

    /*
    @GetMapping("/cosultarEstado/")
    public RegistroHorasEntity consultarEstadoUsuario(@PathVariable Long id, @PathVariable Long idUsuario){
        log.info("Inicia metodo consultarEstadoUsuario en RegistroHorasController");
        RegistroHorasEntity registroHoras = registroHorasServiceImpl.consultarEstadoUsuario(id);
        log.info("Termina metodo consultarEstadoUsuario en RegistroHorasController");
        return registroHoras;
    }
     */

    @GetMapping("/cosultarFecha/{fecha}")
    public List<RegistroHorasEntity> consultarRegistrosPorFecha(@PathVariable String fecha){
        log.info("Inicia metodo consultarRegistrosPorFecha en RegistroHorasController");
        List<RegistroHorasEntity> registroHoras = registroHorasServiceImpl.consultarTodosRegistrosPorFecha(fecha);
        log.info("Termina metodo consultarRegistrosPorFecha en RegistroHorasController");
        return registroHoras;
    }


    @DeleteMapping("/eliminar/{id}")
    public boolean eliminarRegistro(@PathVariable Long id, @RequestBody boolean estado) {
        log.info("Inicio metodo eliminarRegistro en RegistroHorasController");
        Boolean registroEliminado = registroHorasServiceImpl.eliminarRegistro(id, estado);
        log.info("Termina metodo eliminarRegistro en RegistroHorasController");
        return registroEliminado;
    }
}
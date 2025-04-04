package registro.samtel.horas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import registro.samtel.horas.services.RegistroHoraService;

@RestController
@RequestMapping("/api/registro-horas")
public class RegistroHoraController {

    @Autowired
    private RegistroHoraService service;

    @GetMapping
    public List<RegistroHora> listar() {
        return service.listar();
    }

    @PostMapping
    public RegistroHora guardar(@RequestBody RegistroHora registro) {
        return service.guardar(registro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroHora> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroHora> actualizar(@PathVariable Long id, @RequestBody RegistroHora datos) {
        return service.buscarPorId(id)
                .map(registro -> {
                    registro.setNombreEmpleado(datos.getNombreEmpleado());
                    registro.setFecha(datos.getFecha());
                    registro.setHoraEntrada(datos.getHoraEntrada());
                    registro.setHoraSalida(datos.getHoraSalida());
                    return ResponseEntity.ok(service.guardar(registro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

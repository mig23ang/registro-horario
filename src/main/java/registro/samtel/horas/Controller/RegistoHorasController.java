package registro.samtel.horas.Controller;
@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroRepository repo;

    @PostMapping
    public RegistroEntity agregar(@RequestBody RegistroEntity nuevo) {
        return repo.save(nuevo);
    }

    @GetMapping
    public List<RegistroEntity> verTodo() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RegistroEntity> verUno(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public RegistroEntity actualizar(@PathVariable Long id, @RequestBody RegistroEntity datos) {
        return repo.findById(id).map(registro -> {
            registro.setUsuario(datos.getUsuario());
            registro.setFecha(datos.getFecha());
            registro.setHoraEntrada(datos.getHoraEntrada());
            registro.setHoraSalida(datos.getHoraSalida());
            return repo.save(registro);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

public class RegistoHorasController {
}

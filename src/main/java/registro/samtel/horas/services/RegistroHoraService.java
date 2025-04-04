package registro.samtel.horas.services;

@Service
public class RegistroHoraService {
    @Autowired
    private RegistroHoraRepository repository;

    public List<RegistroHora> listar() {
        return repository.findAll();
    }

    public RegistroHora guardar(RegistroHora registro) {
        return repository.save(registro);
    }

    public Optional<RegistroHora> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

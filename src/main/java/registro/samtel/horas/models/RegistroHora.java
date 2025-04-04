package registro.samtel.horas.models;

    @Entity
    public class RegistroHora {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombreEmpleado;
        private LocalDate fecha;
        private LocalTime horaEntrada;
        private LocalTime horaSalida;


    }



    package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

    @Data
    @Table(name = "registro")
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class RegistroEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false)
        private String fecha;

        @Column(nullable = false)
        private String horaEntrada;


        @Column(nullable = true)
        private String horaSalida;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private UsuarioEntity usuario;

    }
    @Table(name = "registro de horas")
    class  RegistroEntity1{
        private Long id;
        private String usuario;
        private Date fecha;
        private Time horaEntrada;
        private Time horaSalida;
}

package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Table(name = "registro")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegistroHorasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaDeRegistro;

    @Column(nullable = false)
    private String horaEntrada;

    @Column(nullable = true)
    private String horaSalida;

    @Column(nullable = false)
    private Boolean estadoRegistro;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

}

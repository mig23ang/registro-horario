package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

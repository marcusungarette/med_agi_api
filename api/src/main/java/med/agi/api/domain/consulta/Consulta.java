package med.agi.api.domain.consulta;


import jakarta.persistence.*;
import lombok.*;
import med.agi.api.domain.consulta.cancelamento.MotivoCancelamento;
import med.agi.api.domain.medico.Medico;
import med.agi.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

@Data
@Builder
@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    private Boolean ativo;



    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", medicoId=" + (medico != null ? medico.getId() : null) +
                ", pacienteId=" + (paciente != null ? paciente.getId() : null) +
                ", data=" + data +
                '}';
    }


    public void cancelar(MotivoCancelamento motivo) {
        this.ativo = false;
    }
}

package med.agi.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.agi.api.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank //only for Strings
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // Between 4 and 6 digits
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid //Valida se o outro DTO esta Ok
        DadosEndereco endereco) {
}

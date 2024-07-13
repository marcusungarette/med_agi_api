package med.agi.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    private String atualizarCampo(String campoAtual, String novoCampo) {
        return novoCampo != null ? novoCampo : campoAtual;
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        this.logradouro = atualizarCampo(this.logradouro, dados.logradouro());
        this.bairro = atualizarCampo(this.bairro, dados.bairro());
        this.cep = atualizarCampo(this.cep, dados.cep());
        this.uf = atualizarCampo(this.uf, dados.uf());
        this.cidade = atualizarCampo(this.cidade, dados.cidade());
        this.numero = atualizarCampo(this.numero, dados.numero());
        this.complemento = atualizarCampo(this.complemento, dados.complemento());
    }
}

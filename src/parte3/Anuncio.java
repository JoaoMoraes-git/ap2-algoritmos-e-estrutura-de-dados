package parte3;

import java.util.UUID;

public class Anuncio {
    private UUID id;
    private String empresa;
    private String descricao;

    public Anuncio(UUID id, String empresa, String descricao) {
        this.id = id;
        this.empresa = empresa;
        this.descricao = descricao;
    }

    public Anuncio() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "[Anuncio] ID: " + this.id + " / " + "Empresa: " + this.empresa + " / " + "Descrição: " + descricao;
    }
}

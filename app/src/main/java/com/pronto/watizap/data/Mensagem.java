package com.pronto.watizap.data;

import java.io.Serializable;
import java.util.Objects;

public class Mensagem implements Serializable {

    private int id;
    private String textoMensagem;
    private String dataMensagem;

    public Mensagem() {
    }

    public Mensagem(int id, String textoMensagem, String dataMensagem) {
        this.id = id;
        this.textoMensagem = textoMensagem;
        this.dataMensagem = dataMensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextoMensagem() {
        return textoMensagem;
    }

    public void setTextoMensagem(String textoMensagem) {
        this.textoMensagem = textoMensagem;
    }

    public String getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(String dataMensagem) {
        this.dataMensagem = dataMensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem = (Mensagem) o;
        return id == mensagem.id &&
                Objects.equals(textoMensagem, mensagem.textoMensagem) &&
                Objects.equals(dataMensagem, mensagem.dataMensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textoMensagem, dataMensagem);
    }
}

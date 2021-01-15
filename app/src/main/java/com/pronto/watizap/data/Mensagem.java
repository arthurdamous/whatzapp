package com.pronto.watizap.data;

import java.io.Serializable;
import java.util.Objects;

public class Mensagem implements Serializable {

    private int id;
    private String textoMensagem;
    private String dataMensagem;
    private boolean isMine;

    public Mensagem() {
    }

    public Mensagem(int id, String textoMensagem, String dataMensagem, boolean isMine) {
        this.id = id;
        this.textoMensagem = textoMensagem;
        this.dataMensagem = dataMensagem;
        this.isMine = isMine;
    }

    public int getId() {
        return id;
    }

    public String getTextoMensagem() {
        return textoMensagem;
    }

    public String getDataMensagem() {
        return dataMensagem;
    }

    public boolean isMine() {
        return isMine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem = (Mensagem) o;
        return id == mensagem.id &&
                isMine == mensagem.isMine &&
                Objects.equals(textoMensagem, mensagem.textoMensagem) &&
                Objects.equals(dataMensagem, mensagem.dataMensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textoMensagem, dataMensagem, isMine);
    }
}

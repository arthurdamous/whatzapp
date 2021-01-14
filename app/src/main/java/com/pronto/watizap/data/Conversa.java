package com.pronto.watizap.data;

import java.io.Serializable;
import java.util.Objects;

public class Conversa implements Serializable {

    private int id;
    private int caminhoImagem;
    private String nomeUsuario;
    private String ultimaMensagem;
    private String dataUltimaMensagem;

    public Conversa() {
    }

    public Conversa(int id, int caminhoImagem, String nomeUsuario, String ultimaMensagem, String dataUltimaMensagem) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
        this.nomeUsuario = nomeUsuario;
        this.ultimaMensagem = ultimaMensagem;
        this.dataUltimaMensagem = dataUltimaMensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(int caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getDataUltimaMensagem() {
        return dataUltimaMensagem;
    }

    public void setDataUltimaMensagem(String dataUltimaMensagem) {
        this.dataUltimaMensagem = dataUltimaMensagem;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    public void setUltimaMensagem(String ultimaMensagem) {
        this.ultimaMensagem = ultimaMensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversa conversa = (Conversa) o;
        return id == conversa.id &&
                caminhoImagem == conversa.caminhoImagem &&
                Objects.equals(nomeUsuario, conversa.nomeUsuario) &&
                Objects.equals(ultimaMensagem, conversa.ultimaMensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caminhoImagem, nomeUsuario, ultimaMensagem);
    }
}

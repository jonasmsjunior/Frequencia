package software.ifto.frequencia.model;

import java.util.Date;
import java.util.List;

/**
 * Created by jonas on 12/12/2016.
 */

public class Processo {
    private Integer numeroProcesso;
    private Date dataCriacao;
    private String juiz;
    private String comarca;
    private String tipoProcesso;

    private List<Parte> Partes;
    private List<Eventos> eventos;

    public Integer getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(Integer numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getJuiz() {
        return juiz;
    }

    public void setJuiz(String juiz) {
        this.juiz = juiz;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public List<Parte> getPartes() {
        return Partes;
    }

    public void setPartes(List<Parte> Partes) {
        this.Partes = Partes;
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }
}

package software.ifto.frequencia.model;


import java.io.Serializable;

public class Aluno implements Serializable {
    private Integer id;
    private String nome;
    private String matricula;
    private Integer idTurma;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public String toString() {
        return getMatricula() + " - " + getNome();
    }
}

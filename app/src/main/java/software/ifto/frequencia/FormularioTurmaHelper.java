package software.ifto.frequencia;

import android.widget.EditText;
import android.widget.Toast;


import java.util.Date;

import software.ifto.frequencia.model.Turma;

/**
 * Created by administrado on 17/11/2016.
 */

public class FormularioTurmaHelper {
    private EditText campoDescricao;
    private Date campoDataCriacao;
    private Date campoDataAlteracao;

    private Turma turma;

    public FormularioTurmaHelper (FormularioTurmaActivity activity)  {
        campoDescricao      = (EditText) activity.findViewById(R.id.descricao);
        campoDataAlteracao  = new Date();
        campoDataCriacao    = new Date();

        campoDataAlteracao = new Date();

        turma = new Turma();
    }

    public Turma pegaTurma(){

        turma.setDescricao(campoDescricao.getText().toString());
        turma.setDataAlteracao(campoDataAlteracao);
        turma.setDataCriacao(campoDataCriacao);

        return turma;
    }

    public void preencheFormulario(Turma turma) {
        campoDescricao.setText(turma.getDescricao());
        this.turma = turma;
    }
}

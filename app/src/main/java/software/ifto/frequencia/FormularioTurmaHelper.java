package software.ifto.frequencia;

import android.widget.EditText;


import java.util.Date;

import software.ifto.frequencia.model.Turma;

/**
 * Created by administrado on 17/11/2016.
 */

public class FormularioTurmaHelper {
    private EditText campoDescricao;
    private Date campoDataCriacao;
    private Date campoDataAlteracao;

    public FormularioTurmaHelper (FormularioTurmaActivity activity)  {
        campoDescricao      = (EditText) activity.findViewById(R.id.descricao);
        campoDataAlteracao  = new Date();
        campoDataCriacao    = new Date();
    }

    public Turma pegaTurma(){
        Turma turma = new Turma();
        turma.setDescricao(campoDescricao.getText().toString());
        turma.setDataAlteracao(campoDataAlteracao);
        turma.setDataCriacao(campoDataCriacao);

        return turma;
    }
}

package software.ifto.frequencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import software.ifto.frequencia.model.Turma;

public class ListaAlunosActivity extends AppCompatActivity {
    private Turma turma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        Intent intente = getIntent();
        turma = (Turma) intente.getSerializableExtra("turma");
        turma.getId();
    }
}

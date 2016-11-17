package software.ifto.frequencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import software.ifto.frequencia.DAO.TurmaDao;
import software.ifto.frequencia.model.Turma;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregalista();


        Button novaTurma = (Button) findViewById(R.id.btn_add_turma);

        novaTurma.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentGoFormularioTurma = new Intent(MainActivity.this, FormularioTurmaActivity.class);
                        startActivity(intentGoFormularioTurma);
                    }
                }
        );
    }

    private void carregalista(){
        TurmaDao dao = new TurmaDao(this);
        List<Turma> turmas = dao.busca(); dao.close();

        ListView listaTurma = (ListView) findViewById(R.id.lista_turmas);
        ArrayAdapter<Turma> adpter =  new ArrayAdapter<Turma>(this,android.R.layout.simple_list_item_1 ,turmas);
        listaTurma.setAdapter(adpter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregalista();
    }
}

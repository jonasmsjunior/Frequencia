package software.ifto.frequencia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import software.ifto.frequencia.DAO.TurmaDao;
import software.ifto.frequencia.model.Turma;


public class FormularioTurmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_turma);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_fomulario_turma, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FormularioTurmaHelper helper = new FormularioTurmaHelper(this);
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Turma turma = helper.pegaTurma();

                TurmaDao dao = new TurmaDao(this);
                dao.insere(turma);
                dao.close();

                Toast.makeText(FormularioTurmaActivity.this, "Turma "+turma.getDescricao()+" adicionada!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

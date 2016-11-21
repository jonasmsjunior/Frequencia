package software.ifto.frequencia.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import software.ifto.frequencia.model.Turma;

/**
 * Created by administrado on 17/11/2016.
 */

public class TurmaDao extends SQLiteOpenHelper {
    public TurmaDao(Context context) {
        super(context, "Frequencia", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Turmas (id INTEGER PRIMARY KEY, descricao TEXT NOT NULL, data_criacao DATETIME NOT NULL, data_alteracao DATETIME NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Turmas";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Turma turma){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("descricao", turma.getDescricao());
        dados.put("data_alteracao", turma.getDataAlteracao().toString());
        dados.put("data_criacao", turma.getDataCriacao().toString());
        db.insert("Turmas",null,dados);
    }

    public List<Turma> busca(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM Turmas;";
        Cursor c = db.rawQuery(sql, null);

        List<Turma> turmas = new ArrayList<Turma>();
        while (c.moveToNext()) {
            Turma turma = new Turma();
            turma.setId(c.getInt(c.getColumnIndex("id")));
            turma.setDescricao(c.getString(c.getColumnIndex("descricao")));

            turmas.add(turma);
        }
        c.close();
        return turmas;
    }

    public void deleta(Turma turma) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {turma.getId().toString()};
        db.delete("Turmas", "id = ?", params);
    }
}

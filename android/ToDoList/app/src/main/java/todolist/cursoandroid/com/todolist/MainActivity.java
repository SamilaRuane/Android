package todolist.cursoandroid.com.todolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button botaoAdicionar;
    private EditText textoTarefa;
    private ListView listaTarefas;
    private SQLiteDatabase bancoDeDados;
    private ArrayAdapter<String> itensAdaptador;
    private ArrayList <String> itens;
    private ArrayList<Integer> ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    try {
        botaoAdicionar = (Button) findViewById(R.id.botaoAdicionarID);
        textoTarefa = (EditText) findViewById(R.id.caixaTextoID);
        listaTarefas = (ListView) findViewById(R.id.listViewID);


        // Banco de dados
        bancoDeDados = openOrCreateDatabase("appTarefas", MODE_PRIVATE, null);

        //Criar Tabela de Tarefas
        bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDigitado = textoTarefa.getText().toString();
                salvarTarefa(textoDigitado);

            }
        });

        listaTarefas.setLongClickable(true);

        listaTarefas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                removerTarefa(ids.get( i ));
                return true;
            }
        });

        recuperarTarefas();

    }catch (Exception e){
        e.printStackTrace();
    }
    }

    private void salvarTarefa (String textoDigitado){
        try {

            if (textoDigitado.equals("")) {
                Toast.makeText(MainActivity.this, "Digite Uma Tarefa", Toast.LENGTH_SHORT).show();
            }else {
                bancoDeDados.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + textoDigitado + "')");
                Toast.makeText(MainActivity.this, "Tarefa Salva com Sucesso!!!", Toast.LENGTH_SHORT).show();
                recuperarTarefas();
                textoTarefa.setText("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        }

    private void recuperarTarefas (){

        try{

        //Recupera as Tarefas
        Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);

        //Recupera ids das colunas
        int indiceColunaId = cursor.getColumnIndex("id");
        int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();

            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_2, android.R.id.text2, itens);
            listaTarefas.setAdapter( itensAdaptador );
        //Listar Tarefas
        cursor.moveToFirst();
        while (cursor != null) {

            Log.i("Resultado - ","Tarefa: " + cursor.getString(indiceColunaTarefa));
            itens.add(cursor.getString(indiceColunaTarefa));
            ids.add( Integer.parseInt( cursor.getString(indiceColunaId)));

            cursor.moveToNext();
        }

    }catch (Exception e){
        e.printStackTrace();
        }
    }

    private void removerTarefa (Integer id){
        try{
            bancoDeDados.execSQL("DELETE FROM tarefas WHERE id=" + id);
            recuperarTarefas();
            Toast.makeText(MainActivity.this, "Tarefa Removida com Sucesso", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

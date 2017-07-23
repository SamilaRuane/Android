package signos.cursoandroid.com.signos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaDeSignos;
    private String [] signos = {"Áries","Touro", "Gêmeos", "Câncer", "Virgem", "Libra",
            "Escorpião", "Sagitário", "Capricórnio", "Áquario", "Peixes"};

    private String [] perfis = {"Áries","Touro", "Gêmeos", "Câncer", "Virgem", "Libra",
        "Escorpião", "Sagitário", "Capricórnio", "Áquario", "Peixes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeSignos = (ListView) findViewById(R.id.listViewID);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, signos);
        listaDeSignos.setAdapter(adaptador);

        listaDeSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosition = i;
                Toast.makeText(getApplicationContext(), perfis[codigoPosition], Toast.LENGTH_SHORT).show();

            }
        });
    }
}

package atmempresaconsultoria.cursoandroid.com.atmempresaconsultoria;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView botaoEmpresa;
    private ImageView botaoServico;
    private ImageView botaoCliente;
    private ImageView botaoContato;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEmpresa = (ImageView) findViewById(R.id.empresaID);
        botaoCliente = (ImageView) findViewById(R.id.clientesID);
        botaoServico = (ImageView) findViewById(R.id.servicoID);
        botaoContato = (ImageView) findViewById(R.id.contatoID);

        botaoEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EmpresaActivity.class));
            }
        });

        botaoServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ServicoActivity.class));

            }
        });

        botaoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ServicoActivity.class));
            }
        });

        botaoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContatoActivity.class));
            }
        });
    }

}

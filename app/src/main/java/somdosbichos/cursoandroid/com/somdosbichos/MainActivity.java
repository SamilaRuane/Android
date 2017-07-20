package somdosbichos.cursoandroid.com.somdosbichos;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView dog;
    private ImageView cat;
    private ImageView cow;
    private ImageView sheep;
    private ImageView monkey;
    private ImageView lion;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dog = (ImageView) findViewById(R.id.caoID);
        cat = (ImageView) findViewById(R.id.gatoID);
        cow = (ImageView) findViewById(R.id.vacaID);
        sheep = (ImageView) findViewById(R.id.ovelhaID);
        monkey = (ImageView) findViewById(R.id.macacoID);
        lion = (ImageView) findViewById(R.id.leaoID);

        dog.setOnClickListener(this);
        cat.setOnClickListener(this);
        cow.setOnClickListener(this);
        sheep.setOnClickListener(this);
        monkey.setOnClickListener(this);
        lion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.caoID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                tocarSom();
                break;
            case R.id.gatoID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                tocarSom();
                break;
            case R.id.leaoID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                tocarSom();
                break;
            case R.id.macacoID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                tocarSom();
                break;
            case R.id.ovelhaID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                tocarSom();
                break;
            case R.id.vacaID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                tocarSom();
                break;
        }
    }

    public void tocarSom (){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy (){
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}

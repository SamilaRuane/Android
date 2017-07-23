package somdosbichos.cursoandroid.com.somdosbichos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    ViewHolder mViewHolder = new ViewHolder();
    Bichos bichos = new BichosImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder.dog = (ImageView) findViewById(R.id.caoID);
        mViewHolder.cat = (ImageView) findViewById(R.id.gatoID);
        mViewHolder.cow = (ImageView) findViewById(R.id.vacaID);
        mViewHolder.sheep = (ImageView) findViewById(R.id.ovelhaID);
        mViewHolder.monkey = (ImageView) findViewById(R.id.macacoID);
        mViewHolder.lion = (ImageView) findViewById(R.id.leaoID);

        mViewHolder.dog.setOnClickListener(this);
        mViewHolder.cat.setOnClickListener(this);
        mViewHolder.cow.setOnClickListener(this);
        mViewHolder.sheep.setOnClickListener(this);
        mViewHolder.monkey.setOnClickListener(this);
        mViewHolder.lion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.caoID:
                mViewHolder.mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                bichos.tocarSom(mViewHolder.mediaPlayer);
                break;
            case R.id.gatoID:
                mViewHolder.mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                bichos.tocarSom(mViewHolder.mediaPlayer);
                break;
            case R.id.leaoID:
                mViewHolder.mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                bichos.tocarSom(mViewHolder.mediaPlayer);
                break;
            case R.id.macacoID:
                mViewHolder.mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                bichos.tocarSom(mViewHolder.mediaPlayer);
                break;
            case R.id.ovelhaID:
                mViewHolder.mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                bichos.tocarSom(mViewHolder.mediaPlayer);
                break;
            case R.id.vacaID:
                mViewHolder.mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                bichos.tocarSom(mViewHolder.mediaPlayer);
                break;
        }
    }

    @Override
    protected void onDestroy (){
        if(mViewHolder.mediaPlayer != null) {
            mViewHolder.mediaPlayer.release();
            mViewHolder.mediaPlayer = null;
        }
        super.onDestroy();
    }

    private class ViewHolder {
        ImageView dog;
        ImageView cat;
        ImageView cow;
        ImageView sheep;
        ImageView monkey;
        ImageView lion;
        MediaPlayer mediaPlayer;
    }
}

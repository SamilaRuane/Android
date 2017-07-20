package somdosbichos.cursoandroid.com.somdosbichos;

import android.media.MediaPlayer;

public class BichosImpl implements Bichos {

    @Override
    public void tocarSom(MediaPlayer media) {
        if (media != null) {
            media.start();
        }
    }
}

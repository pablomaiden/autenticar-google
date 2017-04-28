package autenticar.com.br.aulaautenticar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.InputStream;

public class ImageTask extends AsyncTask<String, Void,Bitmap> {

    ImageView fotoPerfil;

    public ImageTask(ImageView image){
        this.fotoPerfil=image;
    }

    @Override
    protected Bitmap doInBackground(String... url) {
        String urlImage = url[0];
        Bitmap bitMapImage = null;
        try{
            InputStream in = new java.net.URL(urlImage).openStream();
            bitMapImage = BitmapFactory.decodeStream(in);

        }catch(Exception ex){

        }
        return bitMapImage;
    }

    protected void onPostExecute(Bitmap image){
        fotoPerfil.setImageBitmap(image);
    }
}

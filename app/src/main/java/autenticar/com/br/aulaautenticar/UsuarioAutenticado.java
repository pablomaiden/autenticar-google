package autenticar.com.br.aulaautenticar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class UsuarioAutenticado extends ActionBarActivity {

    private TextView tv_nome;
    private TextView tv_email;
    private ImageView iv_foto;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.usuario_autenticado);

        tv_nome  =(TextView) findViewById(R.id.tv_nome);
        tv_email =(TextView) findViewById(R.id.tv_email);
        iv_foto  =(ImageView) findViewById(R.id.iv_foto);

        Bundle extra = getIntent().getExtras();
        if(extra!=null){
            String nome  = extra.getString("nome");
            String email = extra.getString("email");
            String foto  = extra.getString("foto");

            tv_nome.setText(nome);
            tv_email.setText(email);
            new ImageTask((ImageView) findViewById(R.id.iv_foto)).execute(foto);
        }
    }

    public void desconectarUsuario(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}

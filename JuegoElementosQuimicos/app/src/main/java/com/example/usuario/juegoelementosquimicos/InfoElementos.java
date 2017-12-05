package com.example.usuario.juegoelementosquimicos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoElementos extends ActionBarActivity {

    private ImageView imvInfo;
    private int iNumImagenInfo;
    private String strUrlWikipedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_elementos);

        TextView txvWikipedia = (TextView)findViewById(R.id.txvWikipedia);

        imvInfo = (ImageView)findViewById(R.id.imgInfoElemento);

        Bundle bndDatos = this.getIntent().getExtras();
        iNumImagenInfo = bndDatos.getInt("INFO");

        switch( iNumImagenInfo ) {
            case JuegoElementos.HIDROGENO:
                imvInfo.setImageResource(R.drawable.hidrogeno_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Hidr%C3%B3geno";
                break;
            case JuegoElementos.LITIO:
                imvInfo.setImageResource(R.drawable.litio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Litio";
                break;
            case JuegoElementos.BERILIO:
                imvInfo.setImageResource(R.drawable.berilio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Berilio";
                break;
            case JuegoElementos.SODIO:
                imvInfo.setImageResource(R.drawable.sodio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Sodio";
                break;
            case JuegoElementos.MAGNESIO:
                imvInfo.setImageResource(R.drawable.magnesio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Magnesio";
                break;
            case JuegoElementos.POTASIO:
                imvInfo.setImageResource(R.drawable.potasio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Potasio";
                break;
            case JuegoElementos.CALCIO:
                imvInfo.setImageResource(R.drawable.calcio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Calcio";
                break;
            case JuegoElementos.RUBIDIO:
                imvInfo.setImageResource(R.drawable.rubidio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Rubidio";
                break;
            case JuegoElementos.ESTRONCIO:
                imvInfo.setImageResource(R.drawable.estroncio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Estroncio";
                break;
            case JuegoElementos.CESIO:
                imvInfo.setImageResource(R.drawable.cesio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Cesio";
                break;
            case JuegoElementos.BARIO:
                imvInfo.setImageResource(R.drawable.bario_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Bario";
                break;
            case JuegoElementos.FRANCIO:
                imvInfo.setImageResource(R.drawable.francio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Francio";
                break;
            case JuegoElementos.RADIO:
                imvInfo.setImageResource(R.drawable.radio_info_grande);
                strUrlWikipedia = "http://es.wikipedia.org/wiki/Radio";
                break;
        }

        txvWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMiNavegador = new Intent(InfoElementos.this,
                    MiNavegador.class);
                //intMiNavegador.addCategory("OtherApps");
                //intMiNavegador.addCategory("SomeOtherApps");
                Bundle bndDatos = new Bundle();
                bndDatos.putString("URL", strUrlWikipedia);
                intMiNavegador.putExtras(bndDatos);
                startActivity(intMiNavegador);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.info_elementos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

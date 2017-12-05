package com.example.usuario.juegoelementosquimicos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.graphics.Color;


public class JuegoElementos extends ActionBarActivity  {

    static final int HIDROGENO = 1;
    static final int LITIO = 3;
    static final int BERILIO = 4;
    static final int SODIO = 11;
    static final int MAGNESIO = 12;
    static final int POTASIO = 19;
    static final int CALCIO = 20;
    static final int RUBIDIO = 37;
    static final int ESTRONCIO = 38;
    static final int CESIO = 55;
    static final int BARIO = 56;
    static final int FRANCIO = 87;
    static final int RADIO = 88;

    private int iRandomNum;
    private int[] iElementos = { HIDROGENO, LITIO, BERILIO, SODIO, MAGNESIO, POTASIO,
        CALCIO, RUBIDIO, ESTRONCIO, CESIO, BARIO, FRANCIO, RADIO };
    private String[] iElementosNombres = { "Hidrogeno", "Litio", "Berilio", "Sodio",
        "Magnesio", "Potasio", "Calcio", "Rubidio", "Estroncio", "Cesio", "Bario",
        "Francio", "Radio" };


    private String generarElementoRandom() {

        String strElemento = "";

        iRandomNum = (int)(Math.random() * 13);  // El juego selecciona un elemento aleatoriamente
        // Según el número aleatorio generado elegimos un elemento o otro, consiguiendo así
        // un elemento aleatorio

        switch (iRandomNum) {
            case 0: strElemento = "H"; break;
            case 1: strElemento = "Li"; break;
            case 2: strElemento = "Be"; break;
            case 3: strElemento = "Na"; break;
            case 4: strElemento = "Mg"; break;
            case 5: strElemento = "K"; break;
            case 6: strElemento = "Ca"; break;
            case 7: strElemento = "Rb"; break;
            case 8: strElemento = "Sr"; break;
            case 9: strElemento = "Cs"; break;
            case 10: strElemento = "Ba"; break;
            case 11: strElemento = "Fr"; break;
            case 12: strElemento = "Ra"; break;
        }

        return strElemento;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_elementos);

        final ImageButton btnHidrogeno = (ImageButton)findViewById(R.id.btnHidrogeno);
        final ImageButton btnBario = (ImageButton)findViewById(R.id.btnBario);
        final ImageButton btnBerilio = (ImageButton)findViewById(R.id.btnBerilio);
        final ImageButton btnCalcio = (ImageButton)findViewById(R.id.btnCalcio);
        final ImageButton btnCesio = (ImageButton)findViewById(R.id.btnCesio);
        final ImageButton btnEstroncio = (ImageButton)findViewById(R.id.btnEstroncio);
        final ImageButton btnLitio = (ImageButton)findViewById(R.id.btnLitio);
        final ImageButton btnMagnesio = (ImageButton)findViewById(R.id.btnMagnesio);
        final ImageButton btnPotasio = (ImageButton)findViewById(R.id.btnPotasio);
        final ImageButton btnRubidio = (ImageButton)findViewById(R.id.btnRubidio);
        final ImageButton btnSodio = (ImageButton)findViewById(R.id.btnSodio);
        final ImageButton btnFrancio = (ImageButton)findViewById(R.id.btnFrancio);
        final ImageButton btnRadio = (ImageButton)findViewById(R.id.btnRadio);

        final TextView txvPregunta = (TextView)findViewById(R.id.txvPregunta);
        final TextView txvNumero = (TextView)findViewById(R.id.txvNumero);
        final TextView txvNumeroOk = (TextView)findViewById(R.id.txvNumeroOk);
        final TextView txvNombre = (TextView)findViewById(R.id.txvNombre);
        final TextView txvNombreOk = (TextView)findViewById(R.id.txvNombreOk);
        final EditText edtNombre = (EditText)findViewById(R.id.edtNombre);
        final EditText edtNumero = (EditText)findViewById(R.id.edtNumero);

        final Button btnJugar = (Button)findViewById(R.id.btnJugar);
        final Button btnComprobar = (Button)findViewById(R.id.btnComprobar);
        final Button btnFinalizar = (Button)findViewById(R.id.btnFinalizar);
        final Button btnJugarOtra = (Button)findViewById(R.id.btnJugarOtra);

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strElemento;  // Elemento a adivinar

                btnJugar.setEnabled(false);
                btnHidrogeno.setImageResource(R.drawable.interrogante);
                btnBario.setImageResource(R.drawable.interrogante);
                btnBerilio.setImageResource(R.drawable.interrogante);
                btnCalcio.setImageResource(R.drawable.interrogante);
                btnCesio.setImageResource(R.drawable.interrogante);
                btnEstroncio.setImageResource(R.drawable.interrogante);
                btnFrancio.setImageResource(R.drawable.interrogante);
                btnLitio.setImageResource(R.drawable.interrogante);
                btnMagnesio.setImageResource(R.drawable.interrogante);
                btnPotasio.setImageResource(R.drawable.interrogante);
                btnRadio.setImageResource(R.drawable.interrogante);
                btnRubidio.setImageResource(R.drawable.interrogante);
                btnSodio.setImageResource(R.drawable.interrogante);

                strElemento = generarElementoRandom();

                txvPregunta.setText("¿Cuál es el número atómico del elemento '" + strElemento + "' y cuál es su nombre?");
                txvPregunta.setVisibility(View.VISIBLE);
                txvNumero.setVisibility((view.VISIBLE));
                edtNumero.setVisibility(view.VISIBLE);
                txvNumeroOk.setVisibility((view.VISIBLE));
                txvNombre.setVisibility((view.VISIBLE));
                edtNombre.setVisibility(view.VISIBLE);
                txvNombreOk.setVisibility((view.VISIBLE));
                btnComprobar.setVisibility(view.VISIBLE);
                btnJugarOtra.setVisibility(view.VISIBLE);
                btnFinalizar.setVisibility(view.VISIBLE);

            }

        });

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int aciertos = 0;

                if( edtNumero.getText().toString().equals(Integer.toString(iElementos[iRandomNum])) ) {
                    txvNumeroOk.setTextColor(Color.GREEN);
                    txvNumeroOk.setText("Bien!");
                    aciertos++;
                }
                else {
                    txvNumeroOk.setTextColor(Color.RED);
                    txvNumeroOk.setText("Mal");
                }

                if( edtNombre.getText().toString().toLowerCase().equals(iElementosNombres[iRandomNum].toLowerCase()) ) {
                    txvNombreOk.setTextColor(Color.GREEN);
                    txvNombreOk.setText("Bien!");
                    aciertos++;
                }
                else {
                    txvNombreOk.setTextColor(Color.RED);
                    txvNombreOk.setText("Mal");
                }

                if( aciertos == 2 ) {
                    switch( iRandomNum ) {
                        case 0: btnHidrogeno.setImageResource(R.drawable.hidrogeno); break;
                        case 1: btnLitio.setImageResource(R.drawable.litio); break;
                        case 2: btnBerilio.setImageResource(R.drawable.berilio); break;
                        case 3: btnSodio.setImageResource(R.drawable.sodio); break;
                        case 4: btnMagnesio.setImageResource(R.drawable.magnesio); break;
                        case 5: btnPotasio.setImageResource(R.drawable.potasio); break;
                        case 6: btnCalcio.setImageResource(R.drawable.calcio); break;
                        case 7: btnRubidio.setImageResource(R.drawable.rubidio); break;
                        case 8: btnEstroncio.setImageResource(R.drawable.estroncio); break;
                        case 9: btnCesio.setImageResource(R.drawable.cesio); break;
                        case 10: btnBario.setImageResource(R.drawable.bario); break;
                        case 11: btnFrancio.setImageResource(R.drawable.francio); break;
                        case 12: btnRadio.setImageResource(R.drawable.radio); break;
                    }
                }

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txvPregunta.setVisibility(View.INVISIBLE);
                txvNumero.setVisibility((view.INVISIBLE));
                edtNumero.setVisibility(view.INVISIBLE);
                txvNumeroOk.setVisibility((view.INVISIBLE));
                txvNombre.setVisibility((view.INVISIBLE));
                edtNombre.setVisibility(view.INVISIBLE);
                txvNombreOk.setVisibility((view.INVISIBLE));
                btnComprobar.setVisibility(view.INVISIBLE);
                btnFinalizar.setVisibility(view.INVISIBLE);
                btnJugarOtra.setVisibility(view.INVISIBLE);

                edtNumero.setText("");
                edtNombre.setText("");

                btnJugar.setEnabled(true);

                btnHidrogeno.setImageResource(R.drawable.hidrogeno);
                btnBario.setImageResource(R.drawable.bario);
                btnBerilio.setImageResource(R.drawable.berilio);
                btnCalcio.setImageResource(R.drawable.calcio);
                btnCesio.setImageResource(R.drawable.cesio);
                btnEstroncio.setImageResource(R.drawable.estroncio);
                btnFrancio.setImageResource(R.drawable.francio);
                btnLitio.setImageResource(R.drawable.litio);
                btnMagnesio.setImageResource(R.drawable.magnesio);
                btnPotasio.setImageResource(R.drawable.potasio);
                btnRadio.setImageResource(R.drawable.radio);
                btnRubidio.setImageResource(R.drawable.rubidio);
                btnSodio.setImageResource(R.drawable.sodio);

            }
        });

        btnJugarOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strElemento;

                switch( iRandomNum ) {
                    case 0: btnHidrogeno.setImageResource(R.drawable.interrogante); break;
                    case 1: btnLitio.setImageResource(R.drawable.interrogante); break;
                    case 2: btnBerilio.setImageResource(R.drawable.interrogante); break;
                    case 3: btnSodio.setImageResource(R.drawable.interrogante); break;
                    case 4: btnMagnesio.setImageResource(R.drawable.interrogante); break;
                    case 5: btnPotasio.setImageResource(R.drawable.interrogante); break;
                    case 6: btnCalcio.setImageResource(R.drawable.interrogante); break;
                    case 7: btnRubidio.setImageResource(R.drawable.interrogante); break;
                    case 8: btnEstroncio.setImageResource(R.drawable.interrogante); break;
                    case 9: btnCesio.setImageResource(R.drawable.interrogante); break;
                    case 10: btnBario.setImageResource(R.drawable.interrogante); break;
                    case 11: btnFrancio.setImageResource(R.drawable.interrogante); break;
                    case 12: btnRadio.setImageResource(R.drawable.interrogante); break;
                }

                strElemento = generarElementoRandom();
                txvPregunta.setText("¿Cuál es el número atómico del elemento " + strElemento + " y cuál es su nombre?");
                edtNombre.setText("");
                txvNombreOk.setText("");
                edtNumero.setText("");
                txvNumeroOk.setText("");

            }
        });

        btnHidrogeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intInfoElementos = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", HIDROGENO);
                intInfoElementos.putExtras(bndDatos);
                startActivity(intInfoElementos);
            }
        });

        btnLitio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", LITIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnBerilio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", BERILIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnSodio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", SODIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnMagnesio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", MAGNESIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnPotasio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", POTASIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnCalcio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", CALCIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnRubidio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", RUBIDIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnEstroncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", ESTRONCIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnCesio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", CESIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnBario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", BARIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnFrancio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", FRANCIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(JuegoElementos.this, InfoElementos.class);
                Bundle bndDatos = new Bundle();
                bndDatos.putInt("INFO", RADIO);
                intencion.putExtras(bndDatos);
                startActivity(intencion);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.juego_elementos, menu);
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

package com.udistrital.quienquieresermillonario;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ContentView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.udistrital.quienquieresermillonario.dominio.Pregunta;
import com.udistrital.quienquieresermillonario.dominio.Respuesta;
import com.udistrital.quienquieresermillonario.services.QuienQuiereSerMillonario;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView enunciadoPregunta;
    private TextView respuestaA;
    private TextView respuestaB;
    private TextView respuestaC;
    private TextView respuestaD;
    private TextView puntuacion;
    private TextView nivel;
    private TextView contexto;
    private Button button;
    private Dialog dialog;
    private String info;
    private TextView infoTextView;
    private Button buttonReset;
    private Pregunta pregunta = null;
    private TextView publico;

    private QuienQuiereSerMillonario juego;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.juego = new QuienQuiereSerMillonario();

        this.enunciadoPregunta = findViewById(R.id.textViewPregunta);
        this.respuestaA = findViewById(R.id.textViewRespuestaA);
        this.respuestaB = findViewById(R.id.textViewRespuestaB);
        this.respuestaC = findViewById(R.id.textViewRespuestaC);
        this.respuestaD = findViewById(R.id.textViewRespuestaD);
        this.puntuacion = findViewById(R.id.textViewPuntuacion);
        this.nivel = findViewById(R.id.textViewNivel);
        this.contexto = findViewById(R.id.textViewContexto);
        this.publico = findViewById(R.id.textViewPublico);
        info = "Iniciar juego";
        menu();
        establecerPregunta();

        this.buttonReset = findViewById(R.id.buttonReset);

        this.buttonReset.setOnClickListener(e -> {
            this.info = "Juego reiniciado";
            menu();
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void establecerPregunta() {

        this.respuestaA.setBackgroundColor(Color.WHITE);
        this.respuestaB.setBackgroundColor(Color.WHITE);
        this.respuestaC.setBackgroundColor(Color.WHITE);
        this.respuestaD.setBackgroundColor(Color.WHITE);



        try {
            pregunta = this.juego.obtenerPreguntaAleatoria();

            this.contexto.setText("Responde esta pregunta, y te asegura el premio de  " + this.juego.getPremio());
            this.enunciadoPregunta.setText(pregunta.getEnunciado());
            List<Respuesta> listaRespuesta = pregunta.obtenerRespuestasAleatoriamente();
            this.respuestaA.setText("a. " + listaRespuesta.get(0).getRespuesta());
            this.respuestaB.setText("b. " + listaRespuesta.get(1).getRespuesta());
            this.respuestaC.setText("c. " + listaRespuesta.get(2).getRespuesta());
            this.respuestaD.setText("d. " + listaRespuesta.get(3).getRespuesta());
            this.puntuacion.setText("Puntuacion : " + this.juego.getPuntuacion());
            this.nivel.setText("Nivel: " + this.juego.getNivel());


            Context context = getApplicationContext();
            CharSequence text = "Respuesta correcta";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);


            this.respuestaA.setOnClickListener(e -> {
                if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(0))) {
                    this.respuestaA.setBackgroundColor(Color.GREEN);

                    establecerPregunta();
                    toast.show();

                } else {
                    this.info = "Juego terminado";
                    this.menu();
                    this.respuestaA.setBackgroundColor(Color.RED);
                    establecerPregunta();
                }
            });


            this.respuestaB.setOnClickListener(e -> {
                if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(1))) {
                    this.respuestaB.setBackgroundColor(Color.GREEN);
                    establecerPregunta();
                    toast.show();
                } else {
                    this.info = "Juego terminado";
                    this.menu();
                    this.respuestaB.setBackgroundColor(Color.RED);
                    establecerPregunta();
                }
            });

            this.respuestaC.setOnClickListener(e -> {
                if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(2))) {
                    this.respuestaC.setBackgroundColor(Color.GREEN);

                    establecerPregunta();
                    toast.show();

                } else {
                    this.info = "Juego terminado";
                    this.menu();
                    this.respuestaC.setBackgroundColor(Color.RED);
                    establecerPregunta();
                }
            });

            this.respuestaD.setOnClickListener(e -> {
                if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(3))) {
                    this.respuestaD.setBackgroundColor(Color.GREEN);

                    establecerPregunta();

                    toast.show();
                } else {
                    this.info = "Juego terminado";
                    this.menu();
                    this.respuestaD.setBackgroundColor(Color.RED);
                    establecerPregunta();
                }
            });

            this.publico.setOnClickListener(e -> {
               toast.setText(this.juego.ayudaPublico(pregunta));
               toast.show();
               toast.setText("Respuesta correcta");
            });
        } catch (Exception e) {
            this.info = "Juego terminado, su premio es de " + this.juego.getPremio();
            menu();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void menu() {
        this.dialog = new Dialog(this);
        this.dialog.setContentView(R.layout.view_play);
        this.infoTextView = dialog.findViewById(R.id.textViewInfo);
        infoTextView.setText(info);
        button = this.dialog.findViewById(R.id.buttonPlay);
        button.setOnClickListener((e) -> {
            this.juego = new QuienQuiereSerMillonario();
            establecerPregunta();
            dialog.dismiss();

        });
        dialog.show();
    }


}
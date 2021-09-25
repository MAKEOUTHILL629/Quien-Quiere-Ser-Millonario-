package com.udistrital.quienquieresermillonario;

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
        menu();
        establecerPregunta();


    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void establecerPregunta() {

        this.respuestaA.setBackgroundColor(Color.WHITE);
        this.respuestaB.setBackgroundColor(Color.WHITE);
        this.respuestaC.setBackgroundColor(Color.WHITE);
        this.respuestaD.setBackgroundColor(Color.WHITE);


        Pregunta pregunta = this.juego.obtenerPreguntaAleatoria();

        this.enunciadoPregunta.setText(pregunta.getEnunciado());
        List<Respuesta> listaRespuesta = pregunta.obtenerRespuestasAleatoriamente();
        this.respuestaA.setText(listaRespuesta.get(0).getRespuesta());
        this.respuestaB.setText(listaRespuesta.get(1).getRespuesta());
        this.respuestaC.setText(listaRespuesta.get(2).getRespuesta());
        this.respuestaD.setText(listaRespuesta.get(3).getRespuesta());
        this.puntuacion.setText("Puntuacion : " + this.juego.getPuntuacion());
        this.nivel.setText("Nivel: " + this.juego.getNivel());


        this.respuestaA.setOnClickListener(e -> {
            if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(0))) {
                this.respuestaA.setBackgroundColor(Color.GREEN);

                establecerPregunta();


            } else {
                this.respuestaA.setBackgroundColor(Color.RED);

            }
        });


        this.respuestaB.setOnClickListener(e -> {
            if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(1))) {
                this.respuestaB.setBackgroundColor(Color.GREEN);
                establecerPregunta();

            } else {
                this.respuestaB.setBackgroundColor(Color.RED);
                this.respuestaA.setBackgroundColor(Color.WHITE);
            }
        });

        this.respuestaC.setOnClickListener(e -> {
            if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(2))) {
                this.respuestaC.setBackgroundColor(Color.GREEN);

                establecerPregunta();


            } else {
                this.respuestaC.setBackgroundColor(Color.RED);

            }
        });

        this.respuestaD.setOnClickListener(e -> {
            if (this.juego.verificarCorrecta(pregunta, listaRespuesta.get(3))) {
                this.respuestaD.setBackgroundColor(Color.GREEN);

                establecerPregunta();


            } else {
                this.respuestaD.setBackgroundColor(Color.RED);

            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void menu(){
        setContentView(R.layout.view_play);
        button = findViewById(R.id.buttonPlay);
        button.setOnClickListener((e) -> {
            this.juego = new QuienQuiereSerMillonario();
            setContentView(R.layout.activity_main);

        });
        establecerPregunta();
    }



}
package com.udistrital.quienquieresermillonario.services;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.udistrital.quienquieresermillonario.dominio.Pregunta;
import com.udistrital.quienquieresermillonario.dominio.Respuesta;
import com.udistrital.quienquieresermillonario.repositories.RespuestaDataBuilder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuienQuiereSerMillonario {

    private int puntuacion;
    private int nivel;
    private boolean juegoTerminado;

    private List<Pregunta> preguntas;


    public QuienQuiereSerMillonario() {
        this.puntuacion = 0;
        this.nivel = 1;
        RespuestaDataBuilder builder = new RespuestaDataBuilder();
        this.preguntas = builder.getPreguntaList();
        this.juegoTerminado = false;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Pregunta obtenerPreguntaAleatoria() {
        int cantidadNoSolucionadas = (int) this.preguntas.stream().filter(pregunta -> !pregunta.getEstaSolucionada()).count();
        Random random = new Random();
        int index = random.nextInt(cantidadNoSolucionadas);

        return this.preguntas.stream().filter(pregunta -> !pregunta.getEstaSolucionada()).collect(Collectors.toList()).get(index);
    }


    public boolean verificarCorrecta(Pregunta pregunta, Respuesta respuesta) {
        boolean resultado = pregunta.seSoluciono(respuesta);

        if (resultado) {
            puntuacion++;

        } else {
            juegoTerminado = true;
        }
        return resultado;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int cantidadRespondidad() {
        return (int) this.preguntas.stream().filter(pregunta -> pregunta.getEstaSolucionada()).count();
    }


    public int getPuntuacion() {
        return puntuacion;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int getNivel() {
        if (this.cantidadRespondidad() % 5 == 0) {

            nivel++;
            return nivel - 1;
        }
        return nivel;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}

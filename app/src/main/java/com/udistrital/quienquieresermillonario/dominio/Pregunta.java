package com.udistrital.quienquieresermillonario.dominio;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private Boolean estaSolucionada;
    private String enunciado;
    private List<Respuesta> respuestas;

    public Pregunta(String enunciado, String respuesta) {
        this.enunciado = enunciado;
        this.respuestas = new ArrayList<>();
        Respuesta respuestaCorrecta = new Respuesta(respuesta, true);
        this.respuestas.add(respuestaCorrecta);
        this.estaSolucionada = false;
    }

    public void agregarRespuestaIncorrecta(String respuesta) {
        if (respuestas.size() < 4) {
            Respuesta respuestaCorrecta = new Respuesta(respuesta, false);
            this.respuestas.add(respuestaCorrecta);
        } else {
            throw new IllegalStateException("Ya tiene las cuatros respuestas necesarias");
        }
    }

    public boolean seSoluciono(Respuesta respuesta) {
        if (respuesta.getEsCorrecta()) {
            this.estaSolucionada = true;
            return true;
        } else {
            return false;
        }
    }

    public List<Respuesta> obtenerRespuestasAleatoriamente() {
        List<Respuesta> respuestasAleatorias = new ArrayList<>();
        while (respuestasAleatorias.size() < 4) {

            for (Respuesta res : this.respuestas) {
                int random = (int) Math.floor(Math.random() * 11 + 1);
                if (random > 5 && !respuestasAleatorias.contains(res)) {
                    respuestasAleatorias.add(res);
                }
            }
        }


        return respuestasAleatorias;
    }


    public Boolean getEstaSolucionada() {
        return estaSolucionada;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }


}

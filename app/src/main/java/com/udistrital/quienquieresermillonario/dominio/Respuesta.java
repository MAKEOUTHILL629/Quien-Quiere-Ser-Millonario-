package com.udistrital.quienquieresermillonario.dominio;

public class Respuesta {
    private String respuesta;
    private Boolean esCorrecta;

    public Respuesta(String respuesta, Boolean esCorrecta) {
        this.respuesta = respuesta;
        this.esCorrecta = esCorrecta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }
}

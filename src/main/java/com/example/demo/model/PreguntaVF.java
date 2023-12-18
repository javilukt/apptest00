package com.example.demo.model;

public class PreguntaVF {
    private String pregunta;
    private boolean respuesta;

    public PreguntaVF(String pregunta, boolean respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }


}

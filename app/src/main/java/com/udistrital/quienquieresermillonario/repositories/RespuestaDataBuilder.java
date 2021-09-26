package com.udistrital.quienquieresermillonario.repositories;

import com.udistrital.quienquieresermillonario.dominio.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class RespuestaDataBuilder {
    private List<Pregunta> preguntaList;


    public  RespuestaDataBuilder() {

        this.preguntaList = new ArrayList<>();

        Pregunta pregunta1 = new Pregunta("¿Cuáles son los cinco tipos de sabores primarios?", " dulce, amargo, ácido, salado y umami.");
        pregunta1.agregarRespuestaIncorrecta("Miel, Salado, Amargo, Asqueroso");
        pregunta1.agregarRespuestaIncorrecta("Salado, Dulce, Amargo, Expleanda");
        pregunta1.agregarRespuestaIncorrecta("Unami, Salado, Acido, Sin sabor");
        this.preguntaList.add(pregunta1);



        Pregunta pregunta2 = new Pregunta("¿Cuál es el lugar más frío de la tierra?", "La Antártida");
        pregunta2.agregarRespuestaIncorrecta("Bogota");
        pregunta2.agregarRespuestaIncorrecta("La Nevera");
        pregunta2.agregarRespuestaIncorrecta("Polo Norte");
        this.preguntaList.add(pregunta2);


        Pregunta pregunta3 = new Pregunta("¿Quién escribió La Odisea?", "Homero");
        pregunta3.agregarRespuestaIncorrecta("Garcia Marquez");
        pregunta3.agregarRespuestaIncorrecta("Newton");
        pregunta3.agregarRespuestaIncorrecta("Gauss");
        this.preguntaList.add(pregunta3);


        Pregunta pregunta4 = new Pregunta("¿Cuál es el río más largo del mundo?", "Amazonas");
        pregunta4.agregarRespuestaIncorrecta("Nilo");
        pregunta4.agregarRespuestaIncorrecta("Magdalena");
        pregunta4.agregarRespuestaIncorrecta("Rio Bogota");
        this.preguntaList.add(pregunta4);


        Pregunta pregunta5 = new Pregunta("¿Cómo se llama la Reina del Reino Unido?", "Isabel II");
        pregunta5.agregarRespuestaIncorrecta("Maria I");
        pregunta5.agregarRespuestaIncorrecta("Felipe IV");
        pregunta5.agregarRespuestaIncorrecta("Antonieta");
        this.preguntaList.add(pregunta5);


        Pregunta pregunta6 = new Pregunta("¿En qué continente está Ecuador?", "América");
        pregunta6.agregarRespuestaIncorrecta("Asia");
        pregunta6.agregarRespuestaIncorrecta("Europa");
        pregunta6.agregarRespuestaIncorrecta("Africa");
        this.preguntaList.add(pregunta6);


        Pregunta pregunta7 = new Pregunta("¿Dónde originaron los juegos olímpicos?", "Grecia");
        pregunta7.agregarRespuestaIncorrecta("Londres");
        pregunta7.agregarRespuestaIncorrecta("China");
        pregunta7.agregarRespuestaIncorrecta("Alemania");
        this.preguntaList.add(pregunta7);

        Pregunta pregunta8 = new Pregunta("¿Qué cantidad de huesos en el cuerpo humano?", "Un adulto tiene 206, mientras que los recién nacidos tienen alrededor de 300 huesos.");
        pregunta8.agregarRespuestaIncorrecta("Un adulto tiene 300, mientras que los recién nacidos tienen alrededor de 206 huesos.");
        pregunta8.agregarRespuestaIncorrecta("Un adulto tiene 106, mientras que los recién nacidos tienen alrededor de 100 huesos.");
        pregunta8.agregarRespuestaIncorrecta("Un adulto tiene 226, mientras que los recién nacidos tienen alrededor de 206 huesos.");
        this.preguntaList.add(pregunta8);


        Pregunta pregunta9 = new Pregunta("¿Cuándo acabó la II Guerra Mundial?", "1945");
        pregunta9.agregarRespuestaIncorrecta("1965");
        pregunta9.agregarRespuestaIncorrecta("1978");
        pregunta9.agregarRespuestaIncorrecta("1846");
        this.preguntaList.add(pregunta9);


        Pregunta pregunta10 = new Pregunta("¿Quién pintó “la última cena”?", "Leonardo da Vinci");
        pregunta10.agregarRespuestaIncorrecta("Miguel Ángel");
        pregunta10.agregarRespuestaIncorrecta("Rafael Sanzio");
        pregunta10.agregarRespuestaIncorrecta("Vincent van Gogh");
        this.preguntaList.add(pregunta10);


        Pregunta pregunta11 = new Pregunta("¿En qué país se encuentra la torre de Pisa?", "Italia");
        pregunta11.agregarRespuestaIncorrecta("Francia");
        pregunta11.agregarRespuestaIncorrecta("Londres");
        pregunta11.agregarRespuestaIncorrecta("Reino Unido");
        this.preguntaList.add(pregunta11);

        Pregunta pregunta12 = new Pregunta("¿Cuál es el océano más grande?", "Pacífico");
        pregunta12.agregarRespuestaIncorrecta("Atlántico");
        pregunta12.agregarRespuestaIncorrecta("Índico");
        pregunta12.agregarRespuestaIncorrecta("Glacial Antártico");
        this.preguntaList.add(pregunta12);


        Pregunta pregunta13 = new Pregunta(" ¿Qué año llegó Cristóbal Colón a América?", "1492");
        pregunta13.agregarRespuestaIncorrecta("1965");
        pregunta13.agregarRespuestaIncorrecta("1698");
        pregunta13.agregarRespuestaIncorrecta("1255");
        this.preguntaList.add(pregunta13);


        Pregunta pregunta14 = new Pregunta("¿Dónde se encuentra la famosa Torre Eiffel?", "Paris");
        pregunta14.agregarRespuestaIncorrecta("Turín");
        pregunta14.agregarRespuestaIncorrecta("Tokio");
        pregunta14.agregarRespuestaIncorrecta("Vilna");
        this.preguntaList.add(pregunta14);


        Pregunta pregunta15 = new Pregunta("¿Cuál es tercer planeta en el sistema solar?", "Tierra");
        pregunta15.agregarRespuestaIncorrecta("Marte");
        pregunta15.agregarRespuestaIncorrecta("Jupiter");
        pregunta15.agregarRespuestaIncorrecta("Saturno");
        this.preguntaList.add(pregunta15);


    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }
}

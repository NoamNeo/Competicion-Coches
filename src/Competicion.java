public class Competicion {

    private boolean haCorridoCampeonato;
    private String nombre;
    private Piloto[] participantes;
    private int[] puntuacionPilotos;
    private Carrera[] carreras;

    public boolean arrancarCampeonato() {
        if (!haCorridoCampeonato) {
            System.out.println("\n------------------------------\n\nEjecutamos el campeonato " + this.nombre);
            this.puntuacionPilotos = new int[participantes.length];
            int i = 1;
            for (Carrera iCarrera : carreras) {
                System.out.println("\nCarrera: " + i);
                iCarrera.ejecutarCarrera();
                almacenarResultados(iCarrera.getPilotosOrdenados());
                i++;
            }
            this.haCorridoCampeonato = true;
            return true;
        }
        return false;
    }

    public void imprimirResultado() {
        System.out.println("\n\nResultados de cada piloto:");
        int[] idOrdenadas = new int[participantes.length];
        for (int i = 0; i < idOrdenadas.length; i++) {
            idOrdenadas[i] = i;
        }
        insertSort(idOrdenadas, puntuacionPilotos);
        for (int i = 0; i < idOrdenadas.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + participantes[idOrdenadas[i]].getNombre() + " - "
                    + puntuacionPilotos[idOrdenadas[i]] + " puntos");
        }
    }

    public void imprimirResultadoEscuderia() {
        System.out.println("\nResultados de cada escudería:");
        String[] escuderias = getArrayEscuderia(participantes);
        int[] puntuacionEscuderia = getPuntuacionEscuderia(escuderias);
        for (int i = 0; i < escuderias.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + escuderias[i] + " - "
                    + puntuacionEscuderia[i] + " puntos");
        }
    }

    private String[] getArrayEscuderia(Piloto[] participantes) {
        String[] escuderias = null;
        for (Piloto iPiloto : participantes) {
            if (escuderias == null) {
                escuderias = new String[1];
                escuderias[0] = iPiloto.getCoche().getEscuderia();
            } else {
                int contador = 0;
                for (String nombre : escuderias) {
                    if (nombre.equals(iPiloto.getCoche().getEscuderia())) {
                        contador++;
                    }
                }
                if (contador == 0) {
                    int length = escuderias.length + 1;
                    String[] buffer = new String[length];
                    for (int i = 0; i < escuderias.length; i++) {
                        buffer[i] = escuderias[i];
                    }
                    buffer[length - 1] = iPiloto.getCoche().getEscuderia();
                    escuderias = buffer;
                }
            }
        }
        return escuderias;
    }

    private int[] getPuntuacionEscuderia(String[] escuderias) {
        int[] puntuacionEscuderia = new int[escuderias.length];
        for (int i = 0; i < participantes.length; i++) {
            for (int j = 0; j < escuderias.length; j++) {
                if (escuderias[j].equals(participantes[i].getCoche().getEscuderia())) {
                    puntuacionEscuderia[j] += puntuacionPilotos[i];
                    break;
                }
            }
        }
        return puntuacionEscuderia;
    }

    private void insertSort(int[] arrayId, int[] arrayPuntuacion) {
        for (int i = 1; i < arrayId.length; i++) {
            int key = arrayId[i];
            int j = i - 1;
            while (j >= 0 && arrayPuntuacion[arrayId[j]] < arrayPuntuacion[key]) {
                arrayId[j + 1] = arrayId[j];
                j -= 1;
            }
            arrayId[j + 1] = key;
        }
    }

    private void almacenarResultados(Piloto[] arrayOrdenado) {
        int cantPilotos = (arrayOrdenado.length < 3) ? arrayOrdenado.length : 3;
        for (int i = 0; i < cantPilotos; i++) {
            for (int j = 0; j < participantes.length; j++) {
                if (arrayOrdenado[i] == participantes[j]) {
                    switch (i) {
                        case 0:
                            puntuacionPilotos[j] += 10;
                            break;
                        case 1:
                            puntuacionPilotos[j] += 8;
                            break;
                        case 2:
                            puntuacionPilotos[j] += 5;
                            break;
                    }
                }
            }
        }
    }

    public boolean anhadirCarrera(Carrera carrera, int vueltas) {
        if (!haCorridoCampeonato) {
            if (!estaEnLista(carrera)) {
                carrera.setVueltas(vueltas);
                carreras = getNewArray(carrera);
                return true;
            }
        }
        return false;
    }

    public boolean anhadirPiloto(Piloto piloto) {
        if (!haCorridoCampeonato) {
            if (!estaEnLista(piloto)) {
                participantes = getNewArray(piloto);
                return true;
            }
        }
        return false;
    }

    private Carrera[] getNewArray(Carrera carrera) {
        int length;
        if (carreras == null) {
            length = 1;
        } else {
            length = carreras.length + 1;
        }
        Carrera[] arrayTemporal = new Carrera[length];
        for (int i = 0; i < length - 1; i++) {
            arrayTemporal[i] = carreras[i];
        }
        arrayTemporal[length - 1] = carrera;
        return arrayTemporal;
    }

    private Piloto[] getNewArray(Piloto piloto) {
        int length = (participantes == null) ? 1 : participantes.length + 1;
        Piloto[] buffer = new Piloto[length];
        for (int i = 0; i < length - 1; i++) {
            buffer[i] = participantes[i];
        }
        buffer[length - 1] = piloto;
        return buffer;
    }

    private boolean estaEnLista(Carrera carrera) {
        if (carreras == null) {
            return false;
        }
        for (Carrera iCarrera : carreras) {
            if (iCarrera.getCircuito().getNombre().equals(carrera.getCircuito().getNombre())) {
                return true;
            }
        }
        return false;
    }

    private boolean estaEnLista(Piloto piloto) {
        if (participantes == null) {
            return false;
        }
        for (Piloto iPiloto : participantes) {
            if (iPiloto.getNombre().equals(piloto.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public Competicion(String nombre) {
        this.nombre = nombre;
    }

}

public class Competicion {

    private boolean haCampeonato;
    private String nombre;
    private Piloto[] participantes;
    private int[] puntuacionPilotos;
    private int numPilotos; // Contador para saber cuántos pilotos hay realmente

    private Carrera[] carreras;
    private int numCarreras; // Contador para saber cuántas carreras hay

    public boolean arrancarCampeonato() {
        if (!haCampeonato) {
            this.puntuacionPilotos = new int[participantes.length];
            for (Carrera iCarrera : carreras) {
                iCarrera.ejecutarCarrera(participantes);
                almacenarResultados(iCarrera.getPilotosOrdenados());
            }
            this.haCampeonato = true;
            return true;
        }
        return false;
    }

    public void imprimirResultado() {
        int[] idOrdenadas = new int[participantes.length];
        for (int i = 0; i < idOrdenadas.length; i++) {
            idOrdenadas[i] = i;
        }
        idOrdenadas = insertSort(idOrdenadas, puntuacionPilotos);
        for (int i = 0; i < idOrdenadas.length; i++) {
            System.out.println("Piloto: " + participantes[idOrdenadas[i]].getNombre() + "\nPuntuación: "
                    + puntuacionPilotos[idOrdenadas[i]]);
        }
    }

    public void imprimirResultadoEscuderia() {
        String[] escuderias = getArrayEscuderia(participantes);
        int[] puntuacionEscuderia = getPuntuacionEscuderia(escuderias);
        for (int i = 0; i < escuderias.length; i++) {
            System.out.println("Escudería: " + escuderias[i] + "\n Puntuación: " + puntuacionEscuderia[i]);
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
                }
            }
        }
        return puntuacionEscuderia;
    }

    private int[] insertSort(int[] arrayId, int[] arrayPuntuacion) {
        int[] sorted = arrayId;
        for (int i = 1; i < sorted.length; i++) {
            int key = sorted[i];
            int j = i - 1;
            while (j >= 0 && arrayPuntuacion[sorted[j]] < arrayPuntuacion[key]) {
                sorted[j + 1] = sorted[j];
                j -= 1;
            }
            sorted[j + 1] = key;
        }
        return sorted;
    }

    private void almacenarResultados(Piloto[] arrayOrdenado) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < participantes.length; j++) {
                if (arrayOrdenado[i].getNombre().equals(participantes[j].getNombre())) {
                    switch (j) {
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
        if (!haCampeonato) {
            if (!estaEnLista(carrera)) {
                carrera.setVueltas(vueltas);
                carreras = getNewArray(carrera);
                return true;
            }
        }
        return false;
    }

    public boolean anhadirPiloto(Piloto piloto) {
        if (!haCampeonato) {
            if (!estaEnLista(piloto)) {
                participantes = getNewArray(piloto);
                return true;
            }
        }
        return false;
    }

    private Carrera[] getNewArray(Carrera carrera) {
        int length = (carreras == null) ? 1 : carreras.length + 1;
        Carrera[] buffer = new Carrera[length];
        for (int i = 0; i < carreras.length; i++) {
            buffer[i] = carreras[i];
        }
        buffer[length - 1] = carrera;
        return buffer;
    }

    private Piloto[] getNewArray(Piloto piloto) {
        int length = (participantes == null) ? 1 : participantes.length + 1;
        Piloto[] buffer = new Piloto[length];
        for (int i = 0; i < participantes.length; i++) {
            buffer[i] = participantes[i];
        }
        buffer[length - 1] = piloto;
        return buffer;
    }

    private boolean estaEnLista(Carrera carrera) {
        for (Carrera iCarrera : carreras) {
            if (iCarrera.getCircuito().getNombre().equals(carrera.getCircuito().getNombre())) {
                return true;
            }
        }
        return false;
    }

    private boolean estaEnLista(Piloto piloto) {
        for (Piloto iPiloto : participantes) {
            if (iPiloto.getNombre().equals(piloto.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public int getNumPilotos() {
        return numPilotos;
    }

    public void setNumPilotos(int numPilotos) {
        this.numPilotos = numPilotos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

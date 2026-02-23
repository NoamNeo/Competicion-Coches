public class Competicion {

    private boolean haCampeonato;
    private String nombre;
    private Piloto[] participantes;
    private int numPilotos; // Contador para saber cuántos pilotos hay realmente

    private Carrera[] carreras;
    private int numCarreras; // Contador para saber cuántas carreras hay

    public boolean arrancarCampeonato() {
        if (!haCampeonato) {
            for (Carrera iCarrera : carreras) {
                iCarrera.ejecutarCarrera(participantes);
            }
            this.haCampeonato = true;
            return true;
        }
        return false;
    }

    public boolean anhadirCarrera(Carrera carrera, int vueltas) {
        if (!haCampeonato) {
            if (!estaEnLista(carrera)) {
                carreras = getBuffer(carrera);
                return true;
            }
        }
        return false;
    }

    public boolean anhadirPiloto(Piloto piloto) {
        if (!haCampeonato) {
            if (!estaEnLista(piloto)) {
                participantes = getBuffer(piloto);
                return true;
            }
        }
        return false;
    }

    private Carrera[] getBuffer(Carrera carrera) {
        int length = (carreras == null) ? 1 : carreras.length + 1;
        Carrera[] buffer = new Carrera[length];
        for (int i = 0; i < carreras.length; i++) {
            buffer[i] = carreras[i];
        }
        buffer[length - 1] = carrera;
        return buffer;
    }

    private Piloto[] getBuffer(Piloto piloto) {
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

public class Competicion {

    private String nombre;
    private Piloto[] participantes;
    private int numPilotos; // Contador para saber cuántos pilotos hay realmente

    private Carrera[] carreras;
    private int numCarreras; // Contador para saber cuántas carreras hay

    public boolean anhadirPiloto(Piloto piloto) {
        if (carreras == null || carreras.length == 0) {
            if (!estaEnLista(piloto)) {
                participantes = getBuffer(piloto);
                return true;
            }
        }
        return false;
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

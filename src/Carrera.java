public class Carrera {
    private boolean yaCorrida;
    private int vueltas;
    private Piloto[] pilotos, pilotosOrdenados;
    private String temporada;
    private Circuito circuito;

    public boolean ejecutarCarrera(Piloto[] pilotos) {
        this.pilotos = pilotos;
        if (!yaCorrida) {
            for (Piloto piloto : pilotos) {
                System.out.println(piloto.getNombre() + " va a " + (piloto.getCoche().acabaCarrera(getLongitudTotal()) ? String.valueOf(piloto.velocidadMedia()) : "0" + " km/h."));
            }
            yaCorrida = true;
            return true;
        }
        return false;
    }

    private void ordenarPilotos() {
        pilotosOrdenados = new Piloto[pilotos.length];
        pilotosOrdenados[0] = pilotos[0];
        for (int i = 1; i < pilotos.length; i++) {
            int j;
            for (j = i; j > 0; j--)
                if (pilotos[i].velocidadMedia() > pilotosOrdenados[j].velocidadMedia())
                    pilotosOrdenados[j] = pilotosOrdenados[j - 1];
                else break;
            pilotosOrdenados[j] = pilotosOrdenados[i];
        }
    }

    public Carrera(int vueltas, String temporada, Circuito circuito) {
//        yaCorrida = false;
        this.vueltas = vueltas;
        this.temporada = temporada;
        this.circuito = circuito;
    }

    public boolean isYaCorrida() {
        return yaCorrida;
    }

    public int getVueltas() {
        return vueltas;
    }

    public Piloto[] getPilotos() {
        return pilotos;
    }

    public Piloto[] getPilotosOrdenados() {
        return pilotosOrdenados;
    }

    public String getTemporada() {
        return temporada;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public int getLongitudTotal() {
        return circuito.getLongitud() * vueltas;
    }
}
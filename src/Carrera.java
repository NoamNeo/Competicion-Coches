public class Carrera {
    private boolean yaCorrida;
    private int vueltas;
    private Piloto[] pilotos, pilotosOrdenados;
    private String temporada;
    private Circuito circuito;

    public boolean ejecutarCarrera() {
        if (!yaCorrida) {
            for (Piloto piloto : pilotos) {
                System.out.println(piloto.getNombre() + " va a " + (piloto.getCoche().acabaCarrera(getLongitudTotal()) ? String.valueOf(piloto.velocidadMedia()) : "0" + " km/h."));
            }
            yaCorrida = true;
            return true;
        }
        return false;
    }

    private void ordernarPilotos() {

    }

    public Carrera(int vueltas, Piloto[] pilotos, String temporada, Circuito circuito) {
//        yaCorrida = false;
        this.vueltas = vueltas;
        this.pilotos = pilotos;
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
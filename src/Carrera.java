public class Carrera {
    private boolean yaCorrida;
    private int vueltas;
    private Piloto[] pilotos, pilotosOrdenados;
    private String temporada;
    private Circuito circuito;

    public boolean ejecutarCarrera() {
        if (!yaCorrida) {
            for (int i = 0; i < pilotos.length; i++) {
                double velocidadMedia = pilotos[i].getCoche().acabaCarrera(getLongitudTotal()) ? pilotos[i].velocidadMedia() : 0;
                System.out.println(pilotos[i].getNombre() + " va a " + velocidadMedia + "km/h");
                int j;
                for (j = i; j > 0; j--)
                    if (velocidadMedia > pilotosOrdenados[j].velocidadMedia())
                        pilotosOrdenados[j] = pilotosOrdenados[j - 1];
                    else break;
                pilotosOrdenados[j] = pilotosOrdenados[i];
            }
            yaCorrida = true;
            return true;
        }
        return false;
    }

    public Carrera(int vueltas,Piloto[] pilotos, String temporada, Circuito circuito) {
//        yaCorrida = false;
        this.vueltas = vueltas;
        this.pilotos = pilotos;
        pilotosOrdenados = new Piloto[pilotos.length];
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
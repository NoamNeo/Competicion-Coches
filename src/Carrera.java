public class Carrera {
    private boolean yaCorrida;
    private int vueltas;
    private Piloto[] pilotos, pilotosOrdenados;
    private String temporada;
    private Circuito circuito;

    public boolean ejecutarCarrera() {
        if (!yaCorrida) {
            pilotosOrdenados = new Piloto[pilotos.length];
            double[] velocidades = new double[pilotos.length];
            for (int i = 0; i < pilotos.length; i++) {
                velocidades[i] = pilotos[i].getCoche().acabaCarrera(getLongitudTotal()) ? pilotos[i].velocidadMedia() : 0;
                System.out.println(pilotos[i].getNombre() + " va a " + velocidades[i] + "km/h");
                int j;
                for (j = i; j > 0; j--)
                    if (velocidades[i] > velocidades[j]) {
                        pilotosOrdenados[j] = pilotosOrdenados[j - 1];
                        velocidades[j] = velocidades[j - 1];
                    }
                    else break;
                pilotosOrdenados[j] = pilotosOrdenados[i];
                velocidades[j] = velocidades[i];
            }
            yaCorrida = true;
            return true;
        }
        return false;
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

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }
}
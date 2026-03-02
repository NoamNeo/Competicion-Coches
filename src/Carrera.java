public class Carrera {
    private boolean yaCorrida;
    private int vueltas;
    private Piloto[] pilotos, pilotosOrdenados;
    private String temporada;
    private Circuito circuito;

    public Carrera(Piloto[] pilotos, String temporada, Circuito circuito) {
        this.pilotos = pilotos;
        pilotosOrdenados = new Piloto[pilotos.length];
        this.temporada = temporada;
        this.circuito = circuito;
    }

    public boolean ejecutarCarrera() {
        if (!yaCorrida) {
            double[] velocidades = new double[pilotos.length];
            for (int i = 0; i < pilotos.length; i++) {
                double velocidad = pilotos[i].getCoche().acabaCarrera(getLongitudTotal()) ? pilotos[i].velocidadMedia() : 0;
                System.out.println("\t" + pilotos[i].getNombre() + " va a " + String.format("%.2f", velocidad) + "km/h");
                int j;
                for (j = i; j > 0; j--)
                    if (velocidad > velocidades[j - 1]) {
                        pilotosOrdenados[j] = pilotosOrdenados[j - 1];
                        velocidades[j] = velocidades[j - 1];
                    }
                    else break;
                pilotosOrdenados[j] = pilotos[i];
                velocidades[j] = velocidad;
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

        public class Simulador {
            public static void main(String[] args) {

                Coche coche1 = new Coche(350,"Audi",0.2);
                Coche coche2 = new Coche (360,"Audi",0.4);
                Coche coche3= new Coche (345,"RedBull",0.9);
                Coche coche4 = new Coche (365,"RedBull",0.6);
                Coche coche5 = new Coche (339,"Ferrari",0.5);
                Coche coche6 = new Coche (333,"Ferrari",0.8);




                Piloto piloto1 = new Piloto ("Pablo",29,coche1,"Bueno");
                Piloto piloto2 = new Piloto ("José",34,coche2,"Mediocre");
                Piloto piloto3 = new Piloto ("Arturo",33,coche3,"Excelente");
                Piloto piloto4 = new Piloto ("Leonardo",26,coche4,"Bueno");
                Piloto piloto5 = new Piloto ("Estéfano",36,coche5,"Excelente");
                Piloto piloto6 = new Piloto ("Raúl", 27,coche6,"Mediocre");
                Piloto[] arrPiloto = {piloto6,piloto1,piloto3,piloto5,piloto4,piloto2};


                Circuito adelaida = new Circuito("Adelaida", 375);
                Circuito jerez = new Circuito ("Jerez",440);
                Circuito madring = new Circuito("Madring",540);
                Circuito barcelona = new Circuito ("Barcelona", 460);



                Competicion competicion1 = new Competicion("competicion1");
                Competicion competicion2 = new Competicion ("competicion2");

                competicion1.anhadirCarrera(new Carrera(arrPiloto,"Verano",adelaida),7);
                competicion1.anhadirCarrera(new Carrera(arrPiloto,"Invierno",madring),3);
                competicion1.anhadirCarrera(new Carrera(arrPiloto,"Verano",jerez),2);

                competicion2.anhadirCarrera(new Carrera(arrPiloto,"Otoño", madring),4);
                competicion2.anhadirCarrera(new Carrera(arrPiloto,"Verano", barcelona),6);
                competicion2.anhadirCarrera(new Carrera(arrPiloto,"Otoño", jerez),5);

                competicion1.anhadirPiloto(piloto1);
                competicion1.anhadirPiloto(piloto2);
                competicion1.anhadirPiloto(piloto3);
                competicion1.anhadirPiloto(piloto4);
                competicion1.anhadirPiloto(piloto5);
                competicion1.anhadirPiloto(piloto6);

                competicion2.anhadirPiloto(piloto1);
                competicion2.anhadirPiloto(piloto2);
                competicion2.anhadirPiloto(piloto3);
                competicion2.anhadirPiloto(piloto4);
                competicion2.anhadirPiloto(piloto5);
                competicion2.anhadirPiloto(piloto6);


                competicion1.arrancarCampeonato();
                competicion1.imprimirResultado();
                competicion1.imprimirResultadoEscuderia();

                competicion2.arrancarCampeonato();
                competicion2.imprimirResultado();
                competicion2.imprimirResultadoEscuderia();

    }
}
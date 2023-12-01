import java.util.Random;

class Tortuga extends Thread {
    private static final int AVANZAR_RAPIDO = 3;
    private static final int RESBALAR = -5;
    private static final int AVANZAR_LENTO = 1;

    private static final int PROBABILIDAD_AVANZAR_RAPIDO = 50;
    private static final int PROBABILIDAD_RESBALAR = 20;
    private static final int PROBABILIDAD_AVANZAR_LENTO = 30;

    private static final Random random = new Random();

    private int posicion;

    public Tortuga() {
        this.posicion = 1;
    }

    @Override
    public void run() {
        while (posicion < 70) {
            simularMovimiento();
            imprimirCarrera("T ("+posicion+")");
            esperarSegundo();
        }
        System.out.println("¡La tortuga ha llegado a la meta!");
    }

    private void simularMovimiento() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= PROBABILIDAD_AVANZAR_RAPIDO) {
            posicion += AVANZAR_RAPIDO;
        } else if (probabilidad <= PROBABILIDAD_AVANZAR_RAPIDO + PROBABILIDAD_RESBALAR) {
            posicion += RESBALAR;
            if (posicion < 1) {
                posicion = 1;
            }
        } else {
            posicion += AVANZAR_LENTO;
        }
    }

    private void imprimirCarrera(String animal) {
        for (int i = 1; i <= 70; i++) {
            if (i == posicion) {
                System.out.print(animal);
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    private void esperarSegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

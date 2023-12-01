import java.util.Random;

class Liebre extends Thread {
    private static final int DORMIR = 0;
    private static final int GRAN_SALTO = 9;
    private static final int RESBALON_GRANDE = -12;
    private static final int PEQUENO_SALTO = 1;
    private static final int RESBALON_PEQUENO = -2;

    private static final int PROBABILIDAD_DORMIR = 20;
    private static final int PROBABILIDAD_GRAN_SALTO = 20;
    private static final int PROBABILIDAD_RESBALON_GRANDE = 10;
    private static final int PROBABILIDAD_PEQUENO_SALTO = 30;
    private static final int PROBABILIDAD_RESBALON_PEQUENO = 20;

    private static final Random random = new Random();

    private int posicion;

    public Liebre() {
        this.posicion = 1;
    }

    @Override
    public void run() {
        while (posicion < 70) {
            simularMovimiento();
            imprimirCarrera("L ("+posicion+")");
            esperarSegundo();
        }
        System.out.println("¡La liebre ha llegado a la meta!");
    }

    private void simularMovimiento() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= PROBABILIDAD_DORMIR) {
            // La liebre se queda dormida, no se mueve
        } else if (probabilidad <= PROBABILIDAD_DORMIR + PROBABILIDAD_GRAN_SALTO) {
            posicion += GRAN_SALTO;
        } else if (probabilidad <= PROBABILIDAD_DORMIR + PROBABILIDAD_GRAN_SALTO + PROBABILIDAD_RESBALON_GRANDE) {
            posicion += RESBALON_GRANDE;
            if (posicion < 1) {
                posicion = 1;
            }
        } else if (probabilidad <= PROBABILIDAD_DORMIR + PROBABILIDAD_GRAN_SALTO + PROBABILIDAD_RESBALON_GRANDE + PROBABILIDAD_PEQUENO_SALTO) {
            posicion += PEQUENO_SALTO;
        } else {
            posicion += RESBALON_PEQUENO;
            if (posicion < 1) {
                posicion = 1;
            }
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

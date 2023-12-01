public class CarreraAnimales {
    public static void main(String[] args) {
        System.out.println("¡Comienza la carrera!");

        Tortuga tortuga = new Tortuga();
        Liebre liebre = new Liebre();

        tortuga.start();
        liebre.start();
    }
}
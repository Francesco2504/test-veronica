import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        giocoImpiccato gioco = new giocoImpiccato("PROGRAMMAZIONE", 6);

        System.out.println("=== BENVENUTO ALL'IMPICCATO ===");

        while (!gioco.isFinita()) {
            System.out.println("\nParola: " + gioco.getStatoParola());
            System.out.println("Vite rimaste: " + gioco.getVite());
            System.out.print("Inserisci una lettera: ");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            char lettera = input.charAt(0);
            boolean indovinata = gioco.tentaLettera(lettera);

            if (indovinata) {
                System.out.println("Bravo! Lettera corretta.");
            } else {
                System.out.println("Lettera sbagliata!");
            }
        }

        System.out.println("\n-----------------------------");
        if (gioco.isVittoria()) {
            System.out.println("COMPLIMENTI! Hai vinto: " + gioco.getParolaSegreta());
        } else {
            System.out.println("HAI PERSO! La parola era: " + gioco.getParolaSegreta());
        }

        scanner.close();
    }

}


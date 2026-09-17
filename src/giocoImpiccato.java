import java.util.Arrays;
public class giocoImpiccato {
    private String parolaSegreta;
    private char[] progresso;
    private int vite;

    public GiocoImpiccato(String parola, int viteIniziali) {
        this.parolaSegreta = parola.toUpperCase();
        this.vite = viteIniziali;
        this.progresso = new char[parolaSegreta.length()];
        Arrays.fill(this.progresso, '_');
    }

    public boolean tentaLettera(char lettera) {
        lettera = Character.toUpperCase(lettera);
        boolean trovata = false;

        for (int i = 0; i < parolaSegreta.length(); i++) {
            if (parolaSegreta.charAt(i) == lettera) {
                progresso[i] = lettera;
                trovata = true;
            }
        }

        if (!trovata) {
            vite--;
        }
        return trovata;
    }

    public boolean isVittoria() {
        for (char c : progresso) {
            if (c == '_') return false;
        }
        return true;
    }

    public boolean isFinita() {
        return vite <= 0 || isVittoria();
    }

    public String getStatoParola() {
        StringBuilder sb = new StringBuilder();
        for (char c : progresso) {
            sb.append(c).append(" ");
        }
        return sb.toString().trim();
    }

    public int getVite() {
        return vite;
    }

    public String getParolaSegreta() {
        return parolaSegreta;
    }
}

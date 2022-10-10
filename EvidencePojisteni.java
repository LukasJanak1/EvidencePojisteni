
//dodelat vypis jednoho pojistence
import java.util.ArrayList;
import java.util.Scanner;

public class EvidencePojisteni {
    private Databaze databaze;
    private Scanner scanner = new Scanner(System.in, "Windows-1250");

    public EvidencePojisteni() {
        databaze = new Databaze();
    }

    public void vypisVsechnyPojistence() {
        ArrayList<Pojistenec> zaznamy = databaze.najdiVsechnyPojistence();
        for (Pojistenec pojistenec : zaznamy) {
            System.out.println(pojistenec);
        }
    }

    public void pridejPojistence() {
        String jmeno = zadejJmeno();
        String prijmeni = zadejPrijmeni();
        int vek = zadejVek();
        int telefon = zadejTelefon();
        databaze.pridejPojistence(jmeno, prijmeni, vek, telefon);
        System.out.println("Pojištěnec byl úspěšně vložen!");
    }

    public void vyhledejPojistence() {
        String jmeno = zadejJmeno();
        String prijmeni = zadejPrijmeni();
        ArrayList<Pojistenec> pojistenci = databaze.najdiPojistence(jmeno.toLowerCase(), prijmeni.toLowerCase());
        if (pojistenci.size() > 0) {
            System.out.println("Nalezeni tito pojištěnci: ");
            for (Pojistenec pojistenec : pojistenci) {
                System.out.println(pojistenec);
            }
        } else {

            System.out.println("Nebyli nalezeni žádní pojištěnci");
        }
    }

    public String textovyExport(){
       String textovyVypis = databaze.toString();
       return textovyVypis;
    }

    private String zadejJmeno() {
        System.out.println("Zadejte křestní jméno pojištěnce:");
        String jmeno = scanner.nextLine().trim();
        while (jmeno.length()>15||jmeno.length()<2) {
            System.out.println("Příliš krátké nebo dlouhé jméno. Vložte prosím znovu.");
            jmeno = scanner.nextLine().trim();
        }
        return jmeno;
    }

    private String zadejPrijmeni() {
        System.out.println("Zadejte příjmení pojištěnce:");
        String prijmeni = scanner.nextLine().trim();
        while (prijmeni.length() > 15 || prijmeni.length() < 2) {
            System.out.println("Příliš krátké nebo dlouhé příjmení. Vložte prosím znovu.");
            prijmeni = scanner.nextLine().trim();
        }
        return prijmeni;
    }

    private int zadejVek() {
        System.out.println("Zadejte věk:");
        int vek = 0;
        while (vek == 0) {
            try {
                vek = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Neplatná hodnota. Věk zadávejte čísly.");
            }
        }
        return vek;
    }
    
    private int zadejTelefon() {
        System.out.println("Zadejte telefon bez mezer mezi čísly:");
        int telefon = 0;
        while (telefon == 0 || telefon < 100000000 || telefon > 999999999) {
            try {

                telefon = Integer.parseInt(scanner.nextLine().trim());

            } catch (Exception e) {
                System.out.println("Neplatné telefonní číslo, zadejte prosím znovu.");
                continue;
            }
            if (telefon < 100000000 || telefon > 999999999)
                System.out.println("Příliš krátké nebo dlouhé telefonní číslo. Zadejte prosím znovu.");
        }
        return telefon;
    }
}

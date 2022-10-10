import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Main - hlavní okno aplikace
 */
public class Main {

    public static void main(String[] args)throws IOException {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        EvidencePojisteni evidencePojisteni = new EvidencePojisteni();
        String vstup = "";
        System.out.println();
        System.out.println("Vítejte v evidenci pojištěnců!");
        System.out.println("Veškeré vstupy zadávejte bez diakritiky.");
        System.out.println();
        while (!vstup.equals("4")) {
            System.out.println();

            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat pojištěnce");
            System.out.println("2 - Vyhledat konkrétního pojištěnce");
            System.out.println("3 - Vypsat všechny pojištěnce");
            System.out.println("4 - Konec");
            System.out.println("5 - Export všech pojištěnců do textového souboru");
            vstup = scanner.nextLine().trim().toLowerCase();
            ;
            System.out.println();
            switch (vstup) {
                case "1":
                    evidencePojisteni.pridejPojistence();
                    break;
                case "2":
                    evidencePojisteni.vyhledejPojistence();
                    break;
                case "3":
                    evidencePojisteni.vypisVsechnyPojistence();
                    break;
                case "4":
                    break;
                case "5":
                    PrintWriter out = new PrintWriter("Pojistenci.txt");
                    out.println(evidencePojisteni.textovyExport());
                    out.close(); 
                    System.out.println("Export kompletní!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                    break;
            }
        }
    }
}
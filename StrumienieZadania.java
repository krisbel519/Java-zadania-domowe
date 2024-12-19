import java.util.*;
import java.util.stream.Collectors;

public class StrumienieZadania {
    
    public static void main(String[] args) {
        zadanie1();
        zadanie2();
        zadanie3();
    }
    
    // Zadanie 1
    public static void zadanie1() {
        List<Integer> liczby = Arrays.asList(45, 39, 17, 25, 10, 4);
        double srednia = liczby.stream()
                .filter(liczba -> liczba % 10 != 9 && liczba % 10 != 7) 
                .mapToInt(Integer::intValue) 
                .average() 
                .orElse(0.0); 
        System.out.println("Zadanie 1: Srednia = " + srednia);
    }
    
    // Zadanie 2
    public static void zadanie2() {
        List<Integer> liczby = Arrays.asList(3, 10, 9, 4);
        List<Integer> wynik = liczby.stream()
                .map(liczba -> liczba * liczba + 9) 
                .filter(wynikLiczby -> !String.valueOf(wynikLiczby).contains("9")) 
                .collect(Collectors.toList()); 
        System.out.println("Zadanie 2: " + wynik);
    }
    
    // Zadanie 3
    public static void zadanie3() {
        List<String> slowa = Arrays.asList("aa", "cy", "b", "yycd", "c");
        List<String> wynik = slowa.stream()
                .map(slowo -> slowo + "y") 
                .filter(slowo -> !slowo.contains("yy")) 
                .collect(Collectors.toList()); 
        System.out.println("Zadanie 3: " + wynik);
    }
}

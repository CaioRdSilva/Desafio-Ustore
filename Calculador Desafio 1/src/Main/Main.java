package Main;

import Model.Poligono;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Poligono> poligonos = new ArrayList<>();

        while(true){
            int lados = 0;
            double lado = 0;

            try {
                System.out.println("Informe o número de lados do polígono (3 para triangulo, 4 para quadrado), ou digite 0 para calcular a área: ");
                lados = Integer.parseInt(scanner.next());

                if (lados == 0) {
                    break;
                }else if(lados < 3 || lados > 4){
                    System.out.println("O polígono deve possuir 3 ou 4 lados. \n");
                    lados = 0;
                    continue;
                }

            }catch(Exception e){
                System.out.println(catchLadosError(e));
                scanner.nextLine();
                continue;
            }

            try{
                 System.out.println("Informe o tamanho do lado (em cm): ");
                lado = Double.parseDouble(scanner.next());

                if(lado <= 0) {
                    System.out.println("O lado tem que ser maior que 0.\n");
                    lado = 0;
                    continue;
                }

            }catch(Exception e){
                System.out.println(catchLadoError(e));
                scanner.nextLine();
                continue;
            }

            String tipo = "";
            if(lados == 3){
                tipo = "Triângulo";
            }else{
                tipo = "Quadrado";
            }
            poligonos.add(new Poligono(tipo, lado));
        }


        if(poligonos.isEmpty()){
            System.out.println("Ainda não possui nenhum polígono.");
        }else {
            System.out.println("\nÁrea dos polígonos:");
            double areaTotal = 0 ;
            for(Poligono p: poligonos){
                System.out.println(p);
                areaTotal += p.calcularArea();
            }
            System.out.println("Área total " + (Math.round(areaTotal * 100.0) / 100.0) + " cm2");
        }

        scanner.close();
    }

    //Tratamento da exception try catch
    private static String catchLadosError(Exception e){
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?", Pattern.CASE_INSENSITIVE);

        if(pattern.matcher(e.getMessage()).find()) {
            return "Você inseriu um número em formato inválido.\n";
        }else{
            return "Você inseriu um texto ou caractere inválido.\n";
        }
    }

    //Tratamento da exception try catch
    private static String catchLadoError(Exception e){
        Pattern pattern = Pattern.compile("\\d+(\\d+)?", Pattern.CASE_INSENSITIVE);
        if(pattern.matcher(e.getMessage()).find()){
            return "Digito inválido, utilize '.' no lugar de ','.\n";
        }else{
            return "Você inseriu um texto ou caractere inválido.\n";
        }
    }
}
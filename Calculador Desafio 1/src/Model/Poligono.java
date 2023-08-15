package Model;

public class Poligono {
    private String tipo;

    private double lado;

    public Poligono(){
        super();
    }

    public Poligono(String tipo,double lado) {
        this.tipo = tipo;
        this.lado = lado;
    }

    public double calcularArea() {
        if(tipo.equals("Triângulo")) {
            double altura = Math.sqrt(3) * lado/2;
            double result = (lado * altura)/2;
            return (Math.floor(result * 100.0) / 100.0);
        } else if(tipo.equals("Quadrado")){
            double result = lado * lado;
            return (Math.floor(result * 100.0) / 100.0);
        }
        return 0;
    }

    @Override
    public String toString(){
        return tipo + " de lado " + lado + "cm e área " +calcularArea() + " cm2";
    }
}

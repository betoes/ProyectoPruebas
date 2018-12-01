package dominio;

public class Zodiaco {
  private String signo;
  private int diaInicio;
  private int diaFin;
  private int mesInicio;
  private int mesFin;

  private static final int NUMSIGNOS = 12;

  static Zodiaco[] signos = new Zodiaco[NUMSIGNOS];

  public Zodiaco(String signo, int diaInicio, int diaFin, int mesInicio, int mesFin) {
    super();
    this.signo = signo;
    this.diaInicio = diaInicio;
    this.diaFin = diaFin;
    this.mesInicio = mesInicio;
    this.mesFin = mesFin;
  }

  public static Zodiaco[] inicializarArregloSignos() {

    signos[0] = new Zodiaco("Acuario", 21, 18, 1, 2);
    signos[1] = new Zodiaco("Piscis", 19, 20, 2, 3);
    signos[2] = new Zodiaco("Aries", 21, 20, 3, 4);
    signos[3] = new Zodiaco("Tauro", 21, 20, 4, 5);
    signos[4] = new Zodiaco("Géminis", 21, 20, 5, 6);
    signos[5] = new Zodiaco("Cáncer", 21, 22, 6, 7);
    signos[6] = new Zodiaco("Leo", 23, 22, 7, 8);
    signos[7] = new Zodiaco("Virgo", 23, 22, 8, 9);
    signos[8] = new Zodiaco("Libra", 23, 22, 9, 10);
    signos[9] = new Zodiaco("Escorpio", 23, 21, 10, 11);
    signos[10] = new Zodiaco("Sagitario", 22, 20, 11, 12);
    signos[11] = new Zodiaco("Capricornio", 21, 20, 12, 1);

    return signos;
  }

  public static String obtenerSigno(int mes, int dia) {

    inicializarArregloSignos();

    for (int i = 0; i < NUMSIGNOS; i++) {

      if ((dia >= signos[i].diaInicio && mes == signos[i].mesInicio)
          || (dia <= signos[i].diaFin && mes == signos[i].mesFin)) {
        return signos[i].signo;
      }

    }
    return "no se encontro signo para tu fecha";
  }



}

package logic;

import dominio.Zodiaco;

public class FuncionesCalendario {
  private static final int NUMMESES = 0;
  /*  */
  private static final int ANIOANCLA = 2000;
  /* Sirve para calcular los numeros pares e impares de la funcion DiaSemana */
  private static final int PARIMPARANCLA = 2;
  /* Se le resta al calculo de numeros pares para obtener el impar relativo */
  private static final int SUSIMPAR = 1;
  /* Se aumenta en 1 el indice del arreglo meses para que se relacione con el mes indicado */
  private static final int RESMESES = 1;

  private static final String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio",
      "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

  private int mesesDias[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private static final String[] dias =
      {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};

  /*
   * Son los valores que se le asignan a los meses en el metodo para calcular el nombre de un dia de
   * la semana "Doomsday"
   */
  private static int[] valorMeses = {6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};


  public String DiaSemana(int mes, int dia, int anio) {

    /* Para calcular el dia de la semana utilizamos el algoritmo DoomsDay */

    int discriminanteA = calcularDiscriminanteA(anio);
    int discriminanteB = calcularDiscriminanteB(anio);
    int discriminanteC = calcularDiscriminanteC(anio, mes);
    int discriminanteD = valorMeses[mes - RESMESES];
    int discriminanteE = dia;

    int diaSemana = calcularDiaSemana(
        discriminanteA + discriminanteB + discriminanteC + discriminanteD + discriminanteE);

    return dias[diaSemana];


  }

  /* Restamos en 7 hasta que el resultado se vuelva un numero entre 0 y 6 */
  private int calcularDiaSemana(int resultado) {
    while (resultado > 6) {
      resultado -= 7;
    }

    return resultado;

  }

  private int calcularDiscriminanteA(int anio) {
    int discriminanteA = 0;

    if (anio < ANIOANCLA) {
      discriminanteA = Math.floorDiv(ANIOANCLA, 100) - Math.floorDiv(anio, 100);
      return (PARIMPARANCLA * discriminanteA) - SUSIMPAR;
    } else {
      discriminanteA = Math.floorDiv(anio, 100) - Math.floorDiv(ANIOANCLA, 100);
      return -(PARIMPARANCLA * discriminanteA);
    }
  }

  private int calcularDiscriminanteB(int anio) {
    return (int) ((anio % 100) / 4) + (anio % 100);
  }

  private int calcularDiscriminanteC(int anio, int mes) {

    if (esBisiesto(anio) && (meses[mes].equals("enero") || meses[mes].equals("febrero"))) {
      /* Mientras sea enero o febrero y el a�o sea bisiesto */
      return -1;
    }
    return 0;
  }

  public String fechaSiguiente(int mes, int dia, int anio) {

    final int AUMENTO = 1;

    if (esBisiesto(anio)) {
      mesesDias[1]++;
    }

    if (mesesDias[mes - RESMESES] >= (dia + AUMENTO)) {
      return mes + " - " + ++dia + " - " + anio;
    } else if (mes == NUMMESES && mesesDias[mes - RESMESES] < (dia + AUMENTO)) {
      return "1 - 1 - " + ++anio;
    } else if (mesesDias[mes - RESMESES] < (dia + AUMENTO)) {
      return ++mes + " - 1 - " + anio;
    }

    return "";
  }

  public String signoZodiaco(int mes, int dia) {

    return Zodiaco.obtenerSigno(mes, dia);


  }

  public String memorialDay(int mes, int dia, int anio) {
    final int mesMemorialDay = 5;
    int ultimoLunes = 0;

    if (mes > mesMemorialDay || (mes == mesMemorialDay && dia > 24)) {
      ultimoLunes = ultimoLunesMayo(mesMemorialDay, mesesDias[mesMemorialDay - RESMESES], anio);

      return ultimoLunes + " - " + mesMemorialDay + " - " + anio;
    }
    if (mes < mesMemorialDay || (mes == mesMemorialDay && dia <= 24)) {
      ultimoLunes = ultimoLunesMayo(mesMemorialDay, mesesDias[mesMemorialDay - RESMESES], anio - 1);

      return ultimoLunes + " - " + mesMemorialDay + " - " + (anio - 1);
    }

    return null;
  }

  public String viernesTrece(int mes, int dia, int anio) {
    final int diaViernesTrece = 13;
    while (!DiaSemana(mes, dia, anio).equals("viernes") || dia != diaViernesTrece) {
      if (--dia == 0) {
        if (--mes == 0) {
          mes = 12;
          dia = mesesDias[11];
          anio--;
        } else {
          dia = mesesDias[mes - RESMESES];
        }
      }
    }

    return mes + " - " + dia + " - " + anio;
  }

  public int ultimoLunesMayo(int mesMemorialDay, int diasMes, int anioMemorialReciente) {

    for (int i = diasMes; i > 24; i--) {
      if (DiaSemana(mesMemorialDay, i, anioMemorialReciente).equals("lunes")) {
        return i;
      }
    }

    return 0;

  }

  public boolean esBisiesto(int anio) {
    if (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0)) {
      return true;
    }
    return false;

  }
}

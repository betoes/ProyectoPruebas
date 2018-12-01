package gui;

import logic.FuncionesCalendario;

public class calendarioPrincipal {
  public static void main(String[] args) {
    FuncionesCalendario funcionesC = new FuncionesCalendario();

    System.out.println(funcionesC.DiaSemana(10, 10, 1997));

    System.out.println(funcionesC.fechaSiguiente(10, 10, 1997));

    System.out.println(funcionesC.signoZodiaco(11, 19));
  }
}

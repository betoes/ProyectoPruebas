package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.FuncionesCalendario;

public class pantallaCalendarioControlador implements Initializable {

  @FXML
  private TextField txtDia;

  @FXML
  private TextField txtMes;

  @FXML
  private TextField txtAnio;

  @FXML
  private Button bBorrar;

  @FXML
  private Button bSiguienteDia;

  @FXML
  private Button bDiaSemana;

  @FXML
  private Button bZodiaco;

  @FXML
  private Button bMemorialDay;

  @FXML
  private Button bViernes13;


  public boolean validarFecha() {

    FuncionesCalendario bisiesto = new FuncionesCalendario();
    boolean correcto = true;

    int dia = Integer.parseInt(txtDia.getText());
    int mes = Integer.parseInt(txtMes.getText());
    int anio = Integer.parseInt(txtAnio.getText());

    if (dia < 1 || dia > 31) {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Dia excedido");
      alert.setContentText("El dia ingresado supera los limites");

      alert.showAndWait();
      correcto = false;

    } else if (mes < 1 || mes > 12) {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Mes excedido");
      alert.setContentText("El mes ingresado supera los limites");

      alert.showAndWait();
      correcto = false;


    } else if (anio < 1700 || anio > 2100) {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Campos vacios");
      alert.setContentText("El año ingresado supera los limites");

      alert.showAndWait();
      correcto = false;

    } else if (dia == 29 && mes == 02 && bisiesto.esBisiesto(anio) == false) {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Fecha no existente");
      alert.setContentText("La fecha ingresada no existe");

      alert.showAndWait();
      correcto = false;
    }

    return correcto;
  }

  public boolean fechaVacia() {
    boolean vacio = false;

    if (txtDia.getText().equals("") || txtMes.getText().equals("")
        || txtAnio.getText().equals("")) {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Campos vacios");
      alert.setContentText("Ingrese un dato en todos los campos");

      alert.showAndWait();
      vacio = true;
    }

    return vacio;
  }

  public void tamañoCampo(TextField textField, int tamaño) {
    textField.setOnKeyTyped(event -> {
      int maxCaracter = tamaño;
      if (textField.getText().length() > maxCaracter)
        event.consume();
    });
  }

  public void tipoTexto(TextField textField) {
    textField.textProperty().addListener(
        (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
          if (!newValue.matches("[0-9]")) {
            textField.setText(newValue.replaceAll("[^0-9]", ""));
          }
        });
  }

  @FXML
  public void diaSiguiente() {

    FuncionesCalendario fechaSiguiente = new FuncionesCalendario();

    if (fechaVacia() == false) {
      if (validarFecha() == true) {

        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Dia siguiente");
        alert.setContentText(
            "El dia siguiente es: " + fechaSiguiente.fechaSiguiente(mes, dia, anio));

        alert.showAndWait();
      }
    }

  }

  @FXML
  public void DiaSemana() {

    FuncionesCalendario fechaSiguiente = new FuncionesCalendario();

    if (fechaVacia() == false) {
      if (validarFecha() == true) {

        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Dia semana");
        alert.setContentText("El dia de la semana es: " + fechaSiguiente.DiaSemana(mes, dia, anio));

        alert.showAndWait();
      }
    }
  }

  @FXML
  public void zodiaco() {

    FuncionesCalendario fechaSiguiente = new FuncionesCalendario();

    if (fechaVacia() == false) {
      if (validarFecha() == true) {

        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Zodiaco");
        alert.setContentText("Tu zodiaco es" + fechaSiguiente.signoZodiaco(mes, dia));

        alert.showAndWait();
      }
    }

  }

  @FXML
  public void memorialDay() {

    FuncionesCalendario memorialDay = new FuncionesCalendario();

    if (fechaVacia() == false) {
      if (validarFecha() == true) {

        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Memorial day");
        alert.setContentText(
            "El ultimo memorial day es: " + memorialDay.memorialDay(mes, dia, anio));

        alert.showAndWait();
      }
    }

  }

  @FXML
  public void viernes13() {

    FuncionesCalendario viernesTrece = new FuncionesCalendario();

    if (fechaVacia() == false) {
      if (validarFecha() == true) {

        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Viernes 13");
        alert.setContentText(
            "El ultimo viernes 13 es: " + viernesTrece.viernesTrece(mes, dia, anio));

        alert.showAndWait();
      }
    }

  }

  @FXML
  public void borrar() {
    txtDia.setText("");
    txtMes.setText("");
    txtAnio.setText("");
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {

    tipoTexto(txtDia);
    tamañoCampo(txtDia, 1);
    tipoTexto(txtMes);
    tamañoCampo(txtMes, 1);
    tipoTexto(txtAnio);
    tamañoCampo(txtAnio, 3);

  }

}

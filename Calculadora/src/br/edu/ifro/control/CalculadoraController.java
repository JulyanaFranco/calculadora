/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Historico;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 05010722259
 */
public class CalculadoraController implements Initializable {
    
    @FXML
    private TextField txtNumero1;
    @FXML
    private TextField txtNumero2;
    @FXML
    private TextField txtResultado;
    @FXML
    private Label lblNumero1;
    @FXML
    private Label lblNumero2;
    @FXML
    private Label lblResultado;
    @FXML
    private Label label;
    @FXML
    private Button btnSoma;
    @FXML
    private Button btnDivisão;
    @FXML
    private Button btnMultiplicacao;
    @FXML
    private Button btnSubtracao;
    @FXML
    private Button limpar;
    @FXML
    private Button fechar;
    
    @FXML
    private void soma(ActionEvent event) { 
       
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());
        Double resultado = num1 + num2; 
        
        txtResultado.setText(resultado.toString());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Historico hist = new Historico ();
        hist.setPrimeiroValor(num1);
        hist.setSegundoValor(num2);
        hist.setOperador("+");
        hist.setResultado(resultado);
        
        em.getTransaction().begin();
        em.persist(hist);
        em.getTransaction().commit();
    }
    @FXML
    private void subtracao(ActionEvent event) {
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());
        Double resultado = num1 - num2; 
        
        txtResultado.setText(resultado.toString());
        
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Historico hist = new Historico ();
        hist.setPrimeiroValor(num1);
        hist.setSegundoValor(num2);
        hist.setOperador("+");
        hist.setResultado(resultado);
        
        em.getTransaction().begin();
        em.persist(hist);
        em.getTransaction().commit();
    }
    @FXML
    private void multiplicacao(ActionEvent event) {
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());
        Double resultado = num1 * num2; 
        
        txtResultado.setText(resultado.toString());
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Historico hist = new Historico ();
        hist.setPrimeiroValor(num1);
        hist.setSegundoValor(num2);
        hist.setOperador("-");
        hist.setResultado(resultado);
        
        em.getTransaction().begin();
        em.persist(hist);
        em.getTransaction().commit();
    }
    @FXML
    private void divisao(ActionEvent event) {
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());
        Double resultado = num1 / num2; 
        
        txtResultado.setText(resultado.toString());
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Historico hist = new Historico ();
        hist.setPrimeiroValor(num1);
        hist.setSegundoValor(num2);
        hist.setOperador("/");
        hist.setResultado(resultado);
        
        em.getTransaction().begin();
        em.persist(hist);
        em.getTransaction().commit();
    }
    @FXML
    private void limpar(ActionEvent event) {
      txtNumero1.setText("");
      txtNumero2.setText("");
      txtResultado.setText("");
    }
    @FXML
    private void fechar(ActionEvent event) {
        System.exit(0);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void historico(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Historico.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),555,354);
        Stage stage = new Stage();
        stage.setTitle("Histórico");
        stage.setScene(scene);
        stage.show();
    }
    
}

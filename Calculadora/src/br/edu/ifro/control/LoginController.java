/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 04607476226
 */
public class LoginController implements Initializable {
    @FXML
    private TextField Usuario;
    @FXML
    private JFXTextField Senha2;
    @FXML
    private TextField Senha;
    @FXML
    private JFXCheckBox cbMostrarSenha;
    @FXML
    private JFXButton btnCadastro;

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
 public void Salvar() throws IOException{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("SELECT l FROM Login as l WHERE l.usuario = :usuario"); 
     
    query.setParameter("usuario", Usuario.getText());
    
    List<Login> l = query.getResultList();
    if (!l.isEmpty()) {
        Login login = l.get(0);
        String senha = Senha2.getText();
        String senha2 = Senha.getText();
        if (login.getSenha().equals(senha) || login.getSenha().equals(senha2)) {
        JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Calculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),555,354);
        Stage stage = new Stage();
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
        }
        
    else {
        JOptionPane.showMessageDialog(null, "Senha incorreta");
    }
    } 
    else {
    JOptionPane.showMessageDialog(null, "Usuário incorreto");
    }
 
    em.close();
    emf.close();
    
 }
 
 @Override
 public void initialize(URL url, ResourceBundle rb) {
 // TODO
 Senha.setVisible(true);
 Senha2.setVisible(false);
 } 



    @FXML
 private void mostrarSenha(ActionEvent event) {
 if(cbMostrarSenha.isSelected()){
 Senha2.setText(Senha.getText());
 Senha2.setVisible(true);
 Senha.setVisible(false); 
 }
 else{
 Senha.setText(Senha2.getText());
 Senha.setVisible(true);
 Senha2.setVisible(false); 
 }
 }

    @FXML
    private void Cancelar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void abrirCadastroLogin(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastroLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),469,353);

        Stage stage = new Stage();
        stage.setTitle("Cadastrar Login");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void onEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            Salvar();
        }
    }

    
}
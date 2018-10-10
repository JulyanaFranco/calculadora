
package br.edu.ifro.control;

import br.edu.ifro.model.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroLoginController implements Initializable {

    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXTextField txtSenha;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField Senha2;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void abrirLogin(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600,482);
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
}
catch(IOException e){

}
    }

    @FXML
    private void Salvar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Login log = new Login();
        log.setUsuario (txtUsuario .getText());
        log.setSenha (txtSenha.getText());
        log.setSenha2 (Senha2.getText());
        
        em.getTransaction() .begin();
        em.persist(log);
        em.getTransaction() .commit();
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Limpar(ActionEvent event) {
        txtUsuario.setText("");
        txtSenha.setText("");
        Senha2.setText("");
    }
    
}

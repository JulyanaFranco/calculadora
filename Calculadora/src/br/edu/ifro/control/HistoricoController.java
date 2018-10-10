/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Historico;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 05010722259
 */
public class HistoricoController implements Initializable {

    @FXML
    private TableView<String> tbCalculadora;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT c FROM Historico as c");
        //query.setParameter("id");
        
        List<Historico> historicos = query.getResultList();
        
        ObservableList obHistorico = FXCollections.observableArrayList(historicos);
        tbCalculadora.setItems(obHistorico);
        
        
        
    }    

    @FXML
    private void Fechar(ActionEvent event) {
         System.exit(0);
    }

    @FXML
    private void calculadora(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Calculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),555,354);
        Stage stage = new Stage();
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }
    
}

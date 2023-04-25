package chatting.client;

import chatting.client.control.LoginController;
import chatting.client.control.MainController;
import chatting.share.model.UserInfo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;


public class Client extends Application {
  private static final Logger LOG = LoggerFactory.getLogger(Client.class);
  private Stage stage;
  private Initializable controller;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    stage.setTitle("Client");
    login("");
  }

  @Override
  public void stop() {
    LOG.trace("Close");
    if (controller instanceof MainController)
      ((MainController) controller).logout("");
    System.exit(0);
  }

  public void login(String tip) {
    try {
      LoginController loginController = (LoginController) replace("/client_login.fxml");
      loginController.setClient(this);
      loginController.setTip(tip);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void enterMain(UserInfo u) {
    LOG.trace("Entering...");
    try {
      MainController mainController = (MainController) replace("/client_main.fxml");
      mainController.init(u);
      mainController.setClient(this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Initializable replace(String fxml) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    InputStream in = getClass().getResourceAsStream(fxml);
    loader.setBuilderFactory(new JavaFXBuilderFactory());
    loader.setLocation(getClass().getResource(fxml));
    VBox vBox = loader.load(in);
    in.close();
    Platform.runLater(() -> {
      Scene scene = new Scene(vBox);
      stage.setScene(scene);
      stage.sizeToScene();
      stage.centerOnScreen();
      stage.show();
    });
    LOG.trace("Set Main Frame already " + fxml);
    controller = loader.getController();
    return controller;
  }


}

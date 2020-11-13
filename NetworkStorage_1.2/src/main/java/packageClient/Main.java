package packageClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Network network;

    public static Network getNetwork(){
        return network;
    }

    private FXMLLoader loaderWindowStorage;
    private Parent rootWindowStorage;
    private Scene sceneWindowStorage;
    private static Controller controllerWindowStorage;
    private static Stage stageWindowStorage;

    private FXMLLoader authLoader;
    private Parent authRoot;
    private Scene authScene;
    private static AuthController authController;
    private static Stage authStage;

    private FXMLLoader loaderReg;
    private Parent rootReg;
    private Scene sceneReg;
    private static RegController regController;
    private static Stage stageReg;

    public static AuthController getAuthController(){
        return authController;
    }
    private void setPrivariStageClient(Stage stage){
        Main.stageWindowStorage = stage;
    }
    public static Stage getStageClient(){
        return Main.stageWindowStorage;
    }
    public static RegController getRegController(){
        return regController;
    }
    public static Controller getControllerWindowStorage(){
        return controllerWindowStorage;
    }
    @Override
    public void start(Stage stage) throws Exception{
        network = new Network();

        //Основное окно
        stageWindowStorage = new Stage();
        loaderWindowStorage = new FXMLLoader(getClass().getResource("/Client.fxml"));
        rootWindowStorage = (Parent)loaderWindowStorage.load();
        sceneWindowStorage = new Scene(rootWindowStorage,300,275);
        stageWindowStorage.setScene(sceneWindowStorage);
        stageWindowStorage.setTitle("Network Storage");
        controllerWindowStorage = loaderWindowStorage.getController();
        stageWindowStorage.show();

        authStage = new Stage();
        authLoader = new FXMLLoader(getClass().getResource("/Auth.fxml"));
        authRoot = (Parent)authLoader.load();
        authScene = new Scene(authRoot, 250,170);
        authStage.setScene(authScene);
        authStage.setTitle("Авторизация");
        authController = authLoader.getController();
        authStage.show();

        stageReg = new Stage();
        loaderReg = new FXMLLoader(getClass().getResource("/Reg.fxml"));
        rootReg = (Parent)loaderReg.load();
        sceneReg = new Scene(rootReg, 300, 200);
        stageReg.setScene(sceneReg);
        stageReg.setTitle("Регистрация");
        regController = loaderReg.getController();
        stageReg.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

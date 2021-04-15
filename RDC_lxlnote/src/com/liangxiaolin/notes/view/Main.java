package com.liangxiaolin.notes.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    public Main() {

    }

    static private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        loginpage();
        primaryStage.show();
    }

    /**
     * 在loginpage()里面调用了replaceSceneContent(fxml)
     * 初始登录界面
     */
    public void loginpage() {
        primaryStage.setTitle("登录页面");
        try {
            LogInController lic = (LogInController) replaceSceneContent("LogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册窗口
     */
    public void gotoregister() {
        primaryStage.setTitle("注册界面");
        try {
            RegisterController rc = (RegisterController) replaceSceneContent("Register.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 忘记密码窗口
     */
    public void gotoforgetpassword() {
        primaryStage.setTitle("密码中心");
        try {
            ForgetPasswordController fgc = (ForgetPasswordController) replaceSceneContent("ForgetPassword.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *登录后的主页面窗口
     */
    public void gotomainpage() {
        primaryStage.setTitle("欢迎回来研发笔记本~");
        try {
            MainPageController mpc = (MainPageController) replaceSceneContent("MainPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 个人笔记维护功能页面
     */
    public void gotoPersonalNotesEditPage() {
        primaryStage.setTitle("个人笔记维护功能页面");
        try {
            PersonalNotesEditController pnec = (PersonalNotesEditController) replaceSceneContent("PersonalNotesEdit.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 搜索页面
     */
    public void gotoSearchPage() {
        primaryStage.setTitle("搜索页面");
        try {
            SearchController sc = (SearchController) replaceSceneContent("Search.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 我的收藏夹
     */
    public void gotoFavoritePage() {
        primaryStage.setTitle("我的收藏夹");
        try {
            MyFavoriteController fc = (MyFavoriteController) replaceSceneContent("MyFavorite.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 笔记分类页面
     */
    public void gotoCategoryPage() {
        primaryStage.setTitle("笔记分类");
        try {
            CategoryController cc = (CategoryController) replaceSceneContent("Category.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gotoManagerLogIn() {
        primaryStage.setTitle("管理员界面");
        try {
            ManagerLogInController mlic = (ManagerLogInController) replaceSceneContent("ManagerLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Initializable replaceSceneContent(String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(fxml));
        primaryStage.setScene(new Scene(root, 1176, 773));
        primaryStage.sizeToScene();
        return (Initializable) loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package com.liangxiaolin.notes.view;


    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.image.ImageView;

public class PasswordFaultController {

    Main m = new Main();

        @FXML
        private ImageView photo_symbol;

        @FXML
        private Label lable_tip;

        @FXML
        private Button back;

        @FXML
        void Back(ActionEvent event) {

            m.loginpage();
        }

    }

package com.liangxiaolin.notes.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;

import java.util.Optional;

public class SimpleUtils {

    /**
     * 操作结果：自定义一个JavaFX的对话框
     * @param header    对话框头信息
     * @param message   对话框显示内容
     */
    public static boolean informationDialog(String header, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, new ButtonType("确定", ButtonBar.ButtonData.YES), new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE));
        // 设置对话框的标题
        alert.setTitle("提示");
        alert.setHeaderText(header);
        Optional<ButtonType> buttonType = alert.showAndWait();
        // 根据点击结果返回
        if (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;// 如果点击了“确定”就返回true
        } else {
            return false;
        }
        }

    }


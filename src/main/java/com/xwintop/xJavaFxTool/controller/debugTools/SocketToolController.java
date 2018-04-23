package com.xwintop.xJavaFxTool.controller.debugTools;

import com.xwintop.xJavaFxTool.utils.JavaFxViewUtil;
import com.xwintop.xJavaFxTool.utils.SigarUtil;
import com.xwintop.xJavaFxTool.view.debugTools.SocketToolView;
import com.xwintop.xJavaFxTool.services.debugTools.SocketToolService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

@Getter
@Setter
@Slf4j
public class SocketToolController extends SocketToolView {
    private SocketToolService socketToolService = new SocketToolService(this);
    private ObservableList<Map<String, String>> serverConnectTableData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            initView();
            initEvent();
            initService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() throws Exception {
        String ifNames[] = SigarUtil.sigar.getNetInterfaceList();
        for (int i = ifNames.length - 1; i >= 0; i--) {
            String address = SigarUtil.sigar.getNetInterfaceConfig(ifNames[i]).getAddress();
            if (!"0.0.0.0".equals(address)) {
                serverTcpUrlComboBox.getItems().add(address);
                serverUdpUrlComboBox.getItems().add(address);
                clientUrlComboBox.getItems().add(address);
            }
        }
        serverTcpUrlComboBox.getSelectionModel().select(0);
        serverUdpUrlComboBox.getSelectionModel().select(0);
        clientUrlComboBox.getSelectionModel().select(0);
        JavaFxViewUtil.setTableColumnMapValueFactory(serverConnectTableColumn, "connect", false);
        serverConnectTableView.setItems(serverConnectTableData);
    }

    private void initEvent() {
        serverDataSend1Button.setOnMouseClicked(event -> {
            socketToolService.serverDataSendAction(serverDataSend1TextField.getText());
        });
        serverDataSend2Button.setOnMouseClicked(event -> {
            socketToolService.serverDataSendAction(serverDataSend2TextField.getText());
        });
        serverDataSend3Button.setOnMouseClicked(event -> {
            socketToolService.serverDataSendAction(serverDataSend3TextField.getText());
        });
        clientDataSend1Button.setOnMouseClicked(event -> {
            socketToolService.clientDataSendAction(clientDataSend1TextField.getText());
        });
        clientDataSend2Button.setOnMouseClicked(event -> {
            socketToolService.clientDataSendAction(clientDataSend2TextField.getText());
        });
        clientDataSend3Button.setOnMouseClicked(event -> {
            socketToolService.clientDataSendAction(clientDataSend3TextField.getText());
        });
        serverConnectTableView.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY && !serverConnectTableData.isEmpty()) {
                MenuItem menu_Remove = new MenuItem("断开选中连接");
                menu_Remove.setOnAction(event1 -> {
                    serverConnectTableData.remove(serverConnectTableView.getSelectionModel().getSelectedIndex());
                });
                MenuItem menu_RemoveAll = new MenuItem("断开所有连接");
                menu_RemoveAll.setOnAction(event1 -> {
                    serverConnectTableData.clear();
                });
                serverConnectTableView.setContextMenu(new ContextMenu(menu_Remove, menu_RemoveAll));
            }
        });
    }

    private void initService() {
    }

    @FXML
    private void serverTcpListenAction(ActionEvent event) throws Exception {
        socketToolService.serverTcpListenAction();
    }

    @FXML
    private void serverUdpListenAction(ActionEvent event) throws Exception {
        socketToolService.serverUdpListenAction();
    }

    @FXML
    private void serverClearLogAction(ActionEvent event) throws Exception {
        socketToolService.serverClearLogAction();
    }

    @FXML
    private void clientTcpConnectAction(ActionEvent event) throws Exception {
        socketToolService.clientTcpConnectAction();
    }

    @FXML
    private void clientUdpConnectAction(ActionEvent event) throws Exception {
        socketToolService.clientUdpConnectAction();
    }

    @FXML
    private void clientClearLogAction(ActionEvent event) throws Exception {
        socketToolService.clientClearLogAction();
    }
}
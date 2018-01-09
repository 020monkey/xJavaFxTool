package com.xwintop.xJavaFxTool.view.littleTools;

import com.xwintop.xJavaFxTool.model.EmailToolTableBean;
import com.xwintop.xJavaFxTool.model.SmsToolTableBean;
import lombok.Getter;
import lombok.Setter;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

@Getter
@Setter
public abstract class SmsToolView implements Initializable {
    @FXML
    protected CheckBox isEnabledCheckBox;
    @FXML
    protected TextField toPhoneTextField;
    @FXML
    protected TextField toPhoneNameTextField;
    @FXML
    protected Button addItemButton;
    @FXML
    protected Button importToPhoneButton;
    @FXML
    protected TableView<SmsToolTableBean> tableViewMain;
    @FXML
    protected TableColumn<SmsToolTableBean, Integer> orderTableColumn;
    @FXML
    protected TableColumn<SmsToolTableBean, Boolean> isEnabledTableColumn;
    @FXML
    protected TableColumn<SmsToolTableBean, String> toPhoneTableColumn;
    @FXML
    protected TableColumn<SmsToolTableBean, String> toPhoneNameTableColumn;
    @FXML
    protected TableColumn<SmsToolTableBean, Boolean> manualTableColumn;
    @FXML
    protected TableColumn<SmsToolTableBean, String> sendStatusTableColumn;
    @FXML
    protected TabPane mainTabPane;
    @FXML
    protected TextField cmccUrlTextField;
    @FXML
    protected TextField cmccApiKeyTextField;
    @FXML
    protected TextField cmccSecretKeyTextField;
    @FXML
    protected CheckBox cmccNeedReceiptCheckBox;
    @FXML
    protected TextField cmccReceiptNotificationUrlTextField;
    @FXML
    protected TextArea cmccMessageTextArea;
    @FXML
    protected Button cmccSendButton;
    @FXML
    protected TextField open189UrlTextField;
    @FXML
    protected TextField open189AppIdTextField;
    @FXML
    protected TextField open189AppSecretTextField;
    @FXML
    protected TextField open189TemplateIdTextField;
    @FXML
    protected TextArea open189TemplateParamTextArea;
    @FXML
    protected Button open189SendButton;
    @FXML
    protected TextField tencentAppidTextField;
    @FXML
    protected TextField tencentAppkeyTextField;
    @FXML
    protected CheckBox tencentIsParamCheckBox;
    @FXML
    protected TextField tencentMsgTextField;
    @FXML
    protected TextArea tencentParamsTextArea;
    @FXML
    protected Button tencentSendButton;
    @FXML
    protected TextField aliyunAccessKeyIdTextField;
    @FXML
    protected TextField aliyunAccessKeySecretTextField;
    @FXML
    protected TextField aliyunSignNameTextField;
    @FXML
    protected TextField aliyunTemplateCodeTextField;
    @FXML
    protected TextArea aliyunTemplateParamTextArea;
    @FXML
    protected Button aliyunSendButton;

}
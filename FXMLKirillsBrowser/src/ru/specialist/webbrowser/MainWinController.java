package ru.specialist.webbrowser;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class MainWinController implements Initializable 
{
	
	@FXML
	private TextField txtURL;
	@FXML
	private WebView browser;
	
	

	@FXML
	private void GO()
	{
		if (!txtURL.getText().isEmpty())
			browser.getEngine().load(txtURL.getText());
		
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//txtURL.setText("Enter your desired URL, starting with http://");
		
		txtURL.setOnKeyPressed(e->{
			if (e.getCode()==KeyCode.ENTER)
				GO();
			
		});
		
	}
	
}

package edu.fje.dam2;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Classe Activitat que permet realitzar la suma de dos nombres introduïts en
 * dues caselles de text.
 * 
 * @author sergi grau
 * @version 1.0, 06/11/2012
 */
public class E02_SumaActivity extends Activity implements View.OnClickListener {

	private EditText numero1;
	private EditText numero2;
	private Button botoSuma;
	private TextView resultat;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.e02_activity_suma);
		
		numero1 =(EditText) findViewById(R.id.numero1);
		numero2 =(EditText) findViewById(R.id.numero2);
		
		botoSuma = (Button) findViewById(R.id.botoSuma);
		botoSuma.setOnClickListener(this);
		resultat = (TextView) findViewById(R.id.resultat);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_suma, menu);
		return true;
	}
	
	@Override
	public void onClick(View arg0) {
		try{
			double suma = Double.parseDouble(numero1.getText().toString()) +
					Double.parseDouble(numero2.getText().toString());
			resultat.setText(resultat.getText()+" "+String.valueOf(suma));
			Log.v("onClick", String.valueOf(suma));
			
		}
		catch (Exception e){
			
		}
	}

}

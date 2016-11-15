package edu.fje.dam2;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Switch;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CompoundButton;

/**
 * Classe Activitat que  mitjançant un giny commutador permet
 * realitzar una suma o una resta dels nombres introduïts.
 * 
 * @author sergi grau
 * @version 1.0, 06/11/2012
 */
public class E03_SumaSwitchActivity extends Activity implements CompoundButton.OnCheckedChangeListener{

	private EditText numero1;
	private EditText numero2;
	private Switch switchSuma;
	private TextView resultat;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.e03_activity_suma_switch);
		
		numero1 =(EditText) findViewById(R.id.numero1);
		numero2 =(EditText) findViewById(R.id.numero2);
		
		switchSuma = (Switch) findViewById(R.id.botoSuma);
		switchSuma.setOnCheckedChangeListener(this);
		resultat = (TextView) findViewById(R.id.resultat);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_suma, menu);
		return true;
	}
	
	@Override
	 public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		double res=0;
		try{
			 if (isChecked) {
				 res = Double.parseDouble(numero1.getText().toString()) +
							Double.parseDouble(numero2.getText().toString());
	         } else {
	        	 res = Double.parseDouble(numero1.getText().toString()) -
							Double.parseDouble(numero2.getText().toString());
	         }
			
		}
		catch(Exception e){
		
		}
		resultat.setText(switchSuma.getText()+" "+String.valueOf(res));
		Log.v("onClick", String.valueOf(res));
	}

}

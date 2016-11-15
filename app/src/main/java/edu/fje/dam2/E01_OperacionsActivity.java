package edu.fje.dam2;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Classe 3. Activitat que donats dos nombres permeti realitzar les operacions
 * de suma, resta, producte o divisió, seleccionant-les mitjançant botons
 * d'opció
 * 
 * @author sergi grau
 * @version 1.0, 10/11/2012
 */
public class E01_OperacionsActivity extends Activity implements
		RadioGroup.OnCheckedChangeListener {

	private EditText numero1;
	private EditText numero2;
	private RadioGroup opcions;
	private TextView resultat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.e01_activity_operacions);

		numero1 = (EditText) findViewById(R.id.numero1);
		numero2 = (EditText) findViewById(R.id.numero2);
		resultat = (TextView) findViewById(R.id.resultat);
		opcions = (RadioGroup) findViewById(R.id.opcions);
		opcions.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		double res = 0;
		String operacio="";
		try {
			switch (checkedId) {

			case R.id.suma:
				res = Double.parseDouble(numero1.getText().toString())
						+ Double.parseDouble(numero2.getText().toString());
				operacio="suma";
				break;
			case R.id.resta:
				res = Double.parseDouble(numero1.getText().toString())
						- Double.parseDouble(numero2.getText().toString());
				operacio="resta";
				break;
				
			case R.id.producte:
				res = Double.parseDouble(numero1.getText().toString())
						* Double.parseDouble(numero2.getText().toString());
				operacio="producte";
				break;
			case R.id.divisio:
				res = Double.parseDouble(numero1.getText().toString())
						/ Double.parseDouble(numero2.getText().toString());
				operacio="divisio";
				break;
			}
			
			resultat.setText(operacio+ " " + String.valueOf(res));
			Log.v("onCheckedChanged", String.valueOf(res));

		} catch (Exception e) {
			resultat.setBackgroundColor(Color.RED);
			resultat.setText("operació incorrecta");
		}

	}
}

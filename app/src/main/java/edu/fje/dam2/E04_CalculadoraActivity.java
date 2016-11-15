package edu.fje.dam2;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

/**
 * Classe activitat que funciona com una calculadora
 * 
 * @author sergi grau
 * @version 18/11/2012
 * 
 */
public class E04_CalculadoraActivity extends Activity implements View.OnClickListener {

	private TextView resultats;
	private double primerOperand;

	private int[] botons = { R.id.boto0, R.id.boto1, R.id.boto2,
			R.id.boto3, R.id.boto4, R.id.boto5, R.id.boto6, R.id.boto7,
			R.id.boto8, R.id.boto9 , R.id.suma, R.id.resta, R.id.producte,
			R.id.divisio, R.id.operacio};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e04_activity_calculadora);

		resultats = (TextView) findViewById(R.id.resultats);
		for (int i : botons) {
			((Button) findViewById(i)).setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.suma:
			primerOperand= Double.parseDouble(resultats.getText().toString());
			resultats.setText(resultats.getText() + "+");
			break;
		case R.id.resta:
			resultats.setText(resultats.getText() + "-");
			break;
		case R.id.operacio:
			resultats.setText(resultats.getText() + "=");
			break;
		default:
			resultats.setText(resultats.getText() + ((Button)v).getText().toString());
			//throw new RuntimeException("boto desconegut");

		}

	}
}

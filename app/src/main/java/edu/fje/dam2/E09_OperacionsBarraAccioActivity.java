package edu.fje.dam2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activitat que donats dos nombres permeti realitzar les operacions de suma,
 * resta, producte o divisió, seleccionant-les les opcions de la barra d'acció
 * 
 * @author sergi grau
 * @version 1.0, 1/12/2014
 */
public class E09_OperacionsBarraAccioActivity extends Activity {

	private EditText numero1;
	private EditText numero2;
	private TextView resultat;
	private String operacio;
	private double res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.e09_activity_opcions);

		numero1 = (EditText) findViewById(R.id.numero1);
		numero2 = (EditText) findViewById(R.id.numero2);
		resultat = (TextView) findViewById(R.id.resultat);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_opcions, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.suma:
			res = Double.parseDouble(numero1.getText().toString())
					+ Double.parseDouble(numero2.getText().toString());
			operacio = "suma";
			resultat.setText(operacio + " " + String.valueOf(res));

			return true;
		case R.id.resta:
			res = Double.parseDouble(numero1.getText().toString())
					- Double.parseDouble(numero2.getText().toString());
			operacio = "resta";
			resultat.setText(operacio + " " + String.valueOf(res));

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
}

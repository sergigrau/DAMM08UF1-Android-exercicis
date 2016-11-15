package edu.fje.dam2;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;

/**
 * Classe activitat 5. Crea una Activitat que faci ús del IME. Concretament ha
 * de mostrar un TableLayout dins d'un ScrollView per a d'introducció de les
 * dades relatives a una Persona.
 * 
 * @author sergi grau
 * @version 18/11/2012
 * 
 */
public class E05_PersonaActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e05_activity_persona);

	}

	@Override
	public void onClick(View v) {

	}
}

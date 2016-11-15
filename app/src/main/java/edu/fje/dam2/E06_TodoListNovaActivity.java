package edu.fje.dam2;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * Classe Activity que permet la introducció d'una nova activitat
 * 
 * Cal afegir al AndroidManifest l'activitat
 * android:label="@string/result_activity" > </activity>
 * 
 * @author sergi grau
 * @version 1.0, 29/11/2012
 */

public class E06_TodoListNovaActivity extends Activity implements
		View.OnClickListener {

	private EditText nomActivitat;
	private EditText entradaDataHora;
	private Calendar dataHora = Calendar.getInstance();
	private DateFormat formatDataHora = DateFormat.getDateTimeInstance();
	private Button botoCrearActivitat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e06_activity_todolist_nova);

		nomActivitat = (EditText) findViewById(R.id.dataActivitat);

		entradaDataHora = (EditText) findViewById(R.id.dataActivitat);
		entradaDataHora.setOnClickListener(this);

		botoCrearActivitat = (Button) findViewById(R.id.botoCrearActivitat);
		botoCrearActivitat.setOnClickListener(this);

		// Bundle b = getIntent().getExtras();
		// String[] resultArr = b.getStringArray("itemsSeleccionats");
		// ListView lv = (ListView) findViewById(R.id.llistaResultats);

		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, resultArr);
		// lv.setAdapter(adapter);

	}

	/**
	 * Objecte Listener
	 */
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			dataHora.set(Calendar.YEAR, year);
			dataHora.set(Calendar.MONTH, monthOfYear);
			dataHora.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			entradaDataHora.setText(formatDataHora.format(dataHora.getTime()));
		}
	};

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.dataActivitat) {
			new DatePickerDialog(this, d, dataHora.get(Calendar.YEAR),
					dataHora.get(Calendar.MONTH),
					dataHora.get(Calendar.DAY_OF_MONTH)).show();
		}
		if (v.getId() == R.id.botoCrearActivitat) {
			E06_TodoListActivitat activitat = new E06_TodoListActivitat(nomActivitat
					.getText().toString(), dataHora.getTime());
			Log.v("activitat", activitat.toString());

			Intent intent = new Intent(getApplicationContext(),
					E06_TodoListActivity.class);

			intent.putExtra("edu.fje.dam2.E06_TodoListActivitat", activitat);
			startActivity(intent);

		}
	}
}

package edu.fje.dam2;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Classe que hereta de la classe ListActivity i que mostra les tasques d'un
 * TODOLIST
 * 
 * @author sergi grau
 * @version 1.0, 29/11/2012
 */
public class E06_TodoListActivity extends Activity implements View.OnClickListener {

	private ListView llista;
	private Button botoCrearActivitat;

	private static ArrayList<String> items = new ArrayList<>();
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.e06_activity_todolist);
		llista = (ListView) findViewById(R.id.llistaActivitats);
		botoCrearActivitat = (Button) findViewById(R.id.botoCrearActivitat);
		botoCrearActivitat.setOnClickListener(this);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_single_choice);

		adapter.add(new E06_TodoListActivitat("avui", new Date()).toString());

		llista.setAdapter(adapter);

	}

	@Override
	protected void onResume() {
		Log.v("resume", "resume");
		super.onResume();
		Intent i = getIntent();
		E06_TodoListActivitat activitat = null;
		if (i.getExtras() != null)
			activitat = (E06_TodoListActivitat) i.getExtras().getParcelable(
					"edu.fje.dam2.E06_TodoListActivitat");
		if (activitat != null) {
			Log.v("arribat", activitat.toString());
			adapter.add(activitat.toString());
		}

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.botoCrearActivitat) {

			Intent intent = new Intent(getApplicationContext(),
					E06_TodoListNovaActivity.class);
			onPause();

			startActivity(intent);

		}
	}
}

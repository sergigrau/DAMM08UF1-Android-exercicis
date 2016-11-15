package edu.fje.dam2;

import android.app.ListActivity;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Classe que accedeix a la base de dades SQlite
 * i mostra les dades en una llista
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 9.11.2015
 *
 */
public class E08_BaseDadesLlista extends ListActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlumneDBUtilitat utilitatDB = new AlumneDBUtilitat(getBaseContext());

        // seleccionem les date per a poder escriure
        SQLiteDatabase db = utilitatDB.getWritableDatabase();
        db.delete(TaulaAlumne.NOM_TAULA, null, null);

        // creem un mapa de valors on les columnes són les claus
        ContentValues valors = new ContentValues();
        valors.put(TaulaAlumne.COLUMNA_CODI, "1");
        valors.put(TaulaAlumne.COLUMNA_NOM, "joan");
        valors.put(TaulaAlumne.COLUMNA_NOTA, 8);

         db.insert(TaulaAlumne.NOM_TAULA,
                 TaulaAlumne.COLUMNA_NULL, valors);
        valors = new ContentValues();
        valors.put(TaulaAlumne.COLUMNA_CODI, "2");
        valors.put(TaulaAlumne.COLUMNA_NOM, "sergi");
        valors.put(TaulaAlumne.COLUMNA_NOTA, 7);

        db.insert(TaulaAlumne.NOM_TAULA,
                TaulaAlumne.COLUMNA_NULL, valors);
        valors = new ContentValues();
        valors.put(TaulaAlumne.COLUMNA_CODI, "3");
        valors.put(TaulaAlumne.COLUMNA_NOM, "anna");
        valors.put(TaulaAlumne.COLUMNA_NOTA, 5);

        db.insert(TaulaAlumne.NOM_TAULA,
                TaulaAlumne.COLUMNA_NULL, valors);


        db = utilitatDB.getReadableDatabase();

        String[] projeccio = {
                TaulaAlumne._ID,
                TaulaAlumne.COLUMNA_NOM,
                TaulaAlumne.COLUMNA_NOTA
        };

        String seleccio ="nota >= ?";
        String[] seleccioArgs = {"5"};
        String ordre =
                TaulaAlumne.COLUMNA_NOM + " DESC";


        Cursor c = db.query(
                TaulaAlumne.NOM_TAULA,  // taula
                projeccio,                               // columnes
                seleccio,                                // columnes WHERE
                seleccioArgs,                            // valors WHERE
                null,                                     // GROUP
                null,                                     // HAVING
                ordre                                 // ordre
        );

        ArrayList<String> llistaNoms =new ArrayList<String>();
        while(c.moveToNext())
        llistaNoms.add(c.getString(
                c.getColumnIndexOrThrow(TaulaAlumne.COLUMNA_NOM)
        ));



        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, llistaNoms);

        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        getListView().setAdapter(adapter);

    }

}

/**
 * Classe Utilitat que defineix el contacte envers la base de dades
 *
 * @author sergi grau
 * @version 1.0 9.11.2015
 *
 */

 class TaulaAlumne implements BaseColumns {
        public static final String NOM_TAULA = "alumne";
        public static final String COLUMNA_CODI = "codi";
        public static final String COLUMNA_NOM = "nom";
        public static final String COLUMNA_NOTA = "nota";
        public static final String COLUMNA_NULL = "null";
}

/**
 * Classe utilitat per a manipulació de la BDs
 *
 * @author sergi grau
 * @version 1.0 09.11.2015
 *
 */
class AlumneDBUtilitat extends SQLiteOpenHelper {
    private static final String TIPUS_TEXT = " TEXT";
    private static final String TIPUS_ENTER = " INT";
    private static final String SEPARADOR_COMA = ",";
    private static final String SQL_CREACIO_TAULA = "CREATE TABLE "
            + TaulaAlumne.NOM_TAULA + " ("
            + TaulaAlumne._ID + " INTEGER PRIMARY KEY,"
            + TaulaAlumne.COLUMNA_CODI + TIPUS_TEXT
            + SEPARADOR_COMA + TaulaAlumne.COLUMNA_NOM
            + TIPUS_TEXT + SEPARADOR_COMA
            + TaulaAlumne.COLUMNA_NOTA + TIPUS_ENTER + " )";

    private static final String SQL_ESBORRAT_TAULA = "DROP TABLE IF EXISTS "
            + TaulaAlumne.NOM_TAULA;

    // Si canviem l'esquema hem de canviar la versió
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Alumne.db";

    public AlumneDBUtilitat(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREACIO_TAULA);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_ESBORRAT_TAULA);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

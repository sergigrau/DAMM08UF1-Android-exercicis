package edu.fje.dam2;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Activitat que recupera tots els contactes que comencen per B
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 17.11.2015
 */
public class E07_AccesContactesActivity extends Activity {

    private ListView llista;
    ArrayList<Persona> llistaContactes = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e07_access_contactes);
        llista = (ListView) findViewById(R.id.llista);

        llista.setAdapter(
                new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, llistaContactes) {
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                        TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                        text1.setText(llistaContactes.get(position).getNom());
                        text2.setText(llistaContactes.get(position).getTelefon());
                        return view;
                    }
                });


        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null,
                ContactsContract.Contacts.DISPLAY_NAME+" LIKE ?",
                new String[]{"J%"}, null);

        while(c.moveToNext()) {
            String nom = c.getString(c.getColumnIndex(PhoneLookup.DISPLAY_NAME));

            String numeroTelf = c
                    .getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
            String contactId = c.getString(c
                    .getColumnIndex(ContactsContract.Contacts._ID));
            if (numeroTelf.equals("1")) {
                Cursor telefons = getContentResolver()
                        .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                        + " = " + contactId, null, null);
                if (telefons.moveToFirst()) {
                    numeroTelf = telefons
                            .getString(telefons
                                    .getColumnIndex(ContactsContract.
                                            CommonDataKinds.Phone.NUMBER));
                }
                telefons.close();
            }
            llistaContactes.add(new Persona(nom, numeroTelf));
        }
    }
}

/**
 * Classe que representa una Persona
 */
class Persona{
    private String nom;
    private String telefon;

    public Persona(String nom, String telefon) {
        this.nom = nom;
        this.telefon = telefon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

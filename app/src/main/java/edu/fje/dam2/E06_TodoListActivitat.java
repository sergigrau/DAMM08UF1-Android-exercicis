package edu.fje.dam2;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * JavaBean d'activitat
 * 
 * @author sergi grau
 * @version 1.0, 29/11/2012
 * 
 */
public class E06_TodoListActivitat implements Parcelable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomActivitat;
	private Date dataActivitat;

	
	
	public E06_TodoListActivitat(String nomActivitat, Date dataActivitat) {
		super();
		this.nomActivitat = nomActivitat;
		this.dataActivitat = dataActivitat;
	}

	public E06_TodoListActivitat(Parcel in) {
        readFromParcel(in);
    }
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public E06_TodoListActivitat createFromParcel(Parcel in) {
            return new E06_TodoListActivitat(in);
        }

        public E06_TodoListActivitat[] newArray(int mida) {
            return new E06_TodoListActivitat[mida];
        }
    };
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nomActivitat);
        dest.writeValue(dataActivitat);
}
    
    private void readFromParcel(Parcel in) {

    	nomActivitat= in.readString();
    	dataActivitat= (Date) in.readValue(E06_TodoListActivitat.class.getClassLoader());

}
    
	public String getNomActivitat() {
		return nomActivitat;
	}

	public void setNomActivitat(String nomActivitat) {
		this.nomActivitat = nomActivitat;
	}

	public Date getDataActivitat() {
		return dataActivitat;
	}

	public void setDataActivitat(Date dataActivitat) {
		this.dataActivitat = dataActivitat;
	}

	@Override
	public String toString() {
		return dataActivitat + "-"+ nomActivitat;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}



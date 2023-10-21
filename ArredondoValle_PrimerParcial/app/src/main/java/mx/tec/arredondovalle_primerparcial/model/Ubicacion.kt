/*

    Made by: Armando Arredondo Valle
    Finished: 10/09/2023 | 10:08 PM

*/

package mx.tec.arredondovalle_primerparcial.model

import android.os.Parcel
import android.os.Parcelable

data class Ubicacion(
    var nombre: String,
    var descripcion: String,
    var estado: String,
    var latitud: Double,
    var longitud: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeString(estado)
        parcel.writeDouble(latitud)
        parcel.writeDouble(longitud)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ubicacion> {
        override fun createFromParcel(parcel: Parcel): Ubicacion {
            return Ubicacion(parcel)
        }

        override fun newArray(size: Int): Array<Ubicacion?> {
            return arrayOfNulls(size)
        }
    }
}

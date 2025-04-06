package tugas.week.myapplication

import android.os.Parcel
import android.os.Parcelable

data class User(val name: String, val email: String, val password: String) : Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readString() ?: ""
            )
        }

        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
}

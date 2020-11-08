package latihan.ihsan.submission1_ihsan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var name: String,
    var username: String,
    var location: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String,
    var profilePict: Int
) :Parcelable
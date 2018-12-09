package zo.den.testtask2.presentation.model

import android.os.Parcelable
import dagger.Provides
import kotlinx.android.parcel.Parcelize
@Parcelize
data class OrderModel (
        val startAddress: String?,
        val endAddress: String?,
        val dateOfOrder: String?,
        val amount: String?,

        val regNumber: String?,
        val modelName: String?,
        val photo: String,
        val driverName: String?
): Parcelable
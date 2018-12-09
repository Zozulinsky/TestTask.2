package zo.den.testtask2.presentation.model

import android.graphics.Bitmap

data class DetailsModel(
        val startAddress: String?,
        val endAddress: String?,
        val dateAndTimeOfOrder: String?,
        val amount: String?,
        val regNumber: String?,
        val modelName: String?,
        val driverName: String?
)

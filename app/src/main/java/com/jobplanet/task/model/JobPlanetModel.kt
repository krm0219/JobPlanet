package com.jobplanet.task.model

import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

data class ItemsModel(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("items") val items: ArrayList<JobPlanetModel>
)

data class JobPlanetModel(
    @SerializedName("cell_type") val cellType: String,
    @SerializedName("name") val name: String?,
    @SerializedName("salary_avg") val salaryAvg: Int?,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("interview_question") val interviewQuestion: String?,
    @SerializedName("company_id") val companyId: Int?,
    @SerializedName("rate_total_avg") val rateTotalAvg: Double?,
    @SerializedName("review_summary") val reviewSummary: String?,
    @SerializedName("industry_name") val industryName: String?,
    @SerializedName("count") val count: Int?,
    @SerializedName("themes") val themes: ArrayList<ThemeModel>?,
    @SerializedName("pros") val pros: String?,
    @SerializedName("cons") val cons: String?
) {

    fun decimalFormat(salary: Int) : String {

        val decimalFormat = DecimalFormat("#,###")
        return decimalFormat.format(salary)
    }
}


data class CompanyModel(
    @SerializedName("cell_type") val cellType: String,
    @SerializedName("name") val name: String,
    @SerializedName("salary_avg") val salaryAvg: Int,
    @SerializedName("logo_path") val logoPath: String,
    @SerializedName("interview_question") val interviewQuestion: String,
    @SerializedName("company_id") val companyId: Int,
    @SerializedName("rate_total_avg") val rateTotalAvg: Double,
    @SerializedName("review_summary") val reviewSummary: String,
    @SerializedName("industry_name") val industryName: String
)

data class HorizontalThemeModel(
    @SerializedName("cell_type") val cellType: String,
    @SerializedName("count") val count: Int,
    @SerializedName("themes") val themes: ArrayList<ThemeModel>
)

data class ThemeModel(
    @SerializedName("cover_image") val coverImage: String,
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String
)

data class ReviewModel(
    @SerializedName("cell_type") val cellType: String,
    @SerializedName("name") val name: String,
    @SerializedName("logo_path") val logoPath: String,
    @SerializedName("pros") val pros: String,
    @SerializedName("cons") val cons: String,
    @SerializedName("company_id") val companyId: String,
    @SerializedName("rate_total_avg") val rateTotalAvg: Double,
    @SerializedName("review_summary") val reviewSummary: String,
    @SerializedName("industry_name") val industryName: String
)
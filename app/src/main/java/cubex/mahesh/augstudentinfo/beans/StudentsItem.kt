package cubex.mahesh.augstudentinfo.beans

import com.google.gson.annotations.SerializedName

data class StudentsItem(@SerializedName("gender")
                        val gender: String = "",
                        @SerializedName("name")
                        val name: String = "",
                        @SerializedName("qual")
                        val qual: String = "",
                        @SerializedName("email")
                        val email: String = "")
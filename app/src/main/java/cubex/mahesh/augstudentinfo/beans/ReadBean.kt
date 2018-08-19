package cubex.mahesh.augstudentinfo.beans

import com.google.gson.annotations.SerializedName

data class ReadBean(@SerializedName("students")
                    val students: List<StudentsItem>?)
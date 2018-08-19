package cubex.mahesh.augstudentinfo

import cubex.mahesh.augstudentinfo.beans.InsertBean
import cubex.mahesh.augstudentinfo.beans.ReadBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentInfoAPI {
    @GET("AugStuInfo/rs/sinfo/insert/{name}/{gender}/{qual}/{email}")
    fun insert(@Path("name") name:String,
               @Path("gender") gender:String,
               @Path("qual") qual:String,
               @Path("email") email:String) : Call<InsertBean>
    @GET("AugStuInfo/rs/sinfo/read")
    fun read( ) : Call<ReadBean>
}
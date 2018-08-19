package cubex.mahesh.augstudentinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.augstudentinfo.beans.InsertBean
import cubex.mahesh.augstudentinfo.beans.ReadBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var r = Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl("http://10.0.0.2:8080/").
                build()
        var api = r.create(StudentInfoAPI::class.java)

       insert.setOnClickListener {
          var call =      api.insert(et1.text.toString(),
                                et2.text.toString(),et3.text.toString(),
                                et4.text.toString())
           call.enqueue(object : Callback<InsertBean> {
               override fun onResponse(call: Call<InsertBean>?,
                                       response: Response<InsertBean>?) {
                 var bean =       response!!.body()
                   Toast.makeText(this@MainActivity,
                           bean!!.status,Toast.LENGTH_LONG).show()
               }
               override fun onFailure(call: Call<InsertBean>?, t: Throwable?) {

               }
           })
       }

        read.setOnClickListener {

            var call =   api.read()
            call.enqueue(object : Callback<ReadBean> {
                override fun onFailure(call: Call<ReadBean>?, t: Throwable?) {
                }
            override fun onResponse(call: Call<ReadBean>?,
                                    response: Response<ReadBean>?) {
                var bean = response!!.body()
                var list = bean!!.students
                var temp_list = mutableListOf<String>()
                for(item in list!!){
                    temp_list.add(item.name+"\t"+item.gender+"\n"+
                        item.qual+"\t"+item.email)
                }
                var myadapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_list_item_single_choice,temp_list)
                lview.adapter = myadapter
                }
})


        }
    }
}

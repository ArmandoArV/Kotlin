package mx.tec.apis

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import mx.tec.apis.databinding.ActivityRetroMainBinding
import mx.tec.apis.model.User
import mx.tec.apis.service.IService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroMain : AppCompatActivity() {
    lateinit var binding: ActivityRetroMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetroMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create<IService>(IService::class.java)
        service.getUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: retrofit2.Call<List<User>>, t: Throwable) {
                Log.e("RESTLIBS", t.message!!)
            }
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = response.body()
                Log.e("RESTLIBS", Gson().toJson(users))
                val datos = mutableListOf<String>()
                for (i in 0..<response.body()!!.size){
                    datos.add(response.body()!!.get(i).name + "\n" + response.body()!!.get(i).address.city + "\n"
                    + response.body()!!.get(i).company.name)
                }
                val adapter = ArrayAdapter(this@RetroMain, R.layout.simple_list_item_1, datos)
                binding.lvInfo.adapter = adapter
            }
        })
    }

}



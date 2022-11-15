package eu.tutorials.sevenminuteworkaut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import eu.tutorials.sevenminuteworkaut.databinding.ActivityHistoryBinding
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val exerciseDao = (application as ExerciseApp).db.exerciseDao()

        setSupportActionBar(binding?.toolbarHistoryActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "History"

        }

        lifecycleScope.launch {
            exerciseDao.fetchAll().collect(){
                val list = ArrayList(it)
                setupListOfDataIntoRecyclerView(list, exerciseDao)
            }
        }


        binding?.toolbarHistoryActivity?.setNavigationOnClickListener{
            onBackPressed()
        }

    }


    private fun setupListOfDataIntoRecyclerView (
        exerciseList: ArrayList<ExerciseEntity>,
        exerciseDao: ExerciseDao) {

        if(exerciseList.isNotEmpty()) {
            val itemAdapter = ItemAdapter(exerciseList)
            binding?.rvItemsList?.layoutManager = LinearLayoutManager(this)
            binding?.rvItemsList?.adapter = itemAdapter
            binding?.rvItemsList?.visibility = View.VISIBLE
            binding?.tvNoRecordsAvailable?.visibility = View.GONE
        } else {
            binding?.rvItemsList?.visibility = View.GONE
            binding?.tvNoRecordsAvailable?.visibility = View.VISIBLE
        }


    }
}
package eu.tutorials.sevenminuteworkaut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import eu.tutorials.sevenminuteworkaut.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch


class FinishActivity : AppCompatActivity() {
    private var binding: ActivityFinishBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val exerciseDao = (application as ExerciseApp).db.exerciseDao()


        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarFinishActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.btnFinish?.setOnClickListener {
            addRecord(exerciseDao)
            finish()
        }
    }

    private fun addRecord(exerciseDao: ExerciseDao) {
        lifecycleScope.launch {
            exerciseDao.insert(ExerciseEntity(date = System.currentTimeMillis()))
        }
    }
}
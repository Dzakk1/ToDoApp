package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var detailTaskViewModel: DetailTaskViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action

        val viewModelFactory = ViewModelFactory.getInstance(this)

        detailTaskViewModel = ViewModelProvider(this, viewModelFactory).get(DetailTaskViewModel::class.java)


        val detailTask = intent.getIntExtra(TASK_ID, 0)

        val taskTitle : TextView = findViewById(R.id.detail_ed_title)
        val taskDescription : TextView = findViewById(R.id.detail_ed_description)
        val taskDate : TextView = findViewById(R.id.detail_ed_due_date)


        detailTaskViewModel.setTaskId(detailTask)


        //  set detail data
        detailTaskViewModel.task.observe(this) {detailData ->
            detailData?.let {
                taskTitle.text = detailData.title
                taskDescription.text = detailData.description
                taskDate.text = DateConverter.convertMillisToString(detailData.dueDateMillis)
            }
        }
        // end set detail

        //delete data
        findViewById<Button>(R.id.btn_delete_task).setOnClickListener {
            detailTaskViewModel.deleteTask()

            finish()
        }
        // end delete data

    }
}
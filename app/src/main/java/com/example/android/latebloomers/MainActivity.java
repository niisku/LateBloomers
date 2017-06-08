package com.example.android.latebloomers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.latebloomers.R.string.results_text;

public class MainActivity extends AppCompatActivity {

    int scores = 0;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Checks the answers of each question, calculates the scores and gives feedback based
    //on the performance
    public void submitScores(View view) {

        //Question 1, Checks if the correct answer is checked
        RadioButton rb1 = (RadioButton) findViewById(R.id.radio_button_q1_correct);
        if (rb1.isChecked()) {
            scores++;
        }

        //Question 2, Checks if the correct answer is checked
        RadioButton rb2 = (RadioButton) findViewById(R.id.radio_button_q2_correct);
        if (rb2.isChecked()) {
            scores = scores + 1;
        }

        //Question 3, Checks if the correct answer is checked
        RadioButton rb3 = (RadioButton) findViewById(R.id.radio_button_q3_correct);
        if (rb3.isChecked()) {
            scores = scores + 1;
        }
        //Question 4, Checks if the correct answer is checked
        RadioButton rb4 = (RadioButton) findViewById(R.id.radio_button_q4_correct);
        if (rb4.isChecked()) {
            scores = scores + 1;
        }
        //Question 5, Checks if the correct answer is checked
        RadioButton rb5 = (RadioButton) findViewById(R.id.radio_button_q5_correct);
        if (rb5.isChecked()) {
            scores = scores + 1;
        }

        //Question 6; Get point if both the correct (1 and 2) checkboxes are checked
        CheckBox checkBox_1 = (CheckBox) findViewById(R.id.checkbox_correct1);
        CheckBox checkBox_2 = (CheckBox) findViewById(R.id.checkbox_correct2);

        if (checkBox_1.isChecked() && checkBox_2.isChecked()) {
            scores = scores + 1;

        }

        //Question 7, Checks if the correct answer is inputted
        EditText q7_input_answer = (EditText) findViewById(R.id.editable_q7);
        String q7 = q7_input_answer.getText().toString();

        if (q7.equalsIgnoreCase("kfc")) {
            scores = scores + 1;
        }

        //Shows the feedback message
        displayMessage(message);
    }

    // Shows the correct feedback message based on the correct answers
    public void displayMessage(String message) {
        TextView resultArea = (TextView) findViewById(R.id.results_text_view);

        if (scores == 7) {
            message = "Amazing! You knew all the answers! \nYou see, nothing is impossible! \nPress 'Reset' button to play again!";
            scores = 0;

        } else {
            message = "You scored " + scores + " out of 7. \nUnfortunately some of the answers are incorrect. Keep trying, and maybe someday you will be ON this quiz! \nPress 'Reset' button to play again! ";
            scores = 0;
        }
        resultArea.setText(String.valueOf(message));
    }

    //This resets all the values

    public void resetScores(View view) {
        scores = 0;
        RadioGroup group1 = (RadioGroup) findViewById(R.id.radiogroup_1);
        RadioGroup group2 = (RadioGroup) findViewById(R.id.radiogroup_2);
        RadioGroup group3 = (RadioGroup) findViewById(R.id.radiogroup_3);
        RadioGroup group4 = (RadioGroup) findViewById(R.id.radiogroup_4);
        RadioGroup group5 = (RadioGroup) findViewById(R.id.radiogroup_5);

        group1.clearCheck();
        group2.clearCheck();
        group3.clearCheck();
        group4.clearCheck();
        group5.clearCheck();

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_correct1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_correct2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_3);

        if (checkBox1.isChecked()) {
            checkBox1.setChecked(false);
        }
        if (checkBox2.isChecked()) {
            checkBox2.setChecked(false);
        }
        if (checkBox3.isChecked()) {
            checkBox3.setChecked(false);
        }

        EditText q7_input_answer = (EditText) findViewById(R.id.editable_q7);
        q7_input_answer.getText().clear();

        TextView results_text_bottom = (TextView) findViewById(R.id.results_text_view);
        results_text_bottom.setText(results_text);

        Toast.makeText(this, "Note! All the scores are now set to 0! ", Toast.LENGTH_SHORT).show();

    }
}





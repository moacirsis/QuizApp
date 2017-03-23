package com.example.pichau.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int quizScore = 0;
    private EditText editTextQ1;
    private RadioButton q2;
    private EditText editTextQ4;
    private CheckBox q6cB1;
    private CheckBox q6cB2;
    private CheckBox q6cB3;
    private CheckBox q6cB4;
    private RadioButton q8;
    private CheckBox q9cB1;
    private CheckBox q9cB2;
    private CheckBox q9cB3;
    private CheckBox q9cB4;
    private EditText editTextQ10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextQ1 = (EditText) findViewById(R.id.q_1_responda_edit_text);
        q2 = (RadioButton) findViewById(R.id.q_2_radio_button_1);
        editTextQ4 = (EditText) findViewById(R.id.q_4_answer_edit_text);
        q6cB1 = (CheckBox) findViewById(R.id.q_6_check_box_1);
        q6cB2 = (CheckBox) findViewById(R.id.q_6_check_box_2);
        q6cB3 = (CheckBox) findViewById(R.id.q_6_check_box_3);
        q6cB4 = (CheckBox) findViewById(R.id.q_6_check_box_4);
        q8 = (RadioButton) findViewById(R.id.q_8_radio_button_3);
        q9cB1 = (CheckBox) findViewById(R.id.q_9_check_box_1);
        q9cB2 = (CheckBox) findViewById(R.id.q_9_check_box_2);
        q9cB3 = (CheckBox) findViewById(R.id.q_9_check_box_3);
        q9cB4 = (CheckBox) findViewById(R.id.q_9_check_box_4);
        editTextQ10 = (EditText) findViewById(R.id.q_10_responda_edit_text);
    }

    // pontuação para questão
    public void pontuacaoQuestoes() {

        // questao 1
        String q1 = editTextQ1.getText().toString().toUpperCase();
        String q1Responda = "china";
        scoreEditTextQuestao(q1, q1Responda);

        // questao 2
        scoreRadioButtonQuestao(q2);



        //  Questao 4
        String q4 = editTextQ4.getText().toString();
        String q4Responda = "indíos";
        scoreEditTextQuestao(q4, q4Responda);


        //  Questao 6
        int q6Id = 6;
        scoreCheckBoxQuestao(q6Id);


        // Questao 8
        scoreRadioButtonQuestao(q8);

        //  Questao 9
        int q9Id = 9;
        scoreCheckBoxQuestao(q9Id);

        // For Questao 10
        String q10 = editTextQ10.getText().toString();
        String q10Responda = " reciclagem";
        scoreEditTextQuestao(q10, q10Responda);
    }

    // pontuação EditText  questao
    public int scoreEditTextQuestao(String a, String b) {
        if (a.equals(b)) {
            quizScore++;
        }
        return quizScore;
    }

    // Score RadioButton view questao
    public int scoreRadioButtonQuestao(RadioButton rB) {
        if (rB.isChecked()) {
            quizScore++;
        }
        return quizScore;
    }

    public int scoreCheckBoxQuestao(int checkBoxId) {
        switch (checkBoxId) {


            case 6:
                final boolean q6cB1Checked = q6cB1.isChecked();
                final boolean q6cB2Checked = q6cB2.isChecked();
                final boolean q6cB3Checked = q6cB3.isChecked();
                final boolean q6cB4Checked = q6cB4.isChecked();

                if ((q6cB2Checked && q6cB4Checked) && !(q6cB1Checked || q6cB3Checked)) {
                    quizScore++;
                }
                break;

            case 9:
                final boolean q9cB1Checked = q9cB1.isChecked();
                final boolean q9cB2Checked = q9cB2.isChecked();
                final boolean q9cB3Checked = q9cB3.isChecked();
                final boolean q9cB4Checked = q9cB4.isChecked();

                if ((q9cB1Checked && q9cB2Checked && q9cB3Checked) && !q9cB4Checked) {
                    quizScore++;
                }
                break;
        }
        return quizScore;
    }

    // Exibir pontuação final com base no número de perguntas corretas
    public void displayScore(View v) {
        pontuacaoQuestoes();
        Toast.makeText(getApplicationContext(), getString(R.string.quiz_score_toast) + quizScore, Toast.LENGTH_SHORT).show();
        quizScore = 0;
    }
}

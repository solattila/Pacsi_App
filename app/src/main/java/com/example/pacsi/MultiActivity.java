package com.example.pacsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog;
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialogListener;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class MultiActivity extends AppCompatActivity {

    private final String SCORE_KEY = "SCORE";
    private final String INDEX_KEY = "INDEX";


    private TextView mTxtQuestion;

    private ImageView mImageView;




    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;

    private boolean isAnswer1;
    private boolean isAnswer2;
    private boolean isAnswer3;
    private boolean isAnswer4;


    private int mQuestionIndex;
    private int mQuizScore;
    private ProgressBar mProgressBar;

    private boolean isAnswer;


    // Array with the Questionmodel class objects
    private QuestionModel[] questionCollection = new QuestionModel[]{

            new QuestionModel(R.string.q1, R.string.q1a1, false,
                    R.string.q1a2, true, R.string.q1a3, false,
                    R.string.q1a4, false, R.drawable.q1image, new int[]{}),

            new QuestionModel(R.string.q2, R.string.q2a1, false,
                    R.string.q2a2, false, R.string.q2a3, true,
                    R.string.q2a4, false, R.drawable.q2image, new int[]{}),

            new QuestionModel(R.string.q3, R.string.q3a1, false,
                    R.string.q3a2, false, R.string.q3a3, true,
                    R.string.q3a4, false, R.drawable.q3image, new int[]{}),

            new QuestionModel(R.string.q4, R.string.q4a1, true,
                    R.string.q4a2, false, R.string.q4a3, false,
                    R.string.q4a4, false, R.drawable.q4image, new int[]{}),

            new QuestionModel(R.string.q5, R.string.q5a1, true,
                    R.string.q5a2, false, R.string.q5a3, false,
                    R.string.q5a4, false, R.drawable.q5image, new int[]{}),

            new QuestionModel(R.string.q6, R.string.q6a1, false,
                    R.string.q6a2, false, R.string.q6a3, true,
                    R.string.q6a4, false, R.drawable.q6image, new int[]{}),

            new QuestionModel(R.string.q7, R.string.q7a1, false,
                    R.string.q7a2, false, R.string.q7a3, false,
                    R.string.q7a4, true, R.drawable.q7image, new int[]{}),

            new QuestionModel(R.string.q8, R.string.q8a1, false,
                    R.string.q8a2, true, R.string.q8a3, false,
                    R.string.q8a4, false, R.drawable.q8image, new int[]{}),

            new QuestionModel(R.string.q9, R.string.q9a1, false,
                    R.string.q9a2, false, R.string.q9a3, true,
                    R.string.q9a4, false, R.drawable.q9image, new int[]{}),

            new QuestionModel(R.string.q10, R.string.q10a1, true,
                    R.string.q10a2, false, R.string.q10a3, false,
                    R.string.q10a4, false, R.drawable.q10image, new int[]{}),

            new QuestionModel(R.string.q11, R.string.q11a1, false,
                    R.string.q11a2, false, R.string.q11a3, true,
                    R.string.q11a4, false, R.drawable.q11image, new int[]{}),

            new QuestionModel(R.string.q12, R.string.q12a1, true,
                    R.string.q12a2, false, R.string.q12a3, false,
                    R.string.q12a4, false, R.drawable.q12image, new int[]{}),

            new QuestionModel(R.string.q13, R.string.q13a1, false,
                    R.string.q13a2, true, R.string.q13a3, false,
                    R.string.q13a4, false, R.drawable.q13image, new int[]{}),

            new QuestionModel(R.string.q14, R.string.q14a1, false,
                    R.string.q14a2, false, R.string.q14a3, true,
                    R.string.q14a4, false, R.drawable.q14image, new int[]{}),

            new QuestionModel(R.string.q15, R.string.q15a1, false,
                    R.string.q15a2, false, R.string.q15a3, true,
                    R.string.q15a4, false, R.drawable.q15image, new int[]{}),

            new QuestionModel(R.string.q16, R.string.q16a1, false,
                    R.string.q16a2,false, R.string.q16a3, true,
                    R.string.q16a4, false, R.drawable.q16image, new int[]{}),

            new QuestionModel(R.string.q17, R.string.q17a1, true,
                    R.string.q17a2, false, R.string.q17a3, false,
                    R.string.q17a4, false, R.drawable.q17image, new int[]{}),

            new QuestionModel(R.string.q18, R.string.q18a1, false,
                    R.string.q18a2, true, R.string.q18a3, false,
                    R.string.q18a4, false, R.drawable.q18image, new int[]{}),

            new QuestionModel(R.string.q19, R.string.q19a1, false,
                    R.string.q19a2, false, R.string.q19a3, false,
                    R.string.q19a4, true, R.drawable.q19image, new int[]{}),

            new QuestionModel(R.string.q20, R.string.q20a1, false,
                    R.string.q20a2, false, R.string.q20a3, true,
                    R.string.q20a4, false, R.drawable.q20image, new int[]{})

    };

    final int USER_PROGRESS = (int) Math.ceil(100.0 / questionCollection.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            mQuizScore = savedInstanceState.getInt(SCORE_KEY);
            mQuestionIndex = savedInstanceState.getInt(INDEX_KEY);

        }else{
            mQuizScore = 0;
            mQuestionIndex = 0;
        }

        mTxtQuestion = findViewById(R.id.textView);
        mTxtQuestion.setTextSize(20f);

        mImageView = findViewById(R.id.imageView);



        btnAnswer1 = findViewById(R.id.btnSingleMain);
        btnAnswer2 = findViewById(R.id.btnMultiMain);
        btnAnswer3 = findViewById(R.id.btnPhotosMain);
        btnAnswer4 = findViewById(R.id.btnInfoMain);

        mProgressBar = findViewById(R.id.progressBar);

        QuestionModel q1 = questionCollection[mQuestionIndex];

        mTxtQuestion.setText(q1.getQuestion());

        mImageView.setImageResource(q1.getQuestionImage());

        btnAnswer1.setText(q1.getAnswer1());
        btnAnswer2.setText(q1.getAnswer2());
        btnAnswer3.setText(q1.getAnswer3());
        btnAnswer4.setText(q1.getAnswer4());






        isAnswer1 = q1.isAnswerBool1();
        isAnswer2 = q1.isAnswerBool2();
        isAnswer3 = q1.isAnswerBool3();
        isAnswer4 = q1.isAnswerBool4();



        PushDownAnim.setPushDownAnimTo( btnAnswer1 ).setScale( PushDownAnim.MODE_STATIC_DP , 2 )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                evaluateUserAnswer(isAnswer1);
                changeQuestionOnButtonClick();


            }
        });

        PushDownAnim.setPushDownAnimTo(btnAnswer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                evaluateUserAnswer(isAnswer2);
                changeQuestionOnButtonClick();

            }
        });

        PushDownAnim.setPushDownAnimTo(btnAnswer3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                evaluateUserAnswer(isAnswer3);
                changeQuestionOnButtonClick();

            }
        });

        PushDownAnim.setPushDownAnimTo(btnAnswer4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                evaluateUserAnswer(isAnswer4);
                changeQuestionOnButtonClick();

            }
        });


    }

    private void evaluateUserAnswer(boolean userGuess){

        if (userGuess){

            mQuizScore++;

        }

    }

    private void changeQuestionOnButtonClick(){

        mQuestionIndex = (mQuestionIndex + 1) % questionCollection.length;

        if (mQuestionIndex == 0){


            new TTFancyGifDialog.Builder(MultiActivity.this)
                    .setTitle("Gratulálok!\n Sikeresen Meghódítottad a Marsot és " + mQuizScore + " pontot gyűjtöttél.")
                    .setPositiveBtnText("Ok")
                    .setPositiveBtnBackground("#22b573")
                    .setGifResource(R.drawable.astronaut)      //pass your gif, png or jpg
                    .isCancellable(true)
                    .OnPositiveClicked(new TTFancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            finish();
                        }
                    })
                    .build();

//            AlertDialog.Builder quizAlert = new AlertDialog.Builder(MultiActivity.this);
//            quizAlert.setCancelable(false);
//            quizAlert.setTitle("Gratulálok! Sikeresen meghódítottad a Marsot.");
//            quizAlert.setMessage("Összesen " + mQuizScore + " kérdésre válaszoltál helyesen.");
//            quizAlert.setPositiveButton("Játék befejezése", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    finish();
//                }
//            });
//            quizAlert.show();
        }

        mTxtQuestion.setText(questionCollection[mQuestionIndex].getQuestion());
        mImageView.setImageResource(questionCollection[mQuestionIndex].getQuestionImage());
        btnAnswer1.setText(questionCollection[mQuestionIndex].getAnswer1());
        btnAnswer2.setText(questionCollection[mQuestionIndex].getAnswer2());
        btnAnswer3.setText(questionCollection[mQuestionIndex].getAnswer3());
        btnAnswer4.setText(questionCollection[mQuestionIndex].getAnswer4());
        isAnswer1 = questionCollection[mQuestionIndex].isAnswerBool1();
        isAnswer2 = questionCollection[mQuestionIndex].isAnswerBool2();
        isAnswer3 = questionCollection[mQuestionIndex].isAnswerBool3();
        isAnswer4 = questionCollection[mQuestionIndex].isAnswerBool4();
        mProgressBar.incrementProgressBy(USER_PROGRESS);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SCORE_KEY, mQuizScore);
        outState.putInt(INDEX_KEY, mQuestionIndex);

    }


}

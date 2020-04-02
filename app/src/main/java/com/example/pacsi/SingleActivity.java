package com.example.pacsi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog;
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialogListener;
import com.prush.typedtextview.TypedTextView;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleActivity extends AppCompatActivity {

    private TypedTextView pdaText;
    private Button imageButton;
    private int messageCounter;

    private ImageView pdaImage;

    private Animation animRobot;

    private final String SCORE_KEY = "SCORE";
    private final String INDEX_KEY = "INDEX";


    private TextView mTxtQuestion;

    private ImageView mImageView;

    private ImageView imgRobot;


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

    private int[] mPdaMessages;

    private boolean isAnswer;


    // Array with the Questionmodel class objects
    private QuestionModel[] questionCollection = new QuestionModel[]{

            new QuestionModel(R.string.q1, R.string.q1a1, false,
                    R.string.q1a2, true, R.string.q1a3, false,
                    R.string.q1a4, false, R.drawable.q1image,
                    new int[]{R.string.pda1_1, R.string.pda1_2, R.string.pda1_3, R.string.pda1_4, R.string.pda1_5}),

            new QuestionModel(R.string.q2, R.string.q2a1, false,
                    R.string.q2a2, false, R.string.q2a3, true,
                    R.string.q2a4, false, R.drawable.q2image,
                    new int[]{R.string.pda2_1, R.string.pda2_2, R.string.pda2_3}),

            new QuestionModel(R.string.q3, R.string.q3a1, false,
                    R.string.q3a2, false, R.string.q3a3, true,
                    R.string.q3a4, false, R.drawable.q3image,
                    new int[]{R.string.pda3_1, R.string.pda3_2, R.string.pda3_3}),

            new QuestionModel(R.string.q4, R.string.q4a1, true,
                    R.string.q4a2, false, R.string.q4a3, false,
                    R.string.q4a4, false, R.drawable.q4image,
                    new int[]{R.string.pda4_1, R.string.pda4_2, R.string.pda4_3, R.string.pda4_4,
                            R.string.pda4_5}),

            new QuestionModel(R.string.q5, R.string.q5a1, true,
                    R.string.q5a2, false, R.string.q5a3, false,
                    R.string.q5a4, false, R.drawable.q5image,
                    new int[]{R.string.pda5_1, R.string.pda5_2, R.string.pda5_3, R.string.pda5_4}),

            new QuestionModel(R.string.q6, R.string.q6a1, false,
                    R.string.q6a2, false, R.string.q6a3, true,
                    R.string.q6a4, false, R.drawable.q6image,
                    new int[]{R.string.pda6_1, R.string.pda6_2, R.string.pda6_3, R.string.pda6_4,
                            R.string.pda6_5}),

            new QuestionModel(R.string.q7, R.string.q7a1, false,
                    R.string.q7a2, false, R.string.q7a3, false,
                    R.string.q7a4, true, R.drawable.q7image,
                    new int[]{R.string.pda7_1, R.string.pda7_2, R.string.pda7_3, R.string.pda7_4}),

            new QuestionModel(R.string.q8, R.string.q8a1, false,
                    R.string.q8a2, true, R.string.q8a3, false,
                    R.string.q8a4, false, R.drawable.q8image,
                    new int[]{R.string.pda8_1, R.string.pda8_2, R.string.pda8_3, R.string.pda8_4}),

            new QuestionModel(R.string.q9, R.string.q9a1, false,
                    R.string.q9a2, false, R.string.q9a3, true,
                    R.string.q9a4, false, R.drawable.q9image,
                    new int[]{R.string.pda9_1, R.string.pda9_2, R.string.pda9_3}),

            new QuestionModel(R.string.q10, R.string.q10a1, true,
                    R.string.q10a2, false, R.string.q10a3, false,
                    R.string.q10a4, false, R.drawable.q10image,
                    new int[]{R.string.pda10_1, R.string.pda10_2, R.string.pda10_3,
                            R.string.pda10_4, R.string.pda10_5}),

            new QuestionModel(R.string.q11, R.string.q11a1, false,
                    R.string.q11a2, false, R.string.q11a3, true,
                    R.string.q11a4, false, R.drawable.q11image,
                    new int[]{R.string.pda11_1, R.string.pda11_2, R.string.pda11_3, R.string.pda11_4}),

            new QuestionModel(R.string.q12, R.string.q12a1, true,
                    R.string.q12a2, false, R.string.q12a3, false,
                    R.string.q12a4, false, R.drawable.q12image,
                    new int[]{R.string.pda12_1, R.string.pda12_2, R.string.pda12_3}),

            new QuestionModel(R.string.q13, R.string.q13a1, false,
                    R.string.q13a2, true, R.string.q13a3, false,
                    R.string.q13a4, false, R.drawable.q13image,
                    new int[]{R.string.pda13_1, R.string.pda13_2, R.string.pda13_3}),

            new QuestionModel(R.string.q14, R.string.q14a1, false,
                    R.string.q14a2, false, R.string.q14a3, true,
                    R.string.q14a4, false, R.drawable.q14image,
                    new int[]{R.string.pda14_1, R.string.pda14_2}),

            new QuestionModel(R.string.q15, R.string.q15a1, false,
                    R.string.q15a2, false, R.string.q15a3, true,
                    R.string.q15a4, false, R.drawable.q15image,
                    new int[]{R.string.pda15_1, R.string.pda15_2, R.string.pda15_3}),

            new QuestionModel(R.string.q16, R.string.q16a1, false,
                    R.string.q16a2,false, R.string.q16a3, true,
                    R.string.q16a4, false, R.drawable.q16image,
                    new int[]{R.string.pda16_1, R.string.pda16_2, R.string.pda16_3, R.string.pda16_4}),

            new QuestionModel(R.string.q17, R.string.q17a1, true,
                    R.string.q17a2, false, R.string.q17a3, false,
                    R.string.q17a4, false, R.drawable.q17image,
                    new int[]{R.string.pda17_1, R.string.pda17_2}),

            new QuestionModel(R.string.q18, R.string.q18a1, false,
                    R.string.q18a2, true, R.string.q18a3, false,
                    R.string.q18a4, false, R.drawable.q18image,
                    new int[]{R.string.pda18_1, R.string.pda18_2, R.string.pda18_3}),

            new QuestionModel(R.string.q19, R.string.q19a1, false,
                    R.string.q19a2, false, R.string.q19a3, false,
                    R.string.q19a4, true, R.drawable.q19image,
                    new int[]{R.string.pda19_1, R.string.pda19_2}),

            new QuestionModel(R.string.q20, R.string.q20a1, false,
                    R.string.q20a2, false, R.string.q20a3, true,
                    R.string.q20a4, false, R.drawable.q20image,
                    new int[]{R.string.pda20_1, R.string.pda20_2, R.string.pda20_3, R.string.pda20_4})

    };

    final int USER_PROGRESS = (int) Math.ceil(100.0 / questionCollection.length);
    final TypedTextView.Builder builder = new TypedTextView.Builder(pdaText);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        imageButton = findViewById(R.id.imageButton);

        pdaImage = findViewById(R.id.pdaImage);

        pdaText = findViewById(R.id.pdaText);





        mTxtQuestion = findViewById(R.id.textView);
        mTxtQuestion.setTextSize(20f);
        mTxtQuestion.setScaleX(0f);
        mTxtQuestion.setScaleY(0f);

        mImageView = findViewById(R.id.imageView);

        btnAnswer1 = findViewById(R.id.btnSingleMain);
        btnAnswer2 = findViewById(R.id.btnMultiMain);
        btnAnswer3 = findViewById(R.id.btnPhotosMain);
        btnAnswer4 = findViewById(R.id.btnInfoMain);

        btnAnswer1.setTranslationX(1500);
        btnAnswer2.setTranslationX(-1500);
        btnAnswer3.setTranslationX(1500);
        btnAnswer4.setTranslationX(-1500);

        mProgressBar = findViewById(R.id.progressBar);

        QuestionModel q1 = questionCollection[mQuestionIndex];

        mTxtQuestion.setText(q1.getQuestion());

        mImageView.setImageResource(q1.getQuestionImage());

        imgRobot = findViewById(R.id.imgRobot);
        animRobot = AnimationUtils.loadAnimation(this, R.anim.myanim);

        btnAnswer1.setText(q1.getAnswer1());
        btnAnswer2.setText(q1.getAnswer2());
        btnAnswer3.setText(q1.getAnswer3());
        btnAnswer4.setText(q1.getAnswer4());

        pdaText.setTypedText(q1.getPdaMess()[messageCounter]);

        builder.build();






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



                    }
                });

        PushDownAnim.setPushDownAnimTo(btnAnswer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                evaluateUserAnswer(isAnswer2);


            }
        });

        PushDownAnim.setPushDownAnimTo(btnAnswer3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                evaluateUserAnswer(isAnswer3);


            }
        });

        PushDownAnim.setPushDownAnimTo(btnAnswer4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                evaluateUserAnswer(isAnswer4);


            }
        });



//        pdaText = builder.build();

//        pdaText.setTypedText(R.string.q1);

//        pdaText = builder.build();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageCounter++;
                if (messageCounter < questionCollection[mQuestionIndex].getPdaMess().length) {
                    pdaText.setTypedText(questionCollection[mQuestionIndex].getPdaMess()[messageCounter]);

                    builder.build();

                    imgRobot.startAnimation(animRobot);

//                    if (messageCounter % 2 == 1) {
//
//                        imgRobot.animate().rotationBy(720).setDuration(1000);
//                    }else {
//                        imgRobot.animate().translationYBy(50).setDuration(100);
//
//                    }




                }else {

                    btnON();
                    changeQuestionOnButtonClick();




                }
            }
        });

    }

    public void pdaOn(){

        pdaImage.animate().translationYBy(-2500).setDuration(1500);
        pdaText.animate().translationYBy(-2500).setDuration(1500);
        imageButton.animate().translationYBy(-2500).setDuration(1500);
        imgRobot.animate().translationYBy(1500).setDuration(1500);

        mTxtQuestion.animate().scaleX(0f).scaleY(0f).setDuration(1500);

        btnAnswer1.animate().translationXBy(1500).setDuration(1500);
        btnAnswer2.animate().translationXBy(-1500).setDuration(1500);
        btnAnswer3.animate().translationXBy(1500).setDuration(1500);
        btnAnswer4.animate().translationXBy(-1500).setDuration(1500);

    }

    public void btnON(){

        pdaImage.animate().translationYBy(2500).setDuration(1500);
        pdaText.animate().translationYBy(2500).setDuration(1500);
        imageButton.animate().translationYBy(2500).setDuration(1500);
        imgRobot.animate().translationYBy(-1500).setDuration(1500);

        mTxtQuestion.animate().scaleX(1f).scaleY(1f).setDuration(1500);

        btnAnswer1.animate().translationXBy(-1500).setDuration(1500);
        btnAnswer2.animate().translationXBy(1500).setDuration(1500);
        btnAnswer3.animate().translationXBy(-1500).setDuration(1500);
        btnAnswer4.animate().translationXBy(1500).setDuration(1500);

    }

    private void evaluateUserAnswer(boolean userGuess){

        if (userGuess){


            mQuestionIndex++;


            if (mQuestionIndex == questionCollection.length){

                new TTFancyGifDialog.Builder(SingleActivity.this)
                        .setTitle("Gratulálok!\n Sikeresen Meghódítottad a Marsot!\nKöszönöm, hogy velem tartottál a küldetésben.")
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
            }else {
            pdaOn();
            messageCounter = 0;

            pdaText.setTypedText(questionCollection[mQuestionIndex].getPdaMess()[messageCounter]);

            builder.build();
            }
            mProgressBar.incrementProgressBy(USER_PROGRESS);

        }else {
            FancyToast.makeText(SingleActivity.this,"Ezen még egy kicsit gondolkodjunk",
                    FancyToast.LENGTH_SHORT, FancyToast.ERROR,true).show();
        }

    }

    private void changeQuestionOnButtonClick(){





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


    }



}

package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;

    private Story current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildStoryLine();

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        render();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = current.getFirstStoryLine();
                render();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = current.getSecondStoryLine();
                render();
            }
        });

    }

    private void render() {
        mStoryTextView.setText(current.getStory());
        if (current.hasFirstChoice())
            mButtonTop.setText(current.getFirstChoice());
        else
            mButtonTop.setVisibility(View.INVISIBLE);
        if (current.hasSecondChoice())
            mButtonBottom.setText(current.getSecondChoice());
        else
            mButtonBottom.setVisibility(View.INVISIBLE);
    }

    private void buildStoryLine() {
        Story t1, t2, t3, t4, t5, t6;

        t1 = new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);
        t2 = new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
        t3 = new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
        t4 = new Story(R.string.T4_End);
        t5 = new Story(R.string.T5_End);
        t6 = new Story(R.string.T6_End);

        t1.setFirstStoryLine(t3).setSecondStoryLine(t2);
        t3.setFirstStoryLine(t6).setSecondStoryLine(t5);
        t2.setFirstStoryLine(t3).setSecondStoryLine(t4);

        current = t1;
    }
}

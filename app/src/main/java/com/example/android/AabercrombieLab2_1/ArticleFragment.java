/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.AabercrombieLab2_1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArticleFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    ArrayList<Ipsum> mArticles;
    private Button mCancelBtn;
    private Button mSaveBtn;
    private String sCancelText;
    private String sSaveText;
    private EditText article;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.article_view, container, false);
        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

//        mCurrentPosition = IpsumSingleton.get(getActivity()).getmPosition();

        mArticles = IpsumSingleton.get(getActivity()).getIpsumArrayList();



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
       /* Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentPosition);
        } */

        mCurrentPosition = IpsumSingleton.get(getActivity()).getmPosition();
        updateArticleView(mCurrentPosition);
    }

    public void updateArticleView(int position) {

        article = (EditText) getActivity().findViewById(R.id.article);
        mCancelBtn = (Button) getActivity().findViewById(R.id.cancelBtn);
        mSaveBtn = (Button) getActivity().findViewById(R.id.saveBtn);

        String stringTest = mArticles.get(position).getmArticle();
        article.setText(stringTest);
        mCurrentPosition = position;

        mCancelBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                sCancelText = mArticles.get(mCurrentPosition).getmArticle();
                article.setText(sCancelText);

            }
        });

        mSaveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Ipsum ipsum = IpsumSingleton.get(getActivity()).getIpsumArrayList().get(mCurrentPosition);
                sSaveText = article.getText().toString();
                ipsum.setmArticle(sSaveText);
                Toast.makeText(getActivity(), "Your changes have been saved",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

    public void onBackPressed() {
        Ipsum ipsum = IpsumSingleton.get(getActivity()).getIpsumArrayList().get(mCurrentPosition);
        sSaveText = article.getText().toString();
        ipsum.setmArticle(sSaveText);
    }
}
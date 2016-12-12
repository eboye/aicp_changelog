package com.srbodroid.aicpchangelog;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeLog extends PreferenceFragment {

    private static final String CHANGELOG_PATH = "/system/etc/Changelog.txt";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InputStreamReader inputReader = null;
        String text = null;
        StringBuilder data = new StringBuilder();
        Pattern commit = Pattern.compile("([a-f0-9]{7})\\s\\s(.*)\\s\\s\\[(.*)\\]"); //(?dms)
        Pattern title = Pattern.compile("\\s+\\*\\s(([\\w_\\-]+/)+)");
        Pattern date = Pattern.compile("(\\d\\d\\-\\d\\d\\-\\d{4})");
        try {
            char tmp[] = new char[2048];
            int numRead;

            inputReader = new FileReader(CHANGELOG_PATH);
            while ((numRead = inputReader.read(tmp)) >= 0) {
                data.append(tmp, 0, numRead);
            }
            //text = data.toString();
        } catch (IOException e) {
            //text = getString(R.string.changelog_error);
        } finally {
            try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (IOException ignored) {
            }
        }
        SpannableStringBuilder sb = new SpannableStringBuilder(data);
        Matcher m = commit.matcher(data);
        while (m.find()) {
            sb.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), m.start(1), m.end(1), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            sb.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), m.start(1), m.end(1), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            sb.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), m.start(3), m.end(3), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        m = title.matcher(data);
        while (m.find()) {
            sb.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), m.start(1), m.end(1), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            sb.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), m.start(1), m.end(1), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        m = date.matcher(data);
        while (m.find()) {
            sb.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), m.start(1), m.end(1), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        final TextView textView = new TextView(getActivity());
        textView.setText(sb);
        textView.setTextColor(Color.rgb(255, 255, 255));

//        final ScrollView scrollView = new ScrollView(getActivity());
//        scrollView.addView(textView);

        return textView;
    }
}
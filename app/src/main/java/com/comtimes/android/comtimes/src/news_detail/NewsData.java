package com.comtimes.android.comtimes.src.news_detail;

import java.util.ArrayList;

public class NewsData {
    private String title, subTitle, reporter, date, clip, comment;
    private int reporterProfile;
    private ArrayList<String> contents, photographers, editors;

    public NewsData(String title, String subTitle, String reporter, String date, String clip, String comment, int reporterProfile, ArrayList<String> contents, ArrayList<String> photographers, ArrayList<String> editors) {
        this.title = title;
        this.subTitle = subTitle;
        this.reporter = reporter;
        this.date = date;
        this.clip = clip;
        this.comment = comment;
        this.reporterProfile = reporterProfile;
        this.contents = contents;
        this.photographers = photographers;
        this.editors = editors;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getReporter() {
        return reporter;
    }

    public String getDate() {
        return date;
    }

    public String getClip() {
        return clip;
    }

    public String getComment() {
        return comment;
    }

    public int getReporterProfile() {
        return reporterProfile;
    }

    public ArrayList<String> getContents() {
        return contents;
    }
}

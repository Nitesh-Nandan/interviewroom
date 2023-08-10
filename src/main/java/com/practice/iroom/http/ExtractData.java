package com.practice.iroom.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class ArticleData {
    public String title;
    public int numComments;

    public String toString() {
        return "Title:- " + title + " Comments:- " + numComments;
    }
}

public class ExtractData {
    public static String downLoadDataFromUrl(String uname, int page) {
        StringBuilder response = new StringBuilder();
        try {

            URL url = new URL("https://jsonmock.hackerrank.com/api/articles?author=" + uname + "&page=" + page);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            String row;
            while ((row = br.readLine()) != null) {
                response.append(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    public static List<ArticleData> extractAllData(String uname) {
        List<ArticleData> res = new ArrayList<>();
        int page = 1;
        String response = downLoadDataFromUrl(uname, page);
        JsonObject jsonResponse = (JsonObject) JsonParser.parseString(response);
        int totalPage = jsonResponse.get("total_pages").getAsInt();
        while (page <= totalPage) {
            res.addAll(parseJsonToList(response));
            page++;
            response = downLoadDataFromUrl(uname, page);
        }

        return res;
    }

    private static List<ArticleData> parseJsonToList(String response) {
        List<ArticleData> articleData = new ArrayList<>();
        JsonObject jsonResponse = (JsonObject) JsonParser.parseString(response);

        for (JsonElement ele : jsonResponse.getAsJsonArray("data")) {
            JsonObject obj = ele.getAsJsonObject();
            String title = String.valueOf(obj.get("title"));
            String numComments = String.valueOf(obj.get("num_comments"));

            ArticleData article = new ArticleData();
            article.title = title.equals("null") ? "" : title;
            article.numComments = numComments.equals("null") ? 0 : Integer.parseInt(numComments);

            articleData.add(article);
        }

        return articleData;
    }

    public static void main(String[] args) {
        List<ArticleData> articleDatas = extractAllData("replicatorblog");

        for (ArticleData data : articleDatas) {
            System.out.println(data);
        }
    }
}

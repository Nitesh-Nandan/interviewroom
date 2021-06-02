package com.practice.iroom.http;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ArticleData {
    public String title;
    public int numComments;

    public ArticleData(String title, int numComments) {
        this.title = title;
        this.numComments = numComments;
    }

    public String toString() {
        return "Title:- " + title + " Comments:- "  + numComments;
    }
}

public class ExtractData {
    public static Map downLoadDataFromUrl(String uname, int page) {
        Map jsonJavaMap = null;
        try {
            StringBuilder response = new StringBuilder();
            URL url = new URL("https://jsonmock.hackerrank.com/api/articles?author=" + uname + "&page=" + page);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));

            String row;

            while ((row = br.readLine())!=null) {
                response.append(row);
            }

            jsonJavaMap = new Gson().fromJson(response.toString(), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonJavaMap;
    }

    public static List<ArticleData> extractAllData(String uname) {

        List<ArticleData> articleDatas = new ArrayList<>();

        int page = 1;

        try {
            Map jsonJavaObj = downLoadDataFromUrl(uname, page);
            int totalPage = ((Double) jsonJavaObj.get("total_pages")).intValue();
            while (page <= totalPage) {
                List pageData = (List) jsonJavaObj.get("data");
                for (int i=0; i<pageData.size(); i++) {
                    String title = (String) ((Map) pageData.get(i)).get("title");
                    if(null == title) {
                        title = (String) ((Map) pageData.get(i)).get("story_title");
                    }
                    Double numComments = (Double) ((Map) pageData.get(i)).get("num_comments");
                    if(null == numComments) numComments = 0.0;

                    if(null != title) {
                        articleDatas.add(new ArticleData(title, numComments.intValue()));
                    }
                }

                if(++page > totalPage) {
                    break;
                }
                jsonJavaObj = downLoadDataFromUrl(uname,page);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return articleDatas;
    }

    public static void main(String[] args) {
        List<ArticleData> articleDatas = extractAllData("replicatorblog");

        for(ArticleData data : articleDatas) {
            System.out.println(data);
        }

//        articleDatas.sort((a1, a2) -> a2.numComments - a1.numComments);
//
//        for(ArticleData data: articleDatas) {
//            articleList.add(data.title);
//            if(articleList.size() == limit) break;
//        }

    }
}

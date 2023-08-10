package com.practice.iroom.http;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
class BookData {
    private String title;
    private String author;
}

public class HackerRankDemo {

    private static String data = "{\"page\":2,\"per_page\":10,\"total\":41,\"total_pages\":5,\"data\":[{\"title\":\"\",\"url\":\"\",\"author\":\"WisNorCan\",\"num_comments\":null,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":4839436,\"created_at\":1354054386},{\"title\":\"UK votes to leave EU\",\"url\":\"http://www.bbc.co.uk/news/uk-politics-36615028\",\"author\":\"dmmalam\",\"num_comments\":2531,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1466740137},{\"title\":\"Why I Quit Google to Work for Myself\",\"url\":\"https://mtlynch.io/why-i-quit-google/\",\"author\":\"dmmalam\",\"num_comments\":751,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1519828685},{\"title\":\"Lavabit abruptly shuts down\",\"url\":\"http://lavabit.com/\",\"author\":\"dmmalam\",\"num_comments\":643,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1375989154},{\"title\":\"EU approves internet copyright law, including \u2018link tax\u2019 and \u2018upload filter\u2019\",\"url\":\"https://www.theverge.com/2018/9/12/17849868/eu-internet-copyright-reform-article-11-13-approved\",\"author\":\"dmmalam\",\"num_comments\":1010,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1536751541},{\"title\":\"Tim Cook Speaks Up\",\"url\":\"http://www.businessweek.com/articles/2014-10-30/tim-cook-im-proud-to-be-gay\",\"author\":\"replicatorblog\",\"num_comments\":974,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1414667543},{\"title\":\"CIA malware and hacking tools\",\"url\":\"https://wikileaks.org/ciav7p1/\",\"author\":\"replicatorblog\",\"num_comments\":null,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":5536734,\"created_at\":1365743273},{\"title\":\"I Sell Onions on the Internet\",\"url\":\"https://www.deepsouthventures.com/i-sell-onions-on-the-internet/\",\"author\":\"eightturn\",\"num_comments\":435,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1556024424},{\"title\":\"macOS High Sierra: Anyone can login as \u201Croot\u201D with empty password\",\"url\":\"https://twitter.com/lemiorhan/status/935578694541770752\",\"author\":\"vladikoff\",\"num_comments\":813,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1511898070},{\"title\":\"SpaceX\u2019s Falcon Heavy successfully launches\",\"url\":\"https://techcrunch.com/2018/02/06/spacexs-historic-falcon-heavy-successfully-launches/?ncid=rss&utm_source=dlvr.it&utm_medium=twitter\",\"author\":\"mpweiher\",\"num_comments\":872,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1517950635}]}";

    public static void main(String[] args) {
        JsonObject jsonObject = (JsonObject) JsonParser.parseString(data);
        List<BookData> bookDataList = new ArrayList<>();
        for (JsonElement obj : jsonObject.getAsJsonArray("data")) {
            JsonObject jobj = obj.getAsJsonObject();
            bookDataList.add(new BookData(jobj.get("title").getAsString(), jobj.get("author").getAsString()));
        }

        System.out.println(bookDataList);
    }
}

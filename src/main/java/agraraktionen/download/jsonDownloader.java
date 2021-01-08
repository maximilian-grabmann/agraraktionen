package agraraktionen.download;


import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class jsonDownloader {

    public static void main(String[] args) {

        downloader();

    }

    private static void downloader() {
/*        String userJson = "{'Artikelbezeichnung':'Hydraulikpumpe' , 'Hersteller':'keine Angabe','Artikelnummer':'FA205','Kategoriepfad':'Landtechnik>Hydraulikprogramm>Hydraulikpumpen und Zubeh&ouml;r>Zahnradpumpen typenzugeordnet>passend zu Case-IHC','Beschreibungsfeld':'','BildLink':'https://www.faie.at/media/image/b6/05/55/art_pro_fo_mb_205gesamt_200x200.jpg','Deeplink':'https://www.faie.at/landtechnik/hydraulikprogramm/hydraulikpumpen-und-zubehoer/zahnradpumpen-typenzugeordnet/passend-zu-case-ihc/5000205/hydraulikpumpe','Verfuegbarkeit':'lagernd (derzeit bis zu 10 Werktage Lieferzeit)','Bruttopreis':'439,00','Stattpreis':' 509,00','EAN':'','Versandkosten':'0'}";
        Gson gson = new Gson();

        UserSimple userObject = gson.fromJson(userJson, UserSimple.class);
*/
        URL url = null;
        try {
            url = new URL("https://httpbin.org/get?color=red&shape=oval");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            InputStreamReader reader = new InputStreamReader(url.openStream());
            MyDto dto = new Gson().fromJson(reader, MyDto.class);

            System.out.println(dto.headers);
            System.out.println(dto.args);
            System.out.println(dto.origin);
            System.out.println(dto.url);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private class MyDto {
        Map<String, String> headers;
        Map<String, String> args;
        String origin;
        String url;
    }
}

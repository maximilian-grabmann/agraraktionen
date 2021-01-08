package agraraktionen.download;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class csvDownloader {

            public static void main(String args[]) throws IOException {



                CsvMapper csvMapper = new CsvMapper();
                CsvSchema schema = CsvSchema.emptySchema().withHeader();

                ObjectReader oReader = csvMapper.reader(DownloadItem.class).with(schema);
                List<DownloadItem> item = new ArrayList<>();

              //  try (Reader reader = new FileReader("src/main/java/agraraktionen/download/agraraktionen.csv")) {
                try (Reader reader = new FileReader("src/main/java/agraraktionen/download/fileFinished.txt")) {
                    MappingIterator<DownloadItem> mi = oReader.readValues(reader);
                    while (mi.hasNext()) {
                        DownloadItem current = mi.next();
                        item.add(current);
                        System.out.println(current);
                    }
                }

                System.out.println("number of courses into list: " + item.size());
                //System.out.println(courses.get(0).getArtikelbezeichnung());
                //RIGHT FORMAT:
                //artikelbezeichnung,hersteller,artikelnummer,kategoriepfad,beschreibungsfeld,bildlink,deeplink,verfuegbarkeit,bruttopreis,stattpreis,ean,versandkosten
                //Hydraulikpumpe,keineAngabe,FA205,Landtechnik>Hydraulikprogramm>HydraulikpumpenundZubehör>Zahnradpumpentypenzugeordnet>passendzuCase-IHC,,https://www.faie.at/media/image/b6/05/55/art_pro_fo_mb_205gesamt_200x200.jpg,https://www.faie.at/landtechnik/hydraulikprogramm/hydraulikpumpen-und-zubehoer/zahnradpumpen-typenzugeordnet/passend-zu-case-ihc/5000205/hydraulikpumpe,lagernd(derzeitbiszu10WerktageLieferzeit),439,509,0
                //FALSE FORMAT:
                //Artikelbezeichnung;Hersteller;Artikelnummer;Kategoriepfad;Beschreibungsfeld;Bild-Link;Deeplink;Verfuegbarkeit;Bruttopreis;Stattpreis;EAN;Versandkosten;
                //"Hydraulikpumpe";"keine Angabe";"FA205";"Landtechnik>Hydraulikprogramm>Hydraulikpumpen und Zubehör>Zahnradpumpen typenzugeordnet>passend zu Case-IHC";"";https://www.faie.at/media/image/b6/05/55/art_pro_fo_mb_205gesamt_200x200.jpg;"https://www.faie.at/landtechnik/hydraulikprogramm/hydraulikpumpen-und-zubehoer/zahnradpumpen-typenzugeordnet/passend-zu-case-ihc/5000205/hydraulikpumpe";lagernd (derzeit bis zu 10 Werktage Lieferzeit);439,00; 509,00 ""; 0;

                //CORRECTION OF CSV FILE
            /*    String test = courses.toString();
                String test0 = test.replace(",00","");
                String test1 = test0.replace(";", ",");
                String test2 = test1.replace(" ", "");
                String test3 = test2.replace("Artikelbezeichnung", "artikelbezeichnung");
                String test4 = test3.replace("Hersteller", "hersteller");
                String test5 = test4.replace("Artikelnummer", "artikelnummer");
                String test6 = test5.replace("Kategoriepfad", "kategoriepfad");
                String test7 = test6.replace("Beschreibungsfeld", "beschreibungsfeld");
                String test8 = test7.replace("Bild-Link", "bildlink");
                String test9 = test8.replace("Deeplink", "deeplink");
                String test00 = test9.replace("Verfuegbarkeit", "verfuegbarkeit");
                String test11 = test00.replace("Bruttopreis", "bruttopreis");
                String test22 = test11.replace("Stattpreis", "stattpreis");
                String test33= test22.replace("EAN", "ean");
                String test44 = test33.replace("Versandkosten,", "versandkosten");
            */

             //   System.out.println(test44);
             //   readUrlAndWriteToTxtFile();
              //  readTxtFile();
            }

    private static void readUrlAndWriteToTxtFile() throws IOException {
        URL url = new URL("https://www.faie.at/backend/export/index/agraraktionen.csv?feedID=68&hash=1bfdc5718d84ebfd191e9ee6617a7764");
        FileWriter fw = new FileWriter("src/main/java/agraraktionen/download/file.csv");
        BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String i;
        while ((i = read.readLine()) != null){
            System.out.println(i);
            fw.write(i);
        }
        read.close();
        fw.close();
    }

    private static void readTxtFile() throws IOException {

            FileReader fr=new FileReader("src/main/java/agraraktionen/download/file.csv");   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {

                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
                sb.append("\n");
            }
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");

            String test = sb.toString();
/*        char someChar = ',';
        int count = 0;

        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == someChar) {
                if(count == 11){
                    String remover = test.replace(",", "\n");
                    count = 0;
                }
                count++;
            }
            System.out.println(count);
        }
*/      String test0 = test.replaceAll(",00","");
        String test1 = test0.replaceAll(";", ",");
        String test2 = test1.replaceAll(" ", "");
        String test3 = test2.replaceAll("Artikelbezeichnung", "artikelbezeichnung");
        String test4 = test3.replaceAll("Hersteller", "hersteller");
        String test5 = test4.replaceAll("Artikelnummer", "artikelnummer");
        String test6 = test5.replaceAll("Kategoriepfad", "kategoriepfad");
        String test7 = test6.replaceAll("Beschreibungsfeld", "beschreibungsfeld");
        String test8 = test7.replaceAll("Bild-Link", "bildlink");
        String test9 = test8.replaceAll("Deeplink", "deeplink");
        String test00 = test9.replaceAll("Verfuegbarkeit", "verfuegbarkeit");
        String test11 = test00.replaceAll("Bruttopreis", "bruttopreis");
        String test22 = test11.replaceAll("Stattpreis", "stattpreis");
        String test33= test22.replaceAll("EAN", "ean");
        String test44 = test33.replaceAll("Versandkosten,", "versandkosten\n");
        String test55 = test44.replaceAll("[\"]", "");
            System.out.println(test55);   //returns a string that textually represents the object

        //NACH JEDEM 11tn Beistrich gehört noch ein Zeilenumbruch, dan dürfte es funktioniern!!!!!!!!!!
        FileWriter fw = new FileWriter("src/main/java/agraraktionen/download/fileFinished.txt");
        fw.write(test55);
        fw.close();
        }


}


        class DownloadItem { //Artikelbezeichnung;Hersteller;Artikelnummer;Kategoriepfad;Beschreibungsfeld;Bildlink;Deeplink;Verfuegbarkeit;Bruttopreis;Stattpreis;EAN;Versandkosten;
            private String artikelbezeichnung;
            private String hersteller;
            private String artikelnummer;
            private String kategoriepfad;
            private String beschreibungsfeld;
            private String bildlink;
            private String deeplink;
            private String verfuegbarkeit;
            private int bruttopreis;
            private int stattpreis;
            private int ean;
            private int versandkosten;

            public String getArtikelbezeichnung() {
                return artikelbezeichnung;
            }

            public void setArtikelbezeichnung(String artikelbezeichnung) {
                this.artikelbezeichnung = artikelbezeichnung;
            }

            public String getHersteller() {
                return hersteller;
            }

            public void setHersteller(String hersteller) {
                this.hersteller = hersteller;
            }

            public String getArtikelnummer() {
                return artikelnummer;
            }

            public void setArtikelnummer(String artikelnummer) {
                this.artikelnummer = artikelnummer;
            }

            public String getKategoriepfad() {
                return kategoriepfad;
            }

            public void setKategoriepfad(String kategoriepfad) {
                this.kategoriepfad = kategoriepfad;
            }

            public String getBeschreibungsfeld() {
                return beschreibungsfeld;
            }

            public void setBeschreibungsfeld(String beschreibungsfeld) {
                this.beschreibungsfeld = beschreibungsfeld;
            }

            public String getBildlink() {
                return bildlink;
            }

            public void setBildlink(String bildlink) {
                this.bildlink = bildlink;
            }

            public String getDeeplink() {
                return deeplink;
            }

            public void setDeeplink(String deeplink) {
                this.deeplink = deeplink;
            }

            public String getVerfuegbarkeit() {
                return verfuegbarkeit;
            }

            public void setVerfuegbarkeit(String verfuegbarkeit) {
                this.verfuegbarkeit = verfuegbarkeit;
            }

            public int getBruttopreis() {
                return bruttopreis;
            }

            public void setBruttopreis(int bruttopreis) {
                this.bruttopreis = bruttopreis;
            }

            public int getStattpreis() {
                return stattpreis;
            }

            public void setStattpreis(int stattpreis) {
                this.stattpreis = stattpreis;
            }

            public int getEan() {
                return ean;
            }

            public void setEan(int ean) {
                this.ean = ean;
            }

            public int getVersandkosten() {
                return versandkosten;
            }

            public void setVersandkosten(int versandkosten) {
                this.versandkosten = versandkosten;
            }

            @Override
            public String toString() {
                return "OnlineCourse{" +
                        "artikelbezeichnung='" + artikelbezeichnung + '\'' +
                        ", hersteller='" + hersteller + '\'' +
                        ", artikelnummer='" + artikelnummer + '\'' +
                        ", kategoriepfad='" + kategoriepfad + '\'' +
                        ", beschreibungsfeld='" + beschreibungsfeld + '\'' +
                        ", bildlink='" + bildlink + '\'' +
                        ", deeplink='" + deeplink + '\'' +
                        ", verfuegbarkeit=" + verfuegbarkeit +
                        ", bruttopreis=" + bruttopreis +
                        ", stattpreis=" + stattpreis +
                        ", ean=" + ean +
                        ", versandkosten=" + versandkosten +
                        '}';
            }
        }



 /*
        String st = "https://www.faie.at/backend/export/index/agraraktionen.csv?feedID=68&hash=1bfdc5718d84ebfd191e9ee6617a7764";
        URL stockURL = new URL(st);
        BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream()));
        String s = null;
        while ((s=in.readLine())!=null) {
            System.out.println(s);
           String[] split = s.split(";");
            System.out.println("\nLength : " + split.length);
            System.out.println("split[0] : " + split[0]);
            System.out.println("split[1] : " + split[1]);
            System.out.println("split[2] : " + split[2]);
            System.out.println("split[3] : " + split[3]);
*/


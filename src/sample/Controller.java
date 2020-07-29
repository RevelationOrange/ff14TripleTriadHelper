package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Controller {
    @FXML private Label pc0Top, pc0Left, pc0Bottom, pc0Right, pc0Name, pc0Family;
    @FXML private Label pc1Top, pc1Left, pc1Bottom, pc1Right, pc1Name, pc1Family;
    @FXML private Label pc2Top, pc2Left, pc2Bottom, pc2Right, pc2Name, pc2Family;
    @FXML private Label pc3Top, pc3Left, pc3Bottom, pc3Right, pc3Name, pc3Family;
    @FXML private Label pc4Top, pc4Left, pc4Bottom, pc4Right, pc4Name, pc4Family;
    @FXML private TextField pc0Entry, pc1Entry, pc2Entry, pc3Entry, pc4Entry;
    @FXML private GridPane playerCard0, playerCard1, playerCard2, playerCard3, playerCard4;
    @FXML private Label oc0Top, oc0Left, oc0Bottom, oc0Right, oc0Name, oc0Family, oc0FixVar;
    @FXML private Label oc1Top, oc1Left, oc1Bottom, oc1Right, oc1Name, oc1Family, oc1FixVar;
    @FXML private Label oc2Top, oc2Left, oc2Bottom, oc2Right, oc2Name, oc2Family, oc2FixVar;
    @FXML private Label oc3Top, oc3Left, oc3Bottom, oc3Right, oc3Name, oc3Family, oc3FixVar;
    @FXML private Label oc4Top, oc4Left, oc4Bottom, oc4Right, oc4Name, oc4Family, oc4FixVar;
    @FXML private Label oc5Top, oc5Left, oc5Bottom, oc5Right, oc5Name, oc5Family, oc5FixVar;
    @FXML private Label oc6Top, oc6Left, oc6Bottom, oc6Right, oc6Name, oc6Family, oc6FixVar;
    @FXML private Label oc7Top, oc7Left, oc7Bottom, oc7Right, oc7Name, oc7Family, oc7FixVar;
    @FXML private Label oc8Top, oc8Left, oc8Bottom, oc8Right, oc8Name, oc8Family, oc8FixVar;
    @FXML private TextField oppNameEntry, ruleEntry0, ruleEntry1;
    @FXML private GridPane oppCard0, oppCard1, oppCard2, oppCard3, oppCard4, oppCard5, oppCard6, oppCard7, oppCard8;
    private Label[] pc0, pc1, pc2, pc3, pc4;
    private Label[] oc0, oc1, oc2, oc3, oc4, oc5, oc6, oc7, oc8;
    private TextField[] pcEntryArray;
    private Label[][] pcArray;
    private Label[][] ocArray;
    private GridPane[] pcPanes;
    private GridPane[] ocPanes;
    private final String[] texts = {"blue", "red", "yellow", "tan", "orange", "black"};
    private HashMap<String, JSONObject> CardDict = new HashMap<String, JSONObject>();
    private HashMap<String, JSONObject> NPCDict = new HashMap<String, JSONObject>();

    protected void Setup() {
        pc0 = new Label[]{pc0Top, pc0Right, pc0Bottom, pc0Left, pc0Name, pc0Family};
        pc1 = new Label[]{pc1Top, pc1Right, pc1Bottom, pc1Left, pc1Name, pc1Family};
        pc2 = new Label[]{pc2Top, pc2Right, pc2Bottom, pc2Left, pc2Name, pc2Family};
        pc3 = new Label[]{pc3Top, pc3Right, pc3Bottom, pc3Left, pc3Name, pc3Family};
        pc4 = new Label[]{pc4Top, pc4Right, pc4Bottom, pc4Left, pc4Name, pc4Family};
        pcArray = new Label[][]{pc0, pc1, pc2, pc3, pc4};
        pcEntryArray = new TextField[]{pc0Entry, pc1Entry, pc2Entry, pc3Entry, pc4Entry};
        pcPanes = new GridPane[]{playerCard0, playerCard1, playerCard2, playerCard3, playerCard4};

        oc0 = new Label[]{oc0Top, oc0Left, oc0Bottom, oc0Right, oc0Name, oc0Family, oc0FixVar};
        oc1 = new Label[]{oc1Top, oc1Left, oc1Bottom, oc1Right, oc1Name, oc1Family, oc1FixVar};
        oc2 = new Label[]{oc2Top, oc2Left, oc2Bottom, oc2Right, oc2Name, oc2Family, oc2FixVar};
        oc3 = new Label[]{oc3Top, oc3Left, oc3Bottom, oc3Right, oc3Name, oc3Family, oc3FixVar};
        oc4 = new Label[]{oc4Top, oc4Left, oc4Bottom, oc4Right, oc4Name, oc4Family, oc4FixVar};
        oc5 = new Label[]{oc5Top, oc5Left, oc5Bottom, oc5Right, oc5Name, oc5Family, oc5FixVar};
        oc6 = new Label[]{oc6Top, oc6Left, oc6Bottom, oc6Right, oc6Name, oc6Family, oc6FixVar};
        oc7 = new Label[]{oc7Top, oc7Left, oc7Bottom, oc7Right, oc7Name, oc7Family, oc7FixVar};
        oc8 = new Label[]{oc8Top, oc8Left, oc8Bottom, oc8Right, oc8Name, oc8Family, oc8FixVar};
        ocArray = new Label[][]{oc0, oc1, oc2, oc3, oc4, oc5, oc6, oc7, oc8};
        ocPanes = new GridPane[]{oppCard0, oppCard1, oppCard2, oppCard3, oppCard4, oppCard5, oppCard6, oppCard7, oppCard8};

        JSONObject cardJSON, npcJSON;
        JSONParser jp = new JSONParser();
        try {
            cardJSON = (JSONObject) jp.parse(new FileReader("TTdata.json"));
            npcJSON = (JSONObject) jp.parse(new FileReader("TTNPCdata.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return;
        }

        JSONArray cardList = (JSONArray) cardJSON.get("results");
        JSONArray npcList = (JSONArray) npcJSON.get("results");
        Iterator<JSONObject> iter;
        JSONObject cjson;
        JSONObject stats;
        String name, family;

        iter = cardList.iterator();
        while (iter.hasNext()) {
            cjson = iter.next();
            name = (String) cjson.get("name");
            stats = (JSONObject) ((JSONObject) cjson.get("stats")).get("numeric");
            stats.put("name", name);
            family = (String) ((JSONObject) cjson.get("type")).get("name");
            if (family.equals("Normal")) { family = ""; }
            stats.put("family", family);
            CardDict.put(name.toLowerCase(), stats);
        }
        name = "blank";
        stats = new JSONObject();
        stats.put("top", "");
        stats.put("left", "");
        stats.put("bottom", "");
        stats.put("right", "");
        stats.put("name", "");
        stats.put("family", "");
        CardDict.put(name, stats);

        int a, b, c;
        iter = npcList.iterator();
        while (iter.hasNext()) {
            cjson = iter.next();
            name = (String) cjson.get("name");
            stats = new JSONObject();
            stats.put("fixed_cards", cjson.get("fixed_cards"));
            stats.put("variable_cards", cjson.get("variable_cards"));
            stats.put("rules", cjson.get("rules"));
            stats.put("name", name);
            NPCDict.put(name.toLowerCase(), stats);
        }
    }

    @FXML private void setPc0FromEntry(KeyEvent ke) { if (ke.getCharacter().equals("\r")) { setPcX(0, pc0Entry.getText()); } }
    @FXML private void setPc1FromEntry(KeyEvent ke) { if (ke.getCharacter().equals("\r")) { setPcX(1, pc1Entry.getText()); } }
    @FXML private void setPc2FromEntry(KeyEvent ke) { if (ke.getCharacter().equals("\r")) { setPcX(2, pc2Entry.getText()); } }
    @FXML private void setPc3FromEntry(KeyEvent ke) { if (ke.getCharacter().equals("\r")) { setPcX(3, pc3Entry.getText()); } }
    @FXML private void setPc4FromEntry(KeyEvent ke) { if (ke.getCharacter().equals("\r")) { setPcX(4, pc4Entry.getText()); } }

    @FXML private void setAllPCsFromEntry() {
        for (int i = 0; i < pcEntryArray.length; i++) { setPcX(i, pcEntryArray[i].getText()); }
    }

    @FXML private void setOppFromEntry(KeyEvent ke) { if (ke.getCharacter().equals("\r")) { setOpp(oppNameEntry.getText()); } }

    @FXML private void setOppAndRules() {
        setOpp(oppNameEntry.getText());
        // setRules() once it exists
    }

    private void setPcX(int n, String cardName) {
        if (!CardDict.containsKey(cardName.toLowerCase())) {
            cardName = "blank";
            pcPanes[n].setStyle("");
        }
        else { pcPanes[n].setStyle("-fx-background-color: tan"); }
        JSONObject card = CardDict.get(cardName.toLowerCase());
        pcArray[n][0].setText(String.valueOf(card.get("top")));
        pcArray[n][1].setText(String.valueOf(card.get("right")));
        pcArray[n][2].setText(String.valueOf(card.get("bottom")));
        pcArray[n][3].setText(String.valueOf(card.get("left")));
        pcArray[n][4].setText(String.valueOf(card.get("name")));
        pcArray[n][5].setText(String.valueOf(card.get("family")));
    }

    private void setOcX(int n, String cardName, boolean isFixed) {
        String fixvar;
        if (!CardDict.containsKey(cardName.toLowerCase())) {
            cardName = "blank";
            ocPanes[n].setStyle("");
            fixvar = "";
        }
        else {
            ocPanes[n].setStyle("-fx-background-color: CF787F");
            if (isFixed) { fixvar = "Fixed"; }
            else { fixvar = "(variable)"; }
        }
        JSONObject card = CardDict.get(cardName.toLowerCase());
        ocArray[n][0].setText(String.valueOf(card.get("top")));
        ocArray[n][1].setText(String.valueOf(card.get("right")));
        ocArray[n][2].setText(String.valueOf(card.get("bottom")));
        ocArray[n][3].setText(String.valueOf(card.get("left")));
        ocArray[n][4].setText(String.valueOf(card.get("name")));
        ocArray[n][5].setText(String.valueOf(card.get("family")));
        ocArray[n][6].setText(fixvar);
    }

    private void setOpp(String oppName) {
        JSONObject x = NPCDict.get(oppName.toLowerCase());
        if (x == null) {
            for (int i = 0; i < ocArray.length; i++) { setOcX(i, "", false); }
        }
        else {
            int oci = 0;
            JSONArray fixeds = (JSONArray) NPCDict.get(oppName.toLowerCase()).get("fixed_cards");
            JSONArray vars = (JSONArray) NPCDict.get(oppName.toLowerCase()).get("variable_cards");
            JSONObject c;

            for (Object fixed : fixeds) {
                c = (JSONObject) fixed;
                setOcX(oci, (String) c.get("name"), true);
                oci++;
            }
            for (Object var : vars) {
                c = (JSONObject) var;
                setOcX(oci, (String) c.get("name"), false);
                oci++;
            }
            while (oci < ocArray.length) { setOcX(oci, "", false); oci++; }
        }
    }

}

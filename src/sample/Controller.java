package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Controller {
    @FXML private Label pc0Top, pc0Left, pc0Bottom, pc0Right, pc0Name;
    @FXML private Label pc1Top, pc1Left, pc1Bottom, pc1Right, pc1Name;
    @FXML private Label pc2Top, pc2Left, pc2Bottom, pc2Right, pc2Name;
    @FXML private Label pc3Top, pc3Left, pc3Bottom, pc3Right, pc3Name;
    @FXML private Label pc4Top, pc4Left, pc4Bottom, pc4Right, pc4Name;
    private Label[] pc0;
    private Label[] pc1;
    private Label[] pc2;
    private Label[] pc3;
    private Label[] pc4;
    private Label[][] pcArray;
    private final String[] texts = {"a", "b", "testin'"};
    private final String[] onionKnightName = {"8", "2", "8", "10", "Onion Knight"};
    private HashMap<String, JSONObject> CardDict = new HashMap<String, JSONObject>();

    protected void Setup() {
        pc0 = new Label[]{pc0Top, pc0Right, pc0Bottom, pc0Left, pc0Name};
        pc1 = new Label[]{pc1Top, pc1Right, pc1Bottom, pc1Left, pc1Name};
        pc2 = new Label[]{pc2Top, pc2Right, pc2Bottom, pc2Left, pc2Name};
        pc3 = new Label[]{pc3Top, pc3Right, pc3Bottom, pc3Left, pc3Name};
        pc4 = new Label[]{pc4Top, pc4Right, pc4Bottom, pc4Left, pc4Name};
        pcArray = new Label[][]{pc0, pc1, pc2, pc3, pc4};
//        ArrayList<String> griffinText = new ArrayList<String>(Arrays.asList("5", "1", "7", "8", "Griffin"));
//        ArrayList<String> onionKnightText = new ArrayList<String>(Arrays.asList("8", "2", "8", "10", "Onion Knight"));
//        CardDict.put(griffinText.get(griffinText.size()-1), griffinText);
//        CardDict.put(onionKnightText.get(onionKnightText.size()-1), onionKnightText);

        JSONObject cardJSON;
        JSONParser jp = new JSONParser();
        try {
            cardJSON = (JSONObject) jp.parse(new FileReader("TTdata.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return;
        }

        JSONArray cardList = (JSONArray) cardJSON.get("results");
        Iterator<JSONObject> it = cardList.iterator();
        JSONObject cjson;
        JSONObject stats;
        String name;

        while (it.hasNext()) {
            cjson = it.next();
            name = (String) cjson.get("name");
            stats = (JSONObject) ((JSONObject) cjson.get("stats")).get("numeric");
            stats.put("name", name);
            CardDict.put(name.toLowerCase(), stats);
        }
    }

    @FXML private void setPc0GriffinButton() {
        setPc0("sabotender");
    }

    @FXML private void setPc0OnionButton() {
        setPc0("Onion Knight");
    }

    @FXML private void setPCtestButton() {
        setPcX(4, "onion knight");
    }

    private void setPc0(String cardName) {
        JSONObject card = CardDict.get(cardName.toLowerCase());
        if (card == null) { System.out.println("uh ohhhh"); return; }
        pc0[0].setText(String.valueOf(card.get("top")));
        pc0[1].setText(String.valueOf(card.get("right")));
        pc0[2].setText(String.valueOf(card.get("bottom")));
        pc0[3].setText(String.valueOf(card.get("left")));
        pc0[4].setText(String.valueOf(card.get("name")));
    }

    private void setPcX(int n, String cardName) {
        JSONObject card = CardDict.get(cardName.toLowerCase());
        if (card == null) { System.out.println("uh ohhhh"); return; }
        pcArray[n][0].setText(String.valueOf(card.get("top")));
        pcArray[n][1].setText(String.valueOf(card.get("right")));
        pcArray[n][2].setText(String.valueOf(card.get("bottom")));
        pcArray[n][3].setText(String.valueOf(card.get("left")));
        pcArray[n][4].setText(String.valueOf(card.get("name")));
    }

}

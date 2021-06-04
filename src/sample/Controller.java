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
    @FXML private GridPane playerCard0, playerCard1, playerCard2, playerCard3, playerCard4;
    @FXML private TextField pc0Entry, pc1Entry, pc2Entry, pc3Entry, pc4Entry;
    @FXML private Label bc0Top, bc0Left, bc0Bottom, bc0Right, bc0Name, bc0Family;
    @FXML private Label bc1Top, bc1Left, bc1Bottom, bc1Right, bc1Name, bc1Family;
    @FXML private Label bc2Top, bc2Left, bc2Bottom, bc2Right, bc2Name, bc2Family;
    @FXML private Label bc3Top, bc3Left, bc3Bottom, bc3Right, bc3Name, bc3Family;
    @FXML private Label bc4Top, bc4Left, bc4Bottom, bc4Right, bc4Name, bc4Family;
    @FXML private Label bc5Top, bc5Left, bc5Bottom, bc5Right, bc5Name, bc5Family;
    @FXML private Label bc6Top, bc6Left, bc6Bottom, bc6Right, bc6Name, bc6Family;
    @FXML private Label bc7Top, bc7Left, bc7Bottom, bc7Right, bc7Name, bc7Family;
    @FXML private Label bc8Top, bc8Left, bc8Bottom, bc8Right, bc8Name, bc8Family;
    @FXML private GridPane boardCard0, boardCard1, boardCard2, boardCard3, boardCard4, boardCard5, boardCard6, boardCard7, boardCard8;
    @FXML private Label oc0Top, oc0Left, oc0Bottom, oc0Right, oc0Name, oc0Family, oc0FixVar;
    @FXML private Label oc1Top, oc1Left, oc1Bottom, oc1Right, oc1Name, oc1Family, oc1FixVar;
    @FXML private Label oc2Top, oc2Left, oc2Bottom, oc2Right, oc2Name, oc2Family, oc2FixVar;
    @FXML private Label oc3Top, oc3Left, oc3Bottom, oc3Right, oc3Name, oc3Family, oc3FixVar;
    @FXML private Label oc4Top, oc4Left, oc4Bottom, oc4Right, oc4Name, oc4Family, oc4FixVar;
    @FXML private Label oc5Top, oc5Left, oc5Bottom, oc5Right, oc5Name, oc5Family, oc5FixVar;
    @FXML private Label oc6Top, oc6Left, oc6Bottom, oc6Right, oc6Name, oc6Family, oc6FixVar;
    @FXML private Label oc7Top, oc7Left, oc7Bottom, oc7Right, oc7Name, oc7Family, oc7FixVar;
    @FXML private Label oc8Top, oc8Left, oc8Bottom, oc8Right, oc8Name, oc8Family, oc8FixVar;
    @FXML private GridPane oppCard0, oppCard1, oppCard2, oppCard3, oppCard4, oppCard5, oppCard6, oppCard7, oppCard8;
    @FXML private TextField oppNameEntry, ruleEntry0, ruleEntry1;
    private final String[] texts = {"blue", "red", "yellow", "tan", "orange", "black"};
    private final int nPCs = 5, nBCs = 9, nOCs = 9;
    private BoardState bs;

    protected void Setup() {
        Label[] pc0 = new Label[]{pc0Top, pc0Right, pc0Bottom, pc0Left, pc0Name, pc0Family};
        Label[] pc1 = new Label[]{pc1Top, pc1Right, pc1Bottom, pc1Left, pc1Name, pc1Family};
        Label[] pc2 = new Label[]{pc2Top, pc2Right, pc2Bottom, pc2Left, pc2Name, pc2Family};
        Label[] pc3 = new Label[]{pc3Top, pc3Right, pc3Bottom, pc3Left, pc3Name, pc3Family};
        Label[] pc4 = new Label[]{pc4Top, pc4Right, pc4Bottom, pc4Left, pc4Name, pc4Family};
        Label[][] pcArray = new Label[][]{pc0, pc1, pc2, pc3, pc4};
        TextField[] pcEntryArray = new TextField[]{pc0Entry, pc1Entry, pc2Entry, pc3Entry, pc4Entry};
        GridPane[] pcPanes = new GridPane[]{playerCard0, playerCard1, playerCard2, playerCard3, playerCard4};

        Label[] bc0 = new Label[]{bc0Top, bc0Right, bc0Bottom, bc0Left, bc0Name, bc0Family};
        Label[] bc1 = new Label[]{bc1Top, bc1Right, bc1Bottom, bc1Left, bc1Name, bc1Family};
        Label[] bc2 = new Label[]{bc2Top, bc2Right, bc2Bottom, bc2Left, bc2Name, bc2Family};
        Label[] bc3 = new Label[]{bc3Top, bc3Right, bc3Bottom, bc3Left, bc3Name, bc3Family};
        Label[] bc4 = new Label[]{bc4Top, bc4Right, bc4Bottom, bc4Left, bc4Name, bc4Family};
        Label[] bc5 = new Label[]{bc5Top, bc5Right, bc5Bottom, bc5Left, bc5Name, bc5Family};
        Label[] bc6 = new Label[]{bc6Top, bc6Right, bc6Bottom, bc6Left, bc6Name, bc6Family};
        Label[] bc7 = new Label[]{bc7Top, bc7Right, bc7Bottom, bc7Left, bc7Name, bc7Family};
        Label[] bc8 = new Label[]{bc8Top, bc8Right, bc8Bottom, bc8Left, bc8Name, bc8Family};
        Label[][] bcArray = new Label[][]{bc0, bc1, bc2, bc3, bc4, bc5, bc6, bc7, bc8};
        GridPane[] bcPanes = new GridPane[]{boardCard0, boardCard1, boardCard2, boardCard3, boardCard4, boardCard5, boardCard6, boardCard7, boardCard8};

        Label[] oc0 = new Label[]{oc0Top, oc0Left, oc0Bottom, oc0Right, oc0Name, oc0Family, oc0FixVar};
        Label[] oc1 = new Label[]{oc1Top, oc1Left, oc1Bottom, oc1Right, oc1Name, oc1Family, oc1FixVar};
        Label[] oc2 = new Label[]{oc2Top, oc2Left, oc2Bottom, oc2Right, oc2Name, oc2Family, oc2FixVar};
        Label[] oc3 = new Label[]{oc3Top, oc3Left, oc3Bottom, oc3Right, oc3Name, oc3Family, oc3FixVar};
        Label[] oc4 = new Label[]{oc4Top, oc4Left, oc4Bottom, oc4Right, oc4Name, oc4Family, oc4FixVar};
        Label[] oc5 = new Label[]{oc5Top, oc5Left, oc5Bottom, oc5Right, oc5Name, oc5Family, oc5FixVar};
        Label[] oc6 = new Label[]{oc6Top, oc6Left, oc6Bottom, oc6Right, oc6Name, oc6Family, oc6FixVar};
        Label[] oc7 = new Label[]{oc7Top, oc7Left, oc7Bottom, oc7Right, oc7Name, oc7Family, oc7FixVar};
        Label[] oc8 = new Label[]{oc8Top, oc8Left, oc8Bottom, oc8Right, oc8Name, oc8Family, oc8FixVar};
        Label[][] ocArray = new Label[][]{oc0, oc1, oc2, oc3, oc4, oc5, oc6, oc7, oc8};
        GridPane[] ocPanes = new GridPane[]{oppCard0, oppCard1, oppCard2, oppCard3, oppCard4, oppCard5, oppCard6, oppCard7, oppCard8};

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

        HashMap<String, JSONObject> CardDict = new HashMap<>();
        iter = cardList.iterator();
        while (iter.hasNext()) {
            cjson = iter.next();
            name = (String) cjson.get("name");
            stats = (JSONObject) ((JSONObject) cjson.get("stats")).get("numeric");
            stats.put("name", name);
            family = (String) ((JSONObject) cjson.get("type")).get("name");
            if (family.equals("Normal")) {
                family = "";
            }
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

//        int a, b, c;
        HashMap<String, JSONObject> NPCDict = new HashMap<>();
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

        bs = new BoardState(pcArray, pcPanes, bcArray, bcPanes, ocArray, ocPanes, pcEntryArray, oppNameEntry, CardDict, NPCDict);
    }

    @FXML
    private void setPc0FromEntry(KeyEvent ke) {
        if (ke.getCharacter().equals("\r")) {
            bs.setPcX(0);
        }
    }

    @FXML
    private void setPc1FromEntry(KeyEvent ke) {
        if (ke.getCharacter().equals("\r")) {
            bs.setPcX(1);
        }
    }

    @FXML
    private void setPc2FromEntry(KeyEvent ke) {
        if (ke.getCharacter().equals("\r")) {
            bs.setPcX(2);
        }
    }

    @FXML
    private void setPc3FromEntry(KeyEvent ke) {
        if (ke.getCharacter().equals("\r")) {
            bs.setPcX(3);
        }
    }

    @FXML
    private void setPc4FromEntry(KeyEvent ke) {
        if (ke.getCharacter().equals("\r")) {
            bs.setPcX(4);
        }
    }

    @FXML
    private void setAllPCsFromEntry() {
        bs.setAllPCsFromEntry();
    }

    @FXML
    private void setOppFromEntry(KeyEvent ke) {
        if (ke.getCharacter().equals("\r")) {
            bs.setOpp();
        }
    }

    @FXML
    private void setOppAndRules() {
        bs.setOpp();
        // setRules() once it exists
    }

    @FXML
    void highlightBoarders() {
        bs.boardCardHighlighter(true);
    }

    @FXML
    void unHighlightBoarders() {
        bs.boardCardHighlighter(false);
    }

    @FXML
    void selectPC0() {
        bs.select("pc0");
    }

    @FXML
    void selectPC1() {
        bs.select("pc1");
    }

    @FXML
    void selectPC2() {
        bs.select("pc2");
    }

    @FXML
    void selectPC3() {
        bs.select("pc3");
    }

    @FXML
    void selectPC4() {
        bs.select("pc4");
    }

    @FXML
    void selectBC0() {
        bs.select("bc0");
    }

    @FXML
    void selectBC1() {
        bs.select("bc1");
    }

    @FXML
    void selectBC2() {
        bs.select("bc2");
    }

    @FXML
    void selectBC3() {
        bs.select("bc3");
    }

    @FXML
    void selectBC4() {
        bs.select("bc4");
    }

    @FXML
    void selectBC5() {
        bs.select("bc5");
    }

    @FXML
    void selectBC6() {
        bs.select("bc6");
    }

    @FXML
    void selectBC7() {
        bs.select("bc7");
    }

    @FXML
    void selectBC8() {
        bs.select("bc8");
    }

    @FXML
    void selectOC0() {
        bs.select("oc0");
    }

    @FXML
    void selectOC1() {
        bs.select("oc1");
    }

    @FXML
    void selectOC2() {
        bs.select("oc2");
    }

    @FXML
    void selectOC3() {
        bs.select("oc3");
    }

    @FXML
    void selectOC4() {
        bs.select("oc4");
    }

    @FXML
    void selectOC5() {
        bs.select("oc5");
    }

    @FXML
    void selectOC6() {
        bs.select("oc6");
    }

    @FXML
    void selectOC7() {
        bs.select("oc7");
    }

    @FXML
    void selectOC8() {
        bs.select("oc8");
    }


    class BoardState {
        private final Label[][] pcArray;
        private final GridPane[] pcPanes;
        private final Label[][] bcArray;
        private final GridPane[] bcPanes;
        private final Label[][] ocArray;
        private final GridPane[] ocPanes;
        private final TextField[] pcEntryArray;
        private final TextField oppNameEntry;
        private final HashMap<String, JSONObject> CardDict;
        private final HashMap<String, JSONObject> NPCDict;
        private HashMap<String, Label[]> arrayLookup;
        private HashMap<String, GridPane> paneLookup;
        private HashMap<String, HashMap> cardLookup;
        private final String[] texts = {"blue", "red", "yellow", "tan", "orange", "black"};
        private Random r = new Random();
        private boolean selectionState = false;
        private String selection0 = "", selection1 = "";

        public BoardState(Label[][] pca, GridPane[] pcp, Label[][] bca, GridPane[] bcp, Label[][] oca, GridPane[] ocp,
                          TextField[] pcea, TextField oppne, HashMap<String, JSONObject> cd, HashMap<String, JSONObject> npcd) {
            this.pcArray = pca;
            this.pcPanes = pcp;
            this.bcArray = bca;
            this.bcPanes = bcp;
            this.ocArray = oca;
            this.ocPanes = ocp;
            this.pcEntryArray = pcea;
            this.oppNameEntry = oppne;
            this.CardDict = cd;
            this.NPCDict = npcd;

            HashMap<String, Object> tmp;
            this.arrayLookup = new HashMap<>();
            this.cardLookup = new HashMap<>();

            for (int i = 0; i < nPCs; i++) {
                // player card loop
                tmp = new HashMap<>();
                tmp.put("array", this.pcArray[i]);
                tmp.put("pane", this.pcPanes[i]);
                tmp.put("type", "player");
                cardLookup.put("pc"+ i, tmp);
            }

            for (int i = 0; i < nBCs; i++) {
                // board card loop
                tmp = new HashMap<>();
                tmp.put("array", this.bcArray[i]);
                tmp.put("pane", this.bcPanes[i]);
                tmp.put("type", "board");
                cardLookup.put("bc"+ i, tmp);
            }

            for (int i = 0; i < nOCs; i++) {
                // opponent card loop
                tmp = new HashMap<>();
                tmp.put("array", this.ocArray[i]);
                tmp.put("pane", this.ocPanes[i]);
                tmp.put("type", "opponent");
                cardLookup.put("oc"+ i, tmp);
            }

            this.arrayLookup.put("pc0", this.pcArray[0]);
            this.arrayLookup.put("pc1", this.pcArray[1]);
            this.arrayLookup.put("pc2", this.pcArray[2]);
            this.arrayLookup.put("pc3", this.pcArray[3]);
            this.arrayLookup.put("pc4", this.pcArray[4]);
            this.arrayLookup.put("bc0", this.bcArray[0]);
            this.arrayLookup.put("bc1", this.bcArray[1]);
            this.arrayLookup.put("bc2", this.bcArray[2]);
            this.arrayLookup.put("bc3", this.bcArray[3]);
            this.arrayLookup.put("bc4", this.bcArray[4]);
            this.arrayLookup.put("bc5", this.bcArray[5]);
            this.arrayLookup.put("bc6", this.bcArray[6]);
            this.arrayLookup.put("bc7", this.bcArray[7]);
            this.arrayLookup.put("bc8", this.bcArray[8]);
            this.arrayLookup.put("oc0", this.ocArray[0]);
            this.arrayLookup.put("oc1", this.ocArray[1]);
            this.arrayLookup.put("oc2", this.ocArray[2]);
            this.arrayLookup.put("oc3", this.ocArray[3]);
            this.arrayLookup.put("oc4", this.ocArray[4]);
            this.arrayLookup.put("oc5", this.ocArray[5]);
            this.arrayLookup.put("oc6", this.ocArray[6]);
            this.arrayLookup.put("oc7", this.ocArray[7]);
            this.arrayLookup.put("oc8", this.ocArray[8]);

            this.paneLookup = new HashMap<>();
            this.paneLookup.put("pc0", this.pcPanes[0]);
            this.paneLookup.put("pc1", this.pcPanes[1]);
            this.paneLookup.put("pc2", this.pcPanes[2]);
            this.paneLookup.put("pc3", this.pcPanes[3]);
            this.paneLookup.put("pc4", this.pcPanes[4]);
            this.paneLookup.put("bc0", this.bcPanes[0]);
            this.paneLookup.put("bc1", this.bcPanes[1]);
            this.paneLookup.put("bc2", this.bcPanes[2]);
            this.paneLookup.put("bc3", this.bcPanes[3]);
            this.paneLookup.put("bc4", this.bcPanes[4]);
            this.paneLookup.put("bc5", this.bcPanes[5]);
            this.paneLookup.put("bc6", this.bcPanes[6]);
            this.paneLookup.put("bc7", this.bcPanes[7]);
            this.paneLookup.put("bc8", this.bcPanes[8]);
            this.paneLookup.put("oc0", this.ocPanes[0]);
            this.paneLookup.put("oc1", this.ocPanes[1]);
            this.paneLookup.put("oc2", this.ocPanes[2]);
            this.paneLookup.put("oc3", this.ocPanes[3]);
            this.paneLookup.put("oc4", this.ocPanes[4]);
            this.paneLookup.put("oc5", this.ocPanes[5]);
            this.paneLookup.put("oc6", this.ocPanes[6]);
            this.paneLookup.put("oc7", this.ocPanes[7]);
            this.paneLookup.put("oc8", this.ocPanes[8]);
        }

        protected void setPcX(int n) {
            String cardName = this.pcEntryArray[n].getText();
            if (!this.CardDict.containsKey(cardName.toLowerCase())) {
                cardName = "blank";
                this.pcPanes[n].setStyle("");
            } else {
                pcPanes[n].setStyle("-fx-background-color: tan");
            }
            JSONObject card = this.CardDict.get(cardName.toLowerCase());
            this.pcArray[n][0].setText(String.valueOf(card.get("top")));
            this.pcArray[n][1].setText(String.valueOf(card.get("right")));
            this.pcArray[n][2].setText(String.valueOf(card.get("bottom")));
            this.pcArray[n][3].setText(String.valueOf(card.get("left")));
            this.pcArray[n][4].setText(String.valueOf(card.get("name")));
            this.pcArray[n][5].setText(String.valueOf(card.get("family")));
        }

        protected void setAllPCsFromEntry() {
            for (int i = 0; i < this.pcEntryArray.length; i++) {
                this.setPcX(i);
            }
        }

        protected void setOcX(int n, String cardName, boolean isFixed) {
            String fixvar;
            if (!this.CardDict.containsKey(cardName.toLowerCase())) {
                cardName = "blank";
                this.ocPanes[n].setStyle("");
                fixvar = "";
            } else {
                this.ocPanes[n].setStyle("-fx-background-color: CF787F");
                if (isFixed) {
                    fixvar = "Fixed";
                } else {
                    fixvar = "(variable)";
                }
            }
            JSONObject card = this.CardDict.get(cardName.toLowerCase());
            this.ocArray[n][0].setText(String.valueOf(card.get("top")));
            this.ocArray[n][1].setText(String.valueOf(card.get("right")));
            this.ocArray[n][2].setText(String.valueOf(card.get("bottom")));
            this.ocArray[n][3].setText(String.valueOf(card.get("left")));
            this.ocArray[n][4].setText(String.valueOf(card.get("name")));
            this.ocArray[n][5].setText(String.valueOf(card.get("family")));
            this.ocArray[n][6].setText(fixvar);
        }

        protected void setOpp() {
            String oppName = this.oppNameEntry.getText();
            JSONObject x = this.NPCDict.get(oppName.toLowerCase());
            if (x == null) {
                for (int i = 0; i < this.ocArray.length; i++) {
                    setOcX(i, "", false);
                }
            } else {
                int oci = 0;
                JSONArray fixeds = (JSONArray) this.NPCDict.get(oppName.toLowerCase()).get("fixed_cards");
                JSONArray vars = (JSONArray) this.NPCDict.get(oppName.toLowerCase()).get("variable_cards");
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
                while (oci < this.ocArray.length) {
                    setOcX(oci, "", false);
                    oci++;
                }
            }
        }

        protected void boardCardHighlighter(Boolean on) {
            String s;
            if (on) {
//            Random r = new Random();
//            int x = r.nextInt(texts.length);
                s = "-fx-border-color: orange; -fx-border-width: 1.5";
            } else {
                s = "-fx-border-color: #f4f4f4; -fx-border-width: 1.5";
            }
            for (int i = 0; i < this.bcPanes.length; i++) {
//            x = r.nextInt(2);
//            if (x == 0) { s0 = "1"; }
//            else if (x == 1) { s0 = "1.5"; }
//            else { s0 = "1.7"; }
                if (this.bcArray[i][4].getText().isBlank()) {
                    this.bcPanes[i].setStyle(s);
                }
            }
        }

        protected void select(String selection) {
            final Object selType;
            if (this.selectionState) {
                //
                if (this.selection0.equals(selection)) {
                    this.unselect(selection);
                }
                else if (cardLookup.get(selection).get("type").equals("player")) {
                    System.out.println("p");
                    this.unselect(this.selection0);
                    this.updSelection(selection);
                }
                else if (cardLookup.get(selection).get("type").equals("board")) {
                    System.out.println("b");
                }
                else if (cardLookup.get(selection).get("type").equals("opponent")) {
                    System.out.println("o");
                    this.unselect(this.selection0);
                    this.updSelection(selection);
                }
                else { System.out.println("unknown card type found"); }
            }
            else {
                // nothing selected - highlight the card (if it's player or opponent), and highlight possible spots, maybe show outcomes
                selType = cardLookup.get(selection).get("type");
                if (!selType.equals("board")) {
                    this.updSelection(selection);
                }
            }
        }

        protected void updSelection(String selection) {
            this.selection0 = selection;
            this.paneLookup.get(selection).setStyle("-fx-border-color: red; -fx-border-width: 1.5");
            this.selectionState = true;
        }

        protected void unselect(String selection) {
            this.paneLookup.get(selection).setStyle("-fx-border-color: #f4f4f4; -fx-border-width: 1.5");
            this.selection0 = "";
            this.selectionState = false;
        }
    }

}

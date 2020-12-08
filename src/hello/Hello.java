package hello;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.KeyModifier;

public class Hello {
    public static final String DB_NAME = "Autotest";
    public static final String DB_STRUCTURE_PATH = "C:/data/Autotest/__DB__/structure/";
    public static final String DB_DATA_PATH = "C:/data/Autotest/__DB__/data/";
    public static final String DB_STORAGE_PATH = "C:/data/Autotest/__STORAGE__/";
    public static final String DB_STORAGE_DESCRIPTION = "STORAGE";

    public static final String ADD_DB_BUTTON_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0001_Add_DB_button.png";
    public static final String CREATE_DATABASE_ADVANCED_BUTTON_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0002_Create_Database_Advanced_button.png";
    public static final String FLOW_HISTORY_PATH_INPUT_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0003_Flow_History_Path_input.png";
    public static final String BINARY_DATA_PATH_INPUT_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0004_Binary_Data_Path_input.png";
    public static final String ADD_STORAGE_BUTTON_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0005_Add_Storage_button.png";
    public static final String STORAGE_PATH_INPUT_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0006_Storage_Path_input.png";
    public static final String STORAGE_DESCRIPTION_INPUT_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0007_Storage_Description_input.png";
    public static final String ADD_STORAGE_OK_BUTTON_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0008_Add_Storage_OK_button.png";
    public static final String CREATE_DATABASE_OK_BUTTON_IMAGE = "c:/Users/gennady/eclipse-workspace/001_images/0009_Create_Database_OK_button.png";

    public static void main(String[] args) {
        Screen s = new Screen();
        Hello.addDB(s);
    } // main

    public static void addDB(Screen s, String dbName, String folder) {
        try {
            s.paste(ADD_DB_BUTTON_IMAGE, dbName);
            s.click(CREATE_DATABASE_ADVANCED_BUTTON_IMAGE);
            Hello.selectAllPaste(s, FLOW_HISTORY_PATH_INPUT_IMAGE, folder + dbName + "/__DB__/structure/" + dbName);
            Hello.selectAllPaste(s, BINARY_DATA_PATH_INPUT_IMAGE, folder + dbName + "/__DB__/data/" + dbName);
            s.click(ADD_STORAGE_BUTTON_IMAGE);
            Hello.selectAllPaste(s, STORAGE_PATH_INPUT_IMAGE, folder + dbName + "/__STORAGE__/");
            Hello.selectAllPaste(s, STORAGE_DESCRIPTION_INPUT_IMAGE, DB_STORAGE_DESCRIPTION);
            s.click(ADD_STORAGE_OK_BUTTON_IMAGE);
            s.click(CREATE_DATABASE_OK_BUTTON_IMAGE);

        } catch (FindFailed e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } // addDB


    public static <PFRML> void selectAllPaste(Screen s, PFRML target, String message) throws FindFailed {
        s.click(target);
        s.type("a", KeyModifier.CTRL);
        s.paste(message);
    } // selectAllPaste


    public static void addDB(Screen s) {
        try {
            s.paste(ADD_DB_BUTTON_IMAGE, DB_NAME);
            s.click(CREATE_DATABASE_ADVANCED_BUTTON_IMAGE);
            Hello.selectAllPaste(s, FLOW_HISTORY_PATH_INPUT_IMAGE, DB_STRUCTURE_PATH + DB_NAME);
            Hello.selectAllPaste(s, BINARY_DATA_PATH_INPUT_IMAGE, DB_DATA_PATH + DB_NAME);
            s.click(ADD_STORAGE_BUTTON_IMAGE);
            Hello.selectAllPaste(s, STORAGE_PATH_INPUT_IMAGE, DB_STORAGE_PATH);
            Hello.selectAllPaste(s, STORAGE_DESCRIPTION_INPUT_IMAGE, DB_STORAGE_DESCRIPTION);
            s.click(ADD_STORAGE_OK_BUTTON_IMAGE);
            s.click(CREATE_DATABASE_OK_BUTTON_IMAGE);

        } catch (FindFailed e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } // addDB

} // class Hello

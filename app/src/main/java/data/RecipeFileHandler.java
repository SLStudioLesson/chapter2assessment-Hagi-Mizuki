package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes(){
        String filename = "resources/recipes.txt";
        File dataFile = new File(filename);
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
            if (dataFile.exists()) {
                // データの読み込み
                // // ArrayList<String>型のLineを1列取得するために作成
                String line;
                // // String型のArrayListの作成(list型)
                //recipes.txtの文字列が何列か不明のためwhile文にてループ処理をさせる
                while ((line = reader.readLine()) != null) {
                    // リスト形式で返す
                    // Arraylistにlineを追加したい
                    list.add( line );
                }
            }
        } catch (IOException e) {
            // IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
            System.out.println("Error reading file:" + e.getMessage());
        }
        return null;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName  レシピ名
     * @param ingredients 材料名
     */
    //
    public void addRecipe(String recipeName, String ingredients) {
        // try {

        // } catch (IOException e) {

        // }
    }
}

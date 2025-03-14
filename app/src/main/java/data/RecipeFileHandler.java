package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
    public ArrayList<String> readRecipes() {
        // // String型のArrayListの作成
        ArrayList<String> recipes = new ArrayList<>();
        // データの読み込み
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
            // // ArrayList<String>型のlineを1列取得するために作成
            String line;
            // recipes.txtの文字列が何列か不明のためwhile文にてループ処理をさせる
            while ((line = reader.readLine()) != null) {
                // リスト形式で返す Arraylistにlineを追加したい
                recipes.add(line);
            }
        } catch (IOException e) {
            // IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
            System.out.println("Error reading file:" + e.getMessage());
        }
        return recipes;
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // 新しいレシピを`recipes.txt`に追加
            String recipeToWriter = recipeName + "," + ingredients;
            // String aa =String.join(recipeToWriter);
            writer.write(recipeToWriter);
            writer.newLine();
        } catch (IOException e) {
            // <br> IOExceptionが発生したときは`Error reading file: 例外のメッセージ`とコンソールに表示します。
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     * 以下のメソッドは、既に指定されたファイル内に、処理が実装されていない形で用意されています。  
各メソッドについて「説明」をもとに、メソッドが行う処理を読み解いてください。  
読み解いた処理は、既に用意されているメソッド内部に、コメントアウトを仕様して記述してください。
`src/main/java/ui/RecipeUI.java` 

| メソッド名       | 戻り値の型 | 引数 | 送信される例外 | 説明                                                         |
| ---------------- | ---------- | ---- | -------------- | ------------------------------------------------------------ |
| `displayRecipes` | `void`     | なし | なし | `RecipeFileHandler`から読み込んだレシピデータを整形してコンソールに表示します。<br> 読み込んだレシピデータが空の場合は、 `No recipes available.` というメッセージを出力します。 |

- 表示形式は以下の出力例を再現すること

```
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 1

Recipes:
-----------------------------------
Recipe Name: Tomato Soup
Main Ingredients: Tomatoes, Onion, Garlic, Vegetable Stock
-----------------------------------
Recipe Name: Chicken Curry
Main Ingredients: Chicken, Curry Powder, Onion, Garlic, Ginger
-----------------------------------
Recipe Name: Beef Stew
Main Ingredients: Beef, Potatoes, Carrots, Onion, Beef Stock
-----------------------------------

以下省略
```
     */
    private void displayRecipes() {
        RecipeFileHandler recipeFileHandler = new RecipeFileHandler();
        recipeFileHandler.readRecipes();
            //データの1列：Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock
            System.out.println();
            System.out.println("Recipes: ");
            System.out.println("-----------------------------------------");
            //「,」で分割させたい
            // ArrayList<String> strs = list.split(",");  //リストを解決できません
            // //列の「0」を取得し表示させる→何列あるか不明
            // //列の「0」以降を表示させたい→何列あるか不明
            // for( str : strs ){
            //     System.out.println("Recipe Name:" + strs[0]);
            //     System.out.println("Main Ingredients:" + strs[1]  );
            }
        //RecipeFileHandler`から読み込んだレシピデータを整形してコンソールに表示
        //<br> 読み込んだレシピデータが空の場合は、 `No recipes available.` というメッセージを出力
        
        
            /**
             * 設問2: 新規登録機能
             * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
             *
             * @throws java.io.IOException 入出力が受け付けられない
             */
            private void addNewRecipe() throws IOException {
        
            }
        
            /**
             * 設問3: 検索機能
             * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
             *
             * @throws java.io.IOException 入出力が受け付けられない
             */
            private void searchRecipe() throws IOException {
        
            }
        
}

    
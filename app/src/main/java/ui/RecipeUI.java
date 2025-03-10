package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
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
        //RecipeFileHandler recipeFileHandler = new RecipeFileHandler();
        //recipeFileHandler.readRecipes();
        ArrayList<String> recipes = fileHandler.readRecipes(); 
        if(recipes.isEmpty()){
            //1.空行を入力
            System.out.println();
            //2.「`No recipes available.`」と出力
            System.out.println("No recipes available.");
        //4.料理名と材料名(レシピ)が存在する場合(リストの要素数が1以上の場合)
        }else if( recipes.size() > 0){
            //データの1列：Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock
            System.out.println();
            System.out.println("Recipes: ");
            //リストの要素文以下の処理を繰り返す
            for(String recipe : recipes){
                //「,」で分割させたい
                //分割した結果を変数に代入
                String[] recipeparts = recipe.split(",",2);
                String recipeName = recipeparts[0];
                String recipeMain = recipeparts[1];
                System.out.println("Recipe Name: " +recipeName);
                System.out.println("Main Ingredients: " + recipeMain);
            //RecipeFileHandler`から読み込んだレシピデータを整形してコンソールに表示
            }
            System.out.println("-----------------------------------------");
        }
        }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {

        // ユーザーからレシピ名と主な材料を入力
        BufferedReader addReade = reader;
        System.out.println("レシピ名と主な材料を入力してください。");
        String reade = addReade.readLine();
        // String[] recipeparts = recipe.split(",",2);
        // String recipeName = recipeparts[0];
        // String recipeMain = recipeparts[1];
        String[] recipe  = reade.split(",", 2);
        String  recipeName = recipe[0];
        String recipeMain = recipe[1];
        //`RecipeFileHandler`を使用して`recipes.txt`に新しいレシピを追加
        fileHandler.addRecipe(recipeName,recipeMain);

    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    // private void searchRecipe() throws IOException {

    // }

}

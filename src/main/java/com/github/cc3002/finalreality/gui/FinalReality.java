package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
  private static Controller controller;
  private static ArrayList<String> permittedClasses;
  private static  ArrayList<String> permittedWeapons;
  protected Stage currentStage;
  protected String lastAction1;
  protected String lastAction2;

  public static void main(String[] args) {
    permittedClasses=new ArrayList<String>();
    permittedClasses.add("Caballero");
    permittedClasses.add("Ingeniero");
    permittedClasses.add("Ladron");
    permittedClasses.add("Mago Negro");
    permittedClasses.add("Mago Blanco");

    permittedWeapons=new ArrayList<String>();
    permittedWeapons.add("Espada");
    permittedWeapons.add("Hacha");
    permittedWeapons.add("Cuchillo");
    permittedWeapons.add("Baston");
    permittedWeapons.add("Arco");
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final reality");
    currentStage=primaryStage;
    currentStage.setMinHeight(1000);
    currentStage.setMinWidth(1400);
    /*Third Scene for InTurnStage*/

    /*Forth Scene for selectingTargetStage*/

    /*Fifth Scene for endGameStage*/

    /*Sixth Scene for InventoryStage*/
    currentStage.setScene(scene1());

    currentStage.show();
  }

  private static HBox characterInput(Scene scene){
    HBox container = new HBox(15);

    Label label= new Label("Ingrese los datos de un nuevo Personaje");

    final TextField clase = new TextField();
    clase.setPromptText("Ingrese la clase");
    clase.setPrefColumnCount(10);
    clase.getText();

    TextField name= insertName();
    Label error= new Label("");

    Button button = new Button("Crear");

    button.setOnAction(e->{
      try{
        System.out.println("You entered nombre player: "+name.getText()+" "+"Clase "+clase.getText());
        String enteredClass= clase.getText();
        String enteredName= name.getText();
        if (permittedClasses.contains(enteredClass)){
          if (enteredClass.equals("Caballero")){
            controller.createKnight(enteredName,100,5,20);
          }
          else if (enteredClass.equals("Ingeniero")){
            controller.createEngineer(enteredName,120,5,10);
          }
          else if (enteredClass.equals("Ladron")){
            controller.createThief(enteredName,70,10,15);
          }
          else if(enteredClass.equals("Mago Negro")){
            controller.createBlackMage(enteredName,80,2,10,50,0);
          }
          else{
            controller.createWhiteMage(enteredName,80,2,10,60,0);
          }
          Label oldLabel = (Label) scene.lookup("#label1");
          oldLabel.setText(getCurrentInfo());
          name.clear();
          clase.clear();
          error.setText("");
        }
        else {
          error.setText("Ingrese un nombre y clase validos");
        }
      }catch (Exception ex){
        error.setText("Ingrese un nombre y clase validos");
      }
    });

    container.getChildren().addAll(label,name,clase,button,error);
    return container;
  }


  private static HBox weaponInput(Scene scene){
    HBox container = new HBox(15);

    Label label= new Label("Ingrese los datos de un Arma");

    final TextField tipo = new TextField();
    tipo.setPromptText("Ingrese el tipo");
    tipo.setPrefColumnCount(10);
    tipo.getText();

    TextField name= insertName();
    Label error= new Label("");

    TextField attack= new TextField();
    attack.setPromptText("Daño");
    attack.setPrefColumnCount(5);
    TextField weight= new TextField();
    weight.setPromptText("Peso");
    weight.setPrefColumnCount(5);
    Button button = new Button("Crear");

    button.setOnAction(e->{
      try{
        String enteredClass= tipo.getText();
        String enteredName= name.getText();
        int attackValue= Integer.parseInt(attack.getText());
        int weightValue= Integer.parseInt(weight.getText());

        if (permittedWeapons.contains(enteredClass)){
          System.out.println("New Weapon");
          if (enteredClass.equals("Espada")){
            controller.createSword(enteredName,attackValue,weightValue);
          }
          else if (enteredClass.equals("Hacha")){
            controller.createAxe(enteredName,attackValue,weightValue);
          }
          else if (enteredClass.equals("Cuchillo")){
            controller.createKnife(enteredName,attackValue,weightValue);
          }
          else if(enteredClass.equals("Baston")){
            controller.createStaff(enteredName,attackValue,weightValue,10);
          }
          else{
            controller.createBow(enteredName,attackValue,weightValue);
          }
          Label oldLabel = (Label) scene.lookup("#label1");
          oldLabel.setText(getCurrentInfo());

          name.clear();
          tipo.clear();
          attack.clear();
          weight.clear();
          error.setText("Arma añadida al inventario");
        }
        else {
          error.setText("Ingrese atributos validos");
        }



      }catch (Exception ex){
        error.setText("Ingrese atributos validos");
      }
    });

    container.getChildren().addAll(label,name,tipo,attack,weight,button,error);
    return container;
  }

  private static HBox equipBox(Scene scene){
    HBox container= new HBox(15);

    Label label= new Label("Ingrese un nombre y un arma para equipar");

    final TextField weapon = new TextField();
    weapon.setPromptText("Ingrese arma a equipar");
    weapon.setPrefColumnCount(14);
    weapon.getText();

    TextField name= insertName();
    Label error= new Label("");

    Button button = new Button("Equipar");

    button.setOnAction(e->{
      try{
        String characterName = name.getText();
        String weaponName= weapon.getText();
        if (!characterName.trim().isEmpty() && !weaponName.trim().isEmpty()){
          if (controller.getInventory().containsKey(weaponName) && controller.getParty().containsKey(characterName)){
            controller.equipWeaponToPlayer(controller.getInventory().get(weaponName),
                    controller.getParty().get(characterName));
            if (controller.getParty().get(characterName).getEquippedWeapon()==null){
              error.setText("No se pudo equipar");
            }
            else{
              Label oldLabel = (Label) scene.lookup("#label1");
              oldLabel.setText(getCurrentInfo());

              name.clear();
              weapon.clear();
              error.setText("Arma equipada correctamente");
            }
          }
          else{
            error.setText("No se pudo equipar");
          }
        }
        else{
          error.setText("No se pudo equipar");
        }

      }catch (Exception ex){
        error.setText("No se pudo equipar");
      }
    });

    container.getChildren().addAll(label,name,weapon,button,error);
    return container;
  }

  private static HBox enemyInput(){
    HBox container = new HBox(15);

    Label label= new Label("Ingrese maximo numero de enemigos");
    Button button = new Button("Ingresar");
    Label error= new Label("");
    final TextField num = new TextField();
    num.setPromptText("Ingrese numero de enemigos");
    num.setPrefColumnCount(14);
    num.getText();

    button.setOnAction(e->{
      try{
        int enteredNum=Integer.parseInt(num.getText());
        if(!num.getText().trim().isEmpty()) {
          System.out.println("You entered numero enemigos: " + num.getText());
          controller.setMaxEnemiesNumber(enteredNum);
          error.setText("Numero de enemigos: " + Integer.toString(controller.getMaxEnemiesNumber()));
        }
        else{
          error.setText("Ingrese un numero valido");
        }
      }catch (Exception exception) {
        error.setText("Ingrese un numero valido");
      }
    });
    container.getChildren().addAll(label,num,button,error);
    return container;
  }

  private HBox bottomRow(){
    HBox container= new HBox(15);
    Label currentPlayers= new Label(getCurrentInfo());
    currentPlayers.setId("label1");

    Label error= new Label();

    Button start= new Button("Start Batlle");


    start.setOnAction(e-> {
              try {
                if (controller.getLivingPlayers()!=0){
                for(String playerName : controller.getParty().keySet()){
                  assert controller.getParty().get(playerName).getEquippedWeapon()!=null;
                }
                for (int i=1; i<=controller.getMaxEnemiesNumber();i++){
                  controller.createEnemy("Maloso Nº"+i, 40,100,30,10);
                }
                controller.startBattle();
                controller.startGame();
                lastAction2="";
                lastAction1="Ibas por el Bosque y te encontraste unos mounstros, CUIDADO!";
                currentStage.setScene(scene2());
                currentStage.show();
                }
                else{
                  error.setText("Ingrese personajes para jugar");
                }
              } catch (Exception ex) {
                error.setText("Por favor equipe un arma a todos los jugadores");
              }
            });

    container.getChildren().addAll(currentPlayers,start,error);
    return container;
  }

  private VBox getCharacters(){
    VBox container = new VBox(15);
    Label Title= new Label("Personajes");
    Title.setFont(Font.font("Cambria", 30));
    container.getChildren().add(Title);
    for (String playerName : controller.getParty().keySet()){
      int vida= controller.getParty().get(playerName).getHealthpoints();
      if (vida!=0) {
        Label label = new Label("Nombre: " + playerName + "  HP: " + vida);
        container.getChildren().add(label);
      }
    }
    return container;


  }

  private VBox getEnemies(){
    VBox container = new VBox(15);
    Label Title= new Label("Malosos");
    Title.setFont(Font.font("Cambria", 30));
    container.getChildren().add(Title);
    for (String enemyName : controller.getEnemies().keySet()){
      int vida= controller.getEnemies().get(enemyName).getHealthpoints();
      if (vida!=0) {
        Label label = new Label("Nombre: " + enemyName + "  HP: " + vida);
        container.getChildren().add(label);
      }
    }
    return container;
  }

  private VBox getWeapons(){
    VBox container = new VBox(15);
    Label Title= new Label("Inventario");
    Title.setFont(Font.font("Cambria", 30));
    container.getChildren().add(Title);
    for (String enemyName : controller.getInventory().keySet()){
      int damage= controller.getInventory().get(enemyName).getDamage();
      int weight=controller.getInventory().get(enemyName).getWeight();
      Label label = new Label("Nombre: " + enemyName + "  Ataque: " + damage +" Peso: " + weight);
      container.getChildren().add(label);
    }
    return container;
  }

  private static TextField insertName(){
    final TextField name = new TextField();
    name.setPromptText("Ingrese el nombre");
    name.setPrefColumnCount(10);
    name.getText();
    return name;
  }

  private static String getCurrentInfo(){
    String msg="Cantidad de Personajes: "+Integer.toString(controller.getLivingPlayers())
            +"/5  Personajes Creados: ";
    if (controller.getLivingPlayers()==0){
      msg=msg+"No hay personajes  ";
    }else {
      for (String name : controller.getParty().keySet()) {
        msg = msg + name + "  ";
      }
    }

    msg=msg+" Inventario: ";

    if (controller.getInventory().size()==0){
      msg=msg+"No hay objetos";
    }else {
      for (String name : controller.getInventory().keySet()) {
        msg = msg + name + "  ";
      }
    }
    return  msg;
  }


  private HBox menu(){
    HBox container= new HBox(15);
    VBox left= new VBox(15);
    VBox right= new VBox(15);
    container.getChildren().addAll(left,right);

    Label oldestTurn= new Label(lastAction2);
    Label oldTurn= new Label(lastAction1);
    Label thisTurn= new Label();
    Label error= new Label();
    left.getChildren().addAll(oldestTurn,oldTurn,thisTurn,error);

    if (controller.isInTurn()){
      thisTurn.setText("¿Que haras "+controller.getActiveCharacter().getName()+"?, creo que necesitas ayuda");
    }

    Button attack=new Button("Atacar");
    attack.setOnAction(e-> {
      if(controller.isInTurn() && !controller.getActiveCharacter().isEnemy()) {
        currentStage.setScene(scene3());
        currentStage.show();
      }
      else{
        error.setText("Vas muy rapido, espera un poco vaquero");
      }
    });

    Button inventario=new Button("Inventario");
    inventario.setOnAction(e-> {
      currentStage.setScene(scene5());
      currentStage.show();
    });

    right.getChildren().addAll(attack,inventario);
    container.setAlignment(Pos.CENTER);
    return container;
  }
  private  Scene scene1(){
    /* First scene for ConfigStage*/
    controller=new Controller();
    controller.setGUI(this);
    Group root = new Group();
    Scene scene1 = new Scene(root, 1200, 1000);



    Label title = new Label("FINAL REALITY");
    title.setFont(Font.font("Cambria", 32));
    Label subtitle= new Label("by Gustavo Varas");

    BorderPane container2= new BorderPane();
    BackgroundImage myBI= new BackgroundImage(new Image("https://us.123rf.com/450wm/chuckchee/chuckchee1701/chuckchee170100021/68744941-pixel-arte-8-bit-fondo-verde-oscuro-del-bosque.jpg?ver=6"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(100,100,true,true,false,true));
    container2.setBackground(new Background(myBI));
    container2.setMinSize(1400,1000);


    VBox container =new VBox(10);
    container.setPadding(new Insets(0,100,15,100));

    container.setMinSize(800,250);
    container.setMaxSize(1200,300);

    BackgroundFill myBF = new BackgroundFill(Color.MINTCREAM, new CornerRadii(10),
            null);

    container.setBackground(new Background(myBF));

    container.setAlignment(Pos.CENTER);
    container.getChildren().add(title);
    container.getChildren().add(subtitle);
    container.getChildren().addAll(characterInput(scene1),weaponInput(scene1)
            ,equipBox(scene1),enemyInput(),bottomRow());
    container2.setCenter(container);
    root.getChildren().add(container2);
    return scene1;
  }

  private Scene scene2(){
    /*Second scene for waitingCharacterStage*/
    Group root2= new Group();
    Scene scene2= new Scene(root2,1400,1000);

    BorderPane container3= new BorderPane();
    BackgroundImage myBI= new BackgroundImage(new Image("https://us.123rf.com/450wm/chuckchee/chuckchee1701/chuckchee170100021/68744941-pixel-arte-8-bit-fondo-verde-oscuro-del-bosque.jpg?ver=6"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(100,100,true,true,false,true));
    container3.setBackground(new Background(myBI));
    container3.setMinSize(1400,1000);



    VBox container =new VBox(10);
    container.setPadding(new Insets(15,100,15,100));

    container.setMinSize(800,250);
    container.setMaxSize(1200,500);

    BackgroundFill myBF = new BackgroundFill(Color.MINTCREAM, new CornerRadii(10),
            null);

    container.setBackground(new Background(myBF));

    Button restart=new Button("Restart");
    restart.setOnAction(e-> {
      currentStage.setScene(scene1());
      currentStage.show();
    });

    HBox container2= new HBox(15);
    container2.setPadding(new Insets(15,100,15,100));
    container2.setId("Info");
    container2.getChildren().addAll(getCharacters(),getEnemies());
    container2.setAlignment(Pos.TOP_CENTER);
    Label error= new Label();

    container.setAlignment(Pos.CENTER);
    container.getChildren().addAll(container2);
    container.getChildren().add(menu());
    container.getChildren().add(restart);

    container3.setCenter(container);
    root2.getChildren().addAll(container3);

    return scene2;
  }

  private Scene scene3(){
    /*Second scene for waitingCharacterStage*/
    Group root2= new Group();
    Scene scene3= new Scene(root2,1400,1000);

    BorderPane container2= new BorderPane();
    BackgroundImage myBI= new BackgroundImage(new Image("https://us.123rf.com/450wm/chuckchee/chuckchee1701/chuckchee170100021/68744941-pixel-arte-8-bit-fondo-verde-oscuro-del-bosque.jpg?ver=6"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(100,100,true,true,false,true));
    container2.setBackground(new Background(myBI));
    container2.setMinSize(1400,1000);


    VBox container =new VBox(10);
    container.setPadding(new Insets(15,100,15,100));

    container.setMinSize(800,250);
    container.setMaxSize(1200,500);

    BackgroundFill myBF = new BackgroundFill(Color.MINTCREAM, new CornerRadii(10),
            null);

    container.setBackground(new Background(myBF));

    final TextField target = new TextField();
    target.setPromptText("Ingrese enemigo a atacar");
    target.setPrefColumnCount(14);
    Label error= new Label();

    Button attack=new Button("Atacar");
    attack.setOnAction(e-> {
        String targetName=target.getText();
        if (controller.getEnemies().containsKey(targetName) &&
                controller.getEnemies().get(targetName).getHealthpoints()!=0){
          controller.selectTarget();
          try {
            controller.attack(controller.getActiveCharacter(),controller.getEnemies().get(targetName),false);
          } catch (InterruptedException interruptedException) {
            error.setText("Ingrese el nombre de un enemigo valido");
            controller.playTurn();
          }
        }
        else{
          error.setText("Ingrese el nombre de un enemigo valido");
          controller.playTurn();
        }
    });


    container.setAlignment(Pos.CENTER);
    HBox container4 =new HBox(getEnemies());
    container4.setAlignment(Pos.CENTER);
    container.getChildren().add(container4);
    container.getChildren().add(error);
    HBox container3 =new HBox(target,attack);
    container3.setAlignment(Pos.BOTTOM_CENTER);
    container.getChildren().add(container3);
    container2.setCenter(container);
    root2.getChildren().addAll(container2);

    return scene3;
  }

  private Scene scene4(){
    /*Second scene for waitingCharacterStage*/
    Group root= new Group();
    Scene scene4= new Scene(root,1400,1000);

    BorderPane container2= new BorderPane();
    BackgroundImage myBI= new BackgroundImage(new Image("https://us.123rf.com/450wm/chuckchee/chuckchee1701/chuckchee170100021/68744941-pixel-arte-8-bit-fondo-verde-oscuro-del-bosque.jpg?ver=6"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(100,100,true,true,false,true));
    container2.setBackground(new Background(myBI));
    container2.setMinSize(1400,1000);


    VBox container =new VBox(10);
    container.setPadding(new Insets(15,100,15,100));

    container.setMinSize(800,250);
    container.setMaxSize(1200,500);

    BackgroundFill myBF = new BackgroundFill(Color.MINTCREAM, new CornerRadii(10),
            null);

    container.setBackground(new Background(myBF));

    Label msg= new Label();
    msg.setFont(Font.font("Cambria", 40));
    if (controller.checkWin().equals("Player Wins")){
      msg.setText("Felicidades derrotaste a todos los Malosos");
    }
    else{
      msg.setText("Te ganaron los Malosos, quizas debas equiparte mejor ");
    }


    Button restart=new Button("Restart");
    restart.setOnAction(e-> {
      currentStage.setScene(scene1());
      currentStage.show();
    });


    container.setAlignment(Pos.CENTER);
    container.getChildren().addAll(msg,restart);
    container2.setCenter(container);
    root.getChildren().addAll(container2);

    return scene4;
  }

  private Scene scene5(){
    /*Second scene for waitingCharacterStage*/
    Group root= new Group();
    Scene scene5= new Scene(root,1400,1000);

    BorderPane container2= new BorderPane();
    BackgroundImage myBI= new BackgroundImage(new Image("https://us.123rf.com/450wm/chuckchee/chuckchee1701/chuckchee170100021/68744941-pixel-arte-8-bit-fondo-verde-oscuro-del-bosque.jpg?ver=6"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(100,100,true,true,false,true));
    container2.setBackground(new Background(myBI));
    container2.setMinSize(1400,1000);


    VBox container =new VBox(10);
    container.setPadding(new Insets(15,100,15,100));

    container.setMinSize(800,250);
    container.setMaxSize(1200,500);

    BackgroundFill myBF = new BackgroundFill(Color.MINTCREAM, new CornerRadii(10),
            null);
    container.setBackground(new Background(myBF));


    final TextField target = new TextField();
    target.setPromptText("Ingrese arma a equipar");
    target.setPrefColumnCount(14);
    Label error= new Label();

    Button attack=new Button("Equipar");
    attack.setOnAction(e-> {
      String targetName=target.getText();
      if (controller.getInventory().containsKey(targetName)){
        controller.equipWeaponToPlayer(controller.getInventory().get(targetName),
                (IPlayerCharacter)controller.getActiveCharacter());
            if (((IPlayerCharacter)controller.getActiveCharacter()).getEquippedWeapon().getName().equals(targetName)) {
              lastAction2 = lastAction1;
              lastAction1 = controller.getActiveCharacter().getName()+" se equipo "+targetName+ " la necesitara";
              currentStage.setScene(scene2());
              currentStage.show();
            }
            else {
              error.setText("No se pudo equipar, revise compatibilidades");
            }
      }
      else{
        error.setText("Ingrese un nombre de arma que existe");
      }
    });

    Button volver=new Button("volver");
    volver.setOnAction(e-> {
          currentStage.setScene(scene2());
    });


    container.setAlignment(Pos.CENTER);
    HBox container4 =new HBox(getWeapons());
    container4.setAlignment(Pos.CENTER);
    container.getChildren().add(container4);
    container.getChildren().add(error);
    HBox container3 =new HBox(target,attack);
    container3.setAlignment(Pos.BOTTOM_CENTER);
    container.getChildren().addAll(container3,volver);
    container2.setCenter(container);
    root.getChildren().addAll(container2);

    return scene5;
  }


  /**
   * Set the last action message and checks for win condition
   */
  public void setLastAction(String msg) {
    String result = controller.checkWin();
    if (result.equals("Neither")) {
      lastAction2 = lastAction1;
      lastAction1 = msg;
      Platform.runLater(() -> {
        this.currentStage.setScene(scene2());
      });
    }
    else{
      controller.ended();
      Platform.runLater(() -> {
        this.currentStage.setScene(scene4());
      });
    }
  }

  /**
   * Sets the controller for the GUI
   */

  public void setController(Controller c){
    controller=c;
  }
}

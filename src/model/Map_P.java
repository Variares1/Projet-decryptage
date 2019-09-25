package model;

public class Map_P {
    public static String selectIDbyLoginPassword(String login, String password){
        return "SELECT id FROM tb_personne WHERE pseudo = '"+login+"' AND mdp = '"+password + "';";
    }
}

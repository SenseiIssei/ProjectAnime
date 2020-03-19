package projectanime.controller;

import projectanime.model.Anime;
import projectanime.model.Character;
import projectanime.util.InputCheck;

public class CharacterController {

    public void addCharactersToAnime(Anime anime) {
        System.out.println("Type the Name of the Character and after that the Voice you want to add:");
        String characterString = InputCheck.readConsole();
        if ("1".equals(characterString)) {

            while (true) {
                String nameString = InputCheck.readConsole();
                if (nameString.equals("1")) {
                    break;
                } else {
                    String voiceString = InputCheck.readConsole();
                    if (voiceString.equals("1")) {
                        break;
                    }
                    Character character = new Character();
                    character.setName(nameString);
                    character.setVoice(voiceString);
                    anime.addCharacter(character);
                }
            }
        }
    }
}

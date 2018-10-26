/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ken
 */
@Named(value = "guessNumber")
@ViewScoped
public class GuessNumberJSFBean implements Serializable {
    private int number;
    private String guessString;

    public GuessNumberJSFBean() {
        number = (int) (Math.random() * 100);
    }

    public String getGuessString() {
        return guessString;
    }

    public void setGuessString(String guessString) {
        this.guessString = guessString;
    }

    public String getResponse() {
        if (guessString == null) {
            return ""; // No user input yet
        }
        int guess = Integer.parseInt(guessString);
        if (guess < number) {
            return "Too low";
        } else if (guess == number) {
            return "You got it";
        } else {
            return "Too high";
        }
    }

}



package logic;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Score {
	FileDeo ob = new FileDeo();
	private IntegerProperty score = new SimpleIntegerProperty(0);
        public IntegerProperty soumik=score;
        int ssoumik=0;
	public IntegerProperty scoreProperty() {
		return score;
	}

	public void add(int i) {
            int cnt=0;
		score.setValue(score.getValue() + i);
               // System.out.println(score);
                ssoumik = score.getValue().intValue();
                 ob.get(ssoumik);
	}
        
        public int deo() {
            ob.filekamkaj();
             System.out.println(ob.highScore);
            return ob.highScore;
        }
        private String path;
        private String fname;
      
     
}

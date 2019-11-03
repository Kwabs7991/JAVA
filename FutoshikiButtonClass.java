/**
 *
 * @author mkt22
 */
public class ButtonClass extends javafx.scene.control.Button {

    Futoshiki ActualPuzzle;
    int x, y, size;

    public ButtonClass(String toString, Futoshiki ActualPuzzle, FutoshikiSquare tiles) {
        super(toString);
        this.x = tiles.getRow();
        this.y = tiles.getColumn();
        this.ActualPuzzle = ActualPuzzle;
        if (tiles.isEditable()) {
            
        
        setOnAction((event) -> {
            
                
            
            if (ActualPuzzle.gridSize > tiles.getValue()) {
                tiles.setValue(tiles.getValue() + 1);
                setText(String.valueOf(tiles.getValue()));
            } else {
                tiles.setValue(0);
                setText(" ");
            }
            ActualPuzzle.setSquare(x, y, Integer.valueOf(tiles.getValue()));

        });
        
        }else{
            setDisabled(true);
        }

    }

}

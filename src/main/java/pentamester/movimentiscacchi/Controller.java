/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.movimentiscacchi;

/**
 *
 * @author Labinfo1-20
 */
public class Controller implements IViewObserver{
   private Model model;

    public Controller(Model model) {
        this.model = model;
    }
    
    public void setView(IView view){
        view.setObserver(this);   
        model.setObserver((IModelObserver)view);
    }
    @Override
    public void setPiece(int piece) {
        model.setPiece(piece);
    }
   
   
}

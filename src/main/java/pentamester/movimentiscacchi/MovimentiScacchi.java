/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pentamester.movimentiscacchi;

/**
 *
 * @author Labinfo1-20
 */
public class MovimentiScacchi {

    public static void main(String[] args) {
        Model model=new Model();
        IView view=new View("Movimento pezzi scacchi");
        IViewObserver controller=new Controller(model);
        ((Controller)controller).setView(view);
    }
}

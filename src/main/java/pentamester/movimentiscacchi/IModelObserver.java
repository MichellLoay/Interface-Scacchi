/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.movimentiscacchi;

import java.util.List;

/**
 *
 * @author Labinfo1-20
 */
public interface IModelObserver {
    void initialize(String [] piecesName);
    void setCells(List<Coord> list, String pieceName,int row,int col);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.movimentiscacchi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author palma
 */
public class View extends JFrame implements IModelObserver, IView{
    private JButton[] pieces;
    private final JLabel[][] field;
    private final Color[] colors = {Color.white, Color.lightGray};
    private Map<String, Character> map;
    private JPanel north;
    private IViewObserver observer;
    
    public View(String title) {
        super(title);
        JPanel center = new JPanel(new GridLayout(8, 8));
        JPanel south = new JPanel(new GridLayout(1, 8));
        JPanel east = new JPanel(new GridLayout(8, 1));
        JLabel[] numbers = new JLabel[8];
        JLabel[] letters = new JLabel[8];
        add(center);
        field = new JLabel[8][8];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new JLabel();
                field[i][j].setOpaque(true);
                field[i][j].setBackground(colors[(i + j) % 2]);
                field[i][j].setHorizontalAlignment(JLabel.CENTER);
                field[i][j].setVerticalAlignment(JLabel.CENTER);
                field[i][j].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                center.add(field[i][j]);

            }

        }
        for (int i = 0; i < letters.length; i++) {
            letters[i] = new JLabel("" + Character.toString(97 + i));
            letters[i].setHorizontalAlignment(JLabel.CENTER);
            letters[i].setVerticalAlignment(JLabel.CENTER);
            letters[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            south.add(letters[i]);
            numbers[i] = new JLabel("" + (8-i));
            numbers[i].setHorizontalAlignment(JLabel.CENTER);
            numbers[i].setVerticalAlignment(JLabel.CENTER);
            numbers[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            east.add(numbers[i]);
        }
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
    }

    public void setObserver(IViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void initialize(String[] pieces) {
        map = new HashMap<>();
        map.put(pieces[pieces.length - 1], '\u265f');
        map.put(pieces[pieces.length - 2], '\u265e');
        map.put(pieces[pieces.length - 3], '\u265d');
        map.put(pieces[pieces.length - 4], '\u265c');
        map.put(pieces[pieces.length - 5], '\u265b');
        map.put(pieces[pieces.length - 6], '\u265a');
        this.pieces = new JButton[pieces.length];
        north = new JPanel();
        for (int i = 0; i < pieces.length; i++) {
            this.pieces[i] = new JButton("" + map.get(pieces[i]));
            this.pieces[i].setActionCommand("" + i);
            this.pieces[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            this.pieces[i].addActionListener((ActionEvent e) -> {
                observer.setPiece(Integer.parseInt(e.getActionCommand()));
            });
            north.add(this.pieces[i]);
        }
        north.add(new JPanel());
        add(north, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setCells(List<Coord> list, String pieceName, int row, int col) {
        reset();
        for(Coord coord: list){
            field[coord.getRow()][coord.getCol()].setForeground(new Color(100,100,100,100));
            field[coord.getRow()][coord.getCol()].setText(""+map.get(pieceName));
        }
        field[row][col].setForeground(Color.black);
        field[row][col].setText(""+map.get(pieceName));
    }

    private void reset() {
        for(JLabel [] row: field){
            for(JLabel cell: row){
                cell.setText("");                
            }
            
        }
    }

}


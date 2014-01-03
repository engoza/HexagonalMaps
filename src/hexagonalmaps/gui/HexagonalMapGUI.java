package hexagonalmaps.gui;

import hexagonalmaps.scenario.map.Board;
import hexagonalmaps.scenario.map.Direction;
import hexagonalmaps.scenario.map.TerrainType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class HexagonalMapGUI extends JFrame {
    static final int MAP_WIDTH = 10; // number of columns
    static final int MAP_HEIGHT = 10; // number of rows
    private HexagonalMap map;
    private MapInfo info;
    private JPanel mainPanel;


    public HexagonalMapGUI() {
        super("Hexagonal Board Demo");
        info = new MapInfo();
        // Create random map
        Board board = Board.createRandomMap(MAP_WIDTH, MAP_HEIGHT, TerrainType.FOREST);
        map = new HexagonalMap(board);
        map.addMouseMotionListener(new BoardMouseMotionListener());
        mainPanel = new JPanel();
        mainPanel.add(map);
        mainPanel.add(info);
        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HexagonalMapGUI frame = new HexagonalMapGUI();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private class BoardMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent me) {
            info.setMousePosition(me.getX(), me.getY());
            Point tileCoordinates = map.pixelToTile(me.getX(), me.getY());
            if (map.tileIsWithinBoard(tileCoordinates)) {
                info.setTileCoordinates(tileCoordinates);
            } else info.setTileCoordinates(null);
        }
    }
}

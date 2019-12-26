package ru.geekbrains.java_one.homework_g;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
	private static final int WIN_WIDTH = 350;
	private static final int WIN_HEIGHT = 270;
	private final GameWindow gameWindow;
	private JRadioButton jrbHumVsAi;
	private JRadioButton jrbHumVsHum;
	private JSlider jsFieldSize;
	private JSlider jsWinLegth;
	private static final String FIELD_SIZE_PREFIX = "Field size is: ";
	private static final String WIN_LENGTH_PREFIX = "Winning legth is: ";
	private static final int MIN_FIELD_SIZE = 3;
	private static final int MAX_FIELD_SIZE = 10;
	private static final int MIN_WIN_LENGTH = 3;

	Settings(GameWindow gameWindow){
		this.gameWindow = gameWindow;
		setSize(WIN_WIDTH, WIN_HEIGHT);
		Rectangle gameWindowBounds = gameWindow.getBounds();
		int posX = (int) gameWindowBounds.getCenterX() - WIN_WIDTH / 2;
		int posY = (int) gameWindowBounds.getCenterX() - WIN_HEIGHT / 2;
		setLocation(posX, posY);
		setResizable(false);
		setTitle("Creating a new game");
		setLayout(new GridLayout(10, 1));
		addGameModeControls();
		addFieldControls();
		JButton btnStartGame = new JButton("Start new game");
		btnStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onBtnStartGameClick();
			}
		});
		add(btnStartGame);
	}

	private void addGameModeControls(){
		add(new JLabel("Choose game mode"));
		jrbHumVsAi = new JRadioButton("Human vs. AI", true); // true - изначально его выбирает
		jrbHumVsHum = new JRadioButton("Human vs. Human");
		ButtonGroup grpMode = new ButtonGroup();
		grpMode.add(jrbHumVsAi);
		grpMode.add(jrbHumVsHum);

		add(jrbHumVsAi);
		add(jrbHumVsHum);
	}

	private void addFieldControls(){
		JLabel jlFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
		JLabel jlWinLegth = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
		jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
		jsWinLegth = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

		jsFieldSize.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int currentValue = jsFieldSize.getValue();
				jlFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
				jsWinLegth.setMaximum(currentValue);
			}
		});

		jsWinLegth.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				jlWinLegth.setText(WIN_LENGTH_PREFIX + jsWinLegth.getValue());
			}
		});

		add(new JLabel("Choose field size"));
		add(jlFieldSize);
		add(jsFieldSize);
		add(new JLabel("Choose winning legth"));
		add(jlWinLegth);
		add(jsWinLegth);
		}

		private void onBtnStartGameClick(){
			int gameMode;
			if(jrbHumVsHum.isSelected()){
				gameMode = Map.MODE_HVH;
			} else if (jrbHumVsAi.isSelected()){
				gameMode= Map.MODE_HVA;
			} else {
				throw new RuntimeException("Unknow game mode");
			}
			int fieldSize = jsFieldSize.getValue();
			int winLength = jsWinLegth.getValue();
			gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
			setVisible(false);
		}

}
